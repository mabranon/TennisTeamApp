/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.roster;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AppleGrocer
 */
public class AddNewPlayerController implements Initializable {

    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtStreet;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtState;
    @FXML
    private TextField txtZip;
    @FXML
    private TextField txtLastName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveEditAction(ActionEvent event) {
        Stage stage;
        stage=(Stage)this.btnSave.getScene().getWindow();
        System.out.println(this.txtFirstName.getText() +
                " " + this.txtLastName.getText() + 
                " saved in roster");
        stage.close();
    }

    @FXML
    private void cancelEditAction(ActionEvent event) {
        Stage stage;
        stage=(Stage)this.btnCancel.getScene().getWindow();
        System.out.println("Addition Canceled");
        stage.close();
    }
    
}
