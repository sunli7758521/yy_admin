package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.JzWarrantyWx;
import java.util.List;

/**
 * 维修记录Mapper接口
 * 
 * @author sunli
 * @date 2020-02-19
 */
public interface JzWarrantyWxMapper 
{
    /**
     * 查询维修记录
     * 
     * @param wxId 维修记录ID
     * @return 维修记录
     */
    public JzWarrantyWx selectJzWarrantyWxById(Long wxId);

    /**
     * 查询维修记录列表
     * 
     * @param jzWarrantyWx 维修记录
     * @return 维修记录集合
     */
    public List<JzWarrantyWx> selectJzWarrantyWxList(JzWarrantyWx jzWarrantyWx);

    /**
     * 新增维修记录
     * 
     * @param jzWarrantyWx 维修记录
     * @return 结果
     */
    public int insertJzWarrantyWx(JzWarrantyWx jzWarrantyWx);

    /**
     * 修改维修记录
     * 
     * @param jzWarrantyWx 维修记录
     * @return 结果
     */
    public int updateJzWarrantyWx(JzWarrantyWx jzWarrantyWx);

    /**
     * 删除维修记录
     * 
     * @param wxId 维修记录ID
     * @return 结果
     */
    public int deleteJzWarrantyWxById(Long wxId);

    /**
     * 批量删除维修记录
     * 
     * @param wxIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzWarrantyWxByIds(String[] wxIds);
}
