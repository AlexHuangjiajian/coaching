package com.alex.coaching.service.impl;

import com.alex.coaching.mapper.MaterialMapper;
import com.alex.coaching.model.Material;
import com.alex.coaching.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 10:28 2019/11/28
 */
@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return materialMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Material record) {
        return materialMapper.insert(record);
    }

    @Override
    public int insertSelective(Material record) {
        return materialMapper.insertSelective(record);
    }

    @Override
    public Material selectByPrimaryKey(Integer id) {
        return materialMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Material record) {
        return materialMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Material record) {
        return materialMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Material> getAllMaterial(Material material, int page, int limit) {
        page=(page-1)*limit;
        return materialMapper.getAllMaterial(material,page,limit);
    }

    @Override
    public  int  getAllMaterialCount(Material record) {
        return materialMapper.getAllMaterialCount(record);
    }
}
