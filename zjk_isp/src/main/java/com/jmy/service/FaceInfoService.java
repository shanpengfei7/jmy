package com.jmy.service;

import com.jmy.entity.Faceinfo;
import com.jmy.util.DataShowPage;

public interface FaceInfoService {

	public int save(Faceinfo faceinfo);

	public DataShowPage getFaceinfos(int pageNum, int pageSize, String user, String tao, byte status);

	public DataShowPage getFaceinfos(int id, int pageNum, int pageSize);

	public Faceinfo getFaceinfoById(int id);

	/**
	 * 套餐反审核
	 * 
	 * @param faceinfo
	 * @return
	 */
	public int unCheck(Faceinfo faceinfo);

	/**
	 * 套餐续费的时候，修改有效时间点
	 * 
	 * @param faceinfo
	 * @return
	 */
	public int edit(Faceinfo faceinfo);
}
