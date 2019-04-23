package com.aaa.project.system.missionproject.controller;

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
import com.aaa.project.system.missionproject.domain.Missionproject;
import com.aaa.project.system.missionproject.service.IMissionprojectService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 巡查项目 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/missionproject")
public class MissionprojectController extends BaseController
{
    private String prefix = "system/missionproject";
	
	@Autowired
	private IMissionprojectService missionprojectService;
	
	@RequiresPermissions("system:missionproject:view")
	@GetMapping()
	public String missionproject()
	{
	    return prefix + "/missionproject";
	}
	
	/**
	 * 查询巡查项目列表
	 */
	@RequiresPermissions("system:missionproject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Missionproject missionproject)
	{
		startPage();
        List<Missionproject> list = missionprojectService.selectMissionprojectList(missionproject);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出巡查项目列表
	 */
	@RequiresPermissions("system:missionproject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Missionproject missionproject)
    {
    	List<Missionproject> list = missionprojectService.selectMissionprojectList(missionproject);
        ExcelUtil<Missionproject> util = new ExcelUtil<Missionproject>(Missionproject.class);
        return util.exportExcel(list, "missionproject");
    }
	
	/**
	 * 新增巡查项目
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存巡查项目
	 */
	@RequiresPermissions("system:missionproject:add")
	@Log(title = "巡查项目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Missionproject missionproject)
	{		
		return toAjax(missionprojectService.insertMissionproject(missionproject));
	}

	/**
	 * 修改巡查项目
	 */
	@GetMapping("/edit/{missionId}")
	public String edit(@PathVariable("missionId") Integer missionId, ModelMap mmap)
	{
		Missionproject missionproject = missionprojectService.selectMissionprojectById(missionId);
		mmap.put("missionproject", missionproject);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存巡查项目
	 */
	@RequiresPermissions("system:missionproject:edit")
	@Log(title = "巡查项目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Missionproject missionproject)
	{		
		return toAjax(missionprojectService.updateMissionproject(missionproject));
	}
	
	/**
	 * 删除巡查项目
	 */
	@RequiresPermissions("system:missionproject:remove")
	@Log(title = "巡查项目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(missionprojectService.deleteMissionprojectByIds(ids));
	}
	
}
