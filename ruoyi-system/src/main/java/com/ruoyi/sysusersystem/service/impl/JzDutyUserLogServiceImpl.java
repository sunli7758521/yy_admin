package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.sysusersystem.domain.JzDutyUserLog;
import com.ruoyi.sysusersystem.domain.JzInspectionLogVO;
import com.ruoyi.sysusersystem.mapper.JzDutyUserLogMapper;
import com.ruoyi.sysusersystem.service.IJzDutyUserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.domain.JzInspectionLog;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检日志Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-09
 */
@Service
public class JzDutyUserLogServiceImpl implements IJzDutyUserLogService
{
    @Autowired
    private JzDutyUserLogMapper jzDutyUserLogMapper;

    /**
     * 查询巡检日志
     * 
     * @param id 巡检日志ID
     * @return 巡检日志
     */
    @Override
    public JzDutyUserLog selectJzInspectionLogById(Long id)
    {
        return jzDutyUserLogMapper.selectJzDutyUserById(id);
    }

    /**
     * 查询巡检日志列表
     * 
     * @param jzInspectionLog 巡检日志
     * @return 巡检日志
     */
    @Override
    public List<JzDutyUserLog> selectJzInspectionLogList(JzDutyUserLog jzInspectionLog)
    {
        return jzDutyUserLogMapper.selectJzDutyUserList(jzInspectionLog);
    }

    /**
     * 新增巡检日志
     * 
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    @Override
    public int insertJzInspectionLog(JzDutyUserLog jzInspectionLog)
    {
        jzInspectionLog.setCreateTime(DateUtils.getNowDate());
        return jzDutyUserLogMapper.insertJzDutyUser(jzInspectionLog);
    }

    /**
     * 修改巡检日志
     * 
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    @Override
    public int updateJzInspectionLog(JzDutyUserLog jzInspectionLog)
    {
        jzInspectionLog.setUpdateTime(DateUtils.getNowDate());
        return jzDutyUserLogMapper.updateJzDutyUser(jzInspectionLog);
    }

    /**
     * 删除巡检日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzInspectionLogByIds(String ids)
    {
//        return jzDutyUserLogService.deleteJzInspectionLogByIds(Convert.toStrArray(ids));
        return jzDutyUserLogMapper.deleteJzDutyUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 定时器 值班
     * @param ids
     * @return
     */
    @Override
    public int zhiBan(String ids) {
        return jzDutyUserLogMapper.zhiBan(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检日志信息
     * 
     * @param id 巡检日志ID
     * @return 结果
     */
    @Override
    public int deleteJzInspectionLogById(Long id)
    {
        return jzDutyUserLogMapper.deleteJzDutyUserById(id);
    }

    @Override
    public List<JzDutyUserLog> selectDbzLogList(String id, String type, String state,long planId) {
        return jzDutyUserLogMapper.selectDbzLogList(Convert.toStrArray(id),type,state,planId);
    }
}
