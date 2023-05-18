package com.dao;

import com.entity.CaiwutongjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.CaiwutongjiVO;
import com.entity.view.CaiwutongjiView;


/**
 * 财务统计
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface CaiwutongjiDao extends BaseMapper<CaiwutongjiEntity> {
	
	List<CaiwutongjiVO> selectListVO(@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);
	
	CaiwutongjiVO selectVO(@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);
	
	List<CaiwutongjiView> selectListView(@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);

	List<CaiwutongjiView> selectListView(Pagination page,@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);
	
	CaiwutongjiView selectView(@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwutongjiEntity> wrapper);
}
