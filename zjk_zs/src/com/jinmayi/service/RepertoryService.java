package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Repertory;

public interface RepertoryService {

	public List<Repertory> getRepertories(Integer enterpriseid);

	public Repertory getRepertories(Integer enterpriseid, Integer qrcodeid);

	/**
	 * 增加库存
	 * 
	 * @param r
	 * @return
	 */
	public Long save(Repertory r);

	/**
	 * 发货后减少库存
	 * 
	 * @param r
	 * @return
	 */
	public Integer delete(Repertory r);

	public List<Repertory> getRepertoriesByQrCodeId(Integer qrcodeid);
}
