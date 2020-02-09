package com.ruoyi.juser.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.juser.domain.JzUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.juser.mapper.JzUserMapper;
import com.ruoyi.juser.service.IJzUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-24
 */
@Service
public class JzUserServiceImpl implements IJzUserService 
{
    @Autowired
    private JzUserMapper jzUserMapper;

    /**
     * 查询用户
     * 
     * @param userId 用户ID
     * @return 用户
     */
    @Override
    public JzUser selectJzUserById(Long userId)
    {
        return jzUserMapper.selectJzUserById(userId);
    }

    /**
     * 查询用户列表
     * 
     * @param jzUser 用户
     * @return 用户
     */
    @Override
    public List<JzUser> selectJzUserList(JzUser jzUser)
    {

        return jzUserMapper.selectJzUserList(jzUser);
    }

    /**
     * 新增用户
     * 
     * @param jzUser 用户
     * @return 结果
     */
    @Override
    public int insertJzUser(JzUser jzUser)
    {
        jzUser.setCreateTime(DateUtils.getNowDate());
        return jzUserMapper.insertJzUser(jzUser);
    }

    /**
     * 修改用户
     * 
     * @param jzUser 用户
     * @return 结果
     */
    @Override
    public int updateJzUser(JzUser jzUser)
    {
        jzUser.setUpdateTime(DateUtils.getNowDate());
        return jzUserMapper.updateJzUser(jzUser);
    }

    /**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzUserByIds(String ids)
    {
        return jzUserMapper.deleteJzUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteJzUserById(Long userId)
    {
        return jzUserMapper.deleteJzUserById(userId);
    }
    /**
     * 员工下拉列表
     * @return
     */
    @Override
    public List<JzUser> uList() {
        return jzUserMapper.uList();
    }

    /**
     * 员工下拉列表
     * @param uid
     * @return
     */
    @Override
    public List<JzUser> usList(String uid) {
        return jzUserMapper.usList(Convert.toStrArray(uid));
    }
    /**
     * 大班长查询所用的用户
     * @return
     * @param id
     * @param userNum
     * @param state
     * @param phone
     * @param userName
     * @param teamId
     * @param userType
     * @param gender
     *
     * Convert.toStrArray(id)
     */
    @Override
    public List<JzUser> selectDbzUserList(String id, String userNum, Long state, String phone, String userName,
                                          Long teamId, Long userType, String gender) {
        return jzUserMapper.selectDbzUserList(Convert.toStrArray(id),userNum,state,
                phone,userName,teamId,userType,gender);
    }
}
