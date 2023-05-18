package com.controller.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LoufangziliaoEntity;
import com.entity.view.LoufangziliaoView;

import com.service.LoufangziliaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 楼房资料
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@RestController
@RequestMapping("/loufangziliao")
public class LoufangziliaoController {
    @Autowired
    private LoufangziliaoService loufangziliaoService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LoufangziliaoEntity loufangziliao, 
		HttpServletRequest request){

        EntityWrapper<LoufangziliaoEntity> ew = new EntityWrapper<LoufangziliaoEntity>();
		PageUtils page = loufangziliaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, loufangziliao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LoufangziliaoEntity loufangziliao, 
		HttpServletRequest request){
        EntityWrapper<LoufangziliaoEntity> ew = new EntityWrapper<LoufangziliaoEntity>();
		PageUtils page = loufangziliaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, loufangziliao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LoufangziliaoEntity loufangziliao){
       	EntityWrapper<LoufangziliaoEntity> ew = new EntityWrapper<LoufangziliaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( loufangziliao, "loufangziliao")); 
        return R.ok().put("data", loufangziliaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LoufangziliaoEntity loufangziliao){
        EntityWrapper< LoufangziliaoEntity> ew = new EntityWrapper< LoufangziliaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( loufangziliao, "loufangziliao")); 
		LoufangziliaoView loufangziliaoView =  loufangziliaoService.selectView(ew);
		return R.ok("查询楼房资料成功").put("data", loufangziliaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LoufangziliaoEntity loufangziliao = loufangziliaoService.selectById(id);
        return R.ok().put("data", loufangziliao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LoufangziliaoEntity loufangziliao = loufangziliaoService.selectById(id);
        return R.ok().put("data", loufangziliao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LoufangziliaoEntity loufangziliao, HttpServletRequest request){
    	loufangziliao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(loufangziliao);

        loufangziliaoService.insert(loufangziliao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LoufangziliaoEntity loufangziliao, HttpServletRequest request){
    	loufangziliao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(loufangziliao);

        loufangziliaoService.insert(loufangziliao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LoufangziliaoEntity loufangziliao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(loufangziliao);
        loufangziliaoService.updateById(loufangziliao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        loufangziliaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<LoufangziliaoEntity> wrapper = new EntityWrapper<LoufangziliaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = loufangziliaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
