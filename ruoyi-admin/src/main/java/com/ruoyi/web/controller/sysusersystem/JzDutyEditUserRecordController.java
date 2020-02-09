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
import com.ruoyi.sysusersystem.domain.JzDutyEditUserRecord;
import com.ruoyi.sysusersystem.service.IJzDutyEditUserRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 值班修改用户记录Controller
 * 
 * @author sunli
 * @date 2020-01-13
 */
@Controller
@RequestMapping("/sysusersystem/record")
public class JzDutyEditUserRecordController extends BaseController
{
    private String prefix = "sysusersystem/record";

    @Autowired
    private IJzDutyEditUserRecordService jzDutyEditUserRecordService;

    @RequiresPermissions("sysusersystem:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询值班修改用户记录列表
     */
    @RequiresPermissions("sysusersystem:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzDutyEditUserRecord jzDutyEditUserRecord)
    {
        startPage();
        List<JzDutyEditUserRecord> list = jzDutyEditUserRecordService.selectJzDutyEditUserRecordList(jzDutyEditUserRecord);
        return getDataTable(list);
    }

    /**
     * 导出值班修改用户记录列表
     */
    @RequiresPermissions("sysusersystem:record:export")
    @Log(title = "值班修改用户记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzDutyEditUserRecord jzDutyEditUserRecord)
    {
        List<JzDutyEditUserRecord> list = jzDutyEditUserRecordService.selectJzDutyEditUserRecordList(jzDutyEditUserRecord);
        ExcelUtil<JzDutyEditUserRecord> util = new ExcelUtil<JzDutyEditUserRecord>(JzDutyEditUserRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 新增值班修改用户记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存值班修改用户记录
     */
    @RequiresPermissions("sysusersystem:record:add")
    @Log(title = "值班修改用户记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzDutyEditUserRecord jzDutyEditUserRecord)
    {
        return toAjax(jzDutyEditUserRecordService.insertJzDutyEditUserRecord(jzDutyEditUserRecord));
    }

    /**
     * 修改值班修改用户记录
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap)
    {
        JzDutyEditUserRecord jzDutyEditUserRecord = jzDutyEditUserRecordService.selectJzDutyEditUserRecordById(recordId);
        mmap.put("jzDutyEditUserRecord", jzDutyEditUserRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存值班修改用户记录
     */
    @RequiresPermissions("sysusersystem:record:edit")
    @Log(title = "值班修改用户记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzDutyEditUserRecord jzDutyEditUserRecord)
    {
        return toAjax(jzDutyEditUserRecordService.updateJzDutyEditUserRecord(jzDutyEditUserRecord));
    }

    /**
     * 删除值班修改用户记录
     */
    @RequiresPermissions("sysusersystem:record:remove")
    @Log(title = "值班修改用户记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzDutyEditUserRecordService.deleteJzDutyEditUserRecordByIds(ids));
    }
}
