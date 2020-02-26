package com.ruoyi.web.controller.sysusersystem;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sysusersystem.domain.JzSecurityTeam;
import com.ruoyi.sysusersystem.service.IJzSecurityTeamService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 安全小组Controller
 * 
 * @author sunli
 * @date 2020-02-24
 */
@Controller
@RequestMapping("/sysusersystem/team")
public class JzSecurityTeamController extends BaseController
{
    private String prefix = "sysusersystem/team";

    @Autowired
    private IJzSecurityTeamService jzSecurityTeamService;

    @RequiresPermissions("sysusersystem:team:view")
    @GetMapping()
    public String team()
    {
        return prefix + "/team";
    }

    /**
     * 添加小组安全人员
     */
    @GetMapping("/addPerson/{id}")
    public String addPerson(@PathVariable Long id,ModelMap mmp){
        mmp.put("Security",id);
        return prefix+"/user";
    }

    /**
     * 页面编辑更新操作
     * @return
     */
    @PostMapping("/change/{id}/{value}")
    @ResponseBody
    public AjaxResult change(@PathVariable Long id,@PathVariable String value){
        JzSecurityTeam jzSecurityTeam = jzSecurityTeamService.selectJzSecurityTeamById(id);
        jzSecurityTeam.setDescribe(value);
        return toAjax(jzSecurityTeamService.updateJzSecurityTeam(jzSecurityTeam));
    }
    /**
     * 查询安全小组列表
     */
    @RequiresPermissions("sysusersystem:team:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzSecurityTeam jzSecurityTeam)
    {
        startPage();
        List<JzSecurityTeam> list = jzSecurityTeamService.selectJzSecurityTeamList(jzSecurityTeam);
        return getDataTable(list);
    }

    /**
     * 导出安全小组列表
     */
    @RequiresPermissions("sysusersystem:team:export")
    @Log(title = "安全小组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzSecurityTeam jzSecurityTeam)
    {
        List<JzSecurityTeam> list = jzSecurityTeamService.selectJzSecurityTeamList(jzSecurityTeam);
        ExcelUtil<JzSecurityTeam> util = new ExcelUtil<JzSecurityTeam>(JzSecurityTeam.class);
        return util.exportExcel(list, "team");
    }

    /**
     * 新增安全小组
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存安全小组
     */
    @RequiresPermissions("sysusersystem:team:add")
    @Log(title = "安全小组", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzSecurityTeam jzSecurityTeam)
    {
        jzSecurityTeam.setCreateTime(DateUtils.getNowDate());
        jzSecurityTeam.setCreateId(ShiroUtils.getUserId());
        return toAjax(jzSecurityTeamService.insertJzSecurityTeam(jzSecurityTeam));
    }

    /**
     * 修改安全小组
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzSecurityTeam jzSecurityTeam = jzSecurityTeamService.selectJzSecurityTeamById(id);
        mmap.put("jzSecurityTeam", jzSecurityTeam);
        return prefix + "/edit";
    }

    /**
     * 修改保存安全小组
     */
    @RequiresPermissions("sysusersystem:team:edit")
    @Log(title = "安全小组", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzSecurityTeam jzSecurityTeam)
    {
        jzSecurityTeam.setCreateTime(DateUtils.getNowDate());
        return toAjax(jzSecurityTeamService.updateJzSecurityTeam(jzSecurityTeam));
    }

    /**
     * 删除安全小组
     */
    @RequiresPermissions("sysusersystem:team:remove")
    @Log(title = "安全小组", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzSecurityTeamService.deleteJzSecurityTeamByIds(ids));
    }
}
