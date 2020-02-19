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
import com.ruoyi.sysusersystem.domain.JzWarrantyWx;
import com.ruoyi.sysusersystem.service.IJzWarrantyWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修记录Controller
 * 
 * @author sunli
 * @date 2020-02-19
 */
@Controller
@RequestMapping("/sysusersystem/wx")
public class JzWarrantyWxController extends BaseController
{
    private String prefix = "sysusersystem/wx";

    @Autowired
    private IJzWarrantyWxService jzWarrantyWxService;

    @RequiresPermissions("sysusersystem:wx:view")
    @GetMapping()
    public String wx()
    {
        return prefix + "/wx";
    }

    /**
     * 查询维修记录列表
     */
    @RequiresPermissions("sysusersystem:wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzWarrantyWx jzWarrantyWx)
    {
        startPage();
        List<JzWarrantyWx> list = jzWarrantyWxService.selectJzWarrantyWxList(jzWarrantyWx);
        return getDataTable(list);
    }

    /**
     * 导出维修记录列表
     */
    @RequiresPermissions("sysusersystem:wx:export")
    @Log(title = "维修记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzWarrantyWx jzWarrantyWx)
    {
        List<JzWarrantyWx> list = jzWarrantyWxService.selectJzWarrantyWxList(jzWarrantyWx);
        ExcelUtil<JzWarrantyWx> util = new ExcelUtil<JzWarrantyWx>(JzWarrantyWx.class);
        return util.exportExcel(list, "wx");
    }

//    /**
//     * 新增维修记录
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
    /**
     * 新增维修记录
     */
    @GetMapping("/add/{planId}")
    public String add(@PathVariable Long planId,ModelMap mmp)
    {
        mmp.put("planId",planId);
        return prefix + "/add";
    }

    /**
     * 新增保存维修记录
     */
    @RequiresPermissions("sysusersystem:wx:add")
    @Log(title = "维修记录", businessType = BusinessType.INSERT)
    @PostMapping("/add/{warId}")
    @ResponseBody
    public AjaxResult addSave(@PathVariable Long warId, JzWarrantyWx jzWarrantyWx)
    {
        jzWarrantyWx.setWarrantyId(warId);
        return toAjax(jzWarrantyWxService.insertJzWarrantyWx(jzWarrantyWx));
    }

    /**
     * 修改维修记录
     */
    @GetMapping("/edit/{wxId}")
    public String edit(@PathVariable("wxId") Long wxId, ModelMap mmap)
    {
        JzWarrantyWx jzWarrantyWx = jzWarrantyWxService.selectJzWarrantyWxById(wxId);
        mmap.put("jzWarrantyWx", jzWarrantyWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存维修记录
     */
    @RequiresPermissions("sysusersystem:wx:edit")
    @Log(title = "维修记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit/{warId}")
    @ResponseBody
    public AjaxResult editSave(@PathVariable Long warId, JzWarrantyWx jzWarrantyWx)
    {
        jzWarrantyWx.setWarrantyId(warId);
        return toAjax(jzWarrantyWxService.updateJzWarrantyWx(jzWarrantyWx));
    }

    /**
     * 删除维修记录
     */
    @RequiresPermissions("sysusersystem:wx:remove")
    @Log(title = "维修记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzWarrantyWxService.deleteJzWarrantyWxByIds(ids));
    }
}
