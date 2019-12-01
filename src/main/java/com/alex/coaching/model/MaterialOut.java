package com.alex.coaching.model;

import java.util.Date;

public class MaterialOut {

    private String outDateMin;
    private String outDateMax;

    public String getOutDateMin() {
        return outDateMin;
    }

    public void setOutDateMin(String outDateMin) {
        this.outDateMin = outDateMin;
    }

    public String getOutDateMax() {
        return outDateMax;
    }

    public void setOutDateMax(String outDateMax) {
        this.outDateMax = outDateMax;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material_out.id
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material_out.materialId
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    private Integer materialid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material_out.name
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material_out.lot_number
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    private String lotNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material_out.num
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    private Integer num;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material_out.specifications
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    private String specifications;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material_out.out_num
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    private Double outNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material_out.out_time
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    private Date outTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material_out.id
     *
     * @return the value of material_out.id
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material_out.id
     *
     * @param id the value for material_out.id
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material_out.materialId
     *
     * @return the value of material_out.materialId
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public Integer getMaterialid() {
        return materialid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material_out.materialId
     *
     * @param materialid the value for material_out.materialId
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public void setMaterialid(Integer materialid) {
        this.materialid = materialid;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material_out.lot_number
     *
     * @return the value of material_out.lot_number
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public String getLotNumber() {
        return lotNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material_out.lot_number
     *
     * @param lotNumber the value for material_out.lot_number
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber == null ? null : lotNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material_out.num
     *
     * @return the value of material_out.num
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material_out.num
     *
     * @param num the value for material_out.num
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material_out.specifications
     *
     * @return the value of material_out.specifications
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public String getSpecifications() {
        return specifications;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material_out.specifications
     *
     * @param specifications the value for material_out.specifications
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material_out.out_num
     *
     * @return the value of material_out.out_num
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public Double getOutNum() {
        return outNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material_out.out_num
     *
     * @param outNum the value for material_out.out_num
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public void setOutNum(Double outNum) {
        this.outNum = outNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material_out.out_time
     *
     * @return the value of material_out.out_time
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material_out.out_time
     *
     * @param outTime the value for material_out.out_time
     *
     * @mbggenerated Thu Nov 28 15:29:15 CST 2019
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}