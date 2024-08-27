package com.cl.dao;

import com.cl.entity.DingdanquxiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanquxiaoView;


/**
 * 订单取消
 * 
 * @author 
 * @email 
 * @date 2024-04-14 15:19:35
 */
public interface DingdanquxiaoDao extends BaseMapper<DingdanquxiaoEntity> {
	
	List<DingdanquxiaoView> selectListView(@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);

	List<DingdanquxiaoView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);
	
	DingdanquxiaoView selectView(@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);
	

}
