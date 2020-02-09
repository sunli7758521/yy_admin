package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 巡检日志Mapper接口
 * 
 * @author sunli
 * @date 2020-01-09
 */
public interface JzDutyUserLogMapper 
{
    /**
     * 查询巡检日志
     *
     * @param id 巡检日志ID
     * @return 巡检日志
     */
    public JzDutyUserLog selectJzDutyUserById(Long id);

    /**
     * 查询巡检日志列表
     * 
     * @param jzInspectionLog 巡检日志
     * @return 巡检日志集合
     */
    public List<JzDutyUserLog> selectJzDutyUserList(JzDutyUserLog jzInspectionLog);

    /**
     * 新增巡检日志
     * 
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    public int insertJzDutyUser(JzDutyUserLog jzInspectionLog);

    /**
     * 修改巡检日志
     * 
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    public int updateJzDutyUser(JzDutyUserLog jzInspectionLog);

    /**
     * 删除巡检日志
     * 
     * @param id 巡检日志ID
     * @return 结果
     */
    public int deleteJzDutyUserById(Long id);

    /**
     * 批量删除巡检日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzDutyUserByIds(String[] ids);

    // 定时器 添加值班计划日志
    public int insertJzPlanLogList(long planLog);

    //    大班查询
    List<JzDutyUserLog> selectDbzLogList(@Param("array") String[] systemIds,
                                     @Param("type") String type,
                                     @Param("state") String state,
                                         @Param("planId") Long planId);

    /**
     *  定时器 值班
     * @param ids
     * @return
     */
    public int zhiBan(String[] ids);

}
