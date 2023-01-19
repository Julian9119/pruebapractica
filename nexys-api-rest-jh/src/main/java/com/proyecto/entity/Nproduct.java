package com.proyecto.entity;

public class Nproduct {
public int  pId;

public String name;
public int priceFInal;
public String description;
public int categoryId;
public String imagenUrl;



public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
}
public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}
public int getPriceFInal() {
	return priceFInal;
}
public void setPriceFInal(int priceFInal) {
	this.priceFInal = priceFInal;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getImagenUrl() {
	return imagenUrl;
}
public void setImagenUrl(String imagenUrl) {
	this.imagenUrl = imagenUrl;
}
@Override
public String toString() {
	return "Nproduct [pId=" + pId + ", name=" + name + ", priceFInal=" + priceFInal + ", description=" + description
			+ ", categoryId=" + categoryId + ", imagenUrl=" + imagenUrl + "]";
}


}
