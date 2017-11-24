package com.jmy.controller.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmy.entity.Admi;
import com.jmy.entity.Enterprise;
import com.jmy.entity.PreTime;
import com.jmy.entity.Swjg;
import com.jmy.entity.Tax;
import com.jmy.entity.son.PreTimeSon;
import com.jmy.entity.son.TaxSon;
import com.jmy.service.EnterpriseService;
import com.jmy.service.PreTimeService;
import com.jmy.service.SwjgService;
import com.jmy.service.TaxService;
import com.jmy.util.DateFormatUtil;
import com.jmy.util.ExcelTools;

@Controller
@RequestMapping("/admin/tax")
public class AdminTaxController {
	@Resource
	private TaxService taxService;
	@Resource
	private PreTimeService preTimeService;
	@Resource
	private SwjgService swjgService;
	@Resource
	private EnterpriseService enterpriseService;

	@RequestMapping(value = "/list")
	public Map<String, Object> list(Map<String, Object> map, HttpSession session,
			@RequestParam(defaultValue = "0") String time, @RequestParam(defaultValue = "") String idCode,
			@RequestParam(defaultValue = "") String swjgDm) {
		BigDecimal dyingys = new BigDecimal("0.00");
		BigDecimal dgrsds = new BigDecimal("0.00");
		BigDecimal dyjs = new BigDecimal("0.00");
		BigDecimal dyhs = new BigDecimal("0.00");
		BigDecimal dtdzzs = new BigDecimal("0.00");
		BigDecimal dyanys = new BigDecimal("0.00");
		BigDecimal dqs = new BigDecimal("0.00");

		BigDecimal dqysds = new BigDecimal("0.00");
		BigDecimal dzys = new BigDecimal("0.00");
		BigDecimal dfcs = new BigDecimal("0.00");
		BigDecimal dtdsys = new BigDecimal("0.00");
		BigDecimal dccs = new BigDecimal("0.00");
		BigDecimal dgdzys = new BigDecimal("0.00");
		BigDecimal dzzs = new BigDecimal("0.00");

		BigDecimal dtotal = new BigDecimal("0.00");
		int count = 0;

		time = time.trim();
		if ("0".equals(time)) {
			SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
			time = s.format(new Date());
		} else if ("".equals(time)) {
			SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
			time = s.format(new Date());
		}
		PreTime preTime = preTimeService.getPreTimeByTime(DateFormatUtil.getTime(time));
		List<TaxSon> taxs = new ArrayList<TaxSon>();
		Admi a = (Admi) session.getAttribute("admin");
		if (preTime != null) {
			map.put("time", DateFormatUtil.getStrTime(preTime.getNowTime()));

			List<Enterprise> enterprises = new ArrayList<Enterprise>();

			if (!"".equals(idCode)) {
				Enterprise e = enterpriseService.getEnterprisesByIdCode(idCode);
				enterprises.add(e);
			} else if (!"".equals(swjgDm)) {
				if ("21307000000".equals(swjgDm)) {
					enterprises = enterpriseService.getEnterprises();
				} else {
					// 县区局
					Swjg swjg = swjgService.getSwjgByswjg(swjgDm);
					if (swjg != null) {
						enterprises = enterpriseService.getEnterprisesBySwjgDm(swjg.getSwjgDm());
						if (enterprises.size() == 0) {
							// 分局
							List<Swjg> swjgs = swjgService.getSwjgsBySjswjg(swjg.getSwjgDm());
							for (Swjg s : swjgs) {
								List<Enterprise> es = enterpriseService.getEnterprisesBySwjgDm(s.getSwjgDm());
								if (es.size() > 0) {
									enterprises.addAll(es);
								}
							}
						}
					}
				}
			} else {
				if (a.getRole() == 0 || a.getRole() == 1) {
					enterprises = enterpriseService.getEnterprises();
				} else {
					// 县区局
					Swjg swjg = swjgService.getSwjgByswjg(a.getSwjgDm());
					if (swjg != null) {
						enterprises = enterpriseService.getEnterprisesBySwjgDm(swjg.getSwjgDm());
						if (enterprises.size() == 0) {
							// 分局
							List<Swjg> swjgs = swjgService.getSwjgsBySjswjg(swjg.getSwjgDm());
							for (Swjg s : swjgs) {
								List<Enterprise> es = enterpriseService.getEnterprisesBySwjgDm(s.getSwjgDm());
								if (es.size() > 0) {
									enterprises.addAll(es);
								}
							}
						}
					}
				}
			}

			if (preTime != null) {
				for (Enterprise e : enterprises) {
					Tax t = taxService.getTax(e.getId(), preTime.getId());
					if (t != null) {
						Swjg swjg = swjgService.getSwjgByswjg(e.getSwjgDm());
						TaxSon s = new TaxSon(DateFormatUtil.getStrTime(t.getAddTime()),
								DateFormatUtil.getStrTime(preTime.getNowTime()), e.getIdCode(), e.getName(),
								e.getSwjgDm(), swjg.getSwjgmc());
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

						count++;
						dyingys=dyingys.add(t.getYingys());
						dgrsds=dgrsds.add(t.getGrsds());
						dyjs=dyjs.add(t.getYjs());
						dyhs=dyhs.add(t.getYhs());
						dtdzzs=dtdzzs.add(t.getTdzzs());
						dyanys=dyanys.add(t.getYanys());
						dqs=dqs.add(t.getQs());

						dqysds=dqysds.add(t.getQysds());
						dzys=dzys.add(t.getZys());
						dfcs=dfcs.add(t.getFcs());
						dtdsys=dtdsys.add(t.getTdsys());
						dccs=dccs.add(t.getCcs());
						dgdzys=dgdzys.add(t.getGdzys());
						dzzs=dzzs.add(t.getZzs());
						dtotal=dtotal.add(t.getTotal());
					}
				}
			}
		}
		// 查询时时间下拉列表的信息
		List<PreTime> pritimes = preTimeService.getTimes();
		List<PreTimeSon> preTimeSons = new ArrayList<PreTimeSon>();
		for (PreTime p : pritimes) {
			PreTimeSon ps = new PreTimeSon();
			ps.setNow(DateFormatUtil.getStrTime(p.getNowTime()));
			preTimeSons.add(ps);
		}

		// 查询时企业下拉列表的信息
		List<Enterprise> ens = new ArrayList<Enterprise>();
		if (a.getRole() == 0 || a.getRole() == 1) {
			ens = enterpriseService.getEnterprises();
		} else if (a.getRole() == 2) {
			// 县区局
			Swjg swjg = swjgService.getSwjgByswjg(a.getSwjgDm());
			if (swjg != null) {
				// 分局
				List<Swjg> swjgs = swjgService.getSwjgsBySjswjg(swjg.getSwjgDm());
				for (Swjg s : swjgs) {
					List<Enterprise> enters = enterpriseService.getEnterprisesBySwjgDm(s.getSwjgDm());
					if (enters.size() > 0) {
						ens.addAll(enters);
					}
				}
			}
		} else {
			ens = enterpriseService.getEnterprisesBySwjgDm(a.getSwjgDm());
		}

		// 查询时税务机关下拉列表的信息
		List<Swjg> swjgs = new ArrayList<Swjg>();
		if (a.getRole() == 0 || a.getRole() == 1) {
			swjgs = swjgService.getSwjgs();
		} else if (a.getRole() == 2) {
			swjgs = swjgService.getSwjgsBySjswjg(a.getSwjgDm());
		} else {
			swjgs.add(swjgService.getSwjgByswjg(a.getSwjgDm()));
		}

		Swjg swjg = swjgService.getSwjgByswjg(swjgDm);
		if (swjg == null) {
			map.put("swjgmc", "");
		} else {
			map.put("swjgmc", swjg.getSwjgmc());
		}

		Enterprise enter = enterpriseService.getEnterprisesByIdCode(idCode);
		if (enter == null) {
			map.put("name", "");
		} else {
			map.put("name", enter.getName());
		}

		map.put("dyingys", dyingys);
		map.put("dgrsds", dgrsds);
		map.put("dyjs", dyjs);
		map.put("dyhs", dyhs);
		map.put("dtdzzs", dtdzzs);

		map.put("dyanys", dyanys);
		map.put("dqs", dqs);
		map.put("dqysds", dqysds);
		map.put("dzys", dzys);
		map.put("dfcs", dfcs);

		map.put("dtdsys", dtdsys);
		map.put("dccs", dccs);
		map.put("dgdzys", dgdzys);
		map.put("dzzs", dzzs);
		map.put("dtotal", dtotal);

		map.put("count", count);

		map.put("pritimes", preTimeSons);
		map.put("data", taxs);
		map.put("enterprises", ens);
		map.put("swjgs", swjgs);
		return map;
	}

	@RequestMapping(value = "/excel")
	public void excel(HttpSession session, HttpServletResponse response, @RequestParam(defaultValue = "0") String time,
			@RequestParam(defaultValue = "") String idCode, @RequestParam(defaultValue = "") String swjgDm) {
		time = time.trim();
		if ("0".equals(time)) {
			SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
			time = s.format(new Date());
		} else if ("".equals(time)) {
			SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
			time = s.format(new Date());
		}
		PreTime preTime = preTimeService.getPreTimeByTime(DateFormatUtil.getTime(time));
		Admi a = (Admi) session.getAttribute("admin");

		List<Enterprise> enterprises = new ArrayList<Enterprise>();

		if (!"".equals(idCode)) {
			Enterprise e = enterpriseService.getEnterprisesByIdCode(idCode);
			enterprises.add(e);
		} else if (!"".equals(swjgDm)) {
			if ("21307000000".equals(swjgDm)) {
				enterprises = enterpriseService.getEnterprises();
			} else {
				// 县区局
				Swjg swjg = swjgService.getSwjgByswjg(swjgDm);
				if (swjg != null) {
					enterprises = enterpriseService.getEnterprisesBySwjgDm(swjg.getSwjgDm());
					if (enterprises.size() == 0) {
						// 分局
						List<Swjg> swjgs = swjgService.getSwjgsBySjswjg(swjg.getSwjgDm());
						for (Swjg s : swjgs) {
							List<Enterprise> es = enterpriseService.getEnterprisesBySwjgDm(s.getSwjgDm());
							if (es.size() > 0) {
								enterprises.addAll(es);
							}
						}
					}
				}
			}
		} else {
			if (a.getRole() == 0 || a.getRole() == 1) {
				enterprises = enterpriseService.getEnterprises();
			} else {
				// 县区局
				Swjg swjg = swjgService.getSwjgByswjg(a.getSwjgDm());
				if (swjg != null) {
					enterprises = enterpriseService.getEnterprisesBySwjgDm(swjg.getSwjgDm());
					if (enterprises.size() == 0) {
						// 分局
						List<Swjg> swjgs = swjgService.getSwjgsBySjswjg(swjg.getSwjgDm());
						for (Swjg s : swjgs) {
							List<Enterprise> es = enterpriseService.getEnterprisesBySwjgDm(s.getSwjgDm());
							if (es.size() > 0) {
								enterprises.addAll(es);
							}
						}
					}
				}
			}
		}

		List<TaxSon> taxs = new ArrayList<TaxSon>();
		if (preTime != null) {
			for (Enterprise e : enterprises) {
				Tax t = taxService.getTax(e.getId(), preTime.getId());
				if (t != null) {
					Swjg swjg = swjgService.getSwjgByswjg(e.getSwjgDm());
					TaxSon s = new TaxSon(DateFormatUtil.getStrTime(t.getAddTime()),
							DateFormatUtil.getStrTime(preTime.getNowTime()), e.getIdCode(), e.getName(), e.getSwjgDm(),
							swjg.getSwjgmc());
					s.setId(t.getId());
					s.setAddTime(t.getAddTime());

					s.setCcs(t.getCcs());
					s.setEnterpriseId(t.getEnterpriseId());
					s.setFcs(t.getFcs());
					s.setFlag(1);
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
				} else {
					Swjg swjg = swjgService.getSwjgByswjg(e.getSwjgDm());
					TaxSon s = new TaxSon("", DateFormatUtil.getStrTime(preTime.getNowTime()), e.getIdCode(),
							e.getName(), e.getSwjgDm(), swjg.getSwjgmc());

					s.setCcs(new BigDecimal("0.00"));
					s.setFcs(new BigDecimal("0.00"));
					s.setFlag(0);
					s.setGdzys(new BigDecimal("0.00"));
					s.setGrsds(new BigDecimal("0.00"));
					s.setQs(new BigDecimal("0.00"));
					s.setQysds(new BigDecimal("0.00"));
					s.setTdsys(new BigDecimal("0.00"));
					s.setTdzzs(new BigDecimal("0.00"));
					s.setTotal(new BigDecimal("0.00"));
					s.setYanys(new BigDecimal("0.00"));
					s.setYhs(new BigDecimal("0.00"));
					s.setYingys(new BigDecimal("0.00"));
					s.setYjs(new BigDecimal("0.00"));
					s.setZys(new BigDecimal("0.00"));
					s.setZzs(new BigDecimal("0.00"));
					taxs.add(s);
				}
			}
		}
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String excelName = "税务预测上报数据" + format.format(Calendar.getInstance().getTime());
		// 转码防止乱码
		try {
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(excelName.getBytes("utf-8"), "ISO8859-1") + ".xls");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String[] headers = new String[] { "限定上报日期", "实际上报日期", "上报标识", "纳税人识别号", "纳税人名称", "所属税务机关代码", "所属税务机关名称", "合计",
				"营业税", "企业所得税", "个人所得税", "资源税", "城建税", "房产税", "印花税", "土地使用税", "土地增值税", "车船税", "烟叶税", "耕地占用税", "契税",
				"增值税" };

		try {
			ExcelTools.exportExcel(excelName, headers, taxs, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/list2")
	public Map<String, Object> list2(Map<String, Object> map, HttpSession session,
			@RequestParam(defaultValue = "0") String time, @RequestParam(defaultValue = "") String idCode,
			@RequestParam(defaultValue = "") String swjgDm) {
		int count = 0;
		time = time.trim();
		List<Enterprise> enterpriseLists = new ArrayList<Enterprise>();
		if ("0".equals(time)) {
			SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
			time = s.format(new Date());
		} else if ("".equals(time)) {
			SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-dd");
			time = s.format(new Date());
		}
		PreTime preTime = preTimeService.getPreTimeByTime(DateFormatUtil.getTime(time));
		Admi a = (Admi) session.getAttribute("admin");
		if (preTime != null) {
			map.put("time", DateFormatUtil.getStrTime(preTime.getNowTime()));

			List<Enterprise> enterprises = new ArrayList<Enterprise>();

			if (!"".equals(idCode)) {
				Enterprise e = enterpriseService.getEnterprisesByIdCode(idCode);
				enterprises.add(e);
			} else if (!"".equals(swjgDm)) {
				if ("21307000000".equals(swjgDm)) {
					enterprises = enterpriseService.getEnterprises();
				} else {
					// 县区局
					Swjg swjg = swjgService.getSwjgByswjg(swjgDm);
					if (swjg != null) {
						enterprises = enterpriseService.getEnterprisesBySwjgDm(swjg.getSwjgDm());
						if (enterprises.size() == 0) {
							// 分局
							List<Swjg> swjgs = swjgService.getSwjgsBySjswjg(swjg.getSwjgDm());
							for (Swjg s : swjgs) {
								List<Enterprise> es = enterpriseService.getEnterprisesBySwjgDm(s.getSwjgDm());
								if (es.size() > 0) {
									enterprises.addAll(es);
								}
							}
						}
					}
				}
			} else {
				if (a.getRole() == 0 || a.getRole() == 1) {
					enterprises = enterpriseService.getEnterprises();
				} else {
					// 县区局
					Swjg swjg = swjgService.getSwjgByswjg(a.getSwjgDm());
					if (swjg != null) {
						enterprises = enterpriseService.getEnterprisesBySwjgDm(swjg.getSwjgDm());
						if (enterprises.size() == 0) {
							// 分局
							List<Swjg> swjgs = swjgService.getSwjgsBySjswjg(swjg.getSwjgDm());
							for (Swjg s : swjgs) {
								List<Enterprise> es = enterpriseService.getEnterprisesBySwjgDm(s.getSwjgDm());
								if (es.size() > 0) {
									enterprises.addAll(es);
								}
							}
						}
					}
				}
			}

			if (preTime != null) {
				for (Enterprise e : enterprises) {
					Tax t = taxService.getTax(e.getId(), preTime.getId());
					if (t == null) {
						enterpriseLists.add(e);
						count++;
					}
				}
			}
		}
		// 查询时时间下拉列表的信息
		List<PreTime> pritimes = preTimeService.getTimes();
		List<PreTimeSon> preTimeSons = new ArrayList<PreTimeSon>();
		for (PreTime p : pritimes) {
			PreTimeSon ps = new PreTimeSon();
			ps.setNow(DateFormatUtil.getStrTime(p.getNowTime()));
			preTimeSons.add(ps);
		}

		// 查询时企业下拉列表的信息
		List<Enterprise> ens = new ArrayList<Enterprise>();
		if (a.getRole() == 0 || a.getRole() == 1) {
			ens = enterpriseService.getEnterprises();
		} else if (a.getRole() == 2) {
			// 县区局
			Swjg swjg = swjgService.getSwjgByswjg(a.getSwjgDm());
			if (swjg != null) {
				// 分局
				List<Swjg> swjgs = swjgService.getSwjgsBySjswjg(swjg.getSwjgDm());
				for (Swjg s : swjgs) {
					List<Enterprise> enters = enterpriseService.getEnterprisesBySwjgDm(s.getSwjgDm());
					if (enters.size() > 0) {
						ens.addAll(enters);
					}
				}
			}
		} else {
			ens = enterpriseService.getEnterprisesBySwjgDm(a.getSwjgDm());
		}

		// 查询时税务机关下拉列表的信息
		List<Swjg> swjgs = new ArrayList<Swjg>();
		if (a.getRole() == 0 || a.getRole() == 1) {
			swjgs = swjgService.getSwjgs();
		} else if (a.getRole() == 2) {
			swjgs = swjgService.getSwjgsBySjswjg(a.getSwjgDm());
		} else {
			swjgs.add(swjgService.getSwjgByswjg(a.getSwjgDm()));
		}

		Swjg swjg = swjgService.getSwjgByswjg(swjgDm);
		if (swjg == null) {
			map.put("swjgmc", "");
		} else {
			map.put("swjgmc", swjg.getSwjgmc());
		}

		Enterprise enter = enterpriseService.getEnterprisesByIdCode(idCode);
		if (enter == null) {
			map.put("name", "");
		} else {
			map.put("name", enter.getName());
		}

		map.put("count", count);
		map.put("pritimes", preTimeSons);
		map.put("data", enterpriseLists);
		map.put("enterprises", ens);
		map.put("swjgs", swjgs);
		return map;
	}

}
