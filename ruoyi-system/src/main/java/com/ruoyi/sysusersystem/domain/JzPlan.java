package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 制定计划对象 jz_plan
 * 
 * @author sunli
 * @date 2019-12-31
 */
public class JzPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 系统名称 */
    @Excel(name="系统")
    private String systemName;

    /** 班组名称 */
    @Excel(name="班组")
    private String teamName;

    /** 值班类型名称 */
    @Excel(name="值班类型")
    private String zbTypeName;

    /** 计划类型名称 */
    @Excel(name="计划")
    private String planTypeName;

    /** 创建者名称 */
    @Excel(name="创建者")
    private String createName;

    /** 更新者名称 */
    @Excel(name="更新者")
    private String updateName;

    /** 状态名称 */
    @Excel(name="状态")
    private String stateName;

    /** 主键 */
    private Long planId;

    /** 计划标题 */
    @Excel(name = "计划标题")
    private String title;

    /** 计划时间 */
    @Excel(name = "计划时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 计划时长 */
    @Excel(name = "计划时长")
    private String longTime;

    /** 系统id */
    //@Excel(name = "系统id")
    private Long systemId;

    /** 班组id */
   // @Excel(name = "班组id")
    private Long teamId;

    /** 状态（0正常 1.已过期) */
    @Excel(name = "状态", readConverterExp = "状态（0正常 1.已过期)")
    private String state;

    /** 值班类型（0.普通值班人员 1.领导值班） */
   // @Excel(name = "值班类型", readConverterExp = "0=.普通值班人员,1=.领导值班")
    private String zbType;

    /** 计划类型（0.值班计划 1.巡检计划 2.隐患排除计划 3.其他） */
    //@Excel(name = "计划类型", readConverterExp = "0=.值班计划,1=.巡检计划,2=.隐患排除计划,3=.其他")
    private String planType;

    /** 创建人 */
    //@Excel(name = "创建人")
    private Long createId;

    /** 修改人 */
    //@Excel(name = "修改人")
    private Long updateId;

    /** 计划内容 */
    @Excel(name = "计划内容")
    private String content;

    /** 限定时间 */
    @Excel(name = "限定时间")
    private String successTime;

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }


    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setLongTime(String longTime) 
    {
        this.longTime = longTime;
    }

    public String getLongTime() 
    {
        return longTime;
    }
    public void setSystemId(Long systemId) 
    {
        this.systemId = systemId;
    }

    public Long getSystemId() 
    {
        return systemId;
    }
    public void setTeamId(Long teamId) 
    {
        this.teamId = teamId;
    }

    public Long getTeamId() 
    {
        return teamId;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setZbType(String zbType) 
    {
        this.zbType = zbType;
    }

    public String getZbType() 
    {
        return zbType;
    }
    public void setPlanType(String planType) 
    {
        this.planType = planType;
    }

    public String getPlanType() 
    {
        return planType;
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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getZbTypeName() {
        return zbTypeName;
    }

    public void setZbTypeName(String zbTypeName) {
        this.zbTypeName = zbTypeName;
    }

    public String getPlanTypeName() {
        return planTypeName;
    }

    public void setPlanTypeName(String planTypeName) {
        this.planTypeName = planTypeName;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planId", getPlanId())
            .append("title", getTitle())
            .append("time", getTime())
            .append("longTime", getLongTime())
            .append("systemId", getSystemId())
            .append("teamId", getTeamId())
            .append("state", getState())
            .append("zbType", getZbType())
            .append("planType", getPlanType())
            .append("createId", getCreateId())
            .append("createTime", getCreateTime())
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("content", getContent())
            .append("successTime", getSuccessTime())
            .toString();
    }
}
