/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.practice;

import com.applegrocer.util.TimePicker;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jfxtras.scene.control.CalendarPicker;

/**
 * FXML Controller class
 *
 * @author AppleGrocer
 */
public class AddPracticeController implements Initializable {

    @FXML
    TextField textHours;
    @FXML
    TextField textMins;
    @FXML
    ChoiceBox cBoxAmPm;
    @FXML
    Button btnSave;
    @FXML
    Button btnCancel;
    @FXML
    GridPane pneGrid;

    CalendarPicker timePicker;
    SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM/dd/yyyy, hh:mm aa");
    
    @FXML
    private void btnAction(ActionEvent e) throws IOException{
        Stage stage;
        if(e.getSource()==this.btnCancel){
            System.out.println("You Pressed Cancel!");
            stage=(Stage)this.btnCancel.getScene().getWindow();
            stage.close();
        }else if(e.getSource()==this.btnSave){
            System.out.println(this.format.format(this.timePicker.getCalendar().getTime()));
            stage=(Stage)this.btnSave.getScene().getWindow();
            stage.close();
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.timePicker = new TimePicker().getTimePicker();
        this.pneGrid.add(this.timePicker, 0, 0);
    }    
    
}
