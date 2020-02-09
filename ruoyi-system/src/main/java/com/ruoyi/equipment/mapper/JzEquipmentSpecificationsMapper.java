package com.ruoyi.equipment.mapper;

import com.ruoyi.equipment.domain.JzEquipmentSpecifications;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设备规格Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public interface JzEquipmentSpecificationsMapper 
{
    /**
     * 查询设备规格
     * 
     * @param spId 设备规格ID
     * @return 设备规格
     */
    public JzEquipmentSpecifications selectJzEquipmentSpecificationsById(Long spId);

    /**
     * 设备规格下拉框
     * */
    public List<JzEquipmentSpecifications>  esList();
    /**
     * 查询设备规格列表
     * 
     * @param jzEquipmentSpecifications 设备规格
     * @return 设备规格集合
     */
    public List<JzEquipmentSpecifications> selectJzEquipmentSpecificationsList(JzEquipmentSpecifications jzEquipmentSpecifications);

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
     * 修改设备规格备件库
     *
     * @param jzEquipmentSpecifications 设备规格
     * @return 结果
     */
    public int updateJzEquipmentSpecificationsRep(JzEquipmentSpecifications jzEquipmentSpecifications);

    /**
     * 删除设备规格
     * 
     * @param spId 设备规格ID
     * @return 结果
     */
    public int deleteJzEquipmentSpecificationsById(Long spId);

    /**
     * 批量删除设备规格
     * 
     * @param spIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEquipmentSpecificationsByIds(String[] spIds);
    /**
     * 查询设备规格，备品库
     *
     * @param sbId 设备规格ID
     * @return 设备规格
     */
    public List<JzEquipmentSpecifications> esrList(@Param("sbId") Long sbId);

    /**
     * 查询设备规格,备品库列表
     *
     * @param jzEquipmentSpecifications 设备规格
     * @return 设备规格集合
     */
    public List<JzEquipmentSpecifications> selectJzEquipmentSpecificationsRepList(JzEquipmentSpecifications jzEquipmentSpecifications);
}
