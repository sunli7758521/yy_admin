package com.ruoyi.suppliercontract.domain;

import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商对象 jz_supplier
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
public class JzSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long supplierId;

    /** 系统id */
    //@Excel(name = "系统id")
    private Long systemId;

    /** 所属系统 */
    @Excel(name = "所属系统")
    private String systemName;

    /** 供应商电话 */
    @Excel(name = "供应商电话")
    private String phone;

    /** 供应商邮箱 */
    @Excel(name = "供应商邮箱")
    private String supplierEmail;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String supplierAddr;

    /** 供应商传真 */
    @Excel(name = "供应商传真")
    private String supplierCz;

    /** 创建人姓名 */
    @Excel(name = "创建人姓名")
    private String userName;

    /** 最后修改人姓名 */
    @Excel(name = "最后修改人姓名")
    private String updateName;

    /** 创建人id */
   // @Excel(name = "创建人id")
    private Long createId;

    /** 最后修改人id */
   // @Excel(name = "最后修改人id")
    private Long updateId;

    /** 状态(0.正常 1.异常） */
    @Excel(name = "状态")
    private String state;

    //辅助页面显示
    private SysDept dept;
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setSystemId(Long systemId) 
    {
        this.systemId = systemId;
    }

    public Long getSystemId() 
    {
        return systemId;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setSupplierEmail(String supplierEmail) 
    {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierEmail() 
    {
        return supplierEmail;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setSupplierAddr(String supplierAddr) 
    {
        this.supplierAddr = supplierAddr;
    }

    public String getSupplierAddr() 
    {
        return supplierAddr;
    }
    public void setSupplierCz(String supplierCz) 
    {
        this.supplierCz = supplierCz;
    }

    public String getSupplierCz() 
    {
        return supplierCz;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }
    public void setUpdateId(Long updateId) 
    {
        this.updateId = updateId;
    }

    public Long getUpdateId() 
    {
        return updateId;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setUpdateName(String updateName)
    {
        this.updateName = updateName;
    }

    public String getUpdateName()
    {
        return updateName;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplierId", getSupplierId())
            .append("systemId", getSystemId())
            .append("phone", getPhone())
            .append("supplierEmail", getSupplierEmail())
            .append("supplierName", getSupplierName())
            .append("supplierAddr", getSupplierAddr())
            .append("supplierCz", getSupplierCz())
            .append("createId", getCreateId())
            .append("createTime", getCreateTime())
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("state", getState())
            .toString();
    }
}
