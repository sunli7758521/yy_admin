package com.ruoyi.equipment.service;

import com.ruoyi.equipment.domain.JzEquipmentRep;
import java.util.List;

/**
 * 设备备品件库Service接口
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public interface IJzEquipmentRepService 
{
    /**
     * 查询设备备品件库
     * 
     * @param id 设备备品件库ID
     * @return 设备备品件库
     */
    public JzEquipmentRep selectJzEquipmentRepById(Long id);

    /**
     * 查询设备备品件库列表
     * 
     * @param jzEquipmentRep 设备备品件库
     * @return 设备备品件库集合
     */
    public List<JzEquipmentRep> selectJzEquipmentRepList(JzEquipmentRep jzEquipmentRep);

    /**
     * 新增设备备品件库
     * 
     * @param jzEquipmentRep 设备备品件库
     * @return 结果
     */
    public int insertJzEquipmentRep(JzEquipmentRep jzEquipmentRep);

    /**
     * 修改设备备品件库
     * 
     * @param jzEquipmentRep 设备备品件库
     * @return 结果
     */
    public int updateJzEquipmentRep(JzEquipmentRep jzEquipmentRep);

    /**
     * 批量删除设备备品件库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEquipmentRepByIds(String ids);

    /**
     * 删除设备备品件库信息
     * 
     * @param id 设备备品件库ID
     * @return 结果
     */
    public int deleteJzEquipmentRepById(Long id);
}
