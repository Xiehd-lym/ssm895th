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

import com.entity.YongyaoqingkuangEntity;
import com.entity.view.YongyaoqingkuangView;

import com.service.YongyaoqingkuangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 用药情况
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@RestController
@RequestMapping("/yongyaoqingkuang")
public class YongyaoqingkuangController {
    @Autowired
    private YongyaoqingkuangService yongyaoqingkuangService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YongyaoqingkuangEntity yongyaoqingkuang, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiashu")) {
			yongyaoqingkuang.setJiashuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("hugong")) {
			yongyaoqingkuang.setHugonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YongyaoqingkuangEntity> ew = new EntityWrapper<YongyaoqingkuangEntity>();
		PageUtils page = yongyaoqingkuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yongyaoqingkuang), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YongyaoqingkuangEntity yongyaoqingkuang, 
		HttpServletRequest request){
        EntityWrapper<YongyaoqingkuangEntity> ew = new EntityWrapper<YongyaoqingkuangEntity>();
		PageUtils page = yongyaoqingkuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yongyaoqingkuang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YongyaoqingkuangEntity yongyaoqingkuang){
       	EntityWrapper<YongyaoqingkuangEntity> ew = new EntityWrapper<YongyaoqingkuangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yongyaoqingkuang, "yongyaoqingkuang")); 
        return R.ok().put("data", yongyaoqingkuangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YongyaoqingkuangEntity yongyaoqingkuang){
        EntityWrapper< YongyaoqingkuangEntity> ew = new EntityWrapper< YongyaoqingkuangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yongyaoqingkuang, "yongyaoqingkuang")); 
		YongyaoqingkuangView yongyaoqingkuangView =  yongyaoqingkuangService.selectView(ew);
		return R.ok("查询用药情况成功").put("data", yongyaoqingkuangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YongyaoqingkuangEntity yongyaoqingkuang = yongyaoqingkuangService.selectById(id);
        return R.ok().put("data", yongyaoqingkuang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YongyaoqingkuangEntity yongyaoqingkuang = yongyaoqingkuangService.selectById(id);
        return R.ok().put("data", yongyaoqingkuang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YongyaoqingkuangEntity yongyaoqingkuang, HttpServletRequest request){
    	yongyaoqingkuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yongyaoqingkuang);

        yongyaoqingkuangService.insert(yongyaoqingkuang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YongyaoqingkuangEntity yongyaoqingkuang, HttpServletRequest request){
    	yongyaoqingkuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yongyaoqingkuang);

        yongyaoqingkuangService.insert(yongyaoqingkuang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YongyaoqingkuangEntity yongyaoqingkuang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yongyaoqingkuang);
        yongyaoqingkuangService.updateById(yongyaoqingkuang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yongyaoqingkuangService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YongyaoqingkuangEntity> wrapper = new EntityWrapper<YongyaoqingkuangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiashu")) {
			wrapper.eq("jiashuzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("hugong")) {
			wrapper.eq("hugonggonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yongyaoqingkuangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
