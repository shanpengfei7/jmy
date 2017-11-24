package com.jinmayi.dao.impl;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.ProductDao;
import com.jinmayi.entity.Product;

@Repository("productDao")
public class ProductDaoImpl extends BaseDAOImpl<Product> implements ProductDao {

}
