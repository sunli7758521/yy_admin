package com.ruoyi.framework.web.service;

import com.ruoyi.business.domain.JzType;
import com.ruoyi.business.service.IJzTypeService;
import com.ruoyi.emergency.domain.JzEmergencyPlan;
import com.ruoyi.emergency.service.IJzEmergencyPlanService;
import com.ruoyi.equipment.domain.JzEquipment;
import com.ruoyi.equipment.domain.JzEquipmentSpecifications;
import com.ruoyi.equipment.service.IJzEquipmentService;
import com.ruoyi.equipment.service.IJzEquipmentSpecificationsService;
import com.ruoyi.juser.domain.JzUser;
import com.ruoyi.juser.service.IJzUserService;
import com.ruoyi.suppliercontract.domain.JzSupplier;
import com.ruoyi.suppliercontract.service.IJzSupplierService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.systemmanagement.IJzSystemManagementService;
import com.ruoyi.systemmanagement.domain.JzSystemManagement;
import com.ruoyi.sysusersystem.domain.JzInspection;
import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.service.IJzInspectionService;
import com.ruoyi.sysusersystem.service.IJzPlanService;
import com.ruoyi.user.domain.JzUserType;
import com.ruoyi.user.service.IJzUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 *
 * @author ruoyi
 */
@Service("dict")
public class DictService
{
    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private IJzSupplierService supplierService;

    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private IJzUserService userService;

    @Autowired
    private IJzUserTypeService UserTypeService;

    @Autowired
    private IJzSystemManagementService systemManagementService;

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private IJzPlanService jzPlanService;

    @Autowired
    private IJzEquipmentService jzEquipmentService;

    @Autowired
    private IJzEquipmentSpecificationsService jzEquipmentSpecificationsService;

    @Autowired
    private IJzTypeService jzTypeService;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private IJzEmergencyPlanService jzEmergencyPlanService;
    /**
     * 根据stateID查询到jz_type表中 风险 应急物资 隐患
     * @param stateid 0 1 2
     * @return
     */
    public List<JzType> listType(int stateid){
        return jzTypeService.listType(stateid);
    }
    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDictData> getType(String dictType)
    {
        return dictDataService.selectDictDataByType(dictType);
    }
    /**
     *供应商下拉列表
     * @return
     */
    public List<JzSupplier> supList(){

        return supplierService.supList();
    }
    /**
     * 员工下拉列表
     * @return
     */
    public List<JzUser> uList() {

        return userService.uList();
    }

    /**
     * 员工下拉列表
     * @return
     */
    public List<SysUser> systemList() {
        return iSysUserService.selectUserList(new SysUser());
    }

    //    public List<JzInspection> titleList(){
//        return jzInspectionService.selectTitle();
//    }

    /**
     * 获取计划下拉列表
     * @return
     */
    public List<JzPlan> titleList(){
        return jzPlanService.selectTitle();
    }
    /**
     * 员工类型下拉列表
     * @return
     */
    public  List<JzUserType> utList()
    {
        return UserTypeService.utList();
    }

    /**
     * 系统下拉列表
     * @return
     */
    public List<SysDept> DeptList(){
        return deptService.DeptList();
    }

    /**
     * 系统下拉列表
     * @return
     */
    public List<SysDept> zuoYeList(){
        return deptService.zuoYeList();
    }

    /**
     * 系统下拉列表
     * @return
     */
    public List<SysDept> caoZuoList(){
        return deptService.caoZuoList();
    }

    /**
     * 部-科室级联
     * @param parentId
     * @return
     */
    public List<SysDept> DeptBuList(Long parentId){
        SysDept dept = new SysDept();
        dept.setParentId(parentId);
        return deptService.DeptBuList(dept);
    }
    /**
     * 设备下拉列表
     * @return
     */
    public List<JzEquipment> sbList(){
        return jzEquipmentService.sbList();
    }

    /**
     * 设备规格下拉框
     * */
    public List<JzEquipmentSpecifications> esList(){ return jzEquipmentSpecificationsService.esList(); }

    /**
     * 获取应急物资分类列表
     * @return
     */
    public List<JzType> wzList() {
        return jzTypeService.wzList();
    }

    /**
     *  获取应急物资 大分类 列表
     * @return
     */
    public List<JzType> bswzList() {
        return jzTypeService.bswzList(100);
    }
    /**
     *  获取应急物资 小分类 列表
     * @return
     */
    public List<JzType> smallTypeList() {
        return jzTypeService.smallTypeList(100);
    }

    public List<JzEmergencyPlan>emergencySuppliesList(){
        return jzEmergencyPlanService.emergencySuppliesList();
    }
//    uList(){
//
//    }
    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue)
    {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public  List<SysDept> getSystem(Long parentId)
    {
        SysDept dept = new SysDept();
        dept.setParentId(parentId);
        return sysDeptService.selectDeptList(dept);
    }
}
