package com.ruoyi.web.controller.business;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
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
import com.ruoyi.business.domain.JzType;
import com.ruoyi.business.service.IJzTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 隐患分类Controller
 * 
 * @author ljc
 * @date 2019-12-25
 */
@Controller
@RequestMapping("/business/hazardhlassification")
public class HazardClassification extends BaseController
{
    private String prefix = "business/hazardhlassification";

    @Autowired
    private IJzTypeService jzTypeService;

    @RequiresPermissions("business:hazardhlassification:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询隐患分类列表
     */
    @RequiresPermissions("business:hazardhlassification:list")
    @PostMapping("/list")
    @ResponseBody
    public List<JzType> list(JzType jzType)
    {
        //startPage();
        jzType.setClassificationState("2");
        List<JzType> list = jzTypeService.selectJzTypeList(jzType);
        return list;
    }

    /**
     * 导出隐患分类列表
     */
    @RequiresPermissions("business:hazardhlassification:export")
    @Log(title = "隐患分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzType jzType)
    {
        List<JzType> list = jzTypeService.selectJzTypeList(jzType);
        ExcelUtil<JzType> util = new ExcelUtil<JzType>(JzType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增隐患分类
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable Long parentId,ModelMap mmap)
    {
        JzType dept = jzTypeService.selectJzTypeById(parentId);
        dept.setParentId(parentId);
        if(dept !=null){
            mmap.put("dept", dept);
        }
        return prefix + "/add";
    }

    /**
     * 新增保存隐患分类
     */
    @RequiresPermissions("business:hazardhlassification:add")
    @Log(title = "隐患分类", businessType = BusinessType.INSERT)
    @PostMapping("/add/{systemId}")
    @ResponseBody
    public AjaxResult addSave(@PathVariable Long systemId,JzType jzType)
    {
        jzType.setCreateId(ShiroUtils.getUserId());
        jzType.setSystemId(systemId);
        jzType.setClassificationState("2");
        return toAjax(jzTypeService.insertJzType(jzType));
    }
    /**
     * 修改隐患分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
//        JzType jzType = jzTypeService.selectJzTypeByParentId(id);
        JzType jzType = jzTypeService.selectJzTypeById(id);
        jzType.setUpdateId(ShiroUtils.getUserId());
        jzType.setCreateTime(DateUtils.getNowDate());
        mmap.put("jzType", jzType);
        return prefix + "/edit";
    }

    /**
     * 修改保存隐患分类
     */
    @RequiresPermissions("business:hazardhlassification:edit")
    @Log(title = "隐患分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzType jzType)
    {
        jzType.setUpdateId(ShiroUtils.getUserId());
        jzType.setUpdateTime(DateUtils.getNowDate());
        return toAjax(jzTypeService.updateJzType(jzType));
    }

    /**
     * 删除隐患分类
     */
    @RequiresPermissions("business:hazardhlassification:remove")
    @Log(title = "隐患分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
//    public AjaxResult remove(@PathVariable("ids")String ids)
    public AjaxResult remove(@PathVariable("id")Long id)
    {
//        return toAjax(jzTypeService.deleteJzTypeByIds(ids));
        return toAjax(jzTypeService.deleteJzTypeById(id));
    }
}
