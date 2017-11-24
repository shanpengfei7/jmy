package com.jmy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmy.dao.FaceextMapper;
import com.jmy.entity.Faceext;
import com.jmy.entity.FaceextExample;
import com.jmy.entity.Faceinfo;
import com.jmy.service.FaceExtService;
import com.jmy.service.FaceInfoService;
import com.jmy.util.DataShowPage;

@Service("faceExtService")
public class FaceExtServiceImpl implements FaceExtService {

	@Resource
	private FaceextMapper faceextMapper;
	@Resource
	private FaceInfoService faceInfoService;
	
	public int save(Faceext faceext) {
		faceext.setCreateTime((int)(System.currentTimeMillis() / 1000));
		if(faceext.getCreateUser() == null) {
			faceext.setCreateUser(0);
		}
		int result =  faceextMapper.insertSelective(faceext);
		if(result > 0) {
			Faceinfo f = new Faceinfo();
			f.setId(faceext.getFid());
			f.setLastTime(faceext.getNewTime());
			result = faceInfoService.edit(f);
		} else {
			return 0;
		}
		return result;
	}
	public DataShowPage getFaceExts(int fid, int pageNum,int pageSize) {
		FaceextExample f = new FaceextExample();
		f.createCriteria().andFidEqualTo(fid);
		 //设置分页的参数  
        PageHelper.startPage(pageNum, pageSize);  
        //查询数据  
        List<Faceext> list=faceextMapper.selectByExample(f);  
        //创建一个返回值对象  
        DataShowPage page=new DataShowPage();  
        page.setRows(list);  
        
        page.setNow(pageNum);
        page.setSize(pageSize);
        
        //取记录总条数  
        PageInfo pageInfo=new PageInfo(list);  
        page.setTotal(pageInfo.getTotal());  
          
        return page;  
	}
	
	public Faceext getFaceext(int id) {
		return faceextMapper.selectByPrimaryKey(id);
	}
}
