package com.dao;

import com.entity.HugonggongziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.HugonggongziVO;
import com.entity.view.HugonggongziView;


/**
 * 护工工资
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface HugonggongziDao extends BaseMapper<HugonggongziEntity> {
	
	List<HugonggongziVO> selectListVO(@Param("ew") Wrapper<HugonggongziEntity> wrapper);
	
	HugonggongziVO selectVO(@Param("ew") Wrapper<HugonggongziEntity> wrapper);
	
	List<HugonggongziView> selectListView(@Param("ew") Wrapper<HugonggongziEntity> wrapper);

	List<HugonggongziView> selectListView(Pagination page,@Param("ew") Wrapper<HugonggongziEntity> wrapper);
	
	HugonggongziView selectView(@Param("ew") Wrapper<HugonggongziEntity> wrapper);
	

}
