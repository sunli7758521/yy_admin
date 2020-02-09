package com.ruoyi.web.controller.user;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
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
import com.ruoyi.user.domain.JzUserType;
import com.ruoyi.user.service.IJzUserTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人员类型Controller
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
@Controller
@RequestMapping("/user/type")
public class JzUserTypeController extends BaseController
{
    private String prefix = "user/type";

    @Autowired
    private IJzUserTypeService jzUserTypeService;

    @RequiresPermissions("user:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询人员类型列表
     */
    @RequiresPermissions("user:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzUserType jzUserType)
    {
        startPage();
        List<JzUserType> list = jzUserTypeService.selectJzUserTypeList(jzUserType);
        return getDataTable(list);
    }

    /**
     * 导出人员类型列表
     */
    @RequiresPermissions("user:type:export")
    @Log(title = "人员类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzUserType jzUserType)
    {
        List<JzUserType> list = jzUserTypeService.selectJzUserTypeList(jzUserType);
        ExcelUtil<JzUserType> util = new ExcelUtil<JzUserType>(JzUserType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增人员类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存人员类型
     */
    @RequiresPermissions("user:type:add")
    @Log(title = "人员类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzUserType jzUserType)
    {
        SysUser user = ShiroUtils.getSysUser();
        if(user ==null){
            return toAjax(0);
        }
        jzUserType.setCreateBy(user.getUserName());
        return toAjax(jzUserTypeService.insertJzUserType(jzUserType));
    }

    /**
     * 修改人员类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzUserType jzUserType = jzUserTypeService.selectJzUserTypeById(id);
        mmap.put("jzUserType", jzUserType);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员类型
     */
    @RequiresPermissions("user:type:edit")
    @Log(title = "人员类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzUserType jzUserType)
    {
        SysUser user = ShiroUtils.getSysUser();
        if(user ==null){
            return toAjax(0);
        }
        jzUserType.setUpdateBy(user.getUserName());
        return toAjax(jzUserTypeService.updateJzUserType(jzUserType));
    }

    /**
     * 删除人员类型
     */
    @RequiresPermissions("user:type:remove")
    @Log(title = "人员类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzUserTypeService.deleteJzUserTypeByIds(ids));
    }
}
