package com.alex.coaching.controller;

import com.alex.coaching.model.MaterialOut;
import com.alex.coaching.service.MaterialOutService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping("/add")
    public JSONObject addMaterialOut(String record){
        JSONObject jsonObject = new JSONObject();
        if(record.equals("")||record==null){
            jsonObject.put("code",-1);
            jsonObject.put("msg","参数为空！");
            return jsonObject;
        }

        JSONObject recordJson = JSONObject.parseObject(record);
        String lotNumArr[] = recordJson.getString("lotNumberList").split(",") ;
        String outNumArr[] = recordJson.getString("outnumList").split(",") ;

        if(lotNumArr.length!=outNumArr.length){
            //批号数量没有对应上
            jsonObject.put("code",-1);
            jsonObject.put("msg","批号数量不对应！");
            return jsonObject;
        }
        for (int i =0;i<lotNumArr.length;i++){
          MaterialOut out = new MaterialOut();
          out.setLotNumber(lotNumArr[i]);
          out.setMaterialid(recordJson.getInteger("mId"));
          out.setName(recordJson.getString("name"));
          out.setOutNum(recordJson.getDouble("outNum"));
          out.setSpecifications(recordJson.getString("specifications"));
          out.setOutTime(new Date());
        }
        return jsonObject;
    }


}
