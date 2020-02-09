package com.ruoyi.emergency.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.emergency.mapper.JzEmergencyPlanMapper;
import com.ruoyi.emergency.domain.JzEmergencyPlan;
import com.ruoyi.emergency.service.IJzEmergencyPlanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 应急方案Service业务层处理
 *
 * @author sunli
 * @date 2020-01-04
 */
@Service
public class JzEmergencyPlanServiceImpl implements IJzEmergencyPlanService
{
    @Autowired
    private JzEmergencyPlanMapper jzEmergencyPlanMapper;

    /**
     * 查询应急方案
     *
     * @param planId 应急方案ID
     * @return 应急方案
     */
    @Override
    public JzEmergencyPlan selectJzEmergencyPlanById(Long planId)
    {
        return jzEmergencyPlanMapper.selectJzEmergencyPlanById(planId);
    }

    /**
     * 查询应急方案列表
     *
     * @param jzEmergencyPlan 应急方案
     * @return 应急方案
     */
    @Override
    public List<JzEmergencyPlan> selectJzEmergencyPlanList(JzEmergencyPlan jzEmergencyPlan)
    {
        return jzEmergencyPlanMapper.selectJzEmergencyPlanList(jzEmergencyPlan);
    }

    /**
     * 新增应急方案
     *
     * @param jzEmergencyPlan 应急方案
     * @return 结果
     */
    @Override
    public int insertJzEmergencyPlan(JzEmergencyPlan jzEmergencyPlan)
    {
        jzEmergencyPlan.setCreateTime(DateUtils.getNowDate());
        return jzEmergencyPlanMapper.insertJzEmergencyPlan(jzEmergencyPlan);
    }

    /**
     * 修改应急方案
     *
     * @param jzEmergencyPlan 应急方案
     * @return 结果
     */
    @Override
    public int updateJzEmergencyPlan(JzEmergencyPlan jzEmergencyPlan)
    {
        jzEmergencyPlan.setUpdateTime(DateUtils.getNowDate());
        return jzEmergencyPlanMapper.updateJzEmergencyPlan(jzEmergencyPlan);
    }

    /**
     * 删除应急方案对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzEmergencyPlanByIds(String ids)
    {
        return jzEmergencyPlanMapper.deleteJzEmergencyPlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除应急方案信息
     *
     * @param planId 应急方案ID
     * @return 结果
     */
    @Override
    public int deleteJzEmergencyPlanById(Long planId)
    {
        return jzEmergencyPlanMapper.deleteJzEmergencyPlanById(planId);
    }

    /**
     * 根据ID获取文件地址
     *
     * @param managementId
     * @return
     */
    @Override
    public String selectFileUrlByPlanId(Long managementId) {
        return jzEmergencyPlanMapper.selectFileUrlByPlanId(managementId);
    }

    /**
     * 下拉列表
     * 获取应急物资表中计划名称和ID
     *
     * @return
     */
    @Override
    public List<JzEmergencyPlan> emergencySuppliesList() {
        return jzEmergencyPlanMapper.emergencySuppliesList();
    }

    /**
     * 大班长查询
     *
     * @param id
     * @param typeId
     * @param state
     * @param title
     * @return
     */
    @Override
    public List<JzEmergencyPlan> selectDbzList(String id, Long typeId, String state, String title) {
        return jzEmergencyPlanMapper.selectDbzList(Convert.toStrArray(id), typeId, state, title);
    }

}
