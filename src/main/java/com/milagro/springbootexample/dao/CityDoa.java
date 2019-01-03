/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.dao;

import com.milagro.springbootexample.model.MCinema;
import com.milagro.springbootexample.model.MCity;
import com.milagro.springbootexample.model.MMovies;
import com.milagro.springbootexample.model.MReationMovie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

/**
 *
 * @author harpreet
 */

@Transactional
@Repository
public class CityDoa implements ICityDao {
    
    
        @PersistenceContext	
	private EntityManager entityManager;	
    
 
    public List<MCity> getAllCities(){
        String hql = "FROM MCity as c ORDER BY c.cityId";
        return (List<MCity>) entityManager.createQuery(hql).getResultList();    
    }
    
    
    public void addCity(String cityName){
        
        MCity mcity = new MCity();
        mcity.setCName(cityName);
        
        
        entityManager.persist(mcity);
    }

    
    
    @Override
    public List<MMovies> getAllMoviesByCities(long cityId) {
        String hql = "Select r.mMovies FROM MReationMovie as r join r.mMovies  as m WHERE r.mcityId ="+ cityId;
        
               
        
       // List<MReationMovie> lst =  (List<MReationMovie>) ;
        
       
        
        List<MMovies> lMovies = (List<MMovies>) entityManager.createQuery(hql).getResultList();
       
        
        return lMovies;
        
    }

    @Override
    public List<MCinema> getAllCinemasByCities(long cityId) {
        
        String hql = "Select r.mCinema FROM MReationMovie as r join r.mCinema  WHERE r.mcityId = "+cityId;
        
        
        return entityManager.createQuery(hql).getResultList();
    }

   
    
}
