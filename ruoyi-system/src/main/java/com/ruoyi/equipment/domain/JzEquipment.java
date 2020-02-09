package com.ruoyi.equipment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 系统设备对象 jz_equipment
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public class JzEquipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long sbId;

    /** 系统id */
    @Excel(name = "系统id")
    private Long systemId;
    /** 系统名称 */
    private String systemName;

    /** 编号 */
    @Excel(name = "编号")
    private String num;

    /** 设备规格id */
    @Excel(name = "设备规格id")
    private String spId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbName;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String sbCode;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String sbModel;

    /** 安装地点 */
    @Excel(name = "安装地点")
    private String azAddr;

    /** 经销商id */
    @Excel(name = "经销商id")
    private Long supplierId;

    /** 经销商名称 */
    private String supplierName;

    /** 设备安装时间 */
    @Excel(name = "设备安装时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date azTime;

    /** 设备安装开始时间 */
    private Date beginAzTime;

    /** 设备安装结束时间 */
    private Date endAzTime;


    /** 设备出厂日期 */
    @Excel(name = "设备出厂日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date outTime;

    /** 设备出厂开始时间 */
    private Date beginOutTime;

    /** 设备出厂结束时间 */
    private Date endOutTime;

    /** 出厂编号 */
    @Excel(name = "出厂编号")
    private String outNum;

    /** 设备进场日期 */
    @Excel(name = "设备进场日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inTime;

    /** 设备进场开始时间 */
    private Date beginInTime;

    /** 设备进场结束时间 */
    private Date endInTime;

    /** 交接验收日期 */
    @Excel(name = "交接验收日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date jjYsTime;

    /** 交接开始时间 */
    private Date beginJjYsTime;

    /** 交接结束时间 */
    private Date endJjYsTime;

    /** 使用日期 */
    @Excel(name = "使用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date syTime;

    /** 使用开始时间 */
    private Date beginSyTime;

    /** 使用结束时间 */
    private Date endSyTime;

    /** 安装人姓名 */
    @Excel(name = "安装人姓名")
    private String azName;

    /** 设备状态  0 使用中  1.维修中 2.报废  */
    @Excel(name = "设备状态  0 使用中  1.维修中 2.报废 ")
    private String state;

    /** 登记日期 */
    @Excel(name = "登记日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date djTime;

    /**  登记开始时间 */
    private Date beginDjTime;

    /**  登记结束时间 */
    private Date endDjTime;

    public void setSbId(Long sbId) 
    {
        this.sbId = sbId;
    }

    public Long getSbId() 
    {
        return sbId;
    }
    public void setSystemId(Long systemId) 
    {
        this.systemId = systemId;
    }

    public Long getSystemId() 
    {
        return systemId;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setSbName(String sbName) 
    {
        this.sbName = sbName;
    }

    public String getSbName() 
    {
        return sbName;
    }
    public void setSbCode(String sbCode) 
    {
        this.sbCode = sbCode;
    }

    public String getSbCode() 
    {
        return sbCode;
    }
    public void setSbModel(String sbModel) 
    {
        this.sbModel = sbModel;
    }

    public String getSbModel() 
    {
        return sbModel;
    }
    public void setAzAddr(String azAddr) 
    {
        this.azAddr = azAddr;
    }

    public String getAzAddr() 
    {
        return azAddr;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setAzTime(Date azTime) 
    {
        this.azTime = azTime;
    }

    public Date getAzTime() 
    {
        return azTime;
    }
    public void setOutTime(Date outTime) 
    {
        this.outTime = outTime;
    }

    public Date getOutTime() 
    {
        return outTime;
    }
    public void setOutNum(String outNum) 
    {
        this.outNum = outNum;
    }

    public String getOutNum() 
    {
        return outNum;
    }
    public void setInTime(Date inTime) 
    {
        this.inTime = inTime;
    }

    public Date getInTime() 
    {
        return inTime;
    }
    public void setJjYsTime(Date jjYsTime) 
    {
        this.jjYsTime = jjYsTime;
    }

    public Date getJjYsTime() 
    {
        return jjYsTime;
    }
    public void setSyTime(Date syTime) 
    {
        this.syTime = syTime;
    }

    public Date getSyTime() 
    {
        return syTime;
    }
    public void setAzName(String azName) 
    {
        this.azName = azName;
    }

    public String getAzName() 
    {
        return azName;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setDjTime(Date djTime) 
    {
        this.djTime = djTime;
    }

    public Date getDjTime() 
    {
        return djTime;
    }

    public Date getBeginAzTime() {
        return beginAzTime;
    }

    public void setBeginAzTime(Date beginAzTime) {
        this.beginAzTime = beginAzTime;
    }

    public Date getEndAzTime() {
        return endAzTime;
    }

    public void setEndAzTime(Date endAzTime) {
        this.endAzTime = endAzTime;
    }

    public Date getBeginOutTime() {
        return beginOutTime;
    }

    public void setBeginOutTime(Date beginOutTime) {
        this.beginOutTime = beginOutTime;
    }

    public Date getEndOutTime() {
        return endOutTime;
    }

    public void setEndOutTime(Date endOutTime) {
        this.endOutTime = endOutTime;
    }

    public Date getBeginInTime() {
        return beginInTime;
    }

    public void setBeginInTime(Date beginInTime) {
        this.beginInTime = beginInTime;
    }

    public Date getEndInTime() {
        return endInTime;
    }

    public void setEndInTime(Date endInTime) {
        this.endInTime = endInTime;
    }

    public Date getBeginJjYsTime() {
        return beginJjYsTime;
    }

    public void setBeginJjYsTime(Date beginJjYsTime) {
        this.beginJjYsTime = beginJjYsTime;
    }

    public Date getEndJjYsTime() {
        return endJjYsTime;
    }

    public void setEndJjYsTime(Date endJjYsTime) {
        this.endJjYsTime = endJjYsTime;
    }

    public Date getBeginSyTime() {
        return beginSyTime;
    }

    public void setBeginSyTime(Date beginSyTime) {
        this.beginSyTime = beginSyTime;
    }

    public Date getEndSyTime() {
        return endSyTime;
    }

    public void setEndSyTime(Date endSyTime) {
        this.endSyTime = endSyTime;
    }

    public Date getBeginDjTime() {
        return beginDjTime;
    }

    public void setBeginDjTime(Date beginDjTime) {
        this.beginDjTime = beginDjTime;
    }

    public Date getEndDjTime() {
        return endDjTime;
    }

    public void setEndDjTime(Date endDjTime) {
        this.endDjTime = endDjTime;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public void setSpId(String spId)
    {
        this.spId = spId;
    }

    public String getSpId()
    {
        return spId;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sbId", getSbId())
            .append("systemId", getSystemId())
            .append("spId", getSpId())
            .append("num", getNum())
            .append("sbName", getSbName())
            .append("sbCode", getSbCode())
            .append("sbModel", getSbModel())
            .append("azAddr", getAzAddr())
            .append("supplierId", getSupplierId())
            .append("azTime", getAzTime())
            .append("outTime", getOutTime())
            .append("outNum", getOutNum())
            .append("inTime", getInTime())
            .append("jjYsTime", getJjYsTime())
            .append("syTime", getSyTime())
            .append("azName", getAzName())
            .append("state", getState())
            .append("djTime", getDjTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
