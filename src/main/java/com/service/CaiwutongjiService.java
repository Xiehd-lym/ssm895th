package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaiwutongjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CaiwutongjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CaiwutongjiView;


/**
 * 财务统计
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface CaiwutongjiService extends IService<CaiwutongjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaiwutongjiVO> selectListVO(Wrapper<CaiwutongjiEntity> wrapper);
   	
   	CaiwutongjiVO selectVO(@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);
   	
   	List<CaiwutongjiView> selectListView(Wrapper<CaiwutongjiEntity> wrapper);
   	
   	CaiwutongjiView selectView(@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaiwutongjiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CaiwutongjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CaiwutongjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CaiwutongjiEntity> wrapper);
}

