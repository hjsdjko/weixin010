package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DongtaixinxiDao;
import com.cl.entity.DongtaixinxiEntity;
import com.cl.service.DongtaixinxiService;
import com.cl.entity.view.DongtaixinxiView;

@Service("dongtaixinxiService")
public class DongtaixinxiServiceImpl extends ServiceImpl<DongtaixinxiDao, DongtaixinxiEntity> implements DongtaixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DongtaixinxiEntity> page = this.selectPage(
                new Query<DongtaixinxiEntity>(params).getPage(),
                new EntityWrapper<DongtaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DongtaixinxiEntity> wrapper) {
		  Page<DongtaixinxiView> page =new Query<DongtaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DongtaixinxiView> selectListView(Wrapper<DongtaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DongtaixinxiView selectView(Wrapper<DongtaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
