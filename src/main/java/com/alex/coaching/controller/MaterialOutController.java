package com.alex.coaching.controller;

import com.alex.coaching.model.MaterialOut;
import com.alex.coaching.service.MaterialOutService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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


}
