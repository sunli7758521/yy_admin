package com.ruoyi.emergency.mapper;

import com.ruoyi.emergency.domain.JzEmergencyRehearse;
import java.util.List;

/**
 * 应急方案关联演练Mapper接口
 * 
 * @author sunli
 * @date 2020-01-04
 */
public interface JzEmergencyRehearseMapper 
{
    /**
     * 查询应急方案关联演练
     * 
     * @param rehearseId 应急方案关联演练ID
     * @return 应急方案关联演练
     */
    public JzEmergencyRehearse selectJzEmergencyRehearseById(Long rehearseId);

    /**
     * 查询应急方案关联演练列表
     * 
     * @param jzEmergencyRehearse 应急方案关联演练
     * @return 应急方案关联演练集合
     */
    public List<JzEmergencyRehearse> selectJzEmergencyRehearseList(JzEmergencyRehearse jzEmergencyRehearse);

    /**
     * 新增应急方案关联演练
     * 
     * @param jzEmergencyRehearse 应急方案关联演练
     * @return 结果
     */
    public int insertJzEmergencyRehearse(JzEmergencyRehearse jzEmergencyRehearse);

    /**
     * 修改应急方案关联演练
     * 
     * @param jzEmergencyRehearse 应急方案关联演练
     * @return 结果
     */
    public int updateJzEmergencyRehearse(JzEmergencyRehearse jzEmergencyRehearse);

    /**
     * 删除应急方案关联演练
     * 
     * @param rehearseId 应急方案关联演练ID
     * @return 结果
     */
    public int deleteJzEmergencyRehearseById(Long rehearseId);

    /**
     * 批量删除应急方案关联演练
     * 
     * @param rehearseIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEmergencyRehearseByIds(String[] rehearseIds);
}
