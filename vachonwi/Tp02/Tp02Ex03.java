package vachonwi.Tp02;

	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import java.util.Scanner;

	public class Tp02Ex03 {
		@Test void test11() { assertEquals("JAN", moisIntVersString(1)); }
		@Test void test12() { assertEquals("DEC", moisIntVersString(12)); }
		@Test void test13() { assertEquals("MAI", moisIntVersString(5)); }
		@Test void test14() { assertEquals("SEP", moisIntVersString(9)); }
		@Test void test15() { assertEquals("XXX", moisIntVersString(13)); }

		@Test void test21() { assertEquals(0, jourSemaine(1, 1, 1995)); }
		@Test void test22() { assertEquals(2, jourSemaine(17, 2, 2015)); }
		@Test void test23() { assertEquals(3, jourSemaine(25, 3, 1992)); }
		@Test void test24() { assertEquals(4, jourSemaine(22, 9, 2022)); }
		@Test void test25() { assertEquals(6, jourSemaine(23, 1, 2016)); }

		@Test void test31() { assertEquals(30, joursMois(4, 2019)); }
		@Test void test32() { assertEquals(31, joursMois(7, 2001)); }
		@Test void test33() { assertEquals(31, joursMois(10, 1976)); }
		@Test void test34() { assertEquals(29, joursMois(2, 1996)); }
		@Test void test35() { assertEquals(28, joursMois(2, 2009)); }

		@Test void test41() { assertEquals(11, jourDemain(10, 8, 2019)); }
		@Test void test42() { assertEquals(1, jourDemain(31, 12, 1999)); }
		@Test void test43() { assertEquals(31, jourDemain(30, 3, 2002)); }
		@Test void test44() { assertEquals(1, jourDemain(28, 2, 1993)); }
		@Test void test45() { assertEquals(29, jourDemain(28, 2, 2000)); }

		@Test void test51() { assertEquals(5, moisDemain(12, 5, 2019)); }
		@Test void test52() { assertEquals(1, moisDemain(31, 12, 1991)); }
		@Test void test53() { assertEquals(7, moisDemain(30, 7, 2002)); }
		@Test void test54() { assertEquals(3, moisDemain(28, 2, 1973)); }
		@Test void test55() { assertEquals(2, moisDemain(28, 2, 2000)); }

		@Test void test61() { assertEquals(2002, anneeDemain(25, 9, 2002)); }
		@Test void test62() { assertEquals(2012, anneeDemain(21, 12, 2012)); }
		@Test void test63() { assertEquals(2015, anneeDemain(30, 11, 2015)); }
		@Test void test64() { assertEquals(2006, anneeDemain(31, 12, 2005)); }
		@Test void test65() { assertEquals(1999, anneeDemain(31, 1, 1999)); }

		public static void main(String[] args) {
			Scanner clavier = new Scanner(System.in);

			int jour, mois, annee, jourSuivant, moisSuivant, anneeSuivante;
			int jourSemaine;
			
			System.out.print("Inscrivez la date réelle de votre transaction (JJ MMM AAAA): ");
			jour = clavier.nextInt();
			mois = moisStringVersInt(clavier.next().toUpperCase());
			annee = clavier.nextInt();
			
			jourSemaine = jourSemaine(jour, mois, annee);
			
			if (jourSemaine == 6 || jourSemaine == 0) {
				jourSuivant = jourDemain(jour, mois, annee);
				moisSuivant = moisDemain(jour, mois, annee);
				anneeSuivante = anneeDemain(jour, mois, annee);
				if (jourSemaine == 6) {
					jour = jourDemain(jourSuivant, moisSuivant, anneeSuivante);
					mois = moisDemain(jourSuivant, moisSuivant, anneeSuivante);
					annee = anneeDemain(jourSuivant, moisSuivant, anneeSuivante);
				} else {
					jour = jourSuivant;
					mois = moisSuivant;
					annee = anneeSuivante;
				}
			}
			System.out.print("Date d'inscription de votre transaction : ");
			System.out.println(String.format("%02d %s %d", jour, moisIntVersString(mois), annee));
		}
		
		/**
		 * Fonction qui convertit le mois sous forme de chaine de 
		 * caractères en une valeur numérique (JAN=1 ... DEC=12)
		 * 
		 * @param msStr Chaine représentant le mois à convertir
		 * @return Valeur numérique du mois
		 */
		public static int moisStringVersInt(String msStr) {
			int ms;
			
			switch (msStr) {
			case "JAN": ms = 1; break;
			case "FEV": ms = 2; break;
			case "MAR": ms = 3; break;
			case "AVR": ms = 4; break;
			case "MAI": ms = 5; break;
			case "JUN": ms = 6; break;
			case "JUL": ms = 7; break;
			case "AOU": ms = 8; break;
			case "SEP": ms = 9; break;
			case "OCT": ms = 10; break;
			case "NOV": ms = 11; break;
			case "DEC": ms = 12; break;
			default: ms = -1; break;
			}
			return ms;
		}

			public static String moisIntVersString(int ms) {
				// A FAIRE: Fonction qui convertit le mois sous forme de valeur numérique
				// en une chaine de caractères (1=JAN ... 12=DEC) Elle retourne XXX lorsque
				// le numéro du mois est invalide (Indice: voir moisStringVersInt() )
				String monthString;
				switch (ms) {
				case 1: monthString = "JAN"; break;
				case 2: monthString = "FEB"; break;
				case 3: monthString = "MAR"; break;
				case 4: monthString = "AVR"; break;
				case 5: monthString = "MAI"; break;
				case 6: monthString = "JUN"; break;
				case 7: monthString = "JUL"; break;
				case 8: monthString = "AOU"; break;
				case 9: monthString = "SEP"; break;
				case 10: monthString = "OCT"; break;
				case 11: monthString = "NOV"; break;
				case 12: monthString = "DEC"; break;
				default: monthString = "XXX"; break;
				}
				return monthString;
			}
	public static int jourSemaine(int jr, int ms, int an) {
		// A FAIRE: Retourne le jour de la semaine qui correspond à la date transmise
		// en paramètres (0=dimanche, 1=lundi, ..., 6=samedi) (Indice: voir formules)
		int z, D;
		if (ms == 1 || ms == 2) {
				z = an - 1;
				D = (23 * ms / 9 + jr + 4 + an + z / 4 - z / 100 + z / 400) % 7;
			} else {
				z = an;
				D = (23 * ms / 9 + jr + 4 + an + z / 4 - z / 100 + z / 400 - 2) % 7;
			}
			
			return D;
		
		}
	public static int joursMois(int ms, int an) {
		// A FAIRE: Retourne le nombre de jours dans le mois spécifié en prenant
		// en compte les années bissextiles (Indice: atelier 8 exercice 9)
	
		boolean isLeapYear = (an % 4 == 0 && an % 100 != 0) || (an % 400 == 0);

		switch (ms) {
			case 1: 
			case 3:
			case 5: 
			case 7: 
			case 8: 
			case 10: 
			case 12: 
				return 31;
			case 4: 
			case 6:
			case 9: 
			case 11: 
				return 30;
			case 2: 
				return isLeapYear ? 29 : 28;
			default: return 0;
	}
	}
	public static int jourDemain(int jr, int ms, int an) {
		// A FAIRE: Retourne le jour du lendemain dans le calendrier. Par
		// exemple, pour le 9 juin 2019, la fonction retourne 10; pour le 31
		// décembre 1999, elle retourne 1. (Indice: utilisez la fonction joursMois() )
			int joursDansMois = joursMois(ms, an);
			
			if (jr < joursDansMois) {
				return jr + 1;
			} else {
				return 1; 
			}
		}
			

	public static int moisDemain(int jr, int ms, int an) {
		// A FAIRE: Retourne le mois du lendemain dans le calendrier. Par 
		// exemple, pour le 9 juin 2019, la fonction retourne 6; pour le 31
		// décembre 1999, elle retourne 1. (Indice: utilisez la fonction joursMois() )
		
		int joursDansMois = joursMois(ms, an);
    
		if (jr < joursDansMois) {
			return ms; 
		} else {
			
			if (ms == 12) {
				return 1;
			} else {
				return ms + 1; 
			}
		}
	}
	
	public static int anneeDemain(int jr, int ms, int an) {
		// A FAIRE: Retourne l'année du lendemain dans le calendrier.
		// Par exemple, pour le 9 juin 2019, la fonction retourne 2019; pour 
		// le 31 décembre 1999, elle retourne 2000.
		{
      int joursDansMois = joursMois(ms, an);
      if (jr == joursDansMois && ms == 12) {
          return an + 1; 
      } else {
        return an;
          
      }
  
}
}
  }