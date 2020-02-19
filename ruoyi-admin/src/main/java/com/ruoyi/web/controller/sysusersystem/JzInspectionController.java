package com.ruoyi.web.controller.sysusersystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.service.IJzPlanService;
import org.apache.ibatis.annotations.Param;
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
import com.ruoyi.sysusersystem.domain.JzInspection;
import com.ruoyi.sysusersystem.service.IJzInspectionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模板巡检项Controller
 * 
 * @author ljc
 * @date 2019-12-30
 * ljc
 */
@Controller
@RequestMapping("/sysusersystem/inspection")
public class JzInspectionController extends BaseController
{
    private String prefix = "sysusersystem/inspection";

    @Autowired
    private IJzInspectionService jzInspectionService;

    @Autowired
    private IJzPlanService jzPlanService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private IJzSysUserSystemService sysUserSystemService;

    @GetMapping("selectSystemName/{systemId}")
    public String selectSystemName(@PathVariable Long systemId){
        jzInspectionService.selectSystemName(systemId);
        return "";
    }
    @RequiresPermissions("sysusersystem:inspection:view")
    @GetMapping()
    public String inspection()
    {
        return prefix + "/hiddenplan";
    }
    /**
     * 查询模板巡检项列表
     */
    @RequiresPermissions("sysusersystem:inspection:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzInspection jzInspection)
    {
        startPage();
        List<JzInspection> list = jzInspectionService.selectJzInspectionList(jzInspection);
        return getDataTable(list);
//        List<JzInspection> list = new ArrayList<>();
//        Long userId = ShiroUtils.getUserId();
//        SysUser user = sysUserService.selectUserById(userId);
//        Set<String> roles = roleService.selectRoleKeys(user.getUserId());
//        String id ="";
//        // 超级管理员
//        if(user.getSearchSystemId()==0){
//            if(user.isAdmin()){
//                list =  jzInspectionService.selectJzInspectionList(jzInspection);
//                // 大班长
//            }else if(roles.contains("dbz")){
//                List<JzSysUserSystem>  systemIds = sysUserSystemService.selectByUserId(user.getUserId());
//                for (JzSysUserSystem systemId : systemIds) {
//                    id+=systemId.getSystemId()+",";
//                }
//                list = jzInspectionService.selectDbInspectionList(id,
//                        jzInspection.getEquipmentState(),jzInspection.getState(),
//                        jzInspection.getJcStartDate(),jzInspection.getJcEndDate(),
//                        jzInspection.getJcPeople(),jzInspection.getInspectionProject(),jzInspection.getContent());
//
//            }else{
//                // 普通角色
//                jzInspection.setSystemId(user.getSystemId());
//                list =  jzInspectionService.selectJzInspectionList(jzInspection);
//            }
//        }else{
//            jzInspection.setSystemId(user.getSearchSystemId());
//            list =  jzInspectionService.selectJzInspectionList(jzInspection);
//        }
//
//
//
//        return getDataTable(list);
    }

    /**
     * 导出模板巡检项列表
     */
    @RequiresPermissions("sysusersystem:inspection:export")
    @Log(title = "模板巡检项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzInspection jzInspection)
    {
        List<JzInspection> list = jzInspectionService.selectJzInspectionList(jzInspection);
        ExcelUtil<JzInspection> util = new ExcelUtil<JzInspection>(JzInspection.class);
        return util.exportExcel(list, "inspection");
    }

    /**
     * 新增模板巡检项
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") long Id,ModelMap mmap)
    {
        JzPlan jzPlan = jzPlanService.selectJzPlanById(Id);
        mmap.put("jzPlan",jzPlan);
        return prefix + "/add";
    }

    /**
     * 新增保存模板巡检项
     */
    @RequiresPermissions("sysusersystem:inspection:add")
    @Log(title = "模板巡检项", businessType = BusinessType.INSERT)
    @PostMapping("/add/{planId}")
    @ResponseBody
    public AjaxResult addSave(@PathVariable Long planId,JzInspection jzInspection)
    {
        jzInspection.setCreateId(ShiroUtils.getUserId());
        jzInspection.setCreateTime(DateUtils.getNowDate());
        jzInspection.setJzPlanId(planId);
        return toAjax(jzInspectionService.insertJzInspection(jzInspection));
    }

    /**
     * 预览模板巡检项
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzInspection jzInspection = jzInspectionService.selectJzInspectionById(id);
        mmap.put("jzInspection", jzInspection);
        return prefix + "/edit";
    }

    /**
     * 修改保存模板巡检项
     */
    @RequiresPermissions("sysusersystem:inspection:edit")
    @Log(title = "模板巡检项", businessType = BusinessType.UPDATE)
    @PostMapping("/edit/{planId}")
    @ResponseBody
    public AjaxResult editSave(@PathVariable Long planId,JzInspection jzInspection)
    {
        jzInspection.setUpdateTime(DateUtils.getNowDate());
        jzInspection.setUpdateId(ShiroUtils.getUserId());
        jzInspection.setJzPlanId(planId);
        return toAjax(jzInspectionService.updateJzInspection(jzInspection));
    }

    /**
     * 删除模板巡检项
     */
    @RequiresPermissions("sysusersystem:inspection:remove")
    @Log(title = "模板巡检项", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzInspectionService.deleteJzInspectionByIds(ids));
    }

    /**
     * 预览模板巡检项
     */
    @GetMapping("/yulan/{id}")
    public String yulan(@PathVariable("id") Long id, ModelMap mmap)
    {
//        JzInspection jzInspection = jzInspectionService.selectJzInspectionById(id);
//        mmap.put("jzInspection", jzInspection);
        JzInspection jzInspection = new JzInspection();
        jzInspection.setJzPlanId(id);
        List<JzInspection> list = jzInspectionService.selectJzInspectionList(jzInspection);
        mmap.put("list", list);
        return prefix + "/edit";
    }
}
