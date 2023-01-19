package com.proyecto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Categorie;
import com.proyecto.entity.Nproduct;
import com.proyecto.entity.Product;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.Gson;

@RestController
@RequestMapping("/nexsys")

public class Controller {

	
	
    @GetMapping("/v1/products/")
    public  ResponseEntity obtenerPerson(HttpServletRequest servletRequest) {
    	ArrayList<Product> products = new ArrayList();
    	Product product =new Product();
        Product product2 =new Product();
        product.setpId(4);
        product.setName("Handmade Fresh Table");
        product.setPriceFinal(687);
        product.setDescription("Andy shoes are designed to keeping in... ");
        
        product2.setpId(45);
        product2.setName("Handmade Fresh Table");
        product2.setPriceFinal(687);
        product2.setDescription("Andy shoes are designed to keeping in... ");
      
        products.add(product);
        products.add(product2);
       if(!products.isEmpty()) {
    	  return ResponseEntity.ok(products);
       }
     
		
       else {
    	   return ResponseEntity.notFound().build();
       }
        
    
    }
    
    @GetMapping("/v1/categories/")
    public  ResponseEntity allcategories(HttpServletRequest servletRequest) {
    	ArrayList<Categorie> categories = new ArrayList();
    	Categorie categorie =new Categorie();
    	Categorie categorie2 =new Categorie();
         categorie.setcId(4);
         categorie.setTitle("Hanmade Fresh Table");
         categorie2.setcId(5);
         categorie2.setTitle("Hanmade Fresh Table");
         categories.add(categorie);
         categories.add(categorie2);
         if(!categories.isEmpty()) {
       	  return ResponseEntity.ok(categories);
          }
        
   		
          else {
       	   return ResponseEntity.notFound().build();
          }
           
      
		
        
        
    
    }
    
    @PostMapping("/v1/newProduct/")
    public ResponseEntity crearPerson(HttpServletRequest servletRequest,@RequestBody Nproduct nProduct) {
    	int pId=0;
    	pId++;
    	ArrayList<Nproduct> products = new ArrayList();
    	Nproduct product =new Nproduct();
    	product.setpId(pId);
    	product.setName(nProduct.getName());   
    	product.setPriceFInal(nProduct.getPriceFInal());
    	product.setDescription(nProduct.getDescription());
    	product.setCategoryId(nProduct.getCategoryId());
    	product.setImagenUrl(nProduct.getImagenUrl());
    	products.add(nProduct);
    	 if(!products.isEmpty()) {
            String formJson="{\n"+"\"pId\":"+product.getpId()+"\n"+"}";
    		 System.out.println("Producto creado exitosamente"+" "+product.toString());
    		 
       	  return ResponseEntity.ok(formJson);
          }
        
          else {
       	   return ResponseEntity.notFound().build();
          }
           
    	
    	
    }
}
    
    

