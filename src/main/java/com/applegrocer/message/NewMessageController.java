/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.message;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joshua
 */
public class NewMessageController implements Initializable {

    @FXML
    private TextField txtReciever;
    @FXML
    private TextField txtSubject;
    @FXML
    private TextArea txtBody;
    @FXML
    private Button btnSend;
    @FXML
    private Button btnCancel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void sendAction(ActionEvent e){
        Stage stage;
        stage=(Stage)this.btnSend.getScene().getWindow();
        System.out.println("Sent message : " + this.txtBody.getText() +
                " to " + this.txtReciever.getText());
        stage.close();
    }
    
    @FXML
    private void cancelAction(ActionEvent e){
        Stage stage;
        stage=(Stage)this.btnCancel.getScene().getWindow();
        System.out.println("Canceling message");
        stage.close();
    }
}
