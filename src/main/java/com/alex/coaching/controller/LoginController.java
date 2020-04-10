package com.alex.coaching.controller;

import com.alex.coaching.model.User;
import com.alex.coaching.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    /**
     * 设置默认打开地址http://localhost:8001的跳转(需要在拦截器中排除)
     * 1.已登录，跳转到menu.html，把adminUserInfo返回前端渲染
     * 2.未登录，跳转到登录页
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(HttpServletRequest request, ModelMap modelMap){
        HttpSession session = request.getSession();
        User adminUserInfo = (User) session.getAttribute("adminUser");
        if(null != adminUserInfo){
            modelMap.addAttribute("adminUserInfo",adminUserInfo);
            return "/menu";
        }else{
            return "/index";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JSONObject login(HttpServletRequest request, ModelMap modelMap){
        JSONObject returnObj = new JSONObject();
        returnObj.put("code",-100);
        returnObj.put("msg","登陆失败");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.selectByUserName(userName);
        if(user!=null){
            if(password.equals(user.getPassword())){
                request.getSession().setAttribute("adminUser",user);
                returnObj.put("code",0);
                returnObj.put("msg","登陆成功");
                System.out.println(request.getRequestURL()+"......登陆成功..........");
                modelMap.addAttribute(returnObj);
            }else{
                returnObj.put("code",-102);
                returnObj.put("msg","密码不正确");
                System.out.println(request.getRequestURL()+"......登陆用户密码不正确..........");
            }
        }else{
            returnObj.put("code",-101);
            returnObj.put("msg","用户不存在");
            System.out.println(request.getRequestURL()+"......登陆用户不存在..........");
        }
        return returnObj;
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
