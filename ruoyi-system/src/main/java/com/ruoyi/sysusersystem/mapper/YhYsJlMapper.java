package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.YhYsJl;
import java.util.List;

/**
 * 隐患验收记录Mapper接口
 * 
 * @author sunli
 * @date 2020-02-24
 */
public interface YhYsJlMapper 
{
    /**
     * 查询隐患验收记录
     * 
     * @param yId 隐患验收记录ID
     * @return 隐患验收记录
     */
    public YhYsJl selectYhYsJlById(Long yId);

    /**
     * 查询隐患验收记录列表
     * 
     * @param yhYsJl 隐患验收记录
     * @return 隐患验收记录集合
     */
    public List<YhYsJl> selectYhYsJlList(YhYsJl yhYsJl);

    /**
     * 新增隐患验收记录
     * 
     * @param yhYsJl 隐患验收记录
     * @return 结果
     */
    public int insertYhYsJl(YhYsJl yhYsJl);

    /**
     * 修改隐患验收记录
     * 
     * @param yhYsJl 隐患验收记录
     * @return 结果
     */
    public int updateYhYsJl(YhYsJl yhYsJl);

    /**
     * 删除隐患验收记录
     * 
     * @param yId 隐患验收记录ID
     * @return 结果
     */
    public int deleteYhYsJlById(Long yId);

    /**
     * 批量删除隐患验收记录
     * 
     * @param yIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteYhYsJlByIds(String[] yIds);
}
