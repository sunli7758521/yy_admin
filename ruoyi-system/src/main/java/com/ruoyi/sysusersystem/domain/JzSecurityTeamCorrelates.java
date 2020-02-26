package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 安全小组关联系统用户对象 jz_security_team_correlates
 * 
 * @author sunli
 * @date 2020-02-26
 */
public class JzSecurityTeamCorrelates extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 系统用户 */
    @Excel(name = "系统用户")
    private Long userId;

    /** 安全小组主键 */
    @Excel(name = "安全小组主键")
    private Long securityTeamId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setSecurityTeamId(Long securityTeamId) 
    {
        this.securityTeamId = securityTeamId;
    }

    public Long getSecurityTeamId() 
    {
        return securityTeamId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("securityTeamId", getSecurityTeamId())
            .toString();
    }
}
