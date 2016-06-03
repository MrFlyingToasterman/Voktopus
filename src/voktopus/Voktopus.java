package voktopus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author Darius Musiolik
 */
public class Voktopus extends javax.swing.JFrame {

    public static String version = "1.2.0.0 (testing)";
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
    public static String leistungsindex;
    public String theme = svh.deepsettings_lesen("color"); //Theme einlesen
    
    vphelper vh = new vphelper(); //oop
    static vphelper svh = new vphelper();//static oop
    
    private String[] args;
    
    public Voktopus() {
        initComponents();
        jLabel1.setText("Voktopus " + version);
        jLabel4.setText(auslese);
        
        if (version.contains("testing")) {
            vh.alert_info("Danke dass Sie eine >Testing< Version verwenden!\n"
                    + "Sie helfen mir damit das Programm zu verbessern!\n"
                    + "Aber vergessen Sie nicht dass diese Version unausgereift ist und fehler enthalten kann!\n"
                    + "Bitte Melden Sie (sofern Sie wünschen) alle Fehler die Sie finden an MrFlyingToasterman@yahoo.de\n\n"
                    + "Viel erfolg beim lernen! ~Der Entwickler", "Vielen Dank!");
        }
        
        //verzeichnis erstellen
        File f = new File("vdata");
        if (f.exists() && f.isDirectory()) {
            System.out.println("Verzeichnis vdata/ bereits erstellt");
        }else {
            boolean repeter0 = false;
          do {
            profil = vh.alert_input("Bitte geben Sie einen Namen für das Profil an: ");
            
            if (profil == null) {
                System.exit(0);
            }
            
            //Verhinder dass es leer oder leerzeichen ist
            if (profil.equalsIgnoreCase("") || profil.contains(" ")) {
                JOptionPane.showMessageDialog(null, "Ein Profil darf nicht Void sein!!", "Programm Ende", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
            //Verhinder |
            if (profil.contains("|")) {
                JOptionPane.showMessageDialog(null, "Ein Profil darf kein '/' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
            //Verhinder \
            if (profil.contains("\\")) {
                JOptionPane.showMessageDialog(null, "Ein Profil darf kein '\\' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
                continue;
            }
        
            //Verhinder "
            if (profil.contains("\"")) {
                JOptionPane.showMessageDialog(null, "Ein Profil darf kein '\"' enthalten!", "Abbruch", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
            repeter0 = false;
          } while (repeter0);                   
        
            
            f.mkdir(); //Verzeichnis kann ohne Probleme erstellt werden
            File proff = new File ("vdata/" + profil);           
            proff.mkdir();
            jLabel6.setText(profil);
            
            //Leistungsindex erstellen
            vh.xwrite(profil, "vdata/", "0x0");
            
            //deepsettings file erstellen
            vh.xwrite("deepsettings", "vdata/", "color:dunkel;\n"
                    + "beta:1;");
        
        //Letzten Leistungsindex Lesen
        leistungsindex = vh.leistungsindex_lesen(profil);
        
            
            //Speichern
            vh.xwrite("sys", "vdata/", profil);
            vh.alert_info("Erfolg!", "Info");
            profild();
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
        
        //Letzten Leistungsindex Lesen
        leistungsindex = vh.leistungsindex_lesen(profil);
        
        //Auswerten des themes
        svh.themeuse(theme);
        
        //Ausgabe des Themes
        System.out.println("Theme: " + theme);
        
        profild();
    }
    
    public static void leistungslesen() {
        //Letzten Leistungsindex Lesen
        leistungsindex = svh.leistungsindex_lesen(profil); //static oop
        profild();
    }
    
    public static void profild() {
        //Anzeige Setzen
        jLabel6.setText(profil);
        jLabel7.setText("Leistungsindex: " + leistungsindex);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
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
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Voktopus");
        setLocation(new java.awt.Point(200, 100));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

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
        jTextArea1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("oooooo      oooo               oooo                      .                                             \n    `888.      .8'                   `888                   .o8                                             \n     `888.    .8'     .ooooo.      888    oooo   .o888oo   .ooooo.       oo.ooooo.     oooo    oooo       .oooo.o \n      `888. .8'    d88'    `88b    888 .8P'          888     d88'   `88b     888'   `88b    `888    `888      d88(     \"8 \n       `888.8'    888      888    888888.           888     888      888    888     888     888     888        `\"Y88b.  \n        `888'      888      888    888 `88b.         888 .   888      888    888     888     888     888      o.    )88b \n          `8'        `Y8bod8P'   o888o o888o      \"888\"   `Y8bod8P'     888bod8P'     `V88V\"V8P'     8\"\"888P' \n                                                     \t                                    888                            \n                                                        \t                                  o888o                           \n                                                                                        ");
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Ich wusste es nicht");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Ich wusste es");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Start");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pool", "Erster Kasten", "Zweiter Kasten", "Dritter Kasten", "Vierter Kasten"}));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("vokabelkasten:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mommentane Datenbankanbindung:");

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("jLabel4");

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Lösung");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setText("Einstellungen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Profil:");

        jLabel6.setFont(new java.awt.Font("Cantarell", 3, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Profilname / jlabel6");
        jLabel6.setToolTipText("");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Leitungsindex: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        vh.alert_info("Voktopus " + version + " by Darius Musiolik 2k16"
            + "\nWebseite: https://github.com/MrFlyingToasterman/Voktopus", "Über");
    }//GEN-LAST:event_jLabel1MouseClicked

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
        vh.write(profil + "/" + ordner + "/" + uberschrift, "vdata/", untersuchung + "\n" + uberschrift + "\n" + inhalt + "\n" + losung);

        //Leistungsindex lesen
       leistungsindex = vh.leistungsindex_lesen(profil);

        //Leistungsindex Anpassen
        String ja = "";
        String nein = "";
        char iks = 'x';
        boolean janein = true;

        for(int i = 0;  i < leistungsindex.length(); i++) {
            System.out.println(i + " => " + leistungsindex.charAt(i));
            if (iks == leistungsindex.charAt(i)) {
                janein = false;
                continue;
            }
            if (janein == true) {
                ja = ja + leistungsindex.charAt(i);
            }else{
                nein = nein + leistungsindex.charAt(i);
            }
        }
        int neinint = Integer.parseInt(nein);
        neinint++;

        System.out.println(ja + " << " + neinint + " << " + nein);

        leistungsindex = ja + "x" + neinint;
        //Leistungsindex abspeichern
        vh.xwrite(profil, "vdata/", leistungsindex);

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
        vh.write(profil + "/" + ordner + "/" + uberschrift, "vdata/", untersuchung + "\n" + uberschrift + "\n" + inhalt + "\n" + losung);

        //Leistungsindex lesen
        leistungsindex = vh.leistungsindex_lesen(profil);

        //Leistungsindex Anpassen
        String ja = "";
        String nein = "";
        char iks = 'x';
        boolean janein = true;

        for(int i = 0;  i < leistungsindex.length(); i++) {
            System.out.println(i + " => " + leistungsindex.charAt(i));
            if (iks == leistungsindex.charAt(i)) {
                janein = false;
                continue;
            }
            if (janein == true) {
                ja = ja + leistungsindex.charAt(i);
            }else{
                nein = nein + leistungsindex.charAt(i);
            }
        }
        int jaint = Integer.parseInt(ja);
        jaint++;

        System.out.println(ja + " << " + jaint + " << " + nein);

        leistungsindex = jaint + "x" + nein;
        
        //Leistungsindex abspeichern
        vh.xwrite(profil, "vdata/", leistungsindex);

        run();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        System.err.println("jButton3 Event Startet");
        
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
            System.out.println("Start Button Click\n"
                    + "--------------------------");
            
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }

            //Start => Einlesen von Datei
            System.err.println("run(); call");
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

    public void run() {
        System.err.println("! Beginne run();\n");
        profild();
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
        System.err.println("! dir.list enthält:\n>");
        
        for(int i = 0; i < children.length; i++) {
            System.err.println(children[i]);
        }
        
        System.err.println("<");
        
            if (children == null) {
                //nicht vorhanden
                System.out.println("Keine datenbanken gefunden");
                
                
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
                JOptionPane.showMessageDialog(null, "Keine Datenbanken gefunden!", "Einlesefehler", JOptionPane.ERROR_MESSAGE);
                    return;
            } else {
                for (int i=0; i<children.length; i++) {
                String filename = children[i];
                System.out.println(children[i] + "\t=> Output from File dir TEST");
                }
            }
         
            
                int bug = children.length * 4 + 100; //Random Buffer
                int bag = 0;
                System.err.println("Randombuffer (bug) = " + bug);
                repeter = true;
           do {
            
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
                JOptionPane.showMessageDialog(null, "Keine Datenbanken gefunden!", "Random Fehler", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "Keine Datenbanken mehr in diesem Karteikasten!", "Randombuffer Overflow", JOptionPane.ERROR_MESSAGE);
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
        
        //Verarbeitung von inhalt
        System.out.println(inhalt + "\t=> Output from inhalt String");
        jTextArea1.setText(""); //Textbox leeren
        for(int i = 0; i < inhalt.length(); i++) {
            if (inhalt.charAt(i) != 'µ') {
                jTextArea1.setText(jTextArea1.getText() + inhalt.charAt(i));
            }else{
                jTextArea1.setText(jTextArea1.getText() + "\n");
            }
        }
        //jTextArea1.setText(inhalt);
        
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
    public static javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
