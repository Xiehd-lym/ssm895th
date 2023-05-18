package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WupinrukuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WupinrukuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinrukuView;


/**
 * 物品入库
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface WupinrukuService extends IService<WupinrukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WupinrukuVO> selectListVO(Wrapper<WupinrukuEntity> wrapper);
   	
   	WupinrukuVO selectVO(@Param("ew") Wrapper<WupinrukuEntity> wrapper);
   	
   	List<WupinrukuView> selectListView(Wrapper<WupinrukuEntity> wrapper);
   	
   	WupinrukuView selectView(@Param("ew") Wrapper<WupinrukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WupinrukuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<WupinrukuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<WupinrukuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<WupinrukuEntity> wrapper);
}

