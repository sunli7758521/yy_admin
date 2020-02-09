package com.ruoyi.business.service;

import com.ruoyi.business.domain.JzUserLicense;
import java.util.List;

/**
 * 用户证件照Service接口
 * 
 * @author ruoyi
 * @date 2019-12-10
 */
public interface IJzUserLicenseService 
{
    /**
     * 查询用户证件照
     * 
     * @param id 用户证件照ID
     * @return 用户证件照
     */
    public JzUserLicense selectJzUserLicenseById(Long id);

    /**
     * 查询用户证件照列表
     * 
     * @param jzUserLicense 用户证件照
     * @return 用户证件照集合
     */
    public List<JzUserLicense> selectJzUserLicenseList(JzUserLicense jzUserLicense);

    /**
     * 新增用户证件照
     * 
     * @param jzUserLicense 用户证件照
     * @return 结果
     */
    public int insertJzUserLicense(JzUserLicense jzUserLicense);

    /**
     * 修改用户证件照
     * 
     * @param jzUserLicense 用户证件照
     * @return 结果
     */
    public int updateJzUserLicense(JzUserLicense jzUserLicense);

    /**
     * 批量删除用户证件照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzUserLicenseByIds(String ids);

    /**
     * 删除用户证件照信息
     * 
     * @param id 用户证件照ID
     * @return 结果
     */
    public int deleteJzUserLicenseById(Long id);

    /**
     *  大班长查询所有管理的
     *
     * @param zcxmName
     * @param zylbName
     * @param id 用户证件照ID
     * @param beginReviewTime
     * @param endReviewTime
     * @return 结果
     */
    List<JzUserLicense> selectDbzUserList(String id, String userName, Long zcxmType, Long zylbType, String getAppType, Object beginReviewTime, Object endReviewTime,String reviewState);
}
