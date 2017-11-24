package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.CoiCategoryOne;
import com.jinmayi.entity.CoiCategoryThree;
import com.jinmayi.entity.CoiCategoryTwo;
import com.jinmayi.entity.Product;

public interface VersionService {

	public List<CoiCategoryOne> getCoiCategoryOnes();

	public List<CoiCategoryTwo> getcoiCategoryTwos(Integer id);

	public List<CoiCategoryThree> getcoiCategoryThrees(Integer id);

	public List<Product> getProductsApplying(Integer eid);

	public List<Product> getProductsApplying();

	public List<Product> getProductsApplyingp(Integer eid);

	public List<Product> getProductsApplyingp();

	public List<Product> getProductsApplied(Integer eid);

	public List<Product> getProductsApplied();

	public List<Product> getProductsAppliedp(Integer eid);

	public List<Product> getProductsAppliedp();

	public List<Product> getProductsApplyingPcg(Integer eid);

	public List<Product> getProductsAppliedPcg(Integer eid);

	public CoiCategoryThree getCoiCategoryThree(Integer id);

	public void saveProduct(Product product);

	public Product getProduct(Integer id);

	public void updateProduct(Product product);

	public void deleteProduct(Integer id);

	public void addInformationToProduct(Product product);
	
	
}
