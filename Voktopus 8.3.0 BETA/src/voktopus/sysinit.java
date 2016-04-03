package voktopus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.swing.JOptionPane;
import static voktopus.Voktopus.profil;
import static voktopus.Voktopus.uberschrift;

/**
 *
 * @author Darius Musiolik
 */
public class sysinit extends javax.swing.JFrame {

    private String[] args;
    public static String mark;
    public static String mark2;
    public static int prio;
    public static String uberschrift;
    public static String inhalt;
    public static String losung;
    
    public static int datalang;
    
    public static String suchwert;
    
    
    public static boolean check0 = false;
    public static boolean check1 = false;

    /**
     * Creates new form sysinit
     */
    public sysinit() {
        initComponents();
        pscan();
        poolscan();
        scan();
    }
    
    public static void pscan() {
        jLabel5.setText(profil);
    }
    
    public static void poolscan() {
        
        //Daten Lesen
        File dir = new File("vdata/" + profil + "/pool");
   
        String[] children = dir.list();
        int untersuchung = 0;
        int poollang = -1;
        
            if (children == null) {
                //nicht vorhanden
                //JOptionPane.showMessageDialog(null, "KEINE SPEICHERDATEI VORHANDEN!", "DATENBANK NICHT GEFUNDEN!", JOptionPane.ERROR_MESSAGE);
                System.out.println("Keine Datenbanken gefunden!");
                
                //Leer anzeigen lassen!
                String[] leer = {"Keine Einträge!"};
                jList1.setListData(leer);
                jList2.setListData(leer);
                
                check0 = false;
                return;
            } else {
                check0 = true;
                for (int i=0; i<children.length; i++) {
                String filename = children[i];
                System.out.println(children[i] + "\t=> Output from File scan");
                
                    try {
                        FileReader fr = new FileReader("vdata/" + profil + "/pool/" + children[i]);
                        BufferedReader br = new BufferedReader(fr);
                        untersuchung = br.read();
                        br.close();
                    } catch (Exception e) {
                    }//End of Try
                     untersuchung = untersuchung -48;
                    
                    if (untersuchung == 0) {
                        poollang++;
                    }else{
                        try {
                            Files.move(Paths.get("vdata/" + profil + "/pool/" + children[i]), Paths.get("vdata/" + profil + "/kasten/" + children[i]));
                        } catch (Exception e) {
                        } 
                    }//End of if2
                    
                }//End of for 
                 
                untersuchung = 0; //Saubermachmann
                String[] pool = new String[poollang+1];
                int poollaufer = -1;
                
                for (int i=0; i<children.length; i++) {
                
                    try {
                        FileReader fr = new FileReader("vdata/" + profil + "/pool/" + children[i]);
                        BufferedReader br = new BufferedReader(fr);
                        untersuchung = br.read();
                        br.close();
                    } catch (Exception e) {
                    }//End of Try
                    
                        untersuchung = untersuchung -48;
                        if (untersuchung == 0) {
                            poollaufer++;
                            pool[poollaufer] = children[i];                      
                        }//End of if3
                    
                }//End of for 
                
                Arrays.sort(pool);
                jList1.setListData(pool);
                
                jLabel7.setText("Datenbanken im Pool: " + pool.length);
            }//End of if
    }//End of poolscan
    
    public static void scan() {
        
        //Daten Lesen
        File dir = new File("vdata/" + profil + "/kasten");
   
        String[] children = dir.list();
        int untersuchung = 0;
        int kastenlang = -1;
        
            if (children == null) {
                //nicht vorhanden
                //JOptionPane.showMessageDialog(null, "KEINE SPEICHERDATEI VORHANDEN!", "DATENBANK NICHT GEFUNDEN!", JOptionPane.ERROR_MESSAGE);
                System.out.println("Keine Datenbanken gefunden!");
                check1 = false;
                //Leer anzeigen lassen!
                String[] leer = {"Keine Einträge!"};
                jList1.setListData(leer);
                jList2.setListData(leer);
                return;
            } else {
                check1 = true;
                for (int i=0; i<children.length; i++) {
                String filename = children[i];
                System.out.println(children[i] + "\t=> Output from File kastenscan");
                
                    try {                    
                        FileReader fr = new FileReader("vdata/" + profil + "/kasten/" + children[i]);
                        BufferedReader br = new BufferedReader(fr);
                        untersuchung = br.read();
                        System.out.println("untersuchung1: " + untersuchung);
                        br.close();
                    } catch (Exception e) {
                    }//End of Try
                    
                    untersuchung = untersuchung -48;
                    
                    if (untersuchung == 0) {
                        try {
                            Files.move(Paths.get("vdata/" + profil + "/kasten/" + children[i]), Paths.get("vdata/" + profil + "/pool/" + children[i]));
                        } catch (Exception e) {
                        } 
                    }else{
                        kastenlang++;
                        
                    }//End of if2
                    
                }//End of for 
                
                untersuchung = 0; //Saubermachmann
                String[] kasten = new String[kastenlang+1];
                int laufer = -1;
                
                for (int i=0; i<children.length; i++) {
                
                    try {
                        FileReader fr = new FileReader("vdata/" + profil + "/kasten/" + children[i]);
                        BufferedReader br = new BufferedReader(fr);
                        untersuchung = br.read();
                        br.close();
                    } catch (Exception e) {
                    }//End of Try
                        untersuchung = untersuchung -48; 
                        if (untersuchung != 0) {
                            laufer++;
                            kasten[laufer] = children[i];
                        }//End of if3
                    
                }//End of for 
                
                Arrays.sort(kasten);
                jList2.setListData(kasten);
                
                jLabel6.setText("Datenbanken im Karteisystem: " + kasten.length);
            }//End of if
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setTitle("Datenbanken-konfiguration");
        setLocation(new java.awt.Point(300, 200));
        setResizable(false);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Noch keine Datenbanken!"};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Löschen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Karteikasten:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pool", "Erster Kasten", "Zweiter Kasten", "Dritter Kasten", "Vierter Kasten" }));
        jComboBox1.setEnabled(false);

        jLabel2.setText("Überschrift:");

        jTextField1.setEnabled(false);

        jLabel3.setText("Frage:");

        jTextField2.setEnabled(false);

        jLabel4.setText("Lösung:");

        jTextField3.setEnabled(false);

        jButton2.setText("Bearbeiten");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Neu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Speichern");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Suche");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Noch keine Datenbanken!"};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.setEnabled(false);
        jScrollPane2.setViewportView(jList2);

        jButton6.setText("=>");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("<=");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cantarell", 3, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(62, 64, 207));
        jLabel6.setText("Datenbanken im Karteisystem");

        jLabel7.setFont(new java.awt.Font("Cantarell", 3, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(62, 64, 207));
        jLabel7.setText("Datenbanken im Pool");

        jButton8.setText("Pool");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Profile");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("OK");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 3, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(62, 64, 207));
        jLabel5.setText("jLabel5");

        jLabel8.setText("Profil:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Neu
        sysinput.main(args);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void markin() {
        mark = jList1.getSelectedValue();
    }
    
    public static void markin2() {
        mark2 = jList2.getSelectedValue();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Löschen Funktion
        
        //Einlesen der markierung
        markin();
        
         //Wenn man Löschen drückt obwohl nichts ausgewählt ist
        if (jList1.getSelectedValue() == null) {
             JOptionPane.showMessageDialog(null, "Bitte wählen Sie zuerst eine Datenbank aus!", "Void!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Sicherheitsfrage "Sind Sie sicher dass Sie NAME Löschen wollen ?"
        int reply = JOptionPane.showConfirmDialog(null, "Sind Sie sicher dass Sie " + mark + " löschen wollen ?", "Bestätigen", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.out.println("Löschen vom User bestätigt!");
        }
        else {
           JOptionPane.showMessageDialog(null, "Abgebrochen!");
           return;
        }
        
        //Löschen der gewählten Datei
        try{
    		
    		File file = new File("vdata/" + profil + "/pool/" + mark);
        	
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){}
        
        
        //reload
        scan();
        poolscan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Bearbeiten von Datenbanken
        
        //Wenn man Bearbeiten drückt obwohl nichts ausgewählt ist
        if (jList1.getSelectedValue() == null) {
             JOptionPane.showMessageDialog(null, "Bitte wählen Sie zuerst eine Datenbank aus!", "Void!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        markin();
        
        try {
            FileReader fr = new FileReader("vdata/" + profil + "/pool/" + mark);
            BufferedReader br = new BufferedReader(fr);
            prio = br.read();
            br.readLine();
            uberschrift = br.readLine();
            inhalt = br.readLine();
            losung = br.readLine();
            br.close();
        } catch (Exception e) {
        }
        
        //Priorität anzeigen
                //System.out.println(prio);
        prio = prio -48;
        jComboBox1.setSelectedIndex(prio);
        jComboBox1.setEnabled(true);
        
        //Überschrift anzeigen
        jTextField1.setText(uberschrift);
        jTextField1.setEnabled(true);
        
        //Inhalt anzeigen
        jTextField2.setText(inhalt);
        jTextField2.setEnabled(true);
        
        //Lösung anzeigen
        jTextField3.setText(losung);
        jTextField3.setEnabled(true);
        
        //Buttonrechte
        jButton4.setEnabled(true); //Speichernbutton
        jButton1.setEnabled(false); //Löschen Button
        jButton2.setEnabled(false); //Bearbeiten Button
        jButton3.setEnabled(false); //Neu Button
        jButton5.setEnabled(false); //Suchen Button
        jButton8.setEnabled(false); //Pool Button
        jButton9.setEnabled(false); //Profile button
        jList1.setEnabled(false); //Liste deaktiviren
        
        System.out.println("Sysinit => read ready.");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Speichern Button
        
        //Überschrift prüfen
        if (uberschrift.equals("")) {
            JOptionPane.showMessageDialog(null, "Datenbank0 kann nicht Void sein!", "Datenbanken Fehler", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Überschrift Prüfen!", "Datenbank0 Void", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        prio = jComboBox1.getSelectedIndex();
        uberschrift = jTextField1.getText();
        inhalt = jTextField2.getText();
        losung = jTextField3.getText();
        
        //Löschen der alten Datei
        try{
    		
    		File file = new File("vdata/" + profil + "/pool/" + mark);
        	
    		if(file.delete()){
    			System.out.println("\n" + file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){}
        
        //Speichern
        try {

			String content = prio + "\n" + uberschrift + "\n" + inhalt + "\n" + losung;

			File file = new File("vdata/" + profil + "/pool/" + uberschrift + ".vpus");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

                        
                        //Buttonrechte
                        jButton4.setEnabled(false); //Speichernbutton
                        jButton1.setEnabled(true); //Löschen Button
                        jButton2.setEnabled(true); //Bearbeiten Button
                        jButton3.setEnabled(true); //Neu Button
                        jButton5.setEnabled(true); //Suchen Button
                        jList1.setEnabled(true); //Liste aktiviren
                        jButton8.setEnabled(true); //Pool Button
                        jButton9.setEnabled(true); //Profil Button
        
                        jComboBox1.setEnabled(false);
                        jTextField1.setEnabled(false);
                        jTextField2.setEnabled(false);
                        jTextField3.setEnabled(false);
			System.out.println("Done \t=> Output from FileWriter\n");
                        JOptionPane.showMessageDialog(null, "Erfolgreich!", "Information", JOptionPane.INFORMATION_MESSAGE);
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
        
                        jComboBox1.setSelectedIndex(0);
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
        
        System.out.println("Sysinit => write ready.");
        
        
        poolscan();
        scan();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Suchen Funktion
        suchwert= JOptionPane.showInputDialog("Suche: ");
        
        int start = 0;
        int suche = jList1.getNextMatch(suchwert, start, javax.swing.text.Position.Bias.Forward);
        
        if (suche == -1) {
            JOptionPane.showMessageDialog(null, "Keine Treffer!", "Achtung!", JOptionPane.ERROR_MESSAGE);
        }
        
        jList1.setSelectedIndex(suche);
        System.out.println("Suchwert = " + suche);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // Pool Button
        poolscan();
        scan();
        //Buttonrechte
        jButton1.setEnabled(false); //Löschen Button
        jButton2.setEnabled(false); //Bearbeiten Button
        jButton3.setEnabled(false); //Neu Button
        jButton5.setEnabled(false); //Suchen Button
        jButton8.setEnabled(false); //Poolbutton
        jButton9.setEnabled(false); //Profil Button
        
        jButton6.setEnabled(true); //In Kasten schieben Button
        jButton7.setEnabled(true); //In Pool schieben Button
        jButton10.setEnabled(true); //Bestätigungsbutton
        jList2.setEnabled(true); //JList Freigeben
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Aus pool nach kasten
        markin();
        
        if (mark == null) {
            return;
        }
        
        //Den ganzen Spaß in den Arbeitsspeicher laden
        try {
            FileReader fr = new FileReader("vdata/" + profil + "/pool/" + mark);
            BufferedReader br = new BufferedReader(fr);
            prio = br.read();
            br.readLine();
            uberschrift = br.readLine();
            inhalt = br.readLine();
            losung = br.readLine();
            br.close();
        } catch (Exception e) {
        }
        
        //Löschen der alten Datei
        try{
    		
    		File file = new File("vdata/" + profil + "/pool/" + mark);
        	
    		if(file.delete()){
    			System.out.println("\n" + file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){}
        
        //Speichern
        try {

			String content = "1" + "\n" + uberschrift + "\n" + inhalt + "\n" + losung;

			File file = new File("vdata/" + profil + "/pool/" + mark);

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
        poolscan();
        scan();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // bestätigung von Pooländerung
        
        //Buttonrechte
        jButton1.setEnabled(true); //Löschen Button
        jButton2.setEnabled(true); //Bearbeiten Button
        jButton3.setEnabled(true); //Neu Button
        jButton5.setEnabled(true); //Suchen Button
        jButton6.setEnabled(false); //In Kasten schieben Button
        jButton7.setEnabled(false); //In Pool schieben Button
        jButton8.setEnabled(true); //Pool Button
        jButton9.setEnabled(true); //Profil Button
        jButton10.setEnabled(false); //Bestätigen Button
        jList2.setEnabled(false); //JList wieder Sperren
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Von Kasten nach Pool
        markin2();
        
        if (mark2 == null) {
            return;
        }
        
        //Den ganzen Spaß in den Arbeitsspeicher laden
        try {
            FileReader fr = new FileReader("vdata/" + profil + "/kasten/" + mark2);
            BufferedReader br = new BufferedReader(fr);
            prio = br.read();
            br.readLine();
            uberschrift = br.readLine();
            inhalt = br.readLine();
            losung = br.readLine();
            br.close();
        } catch (Exception e) {
        }
        //Löschen der alten Datei
        try{
    		
    		File file = new File("vdata/" + profil + "/kasten/" + mark2);
        	
    		if(file.delete()){
    			System.out.println("\n" + file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	   
    	}catch(Exception e){}
        
        prio = prio - 48;
   
        //Speichern
        try {

			String content = "0" + "\n" + uberschrift + "\n" + inhalt + "\n" + losung;

			File file = new File("vdata/" + profil + "/pool/" + mark2);

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
        
        poolscan();
        scan();
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // Profile
        sysprofile.main(args);
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(sysinit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sysinit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sysinit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sysinit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sysinit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JList<String> jList1;
    public static javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
