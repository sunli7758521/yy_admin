package com.ruoyi.user.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.user.domain.JzUserType;
import com.ruoyi.user.mapper.JzUserTypeMapper;
import com.ruoyi.user.service.IJzUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人员类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-09
 */
@Service
public class JzUserTypeServiceImpl implements IJzUserTypeService 
{
    @Autowired
    private JzUserTypeMapper jzUserTypeMapper;

    /**
     * 查询人员类型
     * 
     * @param id 人员类型ID
     * @return 人员类型
     */
    @Override
    public JzUserType selectJzUserTypeById(Long id)
    {
        return jzUserTypeMapper.selectJzUserTypeById(id);
    }

    /**
     * 查询人员类型列表
     * 
     * @param jzUserType 人员类型
     * @return 人员类型
     */
    @Override
    public List<JzUserType> selectJzUserTypeList(JzUserType jzUserType)
    {
        return jzUserTypeMapper.selectJzUserTypeList(jzUserType);
    }

    /**
     * 新增人员类型
     * 
     * @param jzUserType 人员类型
     * @return 结果
     */
    @Override
    public int insertJzUserType(JzUserType jzUserType)
    {
        jzUserType.setCreateTime(DateUtils.getNowDate());
        return jzUserTypeMapper.insertJzUserType(jzUserType);
    }

    /**
     * 修改人员类型
     * 
     * @param jzUserType 人员类型
     * @return 结果
     */
    @Override
    public int updateJzUserType(JzUserType jzUserType)
    {
        jzUserType.setUpdateTime(DateUtils.getNowDate());
        return jzUserTypeMapper.updateJzUserType(jzUserType);
    }

    /**
     * 删除人员类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzUserTypeByIds(String ids)
    {
        return jzUserTypeMapper.deleteJzUserTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员类型信息
     * 
     * @param id 人员类型ID
     * @return 结果
     */
    @Override
    public int deleteJzUserTypeById(Long id)
    {
        return jzUserTypeMapper.deleteJzUserTypeById(id);
    }

    /**
     * 员工类型下拉列表
     */
    @Override
    public List<JzUserType> utList() {
        return jzUserTypeMapper.utList();
    }
}
