/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample.controller;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import com.milagro.springbootexample.dao.ICityDao;
import com.milagro.springbootexample.model.MCinema;
import com.milagro.springbootexample.model.MCity;
import com.milagro.springbootexample.model.MMovies;
import com.milagro.springbootexample.service.IMovieServices;
import com.milagro.springbootexample.service.MovieServices;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author harpreet
 * 
 * 
 * 
 * API -> GetListOfCities() - will go to DB and fetch list of cities into City Class
API -> GetListOfEventsByCity(CityId) - when user select city, this API will return a list of events in Event Class, which can be extended into multiple types of events such as movies, shows, or festivals etc.
API -> GetLocationsByCity(CityId) - This api will return list of locations(theaters, event grounds etc) based upon the city chosen by the user.
API -> GetLocationsByEventandCity(cityid, eventid) - when user select event, we know the eventid and we already know the cityid, we can make this API call to get locations where the event is getting played/organized.
API -> GetEventsByLocationandCity(CityId, LocationId) - this API will return list of events given the locationid and the city id, we are using cityid here to not create different locationid for same theaters in multiple cities.
API -> GetShowTiming(eventid,locationid) - when user select the location, we know the locationid, system will call this API to get the available show timings
API - > GetAvailableSeats(eventid,locationid,showtimeid) - user will select the showtime, and UI will let user select number of seats in next page, we call this API when user has selected the seat count, until this point everything was read-only, so no issue with concurrent calls, but from this point, we have the concurrency issue. this API will only show currently available seats, which can change in future, once the user has selected the seats, we will call this new API
API -> VarifyUserSelectedSeatsAvailable(eventid,locationid,showtimeid,seats) - this will tell us whether all the chosen seats are available or not, if not, we call GetAvailableSeats again for new available seats.
Once VarifyUserSelectedSeatsAvailable passes, we will block those seats for the user, and move the call to the payment gateway. if payment is failed for whatever reason, we will let the user do one more try, and then unblock those seats if not successful.
 */
@RestController
public class MovieController {
    
    
    @Autowired
    IMovieServices mServices;
 
    
   @Cacheable(value = "Cities", key="#p0") 
   @GetMapping("/GetListOfCities")
   public ResponseEntity<List<MCity>> getListOfCities(){
       
       
       List<MCity> lCities = mServices.getAllCities();
       
       if(lCities == null || lCities.size() == 0)
           return new ResponseEntity< List<MCity>>(lCities,HttpStatus.NO_CONTENT);
       
       
       return new ResponseEntity< List<MCity>>(lCities,HttpStatus.OK);
   }
   
   
   @CachePut(value = "Cities" )
   @PostMapping("/AddCity")
   public ResponseEntity addCity(@RequestParam("cityName") String citName){
      
     try{  
            mServices.addCity(citName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    } catch (Exception e) {
        // log excpetion first, then return Conflict (409)
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    
      
   }
   
   
   @Cacheable(value = "Movies", key = "#response?.cityId")
   @GetMapping("/GetListOfMoviesByCity/{cityId}")
    public ResponseEntity< List<MMovies>>  getListOfMoviesByCity(@PathVariable long cityId, String key){
        
        
        List<MMovies> lMovies = mServices.getAllMoviesByCities(cityId);
        
        if(lMovies == null || lMovies.size() == 0)
           return new ResponseEntity< List<MMovies>>(lMovies,HttpStatus.NO_CONTENT);
       
       
       return new ResponseEntity< List<MMovies>>(lMovies,HttpStatus.OK);
              
    }
    
    
    @GetMapping("/GetListOfCinemaByCity/{cityId}")
    public ResponseEntity<List<MCinema>> getListOfCinemasByCity(@PathVariable long cityId){
    
    
        List<MCinema> lCinema = mServices.getAllCinemasByCities(cityId);
        
        if(lCinema == null || lCinema.size() == 0)
               return new ResponseEntity< List<MCinema>>(lCinema,HttpStatus.NO_CONTENT);
        
        
        return new ResponseEntity< List<MCinema>>(lCinema,HttpStatus.OK);
 
        
        
    }
    
}
