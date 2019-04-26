package com.aaa.project.system.gasmanmanager.controller;

import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.system.gasman.domain.Gasman;
import com.aaa.project.system.gasman.service.IGasmanService;
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
 * 加油站员工 信息操作处理
 *
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/gasmanmanager")
public class GasmanmanagerController extends BaseController {
    private String prefix = "system/gasmanmanager";

    @Autowired
    private IGasmanService gasmanService;

    @RequiresPermissions("system:gasmanmanager:view")
    @GetMapping()
    public String gasmanmanager() {
        return prefix + "/gasmanmanager";
    }

    /**
     * 查询加油站员工列表
     */
    @RequiresPermissions("system:gasmanmanager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Gasman gasman, HttpSession session) {
        gasman.setGasId((Integer) session.getAttribute("gasid"));
        startPage();
        List<Gasman> list = gasmanService.selectGasmanList(gasman);
        return getDataTable(list);
    }
}
