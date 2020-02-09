package com.ruoyi.equipment.mapper;

import com.ruoyi.equipment.domain.JzEquipment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统设备Mapper接口
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public interface JzEquipmentMapper 
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
     * 删除系统设备
     * 
     * @param sbId 系统设备ID
     * @return 结果
     */
    public int deleteJzEquipmentById(Long sbId);

    /**
     * 批量删除系统设备
     * 
     * @param sbIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEquipmentByIds(String[] sbIds);

    /**
     * 系统设备下拉列表
     * @return 系统设备
     */
    public List<JzEquipment> sbList();

    /**
     *  大班长查询数据
     */
    List<JzEquipment> selectDbzList(@Param("array") String[] systemIds,
                                    @Param("num") String num,
                                    @Param("state") String state, @Param("azName") String azName,
                                    @Param("beginInTime") Object beginInTime, @Param("endInTime") Object endInTime);
}
