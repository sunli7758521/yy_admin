package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 巡检对象 jz_inspection
 * 
 * @author sunli
 * @date 2019-12-30
 */
public class JzInspection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 设备id */
    //@Excel(name = "设备id")
    private Long equipmentId;

    /** 设备状态 */
    private String equipmentState;
    /** 负责人名称 */
    @Excel(name="负责人")
    private String jcName;
    /** 设备名称 */
    @Excel(name="设备名称")
    private String equipmentName;
    /** 系统名称 */
    @Excel(name="系统名称")
    private String systemName;
    /** 创建者名称 */
    @Excel(name="创建者名称")
    private String createName;
    /** 更新者名称 */
    @Excel(name="更新者名称")
    private String updateName;
    /** 系统id */
    @Excel(name = "系统id")
    private Long systemId;

    /** 巡检内容 */
    @Excel(name = "巡检内容")
    private String content;

    /** 巡检项目 */
    @Excel(name = "巡检项目")
    private String inspectionProject;

    /** 巡检地址 */
    @Excel(name = "巡检地址")
    private String inspectionAddr;

    /** 检查人 */
    @Excel(name = "检查人")
    private String jcPeople;

    /** 检查时间 */
    @Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date jcDate;

    /** 开始检查时间 */

    private Date jcStartDate;

    /** 结束检查时间 */

    private Date jcEndDate;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;

    /** 修改人id */
    @Excel(name = "修改人id")
    private Long updateId;

    /** 状态（0 未完成 1.已完成） */
    @Excel(name = "状态", readConverterExp = "0=,未=完成,1=.已完成")
    private String state;
    /** 计划id */
    private Long jzPlanId;

    public Long getJzPlanId() {
        return jzPlanId;
    }

    public void setJzPlanId(Long jzPlanId) {
        this.jzPlanId = jzPlanId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }
    public void setSystemId(Long systemId) 
    {
        this.systemId = systemId;
    }

    public Long getSystemId() 
    {
        return systemId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setInspectionProject(String inspectionProject) 
    {
        this.inspectionProject = inspectionProject;
    }

    public String getInspectionProject() 
    {
        return inspectionProject;
    }
    public void setInspectionAddr(String inspectionAddr) 
    {
        this.inspectionAddr = inspectionAddr;
    }

    public String getInspectionAddr() 
    {
        return inspectionAddr;
    }
    public void setJcPeople(String jcPeople) 
    {
        this.jcPeople = jcPeople;
    }

    public String getJcPeople() 
    {
        return jcPeople;
    }
    public void setJcDate(Date jcDate) 
    {
        this.jcDate = jcDate;
    }

    public Date getJcDate() 
    {
        return jcDate;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }
    public void setUpdateId(Long updateId) 
    {
        this.updateId = updateId;
    }

    public Long getUpdateId() 
    {
        return updateId;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getJcName() {
        return jcName;
    }

    public void setJcName(String jcName) {
        this.jcName = jcName;
    }

    public String getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState;
    }

    public Date getJcStartDate() {
        return jcStartDate;
    }

    public void setJcStartDate(Date jcStartDate) {
        this.jcStartDate = jcStartDate;
    }

    public Date getJcEndDate() {
        return jcEndDate;
    }

    public void setJcEndDate(Date jcEndDate) {
        this.jcEndDate = jcEndDate;
    }

    @Override
    public String toString() {
        return "JzInspection{" +
                "id=" + id +
                ", equipmentId=" + equipmentId +
                ", equipmentState='" + equipmentState + '\'' +
                ", jcName='" + jcName + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", systemName='" + systemName + '\'' +
                ", createName='" + createName + '\'' +
                ", updateName='" + updateName + '\'' +
                ", systemId=" + systemId +
                ", content='" + content + '\'' +
                ", inspectionProject='" + inspectionProject + '\'' +
                ", inspectionAddr='" + inspectionAddr + '\'' +
                ", jcPeople='" + jcPeople + '\'' +
                ", jcDate=" + jcDate +
                ", createId=" + createId +
                ", updateId=" + updateId +
                ", state='" + state + '\'' +
                ", jzPlanId='" + jzPlanId + '\'' +
                '}';
    }
}
