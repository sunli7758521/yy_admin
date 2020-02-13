package com.ruoyi.warranty.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 报修对象 jz_warranty
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
public class JzWarranty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long warrantyId;

    /** 保修内容 */
    @Excel(name = "保修内容")
    private String content;

    /** 设备id */
    @Excel(name = "设备id")
    private Long equipmentId;

    /** 报修人员姓名 */
    @Excel(name = "报修人员姓名")
    private String equipmentName;

    /** 保修科室id */
    @Excel(name = "报修科室id")
    private String equipmentDepartmentId;

    /** 维修人id */
    @Excel(name = "维修人id")
    private Long maintenancePeopleId;

    /** 维修人 */
    @Excel(name = "维修人")
    private String maintenancePeopleName;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createName;
    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;
    /** 修改人id */
    @Excel(name = "修改人id")
    private Long updateId;

    /** 最后修改人 */
    @Excel(name = "最后修改人")
    private String updateName;

    /** 状态 (0维修中 1已修. 2.超期 3.巡检产生的维修) */
    @Excel(name = "状态 (0维修中 1已修. 2.超期 3.巡检产生的维修)")
    private String state;

    /** 系统id */
    @Excel(name = "系统id")
    private Long systemId;

    /** 所属系统 */
    @Excel(name = "所属系统")
    private String systemName;


    /** 维修人维修完成时间 */
    @Excel(name = "维修人维修完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wxTime;

    /** 审核状态 0未审核 1.审核通过  2.审核不通过 */
    @Excel(name = "审核状态 0未审核 1.审核通过  2.审核不通过")
    private String shState;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String picUrl;

    /** 维修地址 */
    @Excel(name = "维修地址")
    private String wxAddr;

    /** 维修组 */
    @Excel(name = "维修组")
    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getWxTime() {
        return wxTime;
    }

    public void setWxTime(Date wxTime) {
        this.wxTime = wxTime;
    }

    public String getShState() {
        return shState;
    }

    public void setShState(String shState) {
        this.shState = shState;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getWxAddr() {
        return wxAddr;
    }

    public void setWxAddr(String wxAddr) {
        this.wxAddr = wxAddr;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }
    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getMaintenancePeopleName() {
        return maintenancePeopleName;
    }

    public void setMaintenancePeopleName(String maintenancePeopleName) {
        this.maintenancePeopleName = maintenancePeopleName;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }



    public void setWarrantyId(Long warrantyId)
    {
        this.warrantyId = warrantyId;
    }

    public Long getWarrantyId()
    {
        return warrantyId;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setEquipmentId(Long equipmentId)
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId()
    {
        return equipmentId;
    }
    public void setEquipmentName(String equipmentName)
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName()
    {
        return equipmentName;
    }
    public void setEquipmentDepartmentId(String equipmentDepartmentId)
    {
        this.equipmentDepartmentId = equipmentDepartmentId;
    }

    public String getEquipmentDepartmentId()
    {
        return equipmentDepartmentId;
    }
    public void setMaintenancePeopleId(Long maintenancePeopleId)
    {
        this.maintenancePeopleId = maintenancePeopleId;
    }

    public Long getMaintenancePeopleId()
    {
        return maintenancePeopleId;
    }
    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }
    public void setSystemId(Long systemId)
    {
        this.systemId = systemId;
    }

    public Long getSystemId()
    {
        return systemId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("warrantyId", getWarrantyId())
            .append("content", getContent())
            .append("equipmentId", getEquipmentId())
            .append("equipmentName", getEquipmentName())
            .append("equipmentDepartmentId", getEquipmentDepartmentId())
            .append("maintenancePeopleId", getMaintenancePeopleId())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("systemId", getSystemId())
            .append("remark", getRemark())
            .toString();
    }
}
