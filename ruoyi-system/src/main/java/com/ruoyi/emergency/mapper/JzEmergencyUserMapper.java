package com.ruoyi.emergency.mapper;

import com.ruoyi.emergency.domain.JzEmergencyUser;
import java.util.List;

/**
 * 应急方案关联人员Mapper接口
 * 
 * @author sunli
 * @date 2020-01-04
 */
public interface JzEmergencyUserMapper 
{
    /**
     * 查询应急方案关联人员
     * 
     * @param userId 应急方案关联人员ID
     * @return 应急方案关联人员
     */
    public JzEmergencyUser selectJzEmergencyUserById(Long userId);

    /**
     * 查询应急方案关联人员列表
     * 
     * @param jzEmergencyUser 应急方案关联人员
     * @return 应急方案关联人员集合
     */
    public List<JzEmergencyUser> selectJzEmergencyUserList(JzEmergencyUser jzEmergencyUser);

    /**
     * 新增应急方案关联人员
     * 
     * @param jzEmergencyUser 应急方案关联人员
     * @return 结果
     */
    public int insertJzEmergencyUser(JzEmergencyUser jzEmergencyUser);

    /**
     * 修改应急方案关联人员
     * 
     * @param jzEmergencyUser 应急方案关联人员
     * @return 结果
     */
    public int updateJzEmergencyUser(JzEmergencyUser jzEmergencyUser);

    /**
     * 删除应急方案关联人员
     * 
     * @param userId 应急方案关联人员ID
     * @return 结果
     */
    public int deleteJzEmergencyUserById(Long userId);

    /**
     * 批量删除应急方案关联人员
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzEmergencyUserByIds(String[] userIds);
}
