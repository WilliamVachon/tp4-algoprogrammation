package vachonwi.Tp02;
import java.util.*;

public class Tp02Ex02 { public static void main(String[] args) {
    try (Scanner cl = new Scanner(System.in)) {
        double x, x1, x2, a, b, c;
        System.out.println("Indiquez les coefficients (a b c) :");
        a = cl.nextDouble();
        b = cl.nextDouble();
        c = cl.nextDouble();
        final double delta = ((Math.pow(b, 2)) - 4 * a * c);
        if (a == 0 && b == 0 && c == 0) { System.out.println("Infinité de solutions");     
        } else { if (a == 0 && b == 0 && c != 0 ) { System.out.println("Aucune solution");    
        } else { if (a == 0 && b != 0) {
                x = ((c / b) * -1);
                System.out.printf("x =" + x);
            } else { if (a != 0 && delta > 0) {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.printf("x1 =" + x1 + "x2 =" + x2);

           } else { if (a != 0 && delta == 0) {
            x = (-b / (2 * a));
            System.out.printf("x =" + x);
           } else { if (a != 0 && delta < 0) {
            System.out.printf("Aucune solution réelle");
           }
        }
}
}
}
}
    }
}

}



























