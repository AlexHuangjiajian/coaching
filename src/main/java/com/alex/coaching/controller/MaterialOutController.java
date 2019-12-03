package com.alex.coaching.controller;

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
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
}
