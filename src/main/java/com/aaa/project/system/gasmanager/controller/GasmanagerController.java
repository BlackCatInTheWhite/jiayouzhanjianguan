package com.aaa.project.system.gasmanager.controller;

import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.project.myconst.ServerConst;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.service.IGasService;
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
 * 加油站 信息操作处理
 *
 * @author aaa
 * @date 2019-04-22
 */
@Controller
@RequestMapping("/system/gasmanager")
public class GasmanagerController extends BaseController {
    private String prefix = "system/gasmanager";

    @Autowired
    private IGasService gasService;

    @RequiresPermissions("system:gas:view")
    @GetMapping()
    public String gasmanager() {
        return prefix + "/gasmanager";
    }

    /**
     * 查询加油站
     */
    @RequiresPermissions("system:gas:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Gas gas, HttpSession session) {
        gas.setGasId((Integer) session.getAttribute(ServerConst.GAS_ID));
        startPage();
        List<Gas> list = gasService.selectGasList(gas);
        return getDataTable(list);
    }

}
