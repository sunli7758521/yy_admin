package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.sysusersystem.domain.JzInspectionLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzInspectionLogMapper;
import com.ruoyi.sysusersystem.domain.JzInspectionLog;
import com.ruoyi.sysusersystem.service.IJzInspectionLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检日志Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-09
 */
@Service
public class JzInspectionLogServiceImpl implements IJzInspectionLogService 
{
    @Autowired
    private JzInspectionLogMapper jzInspectionLogMapper;

    /**
     * 查询巡检日志
     * 
     * @param id 巡检日志ID
     * @return 巡检日志
     */
    @Override
    public JzInspectionLog selectJzInspectionLogById(Long id)
    {
        return jzInspectionLogMapper.selectJzInspectionLogById(id);
    }

    /**
     * 查询巡检日志列表
     * 
     * @param jzInspectionLog 巡检日志
     * @return 巡检日志
     */
    @Override
    public List<JzInspectionLog> selectJzInspectionLogList(JzInspectionLog jzInspectionLog)
    {
        return jzInspectionLogMapper.selectJzInspectionLogList(jzInspectionLog);
    }

    /**
     * 新增巡检日志
     * 
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    @Override
    public int insertJzInspectionLog(JzInspectionLog jzInspectionLog)
    {
        jzInspectionLog.setCreateTime(DateUtils.getNowDate());
        return jzInspectionLogMapper.insertJzInspectionLog(jzInspectionLog);
    }

    /**
     * 修改巡检日志
     * 
     * @param jzInspectionLog 巡检日志
     * @return 结果
     */
    @Override
    public int updateJzInspectionLog(JzInspectionLog jzInspectionLog)
    {
        jzInspectionLog.setUpdateTime(DateUtils.getNowDate());
        return jzInspectionLogMapper.updateJzInspectionLog(jzInspectionLog);
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
        return jzInspectionLogMapper.deleteJzInspectionLogByIds(Convert.toStrArray(ids));
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
        return jzInspectionLogMapper.deleteJzInspectionLogById(id);
    }

    /**
     *
     * 预览设备检查项
     */
    @Override
    public List<JzInspectionLogVO> selectLogList(JzInspectionLog log) {
        return jzInspectionLogMapper.selectLogList(log);
    }
    /**
     * 定时器 巡检
     * @param ids
     * @return
     */
    @Override
    public int xunJian(String ids) {
        return jzInspectionLogMapper.xunJian(Convert.toStrArray(ids));
    }
}
