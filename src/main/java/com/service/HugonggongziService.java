package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HugonggongziEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HugonggongziVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HugonggongziView;


/**
 * 护工工资
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface HugonggongziService extends IService<HugonggongziEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HugonggongziVO> selectListVO(Wrapper<HugonggongziEntity> wrapper);
   	
   	HugonggongziVO selectVO(@Param("ew") Wrapper<HugonggongziEntity> wrapper);
   	
   	List<HugonggongziView> selectListView(Wrapper<HugonggongziEntity> wrapper);
   	
   	HugonggongziView selectView(@Param("ew") Wrapper<HugonggongziEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HugonggongziEntity> wrapper);
   	

}

