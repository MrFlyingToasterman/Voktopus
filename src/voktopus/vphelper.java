package voktopus;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Darius Musiolik
 */
public class vphelper {
    
    public String leistungsindex_lesen(String vprofil) {
        
        String wiedergabe = "Fehler";
        
        try {
            FileReader fr = new FileReader("vdata/" + vprofil + ".xvpus");
            BufferedReader br = new BufferedReader(fr);
             wiedergabe = br.readLine();
            br.close();
        } catch (Exception e) {
        }
        
        return wiedergabe;
    }
    
    public static void themeuse(String theme) {
        
        vphelper scall = new vphelper();
        
        switch(theme) {
            case "hell":
                Voktopus.jPanel2.setBackground(Color.lightGray); //Hintergrund
                Voktopus.jButton3.setBackground(Color.gray); //Start Button
                Voktopus.jButton6.setBackground(Color.gray); //Einstellungen
                Voktopus.jButton5.setBackground(Color.gray); //Lösungsbutton
                Voktopus.jButton2.setBackground(Color.gray); //Ich wusste es Button
                Voktopus.jButton1.setBackground(Color.gray); //Ich wusste es Button
                Voktopus.jComboBox1.setBackground(Color.gray); //Combobox
                Voktopus.jLabel5.setForeground(Color.black); //Profil - Label
                Voktopus.jLabel6.setForeground(Color.BLUE); //Profilname - Label
                Voktopus.jLabel2.setForeground(Color.black); //Vokabelkasten - Label
                Voktopus.jLabel7.setForeground(Color.BLUE); //Leistungsindex - Label
                Voktopus.jLabel3.setForeground(Color.black); //Mommentane Datenbank anbindung: - Label
                Voktopus.jLabel4.setForeground(Color.BLUE); //Datenbank - Label
                Voktopus.jLabel1.setForeground(Color.GRAY); //Version - Label
                
                break;
            case "blau":
                Voktopus.jPanel2.setBackground((new Color(0,59,111))); //Hintergrund
                Voktopus.jButton3.setBackground((new Color(76,117,154))); //Start Button
                Voktopus.jButton6.setBackground((new Color(76,117,154))); //Einstellungen
                Voktopus.jButton5.setBackground((new Color(76,117,154))); //Lösungsbutton
                Voktopus.jButton2.setBackground((new Color(76,117,154))); //Ich wusste es Button
                Voktopus.jButton1.setBackground((new Color(76,117,154))); //Ich wusste es Button
                Voktopus.jComboBox1.setBackground((new Color(76,117,154))); //Combobox
                Voktopus.jLabel5.setForeground(Color.lightGray); //Profil - Label
                Voktopus.jLabel6.setForeground(Color.white); //Profilname - Label
                Voktopus.jLabel2.setForeground(Color.lightGray); //Vokabelkasten - Label
                Voktopus.jLabel7.setForeground(Color.white); //Leistungsindex - Label
                Voktopus.jLabel3.setForeground(Color.lightGray); //Mommentane Datenbank anbindung: - Label
                Voktopus.jLabel4.setForeground(Color.white); //Datenbank - Label
                Voktopus.jLabel1.setForeground((new Color(60,93,123))); //Version - Label
                Voktopus.jTextArea1.setBackground((new Color(177,190,202))); //Hintergrung Haupttextbox
                break;
            case "dunkel":
                //Nichts unternemen da Standart
                break;
            default:
            scall.alert_err("Bitte überprüfen Sie ihre deepsettings.xvpus auf Fehler!", "Theme verarbeitungsfehler");
            break;
        }
    }
    
    public String deepsettings_lesen(String wert) {
        
        String wiedergabe = "Fehler";
        String filter = "";
        
        try {
            FileReader fr = new FileReader("vdata/deepsettings.xvpus");
            BufferedReader br = new BufferedReader(fr);
               
            while(wiedergabe != null) {
                wiedergabe = br.readLine();
                
                if (wiedergabe.contains(wert)) {
                    break;
                }
            }
            int counter = 0;
            for (int i = 0; i < wiedergabe.length(); i++) {
                if (wiedergabe.charAt(i) == ':') {
                    break;
                }
                counter++;
            }
      
            for (int i = counter + 1; i < wiedergabe.length()-1;i++) {
                filter = filter + wiedergabe.charAt(i);
            }
            
            br.close();
        } catch (Exception e) {
        }
        
        return filter;
    }
    
    public static int counter; //Suche für auszutauschende Zeile
    public static int bufferflow; //Suche nach arraylänge
    public static int break_int;
    public static String array_ueberfuehrung;
    
    public void deepsettings_schreiben(String wert, String attribut) {
        
        String suche = "Fehler";
        
        System.out.println("Lauf 1");
        
        //Zähle die länge der savedatei
        counter = -1;
        bufferflow = 0;
        break_int = 666;
        array_ueberfuehrung = "";
        
        try {
            FileReader fr = new FileReader("vdata/deepsettings.xvpus");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Lauf 1,4");
            
            while(break_int != 0) {
                System.out.println("Lauf 1,5");
                if (br.readLine() != null) {
                    bufferflow++;
                    System.err.println("Bufferflow " + bufferflow);
                }else{
                    System.err.println("have a break");
                    break_int = 0;
                }
                
            }
            
            System.out.println("Lauf 2");
   
            br.close();
        } catch (Exception e) {
        }
        
        //Suche die Zeile mit dem gewünschten Wert
        try {
            FileReader fr = new FileReader("vdata/deepsettings.xvpus");
            BufferedReader br = new BufferedReader(fr);
            
            while(!suche.startsWith(wert)) {
                suche = br.readLine();
                counter++;
            }
            br.close();
        } catch (Exception e) {
        }
        
        System.out.println("Lauf 3");
        
        //Arraylänge setzen
        String buffer[] = new String[bufferflow];
        
        //Lese Alles in einen Array bis eine Zeile leer ist
        try {
            FileReader fr = new FileReader("vdata/deepsettings.xvpus");
            BufferedReader br = new BufferedReader(fr);
            
            System.err.println("Bufferflow " + bufferflow);
            
            System.out.println("Lauf 4");
            
            for(int i = 0;i < bufferflow; i++) {
                
                System.err.println("VALID");
                System.out.println("Lauf 5");
                
                array_ueberfuehrung = br.readLine();
                
                if (array_ueberfuehrung != null) {
                    buffer[i] = array_ueberfuehrung;
                }
                
            }
            br.close();
        } catch (Exception e) {
        }
        
        System.out.println("Lauf 6");
        
        //Ersetze den eintrag im Array
        buffer[counter] = wert + ":" + attribut + ";";
        System.out.println("Lauf 7");
        
        //Schreibe das array
        vphelper vh = new vphelper();
        vh.a_xwrite("deepsettings", "vdata/", buffer);
        
    }
    
    public void alert_err(String content, String kopf) {
        JOptionPane.showMessageDialog(null, content, kopf, JOptionPane.ERROR_MESSAGE);
    }
    
    public void alert_info(String content, String kopf) {
        JOptionPane.showMessageDialog(null, content, kopf, JOptionPane.INFORMATION_MESSAGE);
    }
    
     public String alert_input(String frage) {
         return JOptionPane.showInputDialog(frage);
     }
    
    public void write(String file, String localation, String content) {
        
        try {
        
        File file2write = new File(localation + file + ".vpus");

			// Falls nicht vorhanden, erstellen!
			if (!file2write.exists()) {
				file2write.createNewFile();
			}

			FileWriter fw = new FileWriter(file2write.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done -" + file + ".vpus\t=> Output from vh.write\n");
                        
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void xwrite(String file, String localation, String content) {
        
        try {
        
        File file2write = new File(localation + file + ".xvpus");

			// Falls nicht vorhanden, erstellen!
			if (!file2write.exists()) {
				file2write.createNewFile();
			}

			FileWriter fw = new FileWriter(file2write.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done -" + file + ".xvpus\t=> Output from vh.write\n");
                        
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void a_xwrite(String file, String localation, String[] content) {
        
        String print = "";
        
        try {
        
        File file2write = new File(localation + file + ".xvpus");
        
        for(int i = 0; i < content.length; i++) {
            print = print + content[i] + "\n";
        }

			// Falls nicht vorhanden, erstellen!
			if (!file2write.exists()) {
				file2write.createNewFile();
			}

			FileWriter fw = new FileWriter(file2write.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(print);
			bw.close();

			System.out.println("Done -" + file + ".vpus\t=> Output from vh.write\n");
                        
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
