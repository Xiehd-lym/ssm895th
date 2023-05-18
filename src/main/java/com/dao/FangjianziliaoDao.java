package com.dao;

import com.entity.FangjianziliaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangjianziliaoVO;
import com.entity.view.FangjianziliaoView;


/**
 * 房间资料
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface FangjianziliaoDao extends BaseMapper<FangjianziliaoEntity> {
	
	List<FangjianziliaoVO> selectListVO(@Param("ew") Wrapper<FangjianziliaoEntity> wrapper);
	
	FangjianziliaoVO selectVO(@Param("ew") Wrapper<FangjianziliaoEntity> wrapper);
	
	List<FangjianziliaoView> selectListView(@Param("ew") Wrapper<FangjianziliaoEntity> wrapper);

	List<FangjianziliaoView> selectListView(Pagination page,@Param("ew") Wrapper<FangjianziliaoEntity> wrapper);
	
	FangjianziliaoView selectView(@Param("ew") Wrapper<FangjianziliaoEntity> wrapper);
	

}
