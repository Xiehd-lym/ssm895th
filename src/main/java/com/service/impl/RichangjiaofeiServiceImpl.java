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


import com.dao.RichangjiaofeiDao;
import com.entity.RichangjiaofeiEntity;
import com.service.RichangjiaofeiService;
import com.entity.vo.RichangjiaofeiVO;
import com.entity.view.RichangjiaofeiView;

@Service("richangjiaofeiService")
public class RichangjiaofeiServiceImpl extends ServiceImpl<RichangjiaofeiDao, RichangjiaofeiEntity> implements RichangjiaofeiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RichangjiaofeiEntity> page = this.selectPage(
                new Query<RichangjiaofeiEntity>(params).getPage(),
                new EntityWrapper<RichangjiaofeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RichangjiaofeiEntity> wrapper) {
		  Page<RichangjiaofeiView> page =new Query<RichangjiaofeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RichangjiaofeiVO> selectListVO(Wrapper<RichangjiaofeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RichangjiaofeiVO selectVO(Wrapper<RichangjiaofeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RichangjiaofeiView> selectListView(Wrapper<RichangjiaofeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RichangjiaofeiView selectView(Wrapper<RichangjiaofeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
