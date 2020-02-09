package com.ruoyi.emergency.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应急方案关联人员对象 jz_emergency_user
 * 
 * @author sunli
 * @date 2020-01-04
 */
public class JzEmergencyUser extends BaseEntity
{

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long userId;

    /** 关联应急预案 */
    @Excel(name = "关联应急预案")
    private Long emergencyPlanId;
    /**
     * 应急预案名称
     */
    private String emergencyPlanName;

    /** 组长 */
    @Excel(name = "组长")
    private String groupLeaderId;
    /**
     * 组长名称
     */
    private String groupLeaderName;

    /** 副组长 */
    @Excel(name = "副组长")
    private String viceGroupLeaderId;

    /** 副组长名称 */
    private String viceGroupLeaderName;

    /** 组员 */
    @Excel(name = "组员")
    private String groupUserId;

    /** 组员名称 */
    private String groupUserName;

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setEmergencyPlanId(Long emergencyPlanId) 
    {
        this.emergencyPlanId = emergencyPlanId;
    }

    public Long getEmergencyPlanId() 
    {
        return emergencyPlanId;
    }
    public void setGroupLeaderId(String groupLeaderId) 
    {
        this.groupLeaderId = groupLeaderId;
    }

    public String getGroupLeaderId() 
    {
        return groupLeaderId;
    }
    public void setViceGroupLeaderId(String viceGroupLeaderId) 
    {
        this.viceGroupLeaderId = viceGroupLeaderId;
    }

    public String getViceGroupLeaderId() 
    {
        return viceGroupLeaderId;
    }
    public void setGroupUserId(String groupUserId) 
    {
        this.groupUserId = groupUserId;
    }

    public String getGroupUserId() 
    {
        return groupUserId;
    }
    public String getGroupUserName() {
        return groupUserName;
    }

    public void setGroupUserName(String groupUserName) {
        this.groupUserName = groupUserName;
    }

    public String getViceGroupLeaderName() {
        return viceGroupLeaderName;
    }

    public void setViceGroupLeaderName(String viceGroupLeaderName) {
        this.viceGroupLeaderName = viceGroupLeaderName;
    }

    public String getEmergencyPlanName() {
        return emergencyPlanName;
    }

    public void setEmergencyPlanName(String emergencyPlanName) {
        this.emergencyPlanName = emergencyPlanName;
    }

    public String getGroupLeaderName() {
        return groupLeaderName;
    }

    public void setGroupLeaderName(String groupLeaderName) {
        this.groupLeaderName = groupLeaderName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("emergencyPlanId", getEmergencyPlanId())
            .append("emergencyPlanName", getEmergencyPlanName())
            .append("groupLeaderId", getGroupLeaderId())
            .append("groupLeaderName", getGroupLeaderName())
            .append("viceGroupLeaderId", getViceGroupLeaderId())
            .append("groupUserId", getGroupUserId())
            .toString();
    }
}
