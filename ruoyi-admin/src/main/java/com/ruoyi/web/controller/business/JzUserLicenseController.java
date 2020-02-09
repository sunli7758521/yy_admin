package com.ruoyi.web.controller.business;

import java.util.*;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.juser.domain.JzUser;
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
import com.ruoyi.business.domain.JzUserLicense;
import com.ruoyi.business.service.IJzUserLicenseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户证件照Controller
 * 
 * @author ruoyi
 * @date 2019-12-10
 */
@Controller
@RequestMapping("/business/license")
public class JzUserLicenseController extends BaseController
{
    private String prefix = "business/license";

    @Autowired
    private IJzUserLicenseService jzUserLicenseService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private IJzSysUserSystemService sysUserSystemService;

    @RequiresPermissions("business:license:view")
    @GetMapping()
    public String license()
    {
        return prefix + "/license";
    }

    /**
     * 查询用户证件照列表
     */
    @RequiresPermissions("business:license:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzUserLicense jzUserLicense)
    {
        startPage();



        List<JzUserLicense> list = new ArrayList<>();
        Long userId = ShiroUtils.getUserId();
        SysUser user = sysUserService.selectUserById(userId);
        Set<String> roles = roleService.selectRoleKeys(user.getUserId());
        String id ="";
        // 超级管理员
        if(user.getSearchSystemId()==0){
            if(user.isAdmin()){
                list =  jzUserLicenseService.selectJzUserLicenseList(jzUserLicense);
                // 大班长
            }else if(roles.contains("dbz")){
                List<JzSysUserSystem>  systemIds = sysUserSystemService.selectByUserId(user.getUserId());
                for (JzSysUserSystem systemId : systemIds) {
                    id+=systemId.getSystemId()+",";
                }
//                jzUserLicense.setSystemIds(Convert.toStrArray(id));
                list = jzUserLicenseService.selectDbzUserList(id,
                        jzUserLicense.getUserName(),
                        jzUserLicense.getHomeworkTypeId(),
                        jzUserLicense.getMustHoldProjectTypeId(),
                        jzUserLicense.getAppType(),
                        jzUserLicense.getParams().get("beginReviewTime"),
                        jzUserLicense.getParams().get("endReviewTime"),
                        jzUserLicense.getReviewState()
                       );

            }else{
                // 普通角色
                jzUserLicense.setSystemId(user.getSystemId());
                list =  jzUserLicenseService.selectJzUserLicenseList(jzUserLicense);
            }
        }else{
            jzUserLicense.setSystemId(user.getSearchSystemId());
            list =  jzUserLicenseService.selectJzUserLicenseList(jzUserLicense);
        }



        return getDataTable(list);
    }

    /**
     * 导出用户证件照列表
     */
    @RequiresPermissions("business:license:export")
    @Log(title = "用户证件照", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzUserLicense jzUserLicense)
    {
        List<JzUserLicense> list = jzUserLicenseService.selectJzUserLicenseList(jzUserLicense);
        ExcelUtil<JzUserLicense> util = new ExcelUtil<JzUserLicense>(JzUserLicense.class);
        return util.exportExcel(list, "license");
    }

    /**
     * 新增用户证件照
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户证件照
     */
    @RequiresPermissions("business:license:add")
    @Log(title = "用户证件照", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzUserLicense jzUserLicense)
    {
        jzUserLicense.setCreateBy(ShiroUtils.getUserId()+"");

        //        0-5  1-5年
        jzUserLicense.setUpdateBy(ShiroUtils.getUserId()+"");
        jzUserLicense.setCreateTime(DateUtils.getNowDate());
        String appType = jzUserLicense.getAppType();
        Date firstTime = jzUserLicense.getFirstTime();

        Calendar cal = Calendar.getInstance();
        cal.setTime(firstTime);
        switch (appType){
            case  "0":
                cal.add(Calendar.YEAR, 1);//增加一年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case  "1":
                cal.add(Calendar.YEAR, 1);//增加二年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case  "2":
                cal.add(Calendar.YEAR, 1);//增加三年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case  "3":
                cal.add(Calendar.YEAR, 1);//增加四年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case  "4":
                cal.add(Calendar.YEAR, 1);//增加五年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case  "5":
                cal.add(Calendar.YEAR, 1);//增加六年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
        }

        return toAjax(jzUserLicenseService.insertJzUserLicense(jzUserLicense));
    }

    /**
     * 修改用户证件照
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzUserLicense jzUserLicense = jzUserLicenseService.selectJzUserLicenseById(id);
        mmap.put("jzUserLicense", jzUserLicense);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户证件照
     */
    @RequiresPermissions("business:license:edit")
    @Log(title = "用户证件照", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzUserLicense jzUserLicense)
    {
//        0-5  1-5年
        jzUserLicense.setUpdateBy(ShiroUtils.getUserId()+"");
        jzUserLicense.setUpdateTime(DateUtils.getNowDate());
        String appType = jzUserLicense.getAppType();
        Date firstTime = jzUserLicense.getFirstTime();

        Calendar cal = Calendar.getInstance();
        cal.setTime(firstTime);
        switch (appType) {
            case "0":
                cal.add(Calendar.YEAR, 1);//增加一年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case "1":
                cal.add(Calendar.YEAR, 1);//增加二年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case "2":
                cal.add(Calendar.YEAR, 1);//增加三年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case "3":
                cal.add(Calendar.YEAR, 1);//增加四年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case "4":
                cal.add(Calendar.YEAR, 1);//增加五年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
            case "5":
                cal.add(Calendar.YEAR, 1);//增加六年
                jzUserLicense.setReviewTime(cal.getTime());
                break;
        }


        return toAjax(jzUserLicenseService.updateJzUserLicense(jzUserLicense));
    }

    /**
     * 删除用户证件照
     */
    @RequiresPermissions("business:license:remove")
    @Log(title = "用户证件照", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzUserLicenseService.deleteJzUserLicenseByIds(ids));
    }
}
