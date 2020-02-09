package com.ruoyi.equipment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备备品件库对象 jz_equipment_rep
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
public class JzEquipmentRep extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备备品件库id */
    private Long id;

    /** 规格id */
    @Excel(name = "规格id")
    private Long spId;

    /** 规格名称 */
    //@Excel(name = "规格名称")
    private String spName;

    /** 配件名称 */
    @Excel(name = "配件名称")
    private String name;

    /** 型号 */
    @Excel(name = "型号")
    private String ggXh;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 最高储存数量 */
    @Excel(name = "最高储存数量")
    private Long highestNum;

    /** 最低储存数量 */
    @Excel(name = "最低储存数量")
    private Long minimumNum;

    /** 类型： 0.电力类1热源类2.燃气类 3.制冷及空调类4.给排水5.电梯类6.医用气体类7.食堂安全类8.工地安全类 */
    @Excel(name = "类型： 0.电力类1热源类2.燃气类 3.制冷及空调类4.给排水5.电梯类6.医用气体类7.食堂安全类8.工地安全类")
    private String type;

    /** 状态 */
    private String ertype;

    /** 状态：0.库存正常 1库存异常 */
    @Excel(name = "状态：0.库存正常 1库存异常")
    private String state;


    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createId;

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getErtype() {
        return ertype;
    }

    public void setErtype(String ertype) {
        this.ertype = ertype;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /** 创建人 */
    private String createName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSpId(Long spId) 
    {
        this.spId = spId;
    }

    public Long getSpId() 
    {
        return spId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGgXh(String ggXh) 
    {
        this.ggXh = ggXh;
    }

    public String getGgXh() 
    {
        return ggXh;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setHighestNum(Long highestNum) 
    {
        this.highestNum = highestNum;
    }

    public Long getHighestNum() 
    {
        return highestNum;
    }
    public void setMinimumNum(Long minimumNum) 
    {
        this.minimumNum = minimumNum;
    }

    public Long getMinimumNum() 
    {
        return minimumNum;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("spId", getSpId())
            .append("name", getName())
            .append("ggXh", getGgXh())
            .append("num", getNum())
            .append("highestNum", getHighestNum())
            .append("minimumNum", getMinimumNum())
            .append("type", getType())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("createId", getCreateId())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
