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
import com.ruoyi.equipment.domain.JzEquipmentSpecifications;
import com.ruoyi.equipment.service.IJzEquipmentSpecificationsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备规格Controller
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
@Controller
@RequestMapping("/equipment/specifications")
public class JzEquipmentSpecificationsController extends BaseController
{
    private String prefix = "equipment/specifications";

    @Autowired
    private IJzEquipmentSpecificationsService jzEquipmentSpecificationsService;

    @RequiresPermissions("equipment:specifications:view")
    @GetMapping()
    public String specifications()
    {
        return prefix + "/specifications";
    }

    /**
     * 查询设备规格列表
     */
    @RequiresPermissions("equipment:specifications:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        startPage();
        //List<JzEquipmentSpecifications> list = jzEquipmentSpecificationsService.selectJzEquipmentSpecificationsList(jzEquipmentSpecifications);
        List<JzEquipmentSpecifications> list = jzEquipmentSpecificationsService.selectJzEquipmentSpecificationsRepList(jzEquipmentSpecifications);
        return getDataTable(list);
    }

    /**
     * 导出设备规格列表
     */
    @RequiresPermissions("equipment:specifications:export")
    @Log(title = "设备规格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        List<JzEquipmentSpecifications> list = jzEquipmentSpecificationsService.selectJzEquipmentSpecificationsList(jzEquipmentSpecifications);
        ExcelUtil<JzEquipmentSpecifications> util = new ExcelUtil<JzEquipmentSpecifications>(JzEquipmentSpecifications.class);
        return util.exportExcel(list, "specifications");
    }

    /**
     * 新增设备规格
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备规格
     */
    @RequiresPermissions("equipment:specifications:add")
    @Log(title = "设备规格", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzEquipmentSpecifications jzEquipmentSpecifications)
    {

        jzEquipmentSpecifications.setCreateId(ShiroUtils.getUserId());
        jzEquipmentSpecifications.setState("0");
        return toAjax(jzEquipmentSpecificationsService.insertJzEquipmentSpecifications(jzEquipmentSpecifications));
    }

    /**
     * 修改设备规格
     */
    @GetMapping("/edit/{spId}")
    public String edit(@PathVariable("spId") Long spId, ModelMap mmap)
    {
        JzEquipmentSpecifications jzEquipmentSpecifications = jzEquipmentSpecificationsService.selectJzEquipmentSpecificationsById(spId);
        mmap.put("jzEquipmentSpecifications", jzEquipmentSpecifications);
        return prefix + "/edit";
    }

//    /**
//     * 修改保存设备规格
//     */
//    @RequiresPermissions("equipment:specifications:edit")
//    @Log(title = "设备规格", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(JzEquipmentSpecifications jzEquipmentSpecifications)
//    {
//        return toAjax(jzEquipmentSpecificationsService.updateJzEquipmentSpecifications(jzEquipmentSpecifications));
//    }
    /**
     * 修改保存设备规格
     */
    @RequiresPermissions("equipment:specifications:edit")
    @Log(title = "设备规格", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        return toAjax(jzEquipmentSpecificationsService.updateJzEquipmentSpecificationsRep(jzEquipmentSpecifications));
    }

    /**
     * 删除设备规格
     */
    @RequiresPermissions("equipment:specifications:remove")
    @Log(title = "设备规格", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzEquipmentSpecificationsService.deleteJzEquipmentSpecificationsByIds(ids));
    }
}
