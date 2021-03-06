/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.practice;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AppleGrocer
 */
public class PracticeController implements Initializable {
    
    @FXML
    private TableView<PracticeSession> table;
    @FXML
    private TableColumn<PracticeSession, Date> colDate; 
    @FXML
    private TableColumn<PracticeSession, Integer> colOpen; 
    @FXML
    private TableColumn<PracticeSession, Integer> colCap; 
    @FXML
    private TableColumn<PracticeSession, PracticeType> colType; 
    @FXML
    private TableColumn<PracticeSession, String> colCoach; 
    @FXML
    private Button btnNewPractice;
    
    @FXML
    private void createNewPracticeAction(ActionEvent e) throws IOException{
        Stage stage;
        Parent root;
        if(e.getSource()==btnNewPractice){           
            stage = new Stage();
            root=FXMLLoader.load(getClass().getResource("/fxml/AddPractice.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Add new practice session");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(btnNewPractice.getScene().getWindow());
            stage.showAndWait();
        }
    } 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PracticeSession> data = FXCollections.observableArrayList();
        try {
           data.add(new PracticeSession("12:30 PM, 10/21/2016", 2, 5, 
                   PracticeType.SERVING, "Bob"));
           data.add(new PracticeSession("10:30 AM, 10/23/2016", 1, 10, 
                   PracticeType.VOLLEY, "Jerry"));
           data.add(new PracticeSession("3:00 PM, 10/22/2016", 8, 9, 
                   PracticeType.FOREHAND, "Mary"));
           data.add(new PracticeSession("12:30 PM, 10/18/2016", 6, 12, 
                   PracticeType.FOREHAND, "Samantha"));
        } catch (ParseException ex) {
            Logger.getLogger(PracticeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setItems(data);
        
        colDate.setCellValueFactory(
                new PropertyValueFactory<PracticeSession, Date>("time"));
        colCoach.setCellValueFactory(
                new PropertyValueFactory<PracticeSession, String>("coachName"));
        colOpen.setCellValueFactory(
                new PropertyValueFactory<PracticeSession, Integer>("open"));
        colCap.setCellValueFactory(
                new PropertyValueFactory<PracticeSession, Integer>("maxCap"));
        colType.setCellValueFactory(new PropertyValueFactory
                <PracticeSession, PracticeType>("type"));
    }    
    
}
