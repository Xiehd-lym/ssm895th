package com.dao;

import com.entity.RichangjiaofeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.RichangjiaofeiVO;
import com.entity.view.RichangjiaofeiView;


/**
 * 日常缴费
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface RichangjiaofeiDao extends BaseMapper<RichangjiaofeiEntity> {
	
	List<RichangjiaofeiVO> selectListVO(@Param("ew") Wrapper<RichangjiaofeiEntity> wrapper);
	
	RichangjiaofeiVO selectVO(@Param("ew") Wrapper<RichangjiaofeiEntity> wrapper);
	
	List<RichangjiaofeiView> selectListView(@Param("ew") Wrapper<RichangjiaofeiEntity> wrapper);

	List<RichangjiaofeiView> selectListView(Pagination page,@Param("ew") Wrapper<RichangjiaofeiEntity> wrapper);
	
	RichangjiaofeiView selectView(@Param("ew") Wrapper<RichangjiaofeiEntity> wrapper);
	

}
