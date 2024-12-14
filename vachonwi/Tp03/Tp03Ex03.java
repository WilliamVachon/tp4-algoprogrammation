package vachonwi.Tp03;

import java.util.random;
import java.util.Scanner;

public class Tp03Ex03 { 
    public static void main(String[] args) {
        Scanner cl = new Scanner(System.in);
        System.out.print("Entrez le nombre de jetons que vous souhaitez acheter (1$ = 1 jeton) : ");
        int jetonsRestants = cl.nextInt();
        int jetonsInitial = jetonsRestants;
        int choix;
        int mise;
        char resultat;

        while (jetonsRestants > 0) {
            System.out.println("\nVous avez " + jetonsRestants + " jetons.");
            System.out.println("Options disponibles :");
            System.out.println("1. Mise sur Pass");
            System.out.println("2. Mise sur Don't Pass");
            System.out.println("3. Quitter le jeu");
            System.out.print("Entrez votre choix (1-3) : ");
            choix = cl.nextInt();

            if (choix == 3) {
                // Le joueur a choisi de quitter le jeu
                break;
            } else if (choix != 1 && choix != 2) {
                System.out.println("Choix invalide. Veuillez réessayer.");
                continue;
            }

            // Demander la mise
            do {
                System.out.print("Entrez le montant de votre mise : ");
                mise = cl.nextInt();
                if (mise > jetonsRestants) {
                    System.out.println("Vous n'avez pas assez de jetons. Vous avez " + jetonsRestants + " jetons.");
                }
            } while (mise > jetonsRestants);

            // Jouer la partie
            System.out.print("Résultats des lancers : ");
            resultat = jouerPartie();
            System.out.println(); // Saut de ligne après les résultats

            // Déterminer si le joueur a gagné ou perdu
            boolean joueurGagne;
            if (choix == 1) { // Mise sur Pass
                joueurGagne = (resultat == 'P');
            } else { // Mise sur Don't Pass
                joueurGagne = (resultat == 'D');
            }

            if (joueurGagne) {
                jetonsRestants += mise;
                System.out.println("Félicitations ! Vous avez gagné " + mise + " jetons.");
            } else {
                jetonsRestants -= mise;
                System.out.println("Dommage ! Vous avez perdu " + mise + " jetons.");
            }

            // Vérifier si le joueur a encore des jetons
            if (jetonsRestants <= 0) {
                System.out.println("Vous n'avez plus de jetons. Le jeu est terminé.");
                break;
            }
        }

        // Afficher le total des gains ou pertes
        int gainOuPerte = jetonsRestants - jetonsInitial;
        if (gainOuPerte > 0) {
            System.out.println("Vous avez gagné " + gainOuPerte + " jetons !");
        } else if (gainOuPerte < 0) {
            System.out.println("Vous avez perdu " + (-gainOuPerte) + " jetons.");
        } else {
            System.out.println("Vous avez terminé avec le même nombre de jetons qu'au départ.");
        }
    }

    
    public static char jouerPartie(){
        int de1 = Outils.Aleatoire.nextInt(6) + 1;
        int de2 = Outils.Aleatoire.nextInt(6) + 1;
        int total = de1 + de2;
        System.out.print(total + " ");
        int point = 0; 
        if (total == 7 || total == 11) {
            return 'P';
        } else if (total == 2 || total == 3 || total == 12) {
            return 'D';
        } else {
            point = total;  
        }
        while (true) {
            de1 = Outils.Aleatoire.nextInt(6) + 1;
            de2 = Outils.Aleatoire.nextInt(6) + 1;
            total = de1 + de2;
            System.out.print(total + " ");
            
            if (total == point) {
                return 'P';
            } else if (total == 7) {
                return 'D';
            }
   
        }
    }
}
