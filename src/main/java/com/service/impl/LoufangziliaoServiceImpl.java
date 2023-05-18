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


import com.dao.LoufangziliaoDao;
import com.entity.LoufangziliaoEntity;
import com.service.LoufangziliaoService;
import com.entity.vo.LoufangziliaoVO;
import com.entity.view.LoufangziliaoView;

@Service("loufangziliaoService")
public class LoufangziliaoServiceImpl extends ServiceImpl<LoufangziliaoDao, LoufangziliaoEntity> implements LoufangziliaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LoufangziliaoEntity> page = this.selectPage(
                new Query<LoufangziliaoEntity>(params).getPage(),
                new EntityWrapper<LoufangziliaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LoufangziliaoEntity> wrapper) {
		  Page<LoufangziliaoView> page =new Query<LoufangziliaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LoufangziliaoVO> selectListVO(Wrapper<LoufangziliaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LoufangziliaoVO selectVO(Wrapper<LoufangziliaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LoufangziliaoView> selectListView(Wrapper<LoufangziliaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LoufangziliaoView selectView(Wrapper<LoufangziliaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
