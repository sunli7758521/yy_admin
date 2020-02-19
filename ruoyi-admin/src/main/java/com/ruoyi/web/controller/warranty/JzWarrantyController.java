package com.ruoyi.web.controller.warranty;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.emergency.domain.JzEmergencyUser;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISysDeptService;
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
import com.ruoyi.warranty.domain.JzWarranty;
import com.ruoyi.warranty.service.IJzWarrantyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报修Controller
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
@Controller
@RequestMapping("/warranty/warranty")
public class JzWarrantyController extends BaseController
{
    private String prefix = "warranty/warranty";

    @Autowired
    private IJzWarrantyService jzWarrantyService;

    @Autowired
    private ISysDeptService deptService;
//    /**
//     * 选择部门树
//     */
//    @GetMapping("/selectDeptTree/{deptId}")
//    public String selectDeptTree(@PathVariable("deptId") Long deptId, ModelMap mmap)
//    {
//        mmap.put("dept", deptService.selectDeptById(deptId));
//        return prefix + "/deptTree";
//    }
//    /**
//     * 加载部门列表树
//     */
//    @GetMapping("/deptTreeData")
//    @ResponseBody
//
//    public List<Ztree> deptTreeData()
//    {
//        SysDept dept =   new SysDept();
//        dept.setSystemType("1");
//        List<Ztree> ztrees = deptService.selectDeptTree(dept);
//        return ztrees;
//    }

    /**
     * 跳转到审核页面
     * @param Id 系统Id
     * @param mmp
     * @return
     */
    @GetMapping("/setState/{Id}")
    public String setState(@PathVariable Long Id,ModelMap mmp){
        JzWarranty jzWarranty = jzWarrantyService.selectJzWarrantyById(Id);
        mmp.put("jzWarranty",jzWarranty);
        return "warranty/warranty/audit";
    }

    @PostMapping("/getWarrantyId/{WarrantyId}/{state}/{cause}")
    @ResponseBody
    public AjaxResult getWarrantyId(@PathVariable Long WarrantyId,@PathVariable String state,@PathVariable String cause)
    {

        JzWarranty jzWarranty = jzWarrantyService.selectJzWarrantyById(WarrantyId);
        jzWarranty.setsHstate(state);
        jzWarranty.setCause(cause);
        return toAjax(jzWarrantyService.updateJzWarranty(jzWarranty));
    }
    //获取手机号
    @PostMapping("/getPhone/{Id}")
    @ResponseBody
    public String getPhone(@PathVariable Long Id){
       String phone  =  jzWarrantyService.selectPhone(Id);
       return phone;
    }
    /**
     * 获取当前报修单号
     * @return
     */
    @PostMapping("/currentTimeMillis")
    @ResponseBody
    public String getCurrentTimeMillis(){
        Long startTs = System.currentTimeMillis(); // 当前时间戳
        return startTs.toString();
    }

    @RequiresPermissions("warranty:warranty:view")
    @GetMapping()
    public String warranty()
    {
        return prefix + "/warranty";
    }

    /**
     * 查询报修列表
     */
    @RequiresPermissions("warranty:warranty:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzWarranty jzWarranty)
    {
        startPage();
        List<JzWarranty> list = jzWarrantyService.selectJzWarrantyList(jzWarranty);
        return getDataTable(list);
    }

    /**
     * 导出报修列表
     */
    @RequiresPermissions("warranty:warranty:export")
    @Log(title = "报修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzWarranty jzWarranty)
    {
        List<JzWarranty> list = jzWarrantyService.selectJzWarrantyList(jzWarranty);
        ExcelUtil<JzWarranty> util = new ExcelUtil<JzWarranty>(JzWarranty.class);
        return util.exportExcel(list, "warranty");
    }

    /**
     * 新增报修
     */
    @GetMapping("/add")
    public String add()
    {
//        SysDept dept =  deptService.selectDeptById(300L);
//
//        if(dept !=null){
//            mmap.put("dept", dept);
//        }
        return prefix + "/add";
    }

    /**
     * 新增保存报修
     */
    @RequiresPermissions("warranty:warranty:add")
    @Log(title = "报修", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzWarranty jzWarranty)
    {

        //jzWarranty.setSystemId(deptService.selectDeptIdByDeptName(treeName));
        jzWarranty.setCreateId(ShiroUtils.getUserId());
        return toAjax(jzWarrantyService.insertJzWarranty(jzWarranty));
    }

    /**
     * 修改报修
     */
    @GetMapping("/edit/{warrantyId}")
    public String edit(@PathVariable("warrantyId") Long warrantyId, ModelMap mmap)
    {
        JzWarranty jzWarranty = jzWarrantyService.selectJzWarrantyById(warrantyId);
//        SysDept dept =  deptService.selectDeptById(300L);
//        if(dept !=null){
//            // jzContract.setDept(dept);
//            mmap.put("dept", dept);
//        }
        mmap.put("jzWarranty", jzWarranty);
        return prefix + "/edit";
    }

    /**
     * 修改保存报修
     */
    @RequiresPermissions("warranty:warranty:edit")
    @Log(title = "报修", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzWarranty jzWarranty)
    {
        //jzWarranty.setSystemId(deptService.selectDeptIdByDeptName(treeName));
        jzWarranty.setUpdateId(ShiroUtils.getUserId());
        return toAjax(jzWarrantyService.updateJzWarranty(jzWarranty));
    }

    /**
     * 删除报修
     */
    @RequiresPermissions("warranty:warranty:remove")
    @Log(title = "报修", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzWarrantyService.deleteJzWarrantyByIds(ids));
    }

    @GetMapping("/detail/{planId}")
    public String detail(@PathVariable Long planId,ModelMap mmp){
        mmp.put("planId",planId);
        return "sysusersystem/wx/wx";
    }
}
