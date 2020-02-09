package com.ruoyi.web.controller.sysusersystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.juser.domain.JzUser;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.sysusersystem.domain.JzInspection;
import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.service.IJzPlanService;
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
import com.ruoyi.sysusersystem.domain.JzHiddenTrouble;
import com.ruoyi.sysusersystem.service.IJzHiddenTroubleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 隐患Controller
 * 
 * @author sunli
 * @date 2020-01-06
 */
@Controller
@RequestMapping("/sysusersystem/hiddentrouble")
public class JzHiddenTroubleController extends BaseController
{
    private String prefix = "sysusersystem/trouble";

    @Autowired
    private IJzHiddenTroubleService jzHiddenTroubleService;

    @Autowired
    private IJzPlanService jzPlanService;

    @RequiresPermissions("sysusersystem:hiddentrouble:view")
    @GetMapping()
    public String trouble()
    {
        return prefix + "/trouble";
    }

    /**
     * 查询隐患列表
     */
    @RequiresPermissions("sysusersystem:hiddentrouble:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzHiddenTrouble jzHiddenTrouble)
    {
        startPage();
        List<JzHiddenTrouble> list = jzHiddenTroubleService.selectJzHiddenTroubleList(jzHiddenTrouble);
        return getDataTable(list);
    }

//    /**
//     * 查询制定计划列表
//     */
//    @RequiresPermissions("sysusersystem:troubleplan:selectlist")
//    @PostMapping("/list1")
//    @ResponseBody
//    public TableDataInfo list1(JzInspection jzInspection)
//    {
//        startPage();
//        List<JzInspection> list = null;
//
//        list =  jzInspectionService.selectJzInspectionList(jzInspection);
//        return getDataTable(list);
//    }

    /**
     * 导出隐患列表
     */
    @RequiresPermissions("sysusersystem:hiddentrouble:export")
    @Log(title = "隐患", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzHiddenTrouble jzHiddenTrouble)
    {
        List<JzHiddenTrouble> list = jzHiddenTroubleService.selectJzHiddenTroubleList(jzHiddenTrouble);
        ExcelUtil<JzHiddenTrouble> util = new ExcelUtil<JzHiddenTrouble>(JzHiddenTrouble.class);
        return util.exportExcel(list, "trouble");
    }

    /**
     * 新增隐患
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") long Id,ModelMap mmap)
    {
        JzPlan jzPlan = jzPlanService.selectJzPlanById(Id);
        mmap.put("jzPlan",jzPlan);
        return prefix + "/add";
    }

    /**
     * 新增保存隐患
     */
    @RequiresPermissions("sysusersystem:hiddentrouble:add")
    @Log(title = "隐患", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzHiddenTrouble jzHiddenTrouble)
    {
//        jzHiddenTrouble.setPlanId(planId);
        jzHiddenTrouble.setCreateTime(DateUtils.getNowDate());
        jzHiddenTrouble.setCreateBy(ShiroUtils.getLoginName());
//        jzHiddenTrouble.setRectificationTime(DateUtils.getNowDate().toString());
        //检查人
//        jzHiddenTrouble.setIdentifyPeople(ShiroUtils.getLoginName());
        return toAjax(jzHiddenTroubleService.insertJzHiddenTrouble(jzHiddenTrouble));
    }

    /**
     * 修改隐患
     */
    @GetMapping("/edit/{hiddenTroubleId}")
    public String edit(@PathVariable("hiddenTroubleId") Long hiddenTroubleId, ModelMap mmap)
    {
        JzHiddenTrouble jzHiddenTrouble = jzHiddenTroubleService.selectJzHiddenTroubleById(hiddenTroubleId);
        mmap.put("jzHiddenTrouble", jzHiddenTrouble);
        return prefix + "/edit";
    }

    /**
     * 修改保存隐患
     */
    @RequiresPermissions("sysusersystem:hiddentrouble:edit")
    @Log(title = "隐患", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzHiddenTrouble jzHiddenTrouble)
    {
       // jzHiddenTrouble.setPlanId(planId);
        return toAjax(jzHiddenTroubleService.updateJzHiddenTrouble(jzHiddenTrouble));
    }

    /**
     * 删除隐患
     */
    @RequiresPermissions("sysusersystem:hiddentrouble:remove")
    @Log(title = "隐患", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzHiddenTroubleService.deleteJzHiddenTroubleByIds(ids));
    }
}
