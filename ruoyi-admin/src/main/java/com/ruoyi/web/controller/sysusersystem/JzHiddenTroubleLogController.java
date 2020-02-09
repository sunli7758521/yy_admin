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
import com.ruoyi.sysusersystem.domain.JzHiddenTroubleLog;
import com.ruoyi.sysusersystem.service.IJzHiddenTroubleLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 隐患日志Controller
 * 
 * @author sunli
 * @date 2020-01-11
 */
@Controller
@RequestMapping("/sysusersystem/hiddenTroubleLog")
public class JzHiddenTroubleLogController extends BaseController
{
    private String prefix = "sysusersystem/hiddenTroubleLog";

    @Autowired
    private IJzHiddenTroubleLogService jzHiddenTroubleLogService;

    @RequiresPermissions("sysusersystem:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/hiddenTroubleLog";
    }

    /**
     * 查询隐患日志列表
     */
    @RequiresPermissions("sysusersystem:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzHiddenTroubleLog jzHiddenTroubleLog)
    {
        startPage();
        List<JzHiddenTroubleLog> list = jzHiddenTroubleLogService.selectJzHiddenTroubleLogList(jzHiddenTroubleLog);
        return getDataTable(list);
    }

    /**
     * 导出隐患日志列表
     */
    @RequiresPermissions("sysusersystem:log:export")
    @Log(title = "隐患日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzHiddenTroubleLog jzHiddenTroubleLog)
    {
        List<JzHiddenTroubleLog> list = jzHiddenTroubleLogService.selectJzHiddenTroubleLogList(jzHiddenTroubleLog);
        ExcelUtil<JzHiddenTroubleLog> util = new ExcelUtil<JzHiddenTroubleLog>(JzHiddenTroubleLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增隐患日志
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存隐患日志
     */
    @RequiresPermissions("sysusersystem:log:add")
    @Log(title = "隐患日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzHiddenTroubleLog jzHiddenTroubleLog)
    {
        return toAjax(jzHiddenTroubleLogService.insertJzHiddenTroubleLog(jzHiddenTroubleLog));
    }

    /**
     * 修改隐患日志
     */
    @GetMapping("/edit/{hiddenTroubleId}")
    public String edit(@PathVariable("hiddenTroubleId") Long hiddenTroubleId, ModelMap mmap)
    {
        JzHiddenTroubleLog jzHiddenTroubleLog = jzHiddenTroubleLogService.selectJzHiddenTroubleLogById(hiddenTroubleId);
        mmap.put("jzHiddenTroubleLog", jzHiddenTroubleLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存隐患日志
     */
    @RequiresPermissions("sysusersystem:log:edit")
    @Log(title = "隐患日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzHiddenTroubleLog jzHiddenTroubleLog)
    {
        return toAjax(jzHiddenTroubleLogService.updateJzHiddenTroubleLog(jzHiddenTroubleLog));
    }

    /**
     * 删除隐患日志
     */
    @RequiresPermissions("sysusersystem:log:remove")
    @Log(title = "隐患日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzHiddenTroubleLogService.deleteJzHiddenTroubleLogByIds(ids));
    }
}
