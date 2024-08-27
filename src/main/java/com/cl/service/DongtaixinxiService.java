package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DongtaixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongtaixinxiView;


/**
 * 动态信息
 *
 * @author 
 * @email 
 * @date 2024-04-14 15:19:34
 */
public interface DongtaixinxiService extends IService<DongtaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongtaixinxiView> selectListView(Wrapper<DongtaixinxiEntity> wrapper);
   	
   	DongtaixinxiView selectView(@Param("ew") Wrapper<DongtaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongtaixinxiEntity> wrapper);
   	

}

