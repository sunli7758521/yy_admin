package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzDutyEditUserRecordMapper;
import com.ruoyi.sysusersystem.domain.JzDutyEditUserRecord;
import com.ruoyi.sysusersystem.service.IJzDutyEditUserRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 值班修改用户记录Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-13
 */
@Service
public class JzDutyEditUserRecordServiceImpl implements IJzDutyEditUserRecordService 
{
    @Autowired
    private JzDutyEditUserRecordMapper jzDutyEditUserRecordMapper;

    /**
     * 查询值班修改用户记录
     * 
     * @param recordId 值班修改用户记录ID
     * @return 值班修改用户记录
     */
    @Override
    public JzDutyEditUserRecord selectJzDutyEditUserRecordById(Long recordId)
    {
        return jzDutyEditUserRecordMapper.selectJzDutyEditUserRecordById(recordId);
    }

    /**
     * 查询值班修改用户记录列表
     * 
     * @param jzDutyEditUserRecord 值班修改用户记录
     * @return 值班修改用户记录
     */
    @Override
    public List<JzDutyEditUserRecord> selectJzDutyEditUserRecordList(JzDutyEditUserRecord jzDutyEditUserRecord)
    {
        return jzDutyEditUserRecordMapper.selectJzDutyEditUserRecordList(jzDutyEditUserRecord);
    }

    /**
     * 新增值班修改用户记录
     * 
     * @param jzDutyEditUserRecord 值班修改用户记录
     * @return 结果
     */
    @Override
    public int insertJzDutyEditUserRecord(JzDutyEditUserRecord jzDutyEditUserRecord)
    {
        jzDutyEditUserRecord.setCreateTime(DateUtils.getNowDate());
        return jzDutyEditUserRecordMapper.insertJzDutyEditUserRecord(jzDutyEditUserRecord);
    }

    /**
     * 修改值班修改用户记录
     * 
     * @param jzDutyEditUserRecord 值班修改用户记录
     * @return 结果
     */
    @Override
    public int updateJzDutyEditUserRecord(JzDutyEditUserRecord jzDutyEditUserRecord)
    {
        jzDutyEditUserRecord.setUpdateTime(DateUtils.getNowDate());
        return jzDutyEditUserRecordMapper.updateJzDutyEditUserRecord(jzDutyEditUserRecord);
    }

    /**
     * 删除值班修改用户记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzDutyEditUserRecordByIds(String ids)
    {
        return jzDutyEditUserRecordMapper.deleteJzDutyEditUserRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除值班修改用户记录信息
     * 
     * @param recordId 值班修改用户记录ID
     * @return 结果
     */
    @Override
    public int deleteJzDutyEditUserRecordById(Long recordId)
    {
        return jzDutyEditUserRecordMapper.deleteJzDutyEditUserRecordById(recordId);
    }
}
