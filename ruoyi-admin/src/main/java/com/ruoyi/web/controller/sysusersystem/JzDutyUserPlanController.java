package com.ruoyi.web.controller.sysusersystem;

import java.util.List;

import com.ruoyi.common.constant.CoommonConstants;
import com.ruoyi.framework.util.ShiroUtils;
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
 * 制定计划Controller
 * 
 * @author sunli
 * @date 2019-12-31
 */
@Controller
@RequestMapping("/sysusersystem/userplan")
public class JzDutyUserPlanController extends BaseController
{
    private String prefix = "sysusersystem/userplan";

    @Autowired
    private IJzPlanService jzPlanService;

    @RequiresPermissions("sysusersystem:userplan:view")
    @GetMapping()
    public String plan()
    {
        return prefix + "/userplan";
    }
    /**
     * 查询制定计划列表
     */
    @RequiresPermissions("sysusersystem:userpaln:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzPlan jzPlan)
    {
        startPage();
        List<JzPlan> list = null;
        jzPlan.setPlanType("0");
        list=  jzPlanService.selectJzPlanList(jzPlan);
        return getDataTable(list);
    }

    /**
     * 导出制定计划列表
     */
    @RequiresPermissions("sysusersystem:userplan:export")
    @Log(title = "制定计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzPlan jzPlan)
    {
        List<JzPlan> list = jzPlanService.selectJzPlanList(jzPlan);
        ExcelUtil<JzPlan> util = new ExcelUtil<JzPlan>(JzPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 新增制定计划
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存制定计划
     */
    @RequiresPermissions("sysusersystem:userplan:add")
    @Log(title = "制定计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzPlan jzPlan)
    {
        jzPlan.setCreateId(ShiroUtils.getUserId());
        jzPlan.setPlanType(CoommonConstants.ZHIBAN);
        jzPlan.setState("0 ");
        return toAjax(jzPlanService.insertJzPlan(jzPlan));
    }

    /**
     * 修改制定计划
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        JzPlan jzPlan = jzPlanService.selectJzPlanById(planId);
        mmap.put("jzPlan", jzPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存制定计划
     */
    @RequiresPermissions("sysusersystem:userplan:edit")
    @Log(title = "制定计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzPlan jzPlan)
    {
        jzPlan.setPlanType("0");
        jzPlan.setUpdateId(ShiroUtils.getUserId());
        jzPlan.setPlanType(CoommonConstants.ZHIBAN);
        return toAjax(jzPlanService.updateJzPlan(jzPlan));
    }

    /**
     * 删除制定计划
     */
    @RequiresPermissions("sysusersystem:userplan:remove")
    @Log(title = "制定计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzPlanService.deleteJzPlanByIds(ids));
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/detail/{dictId}")
    public String detail(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        JzPlan jzPlan = new JzPlan();
        jzPlan = jzPlanService.selectJzPlanById(dictId);
//        List<JzPlan> list = jzPlanService.selectJzPlanList(jzPlan);
        mmap.put("jzPlan",jzPlan);
        return "sysusersystem/userLog/hiddenuser";
    }
}
