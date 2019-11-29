package com.alex.coaching.service;

import com.alex.coaching.model.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MaterialService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    int insert(Material record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    int insertSelective(Material record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    Material selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    int updateByPrimaryKeySelective(Material record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    int updateByPrimaryKey(Material record);

    List<Map<String,Object>> getNameList();

    List<Material> getAllMaterial(Material material,int page,int limit);

    int  getAllMaterialCount(Material record);
}