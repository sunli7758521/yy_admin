package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.JzPlan;
import java.util.List;

/**
 * 制定计划Mapper接口
 * 
 * @author sunli
 * @date 2019-12-31
 */
public interface JzPlanMapper 
{
    /**
     * 查询制定计划
     * 
     * @param planId 制定计划ID
     * @return 制定计划
     */
    public JzPlan selectJzPlanById(Long planId);

    /**
     * 查询制定计划列表
     * 
     * @param jzPlan 制定计划
     * @return 制定计划集合
     */
    public List<JzPlan> selectJzPlanList(JzPlan jzPlan);

    /**
     * 新增制定计划
     * 
     * @param jzPlan 制定计划
     * @return 结果
     */
    public int insertJzPlan(JzPlan jzPlan);

    /**
     * 修改制定计划
     * 
     * @param jzPlan 制定计划
     * @return 结果
     */
    public int updateJzPlan(JzPlan jzPlan);

    /**
     * 删除制定计划
     * 
     * @param planId 制定计划ID
     * @return 结果
     */
    public int deleteJzPlanById(Long planId);

    /**
     * 批量删除制定计划
     * 
     * @param planIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzPlanByIds(String[] planIds);

    /**
     * 获取巡查列表名称
     * @return
     */
    public List<JzPlan> selectTitle();
    // 定时器 添加日值班
    public List<JzPlan> riZhiBanList();
    // 定时器 添加日巡检
    public List<JzPlan> riXunJianList();
    // 定时器 添加日隐患
    public List<JzPlan> riYinHuanList();
    // 定时器 添加周值班
    public List<JzPlan> zhouZhiBanList();
    // 定时器 添加周巡检
    public List<JzPlan> zhouXunJianList();
    // 定时器 添加周隐患
    public List<JzPlan> zhouYinHuanList();
    // 定时器 添加月值班
    public List<JzPlan> yueZhiBanList();
    // 定时器 添加月巡检
    public List<JzPlan> yueXunJianList();
    // 定时器 添加月隐患
    public List<JzPlan> yueYinHuanList();
}
