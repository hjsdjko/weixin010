package com.cl.dao;

import com.cl.entity.DiscussdongtaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussdongtaixinxiView;


/**
 * 动态信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-14 15:19:36
 */
public interface DiscussdongtaixinxiDao extends BaseMapper<DiscussdongtaixinxiEntity> {
	
	List<DiscussdongtaixinxiView> selectListView(@Param("ew") Wrapper<DiscussdongtaixinxiEntity> wrapper);

	List<DiscussdongtaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdongtaixinxiEntity> wrapper);
	
	DiscussdongtaixinxiView selectView(@Param("ew") Wrapper<DiscussdongtaixinxiEntity> wrapper);
	

}
