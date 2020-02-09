package com.ruoyi.sysusersystem.service;

import com.ruoyi.sysusersystem.domain.JzInspection;

import java.util.Date;
import java.util.List;

/**
 * 巡检Service接口
 * 
 * @author sunli
 * @date 2019-12-30
 */
public interface IJzInspectionService 
{
    /**
     * 获取巡查计划名称
     * @return
     */
    public List<JzInspection> selectTitle();

    /**
     * 查询巡检
     * 
     * @param id 巡检ID
     * @return 巡检
     */
    public JzInspection selectJzInspectionById(Long id);

    /**
     * 查询巡检列表
     * 
     * @param jzInspection 巡检
     * @return 巡检集合
     */
    public List<JzInspection> selectJzInspectionList(JzInspection jzInspection);

    /**
     * 新增巡检
     * 
     * @param jzInspection 巡检
     * @return 结果
     */
    public int insertJzInspection(JzInspection jzInspection);

    /**
     * 修改巡检
     * 
     * @param jzInspection 巡检
     * @return 结果
     */
    public int updateJzInspection(JzInspection jzInspection);

    /**
     * 批量删除巡检
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzInspectionByIds(String ids);

    /**
     * 删除巡检信息
     * 
     * @param id 巡检ID
     * @return 结果
     */
    public int deleteJzInspectionById(Long id);

    /**
     * 获取当前系统名称
     */
    String selectSystemName(Long SystemId);

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
    public List<JzInspection> selectDbInspectionList(String id, String equipmentState, String state, Date jcStartDate, Date jcEndDate, String jcPeople, String inspectionProject, String content);
}
