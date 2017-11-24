package com.jmy.service;

import com.jmy.util.DataShowPage;

public interface CategoryService {
	public DataShowPage getOne(int pageNum, int pageSize);

	public DataShowPage getTwo(int tid, int pageNum, int pageSize);

	public DataShowPage getThree(int tid, int pageNum, int pageSize);

}
