package com.ruoyi.guanlisystem.service;

import com.ruoyi.equipment.domain.JzEquipment;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.system.domain.SysDept;

import java.util.List;

/**
 * 系统用户管理的系统Service接口
 * 
 * @author sunli
 * @date 2020-01-02
 */
public interface IJzSysUserSystemService 
{
    /**
     * 查询系统用户管理的系统
     * 
     * @param id 系统用户管理的系统ID
     * @return 系统用户管理的系统
     */
    public JzSysUserSystem selectJzSysUserSystemById(Long id);

    /**
     * 查询系统用户管理的系统列表
     * 
     * @param jzSysUserSystem 系统用户管理的系统
     * @return 系统用户管理的系统集合
     */
    public List<JzSysUserSystem> selectJzSysUserSystemList(JzSysUserSystem jzSysUserSystem);

    /**
     * 新增系统用户管理的系统
     * 
     * @param jzSysUserSystem 系统用户管理的系统
     * @return 结果
     */
    public int insertJzSysUserSystem(JzSysUserSystem jzSysUserSystem);

    /**
     * 修改系统用户管理的系统
     * 
     * @param jzSysUserSystem 系统用户管理的系统
     * @return 结果
     */
    public int updateJzSysUserSystem(JzSysUserSystem jzSysUserSystem);

    /**
     * 批量删除系统用户管理的系统
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzSysUserSystemByIds(String ids);

    /**
     * 删除系统用户管理的系统信息
     * 
     * @param id 系统用户管理的系统ID
     * @return 结果
     */
    public int deleteJzSysUserSystemById(Long id);
   //    查询管理系统
    List<SysDept> selectGuanliSystem(Long userId);
   //  通过用户id 查询管理系统id
    List<JzSysUserSystem> selectByUserId(Long userId);
}
