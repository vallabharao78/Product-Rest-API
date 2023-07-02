package com.vallabha.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vallabha.entites.Product;
import com.vallabha.service.ProductService;

@Controller
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public String product()
	{
		return "product";
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<String> addProduct(@ModelAttribute Product product)
	{
		String status = productService.addProduct(product);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> allProducts = productService.getAllProducts();
		return new ResponseEntity<>(allProducts,HttpStatus.OK);		
	}
	
	@GetMapping("/getProduct/{pid}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer pid)
	{
		Product product = productService.getProduct(pid);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@PostMapping("updateProduct/{pid}")
	public ResponseEntity<String> updateProduct(@PathVariable Integer pid)
	{
		String status = productService.updateProduct(pid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("deleteProduct/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pid)
	{
		String status = productService.deleteProduct(pid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}		
}
