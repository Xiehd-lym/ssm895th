package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuliqingkuangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuliqingkuangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuliqingkuangView;


/**
 * 护理情况
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface HuliqingkuangService extends IService<HuliqingkuangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuliqingkuangVO> selectListVO(Wrapper<HuliqingkuangEntity> wrapper);
   	
   	HuliqingkuangVO selectVO(@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);
   	
   	List<HuliqingkuangView> selectListView(Wrapper<HuliqingkuangEntity> wrapper);
   	
   	HuliqingkuangView selectView(@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuliqingkuangEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<HuliqingkuangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<HuliqingkuangEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<HuliqingkuangEntity> wrapper);
}

