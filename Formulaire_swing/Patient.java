package formulaireswing;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Patient extends javax.swing.JFrame {

    public Patient() {
        initComponents();
        
    // Titre de la fenêtre
    setTitle("Liste des patients");
    
    // Centrage de la fenêtre
    setLocationRelativeTo(null); 
    
    // Connexion bdd
    jTable.isCellEditable(ERROR,NORMAL);
    
            try{             
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","");
            Statement state=con.createStatement();
            
            System.out.println("select * from patient");                  
            ResultSet rs=state.executeQuery("select * from patient");            
            
            DefaultTableModel dtm=(DefaultTableModel) jTable.getModel();
            dtm.setRowCount(0);
            
            while(rs.next()){
                String idPatient=rs.getString("patient_id");
                String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String date=rs.getString("date_naissance");
                String adresse=rs.getString("adresse");
                String [] tab={idPatient,nom,prenom,date,adresse};
                dtm.addRow(tab);
            }
            
            }catch(SQLException ev){
                ev.printStackTrace();
            }
            
            // Désactiver édition
            jTable.setDefaultEditor(Object.class, null);
            
            // Evénement clic
            jTable.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent mouseEvent){
                    JTable table=(JTable) mouseEvent.getSource();
                    Point point=mouseEvent.getPoint();
                    int row=table.rowAtPoint(point);
                    if (mouseEvent.getClickCount()==2 && table.getSelectedRow() !=-1){
                        
                        String idPatientTmp = (String) jTable.getValueAt(table.getSelectedRow() , 0 ); 
                        int idPatient = Integer.parseInt( idPatientTmp );
                        Modifier fenetre = new Modifier(idPatient);
                        fenetre.setVisible(true);
                        
                        setVisible(false);
                    }
                }
            });          
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idPatient", "Non", "Prenom", "Date de naissance", "Adresse"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
