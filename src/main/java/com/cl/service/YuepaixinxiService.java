package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuepaixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuepaixinxiView;


/**
 * 约拍信息
 *
 * @author 
 * @email 
 * @date 2024-04-14 15:19:35
 */
public interface YuepaixinxiService extends IService<YuepaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuepaixinxiView> selectListView(Wrapper<YuepaixinxiEntity> wrapper);
   	
   	YuepaixinxiView selectView(@Param("ew") Wrapper<YuepaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuepaixinxiEntity> wrapper);
   	

}

