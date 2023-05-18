package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuanfangdengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuanfangdengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuanfangdengjiView;


/**
 * 转房登记
 *
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
public interface ZhuanfangdengjiService extends IService<ZhuanfangdengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuanfangdengjiVO> selectListVO(Wrapper<ZhuanfangdengjiEntity> wrapper);
   	
   	ZhuanfangdengjiVO selectVO(@Param("ew") Wrapper<ZhuanfangdengjiEntity> wrapper);
   	
   	List<ZhuanfangdengjiView> selectListView(Wrapper<ZhuanfangdengjiEntity> wrapper);
   	
   	ZhuanfangdengjiView selectView(@Param("ew") Wrapper<ZhuanfangdengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuanfangdengjiEntity> wrapper);
   	

}

