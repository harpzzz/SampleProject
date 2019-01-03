/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author harpreet
 */


@Entity
@Table(name ="tbl_audi")
public class MAudi implements Serializable {
    
    

@Id
@GeneratedValue
private Long aId;    
    

private Integer aNumber;


@ManyToOne
@JoinColumn(name="cId", nullable=false)
MCinema mCinema;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public Integer getaNumber() {
        return aNumber;
    }

    public void setaNumber(Integer aNumber) {
        this.aNumber = aNumber;
    }

    public MCinema getmmCinema() {
        return mCinema;
    }

    public void setmmCinema(MCinema mCinema) {
        this.mCinema = mCinema;
    }




    
    
}
