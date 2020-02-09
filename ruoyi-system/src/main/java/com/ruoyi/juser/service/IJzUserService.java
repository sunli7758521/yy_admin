package com.ruoyi.juser.service;

import com.ruoyi.juser.domain.JzUser;
import java.util.List;

/**
 * 用户Service接口
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
public interface IJzUserService 
{
    /**
     * 查询用户
     * 
     * @param userId 用户ID
     * @return 用户
     */
    public JzUser selectJzUserById(Long userId);

    /**
     * 查询用户列表
     * 
     * @param jzUser 用户
     * @return 用户集合
     */
    public List<JzUser> selectJzUserList(JzUser jzUser);

    /**
     * 新增用户
     * 
     * @param jzUser 用户
     * @return 结果
     */
    public int insertJzUser(JzUser jzUser);

    /**
     * 修改用户
     * 
     * @param jzUser 用户
     * @return 结果
     */
    public int updateJzUser(JzUser jzUser);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzUserByIds(String ids);

    /**
     * 删除用户信息
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteJzUserById(Long userId);
    /**
     * 员工下拉列表
     * @return
     */
    public List<JzUser> uList();
    /**
     * 员工下拉列表
     * @return
     */
    public List<JzUser> usList(String uid);
    /**
     * 大班长查询所用的用户
     * @return
     * @param jzUser
     * @param userNum
     * @param state
     * @param phone
     * @param userName
     * @param teamId
     * @param userType
     * @param gender
     */
    List<JzUser> selectDbzUserList(String id, String userNum, Long state, String phone, String userName, Long teamId, Long userType, String gender);
}
