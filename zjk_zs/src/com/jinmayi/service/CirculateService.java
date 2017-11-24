package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Circulate;
import com.jinmayi.entity.Qrcode;

public interface CirculateService {

	/**
	 * ���� isdelete qrcodeid deliveremployeeid isreceive delivertime deliverplace
	 * 
	 * @param circulate
	 * @return
	 */
	public void newGood(Integer wayBillId, List<Qrcode> qrcodes, Long time, Integer deliverenterpriseid,
			Integer deliveremployeeid, String deliverplace, Integer willreceiveenterpriseid);

	/**
	 * �ջ� qrcodeid receiveemployeeid receiveenterpriseid receiveplace
	 * 
	 * @param circulate
	 * @return
	 */
	public Integer updateGood(List<Integer> integers, Long time, Integer flag, Integer receiveenterpriseid,
			Integer receiveemployeeid, String receiveplace);

	public Circulate getCirculateByQrCodeId(Integer qrcodeid, Integer willreceiveenterpriseid);

	public List<Circulate> getCirculatesByWaybillid(Integer waybillid, Integer willreceiveenterpriseid);

	/**
	 * ȡ������
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
	 * ����ҵ�Ƿ��ѷ�������Ʒ
	 * 
	 * @param enterpriseid
	 * @param qrcodeid
	 * @return
	 */
	public Boolean isDeliver(Integer enterpriseid, Integer qrcodeid);

	/**
	 * ����ҵ�Ƿ����ջ�����Ʒ
	 * 
	 * @param enterpriseid
	 * @param qrcodeid
	 * @return
	 */
	public Boolean isReceive(Integer enterpriseid, Integer qrcodeid);

	/**
	 * �˵��е���ϸ��Ʒ��Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public List<Circulate> getCirculatesByWaybillId(Integer id);

	public Integer getCirculatesCount(Integer id);

	public List<Circulate> getCirculatesByWaybillId(Integer[] ids, Integer id);

	public Integer getCirculatesCount(List<Integer> ids, Integer id);

}
