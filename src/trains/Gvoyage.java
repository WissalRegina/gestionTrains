/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package trains;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrateur
 */
public class Gvoyage extends javax.swing.JFrame {

    /**
     * Creates new form Gvoyage
     */
    Connection c ;
    public Gvoyage() {
        initComponents();
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/dbtrains";
            String user = "postgres";
            String password = "wissal";
            c = DriverManager.getConnection(url, user, password);
            
            listecodegare();
            afficherListeVoyage();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
        
    }
    
    // methode pour alimenter les liste de combobox
    
    void listecodegare() throws Exception{
        listgdep.removeAllItems();listgarr.removeAllItems();
        Statement requete = c.createStatement();
        ResultSet r = requete.executeQuery("SELECT code_gare FROM gare");
        while (r.next()){
            listgdep.addItem(r.getInt(1)+"");
            listgarr.addItem(r.getInt(1)+"");
        }
    }
    
    void afficherListeVoyage()throws Exception{
        DefaultTableModel m = new DefaultTableModel(null, new String[]{"code","gare depart","gare arrivee","arrivee prévue","arrivée effective"});
        Statement requete = c.createStatement();
        ResultSet r = requete.executeQuery("SELECT * FROM voyage");
        while (r.next()){
            m.addRow(new Object[]{r.getInt(1),r.getInt(2),r.getInt(3),
            r.getTimestamp(4),r.getTimestamp(5)});
        }
        tableV.setModel(m);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codev = new javax.swing.JTextField();
        listgdep = new javax.swing.JComboBox<>();
        listgarr = new javax.swing.JComboBox<>();
        Jpanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        datechoisi = new com.toedter.calendar.JCalendar();
        minute = new javax.swing.JSpinner();
        heure = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        retard = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        garearrivetxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Code Voyage");

        jLabel2.setText("Gare depart");

        jLabel3.setText("Gare d'arrivée");

        jLabel4.setText("Date d'arrivée prévue");

        jLabel5.setText("Heure d'arrivée prévue");

        jLabel6.setText("Retard (en minutes)");

        minute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        heure.setModel(new javax.swing.SpinnerNumberModel(0, 0, 12, 1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText(":");

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(heure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datechoisi, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpanelLayout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(retard, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(37, 37, 37))))
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(heure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(retard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addComponent(datechoisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton1.setText("Déclarer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(codev, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(listgdep, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1))
                    .addComponent(listgarr, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(codev, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listgdep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listgarr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Déclarer un retard", jPanel1);

        jLabel8.setText("Gare Arrivée:");

        garearrivetxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                garearrivetxtCaretUpdate(evt);
            }
        });

        tableV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableV);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(garearrivetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(garearrivetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulter Liste Voyage", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        int codevoyage=Integer.parseInt(codev.getText());
        int codeDep=Integer.parseInt(listgdep.getSelectedItem()+"");
        int codeArr=Integer.parseInt(listgarr.getSelectedItem()+"");
        
        //temps prevue temps effictive
        Date date = new java.sql.Date(datechoisi.getDate().getTime());
        int h = (Integer)heure.getValue();
        int m = (Integer)minute.getValue();
        //date.setHours(h);
       // date.setMinutes(m);
        Timestamp tempsprevue =new Timestamp(date.getYear(), date.getMonth(), date.getDate(), h, m, 00, 00);
        //Timestamp tempsprevue = java.sql.Timestamp.valueOf(date+"");
        
        int ret =(Integer)retard.getValue();
        int converthour= (Integer)ret/60;
        int convertminute= ret-(converthour*60);
        Timestamp tempseffictive= new Timestamp(date.getYear(), date.getMonth(), date.getDate(), tempsprevue.getHours()+converthour, tempsprevue.getMinutes()+convertminute, 00, 00);
        //Timestamp tempseffictive = java.sql.Timestamp.valueOf(s+"");
        
        Trains.ajouterVoyage(codevoyage, codeDep, codeArr, tempsprevue, tempseffictive,c);
        afficherListeVoyage();
        } 
        catch(NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "retard non déclaré");
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void garearrivetxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_garearrivetxtCaretUpdate
        try {
        
        DefaultTableModel m = new DefaultTableModel(null,new String[]{"code voyage","code depart","code d'arrivee"});
        String s = garearrivetxt.getText();
        Statement requete = c.createStatement();
        //SELECT code_v,code_g_dep,code_g_arr FROM voyage where(SELECT g.nom_gare FROM gare g,voyage v WHERE g.code_gare= v.code_g_arr) like '%ouasis%';
        String sql= "SELECT code_v,code_g_dep,code_g_arr FROM voyage where(SELECT g.nom_gare FROM gare g,voyage v WHERE g.code_gare= v.code_g_arr) like '%"+s+"%'";
       // String sql ="SELECT g.nom_ville FROM gare g,voyage v WHERE g.code_gare= v.code_g_arr";
        ResultSet r = requete.executeQuery(sql);  
        //ResultSet result = requete2.executeQuery("SELECT code_v,code_g_dep,code_g_arr,temps_arr_prevue,temps_arr_affective FROM voyage where "+r.next()+"like %"garearrivetxt+"%");

        while(r.next()){
            m.addRow(new Object[]{r.getInt(1),r.getInt(2),r.getInt(3)});
        }
        tableV.setModel(m);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_garearrivetxtCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gvoyage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gvoyage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gvoyage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gvoyage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gvoyage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JTextField codev;
    private com.toedter.calendar.JCalendar datechoisi;
    private javax.swing.JTextField garearrivetxt;
    private javax.swing.JSpinner heure;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> listgarr;
    private javax.swing.JComboBox<String> listgdep;
    private javax.swing.JSpinner minute;
    private javax.swing.JSpinner retard;
    private javax.swing.JTable tableV;
    // End of variables declaration//GEN-END:variables
}
