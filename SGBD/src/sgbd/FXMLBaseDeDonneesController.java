/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anthony-Kis
 */
public class FXMLBaseDeDonneesController implements Initializable{

    @FXML Label txtErreur;
    @FXML TextField txtTable;
    @FXML ComboBox comboBox1;
    //private String BddName;
    BDD Database = new BDD();
    public String Nom_de_la_Bdd;

    @FXML private void OuvrirChamp(ActionEvent event) throws IOException{
        Donnees.TableName = (String)comboBox1.getValue();
        Parent root = FXMLLoader.load(getClass().getResource("Champ.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("SGBD");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML private void Retour(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("SGBD");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
    }
    
    @FXML private void CreerTable(ActionEvent event) throws IOException{
        String table = txtTable.getText();
        if((table.length() == 0)){
            txtErreur.setText("Veillez saisir un nom et selectionner un nombre");
        }
        
        Donnees.TableName = table;
        
        Parent root = FXMLLoader.load(getClass().getResource("Champ.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("SGBD");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
        txtErreur.setText("");
        Database.Ajouter_Table(Nom_de_la_Bdd, table);
        //ouvrir la fenetre champ
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Nom_de_la_Bdd = Donnees.BddName;
        comboBox1.setItems(Database.ListeTable(Donnees.BddName));

    }    
    
}
