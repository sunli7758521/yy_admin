package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.YhZg;
import com.ruoyi.sysusersystem.domain.YhZgYsVo;

import java.util.List;

/**
 * 隐患整改Mapper接口
 * 
 * @author sunli
 * @date 2020-02-22
 */
public interface YhZgMapper 
{
    /**
     * 查询隐患整改
     * 
     * @param id 隐患整改ID
     * @return 隐患整改
     */
    public YhZg selectYhZgById(Long id);

    /**
     * 查询隐患整改列表
     * 
     * @param yhZg 隐患整改
     * @return 隐患整改集合
     */
    public List<YhZg> selectYhZgList(YhZg yhZg);

    /**
     * 新增隐患整改
     * 
     * @param yhZg 隐患整改
     * @return 结果
     */
    public int insertYhZg(YhZg yhZg);

    /**
     * 修改隐患整改
     * 
     * @param yhZg 隐患整改
     * @return 结果
     */
    public int updateYhZg(YhZg yhZg);

    /**
     * 删除隐患整改
     * 
     * @param id 隐患整改ID
     * @return 结果
     */
    public int deleteYhZgById(Long id);

    /**
     * 批量删除隐患整改
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYhZgByIds(String[] ids);

    /**
     * 查询隐患整改验收
     *
     * @param yhZg 隐患整改验收
     * @return 结果
     */
    List<YhZgYsVo> selectYhZgYsList(YhZgYsVo yhZg);

    /**
     * 通过隐患整改id 查询整改表里的隐患id
     *
     * @param yhZgId
     * @return 结果
     */
    YhZg selectByYhZgId(Long id);
}
