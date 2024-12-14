package vachonwi.at03;
import java.awt.Color;

import commun.FenetreDessin;

public class TextreCentre {
public static void main(String[] args) {
    FenetreDessin fd = new FenetreDessin("Texte Centre", 500, 500);
    fd.couleurCrayon(Color.YELLOW); //
    fd.dessineSegment(250, 0, 250, 500);
    fd.dessineSegment(0, 250, 500, 250);
    fd.couleurCrayon(Color.RED); //
    fd.dessineTexte(225, 260, "William");
}
}
