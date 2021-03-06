package com.alex.coaching.mapper;

import com.alex.coaching.model.MaterialIn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MaterialInMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_in
     *
     * @mbggenerated Fri Nov 29 15:13:33 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_in
     *
     * @mbggenerated Fri Nov 29 15:13:33 CST 2019
     */
    int insert(MaterialIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_in
     *
     * @mbggenerated Fri Nov 29 15:13:33 CST 2019
     */
    int insertSelective(MaterialIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_in
     *
     * @mbggenerated Fri Nov 29 15:13:33 CST 2019
     */
    MaterialIn selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_in
     *
     * @mbggenerated Fri Nov 29 15:13:33 CST 2019
     */
    int updateByPrimaryKeySelective(MaterialIn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table material_in
     *
     * @mbggenerated Fri Nov 29 15:13:33 CST 2019
     */
    int updateByPrimaryKey(MaterialIn record);

    List<Map<String,Object>> getLnList(int materialId);

    int  getAllMaterialInCount(MaterialIn record);

    List<MaterialIn> getAllMaterialIn(@Param("inDateMin")String outDateMin,
                                        @Param("inDateMax")String outDateMax,
                                        @Param("offset")int page, @Param("pageSize")int limit,
                                        @Param("materialIn")MaterialIn materialIn);
}