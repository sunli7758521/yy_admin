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
import com.ruoyi.sysusersystem.domain.YhYsJl;
import com.ruoyi.sysusersystem.service.IYhYsJlService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 隐患验收记录Controller
 * 
 * @author sunli
 * @date 2020-02-24
 */
@Controller
@RequestMapping("/sysusersystem/jl")
public class YhYsJlController extends BaseController
{
    private String prefix = "sysusersystem/jl";

    @Autowired
    private IYhYsJlService yhYsJlService;

    @RequiresPermissions("sysusersystem:jl:view")
    @GetMapping()
    public String jl()
    {
        return prefix + "/jl";
    }

    /**
     * 查询隐患验收记录列表
     */
    @RequiresPermissions("sysusersystem:jl:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YhYsJl yhYsJl)
    {
        startPage();
        List<YhYsJl> list = yhYsJlService.selectYhYsJlList(yhYsJl);
        return getDataTable(list);
    }

    /**
     * 导出隐患验收记录列表
     */
    @RequiresPermissions("sysusersystem:jl:export")
    @Log(title = "隐患验收记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YhYsJl yhYsJl)
    {
        List<YhYsJl> list = yhYsJlService.selectYhYsJlList(yhYsJl);
        ExcelUtil<YhYsJl> util = new ExcelUtil<YhYsJl>(YhYsJl.class);
        return util.exportExcel(list, "jl");
    }

    /**
     * 新增隐患验收记录
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id,ModelMap map)
    {
        map.put("yhId",id);
        return prefix + "/add";
    }

    /**
     * 新增保存隐患验收记录
     */
    @RequiresPermissions("sysusersystem:jl:add")
    @Log(title = "隐患验收记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YhYsJl yhYsJl)
    {
        return toAjax(yhYsJlService.insertYhYsJl(yhYsJl));
    }

    /**
     * 修改隐患验收记录
     */
    @GetMapping("/edit/{yId}")
    public String edit(@PathVariable("yId") Long yId, ModelMap mmap)
    {
        YhYsJl yhYsJl = yhYsJlService.selectYhYsJlById(yId);
        mmap.put("yhYsJl", yhYsJl);
        return prefix + "/edit";
    }

    /**
     * 修改保存隐患验收记录
     */
    @RequiresPermissions("sysusersystem:jl:edit")
    @Log(title = "隐患验收记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YhYsJl yhYsJl)
    {
        return toAjax(yhYsJlService.updateYhYsJl(yhYsJl));
    }

    /**
     * 删除隐患验收记录
     */
    @RequiresPermissions("sysusersystem:jl:remove")
    @Log(title = "隐患验收记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yhYsJlService.deleteYhYsJlByIds(ids));
    }
}
