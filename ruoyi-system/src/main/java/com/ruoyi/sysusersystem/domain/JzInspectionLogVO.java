package com.ruoyi.sysusersystem.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 巡检日志对象 jz_inspection_log
 * 
 * @author sunli
 * @date 2020-01-09
 */
public class JzInspectionLogVO
{

    /** 巡检内容 */
    @Excel(name = "巡检内容")
    private String content;

    /** 巡检项目 */
    @Excel(name = "巡检项目")
    private String inspectionProject;

    /** 巡检地址 */
    @Excel(name = "巡检地址")
    private String inspectionAddr;

    /** 检查时间 */
    @Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date jcDate;

    /** 0 使用中  1.维修中 2.报废 */
    @Excel(name = "0 使用中  1.维修中 2.报废")
    private String equipmentState;

    /** 状态（0 未完成 1.已完成） */
    @Excel(name = "状态", readConverterExp = "0=,未=完成,1=.已完成")
    private String state;
    /** 检查人姓名 */
    private String userName;

    /** 备注 */
    private String remark;
    /** 审核状态 */
    private String shState;

    public String getShState() {
        return shState;
    }

    public void setShState(String shState) {
        this.shState = shState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInspectionProject() {
        return inspectionProject;
    }

    public void setInspectionProject(String inspectionProject) {
        this.inspectionProject = inspectionProject;
    }

    public String getInspectionAddr() {
        return inspectionAddr;
    }

    public void setInspectionAddr(String inspectionAddr) {
        this.inspectionAddr = inspectionAddr;
    }

    public Date getJcDate() {
        return jcDate;
    }

    public void setJcDate(Date jcDate) {
        this.jcDate = jcDate;
    }

    public String getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
