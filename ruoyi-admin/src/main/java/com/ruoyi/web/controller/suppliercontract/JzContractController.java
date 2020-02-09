package com.ruoyi.web.controller.suppliercontract;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.suppliercontract.domain.JzSupplier;
import com.ruoyi.suppliercontract.service.IJzSupplierService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.suppliercontract.domain.JzContract;
import com.ruoyi.suppliercontract.service.IJzContractService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同Controller
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
@Controller
@RequestMapping("/suppliercontract/contract")
public class JzContractController extends BaseController
{
    private String prefix = "suppliercontract/contract";

    @Autowired
    private IJzContractService jzContractService;
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

    @RequiresPermissions("suppliercontract:contract:view")
    @GetMapping()
    public String contract()
    {
        return prefix + "/contract";
    }

    /**
     * 查询合同列表
     */
    @RequiresPermissions("suppliercontract:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzContract jzContract)
    {
        startPage();
        List<JzContract> list = jzContractService.selectJzContractList(jzContract);

        return getDataTable(list);
    }
    /**
     *查看合同信息
     */
    @GetMapping("/contractById/{id}")
    public String contractById(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzContract jzContract = jzContractService.selectJzContractById(id);
        mmap.put("jzContract", jzContract);
        return prefix + "/contractById";
    }
    /**
     * 导出合同列表
     */
    @RequiresPermissions("suppliercontract:contract:export")
    @Log(title = "合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzContract jzContract)
    {
        List<JzContract> list = jzContractService.selectJzContractList(jzContract);
        ExcelUtil<JzContract> util = new ExcelUtil<JzContract>(JzContract.class);
        return util.exportExcel(list, "contract");
    }

    /**
     * 新增合同
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        SysDept dept =  deptService.selectDeptById(300L);

        if(dept !=null){
            mmap.put("dept", dept);
        }
        return prefix + "/add";
    }

    /**
     * 新增保存合同
     */
    @RequiresPermissions("suppliercontract:contract:add")
    @Log(title = "合同", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzContract jzContract)
    {
        //jzContract.setSystemId(deptService.selectDeptIdByDeptName(treeName));
        jzContract.setCreateId(ShiroUtils.getUserId());
        return toAjax(jzContractService.insertJzContract(jzContract));
    }

    /**
     * 修改合同
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        JzContract jzContract = jzContractService.selectJzContractById(id);
//        SysDept dept =  deptService.selectDeptById(300L);
//        if(dept !=null){
//           // jzContract.setDept(dept);
//            mmap.put("dept", dept);
//        }
        mmap.put("jzContract", jzContract);
        return prefix + "/edit";
    }


    /**
     * 修改保存合同
     */
    @RequiresPermissions("suppliercontract:contract:edit")
    @Log(title = "合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzContract jzContract)
    {
        //jzContract.setSystemId(deptService.selectDeptIdByDeptName(treeName));
        jzContract.setUpdateId(ShiroUtils.getUserId());
        return toAjax(jzContractService.updateJzContract(jzContract));
    }

    /**
     * 删除合同
     */
    @RequiresPermissions("suppliercontract:contract:remove")
    @Log(title = "合同", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzContractService.deleteJzContractByIds(ids));
    }
}
