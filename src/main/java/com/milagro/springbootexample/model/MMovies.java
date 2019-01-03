/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author harpreet
 * 
 * 
 * 
 */

@Entity
@Table(name = "tbl_movies")
public class MMovies implements Serializable{
    
    private static final long serialVersionUID = 7156526077883281623L;
    
    @Id
    @GeneratedValue
    private Long mId;
    
    String mName;
    
    @Column(nullable = false, columnDefinition = "FLOAT default 0.00")
    float mRating;

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public float getmRating() {
        return mRating;
    }

    public void setmRating(float mRating) {
        this.mRating = mRating;
    }
    
    
    
    
    
    
    
}
