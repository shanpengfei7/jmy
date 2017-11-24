package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.ProductDao;
import com.jinmayi.dao.ProductPropertyDao;
import com.jinmayi.entity.Product;
import com.jinmayi.entity.Productproperty;
import com.jinmayi.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;
	
	@Resource
	private ProductPropertyDao productPropertyDao;

	@Override
	public List<Productproperty> getProductproperties(Integer pid) {
		return productPropertyDao.find(" from Productproperty where productid = ?", new Object[]{pid});
	}

	@Override
	public Productproperty getProductpropertyById(Integer id) {
		return productPropertyDao.get(Productproperty.class, id);
	}

	@Override
	public void updateProductproperty(Productproperty productproperty) {
		productPropertyDao.executeHql("update Productproperty set name = ?,value = ?, description = ? where id = ?", new Object[]{productproperty.getName(),productproperty.getValue(), productproperty.getDescription(),productproperty.getId()});
		
	}

	@Override
	public void deleteProductproperty(Productproperty productproperty) {
		productPropertyDao.delete(productproperty);
		
	}

	@Override
	public void saveProductproperty(Productproperty productproperty) {
		productPropertyDao.saveOrUpdate(productproperty);
		
	}

	@Override
	public void updateProductpropertyValue(Productproperty productproperty) {
		productPropertyDao.executeHql("update Productproperty set value = ? where id = ?", new Object[]{productproperty.getValue(), productproperty.getId()});
		
	}

	@Override
	public Product getProductById(Integer id) {
		Product p = productDao.get(Product.class, id);
		List<Productproperty> pp = productPropertyDao.getProductpropertiesByProductId(id);
		
		p.setProductproperties(pp);
		return p;
	}

	@Override
	public Integer checkProduct(String version, Integer id) {
		return productDao.executeHql("update Product set isapply = 1, version = ? where id = ?", new Object[]{version, id});
	}

	@Override
	public List<Product> getProductByEnidAndProcode(Integer enterpriseid,
			String procode) {
		String hql = " from Product where isdelete = 0 and enterpriseid = ? and procode = ?";
		return productDao.find(hql, new Object[]{enterpriseid, procode});
	}
}
