package com.alex.coaching.common;

import java.net.URISyntaxException;

/**
 * @Author: alex_huang
 * @Description:
 * @Date: Create in 17:14 2019/12/4
 */
public class Constants {

    //公司名称
    public static final String COMPANY_NAME = "广州辰星教育有限公司";
    //生产部
    public static final String PRODUCT_DEPARTMENT = "生产部    ";
    //渲染表格后临时存放位置
    public static String EXCEL_TEMP = null;
    //出仓单模板路径
    public static String OUTEXCEL_PATH = null;

    static {
        try {
            EXCEL_TEMP = Constants.class.getResource("/").toURI().getPath()+"static/ExcelTemp/";
            OUTEXCEL_PATH =  Constants.class.getResource("/").toURI().getPath()+"static/Excel/outWord.docx";
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
