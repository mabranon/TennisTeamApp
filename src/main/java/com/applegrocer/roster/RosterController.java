/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.roster;

import com.applegrocer.challenge.Challenge;
import com.applegrocer.challenge.ChallengeTabController;
import com.applegrocer.challenge.DeclareWinnerController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author AppleGrocer
 */
public class RosterController implements Initializable {

    @FXML
    TableView<Player> table;
    @FXML
    TableColumn<Player, String> colName;
    
    ObservableList<Player> rosterList;
    
    private void editPlayer(TableRow row) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/fxml/EditPlayer.fxml"));
        
        Stage stage;
        Parent root;
        stage = new Stage();
        root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("Edit Player");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(row.getScene().getWindow());
        
        EditPlayerController editControl =
                loader.<EditPlayerController>getController();
        editControl.init((Player)row.getItem());
        
        stage.showAndWait();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rosterList=FXCollections.observableArrayList();
        this.rosterList.addAll(
                new Player("Greg"),
                new Player("Mary"),
                new Player("Stan"),
                new Player("Harriet")
        );
        this.table.setItems(this.rosterList);
        
        this.colName.setCellValueFactory(
                new PropertyValueFactory<Player, String>("name"));
        
        this.table.setRowFactory(
                new Callback<TableView<Player>, TableRow<Player>>() {
            @Override
            public TableRow<Player> call(TableView<Player> rosterTable) {
                final TableRow<Player> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getButton().equals(MouseButton.PRIMARY)
                                && !row.isEmpty()
                                && event.getClickCount() == 2) {
                            try {
                                editPlayer(row);
                            } catch (IOException ex) {
                                Logger.getLogger(ChallengeTabController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                });
                return row;
            }
        });
    }        
}
