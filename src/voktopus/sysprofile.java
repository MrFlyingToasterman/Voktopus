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
public class sysprofile extends javax.swing.JFrame {

    public static String mark3;
    vphelper vh = new vphelper();

    /**
     * Creates new form sysprofile
     */
    public sysprofile() {
        initComponents();
        profscan();
        setwindowname("Mommentan ausgewähltes Profil: " + profil);
    }

    public void setwindowname(String name) {
        this.setTitle(name);
    }

    public static void profscan() {
        File file = new File("vdata/"); // Lese inhalte
        String[] files = file.list();
        int xvpuszahler = 0;

        //Zählen der xvpus Dateien
        for (int i = 0; i < files.length; i++) {
            if (files[i].contains(".xvpus")) {
                xvpuszahler++;
            }
        }

        //xvpuszähler wert ausgeben
        System.out.println("xvpuszählerwert = " + xvpuszahler);
        System.out.println("Files Bounds = " + files.length);

        // cleanfiles Array anlegen mit angepassten Bounds
        String[] cleanfiles = new String[files.length - xvpuszahler];
        //xvpus Daten auslassen
        int i2 = -1;
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
            if (files[i].contains(".xvpus")) {
                System.out.println("xpus berücksichtigt");
            } else {
                i2++;
                cleanfiles[i2] = files[i];
                System.out.println("cleanfiles bounds = " + cleanfiles.length);
            }
        }

        jList1.setListData(cleanfiles);
        Voktopus.leistungslesen();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setTitle("Profile");
        setLocation(new java.awt.Point(200, 300));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "KEINE DATEN GEFUNDEN!" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Neues Profil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Profil Löschen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Profil Umbenennen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton4.setText("Profil Aktiviren");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Neues Profil
        String nprofil = JOptionPane.showInputDialog("Bitte geben Sie einen Namen für das Profil an: ");

        if (nprofil == null) {
            System.out.println("NullPointerExeption gefangen");
            return;
        }

        //Verhinder dass es leer oder leerzeichen ist
        if (nprofil.contains(" ")) {
            JOptionPane.showMessageDialog(null, "Ein Profil darf nicht Void sein!!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Verhinder zahlen am Anfan
        if (nprofil.startsWith("1") || nprofil.startsWith("2") || nprofil.startsWith("3") || nprofil.startsWith("4") || nprofil.startsWith("5") || nprofil.startsWith("6") || nprofil.startsWith("7") || nprofil.startsWith("8") || nprofil.startsWith("9") || nprofil.startsWith("0")) {
            JOptionPane.showMessageDialog(null, "Ein Profil darf nicht mit einer Zahl anfangen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Verhinder /
        if (nprofil.contains("/")) {
            JOptionPane.showMessageDialog(null, "Ein Profil darf kein '/' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Verhinder dass sys.xvpus erstellt wird
        if (nprofil.equalsIgnoreCase("sys.xvpus")) {
            JOptionPane.showMessageDialog(null, "Sie können die Systemdatenbank nicht erstellen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Verhinder .
        if (nprofil.contains(".")) {
            JOptionPane.showMessageDialog(null, "Ein Profil darf kein '.' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File proff = new File("vdata/" + nprofil);
        proff.mkdir();

        //Leistungsindex erstellen
        vh.xwrite(nprofil, "vdata/", "0x0");

        profscan(); //neue Profile suchen
        setwindowname("Mommentan ausgewähltes Profil: " + profil); //namen anpassen
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Profil Aktiviren

        mark3 = jList1.getSelectedValue();

        //Verhinder dass sys.xvpus geladen wird
        if (mark3.equalsIgnoreCase("sys.xvpus")) {
            JOptionPane.showMessageDialog(null, "Sie können die Systemdatenbank nicht laden!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        profil = jList1.getSelectedValue();

        //Speichern
        try {

            String content = profil;

            File file = new File("vdata/sys.xvpus");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Done \t=> Output from FileWriter\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        Voktopus.leistungslesen();
        sysinit.pscan();
        sysinit.poolscan();
        //JOptionPane.showMessageDialog(null, "who u gonna call ?", "Abbruch", JOptionPane.ERROR_MESSAGE);
        sysinit.scan();
        Voktopus.profild();

        setwindowname("Mommentan ausgewähltes Profil: " + profil); //namen anpassen
        JOptionPane.showMessageDialog(null, profil + " wurde erfolgreich geladen!", "Erfolgreich!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Profil löschen

        //mark3 updaten
        mark3 = jList1.getSelectedValue();

        //Prüfe ob Profil geladen ist
        if (mark3.equalsIgnoreCase(profil)) {
            JOptionPane.showMessageDialog(null, "Sie können kein aktiviertes Profil löschen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Verhinder dass sys.xvpus gelöscht wird
        if (mark3.equalsIgnoreCase("sys.xvpus")) {
            JOptionPane.showMessageDialog(null, "Sie können die Systemdatenbank nicht löschen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Sicherheitsfrage "Sind Sie sicher dass Sie NAME Löschen wollen ?"
        int reply = JOptionPane.showConfirmDialog(null, "Sind Sie sicher dass Sie " + mark3 + " löschen wollen ?", "Bestätigen", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.out.println("Löschen vom User bestätigt!");
        } else {
            JOptionPane.showMessageDialog(null, "Abgebrochen!");
            return;
        }

        //Löschen der gewählten Datei
        try {

            File file = new File("vdata/" + mark3);

            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }

        } catch (Exception e) {
        }

        Voktopus.leistungslesen();
        //reload
        profscan(); //neue Profile suchen
        setwindowname("Mommentan ausgewähltes Profil: " + profil); //namen anpassen
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // profil umbenennen
        mark3 = jList1.getSelectedValue();

        //Prüfe ob Profil geladen ist
        if (mark3.equalsIgnoreCase(profil)) {
            JOptionPane.showMessageDialog(null, "Sie können kein aktiviertes Profil umbennenen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String eingabe;

        eingabe = JOptionPane.showInputDialog("Geben Sie einen neuen Namen ein.");
        if (eingabe == null) {
            System.out.println("Abbruch");
            return;
        }

        File alt = new File("vdata/" + mark3);
        File neu = new File("vdata/" + eingabe);

        alt.renameTo(neu);

        Voktopus.leistungslesen();
        //reload
        profscan(); //neue Profile suchen
        setwindowname("Mommentan ausgewähltes Profil: " + profil); //namen anpassen
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(sysprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sysprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sysprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sysprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sysprofile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
