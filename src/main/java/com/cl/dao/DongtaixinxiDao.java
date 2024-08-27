package com.cl.dao;

import com.cl.entity.DongtaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongtaixinxiView;


/**
 * 动态信息
 * 
 * @author 
 * @email 
 * @date 2024-04-14 15:19:34
 */
public interface DongtaixinxiDao extends BaseMapper<DongtaixinxiEntity> {
	
	List<DongtaixinxiView> selectListView(@Param("ew") Wrapper<DongtaixinxiEntity> wrapper);

	List<DongtaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DongtaixinxiEntity> wrapper);
	
	DongtaixinxiView selectView(@Param("ew") Wrapper<DongtaixinxiEntity> wrapper);
	

}
