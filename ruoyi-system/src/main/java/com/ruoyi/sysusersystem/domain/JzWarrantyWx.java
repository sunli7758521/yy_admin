package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 维修记录对象 jz_warranty_wx
 * 
 * @author sunli
 * @date 2020-02-19
 */
public class JzWarrantyWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long wxId;

    /** 报修id */
    @Excel(name = "报修id")
    private Long warrantyId;
//    报修名称
    private String warrantyName;

    /** 维修人id */
    @Excel(name = "维修人id")
    private Long wxUserId;
//    维修人名称
    private String wxUserName;

    /** 维修时间 */
    @Excel(name = "维修时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wxTime;

    /** 状态(0,已完成;1,未完成) */
    @Excel(name = "状态")
    private String state;

    /** 未完成原因 */
    @Excel(name = "未完成原因")
    private String wWCYY;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cteateTime;

    public void setWxId(Long wxId) 
    {
        this.wxId = wxId;
    }

    public Long getWxId() 
    {
        return wxId;
    }
    public void setWarrantyId(Long warrantyId) 
    {
        this.warrantyId = warrantyId;
    }

    public Long getWarrantyId() 
    {
        return warrantyId;
    }
    public void setWxUserId(Long wxUserId) 
    {
        this.wxUserId = wxUserId;
    }

    public Long getWxUserId() 
    {
        return wxUserId;
    }
    public void setWxTime(Date wxTime) 
    {
        this.wxTime = wxTime;
    }

    public Date getWxTime() 
    {
        return wxTime;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setwWCYY(String wWCYY)
    {
        this.wWCYY = wWCYY;
    }

    public String getwWCYY() 
    {
        return wWCYY;
    }
    public void setCteateTime(Date cteateTime) 
    {
        this.cteateTime = cteateTime;
    }

    public Date getCteateTime() 
    {
        return cteateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wxId", getWxId())
            .append("warrantyId", getWarrantyId())
            .append("wxUserId", getWxUserId())
            .append("wxTime", getWxTime())
            .append("state", getState())
            .append("wWCYY", getwWCYY())
            .append("cteateTime", getCteateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("warrantyName", getWarrantyName())
            .append("wxUserName", getWxUserName())
            .toString();
    }

    public String getWarrantyName() {
        return warrantyName;
    }

    public void setWarrantyName(String warrantyName) {
        this.warrantyName = warrantyName;
    }

    public String getWxUserName() {
        return wxUserName;
    }

    public void setWxUserName(String wxUserName) {
        this.wxUserName = wxUserName;
    }
}
