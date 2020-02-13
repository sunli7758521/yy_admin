package com.ruoyi.sysusersystem.service.impl;

import java.beans.Transient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.sysusersystem.domain.JzPlanLog;
import com.ruoyi.sysusersystem.mapper.*;
import com.ruoyi.sysusersystem.service.IJzPlanLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.service.IJzPlanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 制定计划Service业务层处理
 * 
 * @author sunli
 * @date 2019-12-31
 */
@Service
public class JzPlanServiceImpl implements IJzPlanService 
{
    @Autowired
    private JzPlanMapper jzPlanMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private JzPlanLogMapper jzPlanLogMapper;

    @Autowired
    private JzHiddenTroubleMapper jzHiddenTroubleMapper;
    @Autowired
    private JzHiddenTroubleLogMapper jzHiddenTroubleLogMapper;

    @Autowired
    private IJzPlanLogService jzPlanLogService;

//    @Autowired
//    private JzPlanLogMapper jzPlanLogMapper;

    @Autowired
    private JzInspectionLogMapper jzInspectionLogMapper;

    @Autowired
    private JzInspectionMapper jzInspectionMapper;

    /**
     * 查询制定计划
     * 
     * @param planId 制定计划ID
     * @return 制定计划
     */
    @Override
    public JzPlan selectJzPlanById(Long planId)
    {
        return jzPlanMapper.selectJzPlanById(planId);
    }

    /**
     * 查询制定计划列表
     * 
     * @param jzPlan 制定计划
     * @return 制定计划
     */
    @Override
    public List<JzPlan> selectJzPlanList(JzPlan jzPlan)
    {
        List<JzPlan> list= jzPlanMapper.selectJzPlanList(jzPlan);
        if(list !=null){
            for (JzPlan plan : list) {
                SysDept dept = sysDeptMapper.selectById(plan.getSystemId());
                if(dept !=null){
                    plan.setSystemName(dept.getDeptName());
                }
            }
        }
        return list;
    }

    /**
     * 新增制定计划
     * 
     * @param jzPlan 制定计划
     * @return 结果
     */
    @Override
    @Transient
    public int insertJzPlan(JzPlan jzPlan)
    {
        int i =0;
        jzPlan.setCreateTime(DateUtils.getNowDate());
        i=jzPlanMapper.insertJzPlan(jzPlan);
        if(jzPlan.getPlanType()=="0"){

        }else if(jzPlan.getPlanType()=="1"){
//            添加巡检任务
            addJzPlanLog(jzPlan);
        }else{
            insertJzPlanLog(jzPlan);
        }
        return i;
    }



    // 添加任务模板
    private int addJzPlanLog(JzPlan plan) {

        JzPlanLog planLog = new JzPlanLog();
            planLog.setPlanId(plan.getPlanId());
            planLog.setCreateTime(plan.getCreateTime());
            planLog.setContent(plan.getContent());
            planLog.setCreateId(plan.getCreateId());
            planLog.setSystemId(plan.getSystemId());
            planLog.setState(plan.getState());
            planLog.setTeamId(plan.getTeamId());
            planLog.setTitle(plan.getTitle());
            planLog.setPlanType(plan.getPlanType());
            planLog.setZbType(plan.getZbType());
            planLog.setTime(plan.getTime());
            planLog.setLongTime(plan.getLongTime());
            planLog.setUpdateId(plan.getUpdateId());
            planLog.setUpdateTime(plan.getUpdateTime());
            planLog.setRemark(plan.getRemark());
            planLog.setSuccessTime(plan.getSuccessTime());
        return  jzPlanLogService.insertJzPlanLogList(planLog);
    }

    /**
     * 修改制定计划
     * 
     * @param jzPlan 制定计划
     * @return 结果
     */
    @Override
    @Transient
    public int updateJzPlan(JzPlan jzPlan)
    {
        int i =0;
        JzPlan jz = jzPlanMapper.selectJzPlanById(jzPlan.getPlanId());
        jzPlan.setUpdateTime(DateUtils.getNowDate());
        jzPlan.setCreateTime(jz.getCreateTime());
        if(jzPlan.getPlanType()=="0"){

        }else if(jzPlan.getPlanType()=="1"){
            //  通过id删除计划任务表数据
            i =  jzPlanLogService.deleteJzPlanLogById(jzPlan.getPlanId());
            // 添加
            addJzPlanLog(jzPlan);
        }else{
            i = jzPlanMapper.updateJzPlan(jzPlan);
//            todo
//            updateJzPlanLog(jzPlan);

            i =  jzPlanLogService.deleteJzPlanLogById(jzPlan.getPlanId());
            // 添加
            addJzPlanLog(jzPlan);
        }
        return i;




    }

    /**
     * 删除制定计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transient
    public int deleteJzPlanByIds(String ids)
    {


//        if(jzPlan.getPlanType()=="0"){

//        }else if(jzPlan.getPlanType()=="1"){

            jzInspectionMapper.deleteJzInspectionByPlanIds(Convert.toStrArray(ids));
            jzInspectionLogMapper.deleteJzInspectionLogByPlanIds(Convert.toStrArray(ids));

//        }else{

//        }


        jzPlanLogMapper.deleteJzPlanLogByIds(Convert.toStrArray(ids));
        return jzPlanMapper.deleteJzPlanByIds(Convert.toStrArray(ids));

    }

    /**
     * 删除制定计划信息
     * 
     * @param planId 制定计划ID
     * @param planType
     * @return 结果
     */
    @Override
    @Transient
    public int deleteJzPlanById(Long planId, String planType)
    {

       if(planType.equals("0")){

      }else if(planType.equals("1")){
           jzPlanLogMapper.deleteJzPlanLogById(planId);
           System.out.println(111);
      }else{

       }

        return jzPlanMapper.deleteJzPlanById(planId);
    }

    /**
     * 获取巡查列表名称
     *
     * @return
     */
    @Override
    public List<JzPlan> selectTitle() {
        return jzPlanMapper.selectTitle();
    }
    /**
     * 新增隐患
     *
     * @param jzPlan 模板
     */
    public void insertJzPlanLog(JzPlan jzPlan)
    {
        JzPlanLog pl = new  JzPlanLog();
        pl.setPlanId(jzPlan.getPlanId());
        pl.setTitle(jzPlan.getTitle());
        pl.setLongTime(jzPlan.getLongTime());
        pl.setSystemId(jzPlan.getSystemId());
        pl.setTeamId(jzPlan.getTeamId());
        pl.setState(jzPlan.getState());
        pl.setZbType(jzPlan.getZbType());
        pl.setPlanType(jzPlan.getPlanType());
        pl.setCreateId(jzPlan.getCreateId());
        pl.setCreateTime(jzPlan.getCreateTime());
        pl.setUpdateId(jzPlan.getUpdateId());
        pl.setUpdateTime(jzPlan.getUpdateTime());
        pl.setRemark(jzPlan.getRemark());
        pl.setContent(jzPlan.getContent());
        jzPlanLogMapper.insertJzPlanLog(pl);


    }
    /**
     * 修改隐患
     *
     * @param jzPlan 模板
     */
    public void updateJzPlanLog(JzPlan jzPlan)
    {
        JzPlanLog pl = new  JzPlanLog();
        pl.setPlanId(jzPlan.getPlanId());
        pl.setTitle(jzPlan.getTitle());
        pl.setLongTime(jzPlan.getLongTime());
        pl.setSystemId(jzPlan.getSystemId());
        pl.setTeamId(jzPlan.getTeamId());
        pl.setState(jzPlan.getState());
        pl.setZbType(jzPlan.getZbType());
        pl.setPlanType(jzPlan.getPlanType());
        pl.setCreateId(jzPlan.getCreateId());
        pl.setCreateTime(jzPlan.getCreateTime());
        pl.setUpdateId(jzPlan.getUpdateId());
        pl.setUpdateTime(jzPlan.getUpdateTime());
        pl.setRemark(jzPlan.getRemark());
        pl.setContent(jzPlan.getContent());
        pl.setSuccessTime(jzPlan.getSuccessTime());
        jzPlanLogMapper.updateJzPlanLog(pl);


    }

    /**
     * 启用禁用
     */
    @Override
    public int qijin(JzPlan jzPlan) {
        String state = jzPlan.getState();
        if(state.equalsIgnoreCase("0")){
            jzPlan.setState("1");
        }else{
            jzPlan.setState("0");
        }

        return jzPlanMapper.updateJzPlan(jzPlan);
    }
    // 定时器 添加日值班
    @Override
    public List<JzPlan> riZhiBanList(){
        return jzPlanMapper.riZhiBanList();
    }

    // 定时器 添加日巡检
    @Override
    public List<JzPlan> riXunJianList() {
        return jzPlanMapper.riXunJianList();
    }

    // 定时器 添加日隐患
    @Override
    public List<JzPlan> riYinHuanList() {
        return jzPlanMapper.riYinHuanList();
    }

    // 定时器 添加周值班
    @Override
    public List<JzPlan> zhouZhiBanList(){
        return jzPlanMapper.zhouZhiBanList();
    }
    // 定时器 添加周巡检
    @Override
    public List<JzPlan> zhouXunJianList(){
        return jzPlanMapper.zhouXunJianList();
    }
    // 定时器 添加周隐患
    @Override
    public List<JzPlan> zhouYinHuanList(){
        return jzPlanMapper.zhouYinHuanList();
    }
    // 定时器 添加月值班
    @Override
    public List<JzPlan> yueZhiBanList(){
        return jzPlanMapper.yueZhiBanList();
    }
    // 定时器 添加月巡检
    @Override
    public List<JzPlan> yueXunJianList(){
        return jzPlanMapper.yueXunJianList();
    }
    // 定时器 添加月隐患
    @Override
    public List<JzPlan> yueYinHuanList(){
        return jzPlanMapper.yueYinHuanList();
    }
}
