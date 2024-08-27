package com.cl.dao;

import com.cl.entity.YuepaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuepaixinxiView;


/**
 * 约拍信息
 * 
 * @author 
 * @email 
 * @date 2024-04-14 15:19:35
 */
public interface YuepaixinxiDao extends BaseMapper<YuepaixinxiEntity> {
	
	List<YuepaixinxiView> selectListView(@Param("ew") Wrapper<YuepaixinxiEntity> wrapper);

	List<YuepaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YuepaixinxiEntity> wrapper);
	
	YuepaixinxiView selectView(@Param("ew") Wrapper<YuepaixinxiEntity> wrapper);
	

}
