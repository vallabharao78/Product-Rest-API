package com.vallabha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.vallabha.entites.Product;
import com.vallabha.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepo;

	@Override
	public String addProduct(@ModelAttribute Product product) {
		productRepo.save(product);
		return "Product Saved Successfuly !!...";
	}

	@Override
	public Product getProduct(Integer pid) {
		if(productRepo.existsById(pid))
		{
			Product product = productRepo.getById(pid);
			return product;
		}
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
	    List<Product> products = productRepo.findAll();
		return products;
	}

	@Override
	public String deleteProduct(Integer pid) {

		if(productRepo.existsById(pid))
		{
			productRepo.deleteById(pid);
			return "Product "+pid+" Deleted Succesfully";
		}
		return "Product "+pid+" Not Found...";
	}

	@Override
	public String updateProduct(Integer pid) {
		if(productRepo.existsById(pid))
		{
			Product product = null;
			product.setName(product.getName());
			product.setPrice(product.getPrice());
			
			productRepo.save(product);
			return "Product Updated Succesfully";
		}
		return "Product Not Found to Update...";
	}	
}
