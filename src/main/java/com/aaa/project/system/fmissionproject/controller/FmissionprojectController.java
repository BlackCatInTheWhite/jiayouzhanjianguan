package com.aaa.project.system.fmissionproject.controller;

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
import com.aaa.project.system.fmissionproject.domain.Fmissionproject;
import com.aaa.project.system.fmissionproject.service.IFmissionprojectService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 项目记录 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/fmissionproject")
public class FmissionprojectController extends BaseController
{
    private String prefix = "system/fmissionproject";
	
	@Autowired
	private IFmissionprojectService fmissionprojectService;
	
	@RequiresPermissions("system:fmissionproject:view")
	@GetMapping()
	public String fmissionproject()
	{
	    return prefix + "/fmissionproject";
	}
	
	/**
	 * 查询项目记录列表
	 */
	@RequiresPermissions("system:fmissionproject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Fmissionproject fmissionproject)
	{
		startPage();
        List<Fmissionproject> list = fmissionprojectService.selectFmissionprojectList(fmissionproject);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出项目记录列表
	 */
	@RequiresPermissions("system:fmissionproject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fmissionproject fmissionproject)
    {
    	List<Fmissionproject> list = fmissionprojectService.selectFmissionprojectList(fmissionproject);
        ExcelUtil<Fmissionproject> util = new ExcelUtil<Fmissionproject>(Fmissionproject.class);
        return util.exportExcel(list, "fmissionproject");
    }
	
	/**
	 * 新增项目记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存项目记录
	 */
	@RequiresPermissions("system:fmissionproject:add")
	@Log(title = "项目记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Fmissionproject fmissionproject)
	{		
		return toAjax(fmissionprojectService.insertFmissionproject(fmissionproject));
	}

	/**
	 * 修改项目记录
	 */
	@GetMapping("/edit/{projectMissionid}")
	public String edit(@PathVariable("projectMissionid") Integer projectMissionid, ModelMap mmap)
	{
		Fmissionproject fmissionproject = fmissionprojectService.selectFmissionprojectById(projectMissionid);
		mmap.put("fmissionproject", fmissionproject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存项目记录
	 */
	@RequiresPermissions("system:fmissionproject:edit")
	@Log(title = "项目记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Fmissionproject fmissionproject)
	{		
		return toAjax(fmissionprojectService.updateFmissionproject(fmissionproject));
	}
	
	/**
	 * 删除项目记录
	 */
	@RequiresPermissions("system:fmissionproject:remove")
	@Log(title = "项目记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fmissionprojectService.deleteFmissionprojectByIds(ids));
	}
	
}
