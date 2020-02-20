package com.ruoyi.sysusersystem.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.sql.Date;

/**
 * @Author sunli
 * @Date 2020/2/20
 */
public class JzRiskVo extends BaseEntity {

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


    /** 评价时间 */
    private Date pjTime;
    /** 评价报告 */
    private String pgBg;

    /** 风险名称 */
    private String name;
    /** 风险等级名称 */
    @Excel(name="风险等级")
    private String levelName;
    /** 系统名称 */
    @Excel(name="系统名称")
    private String systemName;
    /** 创建者名称 */
    private String createName;
    /** 更新者名称 */
    @Excel(name="修改者名称")
    private String updateName;
    /** 风险类别名称 */
    @Excel(name="类别名称")
    private String typeName;
    /** 主键 */
    private Long riskId;

    /** 风险标题 */
    @Excel(name = "风险标题")
    private String title;

    /** 系统id */
    //@Excel(name = "系统id")
    private Long systemId;

    /** 类型id */
    //@Excel(name = "类型id")
    private Long typeId;

    /** 风险等级 */
    @Excel(name = "风险等级")
    private String riskLevel;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String fileUrl;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;

    /** 风险点 */
    @Excel(name = "风险点")
    private String fengXiandian;

    /** 风险活动及内容 */
    @Excel(name = "风险活动及内容")
    private String huodongNeirong;

    /** 潜在风险及可能发生的事故 */
    @Excel(name = "潜在风险及可能发生的事故")
    private String weixianShigu;

    /** 最后修改人id */
    //@Excel(name = "最后修改人id")
    private Long updateId;
    /** 责任部门 */
    private String  zrDept;
    /** 责任人 */
    private String zrName;

    public String getZrDept() {
        return zrDept;
    }

    public void setZrDept(String zrDept) {
        this.zrDept = zrDept;
    }

    public String getZrName() {
        return zrName;
    }

    public void setZrName(String zrName) {
        this.zrName = zrName;
    }

    public Long getPingjiaId() {
        return pingjiaId;
    }

    public void setPingjiaId(Long pingjiaId) {
        this.pingjiaId = pingjiaId;
    }

    public Long getBiaozhunFen() {
        return biaozhunFen;
    }

    public void setBiaozhunFen(Long biaozhunFen) {
        this.biaozhunFen = biaozhunFen;
    }

    public Long getlZhi() {
        return lZhi;
    }

    public void setlZhi(Long lZhi) {
        this.lZhi = lZhi;
    }

    public Long getsZhi() {
        return sZhi;
    }

    public void setsZhi(Long sZhi) {
        this.sZhi = sZhi;
    }

    public Long getrZhi() {
        return rZhi;
    }

    public void setrZhi(Long rZhi) {
        this.rZhi = rZhi;
    }

    public Long getdZhi() {
        return dZhi;
    }

    public void setdZhi(Long dZhi) {
        this.dZhi = dZhi;
    }

    public String getFengxianJibie() {
        return fengxianJibie;
    }

    public void setFengxianJibie(String fengxianJibie) {
        this.fengxianJibie = fengxianJibie;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getRiskId() {
        return riskId;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getFengXiandian() {
        return fengXiandian;
    }

    public void setFengXiandian(String fengXiandian) {
        this.fengXiandian = fengXiandian;
    }

    public String getHuodongNeirong() {
        return huodongNeirong;
    }

    public void setHuodongNeirong(String huodongNeirong) {
        this.huodongNeirong = huodongNeirong;
    }

    public String getWeixianShigu() {
        return weixianShigu;
    }

    public void setWeixianShigu(String weixianShigu) {
        this.weixianShigu = weixianShigu;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }
}
