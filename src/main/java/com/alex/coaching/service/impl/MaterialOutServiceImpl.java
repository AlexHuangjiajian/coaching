package com.alex.coaching.service.impl;

import com.alex.coaching.common.Constants;
import com.alex.coaching.common.MapObjUtil;
import com.alex.coaching.controller.WordReporter;
import com.alex.coaching.mapper.MaterialOutMapper;
import com.alex.coaching.model.MaterialOut;
import com.alex.coaching.service.MaterialOutService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Transactional  //开启事务
    public int deleteByPrimaryKey(Integer id) {
        return materialOutMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional  //开启事务
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
    @Transactional  //开启事务
    public int updateByPrimaryKeySelective(MaterialOut record) {
        return materialOutMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional  //开启事务
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

    @Override
    public JSONObject printWord(HttpServletRequest request, HttpServletResponse response, String data) throws Exception {
        JSONObject jsonObject = new JSONObject();
        List<MaterialOut> jsonArray = JSONObject.parseArray(data,MaterialOut.class);
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i=0;i<jsonArray.size();i++){
            MaterialOut out = jsonArray.get(i);
            //TODO: 此处map数据需要做处理,去除不需要的字段，加上表格需要的字段
            Map<String,Object>  map = MapObjUtil.object2Map(out);
            //添加其他表格字段 ，请领数量等等
            map.put("department","生产部");
            map.put("pNum",out.getNum());
            map.put("fNum",out.getNum());
            list.add(map);
        }

        Map<String,Object> textMap=new HashMap<>();
        textMap.put("companyName", Constants.COMPANY_NAME);
        textMap.put("department",Constants.PRODUCT_DEPARTMENT);
        textMap.put("orderId","order"+ Calendar.getInstance().get(Calendar.YEAR)+(Calendar.getInstance().get(Calendar.MONTH)+1)+Calendar.getInstance().get(Calendar.DATE));
        textMap.put("y",Calendar.getInstance().get(Calendar.YEAR));
        textMap.put("m",Calendar.getInstance().get(Calendar.MONTH)+1);
        textMap.put("d",Calendar.getInstance().get(Calendar.DATE));


        // 模板文件输入输出地址
        //String filePath =WordReporter.class.getResource("/").getPath()+"static/Excel/test.docx";
        String filePath = Constants.OUTEXCEL_PATH;
        System.out.println(filePath);
        //输出文件位置
        String longTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String excelName = "outExcel"+longTime+".docx";
        String outPath = Constants.EXCEL_TEMP+excelName;
        //渲染数据
        WordReporter wordReporter = new WordReporter();
        wordReporter.setTempLocalPath(filePath);    //设置模板的路径
        wordReporter.init();            //初始化工具类
        wordReporter.export(list,0,textMap);   //写入相关数据
        wordReporter.generate(outPath);   //导出到目标文档
        System.out.println(outPath);
        //浏览器下载 ajax提交的时候不会弹窗提示下载，form表单提示的才会
      /*  File file = new File(outPath);
        FileUtil.downFile(request,response,excelName,file);*/
        jsonObject.put("code",0);
        jsonObject.put("msg","已渲染数据");
        jsonObject.put("fileUrl",excelName);
        //jsonObject.put("fileUrl","/static/Exceltemp/"+excelName);
        //最后删除文件
        // file.delete();
        return jsonObject;
    }
}
