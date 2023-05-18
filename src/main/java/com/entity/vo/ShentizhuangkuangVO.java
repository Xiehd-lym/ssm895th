package com.entity.vo;

import com.entity.ShentizhuangkuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 身体状况
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public class ShentizhuangkuangVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 老人姓名
	 */
	
	private String laorenxingming;
		
	/**
	 * 老人性别
	 */
	
	private String laorenxingbie;
		
	/**
	 * 老人年龄
	 */
	
	private String laorennianling;
		
	/**
	 * 体温
	 */
	
	private String tiwen;
		
	/**
	 * 血压
	 */
	
	private String xueya;
		
	/**
	 * 心跳
	 */
	
	private String xintiao;
		
	/**
	 * 建议
	 */
	
	private String jianyi;
		
	/**
	 * 添加时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tianjiashijian;
		
	/**
	 * 护工工号
	 */
	
	private String hugonggonghao;
		
	/**
	 * 护工姓名
	 */
	
	private String hugongxingming;
				
	
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
	 * 设置：老人性别
	 */
	 
	public void setLaorenxingbie(String laorenxingbie) {
		this.laorenxingbie = laorenxingbie;
	}
	
	/**
	 * 获取：老人性别
	 */
	public String getLaorenxingbie() {
		return laorenxingbie;
	}
				
	
	/**
	 * 设置：老人年龄
	 */
	 
	public void setLaorennianling(String laorennianling) {
		this.laorennianling = laorennianling;
	}
	
	/**
	 * 获取：老人年龄
	 */
	public String getLaorennianling() {
		return laorennianling;
	}
				
	
	/**
	 * 设置：体温
	 */
	 
	public void setTiwen(String tiwen) {
		this.tiwen = tiwen;
	}
	
	/**
	 * 获取：体温
	 */
	public String getTiwen() {
		return tiwen;
	}
				
	
	/**
	 * 设置：血压
	 */
	 
	public void setXueya(String xueya) {
		this.xueya = xueya;
	}
	
	/**
	 * 获取：血压
	 */
	public String getXueya() {
		return xueya;
	}
				
	
	/**
	 * 设置：心跳
	 */
	 
	public void setXintiao(String xintiao) {
		this.xintiao = xintiao;
	}
	
	/**
	 * 获取：心跳
	 */
	public String getXintiao() {
		return xintiao;
	}
				
	
	/**
	 * 设置：建议
	 */
	 
	public void setJianyi(String jianyi) {
		this.jianyi = jianyi;
	}
	
	/**
	 * 获取：建议
	 */
	public String getJianyi() {
		return jianyi;
	}
				
	
	/**
	 * 设置：添加时间
	 */
	 
	public void setTianjiashijian(Date tianjiashijian) {
		this.tianjiashijian = tianjiashijian;
	}
	
	/**
	 * 获取：添加时间
	 */
	public Date getTianjiashijian() {
		return tianjiashijian;
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
			
}
