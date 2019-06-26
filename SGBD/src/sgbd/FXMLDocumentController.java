/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Anthony-Kis
 */
public class FXMLDocumentController implements Initializable{
    @FXML ComboBox ComboBox;
    @FXML TextField nouvelleBdd;
    @FXML Label Ret;
    BDD base = new BDD();
    ObservableList<String> option = FXCollections.observableArrayList();

    @FXML
    private void CreerBdd(ActionEvent event) throws IOException{
        if((base.Ajouter(nouvelleBdd.getText()) != "La base de données n'a pas été créé car elle existe") && (nouvelleBdd.getText().length() != 0)){
            Donnees.BddName = nouvelleBdd.getText();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLBaseDeDonnees.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(nouvelleBdd.getText());
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        else if(nouvelleBdd.getText().length() == 0){
            Ret.setText("Le champ est vide, veillez le remplir");
        }
        else{
            String mes = base.Ajouter(nouvelleBdd.getText());
            Ret.setText(mes);
        }
        
    }
    
    @FXML private void SupprimerBdd(ActionEvent event) throws IOException{
        if(ComboBox.getValue() != null){
            String Valeur = (String)ComboBox.getValue();
            JOptionPane jop2 = new JOptionPane();
            jop2.showMessageDialog(null, "La base de données " + Valeur + " a été supprimer", "Supprimer", JOptionPane.INFORMATION_MESSAGE);
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("SGBD");
            base.Supprimer(Valeur);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            
        }
        else{
            Ret.setText("Veillez selectionner une base de données ");
        }
    }
    
    @FXML private void OuvrirBdd(ActionEvent event) throws IOException{
        if(ComboBox.getValue() != null){
            Donnees.BddName = (String)ComboBox.getValue();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLBaseDeDonnees.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle((String)ComboBox.getValue());
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        
        else{
            Ret.setText("Veillez selectionner une base de données ");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComboBox.setItems(base.Recherche());
    }    
    
}
