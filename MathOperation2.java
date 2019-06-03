package mathoperation2;   // Saisir un nombre et faire une opération

import java.util.*; 

public class MathOperation2 {

    public static void main(String[] args) {
                
        Scanner scan=new Scanner(System.in);
        System.out.println ("saisir nombre 1");
        int nombre1 = scan.nextInt();
        
        System.out.println ("saisir nombre 2");
        int nombre2 = scan.nextInt();
        
        System.out.println ("saisir une opération");        
        int choix = scan.nextInt();
        
        
        switch(choix){
            case 1:
            System.out.println (nombre1 + nombre2);break;
            case 2:
            System.out.println (nombre1 - nombre2);break;
            case 3:
            System.out.println (nombre1 * nombre2);break;
            case 4:
            System.out.println (nombre1 / nombre2);break;        
    }    
}}


