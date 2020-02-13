package com.ruoyi.web.controller.sysusersystem;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.CoommonConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.juser.domain.JzUser;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.sysusersystem.domain.*;
import com.ruoyi.sysusersystem.service.IJzHiddenTroubleLogService;
import com.ruoyi.sysusersystem.service.IJzHiddenTroubleService;
import com.ruoyi.sysusersystem.service.IJzPlanLogService;
import com.ruoyi.sysusersystem.service.IJzPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *  隐患任务Controller
 * 
 * @author sunli
 * @date 2019-12-31
 */
@Controller
@RequestMapping("/sysusersystem/hiddenPlan")
public class JzHiddenPlanController extends BaseController
{
    private String prefix = "sysusersystem/hiddenPlan";

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private IJzSysUserSystemService sysUserSystemService;

    @Autowired
    private IJzPlanService jzPlanService;

    @Autowired
    private IJzPlanLogService jzPlanLogService;

    @Autowired
    private IJzHiddenTroubleService jzHiddenTroubleService;

    @Autowired
    private IJzHiddenTroubleLogService jzHiddenTroubleLogService;

    @RequiresPermissions("sysusersystem:hiddenPlan:view")
    @GetMapping()
    public String plan()
    {
        return prefix + "/hiddenPlan";
    }
    /**
     * 查询隐患任务                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       列表
     */
    @RequiresPermissions("sysusersystem:hiddenPlan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzPlanLog jzPlanLog)
    {
        startPage();
        List<JzPlanLog> list = new ArrayList<>();
        Long userId = ShiroUtils.getUserId();
        SysUser user = sysUserService.selectUserById(userId);
        Set<String> roles = roleService.selectRoleKeys(user.getUserId());
        String id ="";
        jzPlanLog.setPlanType("2");
        if(user.getSearchSystemId()==0){
//            超级管理员
            if(user.isAdmin()){
                list=jzPlanLogService.selectJzPlanLogList(jzPlanLog);
            }else if(roles.contains("dbz")){
                List<JzSysUserSystem>  systemIds = sysUserSystemService.selectByUserId(user.getUserId());
                for (JzSysUserSystem systemId : systemIds) {
                    id+=systemId.getSystemId()+",";
                }
                list=jzPlanLogService.selectDbzLogList(id,
                        jzPlanLog.getLongTime(),jzPlanLog.getState());
            }else{
                // 普通角色
                jzPlanLog.setSystemId(user.getSystemId());
                list=jzPlanLogService.selectJzPlanLogList(jzPlanLog);
            }
        } else{
            jzPlanLog.setSystemId(user.getSearchSystemId());
            list=jzPlanLogService.selectJzPlanLogList(jzPlanLog);
        }

            return getDataTable(list);
    }

    /**
     * 导出隐患任务列表
     */
    @RequiresPermissions("sysusersystem:hiddenPlan:export")
    @Log(title = "隐患任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzPlan jzPlan)
    {
        List<JzPlan> list = jzPlanService.selectJzPlanList(jzPlan);
        ExcelUtil<JzPlan> util = new ExcelUtil<JzPlan>(JzPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 新增隐患任务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存隐患任务
     */
    @RequiresPermissions("sysusersystem:hiddenPlan:add")
    @Log(title = "隐患任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzPlan jzPlan)
    {
        jzPlan.setCreateId(ShiroUtils.getUserId());
        jzPlan.setPlanType(CoommonConstants.XUNJIAN);
        jzPlan.setState("0 ");
        return toAjax(jzPlanService.insertJzPlan(jzPlan));
    }

    /**
     * 修改隐患任务
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        JzPlan jzPlan = jzPlanService.selectJzPlanById(planId);
        mmap.put("jzPlan", jzPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存隐患任务
     */
    @RequiresPermissions("sysusersystem:hiddenPlan:edit")
    @Log(title = "隐患任务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzPlan jzPlan)
    {
        jzPlan.setPlanType("1");
        jzPlan.setUpdateId(ShiroUtils.getUserId());
        jzPlan.setPlanType(CoommonConstants.XUNJIAN);
        return toAjax(jzPlanService.updateJzPlan(jzPlan));
    }

    /**
     * 删除隐患任务
     */
    @RequiresPermissions("sysusersystem:hiddenPlan:remove")
    @Log(title = "隐患任务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzPlanService.deleteJzPlanByIds(ids));
    }


    /**
     * 预览隐患项  TODO
     */
    @GetMapping("/yulan/{planId}/{createTime}/{title}")
//    @RequiresPermissions("sysusersystem:hiddenPlan:yulan")
    public String yunlan(@PathVariable("planId") Long planId, @PathVariable("createTime") Date createTime , @PathVariable("title") String title,ModelMap mmap)
    {
        JzHiddenTroubleLog log = new JzHiddenTroubleLog();
        log.setPlanId(planId);
        log.setCreateTime(createTime);
        List<JzHiddenTroubleVO> list = jzHiddenTroubleLogService.selectHiddenTroubleLogList(log);

        mmap.put("title",title);
        mmap.put("list",list);
        return prefix + "/formChart";
    }

}
