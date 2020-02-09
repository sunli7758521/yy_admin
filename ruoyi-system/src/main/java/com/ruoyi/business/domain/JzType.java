package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 风险分类对象 jz_type
 * 
 * @author ruoyi
 * @date 2019-12-25
 */
public class JzType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 风险级别
     */
    public String level;
    /**
     * 风险级别名称
     */
    public String levelName;
    /** 主键 */
    private Long id;

    /** 系统id */
    //@Excel(name = "系统id")
    private Long systemId;

    /**
     * 更新者名称
     */
    private String updateName;
    /**
     * 父类名称
     */
    private String parentName;
    /**
     * 创建者名称
     */
    private String createName;
    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String name;

    /** 父id */
    @Excel(name = "父id")
    private Long parentId;

    /** 祖级列表 */
    @Excel(name = "祖级列表")
    private String ancestors;

    /** 分类状态（0 风险 1.应急物资2.隐患) */
    @Excel(name = "分类状态", readConverterExp = "分类状态（0 风险 1.应急物资2.隐患)")
    private String classificationState;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;

    /** 修改人id */
    @Excel(name = "修改人id")
    private Long updateId;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setAncestors(String ancestors) 
    {
        this.ancestors = ancestors;
    }

    public String getAncestors() 
    {
        return ancestors;
    }
    public void setClassificationState(String classificationState) 
    {
        this.classificationState = classificationState;
    }

    public String getClassificationState() 
    {
        return classificationState;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public String toString() {
        return "JzType{" +
                "level='" + level + '\'' +
                ", levelName='" + levelName + '\'' +
                ", id=" + id +
                ", systemId=" + systemId +
                ", updateName='" + updateName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", createName='" + createName + '\'' +
                ", systemName='" + systemName + '\'' +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", ancestors='" + ancestors + '\'' +
                ", classificationState='" + classificationState + '\'' +
                ", createId=" + createId +
                ", updateId=" + updateId +
                '}';
    }
}
