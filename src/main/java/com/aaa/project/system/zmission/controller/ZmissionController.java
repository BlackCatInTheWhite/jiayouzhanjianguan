package com.aaa.project.system.zmission.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
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
 * 巡查总任务分排 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-24
 */
@Controller
@RequestMapping("/system/zmission")
public class ZmissionController extends BaseController
{
    private String prefix = "system/zmission";
	
	@Autowired
	private IZmissionService zmissionService;
	@Autowired
	private IGasService gasService;
	@Autowired
	private IPolicemanService policemanService;
	
	@RequiresPermissions("system:zmission:view")
	@GetMapping()
	public String zmission()
	{
	    return prefix + "/zmission";
	}
	
	/**
	 * 查询巡查总任务分排列表
	 */
	@RequiresPermissions("system:zmission:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Zmission zmission, HttpSession session)
	{
		Policeman policeman = policemanService.selectPolicemanById((Integer) session.getAttribute("policemanid"));
		Gas gas=new Gas();
		gas.setLpoliceId(policeman.getLpoliceId());
		List<Gas> gases = gasService.selectGasList(gas);
		List<Integer> gasidlist=new ArrayList<>();
		for (Gas g:gases) {
			gasidlist.add(g.getGasId());
		}
		zmission.setGasidlist(gasidlist);
		startPage();
        List<Zmission> list = zmissionService.selectZmissionByLpolice(zmission);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出巡查总任务分排列表
	 */
	@RequiresPermissions("system:zmission:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Zmission zmission)
    {
    	List<Zmission> list = zmissionService.selectZmissionList(zmission);
        ExcelUtil<Zmission> util = new ExcelUtil<Zmission>(Zmission.class);
        return util.exportExcel(list, "zmission");
    }
	
	/**
	 * 新增巡查总任务分排
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		List<Gas> gasList = gasService.selectGasList(new Gas());
		List<Policeman> policemanList = policemanService.selectPolicemanList(new Policeman());
		mmap.put("gasList", gasList);
		mmap.put("policemanList", policemanList);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存巡查总任务分排
	 */
	@RequiresPermissions("system:zmission:add")
	@Log(title = "巡查总任务分排", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Zmission zmission)
	{		
		return toAjax(zmissionService.insertZmission(zmission));
	}

	/**
	 * 修改巡查总任务分排
	 */
	@GetMapping("/edit/{missionId}")
	public String edit(@PathVariable("missionId") Integer missionId, ModelMap mmap)
	{
		Zmission zmission = zmissionService.selectZmissionById(missionId);
		List<Gas> gasList = gasService.selectGasList(new Gas());
		List<Policeman> policemanList = policemanService.selectPolicemanList(new Policeman());
		mmap.put("gasList", gasList);
		mmap.put("policemanList", policemanList);
		mmap.put("zmission", zmission);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存巡查总任务分排
	 */
	@RequiresPermissions("system:zmission:edit")
	@Log(title = "巡查总任务分排", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Zmission zmission)
	{		
		return toAjax(zmissionService.updateZmission(zmission));
	}
	
	/**
	 * 删除巡查总任务分排
	 */
	@RequiresPermissions("system:zmission:remove")
	@Log(title = "巡查总任务分排", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(zmissionService.deleteZmissionByIds(ids));
	}
	
}
