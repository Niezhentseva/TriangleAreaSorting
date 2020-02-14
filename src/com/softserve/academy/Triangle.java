package com.softserve.academy;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

public class Triangle{
    private String name;
    private double area;
    private double side1;
    private double side2;
    private double side3;

    // convert 3 sides to double and check format of all attributes
    Triangle(String[] args) throws NumberFormatException {
        this.name = args[0];
        this.side1 = Double.parseDouble(args[1]);
        this.side2 = Double.parseDouble(args[2]);
        this.side3 = Double.parseDouble(args[3]);
        if (!checkTriangle(side1, side2, side3)) {
            throw new IllegalArgumentException("");
        }
    }

    // check the ability to create a triangle
    private static boolean checkTriangle(double side1, double side2, double side3) {
        return (side1 + side2 > side3
                && side1 + side3 > side2
                && side2 + side3 > side1);
    }

    double getArea() {
        area = calculateArea();
        return area;
    }

    private double calculateArea() {
        double halfPerim = getHalfPerim();
        double diff1 = halfPerim - side1;
        double diff2 = halfPerim - side2;
        double diff3 = halfPerim - side3;
        return Math.sqrt(halfPerim * diff1 * diff2 * diff3);
    }

    private double getHalfPerim() {
        return (side1 + side2 + side3) / 2;
    }

   @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return String.format("[Triangle %s]: " + df.format(area) + " cm", name);
    }


    public static void printTrianglesReversed(List<Triangle> triangles) {
        triangles.sort(Comparator.comparing(Triangle::getArea).reversed());
        System.out.println("============= Triangles list: =============");
        int i = 1;
        for (Triangle temp : triangles) {
            System.out.println(i++ + ". " + temp);
        }
    }
}
