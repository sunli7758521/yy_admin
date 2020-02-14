package com.ruoyi.emergency.service.impl;

import java.util.List;

import com.ruoyi.juser.domain.JzUser;
import com.ruoyi.juser.mapper.JzUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.emergency.mapper.JzEmergencyUserMapper;
import com.ruoyi.emergency.domain.JzEmergencyUser;
import com.ruoyi.emergency.service.IJzEmergencyUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 应急方案关联人员Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-04
 */
@Service
public class JzEmergencyUserServiceImpl implements IJzEmergencyUserService 
{
    @Autowired
    private JzEmergencyUserMapper jzEmergencyUserMapper;

    @Autowired
    private JzUserMapper jzUserMapper;

    /**
     * 查询应急方案关联人员
     * 
     * @param userId 应急方案关联人员ID
     * @return 应急方案关联人员
     */
    @Override
    public JzEmergencyUser selectJzEmergencyUserById(Long userId)
    {
        return jzEmergencyUserMapper.selectJzEmergencyUserById(userId);
    }

    /**
     * 查询应急方案关联组员列表
     * 
     * @param jzEmergencyUser 应急方案关联组员
     * @return 应急方案关联组员
     */
    @Override
    public List<JzEmergencyUser> selectJzEmergencyUserList(JzEmergencyUser jzEmergencyUser)
    {
        List<JzEmergencyUser> list =    jzEmergencyUserMapper.selectJzEmergencyUserList(jzEmergencyUser);
      if(list !=null){
          for (JzEmergencyUser user : list) {
              String[] split = user.getGroupUserId().split(",");
              String userName = "";
              for (String s : split) {
                  JzUser jzUser = jzUserMapper.selectJzUserById(Long.parseLong(s));
                  if(jzUser !=null){
                      userName+=jzUser.getUserName()+",";
                  }
              }
              user.setGroupUserName(userName);
          }
          for (JzEmergencyUser userOne : list) {
              String[] split = userOne.getViceGroupLeaderId().split(",");
              String userNameOne = "";
              for (String s : split) {
//                  JzUser jzUser = jzUserMapper.selectJzUserById(Long.parseLong(s));
                  JzUser jzUser = jzUserMapper.selectJzUserById(Long.parseLong(s));
                  if(jzUser !=null){
                      userNameOne+=jzUser.getUserName()+",";
                  }
              }
              userOne.setViceGroupLeaderName(userNameOne);
          }
      }
        return list;
    }

    /**
     * 新增应急方案关联人员
     * 
     * @param jzEmergencyUser 应急方案关联人员
     * @return 结果
     */
    @Override
    public int insertJzEmergencyUser(JzEmergencyUser jzEmergencyUser)
    {
        return jzEmergencyUserMapper.insertJzEmergencyUser(jzEmergencyUser);
    }

    /**
     * 修改应急方案关联人员
     * 
     * @param jzEmergencyUser 应急方案关联人员
     * @return 结果
     */
    @Override
    public int updateJzEmergencyUser(JzEmergencyUser jzEmergencyUser)
    {
        return jzEmergencyUserMapper.updateJzEmergencyUser(jzEmergencyUser);
    }

    /**
     * 删除应急方案关联人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzEmergencyUserByIds(String ids)
    {
        return jzEmergencyUserMapper.deleteJzEmergencyUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除应急方案关联人员信息
     * 
     * @param userId 应急方案关联人员ID
     * @return 结果
     */
    @Override
    public int deleteJzEmergencyUserById(Long userId)
    {
        return jzEmergencyUserMapper.deleteJzEmergencyUserById(userId);
    }
}
