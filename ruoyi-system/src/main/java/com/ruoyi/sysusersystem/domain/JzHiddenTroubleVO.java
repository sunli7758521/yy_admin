package com.ruoyi.sysusersystem.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 隐患对象 jz_hidden_trouble
 * 
 * @author sunli
 * @date 2020-01-06
 */
public class JzHiddenTroubleVO
{
    private static final long serialVersionUID = 1L;

    /**
     * 隐患类型名称
     */
    private String typeName;

    /** 盘查人 */

    private String identifyPeople;

    /** 整改人 */
    private String rectificationPeople;

    /** 整改时间 */
    private String rectificationTime;

    /** 状态（0.未整改常 1.已整改 2.预期未整改） */
    private String state;

    /** 隐患内容 */
    private String hiddenContent;

    /** 隐患位置 */
    private String hiddenWz;

    /** 隐患级别 */
    private String hiddenJb;

    /** 备注 */
    private String remark;

    /** 检查人名称 */
    private String  userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIdentifyPeople() {
        return identifyPeople;
    }

    public void setIdentifyPeople(String identifyPeople) {
        this.identifyPeople = identifyPeople;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getHiddenJb() {
        return hiddenJb;
    }

    public void setHiddenJb(String hiddenJb) {
        this.hiddenJb = hiddenJb;
    }
}
