/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author harpreet
 */

@Entity
@Table(name = "tblCity")
public class MCity implements Serializable {

    public MCity() {
    }
    
    
    

    public MCity(String CName) {
        this.cName = CName;
    }
    
    
    
    @Id
    @GeneratedValue
    Long cityId;
    
    @NotBlank
    String cName;
    
    
   /* @OneToMany(mappedBy="MReationMovie")
    private Set<MReationMovie> mReationMovie;
    */
  

    public Long getCId() {
        return cityId;
    }

    public void setCId(Long CId) {
        this.cityId = CId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String CName) {
        this.cName = CName;
    }
    
}
