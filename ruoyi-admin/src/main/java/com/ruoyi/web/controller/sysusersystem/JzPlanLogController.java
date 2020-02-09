package com.ruoyi.web.controller.sysusersystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.sysusersystem.domain.*;
import com.ruoyi.sysusersystem.service.IJzHiddenTroubleLogService;
import com.ruoyi.sysusersystem.service.IJzInspectionLogService;
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
import com.ruoyi.sysusersystem.service.IJzPlanLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 制定计划日志Controller
 * 
 * @author sunli
 * @date 2020-01-09
 */
@Controller
@RequestMapping("/sysusersystem/planLog")
public class JzPlanLogController extends BaseController
{
    private String prefix = "sysusersystem/planLog";

    @Autowired
    private IJzPlanLogService jzPlanLogService;

    @Autowired
    private IJzInspectionLogService jzInspectionLogService;

    @Autowired
    private IJzHiddenTroubleLogService jzHiddenTroubleLogService;

    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IJzSysUserSystemService sysUserSystemService;

    @RequiresPermissions("sysusersystem:planlog:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询制定计划日志列表
     */
    @RequiresPermissions("sysusersystem:planlog:list")
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
        jzPlanLog.setPlanType("1");
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
     * 导出制定计划日志列表
     */
    @RequiresPermissions("sysusersystem:planlog:export")
    @Log(title = "制定计划日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzPlanLog jzPlanLog)
    {
        List<JzPlanLog> list = jzPlanLogService.selectJzPlanLogList(jzPlanLog);
        ExcelUtil<JzPlanLog> util = new ExcelUtil<JzPlanLog>(JzPlanLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增制定计划日志
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存制定计划日志
     */
    @RequiresPermissions("sysusersystem:planlog:add")
    @Log(title = "制定计划日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzPlanLog jzPlanLog)
    {
        return toAjax(jzPlanLogService.insertJzPlanLog(jzPlanLog));
    }

    /**
     * 修改制定计划日志
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        JzPlanLog jzPlanLog = jzPlanLogService.selectJzPlanLogById(planId);
        mmap.put("jzPlanLog", jzPlanLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存制定计划日志
     */
    @RequiresPermissions("sysusersystem:planlog:edit")
    @Log(title = "制定计划日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzPlanLog jzPlanLog)
    {
        return toAjax(jzPlanLogService.updateJzPlanLog(jzPlanLog));
    }

    /**
     * 删除制定计划日志
     */
    @RequiresPermissions("sysusersystem:planlog:remove")
    @Log(title = "制定计划日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzPlanLogService.deleteJzPlanLogByIds(ids));
    }

    /**
     * 修改制定计划
     */
    @GetMapping("/yunlan/{planId}/{createTime}/{planType}/{title}")
    public String yunlan(@PathVariable("planId") Long planId, @PathVariable("createTime") Date createTime , @PathVariable("planType") String planType, @PathVariable("title") String title,ModelMap mmap)
    {
        if (planType.equalsIgnoreCase("1")){
            JzInspectionLog log = new JzInspectionLog();
            log.setJzPlanId(planId);
            log.setCreateTime(createTime);
            List<JzInspectionLogVO> list = jzInspectionLogService.selectLogList(log);
            mmap.put("title",title);
            mmap.put("list",list);
        }else if(planType.equalsIgnoreCase("0")){

        }else if(planType.equalsIgnoreCase("2")){
            JzHiddenTroubleLog log = new JzHiddenTroubleLog();
            log.setPlanId(planId);
            log.setCreateTime(createTime);
            List<JzHiddenTroubleVO> list = jzHiddenTroubleLogService.selectHiddenTroubleLogList(log);
            mmap.put("title",title);
            mmap.put("list",list);

        }
        return prefix + "/formChart";
    }
}
