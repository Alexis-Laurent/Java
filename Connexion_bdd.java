package bdd;    //connexion à la base de données MySQL

import java.sql.*;


public class Bdd {
 
    public static void main(String[] args) {
        
        try{ // Connexion à la base de données
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/produit","root","");
            
            // envoie une requête SQL à la base
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from produit");            
            
            // affichage
            while(rs.next())
                {
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
                }
                
                con.close();
                
        }catch(Exception e){System.out.println("erreur" + e.getMessage());}                
    }    
}
