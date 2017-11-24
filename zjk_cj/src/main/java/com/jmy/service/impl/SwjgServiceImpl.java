package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmy.dao.SwjgMapper;
import com.jmy.entity.Swjg;
import com.jmy.entity.SwjgExample;
import com.jmy.service.SwjgService;

@Service("swjgService")
public class SwjgServiceImpl implements SwjgService {

	@Resource
	private SwjgMapper swjgMapper;
	@Override
	public List<Swjg> getSwjgsBySjswjg(String sjSwjg) {
		SwjgExample se = new SwjgExample();
		se.createCriteria().andSjswjgDmEqualTo(sjSwjg).andSwjgbzEqualTo("0");
		return swjgMapper.selectByExample(se);
	}
	@Override
	public Swjg getSwjgByswjg(String Swjg) {
		return swjgMapper.selectByPrimaryKey(Swjg);
	}
	@Override
	public List<Swjg> getSwjgs() {
		SwjgExample se = new SwjgExample();
		se.createCriteria().andSwjgbzEqualTo("0");
		return swjgMapper.selectByExample(se);
	}



}
