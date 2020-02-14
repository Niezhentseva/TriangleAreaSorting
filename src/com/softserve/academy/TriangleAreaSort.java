/*
Задача 3. Разработать консольную программу, выполняющую вывод треугольников в порядке убывания их площади.
После добавления каждого нового треугольника программа спрашивает,
хочет ли пользователь добавить ещё один. Если пользователь ответит “y” или “yes” (без учёта регистра),
программа попросит ввести данные для ещё одного треугольника, в противном случае – выводит результат в консоль.
 */
package com.softserve.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleAreaSort {

    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>(); // create a list
        Triangle triangle;
        String answerU = "y";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter attributes of triangle: <name>, <side1>, <side2>, <side3>: ");
            String input = scanner.nextLine();

            if (!(CheckAttr.checkForCommas(input))) { //checking the number of commas
                System.out.println("Incorrect input! ");
            } else {
                String[] parsedInput = CheckAttr.parseInput(input); // split string
                try {
                    triangle = new Triangle(parsedInput);
                    triangles.add(triangle); // add a triangle into the list
                    System.out.println("Do you want to add another triangle? (y/yes or n/no)");
                    answerU = scanner.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println("Check the input. Sizes must be numbers");
                } catch (IllegalArgumentException e) {
                    System.out.println("Check the input. These cannot be sides of a triangle");
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("You need to enter three sides of a triangle");
                }

            }
        }
        while (answerU.equalsIgnoreCase("y") || answerU.equalsIgnoreCase("yes"));
        Triangle.printTrianglesReversed(triangles);
        scanner.close();
    }

}
