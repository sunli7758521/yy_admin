package com.ruoyi.equipment.service;

import com.ruoyi.equipment.domain.JzEquipment;
import java.util.List;

/**
 * 系统设备Service接口
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public interface IJzEquipmentService 
{
    /**
     * 查询系统设备
     * 
     * @param sbId 系统设备ID
     * @return 系统设备
     */
    public JzEquipment selectJzEquipmentById(Long sbId);

    /**
     * 查询系统设备列表
     * 
     * @param jzEquipment 系统设备
     * @return 系统设备集合
     */
    public List<JzEquipment> selectJzEquipmentList(JzEquipment jzEquipment);

    /**
     * 新增系统设备
     * 
     * @param jzEquipment 系统设备
     * @return 结果
     */
    public int insertJzEquipment(JzEquipment jzEquipment);

    /**
     * 修改系统设备
     * 
     * @param jzEquipment 系统设备
     * @return 结果
     */
    public int updateJzEquipment(JzEquipment jzEquipment);

    /**
     * 批量删除系统设备
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEquipmentByIds(String ids);

    /**
     * 删除系统设备信息
     * 
     * @param sbId 系统设备ID
     * @return 结果
     */
    public int deleteJzEquipmentById(Long sbId);

    /**
     * 系统设备下拉列表
     * @return 系统设备
     */
    public List<JzEquipment> sbList();

    /**
     *  大班长查询数据
     */
    List<JzEquipment> selectDbzList(String id, String num, String state, String azName, Object beginInTime, Object endInTime);
}
