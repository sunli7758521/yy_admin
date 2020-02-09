package com.ruoyi.emergency.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.emergency.mapper.JzEmergencyRehearseMapper;
import com.ruoyi.emergency.domain.JzEmergencyRehearse;
import com.ruoyi.emergency.service.IJzEmergencyRehearseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 应急方案关联演练Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-04
 */
@Service
public class JzEmergencyRehearseServiceImpl implements IJzEmergencyRehearseService 
{
    @Autowired
    private JzEmergencyRehearseMapper jzEmergencyRehearseMapper;

    /**
     * 查询应急方案关联演练
     * 
     * @param rehearseId 应急方案关联演练ID
     * @return 应急方案关联演练
     */
    @Override
    public JzEmergencyRehearse selectJzEmergencyRehearseById(Long rehearseId)
    {
        return jzEmergencyRehearseMapper.selectJzEmergencyRehearseById(rehearseId);
    }

    /**
     * 查询应急方案关联演练列表
     * 
     * @param jzEmergencyRehearse 应急方案关联演练
     * @return 应急方案关联演练
     */
    @Override
    public List<JzEmergencyRehearse> selectJzEmergencyRehearseList(JzEmergencyRehearse jzEmergencyRehearse)
    {
        return jzEmergencyRehearseMapper.selectJzEmergencyRehearseList(jzEmergencyRehearse);
    }

    /**
     * 新增应急方案关联演练
     * 
     * @param jzEmergencyRehearse 应急方案关联演练
     * @return 结果
     */
    @Override
    public int insertJzEmergencyRehearse(JzEmergencyRehearse jzEmergencyRehearse)
    {
        jzEmergencyRehearse.setCreateTime(DateUtils.getNowDate());
        return jzEmergencyRehearseMapper.insertJzEmergencyRehearse(jzEmergencyRehearse);
    }

    /**
     * 修改应急方案关联演练
     * 
     * @param jzEmergencyRehearse 应急方案关联演练
     * @return 结果
     */
    @Override
    public int updateJzEmergencyRehearse(JzEmergencyRehearse jzEmergencyRehearse)
    {
        return jzEmergencyRehearseMapper.updateJzEmergencyRehearse(jzEmergencyRehearse);
    }

    /**
     * 删除应急方案关联演练对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzEmergencyRehearseByIds(String ids)
    {
        return jzEmergencyRehearseMapper.deleteJzEmergencyRehearseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除应急方案关联演练信息
     * 
     * @param rehearseId 应急方案关联演练ID
     * @return 结果
     */
    @Override
    public int deleteJzEmergencyRehearseById(Long rehearseId)
    {
        return jzEmergencyRehearseMapper.deleteJzEmergencyRehearseById(rehearseId);
    }
}
