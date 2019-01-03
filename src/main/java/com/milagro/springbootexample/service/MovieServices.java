/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.service;

import com.milagro.springbootexample.dao.ICityDao;
import com.milagro.springbootexample.model.MCinema;
import com.milagro.springbootexample.model.MCity;
import com.milagro.springbootexample.model.MMovies;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author harpreet
 */

@Service
public class MovieServices implements IMovieServices {
    
    
    @Autowired
    ICityDao iCityDao;
    

    public List<MCity> getAllCities() {
        
        return iCityDao.getAllCities();
        
    }

    @Override
    public void addCity(String mCity) {
        
       iCityDao.addCity(mCity);
    }

    @Override
    public List<MMovies> getAllMoviesByCities(long cityId) {
        
        
        return iCityDao.getAllMoviesByCities(cityId);
    }

    @Override
    public List<MCinema> getAllCinemasByCities(long cityId) {
        return iCityDao.getAllCinemasByCities(cityId);
        
    }
    
    
    
    
    
}
