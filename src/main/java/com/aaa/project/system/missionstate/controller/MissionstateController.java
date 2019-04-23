package com.aaa.project.system.missionstate.controller;

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
import com.aaa.project.system.missionstate.domain.Missionstate;
import com.aaa.project.system.missionstate.service.IMissionstateService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 巡检状态 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/missionstate")
public class MissionstateController extends BaseController
{
    private String prefix = "system/missionstate";
	
	@Autowired
	private IMissionstateService missionstateService;
	
	@RequiresPermissions("system:missionstate:view")
	@GetMapping()
	public String missionstate()
	{
	    return prefix + "/missionstate";
	}
	
	/**
	 * 查询巡检状态列表
	 */
	@RequiresPermissions("system:missionstate:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Missionstate missionstate)
	{
		startPage();
        List<Missionstate> list = missionstateService.selectMissionstateList(missionstate);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出巡检状态列表
	 */
	@RequiresPermissions("system:missionstate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Missionstate missionstate)
    {
    	List<Missionstate> list = missionstateService.selectMissionstateList(missionstate);
        ExcelUtil<Missionstate> util = new ExcelUtil<Missionstate>(Missionstate.class);
        return util.exportExcel(list, "missionstate");
    }
	
	/**
	 * 新增巡检状态
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存巡检状态
	 */
	@RequiresPermissions("system:missionstate:add")
	@Log(title = "巡检状态", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Missionstate missionstate)
	{		
		return toAjax(missionstateService.insertMissionstate(missionstate));
	}

	/**
	 * 修改巡检状态
	 */
	@GetMapping("/edit/{missionStateid}")
	public String edit(@PathVariable("missionStateid") Integer missionStateid, ModelMap mmap)
	{
		Missionstate missionstate = missionstateService.selectMissionstateById(missionStateid);
		mmap.put("missionstate", missionstate);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存巡检状态
	 */
	@RequiresPermissions("system:missionstate:edit")
	@Log(title = "巡检状态", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Missionstate missionstate)
	{		
		return toAjax(missionstateService.updateMissionstate(missionstate));
	}
	
	/**
	 * 删除巡检状态
	 */
	@RequiresPermissions("system:missionstate:remove")
	@Log(title = "巡检状态", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(missionstateService.deleteMissionstateByIds(ids));
	}
	
}
