package com.ruoyi.emergency.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 应急方案关联物资对象 jz_emergency_supplies
 *
 * @author sunli
 * @date 2020-01-04
 */
public class JzEmergencySupplies extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 应急物资计划ID
     */
    private String planId;
    /** 主键 */
    private Long suppliseId;

    /** 应急物资大类型 */
    @Excel(name = "应急物资大类型")
    private Long suppliseBigTypeId;

    /** 应急物资大类型 */
    private String suppliseBigTypeName;


    /** 应急物资小类型 */
    @Excel(name = "应急物资小类型")
    private Long suppliseSmTypeId;

    /** 应急物资小类型 */
    private String suppliseSmTypeName;

    /** 应急物资类型 */
    @Excel(name = "应急物资类型")
    private Long typeId;

    /** 应急物资名称 */
    @Excel(name = "应急物资名称")
    private String suppliseName;

    /** 总数量 */
    @Excel(name = "总数量")
    private Long countNum;

    /** 状态（0.库存正常 1.应急物资不足） */
    @Excel(name = "状态", readConverterExp = "0=.库存正常,1=.应急物资不足")
    private String state;

    /** 物资剩余提醒数量 */
    @Excel(name = "物资剩余提醒数量")
    private Long remindNum;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;

    /** 创建人id */
    private String createName;


    /** 生产日期 */
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scDate;

    /** 保质期 */
    @Excel(name = "保质期")
    private String bzDate;

    /** 批次 */
    @Excel(name = "批次")
    private String piCi;

    public void setSuppliseId(Long suppliseId)
    {
        this.suppliseId = suppliseId;
    }

    public Long getSuppliseId()
    {
        return suppliseId;
    }
    public void setSuppliseBigTypeId(Long suppliseBigTypeId)
    {
        this.suppliseBigTypeId = suppliseBigTypeId;
    }

    public Long getSuppliseBigTypeId()
    {
        return suppliseBigTypeId;
    }
    public void setSuppliseSmTypeId(Long suppliseSmTypeId)
    {
        this.suppliseSmTypeId = suppliseSmTypeId;
    }

    public Long getSuppliseSmTypeId()
    {
        return suppliseSmTypeId;
    }
    public void setTypeId(Long typeId)
    {
        this.typeId = typeId;
    }

    public Long getTypeId()
    {
        return typeId;
    }
    public void setSuppliseName(String suppliseName)
    {
        this.suppliseName = suppliseName;
    }

    public String getSuppliseName()
    {
        return suppliseName;
    }
    public void setCountNum(Long countNum)
    {
        this.countNum = countNum;
    }

    public Long getCountNum()
    {
        return countNum;
    }
    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }
    public void setRemindNum(Long remindNum)
    {
        this.remindNum = remindNum;
    }

    public Long getRemindNum()
    {
        return remindNum;
    }
    public void setCreateId(Long createId)
    {
        this.createId = createId;
    }

    public Long getCreateId()
    {
        return createId;
    }
    public void setScDate(Date scDate)
    {
        this.scDate = scDate;
    }

    public Date getScDate()
    {
        return scDate;
    }
    public void setBzDate(String bzDate)
    {
        this.bzDate = bzDate;
    }

    public String getBzDate()
    {
        return bzDate;
    }
    public void setPiCi(String piCi)
    {
        this.piCi = piCi;
    }

    public String getPiCi()
    {
        return piCi;
    }

    public String getSuppliseBigTypeName() {
        return suppliseBigTypeName;
    }

    public void setSuppliseBigTypeName(String suppliseBigTypeName) {
        this.suppliseBigTypeName = suppliseBigTypeName;
    }

    public String getSuppliseSmTypeName() {
        return suppliseSmTypeName;
    }

    public void setSuppliseSmTypeName(String suppliseSmTypeName) {
        this.suppliseSmTypeName = suppliseSmTypeName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("suppliseId", getSuppliseId())
                .append("suppliseBigTypeId", getSuppliseBigTypeId())
                .append("suppliseSmTypeId", getSuppliseSmTypeId())
                .append("typeId", getTypeId())
                .append("suppliseName", getSuppliseName())
                .append("countNum", getCountNum())
                .append("state", getState())
                .append("remindNum", getRemindNum())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("createId", getCreateId())
                .append("remark", getRemark())
                .append("scDate", getScDate())
                .append("bzDate", getBzDate())
                .append("piCi", getPiCi())
                .append("planId", getPlanId())
                .toString();
    }
}
