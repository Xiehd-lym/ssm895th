package com.dao;

import com.entity.WupinrukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.WupinrukuVO;
import com.entity.view.WupinrukuView;


/**
 * 物品入库
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface WupinrukuDao extends BaseMapper<WupinrukuEntity> {
	
	List<WupinrukuVO> selectListVO(@Param("ew") Wrapper<WupinrukuEntity> wrapper);
	
	WupinrukuVO selectVO(@Param("ew") Wrapper<WupinrukuEntity> wrapper);
	
	List<WupinrukuView> selectListView(@Param("ew") Wrapper<WupinrukuEntity> wrapper);

	List<WupinrukuView> selectListView(Pagination page,@Param("ew") Wrapper<WupinrukuEntity> wrapper);
	
	WupinrukuView selectView(@Param("ew") Wrapper<WupinrukuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<WupinrukuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WupinrukuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WupinrukuEntity> wrapper);
}
