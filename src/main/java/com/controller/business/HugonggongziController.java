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

import com.entity.HugonggongziEntity;
import com.entity.view.HugonggongziView;

import com.service.HugonggongziService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 护工工资
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@RestController
@RequestMapping("/hugonggongzi")
public class HugonggongziController {
    @Autowired
    private HugonggongziService hugonggongziService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HugonggongziEntity hugonggongzi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("hugong")) {
			hugonggongzi.setHugonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HugonggongziEntity> ew = new EntityWrapper<HugonggongziEntity>();
		PageUtils page = hugonggongziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hugonggongzi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HugonggongziEntity hugonggongzi, 
		HttpServletRequest request){
        EntityWrapper<HugonggongziEntity> ew = new EntityWrapper<HugonggongziEntity>();
		PageUtils page = hugonggongziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hugonggongzi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HugonggongziEntity hugonggongzi){
       	EntityWrapper<HugonggongziEntity> ew = new EntityWrapper<HugonggongziEntity>();
      	ew.allEq(MPUtil.allEQMapPre( hugonggongzi, "hugonggongzi")); 
        return R.ok().put("data", hugonggongziService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HugonggongziEntity hugonggongzi){
        EntityWrapper< HugonggongziEntity> ew = new EntityWrapper< HugonggongziEntity>();
 		ew.allEq(MPUtil.allEQMapPre( hugonggongzi, "hugonggongzi")); 
		HugonggongziView hugonggongziView =  hugonggongziService.selectView(ew);
		return R.ok("查询护工工资成功").put("data", hugonggongziView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HugonggongziEntity hugonggongzi = hugonggongziService.selectById(id);
        return R.ok().put("data", hugonggongzi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HugonggongziEntity hugonggongzi = hugonggongziService.selectById(id);
        return R.ok().put("data", hugonggongzi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HugonggongziEntity hugonggongzi, HttpServletRequest request){
    	hugonggongzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hugonggongzi);

        hugonggongziService.insert(hugonggongzi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HugonggongziEntity hugonggongzi, HttpServletRequest request){
    	hugonggongzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hugonggongzi);

        hugonggongziService.insert(hugonggongzi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HugonggongziEntity hugonggongzi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(hugonggongzi);
        hugonggongziService.updateById(hugonggongzi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        hugonggongziService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HugonggongziEntity> wrapper = new EntityWrapper<HugonggongziEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("hugong")) {
			wrapper.eq("hugonggonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = hugonggongziService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
