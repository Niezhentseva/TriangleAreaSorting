package com.softserve.academy;

import java.text.DecimalFormat;

public class Triangle{
    private String name;
    private double side1;
    private double side2;
    private double side3;
    private double area;

    private Triangle(String name, double side1, double side2, double side3){
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    double getArea() {
        if (area == 0) {
            area = calculateArea();
        }
        return area;
    }

    private double calculateArea() {
        double halfPerimeter = getHalfPerimeter();
        double diff1 = halfPerimeter - side1;
        double diff2 = halfPerimeter - side2;
        double diff3 = halfPerimeter - side3;
        return Math.sqrt(halfPerimeter * diff1 * diff2 * diff3);
    }

    private double getHalfPerimeter() {
        return (side1 + side2 + side3) / 2;
    }

    public static Triangle createTriangle(String name, double side1, double side2, double side3)
            throws IllegalArgumentException {
        if ((side1 <= 0 || side2 <= 0 || side3 <= 0) ||
                ((side1 + side2 <= side3)
                || (side1 + side3 <= side2)
                || (side2 + side3 <= side1))) {
            throw new IllegalArgumentException();
        } else {
            return new Triangle(name, side1, side2, side3);
        }
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return String.format("[Triangle %s]: " + df.format(area) + " cm", name);
    }

}
