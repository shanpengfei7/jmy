package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Circulate;
import com.jinmayi.entity.Qrcode;

public interface CirculateService {

	/**
	 * 发货 isdelete qrcodeid deliveremployeeid isreceive delivertime deliverplace
	 * 
	 * @param circulate
	 * @return
	 */
	public void newGood(Integer wayBillId, List<Qrcode> qrcodes, Long time, Integer deliverenterpriseid,
			Integer deliveremployeeid, String deliverplace, Integer willreceiveenterpriseid);

	/**
	 * 收货 qrcodeid receiveemployeeid receiveenterpriseid receiveplace
	 * 
	 * @param circulate
	 * @return
	 */
	public Integer updateGood(List<Integer> integers, Long time, Integer flag, Integer receiveenterpriseid,
			Integer receiveemployeeid, String receiveplace);

	public Circulate getCirculateByQrCodeId(Integer qrcodeid, Integer willreceiveenterpriseid);

	public List<Circulate> getCirculatesByWaybillid(Integer waybillid, Integer willreceiveenterpriseid);

	/**
	 * 取消发货
	 * 
	 * @param circulate
	 * @return
	 */
	public Integer deleteGood(Circulate circulate);

	public List<Circulate> getCirculateByQrCodeId(Integer id);

	public Integer getCirculateCountByDeEmId(Integer did);

	public Integer getCirculateCountByReEmId(Integer rid);

	public List<Circulate> getCirculatesByDeEmId(Integer did, Integer page, Integer rows);

	public List<Circulate> getCirculatesByReEmId(Integer rid, Integer page, Integer rows);

	/**
	 * 该企业是否已发货该物品
	 * 
	 * @param enterpriseid
	 * @param qrcodeid
	 * @return
	 */
	public Boolean isDeliver(Integer enterpriseid, Integer qrcodeid);

	/**
	 * 该企业是否已收货该物品
	 * 
	 * @param enterpriseid
	 * @param qrcodeid
	 * @return
	 */
	public Boolean isReceive(Integer enterpriseid, Integer qrcodeid);

	/**
	 * 运单中的详细物品信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Circulate> getCirculatesByWaybillId(Integer id);

	public Integer getCirculatesCount(Integer id);

	public List<Circulate> getCirculatesByWaybillId(Integer[] ids, Integer id);

	public Integer getCirculatesCount(List<Integer> ids, Integer id);

}
