package com.cl.entity.view;

import com.cl.entity.DongtaixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 动态信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-14 15:19:34
 */
@TableName("dongtaixinxi")
public class DongtaixinxiView  extends DongtaixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DongtaixinxiView(){
	}
 
 	public DongtaixinxiView(DongtaixinxiEntity dongtaixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, dongtaixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
