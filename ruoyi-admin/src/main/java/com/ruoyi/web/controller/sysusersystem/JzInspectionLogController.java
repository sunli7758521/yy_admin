package com.ruoyi.web.controller.sysusersystem;

import java.util.List;
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
import com.ruoyi.sysusersystem.domain.JzInspectionLog;
import com.ruoyi.sysusersystem.service.IJzInspectionLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 巡检日志Controller
 * 
 * @author sunli
 * @date 2020-01-09
 */
@Controller
@RequestMapping("/sysusersystem/inspectionLog")
public class JzInspectionLogController extends BaseController
{
    private String prefix = "sysusersystem/inspectionLog";

    @Autowired
    private IJzInspectionLogService jzInspectionLogService;

    @RequiresPermissions("sysusersystem:inspectionLog:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询巡检日志列表
     */
    @RequiresPermissions("sysusersystem:inspectionLog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzInspectionLog jzInspectionLog)
    {
        startPage();
        List<JzInspectionLog> list = jzInspectionLogService.selectJzInspectionLogList(jzInspectionLog);
        return getDataTable(list);
    }

    /**
     * 导出巡检日志列表
     */
    @RequiresPermissions("sysusersystem:inspectionLog:export")
    @Log(title = "巡检日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzInspectionLog jzInspectionLog)
    {
        List<JzInspectionLog> list = jzInspectionLogService.selectJzInspectionLogList(jzInspectionLog);
        ExcelUtil<JzInspectionLog> util = new ExcelUtil<JzInspectionLog>(JzInspectionLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增巡检日志
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存巡检日志
     */
    @RequiresPermissions("sysusersystem:inspectionLog:add")
    @Log(title = "巡检日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzInspectionLog jzInspectionLog)
    {
        return toAjax(jzInspectionLogService.insertJzInspectionLog(jzInspectionLog));
    }

    /**
     * 修改巡检日志
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzInspectionLog jzInspectionLog = jzInspectionLogService.selectJzInspectionLogById(id);
        mmap.put("jzInspectionLog", jzInspectionLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检日志
     */
    @RequiresPermissions("sysusersystem:inspectionLog:edit")
    @Log(title = "巡检日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzInspectionLog jzInspectionLog)
    {
        return toAjax(jzInspectionLogService.updateJzInspectionLog(jzInspectionLog));
    }

    /**
     * 删除巡检日志
     */
    @RequiresPermissions("sysusersystem:inspectionLog:remove")
    @Log(title = "巡检日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzInspectionLogService.deleteJzInspectionLogByIds(ids));
    }
}
