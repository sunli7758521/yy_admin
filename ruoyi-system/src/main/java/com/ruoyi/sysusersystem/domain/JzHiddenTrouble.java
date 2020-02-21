package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 隐患对象 jz_hidden_trouble
 * 
 * @author sunli
 * @date 2020-01-06
 */
public class JzHiddenTrouble extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 隐患类型名称
     */
    private String typeName;
    /** 主键 */
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
    private String successTime;

    private String jcDept;
    private String jcJb;

    public String getJcDept() {
        return jcDept;
    }

    public void setJcDept(String jcDept) {
        this.jcDept = jcDept;
    }

    public String getJcJb() {
        return jcJb;
    }

    public void setJcJb(String jcJb) {
        this.jcJb = jcJb;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
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
            .append("typeName", getTypeName())
            .append("successTime", getSuccessTime())
            .toString();
    }
}
