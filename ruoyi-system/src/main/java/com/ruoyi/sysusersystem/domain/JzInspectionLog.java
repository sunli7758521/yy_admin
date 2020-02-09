package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 巡检日志对象 jz_inspection_log
 * 
 * @author sunli
 * @date 2020-01-09
 */
public class JzInspectionLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 设备id */
    @Excel(name = "设备id")
    private Long equipmentId;

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

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;

    /** 修改人id */
    @Excel(name = "修改人id")
    private Long updateId;

    /** 0 使用中  1.维修中 2.报废 */
    @Excel(name = "0 使用中  1.维修中 2.报废")
    private String equipmentState;

    /** 状态（0 未完成 1.已完成） */
    @Excel(name = "状态", readConverterExp = "0=,未=完成,1=.已完成")
    private String state;

    /** 巡检计划id */
    @Excel(name = "巡检计划id")
    private Long jzPlanId;
    /** 用户名称 */
    private String userName;

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
    public void setEquipmentState(String equipmentState) 
    {
        this.equipmentState = equipmentState;
    }

    public String getEquipmentState() 
    {
        return equipmentState;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setJzPlanId(Long jzPlanId) 
    {
        this.jzPlanId = jzPlanId;
    }

    public Long getJzPlanId() 
    {
        return jzPlanId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("equipmentId", getEquipmentId())
            .append("systemId", getSystemId())
            .append("content", getContent())
            .append("inspectionProject", getInspectionProject())
            .append("inspectionAddr", getInspectionAddr())
            .append("jcPeople", getJcPeople())
            .append("jcDate", getJcDate())
            .append("createId", getCreateId())
            .append("createTime", getCreateTime())
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .append("equipmentState", getEquipmentState())
            .append("state", getState())
            .append("jzPlanId", getJzPlanId())
            .append("remark", getRemark())
            .toString();
    }
}
