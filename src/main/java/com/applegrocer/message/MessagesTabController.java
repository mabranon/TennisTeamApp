/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.message;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class MessagesTabController implements Initializable {

    @FXML
    private TableView<Message> table;
    @FXML
    private TableColumn<Message, String> colFrom;
    @FXML
    private TableColumn<Message, String> colSubject;
    @FXML
    private Button btnNewMessage;
    ObservableList<Message> messageList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        messageList=FXCollections.observableArrayList();
        messageList.addAll(
                new Message("Clark", "Missing Practice", "Very important block "
                        + "of textVery important block of textVery important "
                        + "block of textVery important block of textVery "
                        + "important block of textVery important block of "
                        + "textVery important block of textVery important block"
                ),
                new Message("Megan", "Software Bug", "Very important block "
                        + "of textVery important block of textVery important "
                        + "block of textVery important block of textVery "
                        + "important block of textVery important block of "
                        + "textVery important block of textVery important block"
                ),
                new Message("Jerry", "New Racket", "Very important block "
                        + "of textVery important block of textVery important "
                        + "block of textVery important block of textVery "
                        + "important block of textVery important block of "
                        + "textVery important block of textVery important block"
                ),
                new Message("Gary", "Moving", "Very important block "
                        + "of textVery important block of textVery important "
                        + "block of textVery important block of textVery "
                        + "important block of textVery important block of "
                        + "textVery important block of textVery important block"
                ),
                new Message("Rebecca", "Challenges???", "Very important "
                        + "block of textVery important block of textVery "
                        + "important block of textVery important block of "
                        + "textVery important block of textVery important "
                        + "block of textVery important block of textVery "
                        + "important block"
                ),
                new Message("Charlotte", "Injury", "Very important "
                        + "block of textVery important block of textVery "
                        + "important block of textVery important block of "
                        + "textVery important block of textVery important "
                        + "block of textVery important block of textVery "
                        + "important block"
                )
        );
        this.table.setItems(messageList);
        
        this.colFrom.setCellValueFactory(
                new PropertyValueFactory<Message, String>("sender"));
        this.colSubject.setCellValueFactory(
                new PropertyValueFactory<Message, String>("subject"));
        
        this.table.setRowFactory(
                new Callback<TableView<Message>, TableRow<Message>>() {
            @Override
            public TableRow<Message> call(TableView<Message> rosterTable) {
                final TableRow<Message> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getButton().equals(MouseButton.PRIMARY)
                                && !row.isEmpty()
                                && event.getClickCount() == 2) {
                            try {
                                readMessage(row);
                            } catch (IOException ex) {
                                Logger.getLogger(MessagesTabController.class
                                        .getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                });
                return row;
            }
        });
    }    

    private void readMessage(TableRow row) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/fxml/MessageDetail.fxml"));   
        Stage stage;
        Parent root;
        stage = new Stage();
        root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle(((Message)row.getItem()).getSubject());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(row.getScene().getWindow());
        
        MessageDetailController editControl =
                loader.<MessageDetailController>getController();
        editControl.init((Message)row.getItem());        
        stage.showAndWait();
    }
    
    @FXML
    private void newMessageAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/fxml/NewMessage.fxml"));   
        Stage stage;
        Parent root;
        stage = new Stage();
        root = loader.load();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);    
        stage.initOwner(this.btnNewMessage.getScene().getWindow());
        stage.showAndWait();
    }
    
}
