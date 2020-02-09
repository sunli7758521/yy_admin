package com.ruoyi.equipment.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.equipment.mapper.JzEquipmentMapper;
import com.ruoyi.equipment.domain.JzEquipment;
import com.ruoyi.equipment.service.IJzEquipmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 系统设备Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
@Service
public class JzEquipmentServiceImpl implements IJzEquipmentService 
{
    @Autowired
    private JzEquipmentMapper jzEquipmentMapper;

    /**
     * 查询系统设备
     * 
     * @param sbId 系统设备ID
     * @return 系统设备
     */
    @Override
    public JzEquipment selectJzEquipmentById(Long sbId)
    {
        return jzEquipmentMapper.selectJzEquipmentById(sbId);
    }

    /**
     * 查询系统设备列表
     * 
     * @param jzEquipment 系统设备
     * @return 系统设备
     */
    @Override
    public List<JzEquipment> selectJzEquipmentList(JzEquipment jzEquipment)
    {
        return jzEquipmentMapper.selectJzEquipmentList(jzEquipment);
    }

    /**
     * 新增系统设备
     * 
     * @param jzEquipment 系统设备
     * @return 结果
     */
    @Override
    public int insertJzEquipment(JzEquipment jzEquipment)
    {
        jzEquipment.setCreateTime(DateUtils.getNowDate());
        return jzEquipmentMapper.insertJzEquipment(jzEquipment);
    }

    /**
     * 修改系统设备
     * 
     * @param jzEquipment 系统设备
     * @return 结果
     */
    @Override
    public int updateJzEquipment(JzEquipment jzEquipment)
    {
        jzEquipment.setUpdateTime(DateUtils.getNowDate());
        return jzEquipmentMapper.updateJzEquipment(jzEquipment);
    }

    /**
     * 删除系统设备对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzEquipmentByIds(String ids)
    {
        return jzEquipmentMapper.deleteJzEquipmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除系统设备信息
     * 
     * @param sbId 系统设备ID
     * @return 结果
     */
    @Override
    public int deleteJzEquipmentById(Long sbId)
    {
        return jzEquipmentMapper.deleteJzEquipmentById(sbId);
    }

    /***
     * 设备下拉框
     * @return
     */
    @Override
    public List<JzEquipment> sbList() {
        return jzEquipmentMapper.sbList();
    }

    /**
     *  大班长查询数据
     */
    @Override
    public List<JzEquipment> selectDbzList(String id, String num, String state, String azName, Object beginInTime, Object endInTime) {
        return jzEquipmentMapper.selectDbzList(Convert.toStrArray(id),num,state,azName,beginInTime,endInTime);
    }


}
