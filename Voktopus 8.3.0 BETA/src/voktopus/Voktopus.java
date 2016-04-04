package voktopus;

import java.io.*;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author Darius Musiolik
 */
public class Voktopus extends javax.swing.JFrame {

    public static String version = "0.8.3.0 BETA";
    public static String prio;
    public static String uberschrift;
    public static String inhalt;
    public static String losung;
    public static String auslese = "keine";
    public static boolean startbtn = true;
    public static int untersuchung;
    public static int combocheck;
    public static boolean repeter;
    public static String ordner;
    public static String profil;
    
    private String[] args;
    
    public Voktopus() {
        initComponents();
        jLabel1.setText("Voktopus " + version);
        jLabel4.setText(auslese);
        
        //verzeichnis erstellen
        File f = new File("vdata");
        if (f.exists() && f.isDirectory()) {
            System.out.println("Verzeichnis vdata/ bereits erstellt");
        }else {
            profil = JOptionPane.showInputDialog("Bitte geben Sie einen Namen für das Profil an: ");
            
            //Verhinder dass es leer oder leerzeichen ist
            if (profil.equalsIgnoreCase("") || profil.contains(" ")) {
                JOptionPane.showMessageDialog(null, "Ein Profil darf nicht Void sein!!", "Programm Ende", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            
            //Verhinder |
            if (profil.contains("|")) {
                JOptionPane.showMessageDialog(null, "Ein Profil darf kein '/' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            
            //Verhinder \
            if (profil.contains("\\")) {
                JOptionPane.showMessageDialog(null, "Ein Profil darf kein '\\' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        
            //Verhinder "
            if (profil.contains("\"")) {
                JOptionPane.showMessageDialog(null, "Ein Profil darf kein '\"' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            
            f.mkdir(); //Verzeichnis kann ohne Probleme erstellt werden
            File proff = new File ("vdata/" + profil);           
            proff.mkdir();
            jLabel6.setText(profil);
            
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
            JOptionPane.showMessageDialog(null, "Erfolg!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
         //Letztes Profil Lesen
        try {
            FileReader fr = new FileReader("vdata/sys.xvpus");
            BufferedReader br = new BufferedReader(fr);
            profil = br.readLine(); //Profil update
            br.readLine();
            uberschrift = br.readLine();
            inhalt = br.readLine();
            losung = br.readLine();
            br.close();
        } catch (Exception e) {
        }
        profild();
    }
    
    public static void profild() {
        //Anzeige Setzen
        jLabel6.setText(profil);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voktopus");
        setLocation(new java.awt.Point(200, 100));

        jLabel1.setForeground(new java.awt.Color(137, 137, 137));
        jLabel1.setText("jLabel1");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("oooooo      oooo               oooo                      .                                             \n    `888.      .8'                   `888                   .o8                                             \n     `888.    .8'     .ooooo.      888    oooo   .o888oo   .ooooo.       oo.ooooo.     oooo    oooo       .oooo.o \n      `888. .8'    d88'    `88b    888 .8P'          888     d88'   `88b     888'   `88b    `888    `888      d88(     \"8 \n       `888.8'    888      888    888888.           888     888      888    888     888     888     888        `\"Y88b.  \n        `888'      888      888    888 `88b.         888 .   888      888    888     888     888     888      o.    )88b \n          `8'        `Y8bod8P'   o888o o888o      \"888\"   `Y8bod8P'     888bod8P'     `V88V\"V8P'     8\"\"888P' \n                                                     \t                                    888                            \n                                                        \t                                  o888o                           \n                                                                                        ");
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Ich wusste es nicht");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ich wusste es");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Start");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pool", "Erster Kasten", "Zweiter Kasten", "Dritter Kasten", "Vierter Kasten"}));

        jLabel2.setText("vokabelkasten:");

        jLabel3.setText("Mommentane Datenbankanbindung:");

        jLabel4.setForeground(new java.awt.Color(55, 52, 228));
        jLabel4.setText("jLabel4");

        jButton5.setText("Lösung");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Einstellungen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("Profil:");

        jLabel6.setFont(new java.awt.Font("Cantarell", 3, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(62, 64, 207));
        jLabel6.setText("Profilname / jlabel6");
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton5)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        //check ob daten da
        System.out.println("Untersuche!");
        
        //Daten Lesen
        File dir0 = new File("vdata/" + profil + "/pool");
        File dir1 = new File("vdata/" + profil + "/kasten");
   
        String[] children0 = dir0.list();
        String[] children1 = dir1.list();
        
            if (children0 == null && children1 == null) {
                JOptionPane.showMessageDialog(null, "Keine Datenbanken gefunden!", "Abbruch!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
        // Button FX
        jButton1.setEnabled(startbtn);
        jButton2.setEnabled(startbtn);
        jButton5.setEnabled(startbtn);
        jTextArea1.setEnabled(startbtn);
        
        if (startbtn == true) { //Start funktion
            startbtn = false;
            jButton3.setText("Stop");
            jComboBox1.setEnabled(startbtn);
            jButton6.setEnabled(startbtn);
            
             //System.out.println für Konsolen Log + Debuging
            System.out.println("Start Button Click");
            System.out.println("--------------------------");
        
            //Start => Einlesen von Datei
            run();
        
            
        }else{
            jButton5.setEnabled(startbtn);
            startbtn = true; //Stop Funktion
            jButton3.setText("Start");
            jButton6.setEnabled(startbtn);
            System.out.println("--------------------------");
            System.out.println("Stop Button Click");
            System.out.println("--------------------------");
            jComboBox1.setEnabled(true);
            jTextArea1.setText("oooooo      oooo               oooo                      .                                             \n    `888.      .8'                   `888                   .o8                                             \n     `888.    .8'     .ooooo.      888    oooo   .o888oo   .ooooo.       oo.ooooo.     oooo    oooo       .oooo.o \n      `888. .8'    d88'    `88b    888 .8P'          888     d88'   `88b     888'   `88b    `888    `888      d88(     \"8 \n       `888.8'    888      888    888888.           888     888      888    888     888     888     888        `\"Y88b.  \n        `888'      888      888    888 `88b.         888 .   888      888    888     888     888     888      o.    )88b \n          `8'        `Y8bod8P'   o888o o888o      \"888\"   `Y8bod8P'     888bod8P'     `V88V\"V8P'     8\"\"888P' \n                                                     \t                                    888                            \n                                                        \t                                  o888o                           \n                                                                                        ");
            this.setTitle("Voktopus");
            
            jLabel4.setText("keine");
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    public void run() {
        combocheck = jComboBox1.getSelectedIndex();
        
        if (combocheck == 0) {
            ordner = "pool";
        }else {
            ordner = "kasten";
        }
        
        System.out.println(ordner);
        
        //Daten Lesen
        File dir = new File("vdata/" + profil + "/" + ordner);
   
        String[] children = dir.list();
            if (children == null) {
                //nicht vorhanden
                System.out.println("keine datenbanken gefunden");
                
                
                // Button FX
                jButton1.setEnabled(startbtn);
                jButton2.setEnabled(startbtn);
                jButton5.setEnabled(startbtn);
                jTextArea1.setEnabled(startbtn);
                
                jButton5.setEnabled(startbtn);
                startbtn = true; //Stop Funktion
                jButton3.setText("Start");
                jButton6.setEnabled(startbtn);
                System.out.println("--------------------------");
                System.out.println("Stop Button Click");
                System.out.println("--------------------------");
                jComboBox1.setEnabled(true);
                jTextArea1.setText("oooooo      oooo               oooo                      .                                             \n    `888.      .8'                   `888                   .o8                                             \n     `888.    .8'     .ooooo.      888    oooo   .o888oo   .ooooo.       oo.ooooo.     oooo    oooo       .oooo.o \n      `888. .8'    d88'    `88b    888 .8P'          888     d88'   `88b     888'   `88b    `888    `888      d88(     \"8 \n       `888.8'    888      888    888888.           888     888      888    888     888     888     888        `\"Y88b.  \n        `888'      888      888    888 `88b.         888 .   888      888    888     888     888     888      o.    )88b \n          `8'        `Y8bod8P'   o888o o888o      \"888\"   `Y8bod8P'     888bod8P'     `V88V\"V8P'     8\"\"888P' \n                                                     \t                                    888                            \n                                                        \t                                  o888o                           \n                                                                                        ");
                this.setTitle("Voktopus");
                jLabel4.setText("keine");
                JOptionPane.showMessageDialog(null, "Keine Datenbanken gefunden!", "Abbruch!", JOptionPane.ERROR_MESSAGE);
                    return;
            } else {
                for (int i=0; i<children.length; i++) {
                String filename = children[i];
                System.out.println(children[i] + "\t=> Output from File dir");
                }
            }
         
            
                int bug = children.length * 2;
                int bag = 0;
                repeter = true;
           do {
               
            //System.out.println für Konsolen Log + Debuging
            System.out.println("--------------------------");
            
            //Zufällig Datei wählen
            Random zufall = new Random();
            if (children.length == 0) {
                System.out.println("children.length darf nicht null sein! Breche ab!");
                // Button FX
                jButton1.setEnabled(startbtn);
                jButton2.setEnabled(startbtn);
                jButton5.setEnabled(startbtn);
                jTextArea1.setEnabled(startbtn);
                
                jButton5.setEnabled(startbtn);
                startbtn = true; //Stop Funktion
                jButton3.setText("Start");
                jButton6.setEnabled(startbtn);
                System.out.println("--------------------------");
                System.out.println("Stop Button Click");
                System.out.println("--------------------------");
                jComboBox1.setEnabled(true);
                jTextArea1.setText("oooooo      oooo               oooo                      .                                             \n    `888.      .8'                   `888                   .o8                                             \n     `888.    .8'     .ooooo.      888    oooo   .o888oo   .ooooo.       oo.ooooo.     oooo    oooo       .oooo.o \n      `888. .8'    d88'    `88b    888 .8P'          888     d88'   `88b     888'   `88b    `888    `888      d88(     \"8 \n       `888.8'    888      888    888888.           888     888      888    888     888     888     888        `\"Y88b.  \n        `888'      888      888    888 `88b.         888 .   888      888    888     888     888     888      o.    )88b \n          `8'        `Y8bod8P'   o888o o888o      \"888\"   `Y8bod8P'     888bod8P'     `V88V\"V8P'     8\"\"888P' \n                                                     \t                                    888                            \n                                                        \t                                  o888o                           \n                                                                                        ");
                this.setTitle("Voktopus");
                jLabel4.setText("keine");
                JOptionPane.showMessageDialog(null, "Keine Datenbanken gefunden!", "Abbruch!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int zufallswert = zufall.nextInt(children.length);
            auslese = children[zufallswert];
            System.out.println(auslese + "\t=> Output from Random");
            
            //Random Auslese Untersuchen
            try {
            FileReader fr = new FileReader("vdata/" + profil + "/" + ordner + "/" + auslese);
            BufferedReader br = new BufferedReader(fr);
            untersuchung = br.read();
            br.close();
        } catch (Exception e) {
        }
            untersuchung = untersuchung -48;
            combocheck = jComboBox1.getSelectedIndex();
            
            System.out.println("\n" + combocheck + " => Output from combocheck\n");
            System.out.println("\n" + untersuchung + " => Output from untersuchung\n");
            if (untersuchung == combocheck) { 
                //auslese soll wert behalten und an gesamtausgabe weitergeben
                repeter = false;
            }else {
                repeter = true;
            }
            bag++;
            if (bag == bug){
                    repeter = false;
                    startbtn = true; //Stop Funktion
                    jButton3.setText("Start");
                    jButton1.setEnabled(false);
                    jButton2.setEnabled(false);
                    jTextArea1.setEnabled(false);
                    jLabel4.setText("keine");
                    jComboBox1.setEnabled(true);
                    jButton5.setEnabled(false);
                    jButton6.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Keine Datenbanken mehr in diesem Karteikasten!", "End of Stream!", JOptionPane.ERROR_MESSAGE);
                    jTextArea1.setText("oooooo      oooo               oooo                      .                                             \n    `888.      .8'                   `888                   .o8                                             \n     `888.    .8'     .ooooo.      888    oooo   .o888oo   .ooooo.       oo.ooooo.     oooo    oooo       .oooo.o \n      `888. .8'    d88'    `88b    888 .8P'          888     d88'   `88b     888'   `88b    `888    `888      d88(     \"8 \n       `888.8'    888      888    888888.           888     888      888    888     888     888     888        `\"Y88b.  \n        `888'      888      888    888 `88b.         888 .   888      888    888     888     888     888      o.    )88b \n          `8'        `Y8bod8P'   o888o o888o      \"888\"   `Y8bod8P'     888bod8P'     `V88V\"V8P'     8\"\"888P' \n                                                     \t                                    888                            \n                                                        \t                                  o888o                           \n                                                                                        ");
                    this.setTitle("Voktopus");
                    return;
               }
           }while(repeter); 
           
            //Gesamt Ausgabe
        try {
            FileReader fr = new FileReader("vdata/" + profil + "/" + ordner + "/" + auslese);
            BufferedReader br = new BufferedReader(fr);
            prio = br.readLine();
            uberschrift = br.readLine();
            inhalt = br.readLine();
            losung = br.readLine();
            br.close();
        } catch (Exception e) {
        }
        
        //System.out.println für Konsolen Log + Debuging
        System.out.println("--------------------------");
        System.out.println(uberschrift + "\t=> Output from uberschrift String");
        this.setTitle(uberschrift);
        System.out.println(inhalt + "\t=> Output from inhalt String");
        jTextArea1.setText(inhalt);
        System.out.println(losung + "\t=> Output from losung String");
        jLabel4.setText(auslese);
        
        //Lösungsbutton im Falle keiner Lösung entfernen
        if (losung.equalsIgnoreCase("Keine Lösung")) {
            jButton5.setEnabled(false);
            //System.out.println für Konsolen Log + Debuging
            System.out.println("--------------------------");
            System.out.println("Lösungsbutton Aus\t=> Output from losungscheck");
            System.out.println("--------------------------");
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            //Ich wusste es nicht button
//Konsolen Output 
        System.out.println("--------------------------");
        System.out.println("'Ich wusste es nicht' => Button Click");
        System.out.println("--------------------------");
        
        //Lösungsbutton Aktiviren
        jButton5.setEnabled(true);

    //Abgleich wegen Negativen zahlen
        switch (untersuchung) {
            case 1:
                //Nichts Unternemen
                break;
            case 0:
                //Nichts Unternemen
                break;
            default:
                untersuchung = 1;
                break;
        }
         //Speichern
        try {

			String content = untersuchung + "\n" + uberschrift + "\n" + inhalt + "\n" + losung;

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
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
        run();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Konsolen Output 
        System.out.println("--------------------------");
        System.out.println("'Ich wusste es' => Button Click");
        System.out.println("--------------------------");
        
        //Lösungsbutton Aktiviren
        jButton5.setEnabled(true);
        
        //Neue Hirachie 0 = Pool 1 -4 = Kästen
        
        //Abgleich wegen Negativen zahlen
        switch (untersuchung) {
            case 4:
                //Nichts Unternemen
                break;
            case 0:
                //Nichts Unternemen
                break;
            default:
                untersuchung++;
                break;
        }
        
        
         //Speichern
        try {

			String content = untersuchung + "\n" + uberschrift + "\n" + inhalt + "\n" + losung;

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
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
        run();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        JOptionPane.showMessageDialog(null, "Voktopus " + version + " by Darius Musiolik 2k16", "Über", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Lösung
        jTextArea1.setText(jTextArea1.getText() + "\n-------------------------------------------------------------\n" + losung);
        jButton5.setEnabled(false);
        
        //System.out.println für Konsolen Log + Debuging
            System.out.println("--------------------------");
            System.out.println("Lösungsbutton Click");
            System.out.println("--------------------------");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Datenbanken Bearbeiten
        combocheck = jComboBox1.getSelectedIndex();
        sysinit.main(args);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Voktopus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Voktopus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Voktopus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Voktopus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Voktopus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}