package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.sysusersystem.domain.JzHiddenTrouble;
import com.ruoyi.sysusersystem.domain.JzHiddenTroubleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzHiddenTroubleLogMapper;
import com.ruoyi.sysusersystem.domain.JzHiddenTroubleLog;
import com.ruoyi.sysusersystem.service.IJzHiddenTroubleLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * 隐患日志Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-11
 */
@Service
public class JzHiddenTroubleLogServiceImpl implements IJzHiddenTroubleLogService 
{
    @Autowired
    private JzHiddenTroubleLogMapper jzHiddenTroubleLogMapper;

    /**
     * 查询隐患日志
     * 
     * @param hiddenTroubleId 隐患日志ID
     * @return 隐患日志
     */
    @Override
    public JzHiddenTroubleLog selectJzHiddenTroubleLogById(Long hiddenTroubleId)
    {
        return jzHiddenTroubleLogMapper.selectJzHiddenTroubleLogById(hiddenTroubleId);
    }

    /**
     * 查询隐患日志列表
     * 
     * @param jzHiddenTroubleLog 隐患日志
     * @return 隐患日志
     */
    @Override
    public List<JzHiddenTroubleLog> selectJzHiddenTroubleLogList(JzHiddenTroubleLog jzHiddenTroubleLog)
    {
        return jzHiddenTroubleLogMapper.selectJzHiddenTroubleLogList(jzHiddenTroubleLog);
    }

    /**
     * 新增隐患日志
     * 
     * @param jzHiddenTroubleLog 隐患日志
     * @return 结果
     */
    @Override
    public int insertJzHiddenTroubleLog(JzHiddenTroubleLog jzHiddenTroubleLog)
    {
        jzHiddenTroubleLog.setCreateTime(DateUtils.getNowDate());
        return jzHiddenTroubleLogMapper.insertJzHiddenTroubleLog(jzHiddenTroubleLog);
    }

    /**
     * 修改隐患日志
     * 
     * @param jzHiddenTroubleLog 隐患日志
     * @return 结果
     */
    @Override
    public int updateJzHiddenTroubleLog(JzHiddenTroubleLog jzHiddenTroubleLog)
    {
        jzHiddenTroubleLog.setUpdateTime(DateUtils.getNowDate());
        return jzHiddenTroubleLogMapper.updateJzHiddenTroubleLog(jzHiddenTroubleLog);
    }

    /**
     * 删除隐患日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzHiddenTroubleLogByIds(String ids)
    {
        return jzHiddenTroubleLogMapper.deleteJzHiddenTroubleLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除隐患日志信息
     * 
     * @param hiddenTroubleId 隐患日志ID
     * @return 结果
     */
    @Override
    public int deleteJzHiddenTroubleLogById(Long hiddenTroubleId)
    {
        return jzHiddenTroubleLogMapper.deleteJzHiddenTroubleLogById(hiddenTroubleId);
    }

    /**
     * 预览隐患项
     *
     * @param
     * @return 结果
     */
    @Override
    public List<JzHiddenTroubleVO> selectHiddenTroubleLogList(JzHiddenTroubleLog log) {
        return jzHiddenTroubleLogMapper.selectHiddenTroubleLogList(log);
    }
    /**
     * 定时器 隐患
     * @param ids
     * @return
     */
    @Override
    public int yinHuan(String ids) {
        return jzHiddenTroubleLogMapper.yinHuan(Convert.toStrArray(ids));
    }

}
