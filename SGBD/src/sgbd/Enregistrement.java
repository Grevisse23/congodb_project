/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd;

import static java.io.File.separator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony-Kis
 */
public class Enregistrement {
    public void newEnre(String[] tab, int i){
        String separateur = "|";
        String fileName = "Base_des_donnees/" + Donnees.BddName + "/Tables/" + Donnees.TableName;
        
        try(FileWriter writer = new FileWriter(fileName)){
            for(int m = 0; m < i; m++){
                writer.append(tab[m]);
                if(i < m){
                    writer.append(separator);
                }
            }
            writer.append(System.lineSeparator());
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
