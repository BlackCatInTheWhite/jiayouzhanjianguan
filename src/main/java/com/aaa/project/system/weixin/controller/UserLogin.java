package com.aaa.project.system.weixin.controller;

import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 张益达
 * @create 2019-04-22 20:28
 * @desprint 这个代码好
 */
@Controller
@RequestMapping("/wx")
public class UserLogin {
    @Autowired
    private IPolicemanService ipoliceman;

    private Policeman polic;
    /**
     *  获取登录用户信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/wxlogin")
    @ResponseBody
    public Policeman login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        response.setContentType("text/html;charset=utf-8");
        /** 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /** 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Policeman policeman=new Policeman();
        policeman.setPolicemanPhone(username);
        policeman.setPolicemanPassword(password);
        Policeman policemen = ipoliceman.selectByLogin(policeman);
        polic =policemen;
        session.setAttribute("policemen",policemen);
        System.out.println(session.getAttribute("policemen"));
        if(policemen!=null){
        return policemen;}
        else {
            return null;
        }
    }
    /**
     * 获取用户分配的任务
     */
    @RequestMapping("/tasks")
    @ResponseBody
    public List<Gas> tasks(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        System.out.println(polic);
        Policeman policeman = ipoliceman.selectJYZByPolicemanId(polic.getPolicemanId());
        List<Gas> list=policeman.getGas();
        System.out.println(list);
        return list;
    }
}
