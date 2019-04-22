package com.aaa.project.system.gas.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.gasstatus.domain.Gasstatus;
import com.aaa.project.system.gasstatus.service.IGasstatusService;
import com.aaa.project.system.gastype.domain.Gastype;
import com.aaa.project.system.gastype.service.IGastypeService;
import com.aaa.project.system.lpolice.domain.Lpolice;
import com.aaa.project.system.lpolice.service.ILpoliceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 加油站 信息操作处理
 *
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/gas")
public class GasController extends BaseController {
    private String prefix = "system/gas";

    @Autowired
    private IGasService gasService;
    @Autowired
    private ILpoliceService lpoliceService;
    @Autowired
    private IGastypeService gastypeService;
    @Autowired
    private IGasstatusService gasstatusService;

    @RequiresPermissions("system:gas:view")
    @GetMapping()
    public String gas() {
        return prefix + "/gas";
    }

    /**
     * 查询加油站列表
     */
    @RequiresPermissions("system:gas:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Gas gas) {
        startPage();
        List<Gas> list = gasService.selectGasList(gas);
        return getDataTable(list);
    }


    /**
     * 导出加油站列表
     */
    @RequiresPermissions("system:gas:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Gas gas) {
        List<Gas> list = gasService.selectGasList(gas);
        ExcelUtil<Gas> util = new ExcelUtil<Gas>(Gas.class);
        return util.exportExcel(list, "gas");
    }

    /**
     * 新增加油站
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存加油站
     */
    @RequiresPermissions("system:gas:add")
    @Log(title = "加油站", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Gas gas) {
        return toAjax(gasService.insertGas(gas));
    }

    /**
     * 修改加油站
     */
    @GetMapping("/edit/{gasId}")
    public String edit(@PathVariable("gasId") Integer gasId, ModelMap mmap) {
        Gas gas = gasService.selectGasById(gasId);
        List<Lpolice> lpoliceList = lpoliceService.selectLpoliceList(new Lpolice());
        List<Gastype> gastypeList = gastypeService.selectGastypeList(new Gastype());
        List<Gasstatus> gasstatusList = gasstatusService.selectGasstatusList(new Gasstatus());
        mmap.put("gas", gas);
        mmap.put("lpoliceList", lpoliceList);
        mmap.put("gastypeList", gastypeList);
        mmap.put("gasstatusList", gasstatusList);
        return prefix + "/edit";
    }

    /**
     * 修改保存加油站
     */
    @RequiresPermissions("system:gas:edit")
    @Log(title = "加油站", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Gas gas) {
        return toAjax(gasService.updateGas(gas));
    }

    /**
     * 删除加油站
     */
    @RequiresPermissions("system:gas:remove")
    @Log(title = "加油站", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(gasService.deleteGasByIds(ids));
    }

}
