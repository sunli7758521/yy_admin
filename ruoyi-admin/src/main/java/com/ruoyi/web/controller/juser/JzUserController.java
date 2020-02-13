package com.ruoyi.web.controller.juser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.juser.domain.JzUser;
import com.ruoyi.juser.service.IJzUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2019-12-24selectJzUserList
 */
@Controller
@RequestMapping("/juser/user")
public class JzUserController extends BaseController
{
    private String prefix = "juser/user";

    @Autowired
    private IJzUserService jzUserService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private IJzSysUserSystemService sysUserSystemService;

    @RequiresPermissions("juser:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    @GetMapping("/rand/{systemId}")
    @ResponseBody
    public String RandomNumber(@PathVariable int systemId){
        String str ="";
        switch(systemId){
            case 301:str="dlxt";break;//电力系统
            case 302:str="ryxt";break;//热源系统
            case 200:str="rqxt";break;//燃气系统
            case 201:str="zljktxt";break;//制冷及空调系统
            case 202:str="jpsxt";break;//给排水系统
            case 203:str="dtxt";break;//电梯系统
            case 204:str="yyqtxt";break;//医用气体系统
            case 205:str="staqxt";break;//食堂安全管理
            case 206:str="adaqxt";break;//工地安全管理
        }
        Integer i = (int)(Math.random()*90000+10000);
        return str + i.toString();
    }
    /**
     * 查询用户列表
     */
    @RequiresPermissions("juser:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzUser jzUser)
    {
        startPage();
        List<JzUser> list = new ArrayList<>();
        Long userId = ShiroUtils.getUserId();
        SysUser user = sysUserService.selectUserById(userId);
        Set<String> roles = roleService.selectRoleKeys(user.getUserId());
        String id ="";
            // 超级管理员
            if(user.getSearchSystemId()==0){
            if(user.isAdmin()){
                list =  jzUserService.selectJzUserList(jzUser);
            // 大班长
            }else if(roles.contains("dbz")){
                List<JzSysUserSystem>  systemIds = sysUserSystemService.selectByUserId(user.getUserId());
                for (JzSysUserSystem systemId : systemIds) {
                    id+=systemId.getSystemId()+",";
                }
//                jzUser.setSystemIds(Convert.toStrArray(id));
                list = jzUserService.selectDbzUserList(id,
                        jzUser.getUserNum(),jzUser.getState(),
                        jzUser.getPhone(),jzUser.getUserName(),
                        jzUser.getTeamId(),jzUser.getUserType(),
                        jzUser.getGender());

            }else{
                // 普通角色
                jzUser.setSystemId(user.getSystemId());
                list =  jzUserService.selectJzUserList(jzUser);
            }
        }else{
            jzUser.setSystemId(user.getSearchSystemId());
            list =  jzUserService.selectJzUserList(jzUser);
        }


       // list =  jzUserService.selectJzUserList(jzUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("juser:user:export")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzUser jzUser)
    {
        List<JzUser> list = jzUserService.selectJzUserList(jzUser);
        ExcelUtil<JzUser> util = new ExcelUtil<JzUser>(JzUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("juser:user:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzUser jzUser)
    {
        jzUser.setCreateBy(ShiroUtils.getUserId()+"");
       // jzUserService.setCreateId(ShiroUtils.getUserId());
        return toAjax(jzUserService.insertJzUser(jzUser));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        JzUser jzUser = jzUserService.selectJzUserById(userId);
        mmap.put("jzUser", jzUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("juser:user:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzUser jzUser)
    {
        jzUser.setUpdateBy(ShiroUtils.getUserId()+"");
        return toAjax(jzUserService.updateJzUser(jzUser));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("juser:user:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzUserService.deleteJzUserByIds(ids));
    }
}
