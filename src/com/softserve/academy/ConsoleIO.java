package com.softserve.academy;

import java.util.List;
import java.util.Scanner;

public class ConsoleIO {
    static Scanner scanner = new Scanner(System.in);

    public static String enterValue() {
        return scanner.nextLine();
    }

    public static boolean isContinue() {
        String scan = scanner.nextLine();
        return (scan.equalsIgnoreCase("y")
                || scan.equalsIgnoreCase("yes"));
    }

    public static void printToConsole(String message) {
        System.out.println(message);
    }

    public static void printListTriangles(List<Triangle> triangles) {
        System.out.println("============= Triangles list: =============");
        int i = 1;
        for (Triangle temp : triangles) {
            System.out.println(i++ + ". " + temp);
        }
    }
}
