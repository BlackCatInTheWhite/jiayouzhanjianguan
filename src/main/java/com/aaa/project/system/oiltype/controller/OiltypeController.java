package com.aaa.project.system.oiltype.controller;

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
import com.aaa.project.system.oiltype.domain.Oiltype;
import com.aaa.project.system.oiltype.service.IOiltypeService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 油品型号 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/oiltype")
public class OiltypeController extends BaseController
{
    private String prefix = "system/oiltype";
	
	@Autowired
	private IOiltypeService oiltypeService;
	
	@RequiresPermissions("system:oiltype:view")
	@GetMapping()
	public String oiltype()
	{
	    return prefix + "/oiltype";
	}
	
	/**
	 * 查询油品型号列表
	 */
	@RequiresPermissions("system:oiltype:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Oiltype oiltype)
	{
		startPage();
        List<Oiltype> list = oiltypeService.selectOiltypeList(oiltype);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出油品型号列表
	 */
	@RequiresPermissions("system:oiltype:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Oiltype oiltype)
    {
    	List<Oiltype> list = oiltypeService.selectOiltypeList(oiltype);
        ExcelUtil<Oiltype> util = new ExcelUtil<Oiltype>(Oiltype.class);
        return util.exportExcel(list, "oiltype");
    }
	
	/**
	 * 新增油品型号
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存油品型号
	 */
	@RequiresPermissions("system:oiltype:add")
	@Log(title = "油品型号", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Oiltype oiltype)
	{		
		return toAjax(oiltypeService.insertOiltype(oiltype));
	}

	/**
	 * 修改油品型号
	 */
	@GetMapping("/edit/{oilId}")
	public String edit(@PathVariable("oilId") Integer oilId, ModelMap mmap)
	{
		Oiltype oiltype = oiltypeService.selectOiltypeById(oilId);
		mmap.put("oiltype", oiltype);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存油品型号
	 */
	@RequiresPermissions("system:oiltype:edit")
	@Log(title = "油品型号", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Oiltype oiltype)
	{		
		return toAjax(oiltypeService.updateOiltype(oiltype));
	}
	
	/**
	 * 删除油品型号
	 */
	@RequiresPermissions("system:oiltype:remove")
	@Log(title = "油品型号", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(oiltypeService.deleteOiltypeByIds(ids));
	}
	
}
