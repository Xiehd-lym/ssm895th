package com.entity.model;

import com.entity.RichangjiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 日常缴费
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public class RichangjiaofeiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 老人姓名
	 */
	
	private String laorenxingming;
		
	/**
	 * 家属账号
	 */
	
	private String jiashuzhanghao;
		
	/**
	 * 缴费标题
	 */
	
	private String jiaofeibiaoti;
		
	/**
	 * 缴费内容
	 */
	
	private String jiaofeineirong;
		
	/**
	 * 缴费金额
	 */
	
	private Float jiaofeijine;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：缴费标题
	 */
	 
	public void setJiaofeibiaoti(String jiaofeibiaoti) {
		this.jiaofeibiaoti = jiaofeibiaoti;
	}
	
	/**
	 * 获取：缴费标题
	 */
	public String getJiaofeibiaoti() {
		return jiaofeibiaoti;
	}
				
	
	/**
	 * 设置：缴费内容
	 */
	 
	public void setJiaofeineirong(String jiaofeineirong) {
		this.jiaofeineirong = jiaofeineirong;
	}
	
	/**
	 * 获取：缴费内容
	 */
	public String getJiaofeineirong() {
		return jiaofeineirong;
	}
				
	
	/**
	 * 设置：缴费金额
	 */
	 
	public void setJiaofeijine(Float jiaofeijine) {
		this.jiaofeijine = jiaofeijine;
	}
	
	/**
	 * 获取：缴费金额
	 */
	public Float getJiaofeijine() {
		return jiaofeijine;
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
