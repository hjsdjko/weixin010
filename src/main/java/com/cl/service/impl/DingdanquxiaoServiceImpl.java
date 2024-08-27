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


import com.cl.dao.DingdanquxiaoDao;
import com.cl.entity.DingdanquxiaoEntity;
import com.cl.service.DingdanquxiaoService;
import com.cl.entity.view.DingdanquxiaoView;

@Service("dingdanquxiaoService")
public class DingdanquxiaoServiceImpl extends ServiceImpl<DingdanquxiaoDao, DingdanquxiaoEntity> implements DingdanquxiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanquxiaoEntity> page = this.selectPage(
                new Query<DingdanquxiaoEntity>(params).getPage(),
                new EntityWrapper<DingdanquxiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanquxiaoEntity> wrapper) {
		  Page<DingdanquxiaoView> page =new Query<DingdanquxiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DingdanquxiaoView> selectListView(Wrapper<DingdanquxiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanquxiaoView selectView(Wrapper<DingdanquxiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
