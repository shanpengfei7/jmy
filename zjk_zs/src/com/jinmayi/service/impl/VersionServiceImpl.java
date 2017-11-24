package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.CoiCategoryOneDao;
import com.jinmayi.dao.CoiCategoryThreeDao;
import com.jinmayi.dao.CoiCategoryTwoDao;
import com.jinmayi.dao.ProductDao;
import com.jinmayi.entity.CoiCategoryOne;
import com.jinmayi.entity.CoiCategoryThree;
import com.jinmayi.entity.CoiCategoryTwo;
import com.jinmayi.entity.Product;
import com.jinmayi.service.VersionService;

@Service("versionService")
public class VersionServiceImpl implements VersionService {

	@Resource
	private CoiCategoryOneDao coiCategoryOneDao;
	@Resource
	private CoiCategoryTwoDao coiCategoryTwoDao;
	@Resource
	private CoiCategoryThreeDao coiCategoryThreeDao;
	@Resource
	private ProductDao productDao;

	@Override
	public List<CoiCategoryOne> getCoiCategoryOnes() {
		return coiCategoryOneDao.find(" from CoiCategoryOne where isdel = ? and status = ?",
				new Object[] { (short) 0, (short) 1 });
	}

	@Override
	public List<CoiCategoryTwo> getcoiCategoryTwos(Integer id) {
		return coiCategoryTwoDao.find(" from CoiCategoryTwo where pid = ? and isdel = ? and status = ?",
				new Object[] { id, (short) 0, (short) 1 });
	}

	@Override
	public List<CoiCategoryThree> getcoiCategoryThrees(Integer id) {
		return coiCategoryThreeDao.find(" from CoiCategoryThree where pid = ? and isdel = ? and status = ?",
				new Object[] { id, (short) 0, (short) 1 });
	}

	@Override
	public List<Product> getProductsApplying(Integer eid) {
		return productDao.find(" from Product where enterpriseid = ? and ispackage = 0 and isdelete = 0 order by id desc", new Object[] { eid });
	}
	@Override
	public List<Product> getProductsApplying() {
		return productDao.find(" from Product where ispackage = 0 and isdelete = 0 order by id desc");
	}
	@Override
	public List<Product> getProductsApplyingp(Integer eid) {
		return productDao.find(" from Product where enterpriseid = ? and ispackage = 1 and isdelete = 0 order by id desc", new Object[] { eid });
	}
	@Override
	public List<Product> getProductsApplyingp() {
		return productDao.find(" from Product where ispackage = 1 and isdelete = 0 order by id desc");
	}

	@Override
	public List<Product> getProductsApplied(Integer eid) {
		return productDao.find(" from Product where isapply = 1 and enterpriseid = ? and ispackage = 0 and isdelete = 0 order by id desc",
				new Object[] { eid });
	}
	@Override
	public List<Product> getProductsApplied() {
		return productDao.find(" from Product where isapply = 1 and ispackage = 0 and isdelete = 0 order by id desc");
	}
	@Override
	public List<Product> getProductsAppliedp(Integer eid) {
		return productDao.find(" from Product where isapply = 1 and enterpriseid = ? and ispackage = 1 and isdelete = 0 order by id desc",
				new Object[] { eid });
	}
	@Override
	public List<Product> getProductsAppliedp() {
		return productDao.find(" from Product where isapply = 1 and ispackage = 1 and isdelete = 0 order by id desc");
	}

	@Override
	public List<Product> getProductsApplyingPcg(Integer eid) {
		return productDao.find(" from Product where enterpriseid = ? and ispackage = 1 and isdelete = 0 order by id desc", new Object[] { eid });
	}
	
	@Override
	public List<Product> getProductsAppliedPcg(Integer eid) {
		return productDao.find(" from Product where isapply = 1 and enterpriseid = ? and ispackage = 1 and isdelete = 0 order by id desc",
				new Object[] { eid });
	}
	@Override
	public CoiCategoryThree getCoiCategoryThree(Integer id) {
		return coiCategoryThreeDao.get(CoiCategoryThree.class, id);
	}

	@Override
	public void saveProduct(Product product) {
		productDao.save(product);

	}

	@Override
	public Product getProduct(Integer id) {
		return productDao.get(Product.class, id);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.executeHql("update Product set tradename = ?, description = ? where id = ?",
				new Object[] { product.getTradename(), product.getDescription(), product.getId()});

	}

	@Override
	public void deleteProduct(Integer id) {
		productDao.executeHql("update Product set isdelete = 1 where id = ?",
				new Object[] { id});
		
	}

	@Override
	public void addInformationToProduct(Product product) {
		productDao.executeHql("update Product set information = ? where id = ?",
				new Object[] { product.getInformation(), product.getId()});

		
	}

}
