package com.ruoyi.web.controller.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.juser.domain.JzUser;
import com.ruoyi.juser.service.IJzUserService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.business.domain.JzType;
import com.ruoyi.business.service.IJzTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 风险分类Controller
 * 
 * @author ljc
 * @date 2019-12-25
 */
@Controller
@RequestMapping("/business/risktype")
public class JzTypeController extends BaseController
{
    private String prefix = "business/risktype";

    @Autowired
    private IJzTypeService jzTypeService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private IJzUserService jzUserService;

    @RequiresPermissions("business:risktype:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询风险分类列表
     */
    @RequiresPermissions("business:risktype:list")
    @PostMapping("/list")
    @ResponseBody
    public List<JzType> list(JzType jzType)
    {
        //startPage();
//        List<JzUser> list = new ArrayList<>();
//        Long userId = ShiroUtils.getUserId();
//        SysUser user = sysUserService.selectUserById(userId);
//        Set<String> roles = roleService.selectRoleKeys(user.getUserId());
//        String id ="";
//        // 超级管理员
//        if(user.getSearchSystemId()==0){
//            if(user.isAdmin()){
//                list =  jzUserService.selectJzUserList(jzUser);
//                // 大班长
//            }else if(roles.contains("dbz")){
//                List<JzSysUserSystem>  systemIds = sysUserSystemService.selectByUserId(user.getUserId());
//                for (JzSysUserSystem systemId : systemIds) {
//                    id+=systemId.getSystemId()+",";
//                }
////                jzUser.setSystemIds(Convert.toStrArray(id));
//                list = jzUserService.selectDbzUserList(id,
//                        jzUser.getUserNum(),jzUser.getState(),
//                        jzUser.getPhone(),jzUser.getUserName(),
//                        jzUser.getTeamId(),jzUser.getUserType(),
//                        jzUser.getGender());
//
//            }else{
//                // 普通角色
//                jzUser.setSystemId(user.getSystemId());
//                list =  jzUserService.selectJzUserList(jzUser);
//            }
//        }else{
//            jzUser.setSystemId(user.getSearchSystemId());
//            list =  jzUserService.selectJzUserList(jzUser);
//        }
//
        jzType.setClassificationState("0");
        List<JzType> list = jzTypeService.selectJzTypeList(jzType);
        return list;
    }

    /**
     * 导出风险分类列表
     */
    @RequiresPermissions("business:risktype:export")
    @Log(title = "风险分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzType jzType)
    {
        List<JzType> list = jzTypeService.selectJzTypeList(jzType);
        ExcelUtil<JzType> util = new ExcelUtil<JzType>(JzType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增风险分类
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable Long parentId,ModelMap mmap)
    {
        if(parentId==0){
            parentId = 100L;
        }
        JzType dept = jzTypeService.selectJzTypeById(parentId);
        dept.setParentId(parentId);
        if(dept !=null){
            mmap.put("dept", dept);
        }
        return prefix + "/add";
    }

    /**
     * 新增保存风险分类
     */
    @RequiresPermissions("business:risktype:add")
    @Log(title = "风险分类", businessType = BusinessType.INSERT)
    @PostMapping("/add/{systemId}")
    @ResponseBody
    public AjaxResult addSave(@PathVariable Long systemId,JzType jzType)
    {

        jzType.setClassificationState("0");
        jzType.setSystemId(systemId);
        jzType.setCreateId(ShiroUtils.getUserId());
        jzType.setCreateTime(DateUtils.getNowDate());
        return toAjax(jzTypeService.insertJzType(jzType));
    }
    /**
     * 修改风险分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
//        JzType jzType = jzTypeService.selectJzTypeByParentId(id);
        JzType jzType = jzTypeService.selectJzTypeById(id);
        jzType.setUpdateTime(DateUtils.getNowDate());
        jzType.setCreateId(ShiroUtils.getUserId());
        mmap.put("jzType", jzType);
        return prefix + "/edit";
    }

    /**
     * 修改保存风险分类
     */
    @RequiresPermissions("business:risktype:edit")
    @Log(title = "风险分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzType jzType)
    {
        jzType.setUpdateId(ShiroUtils.getUserId());
        jzType.setUpdateTime(DateUtils.getNowDate());
        return toAjax(jzTypeService.updateJzType(jzType));
    }

    /**
     * 删除风险分类
     */
    @RequiresPermissions("business:risktype:remove")
    @Log(title = "风险分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("ids")Long ids)
    {
        return toAjax(jzTypeService.deleteJzTypeById(ids));
    }
}
