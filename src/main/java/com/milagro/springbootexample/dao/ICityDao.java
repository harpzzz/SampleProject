/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.dao;

import com.milagro.springbootexample.model.MCinema;
import com.milagro.springbootexample.model.MCity;
import com.milagro.springbootexample.model.MMovies;
import java.util.List;

/**
 *
 * @author harpreet
 */
public interface ICityDao {
    
    public void addCity(String mCity);
    public List<MCity> getAllCities();
    public List<MMovies> getAllMoviesByCities(long cityId);
        public List<MCinema> getAllCinemasByCities(long cityId);

}
