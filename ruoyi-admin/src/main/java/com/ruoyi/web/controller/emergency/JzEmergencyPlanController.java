package com.ruoyi.web.controller.emergency;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.equipment.domain.JzEquipment;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.common.CommonController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.emergency.domain.JzEmergencyPlan;
import com.ruoyi.emergency.service.IJzEmergencyPlanService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 应急方案Controller
 *
 * @author sunli
 * @date 2020-01-04
 */
@Controller
@RequestMapping("/emergency/plan")
public class JzEmergencyPlanController extends BaseController
{
    private String prefix = "emergency/plan";

    @Autowired
    private IJzEmergencyPlanService jzEmergencyPlanService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private IJzSysUserSystemService sysUserSystemService;

    @Autowired
    private ISysUserService sysUserService;

    /**
     *  添加页面在线预览word文件
     * @param fileUrl word文件名称
     * @param mmap
     * @return 跳转yulan文件
     */
    @RequestMapping(value="/addWordToPdf/{fileUrl}",method= RequestMethod.GET)
    public String addWordToPdf(@PathVariable String fileUrl,ModelMap mmap)
    {
        /**
         * 1，word转pdf
         * 2. 读取数据库word路径，
         * 3. 读取pdf路径
         * 4. 显示到页面
         */
        Date date = new Date();
        String strDateFormat = "/yyyy/MM/dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String path1 = Global.getUploadPath()+ fileUrl;
        String isDocOrDocx = path1.substring(path1.indexOf("."));
        String path = Global.getUploadPath()+sdf.format(date)+"/"+fileUrl;
        String str=null;
        if(isDocOrDocx.equals(".docx")) {
            str = path1.substring(0, path1.indexOf(".docx"));
        }else if(isDocOrDocx.equals(".doc"))
        {
            str = path1.substring(0, path1.indexOf(".doc"));
        }
        String pdfUrl = str.concat(".pdf");
        int flag = CommonController.wToPdfChange(path,pdfUrl);//word转PDF
        if(flag==0){
            pdfUrl = pdfUrl.substring(pdfUrl.lastIndexOf("/")+1);
            //把pdf文件路径传递到yulan.html页面
        }else{
        }
        mmap.put("pdfUrl", Constants.RESOURCE_PREFIX+"/"+pdfUrl);
        return prefix+"/yu";
    }
    /**
     * 更新页面预览文件
     * @param managementId 接收主键查询fileurl
     * @param mmap
     * @return
     */
    @RequestMapping(value="/editWordToPdf/{managementId}",method= RequestMethod.GET)
    public String editWordToPdf(@PathVariable Long managementId,ModelMap mmap)
    {
        String wordfile = jzEmergencyPlanService.selectFileUrlByPlanId(managementId);//根据Id获取到文件路径
        wordfile= Global.getUploadPath()+wordfile.substring(15);// /profile/upload 所以从第16位开始
        String fileName = wordfile.substring(wordfile.lastIndexOf("/")+1);//截取到文件名称
        String path1 =Global.getUploadPath()+fileName;//获取全路径
        String isDocOrDocx = path1.substring(path1.indexOf("."));
        String str = null;
        if(isDocOrDocx.equals(".docx")) {
            str = path1.substring(0, path1.indexOf(".docx"));
        }else if(isDocOrDocx.equals(".doc"))
        {
            str = path1.substring(0, path1.indexOf(".doc"));
        }
        String pdffile = str.concat(".pdf");;
        int flag = CommonController.wToPdfChange(wordfile,pdffile);
        String pdfName = fileName.substring(0,fileName.indexOf(".")).concat(".pdf");
        if(flag==0){
            mmap.put("pdfUrl", Constants.RESOURCE_PREFIX+"/upload"+pdfName);
        }else{
            //文件读取错误
        }
        return prefix+"/yu";
    }
    @RequiresPermissions("emergency:plan:view")
    @GetMapping()
    public String plan()
    {
        return prefix + "/plan";
    }

    /**
     * 查询应急方案列表
     */
    @RequiresPermissions("emergency:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzEmergencyPlan jzEmergencyPlan)
    {
        startPage();
        List<JzEmergencyPlan> list = new ArrayList<>();
        Long userId = ShiroUtils.getUserId();
        SysUser user = sysUserService.selectUserById(userId);
        Set<String> roles = roleService.selectRoleKeys(user.getUserId());
        String id ="";
        // 超级管理员
        if(user.getSearchSystemId()==0){
            if(user.isAdmin()){
//                list =  jzEquipmentService.selectJzEquipmentList(jzEquipment);
                list =  jzEmergencyPlanService.selectJzEmergencyPlanList(jzEmergencyPlan);
                // 大班长
            }else if(roles.contains("dbz")){
                List<JzSysUserSystem>  systemIds = sysUserSystemService.selectByUserId(user.getUserId());
                for (JzSysUserSystem systemId : systemIds) {
                    id+=systemId.getSystemId()+",";
                }

                list = jzEmergencyPlanService.selectDbzList(id,
                        jzEmergencyPlan.getTypeId(),jzEmergencyPlan.getState(),
                        jzEmergencyPlan.getTitle());

            }else{
                // 普通角色
                jzEmergencyPlan.setSystemId(user.getSystemId());
                list =  jzEmergencyPlanService.selectJzEmergencyPlanList(jzEmergencyPlan);
            }
        }else{
//            jzEmergencyPlan.setSystemId(user.getSystemId()); //原有
            jzEmergencyPlan.setSystemId(user.getSearchSystemId());
            list =  jzEmergencyPlanService.selectJzEmergencyPlanList(jzEmergencyPlan);
        }
//        List<JzEmergencyPlan> list = jzEmergencyPlanService.selectJzEmergencyPlanList(jzEmergencyPlan);
        return getDataTable(list);
    }

    /**
     * 导出应急方案列表
     */
    @RequiresPermissions("emergency:plan:export")
    @Log(title = "应急方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzEmergencyPlan jzEmergencyPlan)
    {
        List<JzEmergencyPlan> list = jzEmergencyPlanService.selectJzEmergencyPlanList(jzEmergencyPlan);
        ExcelUtil<JzEmergencyPlan> util = new ExcelUtil<JzEmergencyPlan>(JzEmergencyPlan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 新增应急方案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存应急方案
     */
    @RequiresPermissions("emergency:plan:add")
    @Log(title = "应急方案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzEmergencyPlan jzEmergencyPlan)
    {
        jzEmergencyPlan.setUpdateTime(DateUtils.getNowDate());
        jzEmergencyPlan.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(jzEmergencyPlanService.insertJzEmergencyPlan(jzEmergencyPlan));
    }

    /**
     * 修改应急方案
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap)
    {
        JzEmergencyPlan jzEmergencyPlan = jzEmergencyPlanService.selectJzEmergencyPlanById(planId);
        mmap.put("jzEmergencyPlan", jzEmergencyPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存应急方案
     */
    @RequiresPermissions("emergency:plan:edit")
    @Log(title = "应急方案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzEmergencyPlan jzEmergencyPlan)
    {
        jzEmergencyPlan.setUpdateTime(DateUtils.getNowDate());
        jzEmergencyPlan.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(jzEmergencyPlanService.updateJzEmergencyPlan(jzEmergencyPlan));
    }

    /**
     * 删除应急方案
     */
    @RequiresPermissions("emergency:plan:remove")
    @Log(title = "应急方案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzEmergencyPlanService.deleteJzEmergencyPlanByIds(ids));
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
        return "emergency/rehearse/hiddenrehearse";
    }
    /**
     * 查询字典详细
     */
    @GetMapping("/detailpersonnel/{dictId}")
    public String detailpersonnel(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
//        JzPlan jzPlan = new JzPlan();
//        jzPlan.setJzInspectionId(dictId);
//        List<JzPlan> list = jzPlanService.selectJzPlanList(jzPlan);
        mmap.put("dictId", dictId);
        return "emergency/user/hiddenuser";
    }
    /**
     * 查询字典详细
     */
    @GetMapping("/detailsupplies/{dictId}")
    public String detailsupplies(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
//        JzPlan jzPlan = new JzPlan();
//        jzPlan.setJzInspectionId(dictId);
//        List<JzPlan> list = jzPlanService.selectJzPlanList(jzPlan);
        mmap.put("dictId", dictId);
        return "emergency/supplies/hiddensupplies";
    }
}
