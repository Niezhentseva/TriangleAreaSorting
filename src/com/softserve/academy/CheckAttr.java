package com.softserve.academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//checking the number of commas
public class CheckAttr {
    public static boolean checkForCommas(String input) {
        Pattern pattern = Pattern.compile(",");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count == 3;
    }
    // split string
    public static String[] parseInput(String input) {
        String[] inputArr = input.split(",");
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = inputArr[i].trim();
        }
        return inputArr;
    }
}
