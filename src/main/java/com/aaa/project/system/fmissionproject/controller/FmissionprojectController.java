package com.aaa.project.system.fmissionproject.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.fmissionproject.domain.Fmissionproject;
import com.aaa.project.system.fmissionproject.service.IFmissionprojectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 项目记录 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-25
 */
@Controller
@RequestMapping("/system/fmissionproject")
public class FmissionprojectController extends BaseController
{
    private String prefix = "system/fmissionproject";
	
	@Autowired
	private IFmissionprojectService fmissionprojectService;
	
	@RequiresPermissions("system:fmissionproject:view")
	@GetMapping()
	public String fmissionproject()
	{
	    return prefix + "/fmissionproject";
	}
	
	/**
	 * 查询项目记录列表
	 */
	@RequiresPermissions("system:fmissionproject:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Fmissionproject fmissionproject)
	{
		startPage();
        List<Fmissionproject> list = fmissionprojectService.selectFmissionprojectList(fmissionproject);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出项目记录列表
	 */
	@RequiresPermissions("system:fmissionproject:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fmissionproject fmissionproject)
    {
    	List<Fmissionproject> list = fmissionprojectService.selectFmissionprojectList(fmissionproject);
        ExcelUtil<Fmissionproject> util = new ExcelUtil<Fmissionproject>(Fmissionproject.class);
        return util.exportExcel(list, "fmissionproject");
    }

}
