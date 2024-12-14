package vachonwi.at10;

import java.util.Scanner;

public class aa { public static void main(String[] args) {
       try (Scanner cl = new Scanner(System.in)) {
        int nombre;
System.out.print("Saisissez votre nombre: ");
    nombre = cl.nextInt();
while (nombre % 2 == 0) {
    if (nombre > 10) {
        System.out.print("Votre nombre est plus grand que 10");
    } else if (nombre < 10) {
        System.out.print("Votre nombre est plus petit que 10");
    } else if(nombre == 10) {
        System.out.println("Votre nombre est dix");
    
        System.out.print("Saisissez un autre nombre: ");
        nombre = cl.nextInt(); }
    }
    System.out.println("Votre nombre est impair");
}

}}
