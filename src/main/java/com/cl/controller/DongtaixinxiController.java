package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DongtaixinxiEntity;
import com.cl.entity.view.DongtaixinxiView;

import com.cl.service.DongtaixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 动态信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-14 15:19:34
 */
@RestController
@RequestMapping("/dongtaixinxi")
public class DongtaixinxiController {
    @Autowired
    private DongtaixinxiService dongtaixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DongtaixinxiEntity dongtaixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dongtaixinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DongtaixinxiEntity> ew = new EntityWrapper<DongtaixinxiEntity>();

		PageUtils page = dongtaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongtaixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DongtaixinxiEntity dongtaixinxi, 
		HttpServletRequest request){
        EntityWrapper<DongtaixinxiEntity> ew = new EntityWrapper<DongtaixinxiEntity>();

		PageUtils page = dongtaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongtaixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DongtaixinxiEntity dongtaixinxi){
       	EntityWrapper<DongtaixinxiEntity> ew = new EntityWrapper<DongtaixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dongtaixinxi, "dongtaixinxi")); 
        return R.ok().put("data", dongtaixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DongtaixinxiEntity dongtaixinxi){
        EntityWrapper< DongtaixinxiEntity> ew = new EntityWrapper< DongtaixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dongtaixinxi, "dongtaixinxi")); 
		DongtaixinxiView dongtaixinxiView =  dongtaixinxiService.selectView(ew);
		return R.ok("查询动态信息成功").put("data", dongtaixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DongtaixinxiEntity dongtaixinxi = dongtaixinxiService.selectById(id);
		dongtaixinxi = dongtaixinxiService.selectView(new EntityWrapper<DongtaixinxiEntity>().eq("id", id));
        return R.ok().put("data", dongtaixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DongtaixinxiEntity dongtaixinxi = dongtaixinxiService.selectById(id);
		dongtaixinxi = dongtaixinxiService.selectView(new EntityWrapper<DongtaixinxiEntity>().eq("id", id));
        return R.ok().put("data", dongtaixinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        DongtaixinxiEntity dongtaixinxi = dongtaixinxiService.selectById(id);
        if(type.equals("1")) {
        	dongtaixinxi.setThumbsupnum(dongtaixinxi.getThumbsupnum()+1);
        } else {
        	dongtaixinxi.setCrazilynum(dongtaixinxi.getCrazilynum()+1);
        }
        dongtaixinxiService.updateById(dongtaixinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DongtaixinxiEntity dongtaixinxi, HttpServletRequest request){
    	dongtaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongtaixinxi);
        dongtaixinxiService.insert(dongtaixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DongtaixinxiEntity dongtaixinxi, HttpServletRequest request){
    	dongtaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongtaixinxi);
        dongtaixinxiService.insert(dongtaixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DongtaixinxiEntity dongtaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dongtaixinxi);
        dongtaixinxiService.updateById(dongtaixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dongtaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
