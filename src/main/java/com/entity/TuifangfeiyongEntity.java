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
 * 退房费用
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@TableName("tuifangfeiyong")
public class TuifangfeiyongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TuifangfeiyongEntity() {
		
	}
	
	public TuifangfeiyongEntity(T t) {
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
	 * 入住编号
	 */
					
	private String ruzhubianhao;
	
	/**
	 * 老人姓名
	 */
					
	private String laorenxingming;
	
	/**
	 * 家属账号
	 */
					
	private String jiashuzhanghao;
	
	/**
	 * 家属姓名
	 */
					
	private String jiashuxingming;
	
	/**
	 * 入住费用
	 */
					
	private Float ruzhufeiyong;
	
	/**
	 * 护理费用
	 */
					
	private Float hulifeiyong;
	
	/**
	 * 其他费用
	 */
					
	private Float qitafeiyong;
	
	/**
	 * 合计费用
	 */
					
	private Float hejifeiyong;
	
	/**
	 * 登记时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dengjishijian;
	
	/**
	 * 说明
	 */
					
	private String shuoming;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
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
	 * 设置：入住编号
	 */
	public void setRuzhubianhao(String ruzhubianhao) {
		this.ruzhubianhao = ruzhubianhao;
	}
	/**
	 * 获取：入住编号
	 */
	public String getRuzhubianhao() {
		return ruzhubianhao;
	}
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
	 * 设置：家属账号
	 */
	public void setJiashuzhanghao(String jiashuzhanghao) {
		this.jiashuzhanghao = jiashuzhanghao;
	}
	/**
	 * 获取：家属账号
	 */
	public String getJiashuzhanghao() {
		return jiashuzhanghao;
	}
	/**
	 * 设置：家属姓名
	 */
	public void setJiashuxingming(String jiashuxingming) {
		this.jiashuxingming = jiashuxingming;
	}
	/**
	 * 获取：家属姓名
	 */
	public String getJiashuxingming() {
		return jiashuxingming;
	}
	/**
	 * 设置：入住费用
	 */
	public void setRuzhufeiyong(Float ruzhufeiyong) {
		this.ruzhufeiyong = ruzhufeiyong;
	}
	/**
	 * 获取：入住费用
	 */
	public Float getRuzhufeiyong() {
		return ruzhufeiyong;
	}
	/**
	 * 设置：护理费用
	 */
	public void setHulifeiyong(Float hulifeiyong) {
		this.hulifeiyong = hulifeiyong;
	}
	/**
	 * 获取：护理费用
	 */
	public Float getHulifeiyong() {
		return hulifeiyong;
	}
	/**
	 * 设置：其他费用
	 */
	public void setQitafeiyong(Float qitafeiyong) {
		this.qitafeiyong = qitafeiyong;
	}
	/**
	 * 获取：其他费用
	 */
	public Float getQitafeiyong() {
		return qitafeiyong;
	}
	/**
	 * 设置：合计费用
	 */
	public void setHejifeiyong(Float hejifeiyong) {
		this.hejifeiyong = hejifeiyong;
	}
	/**
	 * 获取：合计费用
	 */
	public Float getHejifeiyong() {
		return hejifeiyong;
	}
	/**
	 * 设置：登记时间
	 */
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
	/**
	 * 设置：说明
	 */
	public void setShuoming(String shuoming) {
		this.shuoming = shuoming;
	}
	/**
	 * 获取：说明
	 */
	public String getShuoming() {
		return shuoming;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
