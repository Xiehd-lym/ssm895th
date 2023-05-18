package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.JiashuEntity;
import com.entity.view.JiashuView;
import com.entity.vo.JiashuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 家属
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface JiashuDao extends BaseMapper<JiashuEntity> {
	
	List<JiashuVO> selectListVO(@Param("ew") Wrapper<JiashuEntity> wrapper);
	
	JiashuVO selectVO(@Param("ew") Wrapper<JiashuEntity> wrapper);
	
	List<JiashuView> selectListView(@Param("ew") Wrapper<JiashuEntity> wrapper);

	List<JiashuView> selectListView(Pagination page,@Param("ew") Wrapper<JiashuEntity> wrapper);
	
	JiashuView selectView(@Param("ew") Wrapper<JiashuEntity> wrapper);
	

}
