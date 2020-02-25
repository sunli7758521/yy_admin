package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 隐患验收记录对象 yh_ys_jl
 * 
 * @author sunli
 * @date 2020-02-24
 */
public class YhYsJl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 验收记录id */
    private Long yId;

    /** 隐患整改记录id */
    @Excel(name = "隐患整改记录id")
    private Long yhZgId;

    /** 验收人姓名 */
    @Excel(name = "验收人姓名")
    private String yName;

    /** 验收时间 */
    @Excel(name = "验收时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date yTime;

    /** 描述 */
    @Excel(name = "描述")
    private String describes;

    /** 调整时限 */
    @Excel(name = "调整时限")
    private String tzSx;

    /** 默认0 0验收通过 1.验收不通过 */
    @Excel(name = "默认0 0验收通过 1.验收不通过")
    private String state;

    public void setyId(Long yId) 
    {
        this.yId = yId;
    }

    public Long getyId() 
    {
        return yId;
    }

    public Long getYhZgId() {
        return yhZgId;
    }

    public void setYhZgId(Long yhZgId) {
        this.yhZgId = yhZgId;
    }

    public void setyName(String yName)
    {
        this.yName = yName;
    }

    public String getyName() 
    {
        return yName;
    }
    public void setyTime(Date yTime) 
    {
        this.yTime = yTime;
    }

    public Date getyTime() 
    {
        return yTime;
    }
    public void setDescribes(String describes)
    {
        this.describes = describes;
    }

    public String getDescribes()
    {
        return describes;
    }
    public void setTzSx(String tzSx) 
    {
        this.tzSx = tzSx;
    }

    public String getTzSx() 
    {
        return tzSx;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("yId", getyId())
            .append("yhZgId", getYhZgId())
            .append("yName", getyName())
            .append("yTime", getyTime())
            .append("describes", getDescribes())
            .append("tzSx", getTzSx())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
