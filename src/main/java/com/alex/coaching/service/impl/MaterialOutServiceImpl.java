package com.alex.coaching.service.impl;

import com.alex.coaching.mapper.MaterialOutMapper;
import com.alex.coaching.model.MaterialOut;
import com.alex.coaching.service.MaterialOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 10:28 2019/11/28
 */
@Service("materialOutService")
public class MaterialOutServiceImpl implements MaterialOutService {

    @Autowired
    private MaterialOutMapper materialOutMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return materialOutMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MaterialOut record) {
        return materialOutMapper.insert(record);
    }

    @Override
    public int insertSelective(MaterialOut record) {
        return materialOutMapper.insertSelective(record);
    }

    @Override
    public MaterialOut selectByPrimaryKey(Integer id) {
        return materialOutMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MaterialOut record) {
        return materialOutMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MaterialOut record) {
        return materialOutMapper.updateByPrimaryKey(record);
    }

    @Override
    public int getAllMaterialOutCount(MaterialOut record) {
        return materialOutMapper.getAllMaterialOutCount(record);
    }

    @Override
    public List<MaterialOut> getAllMaterialOut(MaterialOut materialOut,String outDateMin,String outDateMax, int page, int limit) {
        page=(page-1)*limit;
        return materialOutMapper.getAllMaterialOut(outDateMin,outDateMax,page,limit,materialOut);
    }
}
