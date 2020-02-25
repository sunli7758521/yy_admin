package com.ruoyi.sysusersystem.service;

import com.ruoyi.sysusersystem.domain.JzSecurityTeam;
import java.util.List;

/**
 * 安全小组Service接口
 * 
 * @author sunli
 * @date 2020-02-24
 */
public interface IJzSecurityTeamService 
{
    /**
     * 查询安全小组
     * 
     * @param id 安全小组ID
     * @return 安全小组
     */
    public JzSecurityTeam selectJzSecurityTeamById(Long id);

    /**
     * 查询安全小组列表
     * 
     * @param jzSecurityTeam 安全小组
     * @return 安全小组集合
     */
    public List<JzSecurityTeam> selectJzSecurityTeamList(JzSecurityTeam jzSecurityTeam);

    /**
     * 新增安全小组
     * 
     * @param jzSecurityTeam 安全小组
     * @return 结果
     */
    public int insertJzSecurityTeam(JzSecurityTeam jzSecurityTeam);

    /**
     * 修改安全小组
     * 
     * @param jzSecurityTeam 安全小组
     * @return 结果
     */
    public int updateJzSecurityTeam(JzSecurityTeam jzSecurityTeam);

    /**
     * 批量删除安全小组
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzSecurityTeamByIds(String ids);

    /**
     * 删除安全小组信息
     * 
     * @param id 安全小组ID
     * @return 结果
     */
    public int deleteJzSecurityTeamById(String id);
}
