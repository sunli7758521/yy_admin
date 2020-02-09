package com.ruoyi.equipment.service;

import com.ruoyi.equipment.domain.JzEquipmentSpecifications;
import java.util.List;

/**
 * 设备规格Service接口
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public interface IJzEquipmentSpecificationsService 
{
    /**
     * 查询设备规格
     * 
     * @param spId 设备规格ID
     * @return 设备规格
     */
    public JzEquipmentSpecifications selectJzEquipmentSpecificationsById(Long spId);

    /**
     * 查询设备规格列表
     * 
     * @param jzEquipmentSpecifications 设备规格
     * @return 设备规格集合
     */
    public List<JzEquipmentSpecifications> selectJzEquipmentSpecificationsList(JzEquipmentSpecifications jzEquipmentSpecifications);
    /**
     * 设备规格下拉框
     * */
    public List<JzEquipmentSpecifications>  esList();
    /**
     * 新增设备规格
     * 
     * @param jzEquipmentSpecifications 设备规格
     * @return 结果
     */
    public int insertJzEquipmentSpecifications(JzEquipmentSpecifications jzEquipmentSpecifications);

    /**
     * 修改设备规格
     * 
     * @param jzEquipmentSpecifications 设备规格
     * @return 结果
     */
    public int updateJzEquipmentSpecifications(JzEquipmentSpecifications jzEquipmentSpecifications);

    /**
     * 改设备规格,设备库
     *
     * @param jzEquipmentSpecifications 设备规格
     * @return 结果
     */
    public int updateJzEquipmentSpecificationsRep(JzEquipmentSpecifications jzEquipmentSpecifications);

    /**
     * 批量删除设备规格
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEquipmentSpecificationsByIds(String ids);

    /**
     * 删除设备规格信息
     * 
     * @param spId 设备规格ID
     * @return 结果
     */
    public int deleteJzEquipmentSpecificationsById(Long spId);

    /**
     * 查询设备规格，备品库
     *
     * @param sbId 设备规格ID
     * @return 设备规格
     */
    public List<JzEquipmentSpecifications> esrList(Long sbId);
    /**
     * 查询设备规格,备品库列表
     *
     * @param jzEquipmentSpecifications 设备规格
     * @return 设备规格集合
     */
    public List<JzEquipmentSpecifications> selectJzEquipmentSpecificationsRepList(JzEquipmentSpecifications jzEquipmentSpecifications);
}
