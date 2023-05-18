package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuangweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChuangweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuangweiView;


/**
 * 床位
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface ChuangweiService extends IService<ChuangweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuangweiVO> selectListVO(Wrapper<ChuangweiEntity> wrapper);
   	
   	ChuangweiVO selectVO(@Param("ew") Wrapper<ChuangweiEntity> wrapper);
   	
   	List<ChuangweiView> selectListView(Wrapper<ChuangweiEntity> wrapper);
   	
   	ChuangweiView selectView(@Param("ew") Wrapper<ChuangweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuangweiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChuangweiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChuangweiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChuangweiEntity> wrapper);
}

