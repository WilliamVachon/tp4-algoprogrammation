package vachonwi.at04;
import java.util.Scanner;
public class At04Ex03 {

   
    public static int POUCES_PIED = 12;

    public static void main(String[] args) {
    Scanner cl = new Scanner(System.in);
     int pieds, pouces;
     int totalPouces;
     int totalPouces2;
     int pieds2;
     int pouces2;
     int pieds3;
     int pouces3;
     int totalPouces3;
    
     System.out.println("Indiquez une longueur en pieds et pouces : ");
     pieds = cl.nextInt();
     pouces = cl.nextInt();
     totalPouces = pieds * POUCES_PIED + pouces;
     System.out.println("Indiquez une longueur en pieds et pouces : ");
     pieds2 = cl.nextInt();
     pouces2 = cl.nextInt();
     totalPouces2 = totalPouces + (pieds2 * POUCES_PIED + pouces2);
     System.out.println("Indiquez une longueur en pieds et pouces : ");
     pieds3 = cl.nextInt();
     pouces3 = cl.nextInt();
     totalPouces3 = totalPouces2 + (pieds3 * POUCES_PIED + pouces3);
     pieds3 = totalPouces3 / POUCES_PIED;
     pouces3 = totalPouces3 % POUCES_PIED;
     System.out.print("La longueur totale est de " + totalPouces3 + " pouces, ");
     System.out.println("soit " + pieds3 + "' " + pouces3 + "\"");
    
}
}
// Indiquez une longueur en pieds et pouces : 5 9
//Indiquez une longueur en pieds et pouces : 3 8
// Indiquez une longueur en pieds et pouces : 6 3
//La longueur totale est de 188 pouces, soit 15' 8"