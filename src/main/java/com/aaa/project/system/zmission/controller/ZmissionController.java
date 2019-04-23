package com.aaa.project.system.zmission.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.zmission.domain.Zmission;
import com.aaa.project.system.zmission.service.IZmissionService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 巡查总任务分排 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/zmission")
public class ZmissionController extends BaseController
{
    private String prefix = "system/zmission";
	
	@Autowired
	private IZmissionService zmissionService;
	
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
	public TableDataInfo list(Zmission zmission)
	{
		startPage();
        List<Zmission> list = zmissionService.selectZmissionList(zmission);
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
	public String add()
	{
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
