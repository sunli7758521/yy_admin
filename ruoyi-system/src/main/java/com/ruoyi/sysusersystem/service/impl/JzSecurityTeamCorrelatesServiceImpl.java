package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzSecurityTeamCorrelatesMapper;
import com.ruoyi.sysusersystem.domain.JzSecurityTeamCorrelates;
import com.ruoyi.sysusersystem.service.IJzSecurityTeamCorrelatesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 安全小组关联系统用户Service业务层处理
 * 
 * @author sunli
 * @date 2020-02-26
 */
@Service
public class JzSecurityTeamCorrelatesServiceImpl implements IJzSecurityTeamCorrelatesService 
{
    @Autowired
    private JzSecurityTeamCorrelatesMapper jzSecurityTeamCorrelatesMapper;

    /**
     * 查询安全小组关联系统用户
     * 
     * @param id 安全小组关联系统用户ID
     * @return 安全小组关联系统用户
     */
    @Override
    public JzSecurityTeamCorrelates selectJzSecurityTeamCorrelatesById(Long id)
    {
        return jzSecurityTeamCorrelatesMapper.selectJzSecurityTeamCorrelatesById(id);
    }

    /**
     * 查询安全小组关联系统用户列表
     * 
     * @param jzSecurityTeamCorrelates 安全小组关联系统用户
     * @return 安全小组关联系统用户
     */
    @Override
    public List<JzSecurityTeamCorrelates> selectJzSecurityTeamCorrelatesList(JzSecurityTeamCorrelates jzSecurityTeamCorrelates)
    {
        return jzSecurityTeamCorrelatesMapper.selectJzSecurityTeamCorrelatesList(jzSecurityTeamCorrelates);
    }

    /**
     * 新增安全小组关联系统用户
     * 
     * @param jzSecurityTeamCorrelates 安全小组关联系统用户
     * @return 结果
     */
    @Override
    public int insertJzSecurityTeamCorrelates(JzSecurityTeamCorrelates jzSecurityTeamCorrelates)
    {
        return jzSecurityTeamCorrelatesMapper.insertJzSecurityTeamCorrelates(jzSecurityTeamCorrelates);
    }

    /**
     * 修改安全小组关联系统用户
     * 
     * @param jzSecurityTeamCorrelates 安全小组关联系统用户
     * @return 结果
     */
    @Override
    public int updateJzSecurityTeamCorrelates(JzSecurityTeamCorrelates jzSecurityTeamCorrelates)
    {
        return jzSecurityTeamCorrelatesMapper.updateJzSecurityTeamCorrelates(jzSecurityTeamCorrelates);
    }

    /**
     * 删除安全小组关联系统用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzSecurityTeamCorrelatesByIds(String ids)
    {
        return jzSecurityTeamCorrelatesMapper.deleteJzSecurityTeamCorrelatesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除安全小组关联系统用户信息
     * 
     * @param id 安全小组关联系统用户ID
     * @return 结果
     */
    @Override
    public int deleteJzSecurityTeamCorrelatesById(Long id)
    {
        return jzSecurityTeamCorrelatesMapper.deleteJzSecurityTeamCorrelatesById(id);
    }
}
