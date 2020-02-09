package com.ruoyi.user.mapper;

import com.ruoyi.user.domain.JzUserType;

import java.util.List;

/**
 * 人员类型Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
public interface JzUserTypeMapper 
{
    /**
     * 查询人员类型
     * 
     * @param id 人员类型ID
     * @return 人员类型
     */
    public JzUserType selectJzUserTypeById(Long id);

    /**
     * 查询人员类型列表
     * 
     * @param jzUserType 人员类型
     * @return 人员类型集合
     */
    public List<JzUserType> selectJzUserTypeList(JzUserType jzUserType);
    /**
     * 员工类型下拉列表
     */
    public List<JzUserType> utList();

    /**
     * 新增人员类型
     * 
     * @param jzUserType 人员类型
     * @return 结果
     */
    public int insertJzUserType(JzUserType jzUserType);

    /**
     * 修改人员类型
     * 
     * @param jzUserType 人员类型
     * @return 结果
     */
    public int updateJzUserType(JzUserType jzUserType);

    /**
     * 删除人员类型
     * 
     * @param id 人员类型ID
     * @return 结果
     */
    public int deleteJzUserTypeById(Long id);

    /**
     * 批量删除人员类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzUserTypeByIds(String[] ids);
}
