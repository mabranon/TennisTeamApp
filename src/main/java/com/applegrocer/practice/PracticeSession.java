/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author AppleGrocer
 */
public class PracticeSession {
    
    private String name;
    private Date time;

    public PracticeSession(String name, String time) throws ParseException{
        this.name=name;
        this.time=convertTime(time);
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return this.time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }
    
    public void setTime(String timeString) throws ParseException{
        this.time = convertTime(timeString);
    }
    
    private Date convertTime(String timeString) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a, MM/dd/yyyy");
        return formatter.parse(timeString);
    }

    public String getTimeString() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE. hh:mm a, MM/dd/yyyy");
        return formatter.format(this.time);
    }
    
    
}
