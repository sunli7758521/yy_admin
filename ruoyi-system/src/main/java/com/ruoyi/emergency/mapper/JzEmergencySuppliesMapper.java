package com.ruoyi.emergency.mapper;

import com.ruoyi.emergency.domain.JzEmergencySupplies;
import java.util.List;

/**
 * 应急方案关联物资Mapper接口
 *
 * @author sunli
 * @date 2020-01-04
 */
public interface JzEmergencySuppliesMapper
{
    /**
     * 查询应急方案关联物资
     *
     * @param suppliseId 应急方案关联物资ID
     * @return 应急方案关联物资
     */
    public JzEmergencySupplies selectJzEmergencySuppliesById(Long suppliseId);

    /**
     * 查询剩余总数量
     * @param suppliseSmTypeId
     * @return
     */
    public Integer selectSum(Long suppliseSmTypeId);

    /**
     * 查询应急方案关联物资列表
     *
     * @param jzEmergencySupplies 应急方案关联物资
     * @return 应急方案关联物资集合
     */
    public List<JzEmergencySupplies> selectJzEmergencySuppliesList(JzEmergencySupplies jzEmergencySupplies);

    /**
     * 新增应急方案关联物资
     *
     * @param jzEmergencySupplies 应急方案关联物资
     * @return 结果
     */
    public int insertJzEmergencySupplies(JzEmergencySupplies jzEmergencySupplies);

    /**
     * 修改应急方案关联物资
     *
     * @param jzEmergencySupplies 应急方案关联物资
     * @return 结果
     */
    public int updateJzEmergencySupplies(JzEmergencySupplies jzEmergencySupplies);

    /**
     * 删除应急方案关联物资
     *
     * @param suppliseId 应急方案关联物资ID
     * @return 结果
     */
    public int deleteJzEmergencySuppliesById(Long suppliseId);

    /**
     * 批量删除应急方案关联物资
     *
     * @param suppliseIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEmergencySuppliesByIds(String[] suppliseIds);
}
