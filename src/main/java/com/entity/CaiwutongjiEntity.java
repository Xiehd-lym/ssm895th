package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 财务统计
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@TableName("caiwutongji")
public class CaiwutongjiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CaiwutongjiEntity() {
		
	}
	
	public CaiwutongjiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 统计编号
	 */
					
	private String tongjibianhao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：统计编号
	 */
	public void setTongjibianhao(String tongjibianhao) {
		this.tongjibianhao = tongjibianhao;
	}
	/**
	 * 获取：统计编号
	 */
	public String getTongjibianhao() {
		return tongjibianhao;
	}
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
