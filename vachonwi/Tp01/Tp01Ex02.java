package vachonwi.Tp01;
import java.util.*;
public class Tp01Ex02 {
    public static final int EXPOSANT = 2;
public static void main(String[] args) {
    Scanner cl = new Scanner(System.in);
    float pointAx, pointBx, pointCx, pointAy, pointBy, pointCy;
    double segmentBCdoubley,segmentBC, segmentBCapresexposantx,totalBCdesxety, segmentBCdoublex, segmentBCapresexposanty;
    double segmentABdoubley, segmentAB, segmentABapresexposantx,segmentABapresexposanty,segmentABdoublex,totalABdesxety;
    double segmentAC, segmentACapresexposantx, segmentACapresexposanty, segmentACdoublex, segmentACdoubley, totalACdesxety;
    double perimetredutriangle;
    double p, aireavantsqrt, aireabc;
    System.out.println("Entrez les positions en x et y du premier point (A) :");
    pointAx = cl.nextFloat();
    pointAy = cl.nextFloat();
    System.out.println("Entrez les positions en x et y du deuxième point (B) :");
    pointBx = cl.nextFloat();
    pointBy = cl.nextFloat();
    System.out.println("Entrez les positions en x et y du troisième point (C) : ");
    pointCx = cl.nextFloat();
    pointCy = cl.nextFloat();
    System.out.println("-------------------------");
    // Segment AB
    segmentABdoubley = (pointBy - pointAy);
    segmentABapresexposanty = Math.pow(segmentABdoubley, EXPOSANT);
    segmentABdoublex = (pointBx - pointAx);
    segmentABapresexposantx = Math.pow(segmentABdoublex, EXPOSANT);
    totalABdesxety = (segmentABapresexposantx + segmentABapresexposanty);
    segmentAB = Math.sqrt(totalABdesxety);
    System.out.println("Mesure du segment AB :" + segmentAB);
    // Segment BC
    segmentBCdoubley = (pointCy - pointBy);
    segmentBCapresexposanty = Math.pow(segmentBCdoubley, EXPOSANT);
    segmentBCdoublex = (pointCx - pointBx);
    segmentBCapresexposantx = Math.pow(segmentBCdoublex, EXPOSANT);
    totalBCdesxety = (segmentBCapresexposantx + segmentBCapresexposanty);
    segmentBC = Math.sqrt(totalBCdesxety);
    System.out.println("Mesure du segment BC :" + segmentBC);   
    // Segment AC
    segmentACdoubley = (pointCy - pointAy);
    segmentACapresexposanty = Math.pow(segmentACdoubley, EXPOSANT);
    segmentACdoublex = (pointCx - pointAx);
    segmentACapresexposantx = Math.pow(segmentACdoublex, EXPOSANT);
    totalACdesxety = (segmentACapresexposantx + segmentACapresexposanty);
    segmentAC = Math.sqrt(totalACdesxety);
    System.out.println("Mesure du segment AC :" + segmentAC);
    perimetredutriangle = (segmentAB + segmentAC + segmentBC);
    System.out.println("Périmètre du triangle ABC :" + perimetredutriangle);
    p = ((segmentAB + segmentAC + segmentBC) / 2);
    aireavantsqrt = (p * (p - segmentAB) * (p - segmentAC) * (p - segmentBC));
    aireabc = Math.sqrt(aireavantsqrt);
    System.out.println("Aire du triangle ABC :" + aireabc);




}
}
