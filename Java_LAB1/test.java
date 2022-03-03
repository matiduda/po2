import java.lang.Math;
import java.util.Scanner;

class Hello {

    public static void main(String args[]) {  
    
        Scanner sc= new Scanner(System.in); 
        System.out.print("A = ");  
        double a = sc.nextDouble();
        System.out.print("B = ");  
        double b = sc.nextDouble();
        System.out.print("C = ");  
        double c = sc.nextDouble();

        // Sprawdz czy rownanie ma rozwiazanie
        double delta = b * b - 4 * a * c;
        
        if(delta < 0) {
            System.out.print("Rownenie nie ma rozwiazania");
        } else if(delta == 0) {
            double x = -b / (2 * a);
            System.out.print("Rownanie ma jedno rozwiazanie x = " + x);
        } else {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            System.out.print("Rownanie ma dwa rozwiazania x1 = " + x1 + ", x2 = " + x2);
        }
    
        System.out.print("\n");
    }
} 

