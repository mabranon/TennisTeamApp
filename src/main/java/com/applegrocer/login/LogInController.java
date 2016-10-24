/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.login;

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
import javafx.stage.Stage;

/**
 *
 * @author AppleGrocer
 */
public class LogInController implements Initializable {
    
    @FXML
    private Button btnLogIn;
    
    @FXML
    private void logInAction(ActionEvent e) throws IOException{
        Parent root=null;
        Stage stage=(Stage) this.btnLogIn.getScene().getWindow();
        if(e.getSource()==this.btnLogIn){
            root = FXMLLoader.load(getClass()
                    .getResource("/fxml/HomeScreen.fxml"));
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
