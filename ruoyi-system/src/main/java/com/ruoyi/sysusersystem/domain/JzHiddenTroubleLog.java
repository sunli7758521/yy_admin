package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 隐患日志对象 jz_hidden_trouble_log
 * 
 * @author sunli
 * @date 2020-01-11
 */
public class JzHiddenTroubleLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 隐患项主键 */
    @Excel(name = "隐患项主键")
    private Long hiddenTroubleId;

    /** 隐患类型id */
    @Excel(name = "隐患类型id")
    private Long typeId;

    /** 制定计划id */
    @Excel(name = "制定计划id")
    private Long planId;

    /** 系统id */
    @Excel(name = "系统id")
    private Long systemId;

    /** 盘查人 */
    @Excel(name = "盘查人")
    private String identifyPeople;

    /** 整改人 */
    @Excel(name = "整改人")
    private String rectificationPeople;

    /** 整改时间 */
    @Excel(name = "整改时间")
    private String rectificationTime;

    /** 状态（0.未整改常 1.已整改 2.预期未整改） */
    @Excel(name = "状态", readConverterExp = "0=.未整改常,1=.已整改,2=.预期未整改")
    private String state;

    /** 隐患内容 */
    @Excel(name = "隐患内容")
    private String hiddenContent;

    /** 隐患位置 */
    @Excel(name = "隐患位置")
    private String hiddenWz;

    /** 隐患级别 */
    @Excel(name = "隐患级别")
    private String hiddenJb;

    /** 完成时限 */
    @Excel(name = "完成时限")
    private Date successTime;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String picUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }


    public void setHiddenTroubleId(Long hiddenTroubleId) 
    {
        this.hiddenTroubleId = hiddenTroubleId;
    }

    public Long getHiddenTroubleId() 
    {
        return hiddenTroubleId;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setSystemId(Long systemId) 
    {
        this.systemId = systemId;
    }

    public Long getSystemId() 
    {
        return systemId;
    }
    public void setIdentifyPeople(String identifyPeople) 
    {
        this.identifyPeople = identifyPeople;
    }

    public String getIdentifyPeople() 
    {
        return identifyPeople;
    }
    public void setRectificationPeople(String rectificationPeople) 
    {
        this.rectificationPeople = rectificationPeople;
    }

    public String getRectificationPeople() 
    {
        return rectificationPeople;
    }
    public void setRectificationTime(String rectificationTime) 
    {
        this.rectificationTime = rectificationTime;
    }

    public String getRectificationTime() 
    {
        return rectificationTime;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setHiddenContent(String hiddenContent) 
    {
        this.hiddenContent = hiddenContent;
    }

    public String getHiddenContent() 
    {
        return hiddenContent;
    }
    public void setHiddenWz(String hiddenWz) 
    {
        this.hiddenWz = hiddenWz;
    }

    public String getHiddenWz() 
    {
        return hiddenWz;
    }
    public void setHiddenJb(String hiddenJb) 
    {
        this.hiddenJb = hiddenJb;
    }

    public String getHiddenJb() 
    {
        return hiddenJb;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("hiddenTroubleId", getHiddenTroubleId())
                .append("typeId", getTypeId())
                .append("planId", getPlanId())
                .append("systemId", getSystemId())
                .append("identifyPeople", getIdentifyPeople())
                .append("rectificationPeople", getRectificationPeople())
                .append("rectificationTime", getRectificationTime())
                .append("state", getState())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("hiddenContent", getHiddenContent())
                .append("hiddenWz", getHiddenWz())
                .append("hiddenJb", getHiddenJb())
                .append("updateTime", getUpdateTime())
                .append("successTime", getSuccessTime())
                .append("picUrl", getPicUrl())
                .toString();
    }
}
