/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.util;

import java.util.Calendar;
import java.util.Locale;
import jfxtras.scene.control.CalendarPicker;

/**
 *
 * @author AppleGrocer
 */
public class TimePicker {
    private final CalendarPicker picker;
    
    public TimePicker(){
        this.picker = new CalendarPicker();
        this.picker.withCalendar(Calendar.getInstance());
        this.picker.withShowTime(Boolean.TRUE);
        this.picker.withLocale(Locale.US);
    }

    public CalendarPicker getTimePicker(){
        return this.picker;
    }
}
