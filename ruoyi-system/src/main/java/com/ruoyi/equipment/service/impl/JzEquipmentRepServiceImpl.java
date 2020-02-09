package com.ruoyi.equipment.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.equipment.mapper.JzEquipmentRepMapper;
import com.ruoyi.equipment.domain.JzEquipmentRep;
import com.ruoyi.equipment.service.IJzEquipmentRepService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备备品件库Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
@Service
public class JzEquipmentRepServiceImpl implements IJzEquipmentRepService 
{
    @Autowired
    private JzEquipmentRepMapper jzEquipmentRepMapper;

    /**
     * 查询设备备品件库
     * 
     * @param id 设备备品件库ID
     * @return 设备备品件库
     */
    @Override
    public JzEquipmentRep selectJzEquipmentRepById(Long id)
    {
        return jzEquipmentRepMapper.selectJzEquipmentRepById(id);
    }

    /**
     * 查询设备备品件库列表
     * 
     * @param jzEquipmentRep 设备备品件库
     * @return 设备备品件库
     */
    @Override
    public List<JzEquipmentRep> selectJzEquipmentRepList(JzEquipmentRep jzEquipmentRep)
    {
        return jzEquipmentRepMapper.selectJzEquipmentRepList(jzEquipmentRep);
    }

    /**
     * 新增设备备品件库
     * 
     * @param jzEquipmentRep 设备备品件库
     * @return 结果
     */
    @Override
    public int insertJzEquipmentRep(JzEquipmentRep jzEquipmentRep)
    {
        jzEquipmentRep.setCreateTime(DateUtils.getNowDate());
        return jzEquipmentRepMapper.insertJzEquipmentRep(jzEquipmentRep);
    }

    /**
     * 修改设备备品件库
     * 
     * @param jzEquipmentRep 设备备品件库
     * @return 结果
     */
    @Override
    public int updateJzEquipmentRep(JzEquipmentRep jzEquipmentRep)
    {
        jzEquipmentRep.setUpdateTime(DateUtils.getNowDate());
        return jzEquipmentRepMapper.updateJzEquipmentRep(jzEquipmentRep);
    }

    /**
     * 删除设备备品件库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzEquipmentRepByIds(String ids)
    {
        return jzEquipmentRepMapper.deleteJzEquipmentRepByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备备品件库信息
     * 
     * @param id 设备备品件库ID
     * @return 结果
     */
    @Override
    public int deleteJzEquipmentRepById(Long id)
    {
        return jzEquipmentRepMapper.deleteJzEquipmentRepById(id);
    }
}
