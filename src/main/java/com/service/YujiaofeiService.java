package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YujiaofeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YujiaofeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YujiaofeiView;


/**
 * 预交费
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface YujiaofeiService extends IService<YujiaofeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YujiaofeiVO> selectListVO(Wrapper<YujiaofeiEntity> wrapper);
   	
   	YujiaofeiVO selectVO(@Param("ew") Wrapper<YujiaofeiEntity> wrapper);
   	
   	List<YujiaofeiView> selectListView(Wrapper<YujiaofeiEntity> wrapper);
   	
   	YujiaofeiView selectView(@Param("ew") Wrapper<YujiaofeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YujiaofeiEntity> wrapper);
   	

}

