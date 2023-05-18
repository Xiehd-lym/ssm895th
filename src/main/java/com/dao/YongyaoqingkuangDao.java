package com.dao;

import com.entity.YongyaoqingkuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.YongyaoqingkuangVO;
import com.entity.view.YongyaoqingkuangView;


/**
 * 用药情况
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface YongyaoqingkuangDao extends BaseMapper<YongyaoqingkuangEntity> {
	
	List<YongyaoqingkuangVO> selectListVO(@Param("ew") Wrapper<YongyaoqingkuangEntity> wrapper);
	
	YongyaoqingkuangVO selectVO(@Param("ew") Wrapper<YongyaoqingkuangEntity> wrapper);
	
	List<YongyaoqingkuangView> selectListView(@Param("ew") Wrapper<YongyaoqingkuangEntity> wrapper);

	List<YongyaoqingkuangView> selectListView(Pagination page,@Param("ew") Wrapper<YongyaoqingkuangEntity> wrapper);
	
	YongyaoqingkuangView selectView(@Param("ew") Wrapper<YongyaoqingkuangEntity> wrapper);
	

}
