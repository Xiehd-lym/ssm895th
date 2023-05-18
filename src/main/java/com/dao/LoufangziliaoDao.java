package com.dao;

import com.entity.LoufangziliaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.LoufangziliaoVO;
import com.entity.view.LoufangziliaoView;


/**
 * 楼房资料
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface LoufangziliaoDao extends BaseMapper<LoufangziliaoEntity> {
	
	List<LoufangziliaoVO> selectListVO(@Param("ew") Wrapper<LoufangziliaoEntity> wrapper);
	
	LoufangziliaoVO selectVO(@Param("ew") Wrapper<LoufangziliaoEntity> wrapper);
	
	List<LoufangziliaoView> selectListView(@Param("ew") Wrapper<LoufangziliaoEntity> wrapper);

	List<LoufangziliaoView> selectListView(Pagination page,@Param("ew") Wrapper<LoufangziliaoEntity> wrapper);
	
	LoufangziliaoView selectView(@Param("ew") Wrapper<LoufangziliaoEntity> wrapper);
	

}
