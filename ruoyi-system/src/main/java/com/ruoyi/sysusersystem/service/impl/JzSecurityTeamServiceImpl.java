package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzSecurityTeamMapper;
import com.ruoyi.sysusersystem.domain.JzSecurityTeam;
import com.ruoyi.sysusersystem.service.IJzSecurityTeamService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 安全小组Service业务层处理
 * 
 * @author sunli
 * @date 2020-02-24
 */
@Service
public class JzSecurityTeamServiceImpl implements IJzSecurityTeamService 
{
    @Autowired
    private JzSecurityTeamMapper jzSecurityTeamMapper;
    /**
     * 查询安全小组
     * 
     * @param id 安全小组ID
     * @return 安全小组
     */
    @Override
    public JzSecurityTeam selectJzSecurityTeamById(Long id)
    {
        return jzSecurityTeamMapper.selectJzSecurityTeamById(id);
    }

    /**
     * 查询安全小组列表
     * 
     * @param jzSecurityTeam 安全小组
     * @return 安全小组
     */
    @Override
    public List<JzSecurityTeam> selectJzSecurityTeamList(JzSecurityTeam jzSecurityTeam)
    {
        return jzSecurityTeamMapper.selectJzSecurityTeamList(jzSecurityTeam);
    }

    /**
     * 新增安全小组
     * 
     * @param jzSecurityTeam 安全小组
     * @return 结果
     */
    @Override
    public int insertJzSecurityTeam(JzSecurityTeam jzSecurityTeam)
    {
        jzSecurityTeam.setCreateTime(DateUtils.getNowDate());
        return jzSecurityTeamMapper.insertJzSecurityTeam(jzSecurityTeam);
    }

    /**
     * 修改安全小组
     * 
     * @param jzSecurityTeam 安全小组
     * @return 结果
     */
    @Override
    public int updateJzSecurityTeam(JzSecurityTeam jzSecurityTeam)
    {
        jzSecurityTeam.setUpdateTime(DateUtils.getNowDate());
        return jzSecurityTeamMapper.updateJzSecurityTeam(jzSecurityTeam);
    }

    /**
     * 删除安全小组对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzSecurityTeamByIds(String ids)
    {
        return jzSecurityTeamMapper.deleteJzSecurityTeamByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除安全小组信息
     * 
     * @param id 安全小组ID
     * @return 结果
     */
    @Override
    public int deleteJzSecurityTeamById(String id)
    {
        return jzSecurityTeamMapper.deleteJzSecurityTeamById(id);
    }
}
