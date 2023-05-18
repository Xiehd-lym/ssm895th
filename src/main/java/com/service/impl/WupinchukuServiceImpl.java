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


import com.dao.WupinchukuDao;
import com.entity.WupinchukuEntity;
import com.service.WupinchukuService;
import com.entity.vo.WupinchukuVO;
import com.entity.view.WupinchukuView;

@Service("wupinchukuService")
public class WupinchukuServiceImpl extends ServiceImpl<WupinchukuDao, WupinchukuEntity> implements WupinchukuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WupinchukuEntity> page = this.selectPage(
                new Query<WupinchukuEntity>(params).getPage(),
                new EntityWrapper<WupinchukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WupinchukuEntity> wrapper) {
		  Page<WupinchukuView> page =new Query<WupinchukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WupinchukuVO> selectListVO(Wrapper<WupinchukuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WupinchukuVO selectVO(Wrapper<WupinchukuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WupinchukuView> selectListView(Wrapper<WupinchukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WupinchukuView selectView(Wrapper<WupinchukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<WupinchukuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<WupinchukuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<WupinchukuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
