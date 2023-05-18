package com.dao;

import com.entity.WaichudengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.WaichudengjiVO;
import com.entity.view.WaichudengjiView;


/**
 * 外出登记
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface WaichudengjiDao extends BaseMapper<WaichudengjiEntity> {
	
	List<WaichudengjiVO> selectListVO(@Param("ew") Wrapper<WaichudengjiEntity> wrapper);
	
	WaichudengjiVO selectVO(@Param("ew") Wrapper<WaichudengjiEntity> wrapper);
	
	List<WaichudengjiView> selectListView(@Param("ew") Wrapper<WaichudengjiEntity> wrapper);

	List<WaichudengjiView> selectListView(Pagination page,@Param("ew") Wrapper<WaichudengjiEntity> wrapper);
	
	WaichudengjiView selectView(@Param("ew") Wrapper<WaichudengjiEntity> wrapper);
	

}
