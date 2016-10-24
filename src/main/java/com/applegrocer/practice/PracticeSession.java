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

    private String coachName;
    private Date time;
    private Integer maxCap;
    private Integer open;
    private PracticeType type;

    public PracticeSession(String time, Integer open, Integer cap,
            PracticeType type, String coach) throws ParseException {
        this.time = convertTime(time);
        this.open=open;
        this.maxCap=cap;
        this.type=type;
        this.coachName = coach;

    }

    /**
     * @return the name
     */
    public String getCoachName() {
        return coachName;
    }

    /**
     * @param name the name to set
     */
    public void setCoachName(String name) {
        this.coachName = name;
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

    public void setTime(String timeString) throws ParseException {
        this.time = convertTime(timeString);
    }

    private Date convertTime(String timeString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a, MM/dd/yyyy");
        return formatter.parse(timeString);
    }

    public String getTimeString() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, hh:mm a, MM/dd/yyyy");
        return formatter.format(this.time);
    }

    /**
     * @return the maxCap
     */
    public Integer getMaxCap() {
        return maxCap;
    }

    /**
     * @param maxCap the maxCap to set
     */
    public void setMaxCap(Integer maxCap) {
        this.maxCap = maxCap;
    }

    /**
     * @return the currCap
     */
    public Integer getOpen() {
        return open;
    }

    /**
     * @param currCap the currCap to set
     */
    public void setOpen(Integer currCap) {
        this.open = currCap;
    }

    /**
     * @return the type
     */
    public PracticeType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(PracticeType type) {
        this.type = type;
    }

}
