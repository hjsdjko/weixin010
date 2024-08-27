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


import com.cl.dao.DiscussdongtaixinxiDao;
import com.cl.entity.DiscussdongtaixinxiEntity;
import com.cl.service.DiscussdongtaixinxiService;
import com.cl.entity.view.DiscussdongtaixinxiView;

@Service("discussdongtaixinxiService")
public class DiscussdongtaixinxiServiceImpl extends ServiceImpl<DiscussdongtaixinxiDao, DiscussdongtaixinxiEntity> implements DiscussdongtaixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdongtaixinxiEntity> page = this.selectPage(
                new Query<DiscussdongtaixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussdongtaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdongtaixinxiEntity> wrapper) {
		  Page<DiscussdongtaixinxiView> page =new Query<DiscussdongtaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussdongtaixinxiView> selectListView(Wrapper<DiscussdongtaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdongtaixinxiView selectView(Wrapper<DiscussdongtaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
