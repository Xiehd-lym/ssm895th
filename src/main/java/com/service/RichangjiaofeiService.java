package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RichangjiaofeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RichangjiaofeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RichangjiaofeiView;


/**
 * 日常缴费
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface RichangjiaofeiService extends IService<RichangjiaofeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RichangjiaofeiVO> selectListVO(Wrapper<RichangjiaofeiEntity> wrapper);
   	
   	RichangjiaofeiVO selectVO(@Param("ew") Wrapper<RichangjiaofeiEntity> wrapper);
   	
   	List<RichangjiaofeiView> selectListView(Wrapper<RichangjiaofeiEntity> wrapper);
   	
   	RichangjiaofeiView selectView(@Param("ew") Wrapper<RichangjiaofeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RichangjiaofeiEntity> wrapper);
   	

}

