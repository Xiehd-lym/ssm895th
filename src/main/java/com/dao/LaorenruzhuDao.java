package com.dao;

import com.entity.LaorenruzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.LaorenruzhuVO;
import com.entity.view.LaorenruzhuView;


/**
 * 老人入住
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface LaorenruzhuDao extends BaseMapper<LaorenruzhuEntity> {
	
	List<LaorenruzhuVO> selectListVO(@Param("ew") Wrapper<LaorenruzhuEntity> wrapper);
	
	LaorenruzhuVO selectVO(@Param("ew") Wrapper<LaorenruzhuEntity> wrapper);
	
	List<LaorenruzhuView> selectListView(@Param("ew") Wrapper<LaorenruzhuEntity> wrapper);

	List<LaorenruzhuView> selectListView(Pagination page,@Param("ew") Wrapper<LaorenruzhuEntity> wrapper);
	
	LaorenruzhuView selectView(@Param("ew") Wrapper<LaorenruzhuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<LaorenruzhuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LaorenruzhuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LaorenruzhuEntity> wrapper);
}
