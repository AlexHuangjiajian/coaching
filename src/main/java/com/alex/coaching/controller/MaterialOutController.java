package com.alex.coaching.controller;

import com.alex.coaching.common.Constants;
import com.alex.coaching.common.FileUtil;
import com.alex.coaching.common.MapObjUtil;
import com.alex.coaching.model.MaterialOut;
import com.alex.coaching.service.MaterialOutService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: alex_huang
 * @Description:
 * @Date: Create in 10:31 2019/11/28
 */
@Controller
@RequestMapping("materialOut")
public class MaterialOutController {
    @Autowired
    private MaterialOutService materialOutService;

    @RequestMapping("/turnAdd")
    public String turnAdd(){
        return "/material/materialOutAdd";
    }

    @RequestMapping("/turnList")
    public String turnList(){
        return "/material/materialOutList";
    }

    @RequestMapping("/turnEdit")
    public String turnEdit(){
        return "/material/materialOutUpdate";
    }

    @ResponseBody
    @RequestMapping("/list")
    public JSONObject getList(HttpServletRequest request, MaterialOut materialOut,
                              int page, int limit,String outDateMin,String outDateMax ){
        JSONObject jsonObject = new JSONObject();
        List<MaterialOut> materialOutList   = materialOutService.getAllMaterialOut(materialOut,outDateMin,outDateMax,page,limit);
        int count = materialOutService.getAllMaterialOutCount(materialOut);
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",count);
        jsonObject.put("data",materialOutList.toArray());
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public JSONObject addMaterialOut(String record){
        System.out.println(record);
        JSONObject jsonObject = new JSONObject();
        if(record.equals("")||record==null){
            jsonObject.put("code",-1);
            jsonObject.put("msg","参数为空！");
            return jsonObject;
        }
        JSONObject recordJson = JSONObject.parseObject(record);
        JSONArray lotNumArr = recordJson.getJSONArray("lotNumberList");
        JSONArray outNumArr = recordJson.getJSONArray("outnumList");
        if(lotNumArr.size()!=outNumArr.size()){
            //批号数量没有对应上
            jsonObject.put("code",-1);
            jsonObject.put("msg","批号数量不对应！");
            return jsonObject;
        }
        for (int i =0;i<lotNumArr.size();i++){
          MaterialOut out = new MaterialOut();
          out.setLotNumber(String.valueOf(lotNumArr.get(i)));
          out.setMaterialid(recordJson.getInteger("mId"));
          out.setName(recordJson.getString("name"));
          out.setNum(Integer.parseInt(outNumArr.get(i).toString()));
          out.setOutNum(recordJson.getDouble("outNum"));
          out.setSpecifications(recordJson.getString("specifications"));
          out.setOutTime(new Date());
          materialOutService.insert(out);
        }
        return jsonObject;
    }


    //删除
    @ResponseBody
    @RequestMapping("/delete")
    public JSONObject deleteOut(int id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",-1);
        jsonObject.put("msg","删除失败");
        if(id<=0){
            return jsonObject;
        }
        int result = materialOutService.deleteByPrimaryKey(id);
        if(result>0){
            jsonObject.put("code",0);
            jsonObject.put("msg","删除成功");
        }
        return jsonObject;
    }

    //获取单条信息
    @ResponseBody
    @RequestMapping("/getInfo")
    public JSONObject getInfo(Integer id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",-1);
        jsonObject.put("msg","获取失败");
        if(id<=0){
            return jsonObject;
        }
        MaterialOut out = materialOutService.selectByPrimaryKey(id);
        jsonObject.put("materialOut", JSONObject.toJSON(out));
        jsonObject.put("msg","获取成功");
        jsonObject.put("code",1);
        return jsonObject;
    }

    @RequestMapping("/printWord")
    public JSONObject printWord(String data, HttpServletRequest request, HttpServletResponse response)throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",-1);
        if(data.equals("")||data==null){
            jsonObject.put("msg","未选择出仓纪录");
            return jsonObject;
        }
        List<MaterialOut> jsonArray = JSONObject.parseArray(data,MaterialOut.class);
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i=0;i<jsonArray.size();i++){
            MaterialOut out = jsonArray.get(i);

            //TODO: 此处map数据需要做处理,去除不需要的字段，加上表格需要的字段
            list.add(MapObjUtil.object2Map(out));
        }

        Map<String,Object> textMap=new HashMap<>();
        textMap.put("companyName", Constants.COMPANY_NAME);
        textMap.put("y",Calendar.getInstance().get(Calendar.YEAR));
        textMap.put("m",Calendar.getInstance().get(Calendar.MONTH)+1);
        textMap.put("d",Calendar.getInstance().get(Calendar.DATE));

        // 模板文件输入输出地址
        //String filePath =WordReporter.class.getResource("/").getPath()+"static/Excel/test.docx";
        String filePath = Constants.OUTEXCEL_PATH;
        System.out.println(filePath);
        //输出文件位置
        String longTime = new SimpleDateFormat("yyyy-MM-dd/HH:MM:SS").format(new Date());
        String excelName = "outExcel"+longTime+".docx";
        String outPath = Constants.EXCEL_TEMP+excelName;
        //渲染数据
        WordReporter wordReporter = new WordReporter();
        wordReporter.setTempLocalPath(filePath);    //设置模板的路径
        wordReporter.init();            //初始化工具类
        wordReporter.export(list,null,null,0,textMap);   //写入相关数据
        wordReporter.generate(outPath);   //导出到目标文档

        //浏览器下载
        File file = new File(outPath);
        InputStream inputStream = new FileInputStream(file);
        FileUtil.doExport(excelName,outPath,request,response);

        //最后删除文件
        file.delete();
        jsonObject.put("code",0);
        jsonObject.put("msg","导出成功");

        return jsonObject;
    }
}
