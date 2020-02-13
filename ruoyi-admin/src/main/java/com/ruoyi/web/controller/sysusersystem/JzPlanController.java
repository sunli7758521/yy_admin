package com.ruoyi.web.controller.sysusersystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.constant.CoommonConstants;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDictType;
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
import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.service.IJzPlanService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 制定巡检模板Controller
 * 
 * @author sunli
 * @date 2019-12-31
 */
@Controller
@RequestMapping("/sysusersystem/plan")
public class JzPlanController extends BaseController
{
    private String prefix = "sysusersystem/plan";

    @Autowired
    private IJzPlanService jzPlanService;

    @RequiresPermissions("sysusersystem:plan:view")
    @GetMapping()
    public String plan()
    {
        return prefix + "/plan";
    }
    /**
     * 查询制定计划列表
     */
    @RequiresPermissions("sysusersystem:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzPlan jzPlan)
    {
        startPage();
        List<JzPlan> list = null;
        jzPlan.setPlanType("1");
        list=  jzPlanService.selectJzPlanList(jzPlan);
        return getDataTable(list);
    }

    /**
     * 导出制定计划列表
     */
    @RequiresPermissions("sysusersystem:plan:export")
    @Log(title = "巡检模板", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzPlan jzPlan)
    {
        List<JzPlan> list = jzPlanService.selectJzPlanList(jzPlan);
        ExcelUtil<JzPlan> util = new ExcelUtil<JzPlan>(JzPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 新增巡检模板
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存巡检模板
     */
    @RequiresPermissions("sysusersystem:plan:add")
    @Log(title = "巡检模板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzPlan jzPlan)
    {
        jzPlan.setCreateId(ShiroUtils.getUserId());
        jzPlan.setPlanType(CoommonConstants.XUNJIAN);
        jzPlan.setState("0");
        return toAjax(jzPlanService.insertJzPlan(jzPlan));
    }

    /**
     * 修改巡检模板
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        JzPlan jzPlan = jzPlanService.selectJzPlanById(planId);
        mmap.put("jzPlan", jzPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存巡检模板
     */
    @RequiresPermissions("sysusersystem:plan:edit")
    @Log(title = "巡检模板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzPlan jzPlan)
    {
        jzPlan.setPlanType("1");
        jzPlan.setUpdateId(ShiroUtils.getUserId());
        jzPlan.setPlanType(CoommonConstants.XUNJIAN);
        return toAjax(jzPlanService.updateJzPlan(jzPlan));
    }

    /**
     * 删除巡检模板
     */
    @RequiresPermissions("sysusersystem:plan:remove")
    @Log(title = "巡检模板", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzPlanService.deleteJzPlanByIds(ids));
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/detail/{dictId}")
    public String detail(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
//        JzPlan jzPlan = new JzPlan();
//        jzPlan.setJzInspectionId(dictId);
//        List<JzPlan> list = jzPlanService.selectJzPlanList(jzPlan);
        mmap.put("dictId", dictId);

        return "sysusersystem/inspection/hiddenplan";
    }

    /**
     *  删除
     */
    @GetMapping("/delect/{planId}/{planType}")
    @ResponseBody
    public AjaxResult delect(@PathVariable("planId") Long planId,@PathVariable("planType") String planType, ModelMap mmap)
    {


        return  toAjax(jzPlanService.deleteJzPlanById(planId,planType));
    }
    /**
     * 启用禁用
     */
    @RequiresPermissions("sysusersystem:plan:qijin")
    @Log(title = "启用禁用", businessType = BusinessType.UPDATE)
    @PostMapping("/qijin")
    @ResponseBody
    public Map<String, String> qijin(JzPlan jzPlan)
    {
        Map<String, String> map = new HashMap<>();
          int i = jzPlanService.qijin(jzPlan);
          if(i >0 ){
              map.put("code","0");
              map.put("msg","更新成功");
          }else{
              map.put("code","1");
              map.put("msg","更新失败");
          }

        return map;
    }


}
