package com.ruoyi.sysusersystem.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @Author sunli
 * @Date 2020/2/25
 */
public class YhZgYsVo extends BaseEntity {
    /** 隐患整改主键 */
    private Long id;

    /** 隐患id */
    private Long yhId;

    /** 隐患整改时间 */
    private String zgTime;

    /** 隐患整改人 */
    private String zgName;

    /** 隐患整改措施 */
    private String zgCs;

    /** 验收记录id */
    private Long yId;

    /** 隐患整改记录id */
    private Long yhZgId;

    /** 验收人姓名 */
    private String yName;

    /** 验收时间 */
    private String yTime;

    /** 描述 */
    private String describes;

    /** 调整时限 */
    private String tzSx;

    /** 默认0 0验收通过 1.验收不通过 */
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getYhId() {
        return yhId;
    }

    public void setYhId(Long yhId) {
        this.yhId = yhId;
    }

    public String getZgTime() {
        return zgTime;
    }

    public void setZgTime(String zgTime) {
        this.zgTime = zgTime;
    }

    public String getZgName() {
        return zgName;
    }

    public void setZgName(String zgName) {
        this.zgName = zgName;
    }

    public String getZgCs() {
        return zgCs;
    }

    public void setZgCs(String zgCs) {
        this.zgCs = zgCs;
    }

    public Long getyId() {
        return yId;
    }

    public void setyId(Long yId) {
        this.yId = yId;
    }

    public Long getYhZgId() {
        return yhZgId;
    }

    public void setYhZgId(Long yhZgId) {
        this.yhZgId = yhZgId;
    }

    public String getyName() {
        return yName;
    }

    public void setyName(String yName) {
        this.yName = yName;
    }

    public String getyTime() {
        return yTime;
    }

    public void setyTime(String yTime) {
        this.yTime = yTime;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getTzSx() {
        return tzSx;
    }

    public void setTzSx(String tzSx) {
        this.tzSx = tzSx;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
