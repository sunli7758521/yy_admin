package com.ruoyi.sysusersystem.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 值班修改用户记录对象 jz_duty_edit_user_record
 * 
 * @author sunli
 * @date 2020-01-13
 */
public class JzDutyEditUserRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long recordId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 备注 */
    @Excel(name = "备注")
    private String remark;


    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return remark;
    }

    @Override
    public String toString() {
        return "JzDutyEditUserRecord{" +
                "recordId=" + recordId +
                ", userId=" + userId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
