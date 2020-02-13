package com.ruoyi.web.controller.suppliercontract;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
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
import com.ruoyi.suppliercontract.domain.JzSupplier;
import com.ruoyi.suppliercontract.service.IJzSupplierService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商Controller
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
@Controller
@RequestMapping("/suppliercontract/supplier")
public class JzSupplierController extends BaseController
{
    private String prefix = "suppliercontract/supplier";

    @Autowired
    private IJzSupplierService jzSupplierService;

//    @Autowired
//    private SysDeptMapper sysDeptMapper;

    @Autowired
    private ISysDeptService deptService;

    /**
     * 选择部门树
     */
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

    @RequiresPermissions("suppliercontract:supplier:view")
    @GetMapping()
    public String supplier()
    {
        return prefix + "/supplier";
    }

    /**
     * 查询供应商列表
     */
    @RequiresPermissions("suppliercontract:supplier:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzSupplier jzSupplier)
    {
        startPage();
        List<JzSupplier> list = jzSupplierService.selectJzSupplierList(jzSupplier);
        return getDataTable(list);
    }



    /**
     * 导出供应商列表
     */
    @RequiresPermissions("suppliercontract:supplier:export")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzSupplier jzSupplier)
    {
        List<JzSupplier> list = jzSupplierService.selectJzSupplierList(jzSupplier);
        ExcelUtil<JzSupplier> util = new ExcelUtil<JzSupplier>(JzSupplier.class);
        return util.exportExcel(list, "supplier");
    }

    /**
     * 新增供应商
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        SysDept dept = deptService.selectDeptById(300L);
        if(dept !=null){
            mmap.put("dept", dept);
        }

        return prefix + "/add";
    }
//    @GetMapping("/add")
//    public String add(ModelMap mmap)
//    {
//        SysDept dept =  deptService.selectDeptById(301L);
//
//        if(dept !=null){
//            mmap.put("dept", dept);
//        }
//
//        return prefix + "/add";
//    }
    /**
     * 新增保存供应商
     */
    @RequiresPermissions("suppliercontract:supplier:add")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzSupplier jzSupplier)

    {
       // jzSupplier.setSystemId(deptService.selectDeptIdByDeptName(treeName));
        jzSupplier.setCreateId(ShiroUtils.getUserId());
        jzSupplier.setState("0");
        return toAjax(jzSupplierService.insertJzSupplier(jzSupplier));
    }


    /**
     * 修改供应商
     */
    @GetMapping("/edit/{supplierId}")
    public String edit(@PathVariable("supplierId") Long supplierId, ModelMap mmap)
    {

        JzSupplier jzSupplier = jzSupplierService.selectJzSupplierById(supplierId);
//        SysDept dept =  deptService.selectDeptById(300L);
//        if(dept !=null){
////           jzSupplier.setDept(dept);
//            mmap.put("dept", dept);
//        }
        mmap.put("jzSupplier", jzSupplier);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商
     */
    @RequiresPermissions("suppliercontract:supplier:edit")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzSupplier jzSupplier)
    {
        //jzSupplier.setSystemId(deptService.selectDeptIdByDeptName(treeName));
        jzSupplier.setUpdateId(ShiroUtils.getUserId());
        return toAjax(jzSupplierService.updateJzSupplier(jzSupplier));
    }

    /**
     * 删除供应商
     */
    @RequiresPermissions("suppliercontract:supplier:remove")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzSupplierService.deleteJzSupplierByIds(ids));
    }
}
