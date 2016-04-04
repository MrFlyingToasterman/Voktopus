package voktopus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import static voktopus.Voktopus.profil;

/**
 *
 * @author Darius Musiolik
 */
public class sysinput extends javax.swing.JFrame {

    public static int ccheck;
    public static String profilx;
    /**
     * Creates new form sysinput
     */
    public sysinput() {
        initComponents();
        abgleich();
    }
    
    public static void abgleich() {
        
        ccheck = Voktopus.combocheck;
        String ubergang;
        switch (ccheck) {
            case 0:
                ubergang = "Pool";
                break;
            case 1:
                ubergang = "Erster Kasten";
                break;
            case 2:
                ubergang = "Zweiter Kasten";
                break;
            case 3:
                ubergang = "Dritter Kasten";
                break;
            case 4:
                ubergang = "Vierter Kasten";
                break;
            default:
                ubergang = "ERR!";
                break;
        }
        jLabel6.setText("" + ubergang); //Kasten
        
        jLabel8.setText(profil); // Profil
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setTitle("Datenbank Hinzufügen");
        setLocation(new java.awt.Point(300, 150));
        setResizable(false);

        jLabel1.setText("Überschrift:");

        jLabel2.setText("Frage:");

        jButton1.setText("Hinzufügen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Lösung:");

        jTextField3.setText("Keine Lösung");

        jLabel4.setFont(new java.awt.Font("Cantarell", 3, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(74, 94, 237));
        jLabel4.setText("Hilfe..");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 2, 15)); // NOI18N
        jLabel5.setText("Karteikasten:");

        jLabel6.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(235, 55, 75));
        jLabel6.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Cantarell", 2, 15)); // NOI18N
        jLabel7.setText("Profil:");

        jLabel8.setFont(new java.awt.Font("Cantarell", 3, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(235, 55, 75));
        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Inhalt der GUI in Variabeln einlesen
        String uberschrift = jTextField1.getText();
        String inhalt = jTextField2.getText();
        String losung = jTextField3.getText();
        
        //Überschrift prüfen
        if (uberschrift.equals("")) {
            JOptionPane.showMessageDialog(null, "Datenbank0 kann nicht Void sein!", "Datenbanken Fehler", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Überschrift Prüfen!", "Datenbank0 Void", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        //Überschreibungsschutz
        //Daten Lesen
        File pooldir = new File("vdata/" + profil + "/pool");
        File kastendir = new File("vdata/" + profil + "/kasten");
        String poolfiles;
        String kastenfiles;
        
        poolfiles = "";
        kastenfiles = "";
        
        String[] poolchildren = pooldir.list();
            if (poolchildren == null) {
                //nicht vorhanden
                poolfiles = "";
            } else {
                for (int i=0; i<poolchildren.length; i++) {
                poolfiles = poolfiles + poolchildren[i] + " ";
                }
            }
            
            String[] kastenchildren = kastendir.list();
            if (kastenchildren == null) {
                //nicht vorhanden
                kastenfiles = "";
            } else {
                for (int i=0; i<kastenchildren.length; i++) {
                kastenfiles = kastenfiles + kastenchildren[i] + " ";
                }
            }
            String uberschriftendung = uberschrift + ".vpus";
        if (poolfiles.contains(uberschriftendung)) {
            //Sicherheitsfrage "Sind Sie sicher dass Sie NAME Löschen wollen ?"
        int reply = JOptionPane.showConfirmDialog(null, "Es gibt bereits " + uberschriftendung + "\nSind Sie sicher dass Sie " + uberschriftendung + " überschreiben wollen ?", "Bestätigen", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.out.println("überschreiben vom User bestätigt!");
          
        //Löschen der gewählten Datei
        try{
    		
    		File file = new File("vdata/" + profil + "/pool/" + uberschriftendung);
        	
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){}
        }
        else {
           JOptionPane.showMessageDialog(null, "Abgebrochen!");
           return;
        }
        }
        if (kastenfiles.contains(uberschriftendung)) {
            //Sicherheitsfrage "Sind Sie sicher dass Sie NAME Löschen wollen ?"
        int reply = JOptionPane.showConfirmDialog(null, "Es gibt bereits " + uberschriftendung + "\nSind Sie sicher dass Sie " + uberschriftendung + " überschreiben wollen ?", "Bestätigen", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.out.println("überschreiben vom User bestätigt!");
            //Löschen der gewählten Datei
        try{
    		
    		File file = new File("vdata/" + profil + "/kasten/" + uberschriftendung);
        	
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){}
        }
        else {
           JOptionPane.showMessageDialog(null, "Abgebrochen!");
           return;
        }
        }
        
        //Verhinder /
        if (uberschrift.contains("/")) {
            JOptionPane.showMessageDialog(null, "Eine Datenbank darf kein '/' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Verhinder |
        if (uberschrift.contains("|")) {
            JOptionPane.showMessageDialog(null, "Eine Datenbank darf kein '|' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Verhinder \
        if (uberschrift.contains("\\")) {
            JOptionPane.showMessageDialog(null, "Eine Datenbank darf kein '\\' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Verhinder "
        if (uberschrift.contains("\"")) {
            JOptionPane.showMessageDialog(null, "Eine Datenbank darf kein '\"' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Verhinder Zeichenfehler
        if (uberschrift.contains("µ") || uberschrift.contains("!") || uberschrift.contains("?") || uberschrift.contains("<") || uberschrift.contains(">")) {
            JOptionPane.showMessageDialog(null, "zeichenfehler", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Combowert besorgen
        ccheck = Voktopus.combocheck;
        
        /*
        //verzeichnis erstellen
        File f = new File("vdata");
        if (f.exists() && f.isDirectory()) {
            System.out.println("Verzeichnis vdata/ bereits erstellt");
        }else {
            f.mkdir(); //Verzeichnis kann ohne Probleme erstellt werden
            profil = JOptionPane.showInputDialog("Bitte geben Sie einen Namen für das Profil an: ");
        }
        */
        
        //verzeichnis erstellen
        File f1 = new File("vdata/" + profil + "/pool"); //Verzeichnis kann ohne Probleme erstellt werden
        f1.mkdir();
        
        //verzeichnis erstellen
        File f2 = new File("vdata/" + profil + "/kasten"); //Verzeichnis kann ohne Probleme erstellt werden
        f2.mkdir();
        
        //Ordner zum speichern festlegen
        String ordner;
        
        if (ccheck == 0) {
          ordner = "pool";
        }else{
            ordner = "kasten";
        }
        
        System.out.println("In Ordner: " + ordner);
        
        //Speichern
        try {

			String content = ccheck + "\n" + uberschrift + "\n" + inhalt + "\n" + losung;

			File file = new File("vdata/" + profil + "/" + ordner + "/" + uberschrift + ".vpus");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done \t=> Output from FileWriter\n");
                        this.hide();
                        JOptionPane.showMessageDialog(null, "Erfolgreich!", "Information", JOptionPane.INFORMATION_MESSAGE);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //Scan nach änderung für sysinit
        sysinit.poolscan();
        sysinit.scan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        //Hilfe
        JOptionPane.showMessageDialog(null, "Bitte füllen Sie das Feld Überschrift aus!\n"
                + "Die Angabe zum Inhalt hat keine Begrenzung.\n"
                + "Das Feld Lösung ist Optional. Falls Sie keine Lösung wünschen, lassen Sie es bitte leer!\n"
                + "\n"
                + "Feedback bitte an: 'MrFlyingToasterman@yahoo.de'", "Hilfe zu Datenbanken", JOptionPane.INFORMATION_MESSAGE);
        abgleich();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(sysinput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sysinput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sysinput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sysinput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sysinput().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
