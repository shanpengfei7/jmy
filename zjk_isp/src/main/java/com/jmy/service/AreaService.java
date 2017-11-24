package com.jmy.service;

import com.jmy.util.DataShowPage;

public interface AreaService {

	public DataShowPage getArea(int pageNum, int pageSize);

	public DataShowPage getArea(int tid, int pageNum, int pageSize);

}
