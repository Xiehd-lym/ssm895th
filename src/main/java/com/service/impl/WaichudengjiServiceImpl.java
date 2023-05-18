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


import com.dao.WaichudengjiDao;
import com.entity.WaichudengjiEntity;
import com.service.WaichudengjiService;
import com.entity.vo.WaichudengjiVO;
import com.entity.view.WaichudengjiView;

@Service("waichudengjiService")
public class WaichudengjiServiceImpl extends ServiceImpl<WaichudengjiDao, WaichudengjiEntity> implements WaichudengjiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WaichudengjiEntity> page = this.selectPage(
                new Query<WaichudengjiEntity>(params).getPage(),
                new EntityWrapper<WaichudengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WaichudengjiEntity> wrapper) {
		  Page<WaichudengjiView> page =new Query<WaichudengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WaichudengjiVO> selectListVO(Wrapper<WaichudengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WaichudengjiVO selectVO(Wrapper<WaichudengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WaichudengjiView> selectListView(Wrapper<WaichudengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WaichudengjiView selectView(Wrapper<WaichudengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
