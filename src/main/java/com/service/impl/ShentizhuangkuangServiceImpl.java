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


import com.dao.ShentizhuangkuangDao;
import com.entity.ShentizhuangkuangEntity;
import com.service.ShentizhuangkuangService;
import com.entity.vo.ShentizhuangkuangVO;
import com.entity.view.ShentizhuangkuangView;

@Service("shentizhuangkuangService")
public class ShentizhuangkuangServiceImpl extends ServiceImpl<ShentizhuangkuangDao, ShentizhuangkuangEntity> implements ShentizhuangkuangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShentizhuangkuangEntity> page = this.selectPage(
                new Query<ShentizhuangkuangEntity>(params).getPage(),
                new EntityWrapper<ShentizhuangkuangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShentizhuangkuangEntity> wrapper) {
		  Page<ShentizhuangkuangView> page =new Query<ShentizhuangkuangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShentizhuangkuangVO> selectListVO(Wrapper<ShentizhuangkuangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShentizhuangkuangVO selectVO(Wrapper<ShentizhuangkuangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShentizhuangkuangView> selectListView(Wrapper<ShentizhuangkuangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShentizhuangkuangView selectView(Wrapper<ShentizhuangkuangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
