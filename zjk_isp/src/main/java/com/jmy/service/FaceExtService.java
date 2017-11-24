package com.jmy.service;

import com.jmy.entity.Faceext;
import com.jmy.util.DataShowPage;

public interface FaceExtService {

	/**
	 * 套餐续费
	 * @param faceext
	 * @return
	 */
	public int save(Faceext faceext);
	
	public DataShowPage getFaceExts(int fid, int pageNum,int pageSize);
	
	public Faceext getFaceext(int id);
}
