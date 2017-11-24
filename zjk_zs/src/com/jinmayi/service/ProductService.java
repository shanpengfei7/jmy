package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Product;
import com.jinmayi.entity.Productproperty;

public interface ProductService {

	public List<Productproperty> getProductproperties(Integer pid);
	
	public Productproperty getProductpropertyById(Integer id);
	
	public void updateProductproperty(Productproperty productproperty);
	
	public void updateProductpropertyValue(Productproperty productproperty);
	
	public void deleteProductproperty(Productproperty productproperty);
	
	public void saveProductproperty(Productproperty productproperty);
	
	public Product getProductById(Integer id);
	
	/**
	 * –Õ∫≈…Û∫À
	 * @param version
	 * @param id
	 * @return
	 */
	public Integer checkProduct(String version, Integer id);

	public List<Product> getProductByEnidAndProcode(Integer enterpriseid, String procode);
}
