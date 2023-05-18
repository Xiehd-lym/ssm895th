package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YongyaoqingkuangDao;
import com.entity.YongyaoqingkuangEntity;
import com.service.YongyaoqingkuangService;
import com.entity.vo.YongyaoqingkuangVO;
import com.entity.view.YongyaoqingkuangView;

@Service("yongyaoqingkuangService")
public class YongyaoqingkuangServiceImpl extends ServiceImpl<YongyaoqingkuangDao, YongyaoqingkuangEntity> implements YongyaoqingkuangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YongyaoqingkuangEntity> page = this.selectPage(
                new Query<YongyaoqingkuangEntity>(params).getPage(),
                new EntityWrapper<YongyaoqingkuangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YongyaoqingkuangEntity> wrapper) {
		  Page<YongyaoqingkuangView> page =new Query<YongyaoqingkuangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YongyaoqingkuangVO> selectListVO(Wrapper<YongyaoqingkuangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YongyaoqingkuangVO selectVO(Wrapper<YongyaoqingkuangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YongyaoqingkuangView> selectListView(Wrapper<YongyaoqingkuangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YongyaoqingkuangView selectView(Wrapper<YongyaoqingkuangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
