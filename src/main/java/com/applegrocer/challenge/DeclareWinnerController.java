/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.challenge;

import com.applegrocer.practice.PracticeType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AppleGrocer
 */
public class DeclareWinnerController implements Initializable {
    
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;
    @FXML
    private ChoiceBox cBoxPlayers;

    private ObservableList<String> players;
    
    public void init(Challenge challenge){
        this.players=FXCollections.observableArrayList();
        players.addAll(
                challenge.getPlayer1(),
                challenge.getPlayer2()
        );
        this.cBoxPlayers.setItems(players);
    }
    
    @FXML
    private void confirmWin(ActionEvent e){
        Stage stage;
        stage=(Stage)btnConfirm.getScene().getWindow();
        System.out.println(this.cBoxPlayers.getSelectionModel()
                .getSelectedItem());
        stage.close();
    }
    
    @FXML
    private void cancel(ActionEvent e){
        Stage stage;
        stage=(Stage)btnCancel.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
