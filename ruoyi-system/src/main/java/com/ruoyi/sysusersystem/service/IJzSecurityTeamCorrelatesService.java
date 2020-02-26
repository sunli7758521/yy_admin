package com.ruoyi.sysusersystem.service;

import com.ruoyi.sysusersystem.domain.JzSecurityTeamCorrelates;
import java.util.List;

/**
 * 安全小组关联系统用户Service接口
 * 
 * @author sunli
 * @date 2020-02-26
 */
public interface IJzSecurityTeamCorrelatesService 
{
    /**
     * 查询安全小组关联系统用户
     * 
     * @param id 安全小组关联系统用户ID
     * @return 安全小组关联系统用户
     */
    public JzSecurityTeamCorrelates selectJzSecurityTeamCorrelatesById(Long id);

    /**
     * 查询安全小组关联系统用户列表
     * 
     * @param jzSecurityTeamCorrelates 安全小组关联系统用户
     * @return 安全小组关联系统用户集合
     */
    public List<JzSecurityTeamCorrelates> selectJzSecurityTeamCorrelatesList(JzSecurityTeamCorrelates jzSecurityTeamCorrelates);

    /**
     * 新增安全小组关联系统用户
     * 
     * @param jzSecurityTeamCorrelates 安全小组关联系统用户
     * @return 结果
     */
    public int insertJzSecurityTeamCorrelates(JzSecurityTeamCorrelates jzSecurityTeamCorrelates);

    /**
     * 修改安全小组关联系统用户
     * 
     * @param jzSecurityTeamCorrelates 安全小组关联系统用户
     * @return 结果
     */
    public int updateJzSecurityTeamCorrelates(JzSecurityTeamCorrelates jzSecurityTeamCorrelates);

    /**
     * 批量删除安全小组关联系统用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzSecurityTeamCorrelatesByIds(String ids);

    /**
     * 删除安全小组关联系统用户信息
     * 
     * @param id 安全小组关联系统用户ID
     * @return 结果
     */
    public int deleteJzSecurityTeamCorrelatesById(Long id);
}
