package com.jmy.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jmy.dao.TaxMapper;
import com.jmy.entity.PreTime;
import com.jmy.entity.Tax;
import com.jmy.entity.TaxExample;
import com.jmy.service.PreTimeService;
import com.jmy.service.TaxService;
import com.jmy.util.DateFormatUtil;

@Service("taxService")
public class TaxServiceImpl implements TaxService {

	@Resource
	private TaxMapper taxMapper;
	@Resource
	private PreTimeService preTimeService;
	private JSONObject json = new JSONObject();

	@Override
	public Tax lastOne(int eid) {
		TaxExample te = new TaxExample();
		te.createCriteria().andEnterpriseIdEqualTo(eid);
		te.setOrderByClause("id desc");
		List<Tax> taxs = taxMapper.selectByExample(te);
		if (taxs.size() == 0) {
			return null;
		} else {
			return taxs.get(0);
		}
	}

	@Override
	public JSONObject submit(int eid, BigDecimal yingys, BigDecimal qysds, BigDecimal grsds, BigDecimal zys,
			BigDecimal yjs, BigDecimal fcs, BigDecimal yhs, BigDecimal tdsys, BigDecimal tdzzs, BigDecimal ccs,
			BigDecimal yanys, BigDecimal gdzys, BigDecimal qs, BigDecimal zzs, BigDecimal total) {

		Tax t = new Tax();
		t.setYingys(yingys);
		t.setQysds(qysds);
		t.setGrsds(grsds);

		t.setZys(zys);
		t.setYjs(yjs);
		t.setFcs(fcs);

		t.setYhs(yhs);
		t.setTdsys(tdsys);
		t.setTdzzs(tdzzs);

		t.setCcs(ccs);
		t.setYanys(yanys);
		t.setGdzys(gdzys);

		t.setQs(qs);
		t.setZzs(zzs);
		t.setTotal(total);
		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
		String nt = s.format(new Date());
		long now = DateFormatUtil.getTime(nt);
		t.setAddTime(now);
		PreTime p = preTimeService.getPreTimeByTime(now);
		if (p == null) {
			json.put("status", 0);
			json.put("error", "上报失败，未到上报时间！");
			return json;
		}
		t.setTimeId(p.getId());
		t.setEnterpriseId(eid);
		TaxExample te = new TaxExample();
		te.createCriteria().andTimeIdEqualTo(p.getId()).andEnterpriseIdEqualTo(eid);
		te.setOrderByClause("id desc");
		List<Tax> taxs = taxMapper.selectByExample(te);
		int r = 0;
		if (taxs.size() > 0) {
			t.setId(taxs.get(0).getId());
			r = taxMapper.updateByPrimaryKeySelective(t);
		} else {
			r = taxMapper.insertSelective(t);
			preTimeService.flag(p.getId());
		}
		if (r > 0) {
			json.put("status", 1);
		} else {
			json.put("status", 0);
			json.put("error", "上报失败！");
		}
		return json;
	}

	@Override
	public Tax getTax(int eid, int tid) {
		TaxExample te = new TaxExample();
		te.createCriteria().andTimeIdEqualTo(tid).andEnterpriseIdEqualTo(eid);
		List<Tax> taxs = taxMapper.selectByExample(te);
		if(taxs.size() > 0) {
			return taxs.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Tax getTax(int id) {
		return taxMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Tax> getTaxs(int enterpriseId) {
		TaxExample te = new TaxExample();
		te.createCriteria().andEnterpriseIdEqualTo(enterpriseId);
		te.setOrderByClause("id desc");
		return taxMapper.selectByExample(te);
	}

}
