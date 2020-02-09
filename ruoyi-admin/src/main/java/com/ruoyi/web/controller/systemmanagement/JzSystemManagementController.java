package com.ruoyi.web.controller.systemmanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.emergency.domain.JzEmergencyPlan;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.systemmanagement.IJzSystemManagementService;
import com.ruoyi.systemmanagement.domain.JzSystemManagement;
import com.ruoyi.web.controller.common.CommonController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 制度管理Controller
 * 
 * @author ljc
 * @date 2019-12-14
 */
@Controller
@RequestMapping("/systemmanagement/management")
public class JzSystemManagementController extends BaseController
{
    private String prefix = "systemmanagement/management";
    @Autowired
    private ISysDeptService deptService;
    @Autowired
    private IJzSystemManagementService jzSystemManagementService;

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
        String path1 =Global.getUploadPath()+ fileUrl;
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
    @RequiresPermissions("systemmanagement:management:search")
    public String editWordToPdf(@PathVariable Long managementId,ModelMap mmap)
    {
        String wordfile = jzSystemManagementService.selectFileUrlByManagementByID(managementId);//根据Id获取到文件路径
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

    /**
     * 电力系统
     * @return
     */
    @RequiresPermissions("systemmanagement:management:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }

    /**
     * 热源系统
     * @return
     */
    @RequiresPermissions("systemmanagement:management:reYuan")
    @GetMapping("/reYuan")
    public String reYuan(){
        return prefix+"/reYuan";
    }

    /**
     * 燃气系统
     * @return
     */
    @RequiresPermissions("systemmanagement:management:ranQi")
    @GetMapping("/ranQi")
    public String ranQi(){
        return prefix+"/ranQi";
    }

    /**
     * 制冷空调
     * @return
     */
    @RequiresPermissions("systemmanagement:management:zhiLengKongTiao")
    @GetMapping("/zhiLengKongTiao")
    public String zhiLengKongTiao(){
        return prefix+"/zhiLengKongTiao";
    }

    /**
     * 给排水
     * @return
     */
    @RequiresPermissions("systemmanagement:management:jiPaiShui")
    @GetMapping("/jiPaiShui")
    public String jiPaiShui(){
        return prefix+"/jiPaiShui";
    }

    /**
     * 电梯系统
     * @return
     */
    @RequiresPermissions("systemmanagement:management:dianTi")
    @GetMapping("/dianTi")
    public String dianTi(){
        return prefix+"/dianTi";
    }

    /**
     * 医用气体
     * @return
     */
    @RequiresPermissions("systemmanagement:management:yiYongQiTi")
    @GetMapping("/yiYongQiTi")
    public String yiYongQiTi(){
        return prefix+"/yiYongQiTi";
    }

    /**
     * 食堂安全
     * @return
     */
    @RequiresPermissions("systemmanagement:management:shiTangAnQuan")
    @GetMapping("/shiTangAnQuan")
    public String shiTangAnQuan(){
        return prefix+"/shiTangAnQuan";
    }

    /**
     * 工地安全
     * @return
     */
    @RequiresPermissions("systemmanagement:management:gongDiAnQuan")
    @GetMapping("/gongDiAnQuan")
    public String gongDiAnQuan(){
        return prefix+"/gongDiAnQuan";
    }
    /**
     * 查询制度管理列表
     */
    @RequiresPermissions("systemmanagement:management:list")
    @PostMapping("/list/{Id}")
    @ResponseBody
    public TableDataInfo list(@PathVariable int Id,JzSystemManagement jzSystemManagement)
    {
        switch (Id){
            case 1:jzSystemManagement.setSystemId(301L);break;//电力系统
            case 2:jzSystemManagement.setSystemId(302L);break;//热源系统
            case 3:jzSystemManagement.setSystemId(200L);break;//燃气系统
            case 4:jzSystemManagement.setSystemId(201L);break;//制冷及空调系统
            case 5:jzSystemManagement.setSystemId(202L);break;//给排水系统
            case 6:jzSystemManagement.setSystemId(203L);break;//电梯系统
            case 7:jzSystemManagement.setSystemId(204L);break;//医用气体系统
            case 8:jzSystemManagement.setSystemId(205L);break;//食堂安全管理
            case 9:jzSystemManagement.setSystemId(206L);break;//工地安全管理
        }
        List<JzSystemManagement> list = jzSystemManagementService.selectJzSystemManagementList(jzSystemManagement);
        return getDataTable(list);
//        startPage();
//        List<JzSystemManagement> list = new ArrayList<>();
//        Long userId = ShiroUtils.getUserId();
//        SysUser user = sysUserService.selectUserById(userId);
//        Set<String> roles = roleService.selectRoleKeys(user.getUserId());
//        String id ="";
//        // 超级管理员
//        if(user.getSearchSystemId()==0){
//            if(user.isAdmin()){
////                list =  jzEquipmentService.selectJzEquipmentList(jzEquipment);
//                list = jzSystemManagementService.selectJzSystemManagementList(jzSystemManagement);
//                // 大班长
//            }else if(roles.contains("dbz")){
//                List<JzSysUserSystem>  systemIds = sysUserSystemService.selectByUserId(user.getUserId());
//                for (JzSysUserSystem systemId : systemIds) {
//                    id+=systemId.getSystemId()+",";
//                }
//
////                list = jzEmergencyPlanService.selectDbzList(id,
////                        jzEmergencyPlan.getTypeId(),jzEmergencyPlan.getState(),
////                        jzEmergencyPlan.getTitle());
//                list = jzSystemManagementService.selectDbzList(
//                        id,jzSystemManagement.getTeamId(),
//                        jzSystemManagement.getState(),
//                        jzSystemManagement.getManagementId());
//
//            }else{
//                // 普通角色
//                jzSystemManagement.setSystemId(user.getSystemId());
//                list =  jzSystemManagementService.selectJzSystemManagementList(jzSystemManagement);
//            }
//        }else{
////            jzSystemManagement.setSystemId(user.getSystemId()); //原有
//            jzSystemManagement.setSystemId(user.getSearchSystemId());
//            list =  jzSystemManagementService.selectJzSystemManagementList(jzSystemManagement);
//        }
//        return getDataTable(list);
    }
    /**
     * 导出制度管理列表
     */
    @RequiresPermissions("systemmanagement:management:export")
    @Log(title = "制度管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzSystemManagement jzSystemManagement)
    {
        List<JzSystemManagement> list = jzSystemManagementService.selectJzSystemManagementList(jzSystemManagement);
        ExcelUtil<JzSystemManagement> util = new ExcelUtil<JzSystemManagement>(JzSystemManagement.class);
        return util.exportExcel(list, "management");
    }
    /**
     * 新增制度管理
     */
    @GetMapping("/add/{Id}")
    public String add(@PathVariable Long Id, ModelMap mmap)
    {
        Long systemId = 0L;
        switch(Integer.parseInt(Id.toString())){
            case 1:systemId=301L;break;//电力系统
            case 2:systemId=302L;break;//热源系统
            case 3:systemId=200L;break;//燃气系统
            case 4:systemId=201L;break;//制冷及空调系统
            case 5:systemId=202L;break;//给排水系统
            case 6:systemId=203L;break;//电梯系统
            case 7:systemId=204L;break;//医用气体系统
            case 8:systemId=205L;break;//食堂安全管理
            case 9:systemId=206L;break;//工地安全管理
        }
        mmap.put("system",systemId);
        return prefix + "/add";
    }
    /**
     * 新增保存制度管理
     */
    @RequiresPermissions("systemmanagement:management:add")
    @Log(title = "制度管理", businessType = BusinessType.INSERT)
    @PostMapping("/add/{systemId}")
    @ResponseBody
    public AjaxResult addSave(@PathVariable Long systemId,JzSystemManagement jzSystemManagement)
    {
        //sysDeptMapper.selectDeptIdByDeptName(treeName)
        jzSystemManagement.setCreateId(ShiroUtils.getUserId());
        jzSystemManagement.setSystemId(systemId);
        return toAjax(jzSystemManagementService.insertJzSystemManagement(jzSystemManagement));
    }
    /**
     * 修改制度管理
     */
    @GetMapping("/edit/{managementId}")
    public String edit(@PathVariable("managementId") Long managementId, ModelMap mmap)
    {
        JzSystemManagement jzSystemManagement = jzSystemManagementService.selectJzSystemManagementById(managementId);
        SysDept dept =  deptService.selectDeptById(300L);
        if(dept !=null){
//           jzSupplier.setDept(dept);
            mmap.put("dept", dept);
        }
        mmap.put("jzSystemManagement", jzSystemManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存制度管理
     */
    @RequiresPermissions("systemmanagement:management:edit")
    @Log(title = "制度管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzSystemManagement jzSystemManagement)
    {
        jzSystemManagement.setUpdateId(ShiroUtils.getUserId());
        jzSystemManagement.setUpdateTime(DateUtils.getNowDate());
        return toAjax(jzSystemManagementService.updateJzSystemManagement(jzSystemManagement));
    }
    /**
     * 删除制度管理
     */
    @RequiresPermissions("systemmanagement:management:remove")
    @Log(title = "制度管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzSystemManagementService.deleteJzSystemManagementByIds(ids));
    }
}
