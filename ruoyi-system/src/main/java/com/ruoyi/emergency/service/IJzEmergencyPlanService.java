package com.ruoyi.emergency.service;

import com.ruoyi.emergency.domain.JzEmergencyPlan;
import java.util.List;

/**
 * 应急方案Service接口
 *
 * @author sunli
 * @date 2020-01-04
 */
public interface IJzEmergencyPlanService
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
     * 批量删除应急方案
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEmergencyPlanByIds(String ids);

    /**
     * 删除应急方案信息
     *
     * @param planId 应急方案ID
     * @return 结果
     */
    public int deleteJzEmergencyPlanById(Long planId);

    /**
     * 根据ID获取文件地址
     * @param managementId
     * @return
     */
    public String selectFileUrlByPlanId(Long managementId);

    /**
     *
     * 下拉列表
     * 获取应急物资表中计划名称和ID
     * @return
     */
    public List<JzEmergencyPlan> emergencySuppliesList();

    /**
     * 大班长查询
     * @param id
     * @param countNum
     * @param state
     * @param title
     * @param beginInTime
     * @param endInTime
     * @return
     */
    public List<JzEmergencyPlan> selectDbzList(String id, Long typeId, String state, String title);
}
