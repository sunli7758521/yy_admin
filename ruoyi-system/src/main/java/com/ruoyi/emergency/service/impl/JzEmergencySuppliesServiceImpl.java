package com.ruoyi.emergency.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.emergency.mapper.JzEmergencySuppliesMapper;
import com.ruoyi.emergency.domain.JzEmergencySupplies;
import com.ruoyi.emergency.service.IJzEmergencySuppliesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 应急方案关联物资Service业务层处理
 *
 * @author sunli
 * @date 2020-01-04
 */
@Service
public class JzEmergencySuppliesServiceImpl implements IJzEmergencySuppliesService
{
    @Autowired
    private JzEmergencySuppliesMapper jzEmergencySuppliesMapper;

    /**
     * 查询应急方案关联物资
     *
     * @param suppliseId 应急方案关联物资ID
     * @return 应急方案关联物资
     */
    @Override
    public JzEmergencySupplies selectJzEmergencySuppliesById(Long suppliseId)
    {
        return jzEmergencySuppliesMapper.selectJzEmergencySuppliesById(suppliseId);
    }
    /**
     * 查询剩余总数量
     * @param suppliseSmTypeId
     * @return
     */
    @Override
    public Integer selectSum(Long suppliseSmTypeId){
        return jzEmergencySuppliesMapper.selectSum(suppliseSmTypeId);
    }
    /**
     * 查询应急方案关联物资列表
     *
     * @param jzEmergencySupplies 应急方案关联物资
     * @return 应急方案关联物资
     */
    @Override
    public List<JzEmergencySupplies> selectJzEmergencySuppliesList(JzEmergencySupplies jzEmergencySupplies)
    {
        return jzEmergencySuppliesMapper.selectJzEmergencySuppliesList(jzEmergencySupplies);
    }

    /**
     * 新增应急方案关联物资
     *
     * @param jzEmergencySupplies 应急方案关联物资
     * @return 结果
     */
    @Override
    public int insertJzEmergencySupplies(JzEmergencySupplies jzEmergencySupplies)
    {
        jzEmergencySupplies.setCreateTime(DateUtils.getNowDate());
        return jzEmergencySuppliesMapper.insertJzEmergencySupplies(jzEmergencySupplies);
    }

    /**
     * 修改应急方案关联物资
     *
     * @param jzEmergencySupplies 应急方案关联物资
     * @return 结果
     */
    @Override
    public int updateJzEmergencySupplies(JzEmergencySupplies jzEmergencySupplies)
    {
        jzEmergencySupplies.setUpdateTime(DateUtils.getNowDate());
        return jzEmergencySuppliesMapper.updateJzEmergencySupplies(jzEmergencySupplies);
    }

    /**
     * 删除应急方案关联物资对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzEmergencySuppliesByIds(String ids)
    {
        return jzEmergencySuppliesMapper.deleteJzEmergencySuppliesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除应急方案关联物资信息
     *
     * @param suppliseId 应急方案关联物资ID
     * @return 结果
     */
    @Override
    public int deleteJzEmergencySuppliesById(Long suppliseId)
    {
        return jzEmergencySuppliesMapper.deleteJzEmergencySuppliesById(suppliseId);
    }
}
