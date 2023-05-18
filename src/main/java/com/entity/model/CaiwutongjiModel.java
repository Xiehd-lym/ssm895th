package com.entity.model;

import com.entity.CaiwutongjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 财务统计
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public class CaiwutongjiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 当月收入
	 */
	
	private Float dangyueshouru;
		
	/**
	 * 当月支出
	 */
	
	private Float dangyuezhichu;
		
	/**
	 * 纯利润
	 */
	
	private Float chunlirun;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
				
	
	/**
	 * 设置：当月收入
	 */
	 
	public void setDangyueshouru(Float dangyueshouru) {
		this.dangyueshouru = dangyueshouru;
	}
	
	/**
	 * 获取：当月收入
	 */
	public Float getDangyueshouru() {
		return dangyueshouru;
	}
				
	
	/**
	 * 设置：当月支出
	 */
	 
	public void setDangyuezhichu(Float dangyuezhichu) {
		this.dangyuezhichu = dangyuezhichu;
	}
	
	/**
	 * 获取：当月支出
	 */
	public Float getDangyuezhichu() {
		return dangyuezhichu;
	}
				
	
	/**
	 * 设置：纯利润
	 */
	 
	public void setChunlirun(Float chunlirun) {
		this.chunlirun = chunlirun;
	}
	
	/**
	 * 获取：纯利润
	 */
	public Float getChunlirun() {
		return chunlirun;
	}
				
	
	/**
	 * 设置：登记日期
	 */
	 
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
			
}
