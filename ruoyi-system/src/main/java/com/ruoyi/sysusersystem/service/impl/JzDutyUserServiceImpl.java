package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.sysusersystem.domain.*;
import com.ruoyi.sysusersystem.mapper.JzDutyEditUserRecordMapper;
import com.ruoyi.sysusersystem.mapper.JzDutyUserLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzDutyUserMapper;
import com.ruoyi.sysusersystem.service.IJzDutyUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 值班关联用户Service业务层处理
 *
 * @author sunli
 * @date 2020-01-13
 */
@Service
public class JzDutyUserServiceImpl implements IJzDutyUserService
{
    @Autowired
    private JzDutyUserMapper jzDutyUserMapper;

    @Autowired
    private JzDutyUserLogMapper jzDutyUserLogMapper;

    @Autowired
    private JzDutyEditUserRecordMapper jzDutyEditUserRecordMapper;

    /**
     * 查询值班关联用户
     *
     * @param dutyUserId 值班关联用户ID
     * @return 值班关联用户
     */
    @Override
    public JzDutyUser selectJzDutyUserById(Long dutyUserId)
    {
        return jzDutyUserMapper.selectJzDutyUserById(dutyUserId);
    }

    /**
     * 那个日期有多少人值班
     * @return
     */
    @Override
    public List<JzDutyUser> selectShuLiang() {
        return jzDutyUserMapper.selectShuLiang();
    }

    @Override
    public List<JzDutyUser> selectList(String zbTime) {
        return jzDutyUserMapper.selectList(zbTime);
    }

    /**
     * 查询值班关联用户列表
     *
     * @param jzDutyUser 值班关联用户
     * @return 值班关联用户
     */
    @Override
    public List<JzDutyUser> selectJzDutyUserList(JzDutyUser jzDutyUser)
    {
        return jzDutyUserMapper.selectJzDutyUserList(jzDutyUser);
    }

    /**
     * 新增值班关联用户
     *
     * @param jzDutyUser 值班关联用户
     * @return 结果
     */
    @Override
    public int insertJzDutyUser(JzDutyUser jzDutyUser)
    {
        int i  = jzDutyUserMapper.insertJzDutyUser(jzDutyUser);
        addJzDutyUser(jzDutyUser);
        return i;
    }
    // 添加任务模板
    private int addJzDutyUser(JzDutyUser jzDutyUser) {
        JzDutyUserLog jzDutyUserLog = new JzDutyUserLog();
        jzDutyUserLog.setDutyUserId(jzDutyUser.getDutyUserId());
        jzDutyUserLog.setUserId(jzDutyUser.getUserId());
        jzDutyUserLog.setPlanId(jzDutyUser.getPlanId());
        jzDutyUserLog.setType(jzDutyUser.getType());
        jzDutyUserLog.setCreateTime(jzDutyUser.getCreateTime());
        jzDutyUserLog.setState(jzDutyUser.getState());
//        return jzDutyUserLogMapper.insertJzDutyUser(jzDutyUserLog);
        return jzDutyUserLogMapper.insertJzDutyUser(jzDutyUserLog);
    }

    /**
     * 修改值班关联用户
     *
     * @param jzDutyUser 值班关联用户
     * @return 结果
     */
    @Override
    public int updateJzDutyUser(JzDutyUser jzDutyUser)
    {
        udJzDutyUser(jzDutyUser);//保存到日志表jz_duty_user_log
        upJzdutyEditUserRecordMapper(jzDutyUser);//修改值班人员相关信息，保存到jz_duty_edit_user_record 保存修改人，时间
        jzDutyUser.setUpdateTime(DateUtils.getNowDate());
        return jzDutyUserMapper.updateJzDutyUser(jzDutyUser);
    }
    private int upJzdutyEditUserRecordMapper(JzDutyUser jzDutyUser){
        JzDutyEditUserRecord jzDutyEditUserRecord = new JzDutyEditUserRecord();
        jzDutyEditUserRecord.setRecordId(jzDutyUser.getDutyUserId());
        jzDutyEditUserRecord.setCreateTime(jzDutyUser.getCreateTime());
        jzDutyEditUserRecord.setUpdateTime(jzDutyUser.getUpdateTime());
        jzDutyEditUserRecord.setUserId(jzDutyUser.getUserId());//用户Id
        return jzDutyEditUserRecordMapper.insertJzDutyEditUserRecord(jzDutyEditUserRecord);
    }
    //更新模板
    private int udJzDutyUser(JzDutyUser jzDutyUser) {
        JzDutyUserLog jzDutyUserLog = new JzDutyUserLog();
        jzDutyUserLog.setDutyUserId(jzDutyUser.getDutyUserId());
        jzDutyUserLog.setUserId(jzDutyUser.getUserId());
        jzDutyUserLog.setPlanId(jzDutyUser.getPlanId());
        jzDutyUserLog.setType(jzDutyUser.getType());
        jzDutyUserLog.setCreateTime(jzDutyUser.getCreateTime());
        jzDutyUserLog.setState(jzDutyUser.getState());
//        return jzDutyUserLogMapper.insertJzDutyUser(jzDutyUserLog);
        return jzDutyUserLogMapper.updateJzDutyUser(jzDutyUserLog);
    }

    /**
     * 删除值班关联用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzDutyUserByIds(String ids)
    {
        return jzDutyUserMapper.deleteJzDutyUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除值班关联用户信息
     *
     * @param dutyUserId 值班关联用户ID
     * @return 结果
     */
    @Override
    public int deleteJzDutyUserById(Long dutyUserId)
    {
        return jzDutyUserMapper.deleteJzDutyUserById(dutyUserId);
    }
}
