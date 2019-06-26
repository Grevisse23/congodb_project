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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anthony-Kis
 */
public class ChampController implements Initializable {

    @FXML Label Bdd_Nom, Table_Name;
    @FXML TextField Text1, Text2, Text3, Text4, Text5, Text6, Text7, Text8, Text9, Text10, Text11, Text12,Text13, Text14, Text15;
    Enregistrement enre = new Enregistrement();
    
    @FXML public void onRetour(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLBaseDeDonnees.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(Donnees.TableName);
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML public void onEnregistrer(ActionEvent event){
        String[] text;
        int i = 0, m = 15, n = 15;
        text = new String[15];text[0] = Text1.getText();text[1] = Text2.getText();text[2] = Text3.getText();text[3] = Text4.getText();text[4] = Text5.getText();text[5] = Text6.getText();text[6] = Text7.getText();text[7] = Text8.getText();text[8] = Text9.getText();text[9] = Text10.getText();text[10] = Text11.getText();text[11] = Text12.getText();text[12] = Text13.getText();text[13] = Text14.getText();text[14] = Text15.getText();
        
        for(String stri : text){
            if(stri.length() == 0){m--;}
        }
        String[] text2 = new String[15];
        for(String on : text){
            if(on != null){
                text2[i] = on + ";";
                i++;
            }
            if(i == m){
                enre.newEnre(text2, m);
            }
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Bdd_Nom.setText(Donnees.BddName);
        Table_Name.setText(Donnees.TableName);
    }    
    
}
