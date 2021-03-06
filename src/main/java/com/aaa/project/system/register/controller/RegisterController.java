package com.aaa.project.system.register.controller;

import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.myconst.ServerConst;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import com.aaa.project.system.zmission.domain.Zmission;
import com.aaa.project.system.zmission.service.IZmissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 加油站注册审核 信息操作处理
 *
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/register")
public class RegisterController extends BaseController {
    private String prefix = "system/register";

    @Autowired
    private IGasService gasService;
    @Autowired
    private IPolicemanService policemanService;
    @Autowired
    private IZmissionService zmissionService;

    @RequiresPermissions("system:register:view")
    @GetMapping()
    public String gas() {
        return prefix + "/register";
    }

    /**
     * 查询加油站列表
     */
    @RequiresPermissions("system:register:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Gas gas, HttpSession session) {
        gas.setLpoliceId(policemanService.selectPolicemanById((Integer) session.getAttribute(ServerConst.POLICEMAN_ID)).getLpoliceId());
        gas.setGasstatusId(ServerConst.GASSTATE_NOREGISTER);
        startPage();
        List<Gas> list = gasService.selectGasList(gas);
        return getDataTable(list);
    }
    /**
     * 确认审批
     */
    @GetMapping("/agree/{id}")
    public String agree(@PathVariable("id") Integer gasId, ModelMap mmap) {
        Gas gas = gasService.selectGasById(gasId);
        List<Policeman> policemanList = policemanService.selectPolicemanList(new Policeman());
        mmap.put("gas", gas);
        mmap.put("policemanList", policemanList);
        return prefix + "/agree";
    }
    /**
     * 确认审核加油站
     */
    @RequiresPermissions("system:register:agree")
    @PostMapping("/agree")
    @ResponseBody
    public AjaxResult agreeSave(Zmission zmission) {
        Gas gas = gasService.selectGasById(zmission.getGasId());
        gas.setGasstatusId(ServerConst.GASSTATE_MISSION);
        gasService.updateGas(gas);
        Date missionBegin = zmission.getMissionBegin();
        Calendar no = Calendar.getInstance();
        no.setTime(missionBegin);
        no.set(Calendar.DATE, no.get(Calendar.DATE) + 7);
        zmission.setMissionEnd(no.getTime());
        zmission.setMissionTimes(ServerConst.ZMISSION_INTERVAL);
        zmission.setMissionLeft(ServerConst.ZMISSION_INTERVAL);
        return toAjax(zmissionService.insertZmission(zmission));
    }

}
