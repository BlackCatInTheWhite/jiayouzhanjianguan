package com.aaa.project.system.policeman.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.lpolice.domain.Lpolice;
import com.aaa.project.system.lpolice.service.ILpoliceService;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 派出所人员 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/policeman")
public class PolicemanController extends BaseController
{
    private String prefix = "system/policeman";
	
	@Autowired
	private IPolicemanService policemanService;
	@Autowired
	private ILpoliceService lpoliceService;
	
	@RequiresPermissions("system:policeman:view")
	@GetMapping()
	public String policeman()
	{
	    return prefix + "/policeman";
	}
	
	/**
	 * 查询派出所人员列表
	 */
	@RequiresPermissions("system:policeman:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Policeman policeman)
	{
		startPage();
        List<Policeman> list = policemanService.selectPolicemanList(policeman);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出派出所人员列表
	 */
	@RequiresPermissions("system:policeman:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Policeman policeman)
    {
    	List<Policeman> list = policemanService.selectPolicemanList(policeman);
        ExcelUtil<Policeman> util = new ExcelUtil<Policeman>(Policeman.class);
        return util.exportExcel(list, "policeman");
    }
	
	/**
	 * 新增派出所人员
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		List<Lpolice> lpoliceList = lpoliceService.selectLpoliceList(new Lpolice());
		mmap.put("lpoliceList", lpoliceList);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存派出所人员
	 */
	@RequiresPermissions("system:policeman:add")
	@Log(title = "派出所人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Policeman policeman)
	{		
		return toAjax(policemanService.insertPoliceman(policeman));
	}

	/**
	 * 修改派出所人员
	 */
	@GetMapping("/edit/{policemanId}")
	public String edit(@PathVariable("policemanId") Integer policemanId, ModelMap mmap)
	{
		Policeman policeman = policemanService.selectPolicemanById(policemanId);
		mmap.put("policeman", policeman);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存派出所人员
	 */
	@RequiresPermissions("system:policeman:edit")
	@Log(title = "派出所人员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Policeman policeman)
	{		
		return toAjax(policemanService.updatePoliceman(policeman));
	}
	
	/**
	 * 删除派出所人员
	 */
	@RequiresPermissions("system:policeman:remove")
	@Log(title = "派出所人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(policemanService.deletePolicemanByIds(ids));
	}
	
}
