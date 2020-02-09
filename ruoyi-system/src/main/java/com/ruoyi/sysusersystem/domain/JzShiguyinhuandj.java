package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 事故隐患排查整改记录对象 jz_shiguyinhuandj
 * 
 * @author sunli
 * @date 2020-01-19
 */
public class JzShiguyinhuandj extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事故隐患排查id */
    private Long id;

    /** 部门id */
    @Excel(name = "部门id")
    private Long bumenId;

    /** 填表人id */
    @Excel(name = "填表人id")
    private Long sgyhName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 填表时间 */
    @Excel(name = "填表时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date formTime;

    /** 存在隐患 */
    @Excel(name = "存在隐患")
    private String czYinhuan;

    /** 整改措施 */
    @Excel(name = "整改措施")
    private String zgCuoshi;

    /** 整改完成情况 0. 未整改 1.已整改 2.整改延期 */
    @Excel(name = "整改完成情况 0. 未整改 1.已整改 2.整改延期")
    private String zgWancheng;

    /** 隐患id */
    @Excel(name = "隐患id")
    private Long hiddenTroubleId;

    /** 隐患创建时间 */
    @Excel(name = "隐患创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date yhCreateTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBumenId(Long bumenId) 
    {
        this.bumenId = bumenId;
    }

    public Long getBumenId() 
    {
        return bumenId;
    }
    public void setSgyhName(Long sgyhName) 
    {
        this.sgyhName = sgyhName;
    }

    public Long getSgyhName() 
    {
        return sgyhName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setFormTime(Date formTime) 
    {
        this.formTime = formTime;
    }

    public Date getFormTime() 
    {
        return formTime;
    }
    public void setCzYinhuan(String czYinhuan) 
    {
        this.czYinhuan = czYinhuan;
    }

    public String getCzYinhuan() 
    {
        return czYinhuan;
    }
    public void setZgCuoshi(String zgCuoshi) 
    {
        this.zgCuoshi = zgCuoshi;
    }

    public String getZgCuoshi() 
    {
        return zgCuoshi;
    }
    public void setZgWancheng(String zgWancheng) 
    {
        this.zgWancheng = zgWancheng;
    }

    public String getZgWancheng() 
    {
        return zgWancheng;
    }
    public void setHiddenTroubleId(Long hiddenTroubleId) 
    {
        this.hiddenTroubleId = hiddenTroubleId;
    }

    public Long getHiddenTroubleId() 
    {
        return hiddenTroubleId;
    }
    public void setYhCreateTime(Date yhCreateTime) 
    {
        this.yhCreateTime = yhCreateTime;
    }

    public Date getYhCreateTime() 
    {
        return yhCreateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bumenId", getBumenId())
            .append("sgyhName", getSgyhName())
            .append("phone", getPhone())
            .append("formTime", getFormTime())
            .append("czYinhuan", getCzYinhuan())
            .append("zgCuoshi", getZgCuoshi())
            .append("zgWancheng", getZgWancheng())
            .append("hiddenTroubleId", getHiddenTroubleId())
            .append("yhCreateTime", getYhCreateTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
