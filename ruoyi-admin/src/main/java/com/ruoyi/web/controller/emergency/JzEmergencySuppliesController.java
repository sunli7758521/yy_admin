package com.ruoyi.web.controller.emergency;

import java.util.List;

import com.ruoyi.emergency.domain.JzEmergencyPlan;
import com.ruoyi.emergency.service.IJzEmergencyPlanService;
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
import com.ruoyi.emergency.domain.JzEmergencySupplies;
import com.ruoyi.emergency.service.IJzEmergencySuppliesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应急方案关联物资Controller
 *
 * @author sunli
 * @date 2020-01-04
 */
@Controller
@RequestMapping("/emergency/supplies")
public class JzEmergencySuppliesController extends BaseController
{
    private String prefix = "emergency/supplies";

    @Autowired
    private IJzEmergencySuppliesService jzEmergencySuppliesService;

    @Autowired
    private IJzEmergencyPlanService jzEmergencyPlanService;
    @RequiresPermissions("emergency:supplies:view")
    @GetMapping()
    public String supplies()
    {
        return prefix + "/supplies";
    }

    /**
     * 查询应急方案关联物资列表
     */
    @RequiresPermissions("emergency:supplies:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzEmergencySupplies jzEmergencySupplies)
    {
        startPage();
        List<JzEmergencySupplies> list = jzEmergencySuppliesService.selectJzEmergencySuppliesList(jzEmergencySupplies);
        return getDataTable(list);
    }

    /**
     * 导出应急方案关联物资列表
     */
    @RequiresPermissions("emergency:supplies:export")
    @Log(title = "应急方案关联物资", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzEmergencySupplies jzEmergencySupplies)
    {
        List<JzEmergencySupplies> list = jzEmergencySuppliesService.selectJzEmergencySuppliesList(jzEmergencySupplies);
        ExcelUtil<JzEmergencySupplies> util = new ExcelUtil<JzEmergencySupplies>(JzEmergencySupplies.class);
        return util.exportExcel(list, "supplies");
    }

//    /**
//     * 新增应急方案关联物资
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
    @GetMapping("/add/{planId}")
    public String add(@PathVariable Long planId, ModelMap mmap)
    {
        JzEmergencyPlan jzEmergencyPlan = jzEmergencyPlanService.selectJzEmergencyPlanById(planId);
        mmap.put("jzEmergencyPlan",jzEmergencyPlan);
        return prefix + "/add";
    }
    /**
     * 新增保存应急方案关联物资
     */
    @RequiresPermissions("emergency:supplies:add")
    @Log(title = "应急方案关联物资", businessType = BusinessType.INSERT)
    @PostMapping("/add/{planId}")
    @ResponseBody
    public AjaxResult addSave(@PathVariable Long planId,JzEmergencySupplies jzEmergencySupplies)
    {
        jzEmergencySupplies.setPlanId(planId.toString());
        jzEmergencySupplies.setCreateId(ShiroUtils.getUserId());
        jzEmergencySupplies.setPlanId(planId.toString());
        jzEmergencySupplies.setState("0");
        return toAjax(jzEmergencySuppliesService.insertJzEmergencySupplies(jzEmergencySupplies));
    }

    /**
     * 修改应急方案关联物资
     */
    @GetMapping("/edit/{suppliseId}")
    public String edit(@PathVariable("suppliseId") Long suppliseId, ModelMap mmap)
    {
        JzEmergencySupplies jzEmergencySupplies = jzEmergencySuppliesService.selectJzEmergencySuppliesById(suppliseId);
        mmap.put("jzEmergencySupplies", jzEmergencySupplies);
        return prefix + "/edit";
    }

    /**
     * 修改保存应急方案关联物资
     */
    @RequiresPermissions("emergency:supplies:edit")
    @Log(title = "应急方案关联物资", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzEmergencySupplies jzEmergencySupplies)
    {
        return toAjax(jzEmergencySuppliesService.updateJzEmergencySupplies(jzEmergencySupplies));
    }

    /**
     * 删除应急方案关联物资
     */
    @RequiresPermissions("emergency:supplies:remove")
    @Log(title = "应急方案关联物资", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzEmergencySuppliesService.deleteJzEmergencySuppliesByIds(ids));
    }
}
