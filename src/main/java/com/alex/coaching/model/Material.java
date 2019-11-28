package com.alex.coaching.model;

public class Material {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material.id
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material.name
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material.in_total
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    private Double inTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material.out_total
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    private Double outTotal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column material.stock
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    private Double stock;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material.id
     *
     * @return the value of material.id
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material.id
     *
     * @param id the value for material.id
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material.name
     *
     * @return the value of material.name
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material.name
     *
     * @param name the value for material.name
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material.in_total
     *
     * @return the value of material.in_total
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public Double getInTotal() {
        return inTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material.in_total
     *
     * @param inTotal the value for material.in_total
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public void setInTotal(Double inTotal) {
        this.inTotal = inTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material.out_total
     *
     * @return the value of material.out_total
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public Double getOutTotal() {
        return outTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material.out_total
     *
     * @param outTotal the value for material.out_total
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public void setOutTotal(Double outTotal) {
        this.outTotal = outTotal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column material.stock
     *
     * @return the value of material.stock
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public Double getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column material.stock
     *
     * @param stock the value for material.stock
     *
     * @mbggenerated Thu Nov 28 10:19:56 CST 2019
     */
    public void setStock(Double stock) {
        this.stock = stock;
    }
}