package com.ruoyi.quartz.task;

import com.ruoyi.sysusersystem.domain.JzPlan;
import com.ruoyi.sysusersystem.domain.JzPlanLog;
import com.ruoyi.sysusersystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

import java.util.List;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask
{
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }

    @Autowired
    private IJzPlanService jzPlanService;

    @Autowired
    private IJzPlanLogService jzPlanLogService;

    @Autowired
    private IJzDutyUserService jzDutyUserService;

    @Autowired
    private IJzDutyUserLogService jzDutyUserLogService;

    @Autowired
    private IJzHiddenTroubleService jzHiddenTroubleService;

    @Autowired
    private IJzHiddenTroubleLogService jzHiddenTroubleLogService;

    @Autowired
    private IJzInspectionService jzInspectionService;

    @Autowired
    private IJzInspectionLogService jzInspectionLogService;

    /** 巡检任务相关定时器 */
    // @Scheduled(cron = "0/10 * * * * ?")
//    一日一次 时间00:10      cron ="0 10 0 1/1 * ?"

    //@Scheduled(cron ="0 10 0 1/1 * ?")
    public void riZhiBan() {
        jzPlanLogService.riZhiBanList();
        List<JzPlan> list = jzPlanService.riZhiBanList();
        String ids = "";
        for (JzPlan id : list){
            ids+=id.getPlanId()+",";
        }
        if (ids!="" && ids!=null){
            ids= ids.substring(0, ids.length() - 1);
        }

        jzDutyUserLogService.zhiBan(ids);

    }

//    一日一次 时间00:50      cron ="0 50 0 1/1 * ?"
    //@Scheduled(cron ="0 50 0 1/1 * ?")
    public void riXunJian() {

        jzPlanLogService.riXunJianList();
        List<JzPlan> list = jzPlanService.riXunJianList();
        String ids = "";
        for (JzPlan id : list){
            ids+=id.getPlanId()+",";
        }
        if (ids!="" && ids!=null){
            ids= ids.substring(0, ids.length() - 1);
        }
        jzInspectionLogService.xunJian(ids);

    }

//    一日一次 时间01:20      cron ="0 20 1 1/1 * ? "

    //@Scheduled(cron ="0 20 1 1/1 * ?")
    public void riYinHuan() {
        jzPlanLogService.riYinHuanList();
        List<JzPlan> list = jzPlanService.riYinHuanList();
        String ids = "";
        for (JzPlan id : list){
            ids+=id.getPlanId()+",";
        }
        if (ids!="" && ids!=null){
            ids= ids.substring(0, ids.length() - 1);
        }
        jzHiddenTroubleLogService.yinHuan(ids);


    }

//    一周一次 时间  周一 00:10    cron ="0 10 0 ? * MON "

    //@Scheduled(cron ="0 10 0 ? * MON ")
    public void zhouZhiBan() {
        jzPlanLogService.zhouZhiBanList();
        List<JzPlan> list = jzPlanService.zhouZhiBanList();
        String ids = "";
        for (JzPlan id : list){
            ids+=id.getPlanId()+",";
        }
        if (ids!="" && ids!=null){
            ids= ids.substring(0, ids.length() - 1);
        }
        jzDutyUserLogService.zhiBan(ids);

    }

//    一周一次 时间  周一 00:50    cron ="0 50 0 ? * MON  "

    //@Scheduled(cron ="0 50 0 ? * MON ")
    public void zhouXunJian() {
        jzPlanLogService.zhouXunJianList();
        List<JzPlan> list = jzPlanService.zhouXunJianList();
        String ids = "";
        for (JzPlan id : list){
            ids+=id.getPlanId()+",";
        }
        if (ids!="" && ids!=null){
            ids= ids.substring(0, ids.length() - 1);
        }
        jzInspectionLogService.xunJian(ids);

    }

//    一周一次 时间  周一 01:20    cron ="0 20 1 ? * MON "

    //@Scheduled(cron ="0 20 1 ? * MON ")
    public void zhouYinHuan() {
        jzPlanLogService.zhouYinHuanList();
        List<JzPlan> list = jzPlanService.zhouYinHuanList();
        String ids = "";
        for (JzPlan id : list){
            ids+=id.getPlanId()+",";
        }
        if (ids!="" && ids!=null){
            ids= ids.substring(0, ids.length() - 1);
        }
        jzHiddenTroubleLogService.yinHuan(ids);

    }


//    一月一次 时间  一号 00:10    cron ="0 10 0 1 * ? "

    //@Scheduled(cron ="0 10 0 1 * ? ")
    public void yueZhiBan() {
        jzPlanLogService.yueZhiBanList();
        List<JzPlan> list = jzPlanService.yueZhiBanList();
        String ids = "";
        for (JzPlan id : list){
            ids+=id.getPlanId()+",";
        }
        if (ids!="" && ids!=null){
            ids= ids.substring(0, ids.length() - 1);
        }
        jzDutyUserLogService.zhiBan(ids);

    }

//    一月一次 时间  一号 00:50    cron ="0 50 0 1 * ? "

    //@Scheduled(cron ="0 50 0 1 * ? ")
    public void yueXunJian() {
        jzPlanLogService.yueXunJianList();
        List<JzPlan> list = jzPlanService.yueXunJianList();
        String ids = "";
        for (JzPlan id : list){
            ids+=id.getPlanId()+",";
        }
        if (ids!="" && ids!=null){
            ids= ids.substring(0, ids.length() - 1);
        }
        jzInspectionLogService.xunJian(ids);

    }

//    一月一次 时间  一号 01:20    cron ="0 20 1 1 * ? "

    //@Scheduled(cron ="0 20 1 1 * ? ")
    public void yueYinHuan() {
        jzPlanLogService.yueYinHuanList();
        List<JzPlan> list = jzPlanService.yueYinHuanList();
        String ids = "";
        for (JzPlan id : list){
            ids+=id.getPlanId()+",";
        }
        if (ids!="" && ids!=null){
            ids= ids.substring(0, ids.length() - 1);
        }
        jzHiddenTroubleLogService.yinHuan(ids);

    }



}
