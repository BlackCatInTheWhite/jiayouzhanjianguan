package com.aaa.project.system.fmission.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.fmission.domain.Fmission;
import com.aaa.project.system.fmission.service.IFmissionService;
import com.aaa.project.system.missionstate.domain.Missionstate;
import com.aaa.project.system.missionstate.service.IMissionstateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分任务记录 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/fmission")
public class FmissionController extends BaseController
{
    private String prefix = "system/fmission";
	
	@Autowired
	private IFmissionService fmissionService;
	@Autowired
	private IMissionstateService missionstateService;

	@RequiresPermissions("system:fmission:view")
	@GetMapping()
	public String fmission()
	{
	    return prefix + "/fmission";
	}
	
	/**
	 * 查询分任务记录列表
	 */
	@RequiresPermissions("system:fmission:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Fmission fmission)
	{
		startPage();
        List<Fmission> list = fmissionService.selectFmissionList(fmission);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出分任务记录列表
	 */
	@RequiresPermissions("system:fmission:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fmission fmission)
    {
    	List<Fmission> list = fmissionService.selectFmissionList(fmission);
        ExcelUtil<Fmission> util = new ExcelUtil<Fmission>(Fmission.class);
        return util.exportExcel(list, "fmission");
    }
	
	/**
	 * 新增分任务记录
	 */
	@GetMapping("/add")
	public String add( ModelMap mmap)
	{
		List<Missionstate> missionstateList = missionstateService.selectMissionstateList(new Missionstate());
		mmap.put("missionstateList", missionstateList);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存分任务记录
	 */
	@RequiresPermissions("system:fmission:add")
	@Log(title = "分任务记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Fmission fmission)
	{		
		return toAjax(fmissionService.insertFmission(fmission));
	}

	/**
	 * 修改分任务记录
	 */
	@GetMapping("/edit/{fmissionId}")
	public String edit(@PathVariable("fmissionId") Integer fmissionId, ModelMap mmap)
	{
		Fmission fmission = fmissionService.selectFmissionById(fmissionId);
		List<Missionstate> missionstateList = missionstateService.selectMissionstateList(new Missionstate());
		mmap.put("missionstateList", missionstateList);
		mmap.put("fmission", fmission);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存分任务记录
	 */
	@RequiresPermissions("system:fmission:edit")
	@Log(title = "分任务记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Fmission fmission)
	{		
		return toAjax(fmissionService.updateFmission(fmission));
	}
	
	/**
	 * 删除分任务记录
	 */
	@RequiresPermissions("system:fmission:remove")
	@Log(title = "分任务记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fmissionService.deleteFmissionByIds(ids));
	}
	
}
