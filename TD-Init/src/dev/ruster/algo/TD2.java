package dev.ruster.algo;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class TD2 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean over = false;

        while(!over) {
            displayMainMenu();

            System.out.print("Exercice : ");
            int choice = scan.nextInt();

            switch(choice) {
                case 1 -> {
                    String option = Utils.getOption(scan);
                    System.out.print("n : ");
                    int n = scan.nextInt();

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
                case 2 -> {
                    String option = Utils.getOption(scan);
                    System.out.print("n : ");
                    int n = scan.nextInt();

                    System.out.print("x : ");
                    int x = scan.nextInt();

                    if("for".equals(option.trim())) {
                        for(int i = 0; i < n; i++) {
                            System.out.println(x + "^" + (i + 1) + " = " + puissRapide(x, i + 1));
                        }
                    } else {
                        System.out.println(x + "^" + n + " = " + puissRapide(x, n));
                    }
                }
                case 3 -> {
                    int[] t = {1, 2, 6, 4, 3, 8, 7};
//                    System.out.println(Arrays.toString(pivot(t, 1, t.length - 2)));
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

    public static int puiss(int x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * puiss(x, n - 1);
    }

    public static int puissRapide(int x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        int tmp = puissRapide(x, n / 2);

        if(n % 2 == 0) {
            return tmp * tmp;
        }
        return tmp * tmp * x;
    }

    public static int pivot(int @NotNull [] t, int i, int j) {
        if(i == j) {
            return i;
        }
        int p = t[j];
        int c = pivot(t, i + 1, j);

        if(t[i] <= p) {
            return c;
        }
        t[c] = t[i];
        t[i] = t[c - 1];
        t[c - 1] = p;
        return c - 1;
    }

    public static void quickSort(int[] t, int i, int j) {
        if(i < j) {
            int c = pivot(t, i, j);
            quickSort(t, i, c - 1);
            quickSort(t, c + 1, j);
        }
    }

    public static void displayMainMenu() {
        System.out.println("""
                1 -> puissance
                2 -> puissance Rapide
                3 -> pivot
                0 ou autre -> sortir
                """);
    }
}
