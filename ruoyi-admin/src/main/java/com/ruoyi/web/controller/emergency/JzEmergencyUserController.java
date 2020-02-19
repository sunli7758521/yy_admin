package com.ruoyi.web.controller.emergency;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.ruoyi.emergency.domain.JzEmergencyPlan;
import com.ruoyi.emergency.service.IJzEmergencyPlanService;
import com.ruoyi.juser.domain.JzUser;
import com.ruoyi.juser.service.IJzUserService;
import com.ruoyi.system.domain.SysUser;
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
import com.ruoyi.emergency.domain.JzEmergencyUser;
import com.ruoyi.emergency.service.IJzEmergencyUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应急方案关联人员Controller
 * 
 * @author sunli
 * @date 2020-01-04
 */
@Controller
@RequestMapping("/emergency/user")
public class JzEmergencyUserController extends BaseController
{
    private String prefix = "emergency/user";

    @Autowired
    private IJzEmergencyUserService jzEmergencyUserService;

    @Autowired
    private IJzUserService jzUserService;

    @Autowired
    private IJzEmergencyPlanService jzEmergencyPlanService;

    @RequiresPermissions("emergency:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询应急方案关联组员列表
     */
    @RequiresPermissions("emergency:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzEmergencyUser jzEmergencyUser)
    {
        startPage();
        List<JzEmergencyUser> list = jzEmergencyUserService.selectJzEmergencyUserList(jzEmergencyUser);

        return getDataTable(list);
    }

    /**
     * 导出应急方案关联人员列表
     */
    @RequiresPermissions("emergency:user:export")
    @Log(title = "应急方案关联人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzEmergencyUser jzEmergencyUser)
    {
        List<JzEmergencyUser> list = jzEmergencyUserService.selectJzEmergencyUserList(jzEmergencyUser);
        ExcelUtil<JzEmergencyUser> util = new ExcelUtil<JzEmergencyUser>(JzEmergencyUser.class);
        return util.exportExcel(list, "user");
    }

//    /**
//     * 新增应急方案关联人员
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
    @GetMapping("/add/{planId}")
    public String add(@PathVariable Long planId, ModelMap mmap)
    {
        JzEmergencyPlan jzEmergencyPlan = jzEmergencyPlanService.selectJzEmergencyPlanById(planId);
        mmap.put("jzEmergencyPlan",jzEmergencyPlan);
        return prefix + "/add";
    }
    /**
     * 新增保存应急方案关联人员
     */
    @RequiresPermissions("emergency:user:add")
    @Log(title = "应急方案关联人员", businessType = BusinessType.INSERT)
    @PostMapping("/add/{planId}")
    @ResponseBody
    public AjaxResult addSave(@PathVariable Long planId,JzEmergencyUser jzEmergencyUser)
    {

        jzEmergencyUser.setEmergencyPlanId(planId);
        return toAjax(jzEmergencyUserService.insertJzEmergencyUser(jzEmergencyUser));
    }

    /**
     * 修改应急方案关联人员
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        JzEmergencyUser jzEmergencyUser = jzEmergencyUserService.selectJzEmergencyUserById(userId);
//        组员名称
        List<JzUser> llist=jzUserService.usList(jzEmergencyUser.getGroupUserId());
        String sb = new String() ;
        for (JzUser s : llist) {
            sb+=s.getUserName()+",";
        }
        //副组长名称
        List<JzUser> ulist=jzUserService.usList(jzEmergencyUser.getViceGroupLeaderId());
        String sb2 = new String() ;
        for (JzUser s : ulist) {
            sb2+=s.getUserName()+",";
        }

//        jzEmergencyUser.setGroupUserId(llist.toString());
//        jzEmergencyUser.setViceGroupLeaderId(ulist.toString());
        jzEmergencyUser.setGroupUserName(sb);
        jzEmergencyUser.setViceGroupLeaderName(sb2);
        mmap.put("jzEmergencyUser", jzEmergencyUser);
//         return prefix + "/edit";
         return prefix + "/edit";
    }

    /**
     * 修改保存应急方案关联人员
     */
//    @RequiresPermissions("emergency:user:edit")
//    @Log(title = "应急方案关联人员", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit/{planId}")
//    @ResponseBody
//    public AjaxResult editSave(@PathVariable Long planId, JzEmergencyUser jzEmergencyUser)
//    {
//        JzEmergencyUser jzEmergencyUser1 = jzEmergencyUserService.selectJzEmergencyUserById(planId);
//        return toAjax(jzEmergencyUserService.updateJzEmergencyUser(jzEmergencyUser));
//    }

    @RequiresPermissions("emergency:user:edit")
    @Log(title = "应急方案关联人员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated JzEmergencyUser jzEmergencyUser)
    {
       // JzEmergencyUser jzEmergencyUser1 = jzEmergencyUserService.selectJzEmergencyUserById(planId);
        return toAjax(jzEmergencyUserService.updateJzEmergencyUser(jzEmergencyUser));
    }

    /**
     * 删除应急方案关联人员
     */
    @RequiresPermissions("emergency:user:remove")
    @Log(title = "应急方案关联人员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzEmergencyUserService.deleteJzEmergencyUserByIds(ids));
    }
}
