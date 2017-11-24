package com.jmy.controller.user;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Enterprise;
import com.jmy.entity.PreTime;
import com.jmy.entity.Swjg;
import com.jmy.entity.Tax;
import com.jmy.entity.son.TaxSon;
import com.jmy.service.PreTimeService;
import com.jmy.service.SwjgService;
import com.jmy.service.TaxService;
import com.jmy.util.DateFormatUtil;

@Controller
@RequestMapping("/user/tax")
public class UserTaxController {
	@Resource
	private TaxService taxService;
	@Resource
	private PreTimeService preTimeService;
	@Resource
	private SwjgService swjgService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Map<String, Object> add(Map<String, Object> map, HttpSession session) {
		Enterprise e = (Enterprise) session.getAttribute("enterprise");
		Tax t = taxService.lastOne(e.getId());
		if (t == null) {
			return null;
		}
		map.put("yingys", t.getYingys());
		map.put("qysds", t.getQysds());
		map.put("zys", t.getZys());
		map.put("fcs", t.getFcs());
		map.put("tdsys", t.getTdsys());

		map.put("ccs", t.getCcs());
		map.put("gdzys", t.getGdzys());
		map.put("zzs", t.getZzs());
		map.put("grsds", t.getGrsds());
		map.put("yjs", t.getYjs());

		map.put("yhs", t.getYhs());
		map.put("tdzzs", t.getTdzzs());
		map.put("yanys", t.getYanys());
		map.put("qs", t.getQs());
		map.put("total", t.getTotal());
		return map;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Map<String, Object> map, HttpSession session, @RequestParam(defaultValue = "") String yingys,
			@RequestParam(defaultValue = "") String qysds, @RequestParam(defaultValue = "") String grsds,
			@RequestParam(defaultValue = "") String zys, @RequestParam(defaultValue = "") String yjs,
			@RequestParam(defaultValue = "") String fcs, @RequestParam(defaultValue = "") String yhs,
			@RequestParam(defaultValue = "") String tdsys, @RequestParam(defaultValue = "") String tdzzs,
			@RequestParam(defaultValue = "") String ccs, @RequestParam(defaultValue = "") String yanys,
			@RequestParam(defaultValue = "") String gdzys, @RequestParam(defaultValue = "") String qs,
			@RequestParam(defaultValue = "") String zzs) {
		
		yingys = yingys.trim();
		grsds = grsds.trim();
		yjs = yjs.trim();
		yhs = yhs.trim();
		tdzzs = tdzzs.trim();
		yanys = yanys.trim();
		qs = qs.trim();
		
		qysds = qysds.trim();
		zys = zys.trim();
		fcs = fcs.trim();
		tdsys = tdsys.trim();
		ccs = ccs.trim();
		gdzys = gdzys.trim();
		zzs = zzs.trim();
		
		if("".equals(yingys)) {
			yingys="0";
		}
		if("".equals(grsds)) {
			grsds="0";
		}
		if("".equals(yjs)) {
			yjs="0";
		}
		if("".equals(yhs)) {
			yhs="0";
		}
		if("".equals(tdzzs)) {
			tdzzs="0";
		}
		if("".equals(yanys)) {
			yanys="0";
		}
		if("".equals(qs)) {
			qs="0";
		}
		if("".equals(qysds)) {
			qysds="0";
		}
		if("".equals(zys)) {
			zys="0";
		}
		if("".equals(fcs)) {
			fcs="0";
		}
		if("".equals(tdsys)) {
			tdsys="0";
		}
		if("".equals(ccs)) {
			ccs="0";
		}
		if("".equals(gdzys)) {
			gdzys="0";
		}
		if("".equals(zzs)) {
			zzs="0";
		}
		
		
		
		BigDecimal b_yingys= new BigDecimal(yingys);
		BigDecimal b_grsds= new BigDecimal(grsds);
		BigDecimal b_yjs= new BigDecimal(yjs);
		BigDecimal b_yhs= new BigDecimal(yhs);
		BigDecimal b_tdzzs= new BigDecimal(tdzzs);
		BigDecimal b_yanys= new BigDecimal(yanys);
		BigDecimal b_qs= new BigDecimal(qs);
		BigDecimal b_qysds= new BigDecimal(qysds);
		BigDecimal b_zys= new BigDecimal(zys);
		BigDecimal b_fcs= new BigDecimal(fcs);
		BigDecimal b_tdsys= new BigDecimal(tdsys);
		BigDecimal b_ccs= new BigDecimal(ccs);
		BigDecimal b_gdzys= new BigDecimal(gdzys);
		BigDecimal b_zzs= new BigDecimal(zzs);
		BigDecimal total = b_yingys.add(b_qysds).add(b_grsds).add(b_zys).add(b_yjs).add(b_fcs).add(b_yhs).add(b_tdsys).add(b_tdzzs)
				.add(b_ccs).add(b_yanys).add(b_gdzys).add(b_qs).add(b_zzs);
		Enterprise e = (Enterprise) session.getAttribute("enterprise");
		JSONObject json = taxService.submit(e.getId(), b_yingys, b_qysds, b_grsds, b_zys, b_yjs, b_fcs, b_yhs, b_tdsys, b_tdzzs, b_ccs,
				b_yanys, b_gdzys, b_qs, b_zzs, total);
		map.put("yingys", yingys);
		map.put("qysds", qysds);
		map.put("zys", zys);
		map.put("fcs", fcs);
		map.put("tdsys", tdsys);

		map.put("ccs", ccs);
		map.put("gdzys", gdzys);
		map.put("zzs", zzs);
		map.put("grsds", grsds);
		map.put("yjs", yjs);

		map.put("yhs", yhs);
		map.put("tdzzs", tdzzs);
		map.put("yanys", yanys);
		map.put("qs", qs);
		map.put("total", total);
		if (json.getInteger("status") == 0) {

			map.put("error", json.getString("error"));
			return "user/tax/add";
		}
		map.put("data", json);
		map.put("error", "上报成功！");
		return "user/tax/add";
	}

	@RequestMapping(value = "/list")
	public Map<String, Object> list(Map<String, Object> map, HttpSession session,
			@RequestParam(defaultValue = "0") String time) {
		time = time.trim();
		if ("0".equals(time)) {
			SimpleDateFormat s = new SimpleDateFormat("YYYY-MM");
			time = s.format(new Date());
		} else if ("".equals(time)) {
			SimpleDateFormat s = new SimpleDateFormat("YYYY-MM");
			time = s.format(new Date());
		}
		map.put("time", time);
		long start = DateFormatUtil.getTime(time + "-01");
		long end = DateFormatUtil.getTime(time + "-31");
		List<PreTime> times = preTimeService.getTimesByTime(start, end);
		Enterprise e = (Enterprise) session.getAttribute("enterprise");

		List<TaxSon> taxs = new ArrayList<TaxSon>();
		for (PreTime p : times) {
			Tax t = taxService.getTax(e.getId(), p.getId());
			if (t != null) {
				Swjg swjg = swjgService.getSwjgByswjg(e.getSwjgDm());
				TaxSon s = new TaxSon(DateFormatUtil.getStrTime(t.getAddTime()),
						DateFormatUtil.getStrTime(p.getNowTime()), e.getIdCode(), e.getName(), e.getSwjgDm(),swjg.getSwjgmc());
				s.setId(t.getId());
				s.setAddTime(t.getAddTime());
				s.setCcs(t.getCcs());
				s.setEnterpriseId(t.getEnterpriseId());
				s.setFcs(t.getFcs());
				s.setGdzys(t.getGdzys());
				s.setGrsds(t.getGrsds());
				s.setQs(t.getQs());
				s.setQysds(t.getQysds());
				s.setTdsys(t.getTdsys());
				s.setTdzzs(t.getTdzzs());
				s.setTimeId(t.getTimeId());
				s.setTotal(t.getTotal());
				s.setYanys(t.getYanys());
				s.setYhs(t.getYhs());
				s.setYingys(t.getYingys());
				s.setYjs(t.getYjs());
				s.setZys(t.getZys());
				s.setZzs(t.getZzs());

				taxs.add(s);
			}
		}
		map.put("data", taxs);
		return map;
	}
}
