package com.alex.coaching.controller;

import com.alex.coaching.service.MaterialInService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: alex_huang
 * @Description:
 * @Date: Create in 16:18 2019/11/29
 */
@Controller
@RequestMapping("materialIn")
public class MaterialInController {

    @Autowired
    private MaterialInService materialInService;


    @ResponseBody
    @RequestMapping("/getLnList")
    public JSONObject getLnList(Integer materialId){
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> materialOutList   = materialInService.getLnList(materialId);
        if(materialOutList.size()==0){
            jsonObject.put("code",-1);
        }else{
            jsonObject.put("code",0);
        }
        jsonObject.put("list",materialOutList.toArray());
        return jsonObject;
    }
}
