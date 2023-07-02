package com.vallabha.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.vallabha.entites.Product;

@Service   
public interface ProductService 
{
	public String addProduct(@ModelAttribute Product product);
	
	public List<Product> getAllProducts();

	public Product getProduct(Integer pid);
	
	public String deleteProduct(Integer pid);
	
	public String updateProduct(Integer pid);
}
