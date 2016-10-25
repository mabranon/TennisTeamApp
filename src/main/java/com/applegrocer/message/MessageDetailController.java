/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.message;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AppleGrocer
 */
public class MessageDetailController implements Initializable {

    @FXML
    private Label lblSender;
    @FXML
    private Label lblBody;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnReply;
    private Message message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deleteAction(ActionEvent event) {
        Stage stage;
        stage=(Stage)this.btnDelete.getScene().getWindow();
        System.out.println("Message from " + message.getSender() + " deleted");
        stage.close();
    } 

    @FXML
    private void replyAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass()
                .getResource("/fxml/ReplyMessage.fxml"));   
        Stage stage;
        Parent root;
        stage = new Stage();
        root = loader.load();
        String newSubject="RE: " + this.message.getSubject();
        stage.setScene(new Scene(root));
        stage.setTitle(newSubject);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(this.btnReply.getScene().getWindow());
        
        ReplyMessageController replyMsgControl =
                loader.<ReplyMessageController>getController();
        replyMsgControl.init(this.message, newSubject);        
        stage.showAndWait();
        ((Stage)this.btnReply.getScene().getWindow()).close();
    }
    
    public void init(Message message){
        this.message=message;
        this.lblSender.setText(message.getSender());
        this.lblBody.setText(message.getBody());
    }
}
