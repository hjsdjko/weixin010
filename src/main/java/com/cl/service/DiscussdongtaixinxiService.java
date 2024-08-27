package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussdongtaixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussdongtaixinxiView;


/**
 * 动态信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-14 15:19:36
 */
public interface DiscussdongtaixinxiService extends IService<DiscussdongtaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdongtaixinxiView> selectListView(Wrapper<DiscussdongtaixinxiEntity> wrapper);
   	
   	DiscussdongtaixinxiView selectView(@Param("ew") Wrapper<DiscussdongtaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdongtaixinxiEntity> wrapper);
   	

}

