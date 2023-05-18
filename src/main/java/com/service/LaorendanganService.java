package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaorendanganEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LaorendanganVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LaorendanganView;


/**
 * 老人档案
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface LaorendanganService extends IService<LaorendanganEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaorendanganVO> selectListVO(Wrapper<LaorendanganEntity> wrapper);
   	
   	LaorendanganVO selectVO(@Param("ew") Wrapper<LaorendanganEntity> wrapper);
   	
   	List<LaorendanganView> selectListView(Wrapper<LaorendanganEntity> wrapper);
   	
   	LaorendanganView selectView(@Param("ew") Wrapper<LaorendanganEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaorendanganEntity> wrapper);
   	

}

