package com.ruoyi.sysusersystem.service.impl;

import java.beans.Transient;
import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.sysusersystem.domain.JzInspectionLog;
import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.mapper.JzInspectionLogMapper;
import com.ruoyi.sysusersystem.mapper.JzPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzInspectionMapper;
import com.ruoyi.sysusersystem.domain.JzInspection;
import com.ruoyi.sysusersystem.service.IJzInspectionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 巡检Service业务层处理
 * 
 * @author sunli
 * @date 2019-12-30
 */
@Service
public class JzInspectionServiceImpl implements IJzInspectionService 
{
    @Autowired
    private JzInspectionMapper jzInspectionMapper;

    @Autowired
    private JzPlanMapper jzPlanMapper;

    @Autowired
    private JzInspectionLogMapper jzInspectionLogMapper;

    /**
     * 获取巡查计划名称
     *
     * @return
     */
    @Override
    public List<JzInspection> selectTitle() {
        return jzInspectionMapper.selectTitle();
    }

    /**
     * 查询巡检
     * 
     * @param id 巡检ID
     * @return 巡检
     */
    @Override
    public JzInspection selectJzInspectionById(Long id)
    {
        return jzInspectionMapper.selectJzInspectionById(id);
    }

    /**
     * 查询巡检列表
     * 
     * @param jzInspection 巡检
     * @return 巡检
     */
    @Override
    public List<JzInspection> selectJzInspectionList(JzInspection jzInspection)
    {
        return jzInspectionMapper.selectJzInspectionList(jzInspection);
    }

    /**
     * 新增巡检
     * 
     * @param jzInspection 巡检
     * @return 结果
     */
    @Override
    public int insertJzInspection(JzInspection jzInspection)
    {
        int i=0;
        JzPlan jzPlan = jzPlanMapper.selectJzPlanById(jzInspection.getJzPlanId());
        if(jzPlan !=null){
            jzInspection.setCreateTime(jzPlan.getCreateTime());
        }
        i = jzInspectionMapper.insertJzInspection(jzInspection);
    //  添加巡检项日志
        i= addInspectionLog(jzInspection);
        return i;
    }
    //        添加巡检项日志
    private int addInspectionLog(JzInspection jzInspection) {
        JzInspectionLog log = new JzInspectionLog();
        log.setId(jzInspection.getId());
        log.setJzPlanId(jzInspection.getJzPlanId());
        log.setContent(jzInspection.getContent());
        log.setCreateId(jzInspection.getCreateId());
        log.setEquipmentId(jzInspection.getEquipmentId());
        log.setEquipmentState(jzInspection.getEquipmentState());
        log.setInspectionAddr(jzInspection.getInspectionAddr());
        log.setInspectionProject(jzInspection.getInspectionProject());
        log.setJcDate(jzInspection.getJcDate());
        log.setJcPeople(jzInspection.getJcPeople());
        log.setState(jzInspection.getState());
        log.setSystemId(jzInspection.getSystemId());
        log.setUpdateId(jzInspection.getUpdateId());
        log.setCreateTime(jzInspection.getCreateTime());
        log.setUpdateTime(jzInspection.getUpdateTime());
        log.setRemark(jzInspection.getRemark());
      return   jzInspectionLogMapper.insertJzInspectionLog(log);
    }

    /**
     * 修改巡检
     * 
     * @param jzInspection 巡检
     * @return 结果
     */
    @Override
    public int updateJzInspection(JzInspection jzInspection)
    {
        int i=0;
        JzPlan jzPlan = jzPlanMapper.selectJzPlanById(jzInspection.getJzPlanId());
        if(jzPlan !=null){
            jzInspection.setUpdateTime(jzPlan.getUpdateTime());
        }
     //        删除log
        jzInspectionLogMapper.deleteJzInspectionLogById(jzInspection.getId());
    //  添加巡检项日志
        i= addInspectionLog(jzInspection);
        return jzInspectionMapper.updateJzInspection(jzInspection);
    }

    /**
     * 删除巡检对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transient
    public int deleteJzInspectionByIds(String ids)
    {
        jzInspectionLogMapper.deleteJzInspectionLogByIds(Convert.toStrArray(ids));
        return jzInspectionMapper.deleteJzInspectionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除巡检信息
     * 
     * @param id 巡检ID
     * @return 结果
     */
    @Override
    public int deleteJzInspectionById(Long id)
    {
        return jzInspectionMapper.deleteJzInspectionById(id);
    }

    /**
     * 获取当前系统名称
     */
    @Override
    public String selectSystemName(Long systemId) {
        return jzInspectionMapper.selectSystemName();
    }

    /**
     * 大班长查询巡检
     * @param id 系统id
     * @param equipmentState 设备状态
     * @param state 状态
     * @param jcStartDate 开始检查时间
     * @param jcEndDate 结束检查时间
     * @param jcPeople 检查人
     * @param inspectionProject 巡检项目
     * @param content 计划
     * @return
     */
    @Override
    public List<JzInspection> selectDbInspectionList(String id, String equipmentState, String state, Date jcStartDate, Date jcEndDate, String jcPeople, String inspectionProject, String content) {
        return jzInspectionMapper.selectDbInspectionList(Convert.toStrArray(id),equipmentState,state,jcStartDate,jcEndDate,jcPeople,inspectionProject,content);
    }

}
