package com.jmy.controller.app;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jmy.entity.Enterprise;
import com.jmy.entity.PreTime;
import com.jmy.entity.Tax;
import com.jmy.service.EnterpriseService;
import com.jmy.service.PreTimeService;
import com.jmy.service.SwjgService;
import com.jmy.service.TaxService;
import com.jmy.util.DateFormatUtil;

@Controller
@RequestMapping("/app/tax")
public class AppTaxController {

	@Resource
	private PreTimeService preTimeService;
	@Resource
	private TaxService taxService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private SwjgService swjgService;

	private JSONObject json = new JSONObject();

	/**
	 * 本月上报信息
	 * 
	 * @param enterpriseId
	 * @return
	 */
	@RequestMapping("/month")
	public @ResponseBody JSONObject month(@RequestParam(defaultValue = "") int enterpriseId) {
		json.clear();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM");
		String time = sdf.format(new Date());
		long start = DateFormatUtil.getTime(time + "-01");
		long end = DateFormatUtil.getTime(time + "-31");
		List<PreTime> times = preTimeService.getTimesByTime(start, end);
		Enterprise e = enterpriseService.getEnterpriseById(enterpriseId);

		JSONArray js = new JSONArray();
		
		String re_StrTime = null;

		SimpleDateFormat sd = new SimpleDateFormat("dd");

		for (PreTime p : times) {
			Tax t = taxService.getTax(e.getId(), p.getId());
			if (t != null) {

				JSONObject j = new JSONObject();
				j.put("id", t.getId());
				j.put("total", t.getTotal()+"");
				Long sj = t.getAddTime();
				String rq = DateFormatUtil.getStrTime(sj);
				String xq = DateFormatUtil.getWeekOfDate(sj);
				j.put("addTime", rq);
				j.put("week", xq);
				PreTime preTime = preTimeService.getPreTimeById(t.getTimeId());
				preTime.getNowTime();

				re_StrTime = sd.format(new Date(preTime.getNowTime()));
				j.put("stopTime", re_StrTime);

				js.add(j);
			}
		}
		json.put("status", 1);
		json.put("error", "");
		json.put("data", js);

		return json;
	}

	/**
	 * 单个信息查看
	 * 
	 * @param enterpriseId
	 * @return
	 */
	@RequestMapping("/show")
	public @ResponseBody JSONObject show(@RequestParam(defaultValue = "") int taxId) {
		json.clear();
		Tax t = taxService.getTax(taxId);
		json.put("status", 1);
		json.put("error", "");
		json.put("yingys", t.getYingys()+"");
		json.put("qysds", t.getQysds()+"");
		json.put("grsds", t.getGrsds()+"");
		json.put("zys", t.getZys()+"");
		json.put("yjs", t.getYjs()+"");
		json.put("fcs", t.getFcs()+"");
		json.put("yhs", t.getYhs()+"");
		json.put("tdsys", t.getTdsys()+"");
		json.put("tdzzs", t.getTdzzs()+"");
		json.put("ccs", t.getCcs()+"");
		json.put("yanys", t.getYanys()+"");
		json.put("gdzys", t.getGdzys()+"");
		json.put("qs", t.getQs()+"");
		json.put("zzs", t.getZzs()+"");
		json.put("total", t.getTotal()+"");
		json.put("addTime", DateFormatUtil.getStrTime(t.getAddTime()));
		json.put("enterpriseId", t.getEnterpriseId());
		json.put("TimeId", t.getTimeId());
		json.put("id", t.getId());
		return json;
	}

	@RequestMapping("/sub")
	public String sub(Map<String, Object> map, @RequestParam(defaultValue = "") int enterpriseId) {
		Tax t = taxService.lastOne(enterpriseId);
		if (t == null) {
			return null;
		}
		map.put("id", enterpriseId);
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
		return "app/tax/add";
	}

	@RequestMapping("/mit")
	public String mit(Map<String, Object> map, @RequestParam(defaultValue = "") String yingys,
			@RequestParam(defaultValue = "") String qysds, @RequestParam(defaultValue = "") String grsds,
			@RequestParam(defaultValue = "") String zys, @RequestParam(defaultValue = "") String yjs,
			@RequestParam(defaultValue = "") String fcs, @RequestParam(defaultValue = "") String yhs,
			@RequestParam(defaultValue = "") String tdsys, @RequestParam(defaultValue = "") String tdzzs,
			@RequestParam(defaultValue = "") String ccs, @RequestParam(defaultValue = "") String yanys,
			@RequestParam(defaultValue = "") String gdzys, @RequestParam(defaultValue = "") String qs,
			@RequestParam(defaultValue = "") String zzs, @RequestParam(defaultValue = "") int enterpriseId) {
		json.clear();
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

		if ("".equals(yingys)) {
			yingys = "0";
		}
		if ("".equals(grsds)) {
			grsds = "0";
		}
		if ("".equals(yjs)) {
			yjs = "0";
		}
		if ("".equals(yhs)) {
			yhs = "0";
		}
		if ("".equals(tdzzs)) {
			tdzzs = "0";
		}
		if ("".equals(yanys)) {
			yanys = "0";
		}
		if ("".equals(qs)) {
			qs = "0";
		}
		if ("".equals(qysds)) {
			qysds = "0";
		}
		if ("".equals(zys)) {
			zys = "0";
		}
		if ("".equals(fcs)) {
			fcs = "0";
		}
		if ("".equals(tdsys)) {
			tdsys = "0";
		}
		if ("".equals(ccs)) {
			ccs = "0";
		}
		if ("".equals(gdzys)) {
			gdzys = "0";
		}
		if ("".equals(zzs)) {
			zzs = "0";
		}

		BigDecimal b_yingys = new BigDecimal(yingys);
		BigDecimal b_grsds = new BigDecimal(grsds);
		BigDecimal b_yjs = new BigDecimal(yjs);
		BigDecimal b_yhs = new BigDecimal(yhs);
		BigDecimal b_tdzzs = new BigDecimal(tdzzs);
		BigDecimal b_yanys = new BigDecimal(yanys);
		BigDecimal b_qs = new BigDecimal(qs);
		BigDecimal b_qysds = new BigDecimal(qysds);
		BigDecimal b_zys = new BigDecimal(zys);
		BigDecimal b_fcs = new BigDecimal(fcs);
		BigDecimal b_tdsys = new BigDecimal(tdsys);
		BigDecimal b_ccs = new BigDecimal(ccs);
		BigDecimal b_gdzys = new BigDecimal(gdzys);
		BigDecimal b_zzs = new BigDecimal(zzs);
		BigDecimal total = b_yingys.add(b_qysds).add(b_grsds).add(b_zys).add(b_yjs).add(b_fcs).add(b_yhs).add(b_tdsys)
				.add(b_tdzzs).add(b_ccs).add(b_yanys).add(b_gdzys).add(b_qs).add(b_zzs);
		json = taxService.submit(enterpriseId, b_yingys, b_qysds, b_grsds, b_zys, b_yjs, b_fcs, b_yhs, b_tdsys, b_tdzzs,
				b_ccs, b_yanys, b_gdzys, b_qs, b_zzs, total);
		map.put("id", enterpriseId);
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

			map.put("error", "<script>$(function(){new Toast({context:$('body'),message:'"+json.getString("error")+"'}).show();});</script>");
			return "app/tax/add";
		}
		map.put("error", "<script>$(function(){new Toast({context:$('body'),message:'上报成功！'}).show();});</script>");
		return "app/tax/add";
	}

	/**
	 * 历史数据查看
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public @ResponseBody JSONObject list(@RequestParam(defaultValue = "") int enterpriseId) {
		json.clear();
		JSONArray js = new JSONArray();
		List<Tax> taxs = taxService.getTaxs(enterpriseId);

		String re_StrTime = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd");

		for (Tax t : taxs) {

			JSONObject j = new JSONObject();
			j.put("id", t.getId());
			j.put("total", t.getTotal()+"");
			Long sj = t.getAddTime();
			String rq = DateFormatUtil.getStrTime(sj);
			String xq = DateFormatUtil.getWeekOfDate(sj);
			j.put("addTime", rq);
			j.put("week", xq);

			PreTime preTime = preTimeService.getPreTimeById(t.getTimeId());
			preTime.getNowTime();

			re_StrTime = sdf.format(new Date(preTime.getNowTime()));
			j.put("stopTime", re_StrTime);

			js.add(j);

		}
		json.put("status", 1);
		json.put("error", "");
		json.put("data", js);

		return json;
	}
}
