package com.aaa.project.system.fmission.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.fmission.domain.Fmission;
import com.aaa.project.system.fmission.service.IFmissionService;
import com.aaa.project.system.fmissionproject.domain.Fmissionproject;
import com.aaa.project.system.fmissionproject.service.IFmissionprojectService;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.missionstate.service.IMissionstateService;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import com.aaa.project.system.rectification.domain.Rectification;
import com.aaa.project.system.rectification.service.IRectificationService;
import com.aaa.project.system.zmission.service.IZmissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分任务记录 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/fmission")
public class FmissionController extends BaseController
{
    private String prefix = "system/fmission";
	
	@Autowired
	private IFmissionService fmissionService;
	@Autowired
	private IMissionstateService missionstateService;
	@Autowired
	private IFmissionprojectService fmissionprojectService;
	@Autowired
	private IZmissionService zmissionService;
	@Autowired
	private IGasService gasService;
	@Autowired
	private IPolicemanService policemanService;
	@Autowired
	 private IRectificationService rectificationService;

	@RequiresPermissions("system:fmission:view")
	@GetMapping()
	public String fmission()
	{
	    return prefix + "/fmission";
	}
	
	/**
	 * 查询分任务记录列表
	 */
	@RequiresPermissions("system:fmission:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Fmission fmission)
	{
		startPage();
        List<Fmission> list = fmissionService.selectFmissionList(fmission);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出分任务记录列表
	 */
	@RequiresPermissions("system:fmission:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fmission fmission)
    {
    	List<Fmission> list = fmissionService.selectFmissionList(fmission);
        ExcelUtil<Fmission> util = new ExcelUtil<Fmission>(Fmission.class);
        return util.exportExcel(list, "fmission");
    }

	/**
	 * 详情管理
	 */
	@RequiresPermissions("system:fmission:detail")
	@GetMapping("/detail")
	public String oil(@RequestParam("fmissionId") Integer fmissionId,ModelMap mmap) {
		mmap.put("fmissionId", fmissionId);
		return prefix + "/todetail";
	}
	/**
	 * 详情填充
	 */
	@PostMapping("/detail/list/{fmissionId}")
	@ResponseBody
	public TableDataInfo oillist(@PathVariable(name = "fmissionId") Integer fmissionId, Fmissionproject fmissionproject) {
		fmissionproject.setFmissionId(fmissionId);
		startPage();
		List<Fmissionproject> list = fmissionprojectService.selectFmissionprojectList(fmissionproject);
		return getDataTable(list);
	}

	/**
	 * 确认审核
	 */
	@RequiresPermissions("system:fmission:agree")
	@PostMapping("/agree")
	@ResponseBody
	public AjaxResult fmissionagree(String id) {
		Fmission fmission = fmissionService.selectFmissionById(Integer.parseInt(id));
		fmission.setFmissionState(2);
		return toAjax(fmissionService.updateFmission(fmission));
	}

	/**
	 * 确认整改
	 */
	@GetMapping("/notice/{id}")
	public String notice(@PathVariable("id") Integer fmissionId, ModelMap mmap) {
		Fmission fmission = fmissionService.selectFmissionById(fmissionId);
		Gas gas = gasService.selectGasById(zmissionService.selectZmissionById(fmission.getZmissionId()).getGasId());
		List<Policeman> policemanList = policemanService.selectPolicemanList(new Policeman());
		mmap.put("gas", gas);
		mmap.put("fmission", fmission);
		mmap.put("policemanList", policemanList);
		return prefix + "/tonotice";
	}
	/**
	 * 确认整改加油站
	 */
	@RequiresPermissions("system:fmission:notice")
	@PostMapping("/notice")
	@ResponseBody
	public AjaxResult noticeSave(Rectification rectification) {
		Fmission fmission = fmissionService.selectFmissionById(rectification.getFmissionId());
		fmission.setFmissionState(2);
		Gas gas = gasService.selectGasById(rectification.getGasId());
		gas.setGasstatusId(2);
		gasService.updateGas(gas);
		return toAjax(rectificationService.insertRectification(rectification));
	}
}
