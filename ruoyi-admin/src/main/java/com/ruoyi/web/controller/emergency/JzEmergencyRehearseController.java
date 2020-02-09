package com.ruoyi.web.controller.emergency;

import java.util.List;

import com.ruoyi.emergency.domain.JzEmergencyPlan;
import com.ruoyi.emergency.service.IJzEmergencyPlanService;
import com.ruoyi.emergency.service.IJzEmergencySuppliesService;
import io.swagger.annotations.Authorization;
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
import com.ruoyi.emergency.domain.JzEmergencyRehearse;
import com.ruoyi.emergency.service.IJzEmergencyRehearseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应急方案关联演练Controller
 * 
 * @author sunli
 * @date 2020-01-04
 */
@Controller
@RequestMapping("/emergency/rehearse")
public class JzEmergencyRehearseController extends BaseController
{
    private String prefix = "emergency/rehearse";

    @Autowired
    private IJzEmergencyRehearseService jzEmergencyRehearseService;

    @Autowired
    private IJzEmergencySuppliesService jzEmergencySuppliesService;


    @Autowired
    private IJzEmergencyPlanService jzEmergencyPlanService;
    @RequiresPermissions("emergency:rehearse:view")
    @GetMapping()
    public String rehearse()
    {
        return prefix + "/rehearse";
    }

    /**
     * 查询应急方案关联演练列表
     */
    @RequiresPermissions("emergency:rehearse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzEmergencyRehearse jzEmergencyRehearse)
    {
        startPage();
        List<JzEmergencyRehearse> list = jzEmergencyRehearseService.selectJzEmergencyRehearseList(jzEmergencyRehearse);
        return getDataTable(list);
    }

    /**
     * 导出应急方案关联演练列表
     */
    @RequiresPermissions("emergency:rehearse:export")
    @Log(title = "应急方案关联演练", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzEmergencyRehearse jzEmergencyRehearse)
    {
        List<JzEmergencyRehearse> list = jzEmergencyRehearseService.selectJzEmergencyRehearseList(jzEmergencyRehearse);
        ExcelUtil<JzEmergencyRehearse> util = new ExcelUtil<JzEmergencyRehearse>(JzEmergencyRehearse.class);
        return util.exportExcel(list, "rehearse");
    }

    @GetMapping("/shengYu/{suppliesBigTypeId}")
    @ResponseBody
    public int shengYu(@PathVariable Long suppliesBigTypeId){
       Integer con = jzEmergencySuppliesService.selectSum(suppliesBigTypeId);
       // System.out.println("==================="+con);
       if( con != null ){
           return con;
//        System.out.println(suppliesBigTypeId)
       }else{
           return 0;
       }

    }
    /**
     * 新增应急方案关联演练
     */
    @GetMapping("/add/{planId}")
    //
    public String add(@PathVariable Long planId, ModelMap mmap)
    {
        JzEmergencyPlan jzEmergencyPlan = jzEmergencyPlanService.selectJzEmergencyPlanById(planId);
        mmap.put("jzEmergencyPlan",jzEmergencyPlan);
        return prefix + "/add";
    }

    /**
     * 新增保存应急方案关联演练
     */
    @RequiresPermissions("emergency:rehearse:add")
    @Log(title = "应急方案关联演练", businessType = BusinessType.INSERT)
    @PostMapping("/add/{planId}")
    @ResponseBody
    public AjaxResult addSave(@PathVariable Long planId,JzEmergencyRehearse jzEmergencyRehearse)
    {
        jzEmergencyRehearse.setEmergencyPlanId(planId);
        return toAjax(jzEmergencyRehearseService.insertJzEmergencyRehearse(jzEmergencyRehearse));
    }

    /**
     * 修改应急方案关联演练
     */
    @GetMapping("/edit/{rehearseId}")
    public String edit(@PathVariable("rehearseId") Long rehearseId, ModelMap mmap)
    {
        JzEmergencyRehearse jzEmergencyRehearse = jzEmergencyRehearseService.selectJzEmergencyRehearseById(rehearseId);mmap.put("jzEmergencyRehearse", jzEmergencyRehearse);
        mmap.put("jzEmergencyRehearse", jzEmergencyRehearse);
        return prefix + "/edit";
    }

    /**
     * 修改保存应急方案关联演练
     */
    @RequiresPermissions("emergency:rehearse:edit")
    @Log(title = "应急方案关联演练", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzEmergencyRehearse jzEmergencyRehearse)
    {
        return toAjax(jzEmergencyRehearseService.updateJzEmergencyRehearse(jzEmergencyRehearse));
    }

    /**
     * 删除应急方案关联演练
     */
    @RequiresPermissions("emergency:rehearse:remove")
    @Log(title = "应急方案关联演练", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzEmergencyRehearseService.deleteJzEmergencyRehearseByIds(ids));
    }
    /**
     * 查看详细信息
     */
    @GetMapping("/listById/{rehearseId}")
    public String listId(@PathVariable("rehearseId") Long rehearseId, ModelMap mmap,JzEmergencyRehearse jzEmergencyRehearse)
    {
        jzEmergencyRehearse= jzEmergencyRehearseService.selectJzEmergencyRehearseById(rehearseId);
        mmap.put("jzEmergencyRehearse", jzEmergencyRehearse);
        return prefix + "/listById";


    }
}
