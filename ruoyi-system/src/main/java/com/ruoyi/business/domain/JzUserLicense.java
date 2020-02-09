package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 用户证件照对象 jz_user_license
 * 
 * @author ruoyi
 * @date 2019-12-10
 */
public class JzUserLicense extends BaseEntity
{
    JzUserLicense(){}
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;
    /**
     * 系统id
     */
    private Long systemId;
    /**
     * 系统名称
     */
    private String systemName;
    /** 用户主键 */
    @Excel(name = "用户主键")
    private Long userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 证照的初审时间
     */
    private Date firstTime;
    /** 证照类型 0.特种作业证照 1外来人员特种作业证照 */
    @Excel(name = "证照类型 0.特种作业证照 1外来人员特种作业证照")
    private String licenseType;
    /**
     * 特种作业项id
     */
    private Long homeworkTypeId;
    /**
     * 特种作业项名称
     */

    private String homeworkTypeName;
    /**
     * 特种作业证照二次复审时间
     */
    private Date twoReviewTime;
    /**
     * 特种作业证照第一次复审提醒状态
     */
    private String reviewState;
    /** 证件初领时间 */

    /** 证件的有效开始时间 */
    @Excel(name = "证件的有效开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 证件的有效时间 */
    @Excel(name = "证件的有效时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /** 作业类别 准操项目id（小类型id） */
    @Excel(name = "作业类别 准操项目id", readConverterExp = "小=类型id")
    private Long mustHoldProjectTypeId;
    /**
     * 准操项目
     */
    private String mustHoldProjectTypeName;
    /** 证照的复审时间 */
    @Excel(name = "证照的复审时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewTime;

    /** 复审的时间类型（0.3年 1.6年） */
    @Excel(name = "复审的时间类型", readConverterExp = "0=.3年,1=.6年")
    private String appType;

    /** 证件照前面照片url */
    @Excel(name = "证件照前面照片url")
    private String beforeImg;

    /** 证件照后面图片url */
    @Excel(name = "证件照后面图片url")
    private String afterImg;
    /** 证件名称 */
    @Excel(name = "证件名称")
    private String licenseName;

    /** 证件编号 */
    @Excel(name = "证件编号")
    private String licenseNum;

    /** 发证单位 */
    @Excel(name = "发证单位")
    private String unit;
    /** 创建者 */
    private String createName;
    /** 更新者 */
    private String updateName;
  //    作业类别
    private String zylbName;
//    准操项名称
    private String zcxmName;

    public String getZylbName() {
        return zylbName;
    }

    public void setZylbName(String zylbName) {
        this.zylbName = zylbName;
    }

    public String getZcxmName() {
        return zcxmName;
    }

    public void setZcxmName(String zcxmName) {
        this.zcxmName = zcxmName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseTypee(String licenseType) {
        this.licenseType = licenseType;
    }

    public Long getHomeworkTypeId() {
        return homeworkTypeId;
    }

    public void setHomeworkTypeId(Long homeworkTypeId) {
        this.homeworkTypeId = homeworkTypeId;
    }

    public Date getTwoReviewTime() {
        return twoReviewTime;
    }

    public void setTwoReviewTime(Date twoReviewTime) {
        this.twoReviewTime = twoReviewTime;
    }

    public String getReviewState() {
        return reviewState;
    }

    public void setReviewState(String reviewState) {
        this.reviewState = reviewState;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getMustHoldProjectTypeId() {
        return mustHoldProjectTypeId;
    }

    public void setMustHoldProjectTypeId(Long mustHoldProjectTypeId) {
        this.mustHoldProjectTypeId = mustHoldProjectTypeId;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getBeforeImg() {
        return beforeImg;
    }

    public void setBeforeImg(String beforeImg) {
        this.beforeImg = beforeImg;
    }

    public String getAfterImg() {
        return afterImg;
    }

    public void setAfterImg(String afterImg) {
        this.afterImg = afterImg;
    }
    public void setLicenseName(String licenseName)
    {
        this.licenseName = licenseName;
    }

    public String getLicenseName()
    {
        return licenseName;
    }
    public void setLicenseNum(String licenseNum)
    {
        this.licenseNum = licenseNum;
    }

    public String getLicenseNum()
    {
        return licenseNum;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getHomeworkTypeName() {
        return homeworkTypeName;
    }

    public void setHomeworkTypeName(String homeworkTypeName) {
        this.homeworkTypeName = homeworkTypeName;
    }

    public String getMustHoldProjectTypeName() {
        return mustHoldProjectTypeName;
    }

    public void setMustHoldProjectTypeName(String mustHoldProjectTypeName) {
        this.mustHoldProjectTypeName = mustHoldProjectTypeName;
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

    @Override
    public String toString() {
        return "JzUserLicense{" +
                "id=" + id +
                ", systemId=" + systemId +
                ", userId=" + userId +
                ", firstTime=" + firstTime +
                ", licenseType='" + licenseType + '\'' +
                ", homeworkTypeId=" + homeworkTypeId +
                ", twoReviewTime=" + twoReviewTime +
                ", reviewState='" + reviewState + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", mustHoldProjectTypeId=" + mustHoldProjectTypeId +
                ", reviewTime=" + reviewTime +
                ", appType='" + appType + '\'' +
                ", beforeImg='" + beforeImg + '\'' +
                ", afterImg='" + afterImg + '\'' +
                ", licenseName='" + licenseName + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
