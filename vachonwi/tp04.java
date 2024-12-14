

package vachonwi;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.Scanner;
import commun.Outils;
public class tp04 {
    
	@BeforeEach void setup() {
		Outils.Aleatoire.resetSeedSet();
		Outils.Aleatoire.setSeed(123);
	}



	public static final int NB_CASES = 7; // Nombre de cases à remplir par partie, maximum 20
	public static void main(String[] args) {
		// A FAIRE (45) : code
//		Outils.Aleatoire.setSeed(9531);
        Outils.Aleatoire.setSeed(9531); 
        Scanner cl = new Scanner(System.in);
		// Déclarer un tableau pour les points et l'initialiser avec les points
        int[] points = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		// de base inscrits sur la feuille de pointage disponible dans l'énoncé
		// Créer un tableau de taille quarante pour stocker les tuiles
        int[] tuiles = new int[40];
        int scoreMax = 0; 
        boolean continuer = true;
		// Répéter
        while (continuer) {
		// Si l'usager ne choisit pas de quitter
        System.out.println("Choisissez le type de pointage (base ou expert) :"); 
        String typePointage = cl.nextLine(); 
        if (typePointage.equalsIgnoreCase("expert")) {
		// On modifie les trois cases du tableau des points selon le type de pointage choisi
        points[6] = 10; 
        points[12] = 20; 
        points[17] = 25; 
    }
		// On initialise le tableau des tuiles selon la distribution désirée
        System.out.println("Choisissez la distribution des tuiles (classique ou différentes) :"); 
        String distribution = cl.nextLine(); if (distribution.equalsIgnoreCase("différentes")) { 
            for (int i = 0; i < 40; i++) { 
                tuiles[i] = i + 1; 
            } 
        } else { 
            for (int i = 0; i < 31; i++) { 
                tuiles[i] = i; 
            } 
            for (int i = 31; i < 40; i++) 
            { 
                tuiles[i] = i - 20; 
            } 
        }
		// Appel de jouerPartie() et récupération du score final
        int score = jouerPartie(cl,tuiles, points);
		// Mise à jour du score maximal si le joueur a fait un nouveau record
        if (score > scoreMax) { 
            scoreMax = score; 
        }
		// Tant que le joueur ne choisit pas de quitter
        System.out.println("Voulez-vous jouer une nouvelle partie ? (oui/non) :"); 
        continuer = cl.nextLine().equalsIgnoreCase("oui"); 
    }
		// Afficher le pointage record et saluer le joueur
        System.out.println("Votre score maximal est : " + scoreMax); 
        System.out.println("Merci d'avoir joué ! Bonne journée !"); 
        cl.close(); 
    }
	// A FAIRE (14) : code - documentation(/**)
	public static int jouerPartie(Scanner cl, int[] tuiles, int[] points) {
		// tuiles et points ne doivent pas être modifiés
		// Déclarer un tableau de cases et de scores, mais ne pas les initialiser
        int[] cases, scores;
		// Appeler toursDeJeu() et récupérer le tableau de cases
        cases = toursDeJeu(cl, tuiles);
		// Appeler changeJoker()
        changeJoker(cl, cases);
		// Appeler calculScore() et récupérer le tableau des scores
        scores = calculScore(cases, points);
		// Appeler somme() pour obtenir le score total
        int scoreTotal = somme(scores);
		// Appeler maximum() pour obtenir la poisition du score maximal pour une suite
        int positionMax = maximum(scores);
		// Afficher le résultat de la partie
        System.out.println("Résultat de la partie:");
        affiche(cases, ' ', '-', positionMax, "Score maximal: " + scores[positionMax]);
        affiche(scores, ' ', '-', positionMax, "Total: " + scoreTotal);
		return scoreTotal; // Retourner le score total
	}

	// A FAIRE (26) : code - documentation(/**)
	public static int[] toursDeJeu(Scanner cl, int[] tuiles) {
        // tuiles ne doit pas être modifié
		// Initialiser un tableau de cases à -1 ayant pour taille NB_CASES
		// Initialiser un tableau de positions avec les nombres de 1 à NB_CASES
		// Initialiser un tableau tuiles disponibles à vrai (true) de la même taille que tuiles
		// Pour le nombre de cases à remplir, piger une tuile, afficher l'état actuel
		// des cases, demander la position d'ajout au joueur, jusqu'à ce qu'il
		// entre une position valide, et écrire la tuile dans la case.
		// Indice : Les positions du joueur débutent à 1 alors que votre tableau débute à 0
        
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
                affichePositions(NB_CASES); 
                int position;
                do {
                    System.out.print("Position d'ajout du nombre " + tuile + " > ");
                    position = cl.nextInt();
                    cl.nextLine(); 
                } while (position < 1 || position > NB_CASES || cases[position - 1] != -1);
                cases[position - 1] = tuile;
            }
            return cases; // Retourne le tableau de cases rempli
        }
        public static void affichePositions(int nbCases) {
            for (int i = 1; i <= nbCases; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        

	// A FAIRE (8) : code - documentation(/**)
	public static void changeJoker(Scanner cl, int[] cases) {
		// Le tableau cases peut être modifié si un JOKER est présent
		// Lire la documentation de l'énoncé et utiliser la fonction trouve()
        int jokerPosition = trouve(cases, 0); 
        if (jokerPosition != -1) { 
            System.out.print("Entrez la valeur à remplacer pour le JOKER : "); 
            cases[jokerPosition] = cl.nextInt(); 
    } 
}

	// A FAIRE (13) : code - documentation(/**)
	public static int[] calculScore(int[] cases, int[] points) {
		// cases et points ne doivent pas être modifiés
		// Aucun affichage n'est réalisé par cette fonction
        int[] scores = new int[cases.length];
        int suiteLength = 1;
        for (int i = 1; i < cases.length; i++) {
            if (cases[i] == cases[i - 1] + 1) {
                suiteLength++;
            } else {
                if (suiteLength > 1) {
                    scores[i - suiteLength] = points[suiteLength - 1];
                } suiteLength = 1; 
            } 
        }
		// Initialiser à zéro un tableau de scores de la même taille que le tableau cases
		// Initialiser la longueur de la suite à 1
		// Pour chaque paire de cases adjacentes, vérifier s'il s'agit de la fin 
		// d'une suite et faire le traitement approprié
		// Ne pas oublier d'écrire les points de la dernière suite
        if (suiteLength > 1) { 
            scores[cases.length - suiteLength] = points[suiteLength - 1]; 
        }
		return scores; // Retourne le tableau des scores créé
	}

	// A FAIRE (8) : code - documentation(/**)
	public static int pigeTuile(int[] tuiles, boolean[] disponible) {
		// Seul tuiles ne doit pas être modifié
		// Aucun affichage n'est réalisé par cette fonction
        int tuile;
        do {
            tuile = Outils.Aleatoire.valeur(0, tuiles.length - 1);
        } while (!disponible[tuile]);
        disponible[tuile] = false;
		// Lire la documentation de l'énoncé et utiliser Outils.Aleatoire
		// Indice : Ne pas oublier de mettre la tuile pigée à
		// false dans le tableau disponible
		return tuiles[tuile]; // Retourne la valeur de la tuile pigée
	}

	// A FAIRE (15) : code - documentation(/**)
	public static void affiche(int[] tab, char sepC, char sepD, int val, String rem) {
		// tab ne doit pas être modifié
        for (int i = 0; i < tab.length; i++) {
            if (i > 0) {
                System.out.print(sepC);
            }
            if (tab[i] == -1) {
                System.out.print("__");
            } else if (tab[i] == 0) {
                System.out.print("**"); // For Joker representation
            } else {
                System.out.print(tab[i]);
            }
        }
        System.out.println(rem);
    
    
		// Lire la documentation de l'énoncé et utiliser String.formatted()
		// Indice : Faire un cas spécial pour le premier élément qui ne
		// doit pas être précédé d'un séparateur 
	}

	// A FAIRE (6) : code - documentation(/**)
	public static int somme(int[] vecteur) {
		// vecteur ne doit pas être modifié
        int somme = 0;
        for (int i : vecteur) {
            somme += i;
        }
		// Aucun affichage n'est réalisé par cette fonction
		// Indice : Notes de cours
		return somme; // Retourne une valeur
	}

	// A FAIRE (8) : code - documentation(/**)
	public static int maximum(int[] vecteur) {
		// vecteur ne doit pas être modifié
        if (vecteur.length == 0) {
            return -1;
        }
        int maxIndex = 0;
        for (int i = 1; i < vecteur.length; i++) {
            if (vecteur[i] > vecteur[maxIndex]) { 
                maxIndex = i;
        }
    }
		// Aucun affichage n'est réalisé par cette fonction
		// Indice : Notes de cours
		return maxIndex; // Retourne une position
	}

	// A FAIRE (9) : code - documentation(/**)
	public static int trouve(int[] vecteur, int valeur) {
		// vecteur ne doit pas être modifié
        for (int i = 0; i < vecteur.length; i++) {
            if (vecteur[i] == valeur) {
		// Aucun affichage n'est réalisé par cette fonction
        return i;
            }
        }
		// Indice : Notes de cours
		return -1; // Retourne une position
	}
}

