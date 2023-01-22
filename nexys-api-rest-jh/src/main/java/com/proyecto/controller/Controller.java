package com.proyecto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Categorie;
import com.proyecto.entity.Nproduct;
import com.proyecto.entity.Product;
import com.proyecto.service.ServiceProyectoImpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.common.base.CharMatcher;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.boot.json.GsonJsonParser;
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
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
/**
 * Clase controlador 
 * Julian David Hernandez Torres
 * 
 * 
 * @return
 */
@RestController
@RequestMapping("/nexsys")

public class Controller {

	private final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	private ServiceProyectoImpl service;
	/**
	 * Sirve para mostrar todos los productos
	 * 
	 * @param user
	 * @return
	 */
	@GetMapping("/v1/products/")
	public ResponseEntity GetAllProducts(HttpServletRequest servletRequest) {
		service = new ServiceProyectoImpl();
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://api.escuelajs.co/api/v1/products"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		ArrayList<Product> products = new ArrayList();
		products = service.GetallProducts(response.body().toString());
		return ResponseEntity.ok(products);
	}
	/**
	 * Sirve para mostrar todas las categorias
	 * 
	 * @param user
	 * @return
	 */
	@GetMapping("/v1/categories/")
	public ResponseEntity allcategories(HttpServletRequest servletRequest) {

		service = new ServiceProyectoImpl();
		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("https://api.escuelajs.co/api/v1/categories"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		ArrayList<Categorie> categories = new ArrayList();

		categories = service.Getallcategoriess(response.body().toString());
		return ResponseEntity.ok(categories);

	}
	/**
	 * Sirve para grear un nuevo producto
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/v1/newProduct/")
	public ResponseEntity crearPerson(HttpServletRequest servletRequest, @RequestBody Nproduct nProduct) {
		int pId = 0;
		pId++;
		ArrayList<Nproduct> products = new ArrayList();
		Nproduct product = new Nproduct();
		product.setpId(pId);
		product.setName(nProduct.getName());
		product.setPriceFInal(nProduct.getPriceFInal());
		product.setDescription(nProduct.getDescription());
		product.setCategoryId(nProduct.getCategoryId());
		product.setImagenUrl(nProduct.getImagenUrl());
		products.add(nProduct);
	

			return ResponseEntity.ok(products);
		

		

	}
}
