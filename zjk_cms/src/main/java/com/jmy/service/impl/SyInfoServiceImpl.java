package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmy.dao.SyInfoMapper;
import com.jmy.entity.SyInfo;
import com.jmy.entity.SyInfoExample;
import com.jmy.service.SyInfoService;

@Service("syInfoService")
public class SyInfoServiceImpl implements SyInfoService {

	@Resource
	private SyInfoMapper syInfoMapper;
	@Override
	public List<SyInfo> getInfos(int version_id) {
		SyInfoExample s = new SyInfoExample();
		s.createCriteria().andIsDelEqualTo((byte)0).andVersionIdEqualTo(version_id);
		s.setOrderByClause("sort asc");;
		return syInfoMapper.selectByExampleWithBLOBs(s);
	}
	@Override
	public SyInfo getInfoById(int id) {
		return syInfoMapper.selectByPrimaryKey(id);
	}
	@Override
	public int save(SyInfo s) {
		SyInfoExample se = new SyInfoExample();
		se.createCriteria().andIsDelEqualTo((byte)0).andVersionIdEqualTo(s.getVersionId());
		int result = syInfoMapper.selectByExample(se).size();
		if(result > 3) {
			return 0;
		} else {
			s.setIsDel((byte)0);
			return syInfoMapper.insertSelective(s);
		}
	}
	@Override
	public int edit(SyInfo s) {
		return syInfoMapper.updateByPrimaryKeyWithBLOBs(s);
	}
	@Override
	public int del(int id) {
		SyInfo s = new SyInfo();
		s.setIsDel((byte)1);
		s.setId(id);
		return syInfoMapper.updateByPrimaryKeySelective(s);
	}

}
