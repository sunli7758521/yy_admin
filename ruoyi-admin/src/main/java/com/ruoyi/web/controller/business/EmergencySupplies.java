package com.ruoyi.web.controller.business;

import java.util.List;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.JzType;
import com.ruoyi.business.service.IJzTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 *  应急物资Controller
 * 
 * @author ljc
 * @date 2019-12-25
 */
@Controller
@RequestMapping("/business/emergencysupplies")
public class EmergencySupplies extends BaseController
{
    private String prefix = "business/emergencysupplies";

    @Autowired
    private IJzTypeService jzTypeService;

    @Autowired
    private ISysDeptService deptService;
    @RequiresPermissions("business:emergencysupplies:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询风险分类列表
     */
    @RequiresPermissions("business:emergencysupplies:list")
    @PostMapping("/list")
    @ResponseBody
    public List<JzType> list(JzType jzType)
    {
        //startPage();
        jzType.setClassificationState("1");
        List<JzType> list = jzTypeService.selectJzTypeList(jzType);
        return list;
    }

    /**
     * 导出风险分类列表
     */
    @RequiresPermissions("business:emergencysupplies:export")
    @Log(title = "风险分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzType jzType)
    {
        List<JzType> list = jzTypeService.selectJzTypeList(jzType);
        ExcelUtil<JzType> util = new ExcelUtil<JzType>(JzType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增风险分类
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable Long parentId,ModelMap mmap) {
        JzType dept = jzTypeService.selectJzTypeById(parentId);
        dept.setParentId(parentId);
        if(dept !=null){
            mmap.put("dept", dept);
        }
        return prefix + "/add";
    }
    /**
     * 新增保存部门
     */
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("business:emergencysupplies:add")
    @PostMapping("/add/{systemId}")
    @ResponseBody
    public AjaxResult addSave(@PathVariable Long systemId,JzType jzType)
    {
        jzType.setCreateId(ShiroUtils.getUserId());
        jzType.setSystemId(systemId);
        jzType.setClassificationState("1");
        return toAjax(jzTypeService.insertJzType(jzType));
    }

    /**
     * 修改风险分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzType jzType = jzTypeService.selectJzTypeById(id);
        jzType.setUpdateId(ShiroUtils.getUserId());
        mmap.put("jzType", jzType);
        return prefix + "/edit";
    }

    /**
     * 修改保存风险分类
     */
    @RequiresPermissions("business:emergencysupplies:edit")
    @Log(title = "风险分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzType jzType)
    {
        jzType.setUpdateId(ShiroUtils.getUserId());
        return toAjax(jzTypeService.updateJzType(jzType));
    }

    /**
     * 删除风险分类
     */
    @RequiresPermissions("business:emergencysupplies:remove")
    @Log(title = "风险分类", businessType = BusinessType.DELETE)
    //@PostMapping( "/remove/{ids}")
    @GetMapping("/remove/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("ids")String ids)
    {
        return toAjax(jzTypeService.deleteJzTypeByIds(ids));
    }
}
