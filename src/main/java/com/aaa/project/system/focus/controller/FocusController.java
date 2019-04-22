package com.aaa.project.system.focus.controller;

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
import com.aaa.project.system.focus.domain.Focus;
import com.aaa.project.system.focus.service.IFocusService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 重点观察 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/focus")
public class FocusController extends BaseController
{
    private String prefix = "system/focus";
	
	@Autowired
	private IFocusService focusService;
	
	@RequiresPermissions("system:focus:view")
	@GetMapping()
	public String focus()
	{
	    return prefix + "/focus";
	}
	
	/**
	 * 查询重点观察列表
	 */
	@RequiresPermissions("system:focus:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Focus focus)
	{
		startPage();
        List<Focus> list = focusService.selectFocusList(focus);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出重点观察列表
	 */
	@RequiresPermissions("system:focus:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Focus focus)
    {
    	List<Focus> list = focusService.selectFocusList(focus);
        ExcelUtil<Focus> util = new ExcelUtil<Focus>(Focus.class);
        return util.exportExcel(list, "focus");
    }
	
	/**
	 * 新增重点观察
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存重点观察
	 */
	@RequiresPermissions("system:focus:add")
	@Log(title = "重点观察", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Focus focus)
	{		
		return toAjax(focusService.insertFocus(focus));
	}

	/**
	 * 修改重点观察
	 */
	@GetMapping("/edit/{focusId}")
	public String edit(@PathVariable("focusId") Integer focusId, ModelMap mmap)
	{
		Focus focus = focusService.selectFocusById(focusId);
		mmap.put("focus", focus);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存重点观察
	 */
	@RequiresPermissions("system:focus:edit")
	@Log(title = "重点观察", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Focus focus)
	{		
		return toAjax(focusService.updateFocus(focus));
	}
	
	/**
	 * 删除重点观察
	 */
	@RequiresPermissions("system:focus:remove")
	@Log(title = "重点观察", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(focusService.deleteFocusByIds(ids));
	}
	
}
