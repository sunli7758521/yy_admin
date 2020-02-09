package com.ruoyi.equipment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备规格对象 jz_equipment_specifications
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public class JzEquipmentSpecifications extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 规格主键 */
    private Long spId;

    /** 规格名称 */
    @Excel(name = "规格名称")
    private String spName;

    /** 配件名称 */
    //@Excel(name = "规格名称")
    private String erName;

    /** 型号 */
   // @Excel(name = "型号")
    private String ggXh;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 类型： 0.电力类1热源类2.燃气类 3.制冷及空调类4.给排水5.电梯类6.医用气体类7.食堂安全类8.工地安全类 */
    @Excel(name = "类型： 0.电力类1热源类2.燃气类 3.制冷及空调类4.给排水5.电梯类6.医用气体类7.食堂安全类8.工地安全类")
    private String type;

    /** 状态 */
    private String erType;

    /** 状态：0.库存正常 1库存异常 */
    @Excel(name = "状态：0.库存正常 1库存异常")
    private String state;

    /** 系统id */
    @Excel(name = "系统id")
    private Long systemId;

    /** 所属系统 */
    private String systemName;

    /** 设备id */
    @Excel(name = "设备id")
    private Long sbId;

    /**设备名称*/
    private String sbName;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;

    /** 创建人 */
    private String createName;

    /** 设备重量 */
    @Excel(name = "设备重量")
    private String zl;

    /** 设备功率 */
    @Excel(name = "设备功率")
    private String gl;

    /** 设备电压 */
    @Excel(name = "设备电压")
    private String dy;

    /** 设备电流 */
    @Excel(name = "设备电流")
    private String dl;

    /** 设备转速 */
    @Excel(name = "设备转速")
    private String zs;

    /** 设备载重 */
    @Excel(name = "设备载重")
    private String zz;

    /** 控制方式 */
    @Excel(name = "控制方式")
    private String kzfs;

    /** 控制压力 */
    @Excel(name = "控制压力")
    private String kzyl;

    public String getErName() {
        return erName;
    }

    public void setErName(String erName) {
        this.erName = erName;
    }

    public String getGgXh() {
        return ggXh;
    }

    public void setGgXh(String ggXh) {
        this.ggXh = ggXh;
    }

    public void setSpId(Long spId)
    {
        this.spId = spId;
    }

    public Long getSpId() 
    {
        return spId;
    }
    public void setSpName(String spName) 
    {
        this.spName = spName;
    }

    public String getSpName() 
    {
        return spName;
    }
    public void setSystemId(Long systemId) 
    {
        this.systemId = systemId;
    }

    public Long getSystemId() 
    {
        return systemId;
    }
    public void setSbId(Long sbId) 
    {
        this.sbId = sbId;
    }

    public Long getSbId() 
    {
        return sbId;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }
    public void setZl(String zl) 
    {
        this.zl = zl;
    }

    public String getZl() 
    {
        return zl;
    }
    public void setGl(String gl) 
    {
        this.gl = gl;
    }

    public String getGl() 
    {
        return gl;
    }
    public void setDy(String dy) 
    {
        this.dy = dy;
    }

    public String getDy() 
    {
        return dy;
    }
    public void setDl(String dl) 
    {
        this.dl = dl;
    }

    public String getDl() 
    {
        return dl;
    }
    public void setZs(String zs) 
    {
        this.zs = zs;
    }

    public String getZs() 
    {
        return zs;
    }
    public void setZz(String zz) 
    {
        this.zz = zz;
    }

    public String getZz() 
    {
        return zz;
    }
    public void setKzfs(String kzfs) 
    {
        this.kzfs = kzfs;
    }

    public String getKzfs() 
    {
        return kzfs;
    }
    public void setKzyl(String kzyl) 
    {
        this.kzyl = kzyl;
    }

    public String getKzyl() 
    {
        return kzyl;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getErType() {
        return erType;
    }

    public void setErType(String erType) {
        this.erType = erType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "JzEquipmentSpecifications{" +
                "spId=" + spId +
                ", spName='" + spName + '\'' +
                ", erName='" + erName + '\'' +
                ", ggXh='" + ggXh + '\'' +
                ", num=" + num +
                ", type='" + type + '\'' +
                ", erType='" + erType + '\'' +
                ", state='" + state + '\'' +
                ", systemId=" + systemId +
                ", systemName='" + systemName + '\'' +
                ", sbId=" + sbId +
                ", sbName='" + sbName + '\'' +
                ", createId=" + createId +
                ", createName='" + createName + '\'' +
                ", zl='" + zl + '\'' +
                ", gl='" + gl + '\'' +
                ", dy='" + dy + '\'' +
                ", dl='" + dl + '\'' +
                ", zs='" + zs + '\'' +
                ", zz='" + zz + '\'' +
                ", kzfs='" + kzfs + '\'' +
                ", kzyl='" + kzyl + '\'' +
                '}';
    }
}
