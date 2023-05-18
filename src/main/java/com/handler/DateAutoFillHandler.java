package com.handler;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.springframework.stereotype.Component;

/**
 * 自定义填充处理器
 */
@Component
public class DateAutoFillHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("ctime", new Date(), metaObject);
    }

    @Override
    public boolean openUpdateFill() {
        return false;
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 关闭更新填充、这里不执行
    }
}
