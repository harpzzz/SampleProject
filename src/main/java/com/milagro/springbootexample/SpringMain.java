/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milagro.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import javax.servlet.Filter;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author harpreet
 */
//@ComponentScan({"com.milagro.springbootexample.controller","com.milagro.springbootexample.dao","com.milagro.springbootexample.service"})
@SpringBootApplication
@EnableCaching
public class SpringMain {
    

    
    public static void main(String[] args) {
                ApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);
             
                for (String name: applicationContext.getBeanDefinitionNames()) {
                    System.out.println(name);
                }
       
    }
    
    
       @Bean
    public Filter filter(){
        ShallowEtagHeaderFilter filter=new ShallowEtagHeaderFilter();
        return filter;
    }

    
}
