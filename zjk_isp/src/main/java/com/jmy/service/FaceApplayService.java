package com.jmy.service;

import com.jmy.entity.Faceapplay;
import com.jmy.entity.Faceinfo;
import com.jmy.util.DataShowPage;

public interface FaceApplayService {

	/**
	 * 套餐申请
	 * @param faceapplay
	 * @return
	 */
	public int applay(Faceapplay faceapplay);
	
	/**
	 * 套餐审核通过
	 * @param faceapplay
	 * @return
	 */
	public int check(Faceapplay faceapplay,Faceinfo faceinfo);
	/**
	 * 套餐审核拒绝
	 * @param faceapplay
	 * @return
	 */
	public int uncheck(Faceapplay faceapplay);
	
	public DataShowPage getFaceapplays(int pageNum,int pageSize, String user, String tao, byte status);
	
	public DataShowPage getFaceapplays(int id, int pageNum,int pageSize);
	
	public Faceapplay getFaceapplayById(int id);
	
	/**
	 * 超管修改套餐的钱
	 * @param faceapplay
	 * @return
	 */
	public int edit(Faceapplay faceapplay);
}
