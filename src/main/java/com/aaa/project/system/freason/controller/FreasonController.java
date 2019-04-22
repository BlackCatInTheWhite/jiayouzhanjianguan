package com.aaa.project.system.freason.controller;

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
import com.aaa.project.system.freason.domain.Freason;
import com.aaa.project.system.freason.service.IFreasonService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 观察原因 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/freason")
public class FreasonController extends BaseController
{
    private String prefix = "system/freason";
	
	@Autowired
	private IFreasonService freasonService;
	
	@RequiresPermissions("system:freason:view")
	@GetMapping()
	public String freason()
	{
	    return prefix + "/freason";
	}
	
	/**
	 * 查询观察原因列表
	 */
	@RequiresPermissions("system:freason:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Freason freason)
	{
		startPage();
        List<Freason> list = freasonService.selectFreasonList(freason);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出观察原因列表
	 */
	@RequiresPermissions("system:freason:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Freason freason)
    {
    	List<Freason> list = freasonService.selectFreasonList(freason);
        ExcelUtil<Freason> util = new ExcelUtil<Freason>(Freason.class);
        return util.exportExcel(list, "freason");
    }
	
	/**
	 * 新增观察原因
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存观察原因
	 */
	@RequiresPermissions("system:freason:add")
	@Log(title = "观察原因", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Freason freason)
	{		
		return toAjax(freasonService.insertFreason(freason));
	}

	/**
	 * 修改观察原因
	 */
	@GetMapping("/edit/{freasonId}")
	public String edit(@PathVariable("freasonId") Integer freasonId, ModelMap mmap)
	{
		Freason freason = freasonService.selectFreasonById(freasonId);
		mmap.put("freason", freason);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存观察原因
	 */
	@RequiresPermissions("system:freason:edit")
	@Log(title = "观察原因", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Freason freason)
	{		
		return toAjax(freasonService.updateFreason(freason));
	}
	
	/**
	 * 删除观察原因
	 */
	@RequiresPermissions("system:freason:remove")
	@Log(title = "观察原因", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(freasonService.deleteFreasonByIds(ids));
	}
	
}
