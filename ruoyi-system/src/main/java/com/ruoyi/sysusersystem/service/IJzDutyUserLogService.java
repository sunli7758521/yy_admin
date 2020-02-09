package com.ruoyi.sysusersystem.service;

import com.ruoyi.sysusersystem.domain.JzDutyUserLog;
import com.ruoyi.sysusersystem.domain.JzInspectionLog;
import com.ruoyi.sysusersystem.domain.JzInspectionLogVO;
import com.ruoyi.sysusersystem.domain.JzPlanLog;

import java.util.List;

/**
 * 值日日志Service接口
 *
 * @author sunli
 * @date 2020-01-09
 */
public interface IJzDutyUserLogService
{
    /**
     * 查询巡检日志
     *
     * @param id 巡检日志ID
     * @return 巡检日志
     */
    public JzDutyUserLog selectJzInspectionLogById(Long id);

    /**
     * 查询巡检日志列表
     *
     * @param jzInspectionLog 巡检日志
     * @return 巡检日志集合
     */
    public List<JzDutyUserLog> selectJzInspectionLogList(JzDutyUserLog jzInspectionLog);

    /**
     * 新增巡检日志
     *
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    public int insertJzInspectionLog(JzDutyUserLog jzInspectionLog);

    /**
     * 修改巡检日志
     *
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    public int updateJzInspectionLog(JzDutyUserLog jzInspectionLog);

    /**
     * 批量删除巡检日志
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzInspectionLogByIds(String ids);

    /**
     * 定时器 值班
     * @param ids
     * @return
     */
    public  int zhiBan(String ids);

    /**
     * 删除巡检日志信息
     *
     * @param id 巡检日志ID
     * @return 结果
     */
    public int deleteJzInspectionLogById(Long id);

    //    大班查询
    List<JzDutyUserLog> selectDbzLogList(String id, String type, String state,long planId);
}
