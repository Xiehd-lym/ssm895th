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
 * 楼房资料
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@TableName("loufangziliao")
public class LoufangziliaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LoufangziliaoEntity() {
		
	}
	
	public LoufangziliaoEntity(T t) {
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
	 * 楼房名称
	 */
					
	private String loufangmingcheng;
	
	/**
	 * 占地面积
	 */
					
	private String zhandimianji;
	
	/**
	 * 装修程度
	 */
					
	private String zhuangxiuchengdu;
	
	/**
	 * 详情
	 */
					
	private String xiangqing;
	
	/**
	 * 建立时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jianlishijian;
	
	
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
	 * 设置：楼房名称
	 */
	public void setLoufangmingcheng(String loufangmingcheng) {
		this.loufangmingcheng = loufangmingcheng;
	}
	/**
	 * 获取：楼房名称
	 */
	public String getLoufangmingcheng() {
		return loufangmingcheng;
	}
	/**
	 * 设置：占地面积
	 */
	public void setZhandimianji(String zhandimianji) {
		this.zhandimianji = zhandimianji;
	}
	/**
	 * 获取：占地面积
	 */
	public String getZhandimianji() {
		return zhandimianji;
	}
	/**
	 * 设置：装修程度
	 */
	public void setZhuangxiuchengdu(String zhuangxiuchengdu) {
		this.zhuangxiuchengdu = zhuangxiuchengdu;
	}
	/**
	 * 获取：装修程度
	 */
	public String getZhuangxiuchengdu() {
		return zhuangxiuchengdu;
	}
	/**
	 * 设置：详情
	 */
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}
	/**
	 * 设置：建立时间
	 */
	public void setJianlishijian(Date jianlishijian) {
		this.jianlishijian = jianlishijian;
	}
	/**
	 * 获取：建立时间
	 */
	public Date getJianlishijian() {
		return jianlishijian;
	}

}
