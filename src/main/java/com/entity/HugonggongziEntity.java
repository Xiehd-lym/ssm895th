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
 * 护工工资
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@TableName("hugonggongzi")
public class HugonggongziEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HugonggongziEntity() {
		
	}
	
	public HugonggongziEntity(T t) {
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
	 * 发放时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fafangshijian;
	
	/**
	 * 护工工号
	 */
					
	private String hugonggonghao;
	
	/**
	 * 护工姓名
	 */
					
	private String hugongxingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 底薪
	 */
					
	private Integer dixin;
	
	/**
	 * 绩效
	 */
					
	private Integer jixiao;
	
	/**
	 * 加班工资
	 */
					
	private Integer jiabangongzi;
	
	/**
	 * 扣请假
	 */
					
	private Integer kouqingjia;
	
	/**
	 * 扣五险一金
	 */
					
	private Integer kouwuxianyijin;
	
	/**
	 * 其它扣款
	 */
					
	private Integer qitakoukuan;
	
	/**
	 * 其它奖励
	 */
					
	private Integer qitajiangli;
	
	/**
	 * 实发工资
	 */
					
	private Integer shifagongzi;
	
	/**
	 * 工资备注
	 */
					
	private String gongzibeizhu;
	
	
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
	 * 设置：发放时间
	 */
	public void setFafangshijian(Date fafangshijian) {
		this.fafangshijian = fafangshijian;
	}
	/**
	 * 获取：发放时间
	 */
	public Date getFafangshijian() {
		return fafangshijian;
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
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：底薪
	 */
	public void setDixin(Integer dixin) {
		this.dixin = dixin;
	}
	/**
	 * 获取：底薪
	 */
	public Integer getDixin() {
		return dixin;
	}
	/**
	 * 设置：绩效
	 */
	public void setJixiao(Integer jixiao) {
		this.jixiao = jixiao;
	}
	/**
	 * 获取：绩效
	 */
	public Integer getJixiao() {
		return jixiao;
	}
	/**
	 * 设置：加班工资
	 */
	public void setJiabangongzi(Integer jiabangongzi) {
		this.jiabangongzi = jiabangongzi;
	}
	/**
	 * 获取：加班工资
	 */
	public Integer getJiabangongzi() {
		return jiabangongzi;
	}
	/**
	 * 设置：扣请假
	 */
	public void setKouqingjia(Integer kouqingjia) {
		this.kouqingjia = kouqingjia;
	}
	/**
	 * 获取：扣请假
	 */
	public Integer getKouqingjia() {
		return kouqingjia;
	}
	/**
	 * 设置：扣五险一金
	 */
	public void setKouwuxianyijin(Integer kouwuxianyijin) {
		this.kouwuxianyijin = kouwuxianyijin;
	}
	/**
	 * 获取：扣五险一金
	 */
	public Integer getKouwuxianyijin() {
		return kouwuxianyijin;
	}
	/**
	 * 设置：其它扣款
	 */
	public void setQitakoukuan(Integer qitakoukuan) {
		this.qitakoukuan = qitakoukuan;
	}
	/**
	 * 获取：其它扣款
	 */
	public Integer getQitakoukuan() {
		return qitakoukuan;
	}
	/**
	 * 设置：其它奖励
	 */
	public void setQitajiangli(Integer qitajiangli) {
		this.qitajiangli = qitajiangli;
	}
	/**
	 * 获取：其它奖励
	 */
	public Integer getQitajiangli() {
		return qitajiangli;
	}
	/**
	 * 设置：实发工资
	 */
	public void setShifagongzi(Integer shifagongzi) {
		this.shifagongzi = shifagongzi;
	}
	/**
	 * 获取：实发工资
	 */
	public Integer getShifagongzi() {
		return shifagongzi;
	}
	/**
	 * 设置：工资备注
	 */
	public void setGongzibeizhu(String gongzibeizhu) {
		this.gongzibeizhu = gongzibeizhu;
	}
	/**
	 * 获取：工资备注
	 */
	public String getGongzibeizhu() {
		return gongzibeizhu;
	}

}
