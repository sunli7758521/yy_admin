package com.ruoyi.web.controller.equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.equipment.domain.JzEquipmentSpecifications;
import com.ruoyi.equipment.service.IJzEquipmentSpecificationsService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.sysusersystem.domain.JzHiddenTrouble;
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
import com.ruoyi.equipment.domain.JzEquipment;
import com.ruoyi.equipment.service.IJzEquipmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统设备Controller
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
@Controller
@RequestMapping("/equipment/equipment")
public class JzEquipmentController extends BaseController
{
    private String prefix = "equipment/equipment";

    @Autowired
    private IJzEquipmentService jzEquipmentService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private IJzSysUserSystemService sysUserSystemService;

    @Autowired
    private IJzEquipmentSpecificationsService jzEquipmentSpecificationsService;

    @Autowired
    private ISysDictDataService sysDictDataService;

    @RequiresPermissions("equipment:equipment:view")
    @GetMapping()
    public String equipment()
    {
        return prefix + "/equipment";
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
        Integer i = (int)(Math.random()*9000+1000);
        return str + i.toString();
    }
    @GetMapping("/addEquipMentState/{str}")
    @ResponseBody
    public void addEquipMentState(@PathVariable String str){
        SysDictData sysDictData = new SysDictData();
        sysDictData.setDictLabel(str);//字段名称
        sysDictData.setDictValue("1");//字典键值
        sysDictData.setDictSort(1L);//字典排序
        sysDictData.setDictType("jz_equipment_type_state");//字典类型
        sysDictData.setListClass("success");//表格回显样式
        sysDictData.setIsDefault("Y");//是否默认
        sysDictData.setStatus("0");//默认状态
        sysDictData.setCreateBy(ShiroUtils.getLoginName());//创建人
        sysDictData.setCreateTime(DateUtils.getNowDate());//创建时间
        sysDictData.setRemark(str);//备注
        sysDictDataService.insertDictData(sysDictData);
    }
//    @GetMapping("/selectSysDictData")
//    @ResponseBody
//    public String selectSysDictData(){
//        List<SysDictData> sysDictData = sysDictDataService.selectDictDataByType("jz_equipment_type_state");
//        String json = JSON.toJSONString(sysDictData);
//        return json;
//    }
    /**
     * 查询系统设备列表
     */
    @RequiresPermissions("equipment:equipment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzEquipment jzEquipment)
    {
        startPage();

        List<JzEquipment> list = new ArrayList<>();
        Long userId = ShiroUtils.getUserId();
        SysUser user = sysUserService.selectUserById(userId);
        Set<String> roles = roleService.selectRoleKeys(user.getUserId());
        String id ="";
        // 超级管理员
        if(user.getSearchSystemId()==0){
            if(user.isAdmin()){
                list =  jzEquipmentService.selectJzEquipmentList(jzEquipment);
                // 大班长
            }else if(roles.contains("dbz")){
                List<JzSysUserSystem>  systemIds = sysUserSystemService.selectByUserId(user.getUserId());
                for (JzSysUserSystem systemId : systemIds) {
                    id+=systemId.getSystemId()+",";
                }
                list = jzEquipmentService.selectDbzList(id,
                        jzEquipment.getNum(),jzEquipment.getState(),
                        jzEquipment.getAzName(),jzEquipment.getParams().get("beginInTime"),
                        jzEquipment.getParams().get("endInTime"));

            }else{
                // 普通角色
                jzEquipment.setSystemId(user.getSystemId());
                list =  jzEquipmentService.selectJzEquipmentList(jzEquipment);
            }
        }else{
            jzEquipment.setSystemId(user.getSearchSystemId());
            list =  jzEquipmentService.selectJzEquipmentList(jzEquipment);
        }

//        List<JzEquipment> list = jzEquipmentService.selectJzEquipmentList(jzEquipment);
        return getDataTable(list);
    }


    /**
     * 查询系统设备列表
     */
//    @RequiresPermissions("equipment:equipment:list")
    //@PostMapping("/list1/{id}")
    @PostMapping("/list1")
    @ResponseBody
//    public TableDataInfo list1(@PathVariable("id") Long id)
    public TableDataInfo list1(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        startPage();
        List<JzEquipmentSpecifications> list = jzEquipmentSpecificationsService.esrList(jzEquipmentSpecifications.getSbId());
        return getDataTable(list);
    }
    /**
     *查询设备规格，备品库
     */
    @GetMapping("/specificationsRep/{sbId}")
    public String specificationsRepById(@PathVariable("sbId") Long sbId, ModelMap mmap)
    {

//        mmap.put("jzEquipmentSpecifications", jzEquipmentSpecifications);
        mmap.put("sbId",sbId);
        return prefix + "/specificationsRep";
    }
    /**
     * 导出系统设备列表
     */
    @RequiresPermissions("equipment:equipment:export")
    @Log(title = "系统设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzEquipment jzEquipment)
    {
        List<JzEquipment> list = jzEquipmentService.selectJzEquipmentList(jzEquipment);
        ExcelUtil<JzEquipment> util = new ExcelUtil<JzEquipment>(JzEquipment.class);
        return util.exportExcel(list, "equipment");
    }

    /**
     * 新增系统设备
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存系统设备
     */
    @RequiresPermissions("equipment:equipment:add")
    @Log(title = "系统设备", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzEquipment jzEquipment)
    {
        return toAjax(jzEquipmentService.insertJzEquipment(jzEquipment));
    }

    /**
     * 修改系统设备
     */
    @GetMapping("/edit/{sbId}")
    public String edit(@PathVariable("sbId") Long sbId, ModelMap mmap)
    {
        JzEquipment jzEquipment = jzEquipmentService.selectJzEquipmentById(sbId);
        mmap.put("jzEquipment", jzEquipment);
        return prefix + "/edit";
    }

    /**
     * 修改保存系统设备
     */
    @RequiresPermissions("equipment:equipment:edit")
    @Log(title = "系统设备", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzEquipment jzEquipment)
    {
        return toAjax(jzEquipmentService.updateJzEquipment(jzEquipment));
    }

    /**
     * 删除系统设备
     */
    @RequiresPermissions("equipment:equipment:remove")
    @Log(title = "系统设备", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzEquipmentService.deleteJzEquipmentByIds(ids));
    }
}
