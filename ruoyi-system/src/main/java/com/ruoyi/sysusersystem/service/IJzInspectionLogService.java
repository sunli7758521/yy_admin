package com.ruoyi.sysusersystem.service;

import com.ruoyi.sysusersystem.domain.JzInspectionLog;
import com.ruoyi.sysusersystem.domain.JzInspectionLogVO;

import java.util.List;

/**
 * 巡检日志Service接口
 * 
 * @author sunli
 * @date 2020-01-09
 */
public interface IJzInspectionLogService 
{
    /**
     * 查询巡检日志
     * 
     * @param id 巡检日志ID
     * @return 巡检日志
     */
    public JzInspectionLog selectJzInspectionLogById(Long id);

    /**
     * 查询巡检日志列表
     * 
     * @param jzInspectionLog 巡检日志
     * @return 巡检日志集合
     */
    public List<JzInspectionLog> selectJzInspectionLogList(JzInspectionLog jzInspectionLog);

    /**
     * 新增巡检日志
     * 
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    public int insertJzInspectionLog(JzInspectionLog jzInspectionLog);

    /**
     * 修改巡检日志
     * 
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    public int updateJzInspectionLog(JzInspectionLog jzInspectionLog);

    /**
     * 批量删除巡检日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzInspectionLogByIds(String ids);

    /**
     * 删除巡检日志信息
     * 
     * @param id 巡检日志ID
     * @return 结果
     */
    public int deleteJzInspectionLogById(Long id);

    /**
     *
     * 预览设备检查项
     */
    List<JzInspectionLogVO> selectLogList(JzInspectionLog log);

    /**
     *  定时器 巡检
     * @param ids
     * @return
     */
    public int xunJian(String ids);
}
