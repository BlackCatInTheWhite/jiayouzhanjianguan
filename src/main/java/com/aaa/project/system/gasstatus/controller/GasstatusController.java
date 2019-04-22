package com.aaa.project.system.gasstatus.controller;

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
import com.aaa.project.system.gasstatus.domain.Gasstatus;
import com.aaa.project.system.gasstatus.service.IGasstatusService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 加油站状态 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/gasstatus")
public class GasstatusController extends BaseController
{
    private String prefix = "system/gasstatus";
	
	@Autowired
	private IGasstatusService gasstatusService;
	
	@RequiresPermissions("system:gasstatus:view")
	@GetMapping()
	public String gasstatus()
	{
	    return prefix + "/gasstatus";
	}
	
	/**
	 * 查询加油站状态列表
	 */
	@RequiresPermissions("system:gasstatus:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Gasstatus gasstatus)
	{
		startPage();
        List<Gasstatus> list = gasstatusService.selectGasstatusList(gasstatus);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出加油站状态列表
	 */
	@RequiresPermissions("system:gasstatus:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Gasstatus gasstatus)
    {
    	List<Gasstatus> list = gasstatusService.selectGasstatusList(gasstatus);
        ExcelUtil<Gasstatus> util = new ExcelUtil<Gasstatus>(Gasstatus.class);
        return util.exportExcel(list, "gasstatus");
    }
	
	/**
	 * 新增加油站状态
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存加油站状态
	 */
	@RequiresPermissions("system:gasstatus:add")
	@Log(title = "加油站状态", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Gasstatus gasstatus)
	{		
		return toAjax(gasstatusService.insertGasstatus(gasstatus));
	}

	/**
	 * 修改加油站状态
	 */
	@GetMapping("/edit/{gasstatusId}")
	public String edit(@PathVariable("gasstatusId") Integer gasstatusId, ModelMap mmap)
	{
		Gasstatus gasstatus = gasstatusService.selectGasstatusById(gasstatusId);
		mmap.put("gasstatus", gasstatus);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存加油站状态
	 */
	@RequiresPermissions("system:gasstatus:edit")
	@Log(title = "加油站状态", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Gasstatus gasstatus)
	{		
		return toAjax(gasstatusService.updateGasstatus(gasstatus));
	}
	
	/**
	 * 删除加油站状态
	 */
	@RequiresPermissions("system:gasstatus:remove")
	@Log(title = "加油站状态", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(gasstatusService.deleteGasstatusByIds(ids));
	}
	
}
