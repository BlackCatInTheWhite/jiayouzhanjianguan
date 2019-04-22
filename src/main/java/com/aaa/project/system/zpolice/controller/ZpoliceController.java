package com.aaa.project.system.zpolice.controller;

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
import com.aaa.project.system.zpolice.domain.Zpolice;
import com.aaa.project.system.zpolice.service.IZpoliceService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 公安总局 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/zpolice")
public class ZpoliceController extends BaseController
{
    private String prefix = "system/zpolice";
	
	@Autowired
	private IZpoliceService zpoliceService;
	
	@RequiresPermissions("system:zpolice:view")
	@GetMapping()
	public String zpolice()
	{
	    return prefix + "/zpolice";
	}
	
	/**
	 * 查询公安总局列表
	 */
	@RequiresPermissions("system:zpolice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Zpolice zpolice)
	{
		startPage();
        List<Zpolice> list = zpoliceService.selectZpoliceList(zpolice);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出公安总局列表
	 */
	@RequiresPermissions("system:zpolice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Zpolice zpolice)
    {
    	List<Zpolice> list = zpoliceService.selectZpoliceList(zpolice);
        ExcelUtil<Zpolice> util = new ExcelUtil<Zpolice>(Zpolice.class);
        return util.exportExcel(list, "zpolice");
    }
	
	/**
	 * 新增公安总局
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存公安总局
	 */
	@RequiresPermissions("system:zpolice:add")
	@Log(title = "公安总局", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Zpolice zpolice)
	{		
		return toAjax(zpoliceService.insertZpolice(zpolice));
	}

	/**
	 * 修改公安总局
	 */
	@GetMapping("/edit/{zpoliceId}")
	public String edit(@PathVariable("zpoliceId") Integer zpoliceId, ModelMap mmap)
	{
		Zpolice zpolice = zpoliceService.selectZpoliceById(zpoliceId);
		mmap.put("zpolice", zpolice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公安总局
	 */
	@RequiresPermissions("system:zpolice:edit")
	@Log(title = "公安总局", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Zpolice zpolice)
	{		
		return toAjax(zpoliceService.updateZpolice(zpolice));
	}
	
	/**
	 * 删除公安总局
	 */
	@RequiresPermissions("system:zpolice:remove")
	@Log(title = "公安总局", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(zpoliceService.deleteZpoliceByIds(ids));
	}
	
}
