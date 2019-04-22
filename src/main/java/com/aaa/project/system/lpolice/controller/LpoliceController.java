package com.aaa.project.system.lpolice.controller;

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
import com.aaa.project.system.lpolice.domain.Lpolice;
import com.aaa.project.system.lpolice.service.ILpoliceService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 派出所 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/lpolice")
public class LpoliceController extends BaseController
{
    private String prefix = "system/lpolice";
	
	@Autowired
	private ILpoliceService lpoliceService;
	
	@RequiresPermissions("system:lpolice:view")
	@GetMapping()
	public String lpolice()
	{
	    return prefix + "/lpolice";
	}
	
	/**
	 * 查询派出所列表
	 */
	@RequiresPermissions("system:lpolice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Lpolice lpolice)
	{
		startPage();
        List<Lpolice> list = lpoliceService.selectLpoliceList(lpolice);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出派出所列表
	 */
	@RequiresPermissions("system:lpolice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Lpolice lpolice)
    {
    	List<Lpolice> list = lpoliceService.selectLpoliceList(lpolice);
        ExcelUtil<Lpolice> util = new ExcelUtil<Lpolice>(Lpolice.class);
        return util.exportExcel(list, "lpolice");
    }
	
	/**
	 * 新增派出所
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存派出所
	 */
	@RequiresPermissions("system:lpolice:add")
	@Log(title = "派出所", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Lpolice lpolice)
	{		
		return toAjax(lpoliceService.insertLpolice(lpolice));
	}

	/**
	 * 修改派出所
	 */
	@GetMapping("/edit/{lpoliceId}")
	public String edit(@PathVariable("lpoliceId") Integer lpoliceId, ModelMap mmap)
	{
		Lpolice lpolice = lpoliceService.selectLpoliceById(lpoliceId);
		mmap.put("lpolice", lpolice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存派出所
	 */
	@RequiresPermissions("system:lpolice:edit")
	@Log(title = "派出所", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Lpolice lpolice)
	{		
		return toAjax(lpoliceService.updateLpolice(lpolice));
	}
	
	/**
	 * 删除派出所
	 */
	@RequiresPermissions("system:lpolice:remove")
	@Log(title = "派出所", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(lpoliceService.deleteLpoliceByIds(ids));
	}
	
}
