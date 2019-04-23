package com.aaa.project.system.policeproject.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.policeproject.domain.Policeproject;
import com.aaa.project.system.policeproject.service.IPoliceprojectService;
import com.aaa.project.system.projectkind.domain.Projectkind;
import com.aaa.project.system.projectkind.service.IProjectkindService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/policeproject")
public class PoliceprojectController extends BaseController
{
    private String prefix = "system/policeproject";
	
	@Autowired
	private IPoliceprojectService policeprojectService;
	@Autowired
	private IProjectkindService projectkindService;
	
	@RequiresPermissions("system:policeproject:view")
	@GetMapping()
	public String policeproject()
	{
	    return prefix + "/policeproject";
	}
	
	/**
	 * 查询项目列表
	 */
	@RequiresPermissions("system:policeproject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Policeproject policeproject)
	{
		startPage();
        List<Policeproject> list = policeprojectService.selectPoliceprojectList(policeproject);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出项目列表
	 */
	@RequiresPermissions("system:policeproject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Policeproject policeproject)
    {
    	List<Policeproject> list = policeprojectService.selectPoliceprojectList(policeproject);
        ExcelUtil<Policeproject> util = new ExcelUtil<Policeproject>(Policeproject.class);
        return util.exportExcel(list, "policeproject");
    }
	
	/**
	 * 新增项目
	 */
	@GetMapping("/add")
	public String add( ModelMap mmap)
	{
		List<Projectkind> projectkindList = projectkindService.selectProjectkindList(new Projectkind());
		mmap.put("projectkindList", projectkindList);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存项目
	 */
	@RequiresPermissions("system:policeproject:add")
	@Log(title = "项目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Policeproject policeproject)
	{		
		return toAjax(policeprojectService.insertPoliceproject(policeproject));
	}

	/**
	 * 修改项目
	 */
	@GetMapping("/edit/{projectId}")
	public String edit(@PathVariable("projectId") Integer projectId, ModelMap mmap)
	{
		Policeproject policeproject = policeprojectService.selectPoliceprojectById(projectId);
		List<Projectkind> projectkindList = projectkindService.selectProjectkindList(new Projectkind());
		mmap.put("projectkindList", projectkindList);
		mmap.put("policeproject", policeproject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存项目
	 */
	@RequiresPermissions("system:policeproject:edit")
	@Log(title = "项目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Policeproject policeproject)
	{		
		return toAjax(policeprojectService.updatePoliceproject(policeproject));
	}
	
	/**
	 * 删除项目
	 */
	@RequiresPermissions("system:policeproject:remove")
	@Log(title = "项目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(policeprojectService.deletePoliceprojectByIds(ids));
	}
	
}
