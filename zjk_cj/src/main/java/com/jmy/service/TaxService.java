package com.jmy.service;

import java.math.BigDecimal;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Tax;

public interface TaxService {

	/**
	 * 拿到企业最后一次上报 的数据
	 * 
	 * @param eid
	 * @return
	 */
	public Tax lastOne(int eid);

	/**
	 * 企业税收预测数上报，保存上报的数据
	 * 
	 * @param tax
	 * @return
	 */
	public JSONObject submit(int eid, BigDecimal yingys, BigDecimal qysds, BigDecimal grsds, BigDecimal zys, BigDecimal yjs,
			BigDecimal fcs, BigDecimal yhs, BigDecimal tdsys, BigDecimal tdzzs, BigDecimal ccs, BigDecimal yanys,
			BigDecimal gdzys, BigDecimal qs, BigDecimal zzs, BigDecimal total);

	/**
	 * 拿到企业税收预测数上报历史数据，按月查询
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param time
	 * @return
	 */
	public Tax getTax(int eid, int tid);
	
	public Tax getTax(int id);
	
	public List<Tax> getTaxs(int enterpriseId);
}
