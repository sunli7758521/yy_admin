package com.ruoyi.systemmanagement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 制度管理对象 jz_system_management
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
public class JzSystemManagement extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String systemName;
    /** 主键 */
    private Long managementId;

    /*** 系统id*/
    //@Excel(name = "系统id")
    private Long systemId;
    /*** 班组id*/
    private Long teamId;
    /*** 班组名称*/
    @Excel(name = "班组名称")
    private String teamName;
    /*** 修改人Id*/
    @Excel(name = "修改人")
    private Long updateId;
    /*** 修改人名字*/
    @Excel(name = "修改人")
    private String updateName;

    private String level;
    private String type;
    private String levelName;
    private String typeName;

    /**
     * 创建人id
     */
    @Excel(name = "创建人id")
    private Long createId;
    /**
     * 创建人name
     */
    @Excel(name = "创建人")
    private String createName;
    /**
     * 制度标题
     */
    @Excel(name = "制度标题")
    private String title;

    /**
     * 文件地址
     */
    @Excel(name = "文件地址")
    private String fileUrl;

    /**
     * 状态（0使用中1.停用）
     */
    @Excel(name = "状态", readConverterExp = "0=使用中1.停用")
    private String state;

    /**
     * 制度内容
     */
    @Excel(name = "制度内容")
    private String managementContent;

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setManagementId(Long managementId) {
        this.managementId = managementId;
    }

    public Long getManagementId() {
        return managementId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setManagementContent(String managementContent) {
        this.managementContent = managementContent;
    }

    public String getManagementContent() {
        return managementContent;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public String toString() {
        return "JzSystemManagement{" +
                "systemName='" + systemName + '\'' +
                ", managementId=" + managementId +
                ", systemId=" + systemId +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", updateId=" + updateId +
                ", updateName='" + updateName + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                ", levelName='" + levelName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", title='" + title + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", state='" + state + '\'' +
                ", managementContent='" + managementContent + '\'' +
                '}';
    }
}
