package com.ruoyi.web.controller.equipment;

import java.util.List;

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
import com.ruoyi.equipment.domain.JzEquipmentRep;
import com.ruoyi.equipment.service.IJzEquipmentRepService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备备品件库Controller
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
@Controller
@RequestMapping("/equipment/rep")
public class JzEquipmentRepController extends BaseController
{
    private String prefix = "equipment/rep";

    @Autowired
    private IJzEquipmentRepService jzEquipmentRepService;

    @RequiresPermissions("equipment:rep:view")
    @GetMapping()
    public String rep()
    {
        return prefix + "/rep";
    }

    /**
     * 查询设备备品件库列表
     */
    @RequiresPermissions("equipment:rep:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzEquipmentRep jzEquipmentRep)
    {
        startPage();
        List<JzEquipmentRep> list = jzEquipmentRepService.selectJzEquipmentRepList(jzEquipmentRep);
        return getDataTable(list);
    }

    /**
     * 导出设备备品件库列表
     */
    @RequiresPermissions("equipment:rep:export")
    @Log(title = "设备备品件库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzEquipmentRep jzEquipmentRep)
    {
        List<JzEquipmentRep> list = jzEquipmentRepService.selectJzEquipmentRepList(jzEquipmentRep);
        ExcelUtil<JzEquipmentRep> util = new ExcelUtil<JzEquipmentRep>(JzEquipmentRep.class);
        return util.exportExcel(list, "rep");
    }

    /**
     * 新增设备备品件库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备备品件库
     */
    @RequiresPermissions("equipment:rep:add")
    @Log(title = "设备备品件库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzEquipmentRep jzEquipmentRep)
    {
        jzEquipmentRep.setCreateId(ShiroUtils.getUserId());
        return toAjax(jzEquipmentRepService.insertJzEquipmentRep(jzEquipmentRep));
    }

    /**
     * 修改设备备品件库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzEquipmentRep jzEquipmentRep = jzEquipmentRepService.selectJzEquipmentRepById(id);
        mmap.put("jzEquipmentRep", jzEquipmentRep);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备备品件库
     */
    @RequiresPermissions("equipment:rep:edit")
    @Log(title = "设备备品件库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzEquipmentRep jzEquipmentRep)
    {
        return toAjax(jzEquipmentRepService.updateJzEquipmentRep(jzEquipmentRep));
    }

    /**
     * 删除设备备品件库
     */
    @RequiresPermissions("equipment:rep:remove")
    @Log(title = "设备备品件库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzEquipmentRepService.deleteJzEquipmentRepByIds(ids));
    }
}
