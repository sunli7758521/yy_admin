package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;


/**
 * 风险评价对象 pingjiabiao
 *
 * @author sunli
 * @date 2020-01-18
 */
public class Pingjiabiao extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价id */
    private Long pingjiaId;

    /** 标准分 */
    @Excel(name = "标准分")
    private Long biaozhunFen;

    /** L */
    @Excel(name = "L")
    private Long lZhi;

    /** S */
    @Excel(name = "S")
    private Long sZhi;

    /** R */
    @Excel(name = "R")
    private Long rZhi;

    /** D */
    @Excel(name = "D")
    private Long dZhi;

    /** 风险级别 */
    @Excel(name = "风险级别")
    private String fengxianJibie;

    /** 风险id */
    @Excel(name = "风险id")
    private Long riskId;
    /** 评价时间 */
    private Date pjTime;
    /** 评价报告 */
    private String pgBg;
    /** 风险类型 */
    private String  typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getPjTime() {
        return pjTime;
    }

    public void setPjTime(Date pjTime) {
        this.pjTime = pjTime;
    }

    public String getPgBg() {
        return pgBg;
    }

    public void setPgBg(String pgBg) {
        this.pgBg = pgBg;
    }

    public void setPingjiaId(Long pingjiaId)
    {
        this.pingjiaId = pingjiaId;
    }

    public Long getPingjiaId()
    {
        return pingjiaId;
    }
    public void setBiaozhunFen(Long biaozhunFen)
    {
        this.biaozhunFen = biaozhunFen;
    }

    public Long getBiaozhunFen()
    {
        return biaozhunFen;
    }
    public void setlZhi(Long lZhi)
    {
        this.lZhi = lZhi;
    }

    public Long getlZhi()
    {
        return lZhi;
    }
    public void setsZhi(Long sZhi)
    {
        this.sZhi = sZhi;
    }

    public Long getsZhi()
    {
        return sZhi;
    }
    public void setrZhi(Long rZhi)
    {
        this.rZhi = rZhi;
    }

    public Long getrZhi()
    {
        return rZhi;
    }
    public void setdZhi(Long dZhi)
    {
        this.dZhi = dZhi;
    }

    public Long getdZhi()
    {
        return dZhi;
    }
    public void setFengxianJibie(String fengxianJibie)
    {
        this.fengxianJibie = fengxianJibie;
    }

    public String getFengxianJibie()
    {
        return fengxianJibie;
    }
    public void setRiskId(Long riskId)
    {
        this.riskId = riskId;
    }

    public Long getRiskId()
    {
        return riskId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("pingjiaId", getPingjiaId())
                .append("biaozhunFen", getBiaozhunFen())
                .append("lZhi", getlZhi())
                .append("sZhi", getsZhi())
                .append("rZhi", getrZhi())
                .append("dZhi", getdZhi())
                .append("fengxianJibie", getFengxianJibie())
                .append("riskId", getRiskId())
                .append("pgBg", getPgBg())
                .append("pjTime", getPjTime())
                .toString();
    }
}
