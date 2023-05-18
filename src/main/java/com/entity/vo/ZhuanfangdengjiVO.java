package com.entity.vo;

import com.entity.ZhuanfangdengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 转房登记
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public class ZhuanfangdengjiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房间号
	 */
	
	private String fangjianhao;
		
	/**
	 * 楼房名称
	 */
	
	private String loufangmingcheng;
		
	/**
	 * 入住编号
	 */
	
	private String ruzhubianhao;
		
	/**
	 * 老人姓名
	 */
	
	private String laorenxingming;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 新房间号
	 */
	
	private String xinfangjianhao;
		
	/**
	 * 护工工号
	 */
	
	private String hugonggonghao;
		
	/**
	 * 护工姓名
	 */
	
	private String hugongxingming;
				
	
	/**
	 * 设置：房间号
	 */
	 
	public void setFangjianhao(String fangjianhao) {
		this.fangjianhao = fangjianhao;
	}
	
	/**
	 * 获取：房间号
	 */
	public String getFangjianhao() {
		return fangjianhao;
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
	 * 设置：新房间号
	 */
	 
	public void setXinfangjianhao(String xinfangjianhao) {
		this.xinfangjianhao = xinfangjianhao;
	}
	
	/**
	 * 获取：新房间号
	 */
	public String getXinfangjianhao() {
		return xinfangjianhao;
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
