package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.JzDutyEditUserRecord;
import java.util.List;

/**
 * 值班修改用户记录Mapper接口
 * 
 * @author sunli
 * @date 2020-01-13
 */
public interface JzDutyEditUserRecordMapper 
{
    /**
     * 查询值班修改用户记录
     * 
     * @param recordId 值班修改用户记录ID
     * @return 值班修改用户记录
     */
    public JzDutyEditUserRecord selectJzDutyEditUserRecordById(Long recordId);

    /**
     * 查询值班修改用户记录列表
     * 
     * @param jzDutyEditUserRecord 值班修改用户记录
     * @return 值班修改用户记录集合
     */
    public List<JzDutyEditUserRecord> selectJzDutyEditUserRecordList(JzDutyEditUserRecord jzDutyEditUserRecord);

    /**
     * 新增值班修改用户记录
     * 
     * @param jzDutyEditUserRecord 值班修改用户记录
     * @return 结果
     */
    public int insertJzDutyEditUserRecord(JzDutyEditUserRecord jzDutyEditUserRecord);

    /**
     * 修改值班修改用户记录
     * 
     * @param jzDutyEditUserRecord 值班修改用户记录
     * @return 结果
     */
    public int updateJzDutyEditUserRecord(JzDutyEditUserRecord jzDutyEditUserRecord);

    /**
     * 删除值班修改用户记录
     * 
     * @param recordId 值班修改用户记录ID
     * @return 结果
     */
    public int deleteJzDutyEditUserRecordById(Long recordId);

    /**
     * 批量删除值班修改用户记录
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzDutyEditUserRecordByIds(String[] recordIds);
}
