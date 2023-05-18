package com.dao;

import com.entity.ZhuanfangdengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuanfangdengjiVO;
import com.entity.view.ZhuanfangdengjiView;


/**
 * 转房登记
 * 
 * @author 
 * @email 
 * @date 2022-03-22 22:11:26
 */
@Mapper
public interface ZhuanfangdengjiDao extends BaseMapper<ZhuanfangdengjiEntity> {
	
	List<ZhuanfangdengjiVO> selectListVO(@Param("ew") Wrapper<ZhuanfangdengjiEntity> wrapper);
	
	ZhuanfangdengjiVO selectVO(@Param("ew") Wrapper<ZhuanfangdengjiEntity> wrapper);
	
	List<ZhuanfangdengjiView> selectListView(@Param("ew") Wrapper<ZhuanfangdengjiEntity> wrapper);

	List<ZhuanfangdengjiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuanfangdengjiEntity> wrapper);
	
	ZhuanfangdengjiView selectView(@Param("ew") Wrapper<ZhuanfangdengjiEntity> wrapper);
	

}
