package com.aaa.project.system.gasman.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.myconst.ServerConst;
import com.aaa.project.system.area.domain.Area;
import com.aaa.project.system.area.service.IAreaService;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.gasman.domain.Gasman;
import com.aaa.project.system.gasman.service.IGasmanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 加油站员工 信息操作处理
 *
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/gasman")
public class GasmanController extends BaseController {
    private String prefix = "system/gasman";

    @Autowired
    private IGasmanService gasmanService;
    @Autowired
    private IAreaService areaService;
    @Autowired
    private IGasService gasService;

    @RequiresPermissions("system:gasman:view")
    @GetMapping()
    public String gasman() {
        return prefix + "/gasman";
    }

    @RequiresPermissions("system:gasman:view")
    @GetMapping("/{gasid}")
    public String togasman(@PathVariable("gasid") Integer gasId,ModelMap mmap) {
        mmap.put("haveGasId",gasId);
        return prefix + "/gasman";
    }

    /**
     * 查询加油站员工列表
     */
    @RequiresPermissions("system:gasman:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Gasman gasman,HttpSession session) {
        startPage();
        List<Gasman> list = gasmanService.selectGasmanList(gasman);
        return getDataTable(list);
    }


    /**
     * 导出加油站员工列表
     */
    @RequiresPermissions("system:gasman:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Gasman gasman) {
        List<Gasman> list = gasmanService.selectGasmanList(gasman);
        ExcelUtil<Gasman> util = new ExcelUtil<Gasman>(Gasman.class);
        return util.exportExcel(list, "gasman");
    }

    /**
     * 新增加油站员工
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        List<Area> areaList = areaService.selectAreaList(new Area());
        List<Gas> gasList = gasService.selectGasList(new Gas());
        mmap.put("areaList", areaList);
        mmap.put("gasList", gasList);
        return "system/gasmanmanager/add";
    }

    /**
     * 新增保存加油站员工
     */
    @RequiresPermissions("system:gasman:add")
    @Log(title = "加油站员工", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Gasman gasman, HttpSession session) {
        if (gasman.getGasId()==null){
            gasman.setGasId((Integer)session.getAttribute(ServerConst.GAS_ID));
        }
        Gas gas = gasService.selectGasById(gasman.getGasId());
        gas.setStaffNumber(gas.getStaffNumber()+1);
        gasService.updateGas(gas);
        return toAjax(gasmanService.insertGasman(gasman));
    }

    /**
     * 修改加油站员工
     */
    @GetMapping("/edit/{gasmanId}")
    public String edit(@PathVariable("gasmanId") Integer gasmanId, ModelMap mmap) {
        Gasman gasman = gasmanService.selectGasmanById(gasmanId);
        List<Area> areaList = areaService.selectAreaList(new Area());
        List<Gas> gasList = gasService.selectGasList(new Gas());
        mmap.put("areaList", areaList);
        mmap.put("gasList", gasList);
        mmap.put("gasman", gasman);
        return "system/gasmanmanager/edit";
    }

    /**
     * 修改保存加油站员工
     */
    @RequiresPermissions("system:gasman:edit")
    @Log(title = "加油站员工", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Gasman gasman) {
        return toAjax(gasmanService.updateGasman(gasman));
    }

    /**
     * 删除加油站员工
     */
    @RequiresPermissions("system:gasman:remove")
    @Log(title = "加油站员工", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        Gas gas = gasService.selectGasById(gasmanService.selectGasmanById(Integer.parseInt(ids)).getGasId());
        gas.setStaffNumber(gas.getStaffNumber()-1);
        gasService.updateGas(gas);
        return toAjax(gasmanService.deleteGasmanByIds(ids));
    }

}
