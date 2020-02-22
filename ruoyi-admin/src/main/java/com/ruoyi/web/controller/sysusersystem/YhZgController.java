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
import com.ruoyi.sysusersystem.domain.YhZg;
import com.ruoyi.sysusersystem.service.IYhZgService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 隐患整改Controller
 * 
 * @author sunli
 * @date 2020-02-22
 */
@Controller
@RequestMapping("/sysusersystem/zg")
public class YhZgController extends BaseController
{
    private String prefix = "sysusersystem/zg";

    @Autowired
    private IYhZgService yhZgService;

    @RequiresPermissions("sysusersystem:zg:view")
    @GetMapping()
    public String zg()
    {
        return prefix + "/zg";
    }

    /**
     * 查询隐患整改列表
     */
    @RequiresPermissions("sysusersystem:zg:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YhZg yhZg)
    {
        startPage();
        List<YhZg> list = yhZgService.selectYhZgList(yhZg);
        return getDataTable(list);
    }

    /**
     * 导出隐患整改列表
     */
    @RequiresPermissions("sysusersystem:zg:export")
    @Log(title = "隐患整改", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YhZg yhZg)
    {
        List<YhZg> list = yhZgService.selectYhZgList(yhZg);
        ExcelUtil<YhZg> util = new ExcelUtil<YhZg>(YhZg.class);
        return util.exportExcel(list, "zg");
    }

    /**
     * 新增隐患整改
     */
    @GetMapping("/add/{yhId}")
    public String add(@PathVariable("yhId") String yhId,ModelMap map)
    {
        map.put("yhId",yhId);
        return prefix + "/add";
    }

    /**
     * 新增保存隐患整改
     */
    @RequiresPermissions("sysusersystem:zg:add")
    @Log(title = "隐患整改", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YhZg yhZg)
    {
        return toAjax(yhZgService.insertYhZg(yhZg));
    }

    /**
     * 修改隐患整改
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        YhZg yhZg = yhZgService.selectYhZgById(id);
        mmap.put("yhZg", yhZg);
        return prefix + "/edit";
    }

    /**
     * 修改保存隐患整改
     */
    @RequiresPermissions("sysusersystem:zg:edit")
    @Log(title = "隐患整改", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YhZg yhZg)
    {
        return toAjax(yhZgService.updateYhZg(yhZg));
    }

    /**
     * 删除隐患整改
     */
    @RequiresPermissions("sysusersystem:zg:remove")
    @Log(title = "隐患整改", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yhZgService.deleteYhZgByIds(ids));
    }
}
