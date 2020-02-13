package com.ruoyi.web.controller.sysusersystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.ruoyi.common.constant.CoommonConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDictType;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.sysusersystem.domain.JzInspection;
import com.ruoyi.sysusersystem.service.IJzInspectionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.service.IJzPlanService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 制定隐患计划Controller
 * 
 * @author sunli
 * @date 2019-12-31
 */
@Controller
@RequestMapping("/sysusersystem/troubleplan")
public class JzTroublePlanController extends BaseController
{
    private String prefix = "sysusersystem/troubleplan";

    @Autowired
    private IJzPlanService jzPlanService;

    @Autowired
    private IJzInspectionService jzInspectionService;

    @RequiresPermissions("sysusersystem:troubleplan:view")
    @GetMapping()
    public String plan()
    {
        return prefix + "/troubleplan";
    }
    /**
     * 查询制定计划列表
     */
    @RequiresPermissions("sysusersystem:troubleplan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzPlan jzPlan)
    {
        startPage();
        List<JzPlan> list = null;

        jzPlan.setPlanType("2");
        list=  jzPlanService.selectJzPlanList(jzPlan);
        return getDataTable(list);
    }

    /**
     * 导出隐患计划列表
     */
    @RequiresPermissions("sysusersystem:troubleplan:export")
    @Log(title = "隐患计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzPlan jzPlan)
    {
        List<JzPlan> list = jzPlanService.selectJzPlanList(jzPlan);
        ExcelUtil<JzPlan> util = new ExcelUtil<JzPlan>(JzPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 新增隐患计划
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存隐患计划
     */
    @RequiresPermissions("sysusersystem:troubleplan:add")
    @Log(title = "隐患计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzPlan jzPlan)
    {
        jzPlan.setCreateTime(DateUtils.getNowDate());
        jzPlan.setState("0");
        jzPlan.setPlanType(CoommonConstants.YINHUANGPAICHU);
        return toAjax(jzPlanService.insertJzPlan(jzPlan));
    }

    /**
     * 修改隐患计划
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        JzPlan jzPlan = jzPlanService.selectJzPlanById(planId);
        mmap.put("jzPlan", jzPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存隐患计划
     */
    @RequiresPermissions("sysusersystem:troubleplan:edit")
    @Log(title = "隐患计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzPlan jzPlan)
    {
        jzPlan.setUpdateId(ShiroUtils.getUserId());
        jzPlan.setPlanType(CoommonConstants.YINHUANGPAICHU);
        return toAjax(jzPlanService.updateJzPlan(jzPlan));
    }

    /**
     * 删除隐患计划
     */
    @RequiresPermissions("sysusersystem:troubleplan:remove")
    @Log(title = "隐患计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzPlanService.deleteJzPlanByIds(ids));
    }

    /**
     *  跳转到制定隐患项页面
     */
    @GetMapping("/detail/{dictId}")
    public String detail(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        mmap.put("dictId", dictId);
        return "sysusersystem/trouble/hiddentrouble";
    }
}
