package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.JzUserLicenseMapper;
import com.ruoyi.business.domain.JzUserLicense;
import com.ruoyi.business.service.IJzUserLicenseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户证件照Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-10
 */
@Service
public class JzUserLicenseServiceImpl implements IJzUserLicenseService 
{
    @Autowired
    private JzUserLicenseMapper jzUserLicenseMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;
    /**
     * 查询用户证件照
     * 
     * @param id 用户证件照ID
     * @return 用户证件照
     */
    @Override
    public JzUserLicense selectJzUserLicenseById(Long id)
    {
        return jzUserLicenseMapper.selectJzUserLicenseById(id);
    }

    /**
     * 查询用户证件照列表
     * 
     * @param jzUserLicense 用户证件照
     * @return 用户证件照
     */
    @Override
    public List<JzUserLicense> selectJzUserLicenseList(JzUserLicense jzUserLicense)
    {
        List<JzUserLicense> list = jzUserLicenseMapper.selectJzUserLicenseList(jzUserLicense);
        if(list !=null){
            for (JzUserLicense license : list) {
                SysDept dept = sysDeptMapper.selectById(license.getHomeworkTypeId());
                if(dept !=null){
                    license.setZcxmName(dept.getDeptName());
                }
                SysDept dept1 = sysDeptMapper.selectById(license.getMustHoldProjectTypeId());
                if(dept1 !=null){
                    license.setZylbName(dept1.getDeptName());
                }
            }
        }
        return list;
    }

    /**
     * 新增用户证件照
     * 
     * @param jzUserLicense 用户证件照
     * @return 结果
     */
    @Override
    public int insertJzUserLicense(JzUserLicense jzUserLicense)
    {
        jzUserLicense.setCreateTime(DateUtils.getNowDate());
        return jzUserLicenseMapper.insertJzUserLicense(jzUserLicense);
    }

    /**
     * 修改用户证件照
     * 
     * @param jzUserLicense 用户证件照
     * @return 结果
     */
    @Override
    public int updateJzUserLicense(JzUserLicense jzUserLicense)
    {
        jzUserLicense.setUpdateTime(DateUtils.getNowDate());
        return jzUserLicenseMapper.updateJzUserLicense(jzUserLicense);
    }

    /**
     * 删除用户证件照对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzUserLicenseByIds(String ids)
    {
        return jzUserLicenseMapper.deleteJzUserLicenseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户证件照信息
     * 
     * @param id 用户证件照ID
     * @return 结果
     */
    @Override
    public int deleteJzUserLicenseById(Long id)
    {
        return jzUserLicenseMapper.deleteJzUserLicenseById(id);
    }

    /**
     *  二级权限查询所有证照
     *
     */
    @Override
    public List<JzUserLicense> selectDbzUserList(String id, String userName, Long zcxmType, Long zylbType, String AppType, Object beginReviewTime, Object endReviewTime,String reviewState) {
        List<JzUserLicense> list = jzUserLicenseMapper.selectDbzUserList(Convert.toStrArray(id),userName,zcxmType,zylbType,AppType,beginReviewTime,endReviewTime,reviewState);

        if(list !=null){
            for (JzUserLicense license : list) {
                SysDept dept = sysDeptMapper.selectById(license.getHomeworkTypeId());
                if(dept !=null){
                    license.setZcxmName(dept.getDeptName());
                }
                SysDept dept1 = sysDeptMapper.selectById(license.getMustHoldProjectTypeId());
                if(dept1 !=null){
                    license.setZylbName(dept1.getDeptName());
                }
            }
        }
        return list;
    }
}
