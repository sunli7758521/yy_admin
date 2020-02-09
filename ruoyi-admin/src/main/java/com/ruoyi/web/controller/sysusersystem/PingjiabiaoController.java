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
import com.ruoyi.sysusersystem.domain.Pingjiabiao;
import com.ruoyi.sysusersystem.service.IPingjiabiaoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 风险评价Controller
 * 
 * @author sunli
 * @date 2020-01-18
 */
@Controller
@RequestMapping("/sysusersystem/pingjiabiao")
public class PingjiabiaoController extends BaseController
{
    private String prefix = "sysusersystem/pingjiabiao";

    @Autowired
    private IPingjiabiaoService pingjiabiaoService;

    @RequiresPermissions("sysusersystem:pingjiabiao:view")
    @GetMapping()
    public String pingjiabiao()
    {
        return prefix + "/pingjiabiao";
    }

    /**
     * 查询风险评价列表
     */
    @RequiresPermissions("sysusersystem:pingjiabiao:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Pingjiabiao pingjiabiao)
    {
        startPage();
        List<Pingjiabiao> list = pingjiabiaoService.selectPingjiabiaoList(pingjiabiao);
        return getDataTable(list);
    }

    /**
     * 导出风险评价列表
     */
    @RequiresPermissions("sysusersystem:pingjiabiao:export")
    @Log(title = "风险评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Pingjiabiao pingjiabiao)
    {
        List<Pingjiabiao> list = pingjiabiaoService.selectPingjiabiaoList(pingjiabiao);
        ExcelUtil<Pingjiabiao> util = new ExcelUtil<Pingjiabiao>(Pingjiabiao.class);
        return util.exportExcel(list, "pingjiabiao");
    }

    /**
     * 新增风险评价
     */
    @GetMapping("/add/{riskId}")
    public String add(@PathVariable("riskId") Long riskId, ModelMap mmap)
    {
        mmap.put("riskId", riskId);
        return prefix + "/add";
    }

    /**
     * 新增保存风险评价
     */
    @RequiresPermissions("sysusersystem:pingjiabiao:add")
    @Log(title = "风险评价", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Pingjiabiao pingjiabiao)
    {
//        pingjiabiao.setRiskId(riskId);
        return toAjax(pingjiabiaoService.insertPingjiabiao(pingjiabiao));
    }

    /**
     * 修改风险评价
     */
    @GetMapping("/edit/{pingjiaId}")
    public String edit(@PathVariable("pingjiaId") Long pingjiaId, ModelMap mmap)
    {
        Pingjiabiao pingjiabiao = pingjiabiaoService.selectPingjiabiaoById(pingjiaId);
        mmap.put("pingjiabiao", pingjiabiao);
        return prefix + "/edit";
    }

    /**
     * 修改保存风险评价
     */
    @RequiresPermissions("sysusersystem:pingjiabiao:edit")
    @Log(title = "风险评价", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Pingjiabiao pingjiabiao)
    {
        return toAjax(pingjiabiaoService.updatePingjiabiao(pingjiabiao));
    }

    /**
     * 删除风险评价
     */
    @RequiresPermissions("sysusersystem:pingjiabiao:remove")
    @Log(title = "风险评价", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pingjiabiaoService.deletePingjiabiaoByIds(ids));
    }
}
