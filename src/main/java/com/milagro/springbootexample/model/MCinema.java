/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author harpreet
 */

@Entity
@Table(name = "tbl_cinema")
public class MCinema {
 
    @Id
    @GeneratedValue
    @Column(name = "cinemaId")
    private Long cId;
    
    @Column(name = "cinemaName",nullable = false, length = 100)
    private String cName;
    
    
    @Column(name = "cinemaAddress",nullable = false, length = 250)
    private String cAddress;
    
    
    
 /*   @ManyToOne
    @JoinColumn(name="cityId", nullable=false)
    private MCity city;
*/
    
    
    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    
    
    
    
    
    
    
    
}
