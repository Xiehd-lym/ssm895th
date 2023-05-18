package com.dao;

import com.entity.YujiaofeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.YujiaofeiVO;
import com.entity.view.YujiaofeiView;


/**
 * 预交费
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface YujiaofeiDao extends BaseMapper<YujiaofeiEntity> {
	
	List<YujiaofeiVO> selectListVO(@Param("ew") Wrapper<YujiaofeiEntity> wrapper);
	
	YujiaofeiVO selectVO(@Param("ew") Wrapper<YujiaofeiEntity> wrapper);
	
	List<YujiaofeiView> selectListView(@Param("ew") Wrapper<YujiaofeiEntity> wrapper);

	List<YujiaofeiView> selectListView(Pagination page,@Param("ew") Wrapper<YujiaofeiEntity> wrapper);
	
	YujiaofeiView selectView(@Param("ew") Wrapper<YujiaofeiEntity> wrapper);
	

}
