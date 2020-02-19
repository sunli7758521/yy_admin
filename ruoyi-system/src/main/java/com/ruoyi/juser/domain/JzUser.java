package com.ruoyi.juser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 用户对象 jz_user
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
public class JzUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long userId;

    /** 系统id */
    @Excel(name = "系统id")
    private Long systemId;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 性别（0男1女2未知） */
    @Excel(name = "性别", readConverterExp = "0=男1女2未知")
    private String gender;

    /** 人员类型 */
    @Excel(name = "人员类型")
    private Long userType;

    /** 在职状态（0在职1离职） */
    @Excel(name = "在职状态", readConverterExp = "0=在职1离职")
    private Long state;

    /** 医院id */
    @Excel(name = "医院id")
    private Long hospitalId;

    /** 分院id */
    @Excel(name = "分院id")
    private Long ministryId;

    /** 科室id */
    @Excel(name = "科室id")
    private Long families;

    /** 组id */
    @Excel(name = "组id")
    private Long teamId;

    /** 住址 */
    @Excel(name = "住址")
    private String adrress;

    /** 紧急电话 */
    @Excel(name = "紧急电话")
    private String emergencyCall;

    /** 工号 */
    @Excel(name = "工号")
    private String userNum;

    /** 员工入职时间一 */
    private Date beginOutTime;

    /** 入职时间二 */
    private Date endOutTime;

    //  系统ids
    private String[] systemIds;
    //  部门名称
    private String deptName;

    //  用户类型
    private String userTypeName;

    public JzUser() {
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String[] getSystemIds() {
        return systemIds;
    }

    public void setSystemIds(String[] systemIds) {
        this.systemIds = systemIds;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
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
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }
    public void setUserType(Long userType)
    {
        this.userType = userType;
    }

    public Long getUserType()
    {
        return userType;
    }
    public void setState(Long state)
    {
        this.state = state;
    }

    public Long getState()
    {
        return state;
    }
    public void setHospitalId(Long hospitalId)
    {
        this.hospitalId = hospitalId;
    }

    public Long getHospitalId()
    {
        return hospitalId;
    }
    public void setMinistryId(Long ministryId)
    {
        this.ministryId = ministryId;
    }

    public Long getMinistryId()
    {
        return ministryId;
    }
    public void setFamilies(Long families)
    {
        this.families = families;
    }

    public Long getFamilies()
    {
        return families;
    }
    public void setTeamId(Long teamId)
    {
        this.teamId = teamId;
    }

    public Long getTeamId()
    {
        return teamId;
    }
    public void setAdrress(String adrress)
    {
        this.adrress = adrress;
    }

    public String getAdrress()
    {
        return adrress;
    }
    public void setEmergencyCall(String emergencyCall)
    {
        this.emergencyCall = emergencyCall;
    }

    public String getEmergencyCall()
    {
        return emergencyCall;
    }
    public void setUserNum(String userNum)
    {
        this.userNum = userNum;
    }

    public String getUserNum()
    {
        return userNum;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("systemId", getSystemId())
                .append("deptId", getDeptId())
                .append("userName", getUserName())
                .append("phone", getPhone())
                .append("gender", getGender())
                .append("userType", getUserType())
                .append("state", getState())
                .append("hospitalId", getHospitalId())
                .append("ministryId", getMinistryId())
                .append("families", getFamilies())
                .append("teamId", getTeamId())
                .append("adrress", getAdrress())
                .append("emergencyCall", getEmergencyCall())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("userNum", getUserNum())
                .append("remark", getRemark())
                .append("beginOutTime", getBeginOutTime())
                .append("endOutTime", getEndOutTime())
                .toString();
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
}
