package com.aaa.project.system.oilmanager.controller;

import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.buyoilform.domain.Buyoilform;
import com.aaa.project.system.buyoilform.service.IBuyoilformService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 散装油登记 信息操作处理
 *
 * @author aaa
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/oilmanager")
public class OilmanagerController extends BaseController
{
    private String prefix = "system/oilmanager";

    @Autowired
    private IBuyoilformService buyoilformService;

    @RequiresPermissions("system:buyoilform:view")
    @GetMapping()
    public String oilmanager()
    {
        return prefix + "/oilmanager";
    }

    /**
     * 查询散装油登记列表
     */
    @RequiresPermissions("system:buyoilform:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Buyoilform buyoilform, HttpSession session)
    {
        buyoilform.setGasId((Integer) session.getAttribute("gasid"));
        startPage();
        List<Buyoilform> list = buyoilformService.selectBuyoilformList(buyoilform);
        return getDataTable(list);
    }
}
