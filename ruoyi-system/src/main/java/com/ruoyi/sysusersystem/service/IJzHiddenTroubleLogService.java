package com.ruoyi.sysusersystem.service;

import com.ruoyi.sysusersystem.domain.JzHiddenTrouble;
import com.ruoyi.sysusersystem.domain.JzHiddenTroubleLog;
import com.ruoyi.sysusersystem.domain.JzHiddenTroubleVO;

import java.util.List;

/**
 * 隐患日志Service接口
 * 
 * @author sunli
 * @date 2020-01-11
 */
public interface IJzHiddenTroubleLogService 
{
    /**
     * 查询隐患日志
     * 
     * @param hiddenTroubleId 隐患日志ID
     * @return 隐患日志
     */
    public JzHiddenTroubleLog selectJzHiddenTroubleLogById(Long hiddenTroubleId);

    /**
     * 查询隐患日志列表
     * 
     * @param jzHiddenTroubleLog 隐患日志
     * @return 隐患日志集合
     */
    public List<JzHiddenTroubleLog> selectJzHiddenTroubleLogList(JzHiddenTroubleLog jzHiddenTroubleLog);

    /**
     * 新增隐患日志
     * 
     * @param jzHiddenTroubleLog 隐患日志
     * @return 结果
     */
    public int insertJzHiddenTroubleLog(JzHiddenTroubleLog jzHiddenTroubleLog);

    /**
     * 修改隐患日志
     * 
     * @param jzHiddenTroubleLog 隐患日志
     * @return 结果
     */
    public int updateJzHiddenTroubleLog(JzHiddenTroubleLog jzHiddenTroubleLog);

    /**
     * 批量删除隐患日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzHiddenTroubleLogByIds(String ids);

    /**
     * 删除隐患日志信息
     * 
     * @param hiddenTroubleId 隐患日志ID
     * @return 结果
     */
    public int deleteJzHiddenTroubleLogById(Long hiddenTroubleId);

//    /**
//     * 预览隐患项
//     *
//     * @param
//     * @return 结果
//     */
//
//    List<JzHiddenTroubleVO> selectHiddenTroubleList(JzHiddenTrouble log);

    /**
     * 预览隐患项
     *
     * @param
     * @return 结果
     */

    List<JzHiddenTroubleVO> selectHiddenTroubleLogList(JzHiddenTroubleLog log);


    /**
     *  定时器 隐患
     * @param ids
     * @return
     */
    public int yinHuan(String ids);
}
