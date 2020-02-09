package com.ruoyi.emergency.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 应急方案对象 jz_emergency_plan
 *
 * @author sunli
 * @date 2020-01-04
 */
public class JzEmergencyPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public String systemName;

    public String typeName;

    public String supplierName;

    public String deptName;
    /** 主键 */
    private Long planId;

    /** 应急物资表id */
    @Excel(name = "应急物资表id")
    private Long suppliesId;

    /** 应急物资大类型id */
    @Excel(name = "应急物资大类型id")
    private Long suppliesBigTypeId;

    /** 应急物资小类型id */
    @Excel(name = "应急物资小类型id")
    private Long suppliesSmTypeId;

    /** 应急物资类型id */
    @Excel(name = "应急物资类型id")
    private Long typeId;

    /** 应急物资使用数量 */
    @Excel(name = "应急物资使用数量")
    private Long countNum;

    /** 方案上传地址 */
    @Excel(name = "方案上传地址")
    private String planUrl;

    /** 系统id */
    @Excel(name = "系统id")
    private Long systemId;

    /** 部门（科室）id */
    @Excel(name = "部门", readConverterExp = "科=室")
    private Long deptId;

    /** 状态(0，已修改 1.未修改) */
    @Excel(name = "状态(0，已修改 1.未修改)")
    private String state;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    public void setPlanId(Long planId)
    {
        this.planId = planId;
    }

    public Long getPlanId()
    {
        return planId;
    }
    public void setSuppliesId(Long suppliesId)
    {
        this.suppliesId = suppliesId;
    }

    public Long getSuppliesId()
    {
        return suppliesId;
    }
    public void setSuppliesBigTypeId(Long suppliesBigTypeId)
    {
        this.suppliesBigTypeId = suppliesBigTypeId;
    }

    public Long getSuppliesBigTypeId()
    {
        return suppliesBigTypeId;
    }
    public void setSuppliesSmTypeId(Long suppliesSmTypeId)
    {
        this.suppliesSmTypeId = suppliesSmTypeId;
    }

    public Long getSuppliesSmTypeId()
    {
        return suppliesSmTypeId;
    }
    public void setTypeId(Long typeId)
    {
        this.typeId = typeId;
    }

    public Long getTypeId()
    {
        return typeId;
    }
    public void setCountNum(Long countNum)
    {
        this.countNum = countNum;
    }

    public Long getCountNum()
    {
        return countNum;
    }
    public void setPlanUrl(String planUrl)
    {
        this.planUrl = planUrl;
    }

    public String getPlanUrl()
    {
        return planUrl;
    }
    public void setSystemId(Long systemId)
    {
        this.systemId = systemId;
    }

    public Long getSystemId()
    {
        return systemId;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planId", getPlanId())
            .append("suppliesId", getSuppliesId())
            .append("suppliesBigTypeId", getSuppliesBigTypeId())
            .append("suppliesSmTypeId", getSuppliesSmTypeId())
            .append("typeId", getTypeId())
            .append("countNum", getCountNum())
            .append("planUrl", getPlanUrl())
            .append("systemId", getSystemId())
            .append("deptId", getDeptId())
            .append("state", getState())
            .append("title", getTitle())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
