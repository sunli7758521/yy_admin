package com.ruoyi.emergency.mapper;

import com.ruoyi.emergency.domain.JzEmergencyPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 应急方案Mapper接口
 *
 * @author sunli
 * @date 2020-01-04
 */
public interface JzEmergencyPlanMapper
{
    /**
     * 查询应急方案
     *
     * @param planId 应急方案ID
     * @return 应急方案
     */
    public JzEmergencyPlan selectJzEmergencyPlanById(Long planId);

    /**
     * 查询应急方案列表
     *
     * @param jzEmergencyPlan 应急方案
     * @return 应急方案集合
     */
    public List<JzEmergencyPlan> selectJzEmergencyPlanList(JzEmergencyPlan jzEmergencyPlan);

    /**
     * 新增应急方案
     *
     * @param jzEmergencyPlan 应急方案
     * @return 结果
     */
    public int insertJzEmergencyPlan(JzEmergencyPlan jzEmergencyPlan);

    /**
     * 修改应急方案
     *
     * @param jzEmergencyPlan 应急方案
     * @return 结果
     */
    public int updateJzEmergencyPlan(JzEmergencyPlan jzEmergencyPlan);

    /**
     * 删除应急方案
     *
     * @param planId 应急方案ID
     * @return 结果
     */
    public int deleteJzEmergencyPlanById(Long planId);

    /**
     * 批量删除应急方案
     *
     * @param planIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEmergencyPlanByIds(String[] planIds);

    /**
     * 根据ID获取文件地址
     * @param managementId
     * @return
     */
    public String selectFileUrlByPlanId(Long managementId);

    /**
     * 获取下拉列表
     * 应急物资表中计划和ID
     * @return
     */
    public List<JzEmergencyPlan> emergencySuppliesList();

    /**
     * 大班长查询
     * @param id
     * @param countNum
     * @param state
     * @param title
     * @return
     */
    public List<JzEmergencyPlan> selectDbzList(@Param("array") String[] systemIds,
                                               @Param("typeId") Long typeId,
                                               @Param("state") String state,
                                               @Param("title") String title);
}
