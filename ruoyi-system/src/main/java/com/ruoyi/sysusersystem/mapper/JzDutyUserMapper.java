package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.JzDutyUser;
import java.util.List;

/**
 * 值班关联用户Mapper接口
 * 
 * @author sunli
 * @date 2020-01-13
 */
public interface JzDutyUserMapper 
{
    /**
     * 查询值班关联用户
     * 
     * @param dutyUserId 值班关联用户ID
     * @return 值班关联用户
     */
    public JzDutyUser selectJzDutyUserById(Long dutyUserId);

    /**
     * 查询值班关联用户列表
     * 
     * @param jzDutyUser 值班关联用户
     * @return 值班关联用户集合
     */
    public List<JzDutyUser> selectJzDutyUserList(JzDutyUser jzDutyUser);

    /**
     * 新增值班关联用户
     * 
     * @param jzDutyUser 值班关联用户
     * @return 结果
     */
    public int insertJzDutyUser(JzDutyUser jzDutyUser);

    /**
     * 修改值班关联用户
     * 
     * @param jzDutyUser 值班关联用户
     * @return 结果
     */
    public int updateJzDutyUser(JzDutyUser jzDutyUser);

    /**
     * 删除值班关联用户
     * 
     * @param dutyUserId 值班关联用户ID
     * @return 结果
     */
    public int deleteJzDutyUserById(Long dutyUserId);

    /**
     * 批量删除值班关联用户
     * 
     * @param dutyUserIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzDutyUserByIds(String[] dutyUserIds);
}
