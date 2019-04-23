package com.aaa.project.system.projectkind.controller;

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
import com.aaa.project.system.projectkind.domain.Projectkind;
import com.aaa.project.system.projectkind.service.IProjectkindService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

/**
 * 项目分类 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/projectkind")
public class ProjectkindController extends BaseController
{
    private String prefix = "system/projectkind";
	
	@Autowired
	private IProjectkindService projectkindService;
	
	@RequiresPermissions("system:projectkind:view")
	@GetMapping()
	public String projectkind()
	{
	    return prefix + "/projectkind";
	}
	
	/**
	 * 查询项目分类列表
	 */
	@RequiresPermissions("system:projectkind:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Projectkind projectkind)
	{
		startPage();
        List<Projectkind> list = projectkindService.selectProjectkindList(projectkind);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出项目分类列表
	 */
	@RequiresPermissions("system:projectkind:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Projectkind projectkind)
    {
    	List<Projectkind> list = projectkindService.selectProjectkindList(projectkind);
        ExcelUtil<Projectkind> util = new ExcelUtil<Projectkind>(Projectkind.class);
        return util.exportExcel(list, "projectkind");
    }
	
	/**
	 * 新增项目分类
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存项目分类
	 */
	@RequiresPermissions("system:projectkind:add")
	@Log(title = "项目分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Projectkind projectkind)
	{		
		return toAjax(projectkindService.insertProjectkind(projectkind));
	}

	/**
	 * 修改项目分类
	 */
	@GetMapping("/edit/{projectKindid}")
	public String edit(@PathVariable("projectKindid") Integer projectKindid, ModelMap mmap)
	{
		Projectkind projectkind = projectkindService.selectProjectkindById(projectKindid);
		mmap.put("projectkind", projectkind);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存项目分类
	 */
	@RequiresPermissions("system:projectkind:edit")
	@Log(title = "项目分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Projectkind projectkind)
	{		
		return toAjax(projectkindService.updateProjectkind(projectkind));
	}
	
	/**
	 * 删除项目分类
	 */
	@RequiresPermissions("system:projectkind:remove")
	@Log(title = "项目分类", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(projectkindService.deleteProjectkindByIds(ids));
	}
	
}
