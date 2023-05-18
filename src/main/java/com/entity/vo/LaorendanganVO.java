package com.entity.vo;

import com.entity.LaorendanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 老人档案
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public class LaorendanganVO  implements Serializable {
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
	 * 老人照片
	 */
	
	private String laorenzhaopian;
		
	/**
	 * 家属账号
	 */
	
	private String jiashuzhanghao;
		
	/**
	 * 生活习惯
	 */
	
	private String shenghuoxiguan;
		
	/**
	 * 兴趣爱好
	 */
	
	private String xingquaihao;
		
	/**
	 * 既往病史
	 */
	
	private String jiwangbingshi;
		
	/**
	 * 行为能力
	 */
	
	private String xingweinengli;
		
	/**
	 * 禁忌物品
	 */
	
	private String jinjiwupin;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 护工工号
	 */
	
	private String hugonggonghao;
				
	
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
	 * 设置：老人照片
	 */
	 
	public void setLaorenzhaopian(String laorenzhaopian) {
		this.laorenzhaopian = laorenzhaopian;
	}
	
	/**
	 * 获取：老人照片
	 */
	public String getLaorenzhaopian() {
		return laorenzhaopian;
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
	 * 设置：生活习惯
	 */
	 
	public void setShenghuoxiguan(String shenghuoxiguan) {
		this.shenghuoxiguan = shenghuoxiguan;
	}
	
	/**
	 * 获取：生活习惯
	 */
	public String getShenghuoxiguan() {
		return shenghuoxiguan;
	}
				
	
	/**
	 * 设置：兴趣爱好
	 */
	 
	public void setXingquaihao(String xingquaihao) {
		this.xingquaihao = xingquaihao;
	}
	
	/**
	 * 获取：兴趣爱好
	 */
	public String getXingquaihao() {
		return xingquaihao;
	}
				
	
	/**
	 * 设置：既往病史
	 */
	 
	public void setJiwangbingshi(String jiwangbingshi) {
		this.jiwangbingshi = jiwangbingshi;
	}
	
	/**
	 * 获取：既往病史
	 */
	public String getJiwangbingshi() {
		return jiwangbingshi;
	}
				
	
	/**
	 * 设置：行为能力
	 */
	 
	public void setXingweinengli(String xingweinengli) {
		this.xingweinengli = xingweinengli;
	}
	
	/**
	 * 获取：行为能力
	 */
	public String getXingweinengli() {
		return xingweinengli;
	}
				
	
	/**
	 * 设置：禁忌物品
	 */
	 
	public void setJinjiwupin(String jinjiwupin) {
		this.jinjiwupin = jinjiwupin;
	}
	
	/**
	 * 获取：禁忌物品
	 */
	public String getJinjiwupin() {
		return jinjiwupin;
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
			
}
