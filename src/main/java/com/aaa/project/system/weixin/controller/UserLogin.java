package com.aaa.project.system.weixin.controller;

import com.aaa.project.system.fmission.domain.Fmission;
import com.aaa.project.system.fmission.service.IFmissionService;
import com.aaa.project.system.fmissionproject.domain.Fmissionproject;
import com.aaa.project.system.fmissionproject.service.IFmissionprojectService;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import com.aaa.project.system.policeproject.domain.Policeproject;
import com.aaa.project.system.policeproject.service.IPoliceprojectService;
import com.aaa.project.system.weixin.domain.HistoryList;
import com.aaa.project.system.zmission.domain.Zmission;
import com.aaa.project.system.zmission.service.IZmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private IPoliceprojectService policeprojectService;
    @Autowired
    private IFmissionService ifimission;
    @Autowired
    private IPoliceprojectService policeproject;
    @Autowired
    private IFmissionprojectService iFmissionService;

    @Autowired
    private IZmissionService zmissionService;
    private Policeman polic;

    /**
     * 获取登录用户信息
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/wxlogin")
    @ResponseBody
    public Policeman login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        response.setContentType("text/html;charset=utf-8");
        /** 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /** 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Policeman policeman = new Policeman();
        policeman.setPolicemanPhone(username);
        policeman.setPolicemanPassword(password);
        Policeman policemen = ipoliceman.selectByLogin(policeman);
        polic = policemen;
        session.setAttribute("policemen", policemen);
        if (policemen != null) {
            return policemen;
        } else {
            return null;
        }
    }

    /**
     * 获取用户分配的任务
     */
    @RequestMapping("/tasks")
    @ResponseBody
    public List<Gas> tasks(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Policeman policeman = ipoliceman.selectJYZByPolicemanId(polic.getPolicemanId());
        List<Gas> list = policeman.getGas();
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    /**
     * 获取所有加油站列表
     */
    @RequestMapping("/allgas")
    @ResponseBody
    public Map allgas(HttpServletRequest request, HttpServletResponse response) {
        Integer userid = Integer.parseInt(request.getParameter("userid"));
        List<Gas> list = igasservice.selectArrayGas(userid);
        Map mapAll = new HashMap<String, Map>();
        for (int i = 0; i < list.size(); i++) {
            Map map = new HashMap<String, String>();
            map.put("id", list.get(i).getGasId());
            map.put("gasName", list.get(i).getGasName());
            map.put("gasAddress", list.get(i).getGasAddress());
            mapAll.put("gas" + i, map);
        }
        return mapAll;
    }

    /**
     * 获取用户分配的任务
     */
    @RequestMapping("/history")
    @ResponseBody
    public List<HistoryList> history(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Integer userid = Integer.valueOf(request.getParameter("userid"));
        String address = request.getParameter("address");
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd");
        String date = request.getParameter("date");
        List<HistoryList> historyLists = ifimission.HistoryList(userid, address, date);
        System.out.println(historyLists);
        if (historyLists.size() > 0) {
            return historyLists;
        } else {
            return null;
        }
    }

    /**
     * 获取用户所有历史任务
     */
    @RequestMapping("/allhistory")
    @ResponseBody
    public List allhistory(HttpServletRequest request, HttpServletResponse response) {
        Integer userid = Integer.valueOf(request.getParameter("userid"));

        Policeman policeman = ipoliceman.selectPolicemanById(userid);
        List<HistoryList> historyLists = ifimission.selectHistory(userid);

        //List<Gas> list=policeman.getGas();
        if (policeman != null) {
            return historyLists;
        } else {
            return null;
        }

    }

    /**
     * 获取加油站审查规范
     */
    @RequestMapping("/guifan")
    @ResponseBody
    public Map allguifan(HttpServletRequest request, HttpServletResponse response) {
        List<Policeproject> list = policeprojectService.selectProjectGuiFan();
        Map map = new HashMap<String, String>();
        List<String> listKey = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            listKey.add(list.get(i).getProjectKind());
        }
        for (int i = 0; i < listKey.size(); i++) {
            List listValue = new ArrayList();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getProjectKind().equals(listKey.get(i))) {
                    listValue.add(list.get(j).getProjectName() + "(" + list.get(j).getPoint() + "分)");
                }
            }
            map.put(listKey.get(i), listValue);
        }

        return map;
    }

    /**
     * 获取用户分配的任务
     */
    @RequestMapping("/fmission")
    @ResponseBody
    public Integer fmission(HttpServletRequest request,HttpServletResponse response){
        Integer s=Integer.parseInt(request.getParameter("zmission"));
        Integer i = ifimission.selectLast(s);
        if(i!=null){
            return i*-1;
        }else {
            Date date = ifimission.selectLastTime(s);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //System.out.println("任务上次记录时间"+date);
            if (date == null) {
                Date nowtime = new Date(System.currentTimeMillis());
                //找到开始时间
                Date startDate = ifimission.selectStartTime(s);
                long day = ((nowtime.getTime() - startDate.getTime()));
                //System.out.println("当前时间减去任务开始时间"+day);
                if (day > 0) {

                    String current = sdf.format(nowtime);
                    Fmission fmission = new Fmission();
                    fmission.setFmissionCommit(nowtime);
                    fmission.setZmissionId(s);
                    ifimission.insertFmission(fmission);
                    //返回分任务id
                    return fmission.getFmissionId();
                } else {
                    return -1;
                }
            } else {
                Date time = new Date(System.currentTimeMillis());
                long day = ((time.getTime() - date.getTime()) / (1000 * 3600 * 24));

                int pinci = ifimission.selectPinCi(s);
                if (day < (30 / pinci)) {
                    return -1;
                } else {
                    //消除警告
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String current = sdf1.format(time);
                    Fmission fmission = new Fmission();
                    fmission.setFmissionCommit(time);
                    fmission.setZmissionId(s);
                    ifimission.insertFmission(fmission);
                    //返回分任务id
                    return fmission.getFmissionId();
                }
            }
        }
    }

    /**
     * 获取用户分配的任务
     */
    @RequestMapping("/getPoint")
    @ResponseBody
    public Integer getPoint(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Integer fmissionid = Integer.parseInt(request.getParameter("fmissionid"));
        Fmission fmission1 = ifimission.selectFmissionById(fmissionid);

        List<Integer> point = policeproject.getPoint(fmissionid);

        Integer result = 100;
        for (int i = 0; i < point.size(); i++) {
            result -= point.get(i);
        }
        //工作人员添加的项目条数
        int i = iFmissionService.selectCount(fmissionid);

        //所有项目条数
        int j = policeprojectService.selectProjectCount();

        if (i < j) {
            return 0;
        } else {
            Fmission fmission = fmission1;
            fmission.setPoint(result);
            if (result >= 60) {
                fmission.setFmissionState(1);
                ifimission.updateFmission(fmission);
            } else {
                fmission.setFmissionState(2);
                ifimission.updateFmission(fmission);
            }
            Zmission zmission = zmissionService.selectZmissionById(fmission.getZmissionId());
            zmission.setMissionLeft(zmission.getMissionLeft() - 1);
            Date time = new Date();
            zmission.setMissionLastcommit(time);
            System.out.println("获取到的任务" + zmission);
            zmissionService.updateZmission(zmission);
            return result;
        }
    }

    /**
     * 项目具体信息
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/showProject")
    @ResponseBody
    public Fmissionproject showproject(HttpServletRequest request, HttpServletResponse response) {
        Integer fmissionid = Integer.parseInt(request.getParameter("fmissionid"));
        Integer projectid = Integer.parseInt(request.getParameter("projectid"));
        Fmissionproject fmissionproject = new Fmissionproject();
        fmissionproject.setProjectId(projectid);
        fmissionproject.setFmissionId(fmissionid);

        Fmissionproject result = iFmissionService.selectProject(fmissionproject);

        return result;
    }

    /**
     * 获取任务信息
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/showTask")
    @ResponseBody
    public Zmission showTask(HttpServletRequest request, HttpServletResponse response) {
        Integer missionid = Integer.parseInt(request.getParameter("missionid"));
        Zmission zmission = zmissionService.selectZmissionById(missionid);
        return zmission;
    }
}