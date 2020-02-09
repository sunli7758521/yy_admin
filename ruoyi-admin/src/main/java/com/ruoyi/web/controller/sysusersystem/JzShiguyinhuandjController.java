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
import com.ruoyi.sysusersystem.domain.JzShiguyinhuandj;
import com.ruoyi.sysusersystem.service.IJzShiguyinhuandjService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 事故隐患排查整改记录Controller
 * 
 * @author sunli
 * @date 2020-01-19
 */
@Controller
@RequestMapping("/sysusersystem/shiguyinhuandj")
public class JzShiguyinhuandjController extends BaseController
{
    private String prefix = "sysusersystem/shiguyinhuandj";

    @Autowired
    private IJzShiguyinhuandjService jzShiguyinhuandjService;

    @RequiresPermissions("sysusersystem:shiguyinhuandj:view")
    @GetMapping()
    public String shiguyinhuandj()
    {
        return prefix + "/shiguyinhuandj";
    }

    /**
     * 查询事故隐患排查整改记录列表
     */
    @RequiresPermissions("sysusersystem:shiguyinhuandj:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzShiguyinhuandj jzShiguyinhuandj)
    {
        startPage();
        List<JzShiguyinhuandj> list = jzShiguyinhuandjService.selectJzShiguyinhuandjList(jzShiguyinhuandj);
        return getDataTable(list);
    }

    /**
     * 导出事故隐患排查整改记录列表
     */
    @RequiresPermissions("sysusersystem:shiguyinhuandj:export")
    @Log(title = "事故隐患排查整改记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzShiguyinhuandj jzShiguyinhuandj)
    {
        List<JzShiguyinhuandj> list = jzShiguyinhuandjService.selectJzShiguyinhuandjList(jzShiguyinhuandj);
        ExcelUtil<JzShiguyinhuandj> util = new ExcelUtil<JzShiguyinhuandj>(JzShiguyinhuandj.class);
        return util.exportExcel(list, "shiguyinhuandj");
    }

    /**
     * 新增事故隐患排查整改记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存事故隐患排查整改记录
     */
    @RequiresPermissions("sysusersystem:shiguyinhuandj:add")
    @Log(title = "事故隐患排查整改记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzShiguyinhuandj jzShiguyinhuandj)
    {
        return toAjax(jzShiguyinhuandjService.insertJzShiguyinhuandj(jzShiguyinhuandj));
    }

    /**
     * 修改事故隐患排查整改记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzShiguyinhuandj jzShiguyinhuandj = jzShiguyinhuandjService.selectJzShiguyinhuandjById(id);
        mmap.put("jzShiguyinhuandj", jzShiguyinhuandj);
        return prefix + "/edit";
    }

    /**
     * 修改保存事故隐患排查整改记录
     */
    @RequiresPermissions("sysusersystem:shiguyinhuandj:edit")
    @Log(title = "事故隐患排查整改记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzShiguyinhuandj jzShiguyinhuandj)
    {
        return toAjax(jzShiguyinhuandjService.updateJzShiguyinhuandj(jzShiguyinhuandj));
    }

    /**
     * 删除事故隐患排查整改记录
     */
    @RequiresPermissions("sysusersystem:shiguyinhuandj:remove")
    @Log(title = "事故隐患排查整改记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzShiguyinhuandjService.deleteJzShiguyinhuandjByIds(ids));
    }
}
