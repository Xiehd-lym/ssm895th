package com.dao;

import com.entity.ShentizhuangkuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShentizhuangkuangVO;
import com.entity.view.ShentizhuangkuangView;


/**
 * 身体状况
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface ShentizhuangkuangDao extends BaseMapper<ShentizhuangkuangEntity> {
	
	List<ShentizhuangkuangVO> selectListVO(@Param("ew") Wrapper<ShentizhuangkuangEntity> wrapper);
	
	ShentizhuangkuangVO selectVO(@Param("ew") Wrapper<ShentizhuangkuangEntity> wrapper);
	
	List<ShentizhuangkuangView> selectListView(@Param("ew") Wrapper<ShentizhuangkuangEntity> wrapper);

	List<ShentizhuangkuangView> selectListView(Pagination page,@Param("ew") Wrapper<ShentizhuangkuangEntity> wrapper);
	
	ShentizhuangkuangView selectView(@Param("ew") Wrapper<ShentizhuangkuangEntity> wrapper);
	

}
