package com.dao;

import com.entity.HuliqingkuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuliqingkuangVO;
import com.entity.view.HuliqingkuangView;


/**
 * 护理情况
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface HuliqingkuangDao extends BaseMapper<HuliqingkuangEntity> {
	
	List<HuliqingkuangVO> selectListVO(@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);
	
	HuliqingkuangVO selectVO(@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);
	
	List<HuliqingkuangView> selectListView(@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);

	List<HuliqingkuangView> selectListView(Pagination page,@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);
	
	HuliqingkuangView selectView(@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuliqingkuangEntity> wrapper);
}
