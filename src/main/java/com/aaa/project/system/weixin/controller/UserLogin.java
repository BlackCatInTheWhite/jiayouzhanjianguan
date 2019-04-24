package com.aaa.project.system.weixin.controller;

import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private IGasService igasservice;

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
        Policeman policeman = ipoliceman.selectJYZByPolicemanId(polic.getPolicemanId());
        List<Gas> list=policeman.getGas();
        if(list.size()>0){
            System.out.println(list);
            return list;
        }
        else {
            return null;
        }
    }
    /**
     * 获取所有加油站列表
     */
    @RequestMapping("/allgas")
    @ResponseBody
    public Map allgas(HttpServletRequest request, HttpServletResponse response){
        Gas gas = new Gas();
        List<Gas> list = igasservice.selectGasList(gas);
        Map mapAll=new HashMap<String,Map>();
        for (int i = 0; i < list.size(); i++) {
            Map map=new HashMap<String,String>();
            map.put("id",list.get(i).getGasId());
            map.put("gasName",list.get(i).getGasName());
            map.put("gasAddress",list.get(i).getGasAddress());
            mapAll.put("gas"+i,map);
        }
        return mapAll;
    }
    /**
     * 获取用户分配的任务
     */
    @RequestMapping("/history")
    @ResponseBody
    public List<Gas> history(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        Integer userid=Integer.valueOf(request.getParameter("userid"));
        String address=request.getParameter("address");
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format0.parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Policeman policeman = ipoliceman.selectPolicemanJYZById(userid,address,date);

        //List<Gas> list=policeman.getGas();
        if(policeman!=null){
            return policeman.getGas();
        }
        else {
            return null;
        }
    }
    /**
     * 获取用户所有历史任务
     */
    @RequestMapping("/allhistory")
    @ResponseBody
    public List<Gas> allhistory(HttpServletRequest request,HttpServletResponse response){
        Integer userid=Integer.valueOf(request.getParameter("userid"));
        return null;
    }
}
