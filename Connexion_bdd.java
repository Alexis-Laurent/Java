package bdd;    // Connexion à une base de données MySQL

import java.sql.*;


public class Bdd {
 
    public static void main(String[] args) {
        
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/produit","root","");
            
            // Envoie une requête SQL à la base
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from produit");            
            
            // Affichage
            while(rs.next())
                {
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
                }                
                con.close();            
                
        }catch(Exception e){System.out.println("erreur" + e.getMessage());}                
    }    
}
