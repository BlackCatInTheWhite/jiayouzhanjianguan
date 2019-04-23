package com.aaa.project.system.policenotice.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import com.aaa.project.system.policenotice.domain.Policenotice;
import com.aaa.project.system.policenotice.service.IPolicenoticeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/policenotice")
public class PolicenoticeController extends BaseController
{
    private String prefix = "system/policenotice";
	
	@Autowired
	private IPolicenoticeService policenoticeService;
	@Autowired
	private IPolicemanService policemanService;
	
	@RequiresPermissions("system:policenotice:view")
	@GetMapping()
	public String policenotice()
	{
	    return prefix + "/policenotice";
	}
	
	/**
	 * 查询公告列表
	 */
	@RequiresPermissions("system:policenotice:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Policenotice policenotice)
	{
		startPage();
        List<Policenotice> list = policenoticeService.selectPolicenoticeList(policenotice);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出公告列表
	 */
	@RequiresPermissions("system:policenotice:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Policenotice policenotice)
    {
    	List<Policenotice> list = policenoticeService.selectPolicenoticeList(policenotice);
        ExcelUtil<Policenotice> util = new ExcelUtil<Policenotice>(Policenotice.class);
        return util.exportExcel(list, "policenotice");
    }
	
	/**
	 * 新增公告
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		List<Policeman> policemanList = policemanService.selectPolicemanList(new Policeman());
		mmap.put("policemanList", policemanList);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存公告
	 */
	@RequiresPermissions("system:policenotice:add")
	@Log(title = "公告", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Policenotice policenotice)
	{		
		return toAjax(policenoticeService.insertPolicenotice(policenotice));
	}

	/**
	 * 修改公告
	 */
	@GetMapping("/edit/{noticeId}")
	public String edit(@PathVariable("noticeId") Integer noticeId, ModelMap mmap)
	{
		Policenotice policenotice = policenoticeService.selectPolicenoticeById(noticeId);
		List<Policeman> policemanList = policemanService.selectPolicemanList(new Policeman());
		mmap.put("policemanList", policemanList);
		mmap.put("policenotice", policenotice);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公告
	 */
	@RequiresPermissions("system:policenotice:edit")
	@Log(title = "公告", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Policenotice policenotice)
	{		
		return toAjax(policenoticeService.updatePolicenotice(policenotice));
	}
	
	/**
	 * 删除公告
	 */
	@RequiresPermissions("system:policenotice:remove")
	@Log(title = "公告", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(policenoticeService.deletePolicenoticeByIds(ids));
	}
	
}
