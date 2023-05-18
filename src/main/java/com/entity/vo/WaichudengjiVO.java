package com.entity.vo;

import com.entity.WaichudengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 外出登记
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public class WaichudengjiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 老人姓名
	 */
	
	private String laorenxingming;
		
	/**
	 * 护工工号
	 */
	
	private String hugonggonghao;
		
	/**
	 * 护工姓名
	 */
	
	private String hugongxingming;
		
	/**
	 * 外出地点
	 */
	
	private String waichudidian;
		
	/**
	 * 外出时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date waichushijian;
		
	/**
	 * 回来时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date huilaishijian;
				
	
	/**
	 * 设置：老人姓名
	 */
	 
	public void setLaorenxingming(String laorenxingming) {
		this.laorenxingming = laorenxingming;
	}
	
	/**
	 * 获取：老人姓名
	 */
	public String getLaorenxingming() {
		return laorenxingming;
	}
				
	
	/**
	 * 设置：护工工号
	 */
	 
	public void setHugonggonghao(String hugonggonghao) {
		this.hugonggonghao = hugonggonghao;
	}
	
	/**
	 * 获取：护工工号
	 */
	public String getHugonggonghao() {
		return hugonggonghao;
	}
				
	
	/**
	 * 设置：护工姓名
	 */
	 
	public void setHugongxingming(String hugongxingming) {
		this.hugongxingming = hugongxingming;
	}
	
	/**
	 * 获取：护工姓名
	 */
	public String getHugongxingming() {
		return hugongxingming;
	}
				
	
	/**
	 * 设置：外出地点
	 */
	 
	public void setWaichudidian(String waichudidian) {
		this.waichudidian = waichudidian;
	}
	
	/**
	 * 获取：外出地点
	 */
	public String getWaichudidian() {
		return waichudidian;
	}
				
	
	/**
	 * 设置：外出时间
	 */
	 
	public void setWaichushijian(Date waichushijian) {
		this.waichushijian = waichushijian;
	}
	
	/**
	 * 获取：外出时间
	 */
	public Date getWaichushijian() {
		return waichushijian;
	}
				
	
	/**
	 * 设置：回来时间
	 */
	 
	public void setHuilaishijian(Date huilaishijian) {
		this.huilaishijian = huilaishijian;
	}
	
	/**
	 * 获取：回来时间
	 */
	public Date getHuilaishijian() {
		return huilaishijian;
	}
			
}
