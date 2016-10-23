/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.playerrank;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author AppleGrocer
 */
public class PlayerRankController {

    @FXML
    private AnchorPane anchor;
    
    @FXML
    private Label labelName;
    
    @FXML
    private Label lblWins;
    
    @FXML
    private Label lblLosses;

    public void load() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PlayerRank.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(PlayerRankController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    /**
     * @return the anchor
     */
    public AnchorPane getAnchor() {
        return anchor;
    }


    public void setLblName(String name) {
        labelName.setText(name);
    }


    public void setLblWins(String wins) {
        this.lblWins.setText(wins);
    }


    public void setLblLosses(String losses) {
        this.lblLosses.setText(losses);
    }
    
}
