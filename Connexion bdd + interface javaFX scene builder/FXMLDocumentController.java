package bddinterface;

import java.sql.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TableView dataView; 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //création des tables colonnes
        TableColumn<Produit, String> col1 = new TableColumn<>("ID" );
        TableColumn<Produit, String> col2 = new TableColumn<>("Nom Produit" );
        TableColumn<Produit, String> col3 = new TableColumn<>("Prix" );

  
        col1.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(""+param.getValue().getId());
        });        
        col2.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(param.getValue().getNom());
        });
        col3.setCellValueFactory(param -> {
            return new ReadOnlyStringWrapper(""+param.getValue().getPrix());
        }); 
        
        
        dataView.getColumns().add(col1);
        dataView.getColumns().add(col2);
        dataView.getColumns().add(col3);

        
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
                  dataView.getItems().add(new Produit(rs.getInt(1) , rs.getString(2) , rs.getInt(3) ));
                }
            
                con.close();
                
        }catch(Exception e){System.out.println("erreur" + e.getMessage());}  
    }    
}


