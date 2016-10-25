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
public class EditPlayerController implements Initializable {

    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtStreet;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtState;
    @FXML
    private TextField txtZip;
    @FXML 
    private Button btnRemove;
    @FXML 
    private Button btnSave;
    @FXML 
    private Button btnCancel;
    
    private Player player;
    
    @FXML
    private void removePlayerAction(ActionEvent e){
        Stage stage;
        stage=(Stage)this.btnRemove.getScene().getWindow();
        System.out.println(this.player.getFirstName() + 
                " " + this.player.getLastName() +
                " removed from roster");
        stage.close();
    }
    
    @FXML
    private void saveEditAction(ActionEvent e){
        Stage stage;
        stage=(Stage)this.btnSave.getScene().getWindow();
        System.out.println(this.player.getFirstName() + 
                " " + this.player.getLastName() +
                " edited");
        stage.close();
    }
    
    @FXML
    private void cancelEditAction(ActionEvent e){
        Stage stage;
        stage=(Stage)this.btnCancel.getScene().getWindow();
        System.out.println("Edit canceled");
        stage.close();
    }
    
    public void init(Player player){
        this.player=player;
        this.txtFirstName.setText(player.getFirstName());
        this.txtLastName.setText(player.getLastName());
        this.txtStreet.setText(player.getStreetAddress());
        this.txtCity.setText(player.getCity());
        this.txtState.setText(player.getState());
        this.txtZip.setText(Integer.toString(player.getZip()));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
