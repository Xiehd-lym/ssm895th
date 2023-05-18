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


import com.dao.HuliqingkuangDao;
import com.entity.HuliqingkuangEntity;
import com.service.HuliqingkuangService;
import com.entity.vo.HuliqingkuangVO;
import com.entity.view.HuliqingkuangView;

@Service("huliqingkuangService")
public class HuliqingkuangServiceImpl extends ServiceImpl<HuliqingkuangDao, HuliqingkuangEntity> implements HuliqingkuangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuliqingkuangEntity> page = this.selectPage(
                new Query<HuliqingkuangEntity>(params).getPage(),
                new EntityWrapper<HuliqingkuangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuliqingkuangEntity> wrapper) {
		  Page<HuliqingkuangView> page =new Query<HuliqingkuangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuliqingkuangVO> selectListVO(Wrapper<HuliqingkuangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuliqingkuangVO selectVO(Wrapper<HuliqingkuangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuliqingkuangView> selectListView(Wrapper<HuliqingkuangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuliqingkuangView selectView(Wrapper<HuliqingkuangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<HuliqingkuangEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<HuliqingkuangEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<HuliqingkuangEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
