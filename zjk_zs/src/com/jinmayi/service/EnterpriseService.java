package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Enterprise;

public interface EnterpriseService {

	/**
	 * ������ҵ
	 * 
	 * @param enterprise
	 */
	public void save(Enterprise enterprise);

	/**
	 * �õ���ҵ������
	 * 
	 * @return
	 */
	public Integer getEnterprise(Short role, String keyword);

	/**
	 * ͨ���������õ���˾���б�
	 * 
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List<Enterprise> getEnterprise(Integer pageNow, Integer pageSize, Short role, String keyword);

	/**
	 * ͨ��ID���Ĺ�˾��״̬1
	 * 
	 * @param id
	 * @return
	 */
	public void changeStatus(Enterprise enterprise);

	public void changeConnect(Enterprise enterprise);

	/**
	 * ͨ��ID���Ĺ�˾��״̬2
	 * 
	 * @param id
	 * @return
	 */
	public void changeStatus1(Enterprise enterprise);

	public Enterprise getEnterpriseById(Integer id);

	public Integer updateEnterprise(Enterprise enterprise);

	/**
	 * ͨ����ҵ��õ���ҵ��Ϣ
	 * 
	 * @param token
	 * @return
	 */
	public Enterprise getEnterpriseByCode(String token);

	/**
	 * �޸�����
	 * 
	 * @param enterprise
	 */
	public void changePassword(Enterprise enterprise);

	public Integer updateScannumber(Integer id);

	public Integer updateQrcodeCount(Integer enterpriseid, Integer count);

	public Integer updateUserCount(Integer enterpriseid, Integer count);

}
