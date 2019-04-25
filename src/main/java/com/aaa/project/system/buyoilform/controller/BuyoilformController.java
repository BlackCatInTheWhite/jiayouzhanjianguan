package com.aaa.project.system.buyoilform.controller;

import com.aaa.common.utils.poi.ExcelUtil;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.buyoilform.domain.Buyoilform;
import com.aaa.project.system.buyoilform.service.IBuyoilformService;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
import com.aaa.project.system.oilkind.domain.Oilkind;
import com.aaa.project.system.oilkind.service.IOilkindService;
import com.aaa.project.system.oiltype.domain.Oiltype;
import com.aaa.project.system.oiltype.service.IOiltypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 散装油登记 信息操作处理
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/buyoilform")
public class BuyoilformController extends BaseController
{
    private String prefix = "system/buyoilform";
	
	@Autowired
	private IBuyoilformService buyoilformService;
	@Autowired
	private IOilkindService oilkindService;
	@Autowired
	private IOiltypeService oiltypeService;
	@Autowired
	private IGasService gasService;
	
	@RequiresPermissions("system:buyoilform:view")
	@GetMapping()
	public String buyoilform()
	{
	    return prefix + "/buyoilform";
	}
	
	/**
	 * 查询散装油登记列表
	 */
	@RequiresPermissions("system:buyoilform:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Buyoilform buyoilform)
	{
		startPage();
        List<Buyoilform> list = buyoilformService.selectBuyoilformList(buyoilform);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出散装油登记列表
	 */
	@RequiresPermissions("system:buyoilform:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Buyoilform buyoilform)
    {
    	List<Buyoilform> list = buyoilformService.selectBuyoilformList(buyoilform);
        ExcelUtil<Buyoilform> util = new ExcelUtil<Buyoilform>(Buyoilform.class);
        return util.exportExcel(list, "buyoilform");
    }
	
	/**
	 * 新增散装油登记
	 */
	@GetMapping("/add")
	public String add( ModelMap mmap)
	{
		List<Oilkind> oilkindList = oilkindService.selectOilkindList(new Oilkind());
		List<Oiltype> oiltypeList = oiltypeService.selectOiltypeList(new Oiltype());
		List<Gas> gasList = gasService.selectGasList(new Gas());
		mmap.put("oilkindList", oilkindList);
		mmap.put("oiltypeList", oiltypeList);
		mmap.put("gasList", gasList);
		//判断加油站
		if (1==1){
			return "system/oilmanager/add";
		}
		return prefix + "/add";
	}
	
	/**
	 * 新增保存散装油登记
	 */
	@RequiresPermissions("system:buyoilform:add")
	@Log(title = "散装油登记", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Buyoilform buyoilform)
	{
		//判断加油站
		if (buyoilform.getGasId()==null){
			buyoilform.setGasId(1);
		}
		return toAjax(buyoilformService.insertBuyoilform(buyoilform));
	}

	/**
	 * 修改散装油登记
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Buyoilform buyoilform = buyoilformService.selectBuyoilformById(id);
		List<Oilkind> oilkindList = oilkindService.selectOilkindList(new Oilkind());
		List<Oiltype> oiltypeList = oiltypeService.selectOiltypeList(new Oiltype());
		List<Gas> gasList = gasService.selectGasList(new Gas());
		mmap.put("oilkindList", oilkindList);
		mmap.put("oiltypeList", oiltypeList);
		mmap.put("gasList", gasList);
		mmap.put("buyoilform", buyoilform);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存散装油登记
	 */
	@RequiresPermissions("system:buyoilform:edit")
	@Log(title = "散装油登记", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Buyoilform buyoilform)
	{		
		return toAjax(buyoilformService.updateBuyoilform(buyoilform));
	}
	
	/**
	 * 删除散装油登记
	 */
	@RequiresPermissions("system:buyoilform:remove")
	@Log(title = "散装油登记", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(buyoilformService.deleteBuyoilformByIds(ids));
	}
	
}
