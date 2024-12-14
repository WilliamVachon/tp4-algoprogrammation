package sandbox;

import java.awt.Color; 


import commun.FenetreDessin;
public class Paysage {
    public static void main(String[] args) {
        FenetreDessin fd = new FenetreDessin("Paysage", 1000, 600);
        fd.couleurRemplissage(Color.BLACK); //
        fd.dessineRectanglePlein(100, 300, 200, 500); 
        fd.couleurRemplissage(Color.GREEN); //
        fd.dessineCerclePlein(150, 200, 100); 
        fd.dessineCerclePlein(850, 200, 100); 
        fd.couleurRemplissage(Color.BLACK); //
        fd.dessineRectanglePlein(800, 300, 900, 500); 
        fd.couleurRemplissage(Color.RED); //
        fd.dessineTrianglePlein(500, 100, 300, 200, 700, 200); 
        fd.couleurRemplissage(Color.ORANGE); //
        fd.dessineRectanglePlein(300, 200, 700, 500); 
        fd.couleurRemplissage(Color.WHITE); //
        fd.dessineRectanglePlein(550, 300, 650, 500); 
        fd.couleurRemplissage(Color.WHITE); //
        fd.dessineRectanglePlein(350, 250, 450, 350);

    }
}
