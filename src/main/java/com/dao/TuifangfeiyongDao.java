package com.dao;

import com.entity.TuifangfeiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuifangfeiyongVO;
import com.entity.view.TuifangfeiyongView;


/**
 * 退房费用
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface TuifangfeiyongDao extends BaseMapper<TuifangfeiyongEntity> {
	
	List<TuifangfeiyongVO> selectListVO(@Param("ew") Wrapper<TuifangfeiyongEntity> wrapper);
	
	TuifangfeiyongVO selectVO(@Param("ew") Wrapper<TuifangfeiyongEntity> wrapper);
	
	List<TuifangfeiyongView> selectListView(@Param("ew") Wrapper<TuifangfeiyongEntity> wrapper);

	List<TuifangfeiyongView> selectListView(Pagination page,@Param("ew") Wrapper<TuifangfeiyongEntity> wrapper);
	
	TuifangfeiyongView selectView(@Param("ew") Wrapper<TuifangfeiyongEntity> wrapper);
	

}
