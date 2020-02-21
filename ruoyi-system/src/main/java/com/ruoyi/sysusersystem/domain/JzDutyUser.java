package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import java.util.Date;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 值班关联用户对象 jz_duty_user
 *
 * @author sunli
 * @date 2020-01-13
 */
public class JzDutyUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 值班关联用户id */
    private Long dutyUserId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    private String userName;

    /** 计划表id */
    @Excel(name = "计划表id")
    private Long planId;

    private String planName;

    /** 状态（0 未调班 1.已调班） */
    @Excel(name = "状态", readConverterExp = "0=,未=调班,1=.已调班")
    private String state;

    /** 计划时长 */
    @Excel(name = "计划类别")

    private String type;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private String typeName;
    /** 值班开始时间 */
    @Excel(name = "值班开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginZBTime;

    /** 值班结束时间 */
    @Excel(name = "值班结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endZBTime;

    /** 值班日期 */
//    @Excel(name = "值班日期", width = 30, dateFormat = "yyyy-MM-dd")
    @Excel(name = "值班日期", readConverterExp = "值班日期")
    private String zbTime;

    private int shuLiang;

    public void setDutyUserId(Long dutyUserId)
    {
        this.dutyUserId = dutyUserId;
    }

    public Long getDutyUserId()
    {
        return dutyUserId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId()
    {
        return planId;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Date getBeginZBTime() {
        return beginZBTime;
    }

    public void setBeginZBTime(Date beginZBTime) {
        this.beginZBTime = beginZBTime;
    }

    public Date getEndZBTime() {
        return endZBTime;
    }

    public void setEndZBTime(Date endZBTime) {
        this.endZBTime = endZBTime;
    }

    public String getZbTime() {
        return zbTime;
    }

    public void setZbTime(String zbTime) {
        this.zbTime = zbTime;
    }

    public int getShuLiang() {
        return shuLiang;
    }

    public void setShuLiang(int shuLiang) {
        this.shuLiang = shuLiang;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("dutyUserId", getDutyUserId())
                .append("userId", getUserId())
                .append("beginZBTime", getBeginZBTime())
                .append("endZBTime", getEndZBTime())
                .append("zbTime", getZbTime())
                .append("type", getType())
                .append("planId", getPlanId())
                .append("state", getState())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
