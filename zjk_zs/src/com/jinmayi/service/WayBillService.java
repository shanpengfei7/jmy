package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Waybill;

public interface WayBillService {

	public Integer saveWayBill(Waybill w);

	public void updateWayBill(Waybill w);
	
	public void deleteWayBill(Waybill w);
	
	/**
	 * 发货单的信息
	 * @param enterpriseid
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List<Waybill> getWaybillsByDeEnId(Integer enterpriseid, Integer pageNow, Integer pageSize);
	
	/**
	 * 对发货单收货的信息
	 * @param enterpriseid
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List<Waybill> getWaybillsByReEnId(Integer enterpriseid, Integer pageNow, Integer pageSize);
	
	public Integer getWaybillsCountByDeEnId(Integer enterpriseid);
	
	public Integer getWaybillsCountByReEnId(Integer enterpriseid);
	
	/**
	 * 通过将收货企业拿到运单
	 * @param id
	 * @return
	 */
	public Waybill getWaybillByWillEnterpriseId(Integer id, Integer willEnterpriseId);
	
	/**
	 * 通过运单号拿到运单
	 * @param number
	 * @return
	 */
	public Waybill getWaybillByNumbwer(String number);
	
	
	/**
	 * 发货单的信息
	 * @param enterpriseid
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List<Waybill> getWaybillsByDeEmId(Integer employeeid, Integer pageNow, Integer pageSize, String date);
	
	/**
	 * 对发货单收货的信息
	 * @param enterpriseid
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List<Waybill> getWaybillsByReEmId(Integer employeeid, Integer pageNow, Integer pageSize, String date);
	
	public Integer getWaybillsCountByDeEmId(Integer employeeid, String date);
	
	public Integer getWaybillsCountByReEmId(Integer employeeid, String date);
	
	public Waybill getWaybillById(Integer id);
	
	public Integer printWaybill(Waybill w);
	
}
