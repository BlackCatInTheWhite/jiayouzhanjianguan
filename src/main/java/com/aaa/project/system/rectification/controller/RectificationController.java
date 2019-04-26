package com.aaa.project.system.rectification.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.missionstate.domain.Missionstate;
import com.aaa.project.system.missionstate.service.IMissionstateService;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import com.aaa.project.system.rectification.domain.Rectification;
import com.aaa.project.system.rectification.service.IRectificationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 整改 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/rectification")
public class RectificationController extends BaseController
{
    private String prefix = "system/rectification";
	
	@Autowired
	private IRectificationService rectificationService;
	@Autowired
	private IGasService gasService;
	@Autowired
	private IPolicemanService policemanService;
	@Autowired
	private IMissionstateService missionstateService;
	
	@RequiresPermissions("system:rectification:view")
	@GetMapping()
	public String rectification()
	{
	    return prefix + "/rectification";
	}
	
	/**
	 * 查询整改列表
	 */
	@RequiresPermissions("system:rectification:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Rectification rectification)
	{
		startPage();
        List<Rectification> list = rectificationService.selectRectificationList(rectification);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出整改列表
	 */
	@RequiresPermissions("system:rectification:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Rectification rectification)
    {
    	List<Rectification> list = rectificationService.selectRectificationList(rectification);
        ExcelUtil<Rectification> util = new ExcelUtil<Rectification>(Rectification.class);
        return util.exportExcel(list, "rectification");
    }
	
	/**
	 * 新增整改
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		List<Gas> gasList = gasService.selectGasList(new Gas());
		List<Policeman> policemanList = policemanService.selectPolicemanList(new Policeman());
		List<Missionstate> missionstateList = missionstateService.selectMissionstateList(new Missionstate());
		mmap.put("gasList", gasList);
		mmap.put("policemanList", policemanList);
		mmap.put("missionstateList", missionstateList);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存整改
	 */
	@RequiresPermissions("system:rectification:add")
	@Log(title = "整改", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Rectification rectification)
	{		
		return toAjax(rectificationService.insertRectification(rectification));
	}

	/**
	 * 修改整改
	 */
	@GetMapping("/edit/{rectificationId}")
	public String edit(@PathVariable("rectificationId") Integer rectificationId, ModelMap mmap)
	{
		Rectification rectification = rectificationService.selectRectificationById(rectificationId);
		List<Gas> gasList = gasService.selectGasList(new Gas());
		List<Policeman> policemanList = policemanService.selectPolicemanList(new Policeman());
		List<Missionstate> missionstateList = missionstateService.selectMissionstateList(new Missionstate());
		mmap.put("gasList", gasList);
		mmap.put("policemanList", policemanList);
		mmap.put("missionstateList", missionstateList);
		mmap.put("rectification", rectification);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存整改
	 */
	@RequiresPermissions("system:rectification:edit")
	@Log(title = "整改", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Rectification rectification)
	{		
		return toAjax(rectificationService.updateRectification(rectification));
	}
	
	/**
	 * 删除整改
	 */
	@RequiresPermissions("system:rectification:remove")
	@Log(title = "整改", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(rectificationService.deleteRectificationByIds(ids));
	}
	
}
