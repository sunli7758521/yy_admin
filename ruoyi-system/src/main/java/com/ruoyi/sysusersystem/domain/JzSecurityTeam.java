package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 安全小组对象 jz_security_team
 * 
 * @author sunli
 * @date 2020-02-24
 */
public class JzSecurityTeam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 小组名称 */
    @Excel(name = "小组名称")
    private String xzName;

    /** 创建人Id */
    @Excel(name = "创建人Id")
    private Long createId;

    /** 描述 */
    @Excel(name = "描述")
    private String describe;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setXzName(String xzName) 
    {
        this.xzName = xzName;
    }

    public String getXzName() 
    {
        return xzName;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }
    public void setDescribe(String describe) 
    {
        this.describe = describe;
    }

    public String getDescribe() 
    {
        return describe;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("xzName", getXzName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createId", getCreateId())
            .append("describe", getDescribe())
            .append("remark", getRemark())
            .toString();
    }
}
