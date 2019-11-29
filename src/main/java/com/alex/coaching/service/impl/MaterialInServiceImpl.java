package com.alex.coaching.service.impl;

import com.alex.coaching.mapper.MaterialInMapper;
import com.alex.coaching.model.MaterialIn;
import com.alex.coaching.service.MaterialInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 10:28 2019/11/28
 */
@Service("materialInService")
public class MaterialInServiceImpl implements MaterialInService {

    @Autowired
    private MaterialInMapper materialInMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return materialInMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MaterialIn record) {
        return materialInMapper.insert(record);
    }

    @Override
    public int insertSelective(MaterialIn record) {
        return materialInMapper.insertSelective(record);
    }

    @Override
    public MaterialIn selectByPrimaryKey(Integer id) {
        return materialInMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MaterialIn record) {
        return materialInMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MaterialIn record) {
        return materialInMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> getLnList(int materialId) {
        return materialInMapper.getLnList(materialId);
    }

    @Override
    public int getAllMaterialInCount(MaterialIn record) {
        return materialInMapper.getAllMaterialInCount(record);
    }

    @Override
    public List<MaterialIn> getAllMaterialIn(MaterialIn materialOut,String outDateMin,String outDateMax, int page, int limit) {
        page=(page-1)*limit;
        return materialInMapper.getAllMaterialIn(outDateMin,outDateMax,page,limit,materialOut);
    }
}
