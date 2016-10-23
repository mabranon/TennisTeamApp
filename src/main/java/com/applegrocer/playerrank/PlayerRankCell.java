/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.playerrank;

import javafx.scene.control.ListCell;

/**
 *
 * @author AppleGrocer
 */
public class PlayerRankCell extends ListCell<String> {

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            PlayerRankController player = new PlayerRankController();
            player.load();
            player.setLblName(item);
            player.setLblWins("20");
            player.setLblLosses("8");
            setGraphic(player.getAnchor());
        }
    }
}
