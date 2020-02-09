package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.JzPlanLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 制定计划日志Mapper接口
 * 
 * @author sunli
 * @date 2020-01-09
 */
public interface JzPlanLogMapper 
{
    /**
     * 查询制定计划日志
     * 
     * @param planId 制定计划日志ID
     * @return 制定计划日志
     */
    public JzPlanLog selectJzPlanLogById(Long planId);

    /**
     * 查询制定计划日志列表
     * 
     * @param jzPlanLog 制定计划日志
     * @return 制定计划日志集合
     */
    public List<JzPlanLog> selectJzPlanLogList(JzPlanLog jzPlanLog);

    /**
     * 新增制定计划日志
     * 
     * @param jzPlanLog 制定计划日志
     * @return 结果
     */
    public int insertJzPlanLog(JzPlanLog jzPlanLog);

    /**
     * 修改制定计划日志
     * 
     * @param jzPlanLog 制定计划日志
     * @return 结果
     */
    public int updateJzPlanLog(JzPlanLog jzPlanLog);

    /**
     * 删除制定计划日志
     * 
     * @param planId 制定计划日志ID
     * @return 结果
     */
    public int deleteJzPlanLogById(Long planId);

    /**
     * 批量删除制定计划日志
     * 
     * @param planIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzPlanLogByIds(String[] planIds);

    //    大班查询
    List<JzPlanLog> selectDbzLogList(@Param("array") String[] systemIds,
                                     @Param("longTime") String longTime,
                                     @Param("state") String state);
    // 定时器 添加计划日志
    int insertJzPlanLogList(JzPlanLog planLog);
    // 定时器 添加日值班
    public int riZhiBanList();
    // 定时器 添加日巡检
    public int riXunJianList();
    // 定时器 添加日隐患
    public int riYinHuanList();
    // 定时器 添加周值班
    public int zhouZhiBanList();
    // 定时器 添加周巡检
    public int zhouXunJianList();
    // 定时器 添加周隐患
    public int zhouYinHuanList();
    // 定时器 添加月值班
    public int yueZhiBanList();
    // 定时器 添加月巡检
    public int yueXunJianList();
    // 定时器 添加月隐患
    public int yueYinHuanList();
}
