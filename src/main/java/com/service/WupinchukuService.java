package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WupinchukuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WupinchukuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinchukuView;


/**
 * 物品出库
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface WupinchukuService extends IService<WupinchukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WupinchukuVO> selectListVO(Wrapper<WupinchukuEntity> wrapper);
   	
   	WupinchukuVO selectVO(@Param("ew") Wrapper<WupinchukuEntity> wrapper);
   	
   	List<WupinchukuView> selectListView(Wrapper<WupinchukuEntity> wrapper);
   	
   	WupinchukuView selectView(@Param("ew") Wrapper<WupinchukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WupinchukuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<WupinchukuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<WupinchukuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<WupinchukuEntity> wrapper);
}

