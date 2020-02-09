package com.ruoyi.emergency.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;


/**
 * 应急方案关联演练对象 jz_emergency_rehearse
 * 
 * @author sunli
 * @date 2020-01-04
 */
public class JzEmergencyRehearse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private String emergencyPlanName;
    /** 主键 */
    private Long rehearseId;

    /** 关联应急预案 */
    @Excel(name = "关联应急预案")
    private Long emergencyPlanId;

    /** 应急演练图片(一张或者多张) */
    @Excel(name = "应急演练图片(一张或者多张)")
    private String rehearsePic;

    /** 应急演练备注 */
    @Excel(name = "应急演练备注")
    private String rehearseRemark;

    /** 应急物资表id */
    @Excel(name = "应急物资表id")
    private Long suppliesId;

    /** 应急物资大类型id */
    @Excel(name = "应急物资大类型id")
    private Long suppliseBigTypeId;

    /** 应急物资大类型 */
    private String suppliseBigTypeName;


    /** 应急物资小类型id */
    @Excel(name = "应急物资小类型id")
    private Long suppliseSmTypeId;

    /** 应急物资小类型 */
    private String suppliseSmTypeName;

    /** 应急物资使用数量 */
    @Excel(name = "应急物资使用数量")
    private Long countNum;

    /** 演练时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rehearseTime;

    /** 状态(0，已修改 1.未修改) */
    @Excel(name = "状态(0，成功 1.失败)")
    private String state;

    public void setRehearseId(Long rehearseId) 
    {
        this.rehearseId = rehearseId;
    }

    public Long getRehearseId() 
    {
        return rehearseId;
    }
    public void setEmergencyPlanId(Long emergencyPlanId) 
    {
        this.emergencyPlanId = emergencyPlanId;
    }

    public Long getEmergencyPlanId() 
    {
        return emergencyPlanId;
    }
    public void setRehearsePic(String rehearsePic) 
    {
        this.rehearsePic = rehearsePic;
    }

    public String getRehearsePic() 
    {
        return rehearsePic;
    }
    public void setRehearseRemark(String rehearseRemark) 
    {
        this.rehearseRemark = rehearseRemark;
    }

    public String getRehearseRemark() 
    {
        return rehearseRemark;
    }

    public String getEmergencyPlanName() {
        return emergencyPlanName;
    }

    public void setEmergencyPlanName(String emergencyPlanName) {
        this.emergencyPlanName = emergencyPlanName;
    }

    public Long getSuppliesId() {
        return suppliesId;
    }

    public void setSuppliesId(Long suppliesId) {
        this.suppliesId = suppliesId;
    }

    public Long getSuppliseBigTypeId() {
        return suppliseBigTypeId;
    }

    public void setSuppliseBigTypeId(Long suppliseBigTypeId) {
        this.suppliseBigTypeId = suppliseBigTypeId;
    }

    public String getSuppliseBigTypeName() {
        return suppliseBigTypeName;
    }

    public void setSuppliseBigTypeName(String suppliseBigTypeName) {
        this.suppliseBigTypeName = suppliseBigTypeName;
    }

    public Long getSuppliseSmTypeId() {
        return suppliseSmTypeId;
    }

    public void setSuppliseSmTypeId(Long suppliseSmTypeId) {
        this.suppliseSmTypeId = suppliseSmTypeId;
    }

    public String getSuppliseSmTypeName() {
        return suppliseSmTypeName;
    }

    public void setSuppliseSmTypeName(String suppliseSmTypeName) {
        this.suppliseSmTypeName = suppliseSmTypeName;
    }

    public Long getCountNum() {
        return countNum;
    }

    public void setCountNum(Long countNum) {
        this.countNum = countNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getRehearseTime() {
        return rehearseTime;
    }

    public void setRehearseTime(Date rehearseTime) {
        this.rehearseTime = rehearseTime;
    }

    @Override
    public String toString() {
        return "JzEmergencyRehearse{" +
                "emergencyPlanName='" + emergencyPlanName + '\'' +
                ", rehearseId=" + rehearseId +
                ", emergencyPlanId=" + emergencyPlanId +
                ", rehearsePic='" + rehearsePic + '\'' +
                ", rehearseRemark='" + rehearseRemark + '\'' +
                ", suppliesId=" + suppliesId +
                ", suppliseBigTypeId=" + suppliseBigTypeId +
                ", suppliseBigTypeName='" + suppliseBigTypeName + '\'' +
                ", suppliseSmTypeId=" + suppliseSmTypeId +
                ", suppliseSmTypeName='" + suppliseSmTypeName + '\'' +
                ", countNum=" + countNum +
                ", rehearseTime=" + rehearseTime +
                ", state='" + state + '\'' +
                '}';
    }
}
