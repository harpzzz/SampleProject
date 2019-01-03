/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author harpreet
 */
@Entity
@Table(name = "tbl_seat")
public class MSeat {
    
    @Id
    @GeneratedValue        
    private long sId;
    
    private String sNumber;
    private SeatType sType;

    public long getsId() {
        return sId;
    }

    public void setsId(long sId) {
        this.sId = sId;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public SeatType getsType() {
        return sType;
    }

    public void setsType(SeatType sType) {
        this.sType = sType;
    }
    
    
    
    
}
