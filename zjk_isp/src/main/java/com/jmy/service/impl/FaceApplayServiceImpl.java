package com.jmy.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.FaceapplayMapper;
import com.jmy.domain.FaceApplayDoMain;
import com.jmy.entity.Actionpackage;
import com.jmy.entity.Faceapplay;
import com.jmy.entity.FaceapplayExample;
import com.jmy.entity.Faceinfo;
import com.jmy.entity.User;
import com.jmy.service.ActionPackageService;
import com.jmy.service.FaceApplayService;
import com.jmy.service.FaceInfoService;
import com.jmy.service.UserService;
import com.jmy.util.DataShowPage;

@Service("faceApplayService")
public class FaceApplayServiceImpl implements FaceApplayService {

	@Resource
	private FaceapplayMapper faceapplayMapper;
	@Resource
	private FaceInfoService faceInfoService;
	@Resource
	private UserService userService;
	@Resource
	private ActionPackageService actionPackageService;
	
	public int applay(Faceapplay faceapplay) {
		faceapplay.setStatus((byte)0);
		faceapplay.setCreateTime((int)(System.currentTimeMillis() / 1000));
		if(faceapplay.getCreateUser() == null) {
			faceapplay.setCreateUser(0);
		}
		return faceapplayMapper.insertSelective(faceapplay);
	}

	public int check(Faceapplay faceapplay,Faceinfo faceinfo) {
		faceapplay.setStatus((byte)1);
		faceapplay.setCheckTime((int)(System.currentTimeMillis() / 1000));
		if(faceapplay.getCheckUser() == null) {
			faceapplay.setCheckUser(0);
		}
		int result = faceapplayMapper.updateByPrimaryKeySelective(faceapplay);
		int createUser = faceapplay.getCheckUser();
		if(result != 0) {
			faceapplay = faceapplayMapper.selectByPrimaryKey(faceapplay.getId());
			faceinfo.setUserId(faceapplay.getUserId());
			faceinfo.setTaoId(faceapplay.getTaoId());
			faceinfo.setMoney(faceapplay.getMoney());
			faceinfo.setYears(faceapplay.getYears());
			faceinfo.setStatus((byte)1);
			
			Calendar calendar = Calendar.getInstance();
			Date date = new Date(System.currentTimeMillis());
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, +faceapplay.getYears());
			long longTime = calendar.getTimeInMillis();
			int intTime = (int) (longTime / 1000);
			
			faceinfo.setLastTime(intTime);
			faceinfo.setStartTime((int)(System.currentTimeMillis() / 1000));
			faceinfo.setCreateTime((int)(System.currentTimeMillis() / 1000));
			faceinfo.setCreateUser(createUser);
			return  faceInfoService.save(faceinfo);
		}
		return result;
	}
	public int uncheck(Faceapplay faceapplay) {
		faceapplay.setCheckTime((int)(System.currentTimeMillis() / 1000));
		if(faceapplay.getCheckUser() == null) {
			faceapplay.setCheckUser(0);
		}
		faceapplay.setStatus((byte)2);
		return faceapplayMapper.updateByPrimaryKeySelective(faceapplay);
	}

	public DataShowPage getFaceapplays(int pageNum,int pageSize, String user, String tao, byte status) {
		FaceapplayExample f = new FaceapplayExample();
		if (3 != status) {
			f.createCriteria().andStatusEqualTo(status);
		}
		f.setOrderByClause("id desc");
		 //设置分页的参数  
        PageHelper.startPage(pageNum, pageSize);  
        //查询数据  
        List<Faceapplay> list=faceapplayMapper.selectByExample(f); 
        List<FaceApplayDoMain> lists = new ArrayList<FaceApplayDoMain>();
		for (int i = 0; i < list.size(); i++) {
			FaceApplayDoMain fa = new FaceApplayDoMain();
			User u = userService.getUserById(list.get(i).getUserId());
			Actionpackage ap = actionPackageService.getActionpackageById(list.get(i).getTaoId());
			if (!"".equals(user) && !"".equals(user.trim())) {
				if(!(u.getName().indexOf(user.trim()) > -1)) {
					//不满足条件，从list中去了
					list.remove(i);
					i--;
					continue;
				}
			} 
			if (!"".equals(tao) && !"".equals(tao.trim())) {
				if(!(ap.getName().indexOf(tao.trim()) > -1)) {
					//不满足条件，从list中去了
					list.remove(i);
					i--;
					continue;
				}
			}
			fa.setCheckTime(list.get(i).getCheckTime());
			fa.setCheckUser(list.get(i).getCheckUser());
			fa.setCreateTime(list.get(i).getCreateTime());
			fa.setCreateUser(list.get(i).getCreateUser());
			fa.setId(list.get(i).getId());
			fa.setMessage(list.get(i).getMessage());
			fa.setMoney(list.get(i).getMoney());
			fa.setStatus(list.get(i).getStatus());
			fa.setTao(ap.getName());
			fa.setTaoId(list.get(i).getTaoId());
			fa.setUpdateUser(list.get(i).getUpdateUser());
			fa.setUpdateTime(list.get(i).getUpdateTime());
			fa.setUser(u.getName());
			fa.setUserId(list.get(i).getUserId());
			fa.setYears(list.get(i).getYears());
			lists.add(fa);
		}
        //创建一个返回值对象  
        DataShowPage page=new DataShowPage();  
        page.setRows(lists);  
        
        page.setNow(pageNum);
        page.setSize(pageSize);
        
        //取记录总条数  
        PageInfo pageInfo=new PageInfo(list);  
        page.setTotal(pageInfo.getTotal());  
          
        return page;  
	}
	public DataShowPage getFaceapplays(int id, int pageNum,int pageSize) {
		FaceapplayExample f = new FaceapplayExample();
		f.createCriteria().andUserIdEqualTo(id);
		f.setOrderByClause("id desc");
		//设置分页的参数  
		PageHelper.startPage(pageNum, pageSize);  
		//查询数据  
		List<Faceapplay> list=faceapplayMapper.selectByExample(f);  
		List<FaceApplayDoMain> lists = new ArrayList<FaceApplayDoMain>();
		for(Faceapplay a : list) {
			FaceApplayDoMain fa = new FaceApplayDoMain();
			User u = userService.getUserById(a.getUserId());
			Actionpackage ap = actionPackageService.getActionpackageById(a.getTaoId());
			fa.setCheckTime(a.getCheckTime());
			fa.setCheckUser(a.getCheckUser());
			fa.setCreateTime(a.getCreateTime());
			fa.setCreateUser(a.getCreateUser());
			fa.setId(a.getId());
			fa.setMessage(a.getMessage());
			fa.setMoney(a.getMoney());
			fa.setStatus(a.getStatus());
			fa.setTao(ap.getName());
			fa.setTaoId(a.getTaoId());
			fa.setUpdateUser(a.getUpdateUser());
			fa.setUpdateTime(a.getUpdateTime());
			fa.setUser(u.getName());
			fa.setUserId(a.getUserId());
			fa.setYears(a.getYears());
			lists.add(fa);
		}
		//创建一个返回值对象  
		DataShowPage page=new DataShowPage();  
		page.setRows(lists);  
		
		page.setNow(pageNum);
		page.setSize(pageSize);
		
		//取记录总条数  
		PageInfo pageInfo=new PageInfo(list);  
		page.setTotal(pageInfo.getTotal());  
		
		return page;  
	}

	public Faceapplay getFaceapplayById(int id) {
		return faceapplayMapper.selectByPrimaryKey(id);
	}

	public int edit(Faceapplay faceapplay) {
		faceapplay.setUpdateTime((int)(System.currentTimeMillis() / 1000));
		if(faceapplay.getUpdateUser() == null) {
			faceapplay.setUpdateUser(0);
		}
		return faceapplayMapper.updateByPrimaryKeySelective(faceapplay);
	}

}
