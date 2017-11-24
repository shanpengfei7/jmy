package com.jmy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.FaceinfoMapper;
import com.jmy.domain.FaceInfoDoMain;
import com.jmy.entity.Actionpackage;
import com.jmy.entity.Faceinfo;
import com.jmy.entity.FaceinfoExample;
import com.jmy.entity.User;
import com.jmy.service.ActionPackageService;
import com.jmy.service.FaceInfoService;
import com.jmy.service.UserService;
import com.jmy.util.DataShowPage;
import com.jmy.util.TimeFormats;

@Service("faceInfoService")
public class FaceInfoServiceImpl implements FaceInfoService {

	@Resource
	private FaceinfoMapper faceinfoMapper;
	@Resource
	private UserService userService;
	@Resource
	private ActionPackageService actionPackageService;
	
	public int save(Faceinfo faceinfo) {
		faceinfo.setStatus((byte)1);
		faceinfo.setStartTime((int)(System.currentTimeMillis() / 1000));
		faceinfo.setCreateTime((int)(System.currentTimeMillis() / 1000));
		if(faceinfo.getCreateUser() == null) {
			faceinfo.setCreateUser(0);
		}
		return faceinfoMapper.insertSelective(faceinfo);
	}

	public DataShowPage getFaceinfos(int pageNum,int pageSize, String user, String tao, byte status) {
		FaceinfoExample f = new FaceinfoExample();
		if (3 != status) {
			f.createCriteria().andStatusEqualTo(status);
		}
		f.setOrderByClause("id desc");
		 //设置分页的参数  
        PageHelper.startPage(pageNum, pageSize);  
        //查询数据  
        List<Faceinfo> list=faceinfoMapper.selectByExample(f);  
        List<FaceInfoDoMain> lists = new ArrayList<FaceInfoDoMain>();
		for(int i = 0; i < list.size(); i++) {
			FaceInfoDoMain fi = new FaceInfoDoMain();
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
			fi.setId(list.get(i).getId());
			fi.setUser(u.getName());
			fi.setTao(ap.getName());
			fi.setMoney(list.get(i).getMoney());
			fi.setToken(list.get(i).getToken());
			fi.setYears(list.get(i).getYears());
			fi.setStatus(list.get(i).getStatus());
			
			fi.setLastTime(list.get(i).getLastTime());
			fi.setStartTime(list.get(i).getStartTime());
			if(list.get(i).getLastTime() != null) {
				fi.setLast(TimeFormats.changeTime(list.get(i).getLastTime()));
			}
			if(list.get(i).getStartTime() != null) {
				fi.setStart(TimeFormats.changeTime(list.get(i).getStartTime()));
			}
			fi.setCreateTime(list.get(i).getCreateTime());
			fi.setCreateUser(list.get(i).getCreateUser());
			
			fi.setMessage(list.get(i).getMessage());
			lists.add(fi);
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
	public DataShowPage getFaceinfos(int id, int pageNum,int pageSize) {
		FaceinfoExample f = new FaceinfoExample();
		f.createCriteria().andUserIdEqualTo(id);
		f.setOrderByClause("id desc");
		//设置分页的参数  
		PageHelper.startPage(pageNum, pageSize);  
		//查询数据  
		List<Faceinfo> list=faceinfoMapper.selectByExample(f);  
		List<FaceInfoDoMain> lists = new ArrayList<FaceInfoDoMain>();
		for(Faceinfo a : list) {
			FaceInfoDoMain fi = new FaceInfoDoMain();
			User u = userService.getUserById(a.getUserId());
			Actionpackage ap = actionPackageService.getActionpackageById(a.getTaoId());
			fi.setId(a.getId());
			fi.setUser(u.getName());
			fi.setTao(ap.getName());
			fi.setMoney(a.getMoney());
			fi.setToken(a.getToken());
			fi.setYears(a.getYears());
			fi.setStatus(a.getStatus());
			fi.setLastTime(a.getLastTime());
			fi.setStartTime(a.getStartTime());
			if(a.getLastTime() != null) {
				fi.setLast(TimeFormats.changeTime(a.getLastTime()));
			}
			if(a.getStartTime() != null) {
				fi.setStart(TimeFormats.changeTime(a.getStartTime()));
			}
			fi.setCreateTime(a.getCreateTime());
			fi.setCreateUser(a.getCreateUser());
			fi.setMessage(a.getMessage());
			lists.add(fi);
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

	public Faceinfo getFaceinfoById(int id) {
		return faceinfoMapper.selectByPrimaryKey(id);
	}

	public int unCheck(Faceinfo faceinfo) {
		return faceinfoMapper.updateByPrimaryKeySelective(faceinfo);
	}

	public int edit(Faceinfo faceinfo) {
		return faceinfoMapper.updateByPrimaryKeySelective(faceinfo);
	}

}
