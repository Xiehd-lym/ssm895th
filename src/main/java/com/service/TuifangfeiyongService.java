package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuifangfeiyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuifangfeiyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuifangfeiyongView;


/**
 * 退房费用
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface TuifangfeiyongService extends IService<TuifangfeiyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuifangfeiyongVO> selectListVO(Wrapper<TuifangfeiyongEntity> wrapper);
   	
   	TuifangfeiyongVO selectVO(@Param("ew") Wrapper<TuifangfeiyongEntity> wrapper);
   	
   	List<TuifangfeiyongView> selectListView(Wrapper<TuifangfeiyongEntity> wrapper);
   	
   	TuifangfeiyongView selectView(@Param("ew") Wrapper<TuifangfeiyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuifangfeiyongEntity> wrapper);
   	

}

