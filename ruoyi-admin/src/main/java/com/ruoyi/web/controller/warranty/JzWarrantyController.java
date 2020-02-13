package com.ruoyi.web.controller.warranty;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISysDeptService;
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
import com.ruoyi.warranty.domain.JzWarranty;
import com.ruoyi.warranty.service.IJzWarrantyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报修Controller
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
@Controller
@RequestMapping("/warranty/warranty")
public class JzWarrantyController extends BaseController
{
    private String prefix = "warranty/warranty";

    @Autowired
    private IJzWarrantyService jzWarrantyService;

    @Autowired
    private ISysDeptService deptService;


    @RequiresPermissions("warranty:warranty:view")
    @GetMapping()
    public String warranty()
    {
        return prefix + "/warranty";
    }

    /**
     * 查询报修列表
     */
    @RequiresPermissions("warranty:warranty:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzWarranty jzWarranty)
    {
        startPage();
        List<JzWarranty> list = jzWarrantyService.selectJzWarrantyList(jzWarranty);
        return getDataTable(list);
    }

    /**
     * 导出报修列表
     */
    @RequiresPermissions("warranty:warranty:export")
    @Log(title = "报修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzWarranty jzWarranty)
    {
        List<JzWarranty> list = jzWarrantyService.selectJzWarrantyList(jzWarranty);
        ExcelUtil<JzWarranty> util = new ExcelUtil<JzWarranty>(JzWarranty.class);
        return util.exportExcel(list, "warranty");
    }

    /**
     * 新增报修
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报修
     */
    @RequiresPermissions("warranty:warranty:add")
    @Log(title = "报修", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzWarranty jzWarranty)
    {
        //jzWarranty.setSystemId(deptService.selectDeptIdByDeptName(treeName));
        jzWarranty.setCreateId(ShiroUtils.getUserId());
        return toAjax(jzWarrantyService.insertJzWarranty(jzWarranty));
    }

    /**
     * 修改报修
     */
    @GetMapping("/edit/{warrantyId}")
    public String edit(@PathVariable("warrantyId") Long warrantyId, ModelMap mmap)
    {
        JzWarranty jzWarranty = jzWarrantyService.selectJzWarrantyById(warrantyId);
//        SysDept dept =  deptService.selectDeptById(300L);
//        if(dept !=null){
//            // jzContract.setDept(dept);
//            mmap.put("dept", dept);
//        }
        mmap.put("jzWarranty", jzWarranty);
        return prefix + "/edit";
    }

    /**
     * 修改保存报修
     */
    @RequiresPermissions("warranty:warranty:edit")
    @Log(title = "报修", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzWarranty jzWarranty)
    {
        //jzWarranty.setSystemId(deptService.selectDeptIdByDeptName(treeName));
        jzWarranty.setUpdateId(ShiroUtils.getUserId());
        return toAjax(jzWarrantyService.updateJzWarranty(jzWarranty));
    }

    /**
     * 删除报修
     */
    @RequiresPermissions("warranty:warranty:remove")
    @Log(title = "报修", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzWarrantyService.deleteJzWarrantyByIds(ids));
    }
}
