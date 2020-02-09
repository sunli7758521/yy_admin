package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ruoyi.common.constant.SystemConstants;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private IJzSysUserSystemService jzSysUserSystemService;

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysUserService sysUserService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        // todo

        List<SysDept> list = new ArrayList<>();
        Set<String> roles = roleService.selectRoleKeys(user.getUserId());
         SysDept dept1 =   new SysDept();
        if(user.isAdmin()){
            dept1.setParentId(300L);
            list = sysDeptService.selectDeptList(dept1);
        }else if(roles.contains("dbz")){
            list = sysDeptService.systemList(user.getUserId());
        }else{
            SysDept dept =  sysDeptService.selectDeptById(user.getSystemId());
            list.add(dept);
        }

        mmap.put("systemList", list);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        return "index";
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin(ModelMap mmap)
    {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.INDEX_STATE);
        sysUserService.updateUserSystemId(user);
        mmap.put("version", Global.getVersion());
        return "/main";
    }
    // 电力系统
    @GetMapping("/system/electric")
    public String electric(ModelMap mmap)
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.DIAN_LI_STATE);
        sysUserService.updateUserSystemId(user);
        return  "/electric";
    }

    // 热源系统
    @GetMapping("/system/heatSource")
    public String heatSource(ModelMap mmap)
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.RE_YUAN_STATE);
        sysUserService.updateUserSystemId(user);
        return "/heatSource";
    }
    // 燃气系统
    @GetMapping("/system/gas")
    public String gas()
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.RAN_QI_STATE);
        sysUserService.updateUserSystemId(user);
        return "/gas";
    }
    // 制冷及空调系统
    @GetMapping("/system/zlkt")
    public String zlkt(ModelMap mmap)
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.ZHI_LENG_KONG_TIAO_STATE);
        sysUserService.updateUserSystemId(user);
        return "/zlkt";
    }
    // 给排水系统
    @GetMapping("/system/drain")
    public String water()
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.JI_PAI_SHUI_STATE);
        sysUserService.updateUserSystemId(user);
        return "/drain";
    }
    // 电梯系统
    @GetMapping("/system/elevator")
    public String dt()
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.DIAN_TI_STATE);
        sysUserService.updateUserSystemId(user);
        return "/elevator";
    }
    // 医用气体系统
    @GetMapping("/system/medicalGas")
    public String yyqt()
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.YI_YONG_STATE);
        sysUserService.updateUserSystemId(user);
        return "/medicalGas";
    }
    // 食堂安全管理
    @GetMapping("/system/cafeteriaSafety")
    public String staq()
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.SHI_TANG_STATE);
        sysUserService.updateUserSystemId(user);
        return "/cafeteriaSafety";
    }
    // 工地安全管理
    @GetMapping("/system/constructionSite")
    public String gdaq()
    {
        SysUser user =  ShiroUtils.getSysUser();
        user.setSearchSystemId(SystemConstants.GONG_DI_AN_QUAN_STATE);
        sysUserService.updateUserSystemId(user);
        return "/constructionSite";
    }
}
