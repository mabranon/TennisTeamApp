/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.challenge;

import com.applegrocer.practice.PracticeController;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
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
public class ChallengeTabController implements Initializable {

    @FXML
    private TableView<Challenge> table;
    @FXML
    private TableColumn<Challenge, String> colPlayer1;
    @FXML
    private TableColumn<Challenge, String> colPlayer2;
    @FXML
    private TableColumn<Challenge, Date> colDate;

    ObservableList<Challenge> challengeList;

    private void declareWinner(TableRow row) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/fxml/DeclareWinner.fxml"));
        
        Stage stage;
        Parent root;
        stage = new Stage();
        root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle("Declare a winner for this challenge");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(row.getScene().getWindow());
        
        DeclareWinnerController dwControl =
                loader.<DeclareWinnerController>getController();
        dwControl.init((Challenge)row.getItem());
        
        stage.showAndWait();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.challengeList = FXCollections.observableArrayList();
        try {
            this.challengeList.addAll(
                    new Challenge("Mark", "Steve", "12:30 PM, 10/21/2016"),
                    new Challenge("Greg", "Carl", "10:00 AM, 10/24/2016"),
                    new Challenge("Martha", "Samantha", "04:00 PM, 11/22/2016"),
                    new Challenge("Margret", "Jessica", "03:30 PM, 10/30/2016"),
                    new Challenge("Bob", "John", "09:00 AM, 10/28/2016"),
                    new Challenge("Paul", "George", "11:30 AM, 11/21/2016"),
                    new Challenge("Sally", "Barbara", "02:30 PM, 12/21/2016")
            );
        } catch (ParseException e) {
            Logger.getLogger(PracticeController.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        this.table.setItems(this.challengeList);

        this.colPlayer1.setCellValueFactory(
                new PropertyValueFactory<Challenge, String>("player1"));
        this.colPlayer2.setCellValueFactory(
                new PropertyValueFactory<Challenge, String>("player2"));
        this.colDate.setCellValueFactory(
                new PropertyValueFactory<Challenge, Date>("date"));

        this.table.setRowFactory(
                new Callback<TableView<Challenge>, TableRow<Challenge>>() {
            @Override
            public TableRow<Challenge> call(TableView<Challenge> challengeTable) {
                final TableRow<Challenge> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getButton().equals(MouseButton.PRIMARY)
                                && !row.isEmpty()
                                && event.getClickCount() == 2) {
                            try {
                                declareWinner(row);
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
