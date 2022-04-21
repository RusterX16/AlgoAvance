package dev.ruster.algo;

import java.util.Scanner;

public class Utils {

    public static String getOption(Scanner scan) {
        String option;

        do {
            System.out.print("Option : ");
            option = scan.next();
        } while(!option.equals("for") && !option.equals("/"));
        return option;
    }
}
