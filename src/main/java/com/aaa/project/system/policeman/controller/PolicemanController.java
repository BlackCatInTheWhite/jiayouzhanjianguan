package com.aaa.project.system.policeman.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.shiro.service.PasswordService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.myconst.ServerConst;
import com.aaa.project.system.lpolice.service.ILpoliceService;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.service.IPolicemanService;
import com.aaa.project.system.user.domain.User;
import com.aaa.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 派出所人员 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/policeman")
public class PolicemanController extends BaseController
{
    private String prefix = "system/policeman";
	
	@Autowired
	private IPolicemanService policemanService;
	@Autowired
	private ILpoliceService lpoliceService;
	@Autowired
	private IUserService userService;

	@RequiresPermissions("system:policeman:view")
	@GetMapping()
	public String policeman()
	{
	    return prefix + "/policeman";
	}
	
	/**
	 * 查询派出所人员列表
	 */
	@RequiresPermissions("system:policeman:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Policeman policeman, HttpSession session)
	{
		policeman.setLpoliceId(policemanService.selectPolicemanById((Integer) session.getAttribute(ServerConst.POLICEMAN_ID)).getLpoliceId());
		startPage();
        List<Policeman> list = policemanService.selectPolicemanList(policeman);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出派出所人员列表
	 */
	@RequiresPermissions("system:policeman:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Policeman policeman)
    {
    	List<Policeman> list = policemanService.selectPolicemanList(policeman);
        ExcelUtil<Policeman> util = new ExcelUtil<Policeman>(Policeman.class);
        return util.exportExcel(list, "policeman");
    }
	
	/**
	 * 新增派出所人员
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap,HttpSession session)
	{
		Integer policemanid = (Integer)session.getAttribute(ServerConst.POLICEMAN_ID);
		Policeman policeman = policemanService.selectPolicemanById(policemanid);
		mmap.put("policeman",policeman);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存派出所人员
	 */
	@RequiresPermissions("system:policeman:add")
	@Log(title = "派出所人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Policeman policeman)
	{
		policemanService.insertPoliceman(policeman);
		User user=new User();
		user.setDeptId(ServerConst.USER_DEPTID_POLICE);
		user.setParentId(ServerConst.USER_DEPTID_PARENT);
		user.setLoginName(policeman.getPolicemanPhone());
		user.setUserName(policeman.getPolicemanName());
		user.setEmail(ServerConst.USER_EMAIL);
		user.setPhonenumber(policeman.getPolicemanPhone());
		user.setSex(ServerConst.USER_SEX_MAN);
		user.setPassword(policeman.getPolicemanPassword());
		user.setStatus(ServerConst.USER_STATUS);
		user.setPostIds(ServerConst.USER_POSTIDS);
		user.setRoleIds(ServerConst.USER_ROLEIDS_POLICE);
		user.setPolicemanId(policeman.getPolicemanId());
		return toAjax(userService.insertUser(user));
	}

	/**
	 * 修改派出所人员
	 */
	@GetMapping("/edit/{policemanId}")
	public String edit(@PathVariable("policemanId") Integer policemanId, ModelMap mmap)
	{
		Policeman policeman = policemanService.selectPolicemanById(policemanId);
		mmap.put("policeman", policeman);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存派出所人员
	 */
	@RequiresPermissions("system:policeman:edit")
	@Log(title = "派出所人员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Policeman policeman)
	{
		User user = new User();
		Integer policemanid =policeman.getPolicemanId();
		Long userid = userService.selectBypolicemanid(policemanid);
		user.setUserId(userid);
		user.setLoginName(policeman.getPolicemanPhone());
		String s = new PasswordService().encryptPassword(policeman.getPolicemanPhone(), policeman.getPolicemanPassword(), ServerConst.USER_SALT);
		user.setPassword(s);
		user.setSalt(ServerConst.USER_SALT);
		user.setUserName(policeman.getPolicemanName());
		user.setPhonenumber(policeman.getPolicemanPhone());
		user.setPostIds(ServerConst.USER_POSTIDS);
		user.setRoleIds(ServerConst.USER_ROLEIDS_POLICE);
		policemanService.updatePoliceman(policeman);
		return toAjax(userService.updateUser(user));
	}
	
	/**
	 * 删除派出所人员
	 */
	@RequiresPermissions("system:policeman:remove")
	@Log(title = "派出所人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(policemanService.deletePolicemanByIds(ids));
	}
	
}
