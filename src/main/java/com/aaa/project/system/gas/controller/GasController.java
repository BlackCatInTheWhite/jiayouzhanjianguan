package com.aaa.project.system.gas.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.buyoilform.domain.Buyoilform;
import com.aaa.project.system.buyoilform.service.IBuyoilformService;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.gasman.domain.Gasman;
import com.aaa.project.system.gasman.service.IGasmanService;
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

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private IGasmanService gasmanService;
    @Autowired
    private IBuyoilformService buyoilformService;

    @RequestMapping("/sign")
    public String sign(HttpServletRequest req,Lpolice lpolice){
        List<Lpolice> lpoliceList = lpoliceService.selectLpoliceList(lpolice);
        req.setAttribute("lpoliceList",lpoliceList);
        //System.out.println(lpoliceList);
        return "system/sign/sign";
    }
    @RequestMapping("/signsave")
    public String signSave(HttpServletRequest req,Gas gas){
        gasService.insertGas(gas);
        System.out.println(gas);
        return "system/login";
    }

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
    public String add(ModelMap mmap) {
        List<Lpolice> lpoliceList = lpoliceService.selectLpoliceList(new Lpolice());
        List<Gastype> gastypeList = gastypeService.selectGastypeList(new Gastype());
        List<Gasstatus> gasstatusList = gasstatusService.selectGasstatusList(new Gasstatus());
        mmap.put("lpoliceList", lpoliceList);
        mmap.put("gastypeList", gastypeList);
        mmap.put("gasstatusList", gasstatusList);
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

    /**
     * 员工管理
     */
    @RequiresPermissions("system:gas:gasman")
    @GetMapping("/gasman")
    public String gasman(@RequestParam("gasid") Integer gasid,ModelMap mmap) {
        mmap.put("gasid", gasid);
        return prefix + "/togasman";
    }
    /**
     * 员工填充
     */
    @PostMapping("/gasman/list/{gasid}")
    @ResponseBody
    public TableDataInfo gasmanlist(@PathVariable(name = "gasid") Integer gasid,Gasman gasman) {
        gasman.setGasId(gasid);
        startPage();
        List<Gasman> list = gasmanService.selectGasmanList(gasman);
        return getDataTable(list);
    }
    /**
     * 散装油管理
     */
    @RequiresPermissions("system:gas:oil")
    @GetMapping("/oil")
    public String oil(@RequestParam("gasid") Integer gasid,ModelMap mmap) {
        mmap.put("gasid", gasid);
        return prefix + "/tooil";
    }
    /**
     * 散装油填充
     */
    @PostMapping("/oil/list/{gasid}")
    @ResponseBody
    public TableDataInfo oillist(@PathVariable(name = "gasid") Integer gasid, Buyoilform buyoilform) {
        buyoilform.setGasId(gasid);
        startPage();
        List<Buyoilform> list = buyoilformService.selectBuyoilformList(buyoilform);
        return getDataTable(list);
    }
}
