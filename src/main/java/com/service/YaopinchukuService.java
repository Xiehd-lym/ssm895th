package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YaopinchukuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YaopinchukuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YaopinchukuView;


/**
 * 药品出库
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface YaopinchukuService extends IService<YaopinchukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YaopinchukuVO> selectListVO(Wrapper<YaopinchukuEntity> wrapper);
   	
   	YaopinchukuVO selectVO(@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
   	
   	List<YaopinchukuView> selectListView(Wrapper<YaopinchukuEntity> wrapper);
   	
   	YaopinchukuView selectView(@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YaopinchukuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YaopinchukuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YaopinchukuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YaopinchukuEntity> wrapper);
}

