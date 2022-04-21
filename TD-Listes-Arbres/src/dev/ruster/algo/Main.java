package dev.ruster.algo;

public final class Main {

    public static void main(String[] args) {
        Liste l7 = new Liste(7, null);
        Liste l6 = new Liste(6, l7);
        Liste l5 = new Liste(5, l6);
        Liste l4 = new Liste(4, l5);
        Liste l3 = new Liste(3, l4);
        Liste l2 = new Liste(2, l3);
        Liste l1 = new Liste(1, l2);

        System.out.println(Liste.recherche(l1, 9));
    }
}
