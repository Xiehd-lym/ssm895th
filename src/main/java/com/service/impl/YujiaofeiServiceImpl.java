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


import com.dao.YujiaofeiDao;
import com.entity.YujiaofeiEntity;
import com.service.YujiaofeiService;
import com.entity.vo.YujiaofeiVO;
import com.entity.view.YujiaofeiView;

@Service("yujiaofeiService")
public class YujiaofeiServiceImpl extends ServiceImpl<YujiaofeiDao, YujiaofeiEntity> implements YujiaofeiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YujiaofeiEntity> page = this.selectPage(
                new Query<YujiaofeiEntity>(params).getPage(),
                new EntityWrapper<YujiaofeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YujiaofeiEntity> wrapper) {
		  Page<YujiaofeiView> page =new Query<YujiaofeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YujiaofeiVO> selectListVO(Wrapper<YujiaofeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YujiaofeiVO selectVO(Wrapper<YujiaofeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YujiaofeiView> selectListView(Wrapper<YujiaofeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YujiaofeiView selectView(Wrapper<YujiaofeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
