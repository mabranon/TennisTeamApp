/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.homescreen;

import com.applegrocer.playerrank.PlayerRankCell;
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
public class HomeScreenController implements Initializable {

    @FXML
    private ListView rankList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> names = FXCollections.observableArrayList();
        names.addAll("Steve", "Nancy Drew", "Erica Stevens", "Bob Ross");
        rankList.setItems(names);
        rankList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new PlayerRankCell();
            }
        });
    }
}
