package com.sc.cd.demo;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();


        boolean match = isMatch(a, b);
        System.out.println(match);
    }

    private static boolean isMatch(String aStr, String bStr) {
        if (aStr == null || bStr == null) {
            return false;
        }

        if (aStr.length() != bStr.length() || aStr.length() > 100 || bStr.length() > 100) {
            return false;
        }

        if (aStr.equals(bStr)) {
            return true;
        }

        String aTemp = aStr.toLowerCase();
        String bTemp = bStr.toLowerCase();
        String temp = aTemp;
        for (int i = 0; i < aTemp.length(); i++) {
            String leftStr = temp.substring(0, 1);
            String rightStr = temp.substring(1);
            temp = rightStr + leftStr;
            if (bTemp.equals(temp)) {
                return true;
            }
        }
        return false;
    }

}
