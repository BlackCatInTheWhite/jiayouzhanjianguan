package com.aaa.project.system.gasmission.controller;

import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.gasstatus.service.IGasstatusService;
import com.aaa.project.system.gastype.service.IGastypeService;
import com.aaa.project.system.lpolice.service.ILpoliceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private ILpoliceService lpoliceService;
    @Autowired
    private IGastypeService gastypeService;
    @Autowired
    private IGasstatusService gasstatusService;

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
    public TableDataInfo list(Gas gas) {
        gas.setGasstatusId(1);
        startPage();
        List<Gas> list = gasService.selectGasList(gas);
        return getDataTable(list);
    }

    /**
     * 确认审核加油站
     */
    @RequiresPermissions("system:gasmission:mission")
    @Log(title = "加油站", businessType = BusinessType.DELETE)
    @PostMapping("/mission")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(gasService.deleteGasByIds(ids));
    }

}
