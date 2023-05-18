package com.entity.view;

import com.entity.ShentizhuangkuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 身体状况
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@TableName("shentizhuangkuang")
public class ShentizhuangkuangView  extends ShentizhuangkuangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShentizhuangkuangView(){
	}
 
 	public ShentizhuangkuangView(ShentizhuangkuangEntity shentizhuangkuangEntity){
 	try {
			BeanUtils.copyProperties(this, shentizhuangkuangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
