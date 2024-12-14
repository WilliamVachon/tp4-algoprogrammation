package vachonwi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.Scanner;
import commun.Outils;

public class tp4 {

    public static final int NB_CASES = 7; // Nombre de cases à remplir par partie, maximum 20

    @BeforeEach
    void setup() {
        Outils.Aleatoire.resetSeedSet();
        Outils.Aleatoire.setSeed(123);
    }

    public static void main(String[] args) {
        Outils.Aleatoire.setSeed(9531);
        Scanner cl = new Scanner(System.in);

        int[] points = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        int[] tuiles = new int[40];
        int scoreMax = 0;
        boolean continuer = true;

        while (continuer) {
            System.out.println("Sélectionnez le pointage de Base ou Expert ou Quitter : ");
            String typePointage = cl.nextLine().trim().toUpperCase();

            if (typePointage.equals("Q")) {
                break;
            }

            if (typePointage.equals("E")) {
                points[6] = 10;
                points[12] = 20;
                points[17] = 25;
            }

            System.out.println("Distribution des chiffres, soit Classique ou Différents? (C/D) : ");
            String distribution = cl.nextLine().trim().toUpperCase();

            if (distribution.equals("D")) {
                for (int i = 0; i < 40; i++) {
                    tuiles[i] = i + 1;
                }
            } else {
                for (int i = 0; i < 31; i++) {
                    tuiles[i] = i;
                }
                for (int i = 31; i < 40; i++) {
                    tuiles[i] = i - 20;
                }
            }

            int score = jouerPartie(cl, tuiles, points);
            if (score > scoreMax) {
                scoreMax = score;
                System.out.println("Bravo, vous avez battu votre record! Nouveau score à battre : " + String.format("%03d", scoreMax));
            }

            System.out.println("Sélectionnez le pointage de Base ou Expert ou Quitter : ");
            continuer = !cl.nextLine().trim().equalsIgnoreCase("Q");
        }

        System.out.println("Votre record est : " + String.format("%03d", scoreMax));
        System.out.println("Bonne journée!");
        cl.close();
    }

    public static int jouerPartie(Scanner cl, int[] tuiles, int[] points) {
        int[] cases = toursDeJeu(cl, tuiles);
        changeJoker(cl, cases);
        int[] scores = calculScore(cases, points);
        int scoreTotal = somme(scores);
        int positionMax = maximum(scores);

        System.out.println("Résultat de la partie:");
        affiche(cases, ' ', '-', positionMax, "");
        affiche(scores, ' ', '-', positionMax, "");

        System.out.println("Total de la partie = " + scoreTotal + " (" + scores[positionMax] + ")");
        return scoreTotal;
    }

    public static int[] toursDeJeu(Scanner cl, int[] tuiles) {
        int[] cases = new int[NB_CASES];
        for (int i = 0; i < NB_CASES; i++) {
            cases[i] = -1;
        }
    
        boolean[] disponible = new boolean[tuiles.length];
        for (int i = 0; i < tuiles.length; i++) {
            disponible[i] = true;
        }
    
        for (int i = 0; i < NB_CASES; i++) {
            int tuile = pigeTuile(tuiles, disponible);
            affiche(cases, ' ', '-', -1, "");
            affichePositions(NB_CASES);  // Display position numbers 1 to 7
            int position;
            do {
                System.out.print("Position d'ajout du nombre " + tuile + " > ");
                position = cl.nextInt();
                cl.nextLine(); // Clear the newline character
            } while (position < 1 || position > NB_CASES || cases[position - 1] != -1);
            cases[position - 1] = tuile;
        }
        return cases;
    }
    public static void affichePositions(int nbCases) {
        for (int i = 1; i <= nbCases; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    

    public static void changeJoker(Scanner cl, int[] cases) {
        int jokerPosition = trouve(cases, 0);
        if (jokerPosition != -1) {
            System.out.print("En quelle valeur voulez-vous changer le JOKER? ");
            cases[jokerPosition] = cl.nextInt();
            cl.nextLine(); // Clear the newline character
        }
    }

    public static int[] calculScore(int[] cases, int[] points) {
        int[] scores = new int[cases.length];
        int suiteLength = 1;
        for (int i = 1; i < cases.length; i++) {
            if (cases[i] == cases[i - 1] + 1) {
                suiteLength++;
            } else {
                if (suiteLength > 1) {
                    scores[i - suiteLength] = points[suiteLength - 1];
                }
                suiteLength = 1;
            }
        }

        if (suiteLength > 1) {
            scores[cases.length - suiteLength] = points[suiteLength - 1];
        }
        return scores;
    }

    public static int pigeTuile(int[] tuiles, boolean[] disponible) {
        int tuile;
        do {
            tuile = Outils.Aleatoire.valeur(0, tuiles.length - 1);
        } while (!disponible[tuile]);
        disponible[tuile] = false;
        return tuiles[tuile];
    }

    public static void affiche(int[] tab, char sepC, char sepD, int val, String rem) {
        for (int i = 0; i < tab.length; i++) {
            if (i > 0) {
                System.out.print(sepC);
            }
            if (tab[i] == 0) {
                System.out.print("**");
            } else {
                System.out.print(tab[i]);
            }
        }
        System.out.println(rem);
    }

    public static int somme(int[] vecteur) {
        int somme = 0;
        for (int i : vecteur) {
            somme += i;
        }
        return somme;
    }

    public static int maximum(int[] vecteur) {
        int maxIndex = 0;
        for (int i = 1; i < vecteur.length; i++) {
            if (vecteur[i] > vecteur[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int trouve(int[] vecteur, int valeur) {
        for (int i = 0; i < vecteur.length; i++) {
            if (vecteur[i] == valeur) {
                return i;
            }
        }
        return -1;
    }
}
