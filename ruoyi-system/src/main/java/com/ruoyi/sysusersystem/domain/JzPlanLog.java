package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 制定计划日志对象 jz_plan_log
 * 
 * @author sunli
 * @date 2020-01-09
 */
public class JzPlanLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private Long id;

    /** 计划id */
    @Excel(name = "计划id")
    private Long planId;

    /** 计划标题 */
    @Excel(name = "计划标题")
    private String title;

    /** 计划时间 */
    @Excel(name = "计划时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 巡检周期 */
    @Excel(name = "巡检周期")
    private String longTime;

    /** 系统id */
    @Excel(name = "系统id")
    private Long systemId;

    /** 班组id */
    @Excel(name = "班组id")
    private Long teamId;

    /** 状态（0正常 1.已过期) */
    @Excel(name = "状态", readConverterExp = "状态（0正常 1.已过期)")
    private String state;

    /** 值班类型（0.普通值班人员 1.领导值班） */
    @Excel(name = "值班类型", readConverterExp = "0=.普通值班人员,1=.领导值班")
    private String zbType;

    /** 计划类型（0.值班计划 1.巡检计划 2.隐患排除计划 3.其他） */
    @Excel(name = "计划类型", readConverterExp = "0=.值班计划,1=.巡检计划,2=.隐患排除计划,3=.其他")
    private String planType;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createId;

    /** 修改人 */
    @Excel(name = "修改人")
    private Long updateId;

    /** 计划内容 */
    @Excel(name = "计划内容")
    private String content;

    private String systemName;

    /** 限定时间 */
    @Excel(name = "限定时间")
    private String successTime;

    /** 维修人id */
    @Excel(name = "维修人id")
    private Long wxId;

    /** 维修时间 */
    @Excel(name = "维修时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wxTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWxId() {
        return wxId;
    }

    public void setWxId(Long wxId) {
        this.wxId = wxId;
    }

    public Date getWxTime() {
        return wxTime;
    }

    public void setWxTime(Date wxTime) {
        this.wxTime = wxTime;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
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
                .append("wxId", getWxId())
                .append("wxTime", getWxTime())
                .toString();
    }
}
