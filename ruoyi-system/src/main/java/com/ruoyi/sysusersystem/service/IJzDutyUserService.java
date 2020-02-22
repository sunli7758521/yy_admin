package com.ruoyi.sysusersystem.service;

import com.ruoyi.sysusersystem.domain.JzDutyUser;
import java.util.List;

/**
 * 值班关联用户Service接口
 *
 * @author sunli
 * @date 2020-01-13
 */
public interface IJzDutyUserService
{
    /**
     * 查询值班关联用户
     *
     * @param dutyUserId 值班关联用户ID
     * @return 值班关联用户
     */
    public JzDutyUser selectJzDutyUserById(Long dutyUserId);

    /**
     * 那个日期有多少值班人数
     * @return
     */
    public List<JzDutyUser> selectShuLiang();

    /**
     * 那个日期值班的具体人员
     * @return
     */
    public List<JzDutyUser> selectList(String zbTime);

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
     * 批量删除值班关联用户
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzDutyUserByIds(String ids);

    /**
     * 删除值班关联用户信息
     *
     * @param dutyUserId 值班关联用户ID
     * @return 结果
     */
    public int deleteJzDutyUserById(Long dutyUserId);
}
