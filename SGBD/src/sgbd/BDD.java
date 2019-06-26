/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Anthony-Kis
 */
public class BDD {
    
    public BDD() {
        new File("Base_des_donnees").mkdir();
    }
    
    ObservableList<String> option = FXCollections.observableArrayList();
    ObservableList<String> option1 = FXCollections.observableArrayList();
    
    public String Ajouter(String NomBdd) {
        String Relation = "", Contrainte = "", fin =  " a été créé";
        File dossiers = new File("Base_des_donnees");
        for(File file : dossiers.listFiles()){
            if((file.isDirectory()) && (file.getName().equals(NomBdd)))
                return "La base de données n'a pas été créé car elle existe";
        }
        new File("Base_des_donnees/" + NomBdd).mkdir();
        new File("Base_des_donnees/" + NomBdd + "/Tables").mkdir();
        new File("Base_des_donnees/" + NomBdd + "/Relations").mkdir();
        new File("Base_des_donnees/" + NomBdd + "/Contraintes").mkdir();
        try(FileWriter fichier = new FileWriter("Base_des_donnees/" + NomBdd + "/Relations/relation.csv")){
            Relation = ", le fichier des relations";
            fin = " ont été créé";
        }catch(IOException e){ }
        try(FileWriter fichier = new FileWriter("Base_des_donnees/" + NomBdd + "/Contraintes/contriante.csv")){
            Contrainte = " et le fichier des contraintes";
            fin = " ont été créé";
        }catch(IOException e){ }
        return "La base des données" + Relation + Contrainte + fin;
    }
    
    public ObservableList<String> Recherche(){
        File dossier = new File("Base_des_donnees");
        for(File file : dossier.listFiles()){
            option.add(file.getName().toString());
        }
        return option;
    }
    
    public ObservableList<String> ListeTable(String NomBdd){
        File dossiers = new File("Base_des_donnees");
        
        for(File file : dossiers.listFiles()){
            if((file.isDirectory()) && (file.getName().equals(NomBdd))){
                File fichiers = new File("Base_des_donnees/" + NomBdd + "/Tables/");
                for(File fiche : fichiers.listFiles()){
                    option1.add(fiche.getName());
                }
            }
        }
        return option1;
    }
    
    public String Supprimer(String NomBdd){
        String message = "La base des donnees n'existe pas";
        File dossiers = new File("Base_des_donnees");
        for(File file : dossiers.listFiles()){
            if((file.isDirectory()) && (file.getName().equals(NomBdd))){
                message = "La base des donnees " + file.getName() + "a été supprimée";
                for(File nom : file.listFiles()){
                    if(nom.isDirectory()){
                        for(File fin : nom.listFiles()){
                            fin.delete();
                        }
                    }
                    nom.delete();
                }
            }
            file.delete();
            
        }
        return message;
    }
    
    public String Ajouter_Table(String NomBdd, String NomTable){
        File dossiers = new File("Base_des_donnees");
        for(File file : dossiers.listFiles()){
            if(file.isDirectory()){
                if(file.getName().equals(NomBdd)) {
                    File fichiers = new File("Base_des_donnees/" + NomBdd + "/Tables/");
                    for(File fiche : fichiers.listFiles()){
                        if((fiche.isFile()) && (fiche.getName().equals(NomTable))){
                            return "La table existe";
                        }
                    }
                    if(Table(NomBdd, NomTable))
                        return "Succes";
                }
            }
        }
        return "La base des donnees n'existe pas";
    }
    
    static boolean Table(String Chemin, String NomT){
        try(FileWriter ecrit = new FileWriter("Base_des_donnees/" + Chemin + "/Tables/" + NomT + ".csv")){
            return true;
        }catch(IOException e){ }
        return false;
    }
    
    
}
