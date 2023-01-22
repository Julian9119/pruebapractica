package com.proyecto.service;

import java.util.ArrayList;

import com.google.common.base.CharMatcher;
import com.proyecto.entity.Categorie;
import com.proyecto.entity.Product;

public class ServiceProyectoImpl  {

	
	
	
	public ArrayList<Product> GetallProducts(String string){
		ArrayList<Product> products = new ArrayList();
		String charsToRemove = "[]{\"";
		string = CharMatcher.anyOf(charsToRemove).removeFrom(string);
		String[] parts = string.split("}},");
		for (int i = 0; i < parts.length; i++) {
	    Product product= new Product();
	    product=llenarUsuario(parts[i]);
	    products.add(product);
		}
		return products;
	}
	
	public Product llenarUsuario(String cadena) {
		 String acu="",acu2="" ,acu3="",acu4="";
		Product product= new Product ();
        String [] part=cadena.split(",");
        for (int i = 0; i < part.length; i++) {
			String []part2=part[i].split(":");
			for (int j = 0; j < part2.length; j++) {
				if(part2[0].equalsIgnoreCase("id")) {
					acu+=part2[1]+",";
					
				}
				if(part2[0].equalsIgnoreCase("title")) {
					acu2+=part2[1]+",";
					
				}
				if(part2[0].equalsIgnoreCase("price")) {
					acu3+=part2[1]+",";
					
				}
				if(part2[0].equalsIgnoreCase("description")) {
					acu4+=part2[1]+",";
					break;
				}
			}
			
		}
        String [] finals=acu.split(",");
        String [] finals2=acu2.split(",");
        String [] finals3=acu3.split(",");
        String [] finals4=acu4.split(",");
        product.setpId(Integer.parseInt(finals[0]));
        product.setName(finals2[0]);
        product.setPriceFinal(Integer.parseInt(finals3[0]));
        product.setDescription(finals4[0]);
		return product;
	}
	
	
	
	
	public ArrayList<Categorie> Getallcategoriess(String string){
		ArrayList<Categorie> categories = new ArrayList();
		String charsToRemove = "[]{\"";
		string = CharMatcher.anyOf(charsToRemove).removeFrom(string);
		String[] parts = string.split("}},");
		for (int i = 0; i < parts.length; i++) {
		Categorie categorie= new Categorie();
		categorie=llenarCategoria(parts[i]);
		categories.add(categorie);
		}
		return categories;
	}
	
	public Categorie llenarCategoria(String cadena) {
		 String acu="",acu2="" ;
		Categorie categorie= new Categorie ();
        String [] part=cadena.split(",");
        for (int i = 0; i < part.length; i++) {
			String []part2=part[i].split(":");
			for (int j = 0; j < part2.length; j++) {
				if(part2[0].equalsIgnoreCase("id")) {
					acu+=part2[1]+",";
					
				}
				if(part2[0].equalsIgnoreCase("name")) {
					acu2+=part2[1]+",";
					break;
				}
				
			}
			
		}
        String [] finals=acu.split(",");
        String [] finals2=acu2.split(",");
        
        categorie.setcId(Integer.parseInt(finals[0]));
        categorie.setTitle(finals2[0]);
		return categorie;
	}
	
	
	
	
	
	
	
	
	
	
}
