package voktopus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Darius Musiolik
 */
public class vphelper {
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
}
