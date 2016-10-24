/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.challenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AppleGrocer
 */
public class Challenge {
    private String player1;
    private String player2;
    private Date date;

    public Challenge(String player1, String player2, String date) throws ParseException{
        this.player1=player1;
        this.player2=player2;
        this.date=convertTime(date);
    }
    
    private Date convertTime(String timeString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a, MM/dd/yyyy");
        return formatter.parse(timeString);
    }
    
    /**
     * @return the player1
     */
    public String getPlayer1() {
        return player1;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    /**
     * @return the player2
     */
    public String getPlayer2() {
        return player2;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
