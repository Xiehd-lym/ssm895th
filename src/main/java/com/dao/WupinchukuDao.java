package com.dao;

import com.entity.WupinchukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.WupinchukuVO;
import com.entity.view.WupinchukuView;


/**
 * 物品出库
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface WupinchukuDao extends BaseMapper<WupinchukuEntity> {
	
	List<WupinchukuVO> selectListVO(@Param("ew") Wrapper<WupinchukuEntity> wrapper);
	
	WupinchukuVO selectVO(@Param("ew") Wrapper<WupinchukuEntity> wrapper);
	
	List<WupinchukuView> selectListView(@Param("ew") Wrapper<WupinchukuEntity> wrapper);

	List<WupinchukuView> selectListView(Pagination page,@Param("ew") Wrapper<WupinchukuEntity> wrapper);
	
	WupinchukuView selectView(@Param("ew") Wrapper<WupinchukuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<WupinchukuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WupinchukuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WupinchukuEntity> wrapper);
}
