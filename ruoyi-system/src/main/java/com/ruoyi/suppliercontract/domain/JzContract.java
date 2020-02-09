package com.ruoyi.suppliercontract.domain;

import com.ruoyi.system.domain.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同对象 jz_contract
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
public class JzContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 系统id */
    //@Excel(name = "系统id")
    private Long systemId;

    /** 所属系统 */
    @Excel(name = "所属系统")
    private String systemName;

    /** 合同标题 */
    @Excel(name = "合同标题")
    private String titile;

    /** 上传文件地址 */
    @Excel(name = "上传文件地址")
    private String fileUrl;

    /** 供应商id */
    @Excel(name = "供应商id")
    private Long supplierId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;

    /** 创建人姓名 */
    @Excel(name = "创建人姓名")
    private String userName;

    /** 最后修改人姓名 */
    @Excel(name = "最后修改人姓名")
    private String updateName;

    /** 修改人id */
    @Excel(name = "修改人id")
    private Long updateId;


    //辅助页面显示
    private SysDept dept;



    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSystemId(Long systemId) 
    {
        this.systemId = systemId;
    }

    public Long getSystemId() 
    {
        return systemId;
    }
    public void setTitile(String titile) 
    {
        this.titile = titile;
    }

    public String getTitile() 
    {
        return titile;
    }
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("systemId", getSystemId())
            .append("titile", getTitile())
            .append("fileUrl", getFileUrl())
            .append("supplierId", getSupplierId())
            //.append("supplierName", getSupplierName())
            .append("createId", getCreateId())
            .append("createTime", getCreateTime())
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
