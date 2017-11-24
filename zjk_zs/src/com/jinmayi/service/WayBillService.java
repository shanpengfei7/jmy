package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Waybill;

public interface WayBillService {

	public Integer saveWayBill(Waybill w);

	public void updateWayBill(Waybill w);
	
	public void deleteWayBill(Waybill w);
	
	/**
	 * ����������Ϣ
	 * @param enterpriseid
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List<Waybill> getWaybillsByDeEnId(Integer enterpriseid, Integer pageNow, Integer pageSize);
	
	/**
	 * �Է������ջ�����Ϣ
	 * @param enterpriseid
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List<Waybill> getWaybillsByReEnId(Integer enterpriseid, Integer pageNow, Integer pageSize);
	
	public Integer getWaybillsCountByDeEnId(Integer enterpriseid);
	
	public Integer getWaybillsCountByReEnId(Integer enterpriseid);
	
	/**
	 * ͨ�����ջ���ҵ�õ��˵�
	 * @param id
	 * @return
	 */
	public Waybill getWaybillByWillEnterpriseId(Integer id, Integer willEnterpriseId);
	
	/**
	 * ͨ���˵����õ��˵�
	 * @param number
	 * @return
	 */
	public Waybill getWaybillByNumbwer(String number);
	
	
	/**
	 * ����������Ϣ
	 * @param enterpriseid
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List<Waybill> getWaybillsByDeEmId(Integer employeeid, Integer pageNow, Integer pageSize, String date);
	
	/**
	 * �Է������ջ�����Ϣ
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
