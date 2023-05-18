package com.entity.view;

import com.entity.LoufangziliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 楼房资料
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@TableName("loufangziliao")
public class LoufangziliaoView  extends LoufangziliaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LoufangziliaoView(){
	}
 
 	public LoufangziliaoView(LoufangziliaoEntity loufangziliaoEntity){
 	try {
			BeanUtils.copyProperties(this, loufangziliaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
