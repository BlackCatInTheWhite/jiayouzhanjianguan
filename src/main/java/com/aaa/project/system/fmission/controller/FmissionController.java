package com.aaa.project.system.fmission.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.myconst.ServerConst;
import com.aaa.project.system.fmission.domain.Fmission;
import com.aaa.project.system.fmission.service.IFmissionService;
import com.aaa.project.system.fmissionproject.domain.Fmissionproject;
import com.aaa.project.system.fmissionproject.service.IFmissionprojectService;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import com.aaa.project.system.rectification.domain.Rectification;
import com.aaa.project.system.rectification.service.IRectificationService;
import com.aaa.project.system.user.domain.User;
import com.aaa.project.system.user.service.IUserService;
import com.aaa.project.system.zmission.domain.Zmission;
import com.aaa.project.system.zmission.service.IZmissionService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
	private IFmissionprojectService fmissionprojectService;
	@Autowired
	private IZmissionService zmissionService;
	@Autowired
	private IGasService gasService;
	@Autowired
	private IPolicemanService policemanService;
	@Autowired
	 private IRectificationService rectificationService;
	@Autowired
	private IUserService userService;

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
	public TableDataInfo list(Fmission fmission, HttpSession session)
	{
		Policeman policeman = policemanService.selectPolicemanById((Integer) session.getAttribute(ServerConst.POLICEMAN_ID));
		Gas gas=new Gas();
		gas.setLpoliceId(policeman.getLpoliceId());
		List<Gas> gases = gasService.selectGasList(gas);
		List<Integer> gasidlist=new ArrayList<>();
		//所有加油站id
		for (Gas g:gases) {
			gasidlist.add(g.getGasId());
		}
		//所有总任务id
		Zmission zmission=new Zmission();
		zmission.setGasidlist(gasidlist);
		List<Zmission> zmissions = zmissionService.selectZmissionByLpolice(zmission);
		List<Integer> zmissionlist=new ArrayList<>();
		for (Zmission z:zmissions) {
			zmissionlist.add(z.getMissionId());
		}
		if (zmissionlist.isEmpty())zmissionlist.add(ServerConst.ZERO);
		fmission.setZmissionlist(zmissionlist);
		startPage();
        List<Fmission> list = fmissionService.selectFmissionByZmissionlist(fmission);
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
		fmission.setFmissionState(ServerConst.FMISSIONSTATE_SUCCESS);
		Gas gas = gasService.selectGasById(zmissionService.selectZmissionById(fmission.getZmissionId()).getGasId());
		gas.setGasstatusId(ServerConst.GASSTATE_NORMAL);
		gasService.updateGas(gas);
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
		fmission.setFmissionState(ServerConst.FMISSIONSTATE_SUCCESS);
		fmissionService.updateFmission(fmission);
		Gas gas = gasService.selectGasById(rectification.getGasId());
		gas.setGasstatusId(ServerConst.GASSTATE_RECTIFICATION);
		gasService.updateGas(gas);
		return toAjax(rectificationService.insertRectification(rectification));
	}
	/**
	 * 批准加油站注册
	 */
	@GetMapping("/gasregister/{id}")
	public String gasregister(@PathVariable("id") Integer fmissionId, ModelMap mmap) {
		Fmission fmission = fmissionService.selectFmissionById(fmissionId);
		Zmission zmission = zmissionService.selectZmissionById(fmission.getZmissionId());
		Gas gas = gasService.selectGasById(zmission.getGasId());
		mmap.put("gas",gas);
		mmap.put("fmissionId",fmissionId);
		return prefix + "/toregister";
	}
	/**
	 * 确认批准加油站注册
	 */
	@RequiresPermissions("system:fmission:gasregister")
	@PostMapping("/gasregister")
	@ResponseBody
	public AjaxResult gasregisterSave(Gas gas, @Param("fmissionId") Integer fmissionId) {
		Fmission fmission = fmissionService.selectFmissionById(fmissionId);
		fmission.setFmissionState(ServerConst.FMISSIONSTATE_SUCCESS);
		fmissionService.updateFmission(fmission);
		Gas oldgas = gasService.selectGasById(gas.getGasId());
		gas.setGasLongitude(oldgas.getGasLongitude());
		gas.setGasLatitude(oldgas.getGasLatitude());
		gas.setGasstatusId(ServerConst.GASSTATE_NORMAL);
		gasService.updateGas(gas);
		User user=new User();
		user.setDeptId(ServerConst.USER_DEPTID_GAS);
		user.setParentId(ServerConst.USER_DEPTID_PARENT);
		user.setLoginName(gas.getPrincipalUsername());
		user.setUserName(gas.getPrincipalName());
		user.setEmail(ServerConst.USER_EMAIL);
		user.setPhonenumber(gas.getPrincipalPhone());
		user.setSex(ServerConst.USER_SEX_MAN);
		user.setPassword(gas.getPrincipalPassword());
		user.setStatus(ServerConst.USER_STATUS);
		user.setPostIds(ServerConst.USER_POSTIDS);
		user.setRoleIds(ServerConst.USER_ROLEIDS_GAS);
		user.setGasId(gas.getGasId());
		return toAjax(userService.insertUser(user));
	}
}
