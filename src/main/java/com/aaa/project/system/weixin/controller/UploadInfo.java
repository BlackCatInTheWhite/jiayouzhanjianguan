package com.aaa.project.system.weixin.controller;

import com.aaa.common.utils.file.FileUploadUtils;
import com.aaa.project.system.fmissionproject.domain.Fmissionproject;
import com.aaa.project.system.fmissionproject.service.IFmissionprojectService;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeproject.domain.Policeproject;
import com.aaa.project.system.policeproject.service.IPoliceprojectService;
import com.aaa.project.system.projectkind.domain.Projectkind;
import com.aaa.project.system.projectkind.service.IProjectkindService;
import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.wiring.BeanWiringInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/uploadInfo")
public class UploadInfo {
    @Autowired
    private IProjectkindService projectkindService;
    @Autowired
    private IPoliceprojectService policeprojectService;
    @Autowired
    private IFmissionprojectService fmissionprojectService;

    /**
     * @param file    后台上传的图片文件
     * @param request 请求，储存表单信息
     * @return
     */
    @RequestMapping("/uploadForm")
    @ResponseBody
    public String uploadImg(@RequestParam(value = "form", required = true) MultipartFile file, HttpServletRequest request) {
        Fmissionproject fmissionproject = new Fmissionproject();
        String pictureSrc = "";
        if (!file.isEmpty()) {
            int indexOf = file.getOriginalFilename().lastIndexOf(".");
            System.out.println(file.getOriginalFilename());
            String substring = file.getOriginalFilename().substring(indexOf);
            String filepath = "E:\\test\\tt\\";
            try {
                pictureSrc = "/profile/" + FileUploadUtils.upload(filepath, file, substring);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String radio = request.getParameter("radio");
        Integer state = 1;//1代表未通过 2代表通过
        if (radio.equals("radio2")) {
            state = 2;
        }
        String topic = request.getParameter("topic");
        System.out.println(request.getParameter("fmissionId"));
        Integer fmissionId = Integer.parseInt(request.getParameter("fmissionId"));
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));

        fmissionproject.setFmissionId(fmissionId);
        fmissionproject.setProjectId(projectId);
        Fmissionproject fmissionprojectnew = fmissionprojectService.selectByFmissionIdAndProjectID(fmissionproject);
        if (fmissionprojectnew == null) {
            System.out.println("insert");
            System.out.println(fmissionprojectnew);
            fmissionproject.setProjectState(state);
            fmissionproject.setProjectPicturesrc(pictureSrc);
            fmissionproject.setProjectDescribe(topic);
            fmissionprojectService.insertFmissionproject(fmissionproject);
        } else {
            System.out.println("update");
            fmissionprojectnew.setProjectState(state);
            fmissionprojectnew.setProjectPicturesrc(pictureSrc);
            fmissionprojectnew.setProjectDescribe(topic);
            fmissionprojectService.updateFmissionproject(fmissionprojectnew);
        }
        return "上传完毕";
    }

    @RequestMapping("/uploadFormNoImg")
    @ResponseBody
    public String uploadImg(HttpServletRequest request) {
        String radio = request.getParameter("radio");
        Integer state = 1;//1代表未通过 2代表通过
        if (radio.equals("radio2")) {
            state = 2;
        }
        String topic = request.getParameter("topic");
        System.out.println(request.getParameter("fmissionId"));
        Integer fmissionId = Integer.parseInt(request.getParameter("fmissionId"));
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));
        Fmissionproject fmissionproject = new Fmissionproject();
        fmissionproject.setFmissionId(fmissionId);
        fmissionproject.setProjectId(projectId);
        Fmissionproject fmissionprojectnew = fmissionprojectService.selectByFmissionIdAndProjectID(fmissionproject);
        if (fmissionprojectnew == null) {
            System.out.println(fmissionproject);
            fmissionproject.setProjectState(state);
            fmissionproject.setProjectDescribe(topic);
            fmissionprojectService.insertFmissionproject(fmissionproject);
        } else {
            System.out.println(fmissionprojectnew);
            fmissionprojectnew.setProjectState(state);
            fmissionprojectnew.setProjectDescribe(topic);
            fmissionprojectService.updateFmissionproject(fmissionprojectnew);
        }
        return "提交成功";
    }

    @RequestMapping("/getProjectKind")
    @ResponseBody
    public List<Projectkind> getProjectkind(HttpServletRequest request) {
        List<Projectkind> list = projectkindService.selectProjectkindList(new Projectkind());
        System.out.println(list.size());
        return list;
    }

    @RequestMapping("/getProjectList")
    @ResponseBody
    public List<Policeproject> getProjectList(@RequestParam(value = "projectKindId") String kindId, HttpServletRequest request) {

        Integer projectkindId = Integer.parseInt(kindId);
        Policeproject policeproject = new Policeproject();
        policeproject.setProjectKindid(projectkindId);
        List<Policeproject> list = policeprojectService.selectPoliceprojectList(policeproject);
        return list;
    }
}