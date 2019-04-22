package com.aaa.project.system.gastype.controller;

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
import com.aaa.project.system.gastype.domain.Gastype;
import com.aaa.project.system.gastype.service.IGastypeService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 加油站性质 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/gastype")
public class GastypeController extends BaseController
{
    private String prefix = "system/gastype";
	
	@Autowired
	private IGastypeService gastypeService;
	
	@RequiresPermissions("system:gastype:view")
	@GetMapping()
	public String gastype()
	{
	    return prefix + "/gastype";
	}
	
	/**
	 * 查询加油站性质列表
	 */
	@RequiresPermissions("system:gastype:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Gastype gastype)
	{
		startPage();
        List<Gastype> list = gastypeService.selectGastypeList(gastype);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出加油站性质列表
	 */
	@RequiresPermissions("system:gastype:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Gastype gastype)
    {
    	List<Gastype> list = gastypeService.selectGastypeList(gastype);
        ExcelUtil<Gastype> util = new ExcelUtil<Gastype>(Gastype.class);
        return util.exportExcel(list, "gastype");
    }
	
	/**
	 * 新增加油站性质
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存加油站性质
	 */
	@RequiresPermissions("system:gastype:add")
	@Log(title = "加油站性质", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Gastype gastype)
	{		
		return toAjax(gastypeService.insertGastype(gastype));
	}

	/**
	 * 修改加油站性质
	 */
	@GetMapping("/edit/{gastypeId}")
	public String edit(@PathVariable("gastypeId") Integer gastypeId, ModelMap mmap)
	{
		Gastype gastype = gastypeService.selectGastypeById(gastypeId);
		mmap.put("gastype", gastype);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存加油站性质
	 */
	@RequiresPermissions("system:gastype:edit")
	@Log(title = "加油站性质", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Gastype gastype)
	{		
		return toAjax(gastypeService.updateGastype(gastype));
	}
	
	/**
	 * 删除加油站性质
	 */
	@RequiresPermissions("system:gastype:remove")
	@Log(title = "加油站性质", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(gastypeService.deleteGastypeByIds(ids));
	}
	
}
