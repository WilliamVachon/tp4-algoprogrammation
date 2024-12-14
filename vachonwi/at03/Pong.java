package vachonwi.at03;
import java.awt.Color; 

import commun.FenetreDessin;
public class Pong {
public static void main(String[] args) {
    FenetreDessin fd = new FenetreDessin("Pong", 800, 600);
   fd.couleurCrayon(Color.RED); //
    fd.dessineRectangle(0,0,800,600);
    fd.dessineRectangle(1,1,799,599);
    fd.dessineRectangle(2,2,798,598);
    fd.dessineRectangle(3,3,797,597);
    fd.dessineRectangle(4,4,796,596);
    fd.dessineRectangle(5,5,795,595);
    fd.dessineRectangle(50, 150, 100, 450 );
    fd.dessineRectangle(700, 150, 750, 450);
    fd.dessineRectangle(150, 150, 650, 450);
    fd.dessineRectangle(200, 250, 250, 350);
    fd.dessineRectangle(550 ,250 ,600, 350);
    fd.dessineRectangle(375,275,425,325);
}
}
