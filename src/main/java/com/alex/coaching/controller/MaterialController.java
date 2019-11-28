package com.alex.coaching.controller;

import com.alex.coaching.model.Material;
import com.alex.coaching.service.MaterialService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 10:31 2019/11/28
 */
@Controller
@RequestMapping("material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @RequestMapping("/turnAdd")
    public String turnAdd(){
        return "/material/materialAdd";
    }

    @RequestMapping("/turnList")
    public String turnList(){
        return "/material/materialList";
    }

    @ResponseBody
    @RequestMapping("/list")
    public JSONObject getList(HttpServletRequest request,Material material,int page,int limit ){
        JSONObject jsonObject = new JSONObject();
        List<Material> materialList   = materialService.getAllMaterial(material,page,limit);
        int count = materialService.getAllMaterialCount(material);
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",count);
        jsonObject.put("data",materialList.toArray());
        return jsonObject;
    }


}
