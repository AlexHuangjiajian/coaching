package com.alex.coaching.controller;

import com.alex.coaching.common.DateUtil;
import com.alex.coaching.model.User;
import com.alex.coaching.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.*;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, ModelAndView view){
        JSONObject returnObj = new JSONObject();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.selectByUserName(userName);
        if(user!=null){
            if(password.equals(user.getPassword())){
                request.getSession().setAttribute("user",user);
                returnObj.put("code",100);
                returnObj.put("data",user);
                //return returnObj;
            }
        }
        view.addObject(returnObj);
        return "/menu";
    }

    @ResponseBody
    @RequestMapping("/getInfo")
    public JSONObject getInfo(User user) {
        List<User> userList = userService.getAllUser(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",userList.size());
        jsonObject.put("data",userList.toArray());
        return jsonObject;
    }
}
