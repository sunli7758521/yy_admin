package com.ruoyi.sysusersystem.domain;

import java.util.Map;

/**
 * @Author sunli
 * @Date 2020/2/20
 */
public class YHTZVo {
//    计划主键
    private String planId;
//    隐患名称
    private String title;

    private String time;
//    系统名称
    private String deptName;
//    排查班组
    private String teamId;
//    任务内容
    private String content;
//隐患类型
    private String typeName;
//    检查人
    private String rectificationPeople;
//    检查时间
    private String rectificationTime;
//    隐患内容
    private String hiddenContent;
//    隐患位置
    private String hiddenWz;
//    隐患状态
    private String state;
// 隐患级别
    private String hiddenJb;
//   检查部门
    private String jcDept;
//    检查级别
    private String jcJb;
//    备注
    private String remark;
//    巡查周期
    private String longTime;
    //    隐患排查时间
    private String createTime;
    //    隐患主键id
    private String hiddenTroubleId;

    /** 请求参数 */
    private Map<String, Object> params;

    public String getHiddenTroubleId() {
        return hiddenTroubleId;
    }

    public void setHiddenTroubleId(String hiddenTroubleId) {
        this.hiddenTroubleId = hiddenTroubleId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getLongTime() {
        return longTime;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRectificationPeople() {
        return rectificationPeople;
    }

    public void setRectificationPeople(String rectificationPeople) {
        this.rectificationPeople = rectificationPeople;
    }

    public String getRectificationTime() {
        return rectificationTime;
    }

    public void setRectificationTime(String rectificationTime) {
        this.rectificationTime = rectificationTime;
    }

    public String getHiddenContent() {
        return hiddenContent;
    }

    public void setHiddenContent(String hiddenContent) {
        this.hiddenContent = hiddenContent;
    }

    public String getHiddenWz() {
        return hiddenWz;
    }

    public void setHiddenWz(String hiddenWz) {
        this.hiddenWz = hiddenWz;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHiddenJb() {
        return hiddenJb;
    }

    public void setHiddenJb(String hiddenJb) {
        this.hiddenJb = hiddenJb;
    }

    public String getJcDept() {
        return jcDept;
    }

    public void setJcDept(String jcDept) {
        this.jcDept = jcDept;
    }

    public String getJcJb() {
        return jcJb;
    }

    public void setJcJb(String jcJb) {
        this.jcJb = jcJb;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
