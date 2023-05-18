package com.entity.vo;

import com.entity.LoufangziliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 楼房资料
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public class LoufangziliaoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
