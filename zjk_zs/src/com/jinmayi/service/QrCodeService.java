package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Makeqrcode;
import com.jinmayi.entity.Qrcode;

public interface QrCodeService {

	public void printQrCodeBatch(Integer pid, Integer count, Integer eid,
			String pname, String pvalue, Double price);

	public String getLastQrCode(Integer pid, Integer eid);

	public Qrcode getQrCodeById(Integer id);

	public Qrcode getQrCodeByQrCode(String qrcode);

	public Qrcode getQrCodeByQrCode(Qrcode qrcode);

	/**
	 * 打包
	 * 
	 * @param employeeid
	 * @param sonids
	 * @param parentid
	 * @param soncount
	 * @return
	 */
	public Integer packageQrCode(Integer enterpriseid, Integer employeeid,
			List<Integer> sonids, Integer parentid, Integer soncount,
			String place);
	/**
	 * 拆包
	 * 
	 * @param employeeid
	 * @param sonids
	 * @param parentid
	 * @param soncount
	 * @return
	 */
	public Integer packageUnQrCode(Integer enterpriseid, Integer employeeid,
			List<Integer> parentids, String place);

	/**
	 * 销售
	 * 
	 * @param qrcode
	 * @return
	 */
	public void sellQrCode(List<Qrcode> qrcodes, Integer enid, Integer emid,
			String sellplace);

	/**
	 * 评价
	 * 
	 * @param qrcode
	 * @return
	 */
	public Integer sellEvaluate(Integer id);

	/**
	 * 这个厂家所有的码,分页
	 * 
	 * @param eid
	 * @param pid
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Qrcode> getQrcodes(Integer eid, Integer pid, Integer page,
			Integer rows);

	public Integer getQrcodeCount(Integer eid, Integer pid);

	public List<Qrcode> getSellQrcodes(Integer eid, Integer pid, Integer page,
			Integer rows);

	public Integer getSellQrcodeCount(Integer eid, Integer pid);

	/**
	 * 厂家未使用的码量
	 * 
	 * @param eid
	 * @param pid
	 * @return
	 */
	public Integer getNoUseQrcodeCount(Integer eid, Integer pid);

	public List<Qrcode> getQrcodesByParentId(Integer pid);

	public Integer getQrcodeCountBySeEnId(Integer sid);

	public List<Qrcode> getQrcodesBySeEnId(Integer sid, Integer page,
			Integer rows);

	public Integer updateScanCountAddOne(Integer id);

	public List<Makeqrcode> getMakeqrcodesByEidAndPid(Integer eid, Integer pid);

	public List<Qrcode> getQrcodesByMakeQrCodeId(Integer id);

	public Integer updateMakeQrCode(Integer id);

	public List<Makeqrcode> getMakeQrCodesByEnId(Integer id);

	public Integer getQrcodeCountByMqid(Integer makeQrCodeId);
	
	public List<Qrcode> getQrcodesByMqid(Integer makeQrCodeId, Integer page,
			Integer rows);
	
	public Integer getNoUseQrcodeCountByMqid(Integer makeQrCodeId);
	
}
