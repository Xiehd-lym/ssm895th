package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShentizhuangkuangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShentizhuangkuangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShentizhuangkuangView;


/**
 * 身体状况
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface ShentizhuangkuangService extends IService<ShentizhuangkuangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShentizhuangkuangVO> selectListVO(Wrapper<ShentizhuangkuangEntity> wrapper);
   	
   	ShentizhuangkuangVO selectVO(@Param("ew") Wrapper<ShentizhuangkuangEntity> wrapper);
   	
   	List<ShentizhuangkuangView> selectListView(Wrapper<ShentizhuangkuangEntity> wrapper);
   	
   	ShentizhuangkuangView selectView(@Param("ew") Wrapper<ShentizhuangkuangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShentizhuangkuangEntity> wrapper);
   	

}

