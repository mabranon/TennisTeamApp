/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.playerrank;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author AppleGrocer
 */
public class RankListController implements Initializable {

    @FXML
    private ListView<RankedPlayer> listView;

    private ObservableList<RankedPlayer> playerList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerList = FXCollections.observableArrayList();
        playerList.addAll(
                new RankedPlayer(1, "Mary", 20, 0),
                new RankedPlayer(2, "Jerry", 17, 2),
                new RankedPlayer(3, "Bob", 12, 0),
                new RankedPlayer(4, "Steve", 12, 4),
                new RankedPlayer(5, "Samantha", 17, 12)
        );

        this.listView.setItems(this.playerList);
        this.listView.setCellFactory(new Callback<ListView<RankedPlayer>, 
                ListCell<RankedPlayer>>() {
            @Override
            public ListCell<RankedPlayer> call(
                    ListView<RankedPlayer> playerListView) {
                return new PlayerRankCell();
            }
        }
        );
    }

}
