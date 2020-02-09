package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzPlanLogMapper;
import com.ruoyi.sysusersystem.domain.JzPlanLog;
import com.ruoyi.sysusersystem.service.IJzPlanLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * 制定计划日志Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-09
 */
@Service
public class JzPlanLogServiceImpl implements IJzPlanLogService 
{
    @Autowired
    private JzPlanLogMapper jzPlanLogMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询制定计划日志
     * 
     * @param planId 制定计划日志ID
     * @return 制定计划日志
     */
    @Override
    public JzPlanLog selectJzPlanLogById(Long planId)
    {
        return jzPlanLogMapper.selectJzPlanLogById(planId);
    }

    /**
     * 查询制定计划日志列表
     * 
     * @param jzPlanLog 制定计划日志
     * @return 制定计划日志
     */
    @Override
    public List<JzPlanLog> selectJzPlanLogList(JzPlanLog jzPlanLog)
    {

        List<JzPlanLog> list= jzPlanLogMapper.selectJzPlanLogList(jzPlanLog);
        if(list !=null){
            for (JzPlanLog plan : list) {
                SysDept dept = sysDeptMapper.selectById(plan.getSystemId());
                if(dept !=null){
                    plan.setSystemName(dept.getDeptName());
                }
            }
        }
        return list;
    }

    /**
     * 新增制定计划日志
     * 
     * @param jzPlanLog 制定计划日志
     * @return 结果
     */
    @Override
    public int insertJzPlanLog(JzPlanLog jzPlanLog)
    {
        jzPlanLog.setCreateTime(DateUtils.getNowDate());
        return jzPlanLogMapper.insertJzPlanLog(jzPlanLog);
    }

    /**
     * 修改制定计划日志
     * 
     * @param jzPlanLog 制定计划日志
     * @return 结果
     */
    @Override
    public int updateJzPlanLog(JzPlanLog jzPlanLog)
    {
        jzPlanLog.setUpdateTime(DateUtils.getNowDate());
        return jzPlanLogMapper.updateJzPlanLog(jzPlanLog);
    }

    /**
     * 删除制定计划日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzPlanLogByIds(String ids)
    {
        return jzPlanLogMapper.deleteJzPlanLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除制定计划日志信息
     * 
     * @param planId 制定计划日志ID
     * @return 结果
     */
    @Override
    public int deleteJzPlanLogById(Long planId)
    {
        return jzPlanLogMapper.deleteJzPlanLogById(planId);
    }
    //    大班查询
    @Override
    public List<JzPlanLog> selectDbzLogList(String id,  String longTime, String state) {
        return jzPlanLogMapper.selectDbzLogList(Convert.toStrArray(id),longTime,state);
    }
    // 定时器 添加日值班
    @Override
    public int riZhiBanList() {
        return jzPlanLogMapper.riZhiBanList();
    }
    // 定时器 添加日巡检
    @Override
    public int riXunJianList() {
        return jzPlanLogMapper.riXunJianList();
    }
    // 定时器 添加日隐患
    @Override
    public int riYinHuanList() {
        return jzPlanLogMapper.riYinHuanList();
    }
    // 定时器 添加周值班
    @Override
    public int zhouZhiBanList() {
        return jzPlanLogMapper.zhouZhiBanList();
    }
    // 定时器 添加周巡检
    @Override
    public int zhouXunJianList() {
        return jzPlanLogMapper.zhouXunJianList();
    }
    // 定时器 添加周隐患
    @Override
    public int zhouYinHuanList() {
        return jzPlanLogMapper.zhouYinHuanList();
    }
    // 定时器 添加月值班
    @Override
    public int yueZhiBanList() {
        return jzPlanLogMapper.yueZhiBanList();
    }
    // 定时器 添加月巡检
    @Override
    public int yueXunJianList() {
        return jzPlanLogMapper.yueXunJianList();
    }
    // 定时器 添加月隐患
    @Override
    public int yueYinHuanList() {
        return jzPlanLogMapper.yueYinHuanList();
    }

    // 添加计划日志
    @Override
    public int insertJzPlanLogList(JzPlanLog planLog) {
       return jzPlanLogMapper.insertJzPlanLogList(planLog);
    }
}
