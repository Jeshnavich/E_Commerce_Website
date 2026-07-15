package com.example.demo.entity;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
Integer id;
String name;
String description;
String price;
String category;
String image;
public Product(Integer id, String name, String description, String price, String category, String image) {
super();
this.id = id;
this.name = name;
this.description = description;
this.price = price;
this.category = category;
this.image = image;
}
public Product() {
super();
}
public Integer getId() {
return id;
}
public void setId(Integer id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}
public String getPrice() {
return price;
}
public void setPrice(String price) {
this.price = price;
}
public String getCategory() {
return category;
}
public void setCategory(String category) {
this.category = category;
}
public String getImage() {
return image;
}
public void setImage(String image) {
this.image = image;
}

}

