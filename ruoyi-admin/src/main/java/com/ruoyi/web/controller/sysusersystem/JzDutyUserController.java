package com.ruoyi.web.controller.sysusersystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.service.IJzPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sysusersystem.domain.JzDutyUser;
import com.ruoyi.sysusersystem.service.IJzDutyUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 值班关联用户Controller
 * 
 * @author sunli
 * @date 2020-01-13
 */
@Controller
@RequestMapping("/sysusersystem/user")
public class JzDutyUserController extends BaseController
{
    private String prefix = "sysusersystem/user";

    @Autowired
    private IJzDutyUserService jzDutyUserService;

    @Autowired
    private IJzPlanService jzPlanService;
    @RequiresPermissions("sysusersystem:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }
    /**
     * 查询值班关联用户列表
     */
    @RequiresPermissions("sysusersystem:user:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzDutyUser jzDutyUser)
    {
        startPage();
        List<JzDutyUser> list = jzDutyUserService.selectJzDutyUserList(jzDutyUser);
        return getDataTable(list);
    }
    @RequiresPermissions("sysusersystem:show:view")
    @PostMapping("/show")
    @ResponseBody
    public  List<JzDutyUser> show(ModelMap mmp,JzDutyUser jzDutyUser){
        Map<String,String> map = new HashMap<>();
        List<JzDutyUser> list = jzDutyUserService.selectJzDutyUserList(jzDutyUser);
        map.put("code","0");
        map.put("msg","成功");
//        map.put("list",list);
//        AjaxResult json = new AjaxResult();
//        json.put("msg", "msg");
//        json.put("code", 0);
        mmp.put("map",map);
        return  list;
    }
    /**
     * 导出值班关联用户列表
     */
    @RequiresPermissions("sysusersystem:user:export")
    @Log(title = "值班关联用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzDutyUser jzDutyUser)
    {
        List<JzDutyUser> list = jzDutyUserService.selectJzDutyUserList(jzDutyUser);
        ExcelUtil<JzDutyUser> util = new ExcelUtil<JzDutyUser>(JzDutyUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增值班关联用户
     */
    @GetMapping("/add/{planId}")
    public String add(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        JzPlan jzPlan = jzPlanService.selectJzPlanById(planId);
        mmap.put("jzPlan", jzPlan);
        return prefix + "/add";
    }

    /**
     * 新增保存值班关联用户
     */
    @RequiresPermissions("sysusersystem:user:add")
    @Log(title = "值班关联用户", businessType = BusinessType.INSERT)
    @PostMapping("/adda")
    @ResponseBody
    public AjaxResult addSave(JzDutyUser jzDutyUser)
    {
//        jzDutyUser.setPlanId(planId);
//        jzDutyUser.setPlanId(planId);
        jzDutyUser.setCreateTime(DateUtils.getNowDate());
        return toAjax(jzDutyUserService.insertJzDutyUser(jzDutyUser));
    }

    /**
     * 修改值班关联用户
     */
    @GetMapping("/edit/{dutyUserId}")
    public String edit(@PathVariable("dutyUserId") Long dutyUserId, ModelMap mmap)
    {
        JzDutyUser jzDutyUser = jzDutyUserService.selectJzDutyUserById(dutyUserId);
        mmap.put("jzDutyUser", jzDutyUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存值班关联用户
     */
    @RequiresPermissions("sysusersystem:user:edit")
    @Log(title = "值班关联用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit/{planId}")
    @ResponseBody
    public AjaxResult editSave(@PathVariable long planId,JzDutyUser jzDutyUser)
    {
        jzDutyUser.setPlanId(planId);
        jzDutyUser.setCreateTime(DateUtils.getNowDate());
        return toAjax(jzDutyUserService.updateJzDutyUser(jzDutyUser));
    }

    /**
     * 删除值班关联用户
     */
    @RequiresPermissions("sysusersystem:user:remove")
    @Log(title = "值班关联用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzDutyUserService.deleteJzDutyUserByIds(ids));
    }
}
