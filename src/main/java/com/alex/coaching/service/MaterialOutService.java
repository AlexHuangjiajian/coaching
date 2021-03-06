package com.alex.coaching.service;

import com.alex.coaching.model.Material;
import com.alex.coaching.model.MaterialOut;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface MaterialOutService {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_out
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_out
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    int insert(MaterialOut record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_out
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    int insertSelective(MaterialOut record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_out
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    MaterialOut selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_out
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    int updateByPrimaryKeySelective(MaterialOut record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_out
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    int updateByPrimaryKey(MaterialOut record);

    int  getAllMaterialOutCount(MaterialOut record);

    List<MaterialOut> getAllMaterialOut(MaterialOut materialOut,String outDateMin,String outDateMax,
                                        int page, int limit);

    JSONObject printWord(HttpServletRequest request, HttpServletResponse response, String data) throws Exception;

}