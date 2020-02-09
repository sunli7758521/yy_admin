package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.JzHiddenTrouble;
import com.ruoyi.sysusersystem.domain.JzHiddenTroubleVO;

import java.util.List;

/**
 * 隐患Mapper接口
 * 
 * @author sunli
 * @date 2020-01-06
 */
public interface JzHiddenTroubleMapper 
{
    /**
     * 查询隐患
     * 
     * @param hiddenTroubleId 隐患ID
     * @return 隐患
     */
    public JzHiddenTrouble selectJzHiddenTroubleById(Long hiddenTroubleId);

    /**
     * 查询隐患列表
     * 
     * @param jzHiddenTrouble 隐患
     * @return 隐患集合
     */
    public List<JzHiddenTrouble> selectJzHiddenTroubleList(JzHiddenTrouble jzHiddenTrouble);

    /**
     * 新增隐患
     * 
     * @param jzHiddenTrouble 隐患
     * @return 结果
     */
    public int insertJzHiddenTrouble(JzHiddenTrouble jzHiddenTrouble);

    /**
     * 修改隐患
     * 
     * @param jzHiddenTrouble 隐患
     * @return 结果
     */
    public int updateJzHiddenTrouble(JzHiddenTrouble jzHiddenTrouble);

    /**
     * 删除隐患
     * 
     * @param hiddenTroubleId 隐患ID
     * @return 结果
     */
    public int deleteJzHiddenTroubleById(Long hiddenTroubleId);

    /**
     * 批量删除隐患
     * 
     * @param hiddenTroubleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzHiddenTroubleByIds(String[] hiddenTroubleIds);

    /**
     * 从计划批量删除隐患
     *
     * @param planIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzHiddenTroublePByIds(String[] planIds);

    /**
     * 预览隐患项
     *
     * @param
     * @return 结果
     */
    List<JzHiddenTroubleVO> selectHiddenTroubleList(JzHiddenTrouble log);
}
