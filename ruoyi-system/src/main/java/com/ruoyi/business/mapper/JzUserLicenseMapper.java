package com.ruoyi.business.mapper;

import com.ruoyi.business.domain.JzUserLicense;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户证件照Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-10
 */
public interface JzUserLicenseMapper
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
     * 删除用户证件照
     * 
     * @param id 用户证件照ID
     * @return 结果
     */
    public int deleteJzUserLicenseById(Long id);

    /**
     * 批量删除用户证件照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzUserLicenseByIds(String[] ids);

    /**
     *  二级权限查询所有证照
     *
     */
    List<JzUserLicense> selectDbzUserList(@Param("array") String[] systemIds,
                                          @Param("userName") String userName,
                                          @Param("homeworkTypeId") Long homeworkTypeId,
                                          @Param("mustHoldProjectTypeId") Long mustHoldProjectTypeId,
                                          @Param("appType") String appType,
                                          @Param("beginReviewTime")Object beginReviewTime,
                                          @Param("endReviewTime")Object endReviewTime,
                                          @Param("reviewState") String reviewState);
}
