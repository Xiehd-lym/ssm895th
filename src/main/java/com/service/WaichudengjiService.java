package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WaichudengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WaichudengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WaichudengjiView;


/**
 * 外出登记
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface WaichudengjiService extends IService<WaichudengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WaichudengjiVO> selectListVO(Wrapper<WaichudengjiEntity> wrapper);
   	
   	WaichudengjiVO selectVO(@Param("ew") Wrapper<WaichudengjiEntity> wrapper);
   	
   	List<WaichudengjiView> selectListView(Wrapper<WaichudengjiEntity> wrapper);
   	
   	WaichudengjiView selectView(@Param("ew") Wrapper<WaichudengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WaichudengjiEntity> wrapper);
   	

}

