package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DingdanquxiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanquxiaoView;


/**
 * 订单取消
 *
 * @author 
 * @email 
 * @date 2024-04-14 15:19:35
 */
public interface DingdanquxiaoService extends IService<DingdanquxiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanquxiaoView> selectListView(Wrapper<DingdanquxiaoEntity> wrapper);
   	
   	DingdanquxiaoView selectView(@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanquxiaoEntity> wrapper);
   	

}

