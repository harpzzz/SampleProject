/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author harpreet
 */
@Entity
@Table(name = "tbl_relation_movie")
public class MReationMovie {
    
   
   @Id
   @GeneratedValue        
   Long rmId;
   
   
   @ManyToOne
   @JoinColumn(name="cityId", nullable=false)
   MCity mcityId;
    
   
   @ManyToOne
   @JoinColumn(name="cinemaId", nullable=false)
   MCinema mCinema;
   
   
   
  @ManyToOne
  @JoinColumn(name="movieId", nullable = false)
  MMovies mMovies;

    public Long getRmId() {
        return rmId;
    }

    public void setRmId(Long rmId) {
        this.rmId = rmId;
    }

    public MCity getMcityId() {
        return mcityId;
    }

    public void setMcityId(MCity mcityId) {
        this.mcityId = mcityId;
    }

    public MCinema getmCinemaId() {
        return mCinema;
    }

    public void setmCinemaId(MCinema mCinemaId) {
        this.mCinema = mCinemaId;
    }

    public MMovies getmMovies() {
        return mMovies;
    }

    public void setmMovies(MMovies mMovies) {
        this.mMovies = mMovies;
    }
  
  
   
  
 
    
}
