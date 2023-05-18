package com.dao;

import com.entity.YaopinchukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.YaopinchukuVO;
import com.entity.view.YaopinchukuView;


/**
 * 药品出库
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface YaopinchukuDao extends BaseMapper<YaopinchukuEntity> {
	
	List<YaopinchukuVO> selectListVO(@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
	
	YaopinchukuVO selectVO(@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
	
	List<YaopinchukuView> selectListView(@Param("ew") Wrapper<YaopinchukuEntity> wrapper);

	List<YaopinchukuView> selectListView(Pagination page,@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
	
	YaopinchukuView selectView(@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<YaopinchukuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YaopinchukuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YaopinchukuEntity> wrapper);
}
