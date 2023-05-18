package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LoufangziliaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LoufangziliaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LoufangziliaoView;


/**
 * 楼房资料
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface LoufangziliaoService extends IService<LoufangziliaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LoufangziliaoVO> selectListVO(Wrapper<LoufangziliaoEntity> wrapper);
   	
   	LoufangziliaoVO selectVO(@Param("ew") Wrapper<LoufangziliaoEntity> wrapper);
   	
   	List<LoufangziliaoView> selectListView(Wrapper<LoufangziliaoEntity> wrapper);
   	
   	LoufangziliaoView selectView(@Param("ew") Wrapper<LoufangziliaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LoufangziliaoEntity> wrapper);
   	

}

