package com.ruoyi.sysusersystem.service;

import com.ruoyi.sysusersystem.domain.JzShiguyinhuandj;
import java.util.List;

/**
 * 事故隐患排查整改记录Service接口
 * 
 * @author sunli
 * @date 2020-01-19
 */
public interface IJzShiguyinhuandjService 
{
    /**
     * 查询事故隐患排查整改记录
     * 
     * @param id 事故隐患排查整改记录ID
     * @return 事故隐患排查整改记录
     */
    public JzShiguyinhuandj selectJzShiguyinhuandjById(Long id);

    /**
     * 查询事故隐患排查整改记录列表
     * 
     * @param jzShiguyinhuandj 事故隐患排查整改记录
     * @return 事故隐患排查整改记录集合
     */
    public List<JzShiguyinhuandj> selectJzShiguyinhuandjList(JzShiguyinhuandj jzShiguyinhuandj);

    /**
     * 新增事故隐患排查整改记录
     * 
     * @param jzShiguyinhuandj 事故隐患排查整改记录
     * @return 结果
     */
    public int insertJzShiguyinhuandj(JzShiguyinhuandj jzShiguyinhuandj);

    /**
     * 修改事故隐患排查整改记录
     * 
     * @param jzShiguyinhuandj 事故隐患排查整改记录
     * @return 结果
     */
    public int updateJzShiguyinhuandj(JzShiguyinhuandj jzShiguyinhuandj);

    /**
     * 批量删除事故隐患排查整改记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzShiguyinhuandjByIds(String ids);

    /**
     * 删除事故隐患排查整改记录信息
     * 
     * @param id 事故隐患排查整改记录ID
     * @return 结果
     */
    public int deleteJzShiguyinhuandjById(Long id);
}
