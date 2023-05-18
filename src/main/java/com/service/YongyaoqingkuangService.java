package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YongyaoqingkuangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YongyaoqingkuangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YongyaoqingkuangView;


/**
 * 用药情况
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface YongyaoqingkuangService extends IService<YongyaoqingkuangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YongyaoqingkuangVO> selectListVO(Wrapper<YongyaoqingkuangEntity> wrapper);
   	
   	YongyaoqingkuangVO selectVO(@Param("ew") Wrapper<YongyaoqingkuangEntity> wrapper);
   	
   	List<YongyaoqingkuangView> selectListView(Wrapper<YongyaoqingkuangEntity> wrapper);
   	
   	YongyaoqingkuangView selectView(@Param("ew") Wrapper<YongyaoqingkuangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YongyaoqingkuangEntity> wrapper);
   	

}

