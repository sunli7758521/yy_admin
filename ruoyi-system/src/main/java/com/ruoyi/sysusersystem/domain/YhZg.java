package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 隐患整改对象 yh_zg
 * 
 * @author sunli
 * @date 2020-02-22
 */
public class YhZg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 隐患整改主键 */
    private Long id;

    /** 隐患id */
    @Excel(name = "隐患id")
    private Long yhId;

    /** 隐患整改时间 */
    @Excel(name = "隐患整改时间")
    private String zgTime;

    /** 隐患整改人 */
    @Excel(name = "隐患整改人")
    private String zgName;

    /** 隐患整改措施 */
    @Excel(name = "隐患整改措施")
    private String zgCs;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setYhId(Long yhId) 
    {
        this.yhId = yhId;
    }

    public Long getYhId() 
    {
        return yhId;
    }
    public void setZgTime(String zgTime) 
    {
        this.zgTime = zgTime;
    }

    public String getZgTime() 
    {
        return zgTime;
    }
    public void setZgName(String zgName) 
    {
        this.zgName = zgName;
    }

    public String getZgName() 
    {
        return zgName;
    }
    public void setZgCs(String zgCs) 
    {
        this.zgCs = zgCs;
    }

    public String getZgCs() 
    {
        return zgCs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("yhId", getYhId())
            .append("zgTime", getZgTime())
            .append("zgName", getZgName())
            .append("zgCs", getZgCs())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
