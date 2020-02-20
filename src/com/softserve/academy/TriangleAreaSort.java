/*
Задача 3. Разработать консольную программу, выполняющую вывод треугольников в порядке убывания их площади.
После добавления каждого нового треугольника программа спрашивает,
хочет ли пользователь добавить ещё один. Если пользователь ответит “y” или “yes” (без учёта регистра),
программа попросит ввести данные для ещё одного треугольника, в противном случае – выводит результат в консоль.
 */
package com.softserve.academy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TriangleAreaSort {
    public static String startProgram = "Enter attributes of triangle: " +
        "<name>, <side1>, <side2>, <side3>: ";
    public static String continueProgram = "Do you want to add another triangle? (y/yes or n/no)";
    public static String informNoNumber = "Check the input. Sides must be numbers";
    public static String informNoTriangle = "Check the input. " +
            "These attributes cannot be sides of a triangle. " +
            "Rule: The sum of two arbitrary triangle sides " +
            "is always greater then the third side";
    public static String informNoThreeSides = "You need to enter three sides of a triangle";

    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>(); // create a list
        do {
            ConsoleIO.printToConsole(startProgram);
            String input = ConsoleIO.enterValue();
            if (!(CheckAttr.isForCommas(input))) { //checking the number of commas
                ConsoleIO.printToConsole(informNoThreeSides);
            } else {
                String[] arrInput = CheckAttr.parseInput(input); // split string
                try {
                    triangles.add(
                            Triangle.createTriangle(
                                    arrInput[0],
                                    Double.parseDouble(arrInput[1]),
                                    Double.parseDouble(arrInput[2]),
                                    Double.parseDouble(arrInput[3])));
                } catch (NumberFormatException e) {
                    ConsoleIO.printToConsole(informNoNumber);
                } catch (IllegalArgumentException e) {
                   ConsoleIO.printToConsole(informNoTriangle);
                }
            }
            ConsoleIO.printToConsole(continueProgram);
        } while (ConsoleIO.isContinue());
            triangles.sort(Comparator.comparing(Triangle::getArea).reversed());
            ConsoleIO.printListTriangles(triangles);
        }
    }
