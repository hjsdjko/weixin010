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


import com.cl.dao.YuepaixinxiDao;
import com.cl.entity.YuepaixinxiEntity;
import com.cl.service.YuepaixinxiService;
import com.cl.entity.view.YuepaixinxiView;

@Service("yuepaixinxiService")
public class YuepaixinxiServiceImpl extends ServiceImpl<YuepaixinxiDao, YuepaixinxiEntity> implements YuepaixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuepaixinxiEntity> page = this.selectPage(
                new Query<YuepaixinxiEntity>(params).getPage(),
                new EntityWrapper<YuepaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuepaixinxiEntity> wrapper) {
		  Page<YuepaixinxiView> page =new Query<YuepaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuepaixinxiView> selectListView(Wrapper<YuepaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuepaixinxiView selectView(Wrapper<YuepaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
