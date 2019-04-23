package com.aaa.project.system.oilkind.controller;

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
import com.aaa.project.system.oilkind.domain.Oilkind;
import com.aaa.project.system.oilkind.service.IOilkindService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 油品类型 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/oilkind")
public class OilkindController extends BaseController
{
    private String prefix = "system/oilkind";
	
	@Autowired
	private IOilkindService oilkindService;
	
	@RequiresPermissions("system:oilkind:view")
	@GetMapping()
	public String oilkind()
	{
	    return prefix + "/oilkind";
	}
	
	/**
	 * 查询油品类型列表
	 */
	@RequiresPermissions("system:oilkind:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Oilkind oilkind)
	{
		startPage();
        List<Oilkind> list = oilkindService.selectOilkindList(oilkind);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出油品类型列表
	 */
	@RequiresPermissions("system:oilkind:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Oilkind oilkind)
    {
    	List<Oilkind> list = oilkindService.selectOilkindList(oilkind);
        ExcelUtil<Oilkind> util = new ExcelUtil<Oilkind>(Oilkind.class);
        return util.exportExcel(list, "oilkind");
    }
	
	/**
	 * 新增油品类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存油品类型
	 */
	@RequiresPermissions("system:oilkind:add")
	@Log(title = "油品类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Oilkind oilkind)
	{		
		return toAjax(oilkindService.insertOilkind(oilkind));
	}

	/**
	 * 修改油品类型
	 */
	@GetMapping("/edit/{oilKindid}")
	public String edit(@PathVariable("oilKindid") Integer oilKindid, ModelMap mmap)
	{
		Oilkind oilkind = oilkindService.selectOilkindById(oilKindid);
		mmap.put("oilkind", oilkind);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存油品类型
	 */
	@RequiresPermissions("system:oilkind:edit")
	@Log(title = "油品类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Oilkind oilkind)
	{		
		return toAjax(oilkindService.updateOilkind(oilkind));
	}
	
	/**
	 * 删除油品类型
	 */
	@RequiresPermissions("system:oilkind:remove")
	@Log(title = "油品类型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(oilkindService.deleteOilkindByIds(ids));
	}
	
}
