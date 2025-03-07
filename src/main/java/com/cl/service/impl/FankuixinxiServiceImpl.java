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


import com.cl.dao.FankuixinxiDao;
import com.cl.entity.FankuixinxiEntity;
import com.cl.service.FankuixinxiService;
import com.cl.entity.view.FankuixinxiView;

@Service("fankuixinxiService")
public class FankuixinxiServiceImpl extends ServiceImpl<FankuixinxiDao, FankuixinxiEntity> implements FankuixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FankuixinxiEntity> page = this.selectPage(
                new Query<FankuixinxiEntity>(params).getPage(),
                new EntityWrapper<FankuixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FankuixinxiEntity> wrapper) {
		  Page<FankuixinxiView> page =new Query<FankuixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FankuixinxiView> selectListView(Wrapper<FankuixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FankuixinxiView selectView(Wrapper<FankuixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
