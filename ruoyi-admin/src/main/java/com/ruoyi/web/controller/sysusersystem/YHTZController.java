package com.ruoyi.web.controller.sysusersystem;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.domain.YHTZVo;
import com.ruoyi.sysusersystem.service.IJzPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.page.TableDataInfo;
import java.util.List;


/**
 * @Author sunli
 * @Date 2020/2/20
 */

@Controller
@RequestMapping("/sysusersystem/yhtz")
public class YHTZController  extends BaseController {

    private String prefix = "sysusersystem/troubleplan";

    @Autowired
    private IJzPlanService jzPlanService;

    @RequiresPermissions("sysusersystem:yhtz:view")
    @GetMapping()
    public String yhtz()
    {
        return prefix + "/yhtz";
    }

    /**
     *  统计隐患台账
     */
    @RequiresPermissions("sysusersystem:yhtz:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YHTZVo vo)
    {
        startPage();
        List<YHTZVo> list = jzPlanService.selectYHTZList(vo);
        return getDataTable(list);
    }

    /**
     * 跳转录入隐患项页面
     */
    @GetMapping("/lryhx/{id}")
    public String lryhx(@PathVariable("id") String id, ModelMap map)
    {
        map.put("id",id);
        return "sysusersystem/zg/zg";
    }



}
