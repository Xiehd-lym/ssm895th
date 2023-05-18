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


import com.dao.HugonggongziDao;
import com.entity.HugonggongziEntity;
import com.service.HugonggongziService;
import com.entity.vo.HugonggongziVO;
import com.entity.view.HugonggongziView;

@Service("hugonggongziService")
public class HugonggongziServiceImpl extends ServiceImpl<HugonggongziDao, HugonggongziEntity> implements HugonggongziService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HugonggongziEntity> page = this.selectPage(
                new Query<HugonggongziEntity>(params).getPage(),
                new EntityWrapper<HugonggongziEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HugonggongziEntity> wrapper) {
		  Page<HugonggongziView> page =new Query<HugonggongziView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HugonggongziVO> selectListVO(Wrapper<HugonggongziEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HugonggongziVO selectVO(Wrapper<HugonggongziEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HugonggongziView> selectListView(Wrapper<HugonggongziEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HugonggongziView selectView(Wrapper<HugonggongziEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
