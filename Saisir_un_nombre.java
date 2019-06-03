package saisirnombre;   // Saisir 2 nombres et donner le plus grand

import java.util.*; 

public class SaisirNombre {
   
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        System.out.println ("saisir premier nombre:");
        int nombre1 = scan.nextInt();
        
        System.out.println ("saisir deuxieme nombre:");
        int nombre2 = scan.nextInt();
        
        System.out.println ("Merci");
        
        if (nombre1 > nombre2)
            System.out.println ("l'entier le plus grand est:" + nombre1);
        else
            System.out.println ("l'entier le plus grand est:" + nombre2);
    }    
}
