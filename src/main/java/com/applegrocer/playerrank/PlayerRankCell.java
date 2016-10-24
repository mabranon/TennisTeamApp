/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.playerrank;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author AppleGrocer
 */
public class PlayerRankCell extends ListCell<RankedPlayer> {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Label lblRank;
    @FXML
    private Label lblName;
    @FXML
    private Label lblWins;
    @FXML
    private Label lblLosses;
    
    private FXMLLoader loader;

    @Override
    public void updateItem(RankedPlayer player, boolean empty) {
        super.updateItem(player, empty);
        
        if(empty||player==null){
            setGraphic(null);
        }else{
            if(loader == null){
                loader = new FXMLLoader(getClass()
                        .getResource("/fxml/PlayerRankCell.fxml"));
                loader.setController(this);
                try{
                    loader.load();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            this.lblRank.setText(Integer.toString(player.getRank()));
            this.lblName.setText(player.getName());
            this.lblWins.setText(Integer.toString(player.getWins()));
            this.lblLosses.setText(Integer.toString(player.getLosses()));
            setGraphic(this.anchor);
            
        }
    }
}
