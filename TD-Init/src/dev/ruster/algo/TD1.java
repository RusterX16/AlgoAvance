package dev.ruster.algo;

import org.jetbrains.annotations.Contract;

import java.util.Scanner;

public class TD1 {

    private static final Scanner scan = new Scanner(System.in);

    @Contract(pure = true)
    public static void main(String[] args) {
        boolean over = false;

        while(!over) {
            displayMainMenu();

            System.out.print("Exercice : ");
            int choice = scan.nextInt();

            String option = Utils.getOption(scan);
            System.out.print("n : ");
            int n = scan.nextInt();

            switch(choice) {
                case 1 -> {
                    if("for".equals(option.trim())) {
                        for(int i = 0; i < n; i++) {
                            System.out.println((i + 1) + "! = " + factorielle(i + 1));
                        }
                    } else {
                        System.out.println(n + "! = " + factorielle(n));
                    }
                }
                case 2 -> {
                    if("for".equals(option.trim())) {
                        for(int i = 0; i < n; i++) {
                            System.out.println((i + 1) + " pair ? " + pair(i + 1));
                        }
                    } else {
                        System.out.println(n + " pair ? " + pair(n));
                    }
                }
                case 3 -> {
                    if("for".equals(option.trim())) {
                        for(int i = 0; i < n; i++) {
                            System.out.println("Σ(0, " + n + ") = " + sommeImpairs(i + 1));
                        }
                    } else {
                        System.out.println("Σ(0, n) = " + sommeImpairs(n));
                    }
                }
                case 4 -> {
                    System.out.print("x : ");
                    int x = scan.nextInt();

                    if("for".equals(option.trim())) {
                        for(int i = 0; i < n; i++) {
                            System.out.println(x + "^" + (i + 1) + " = " + puiss(x, i + 1));
                        }
                    } else {
                        System.out.println(x + "^" + n + " = " + puiss(x, n));
                    }
                }
                case 5 -> {
                    System.out.print("a : ");
                    int a = scan.nextInt();
                    System.out.print("b : ");
                    int b = scan.nextInt();

                    System.out.println("Le PGCD de " + a + " et " + b + " est " + pgcd(a, b));
                }
                default -> {
                    System.out.println("Merci au revoir");
                    over = true;
                }
            }
            System.out.println();
        }
        System.exit(0);
    }

    @Contract(pure = true)
    private static int factorielle(int n) {
        return n == 1 ? 1 : n * factorielle(n - 1);
    }

    @Contract(pure = true)
    public static boolean pair(int n) {
        if(n == 0) {
            return true;
        }
        if(n == 1) {
            return false;
        }
        return pair(n - 2);
    }

    @Contract(pure = true)
    public static int sommeImpairs(int n) {
        if(pair(n)) {
            return 0;
        }
        return n + sommeImpairs(n - 1);
    }

    @Contract(pure = true)
    public static int puiss(int x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * puiss(x, n - 1);
    }

    @Contract(pure = true)
    public static int pgcd(int a, int b) {
        if(b - a < 0) {
            return 1;
        }
        return pgcd(b - a, b);
    }

    public static void displayMainMenu() {
        System.out.println("""
                    1 -> factorielle
                    2 -> pair
                    3 -> somme impairs
                    4 -> puissance
                    5 -> PGCD
                    0 ou autre -> sortir
                    """);
    }
}
