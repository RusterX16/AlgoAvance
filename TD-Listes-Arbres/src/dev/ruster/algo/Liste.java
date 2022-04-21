package dev.ruster.algo;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Liste {

    private int val;
    private Liste suiv;

    public Liste(int val, Liste suiv) {
        this.val = val;
        this.suiv = suiv;
    }

    public int longueur() {
        Liste suiv = this;
        int longueur = 1;

        while(suiv.suiv != null) {
            suiv = suiv.suiv;
            longueur++;
        }
        return longueur;
    }

    public static int longueur(Liste liste) {
        int longueur = 0;

        if(liste == null) {
            return 0;
        }
        longueur++;
        return longueur + longueur(liste.suiv);
    }

    public boolean recherche(int x) {
        Liste suiv = this;

        while(suiv.suiv != null) {
            suiv = suiv.suiv;

            if(suiv.val == x) {
                return true;
            }
        }
        return false;
    }

    @Contract(pure = true)
    public static boolean recherche(Liste liste, int x) {
        if(liste == null) {
            return false;
        }
        if(x == liste.val) {
            return true;
        }
        return recherche(liste.suiv, x);
    }

    public boolean estVide() {
        return suiv == null;
    }

    public void setSuiv(Liste liste) {
        suiv = liste;
    }
}
