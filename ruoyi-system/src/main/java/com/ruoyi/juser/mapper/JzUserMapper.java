package com.ruoyi.juser.mapper;

import com.ruoyi.juser.domain.JzUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
public interface JzUserMapper 
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
     * 删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteJzUserById(Long userId);

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzUserByIds(String[] userIds);
    /**
     * 员工下拉列表
     * @return
     */
    public List<JzUser> uList();
    /**
     * 员工下拉列表
     * @return
     */
    public List<JzUser> usList(String[] uid);
    /**
     * 大班长查询所用的用户
     * @return
     */
    List<JzUser> selectDbzUserList(@Param("array") String[]  systemIds, @Param("userNum") String userNum,
                                   @Param("state") Long state, @Param("phone") String phone,
                                   @Param("userName") String userName,
                                   @Param("teamId") Long teamId,
                                   @Param("userType")Long userType, @Param("gender")String gender);
}
