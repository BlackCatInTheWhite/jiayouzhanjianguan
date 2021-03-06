package com.aaa.project.system.gasmission.controller;

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
import java.util.ArrayList;
import java.util.List;

/**
 * 加油站巡检审核 信息操作处理
 *
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/gasmission")
public class GasmissionController extends BaseController {
    private String prefix = "system/gasmission";

    @Autowired
    private IGasService gasService;
    @Autowired
    private IPolicemanService policemanService;
    @Autowired
    private IZmissionService zmissionService;

    @RequiresPermissions("system:gasmission:view")
    @GetMapping()
    public String gas() {
        return prefix + "/gasmission";
    }

    /**
     * 查询加油站列表
     */
    @RequiresPermissions("system:gasmission:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Gas gas, HttpSession session) {
        gas.setLpoliceId(policemanService.selectPolicemanById((Integer) session.getAttribute(ServerConst.POLICEMAN_ID)).getLpoliceId());
        List<Integer> gasList=new ArrayList<>();
        gasList.add(ServerConst.GASSTATE_NORMAL);
        gasList.add(ServerConst.GASSTATE_RECTIFICATION);
        gas.setGasList(gasList);
        startPage();
        List<Gas> list = gasService.selectGasMission(gas);
        return getDataTable(list);
    }

    /**
     * 确认巡检
     */
    @GetMapping("/mission/{id}")
    public String mission(@PathVariable("id") Integer gasId, ModelMap mmap) {
        Gas gas = gasService.selectGasById(gasId);
        List<Policeman> policemanList = policemanService.selectPolicemanList(new Policeman());
        mmap.put("gas", gas);
        mmap.put("policemanList", policemanList);
        return prefix + "/mission";
    }
    /**
     * 确认巡检加油站
     */
    @RequiresPermissions("system:gasmission:mission")
    @PostMapping("/mission")
    @ResponseBody
    public AjaxResult agreeSave(Zmission zmission) {
        zmission.setMissionLeft(zmission.getMissionTimes());
        Gas gas = gasService.selectGasById(zmission.getGasId());
        gas.setGasstatusId(ServerConst.GASSTATE_MISSION);
        gasService.updateGas(gas);
        return toAjax(zmissionService.insertZmission(zmission));
    }

}
