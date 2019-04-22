package com.aaa.project.system.fpolice.controller;

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
import com.aaa.project.system.fpolice.domain.Fpolice;
import com.aaa.project.system.fpolice.service.IFpoliceService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 公安分局 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/fpolice")
public class FpoliceController extends BaseController
{
    private String prefix = "system/fpolice";
	
	@Autowired
	private IFpoliceService fpoliceService;
	
	@RequiresPermissions("system:fpolice:view")
	@GetMapping()
	public String fpolice()
	{
	    return prefix + "/fpolice";
	}
	
	/**
	 * 查询公安分局列表
	 */
	@RequiresPermissions("system:fpolice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Fpolice fpolice)
	{
		startPage();
        List<Fpolice> list = fpoliceService.selectFpoliceList(fpolice);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出公安分局列表
	 */
	@RequiresPermissions("system:fpolice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fpolice fpolice)
    {
    	List<Fpolice> list = fpoliceService.selectFpoliceList(fpolice);
        ExcelUtil<Fpolice> util = new ExcelUtil<Fpolice>(Fpolice.class);
        return util.exportExcel(list, "fpolice");
    }
	
	/**
	 * 新增公安分局
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存公安分局
	 */
	@RequiresPermissions("system:fpolice:add")
	@Log(title = "公安分局", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Fpolice fpolice)
	{		
		return toAjax(fpoliceService.insertFpolice(fpolice));
	}

	/**
	 * 修改公安分局
	 */
	@GetMapping("/edit/{fpoliceId}")
	public String edit(@PathVariable("fpoliceId") Integer fpoliceId, ModelMap mmap)
	{
		Fpolice fpolice = fpoliceService.selectFpoliceById(fpoliceId);
		mmap.put("fpolice", fpolice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公安分局
	 */
	@RequiresPermissions("system:fpolice:edit")
	@Log(title = "公安分局", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Fpolice fpolice)
	{		
		return toAjax(fpoliceService.updateFpolice(fpolice));
	}
	
	/**
	 * 删除公安分局
	 */
	@RequiresPermissions("system:fpolice:remove")
	@Log(title = "公安分局", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(fpoliceService.deleteFpoliceByIds(ids));
	}
	
}
