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


import com.dao.ZhuanfangdengjiDao;
import com.entity.ZhuanfangdengjiEntity;
import com.service.ZhuanfangdengjiService;
import com.entity.vo.ZhuanfangdengjiVO;
import com.entity.view.ZhuanfangdengjiView;

@Service("zhuanfangdengjiService")
public class ZhuanfangdengjiServiceImpl extends ServiceImpl<ZhuanfangdengjiDao, ZhuanfangdengjiEntity> implements ZhuanfangdengjiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuanfangdengjiEntity> page = this.selectPage(
                new Query<ZhuanfangdengjiEntity>(params).getPage(),
                new EntityWrapper<ZhuanfangdengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuanfangdengjiEntity> wrapper) {
		  Page<ZhuanfangdengjiView> page =new Query<ZhuanfangdengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuanfangdengjiVO> selectListVO(Wrapper<ZhuanfangdengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuanfangdengjiVO selectVO(Wrapper<ZhuanfangdengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuanfangdengjiView> selectListView(Wrapper<ZhuanfangdengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuanfangdengjiView selectView(Wrapper<ZhuanfangdengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
