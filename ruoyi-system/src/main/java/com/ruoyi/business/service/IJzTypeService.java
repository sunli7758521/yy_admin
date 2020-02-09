package com.ruoyi.business.service;

import com.ruoyi.business.domain.JzType;
import java.util.List;

/**
 * 风险分类Service接口
 * 
 * @author ruoyi
 * @date 2019-12-25
 */
public interface IJzTypeService 
{
    /**
     * 查询风险分类
     * 
     * @param id 风险分类ID
     * @return 风险分类
     */
    public JzType selectJzTypeById(Long id);

    /**
     * 查询风险分类列表
     * 
     * @param jzType 风险分类
     * @return 风险分类集合
     */
    public List<JzType> selectJzTypeList(JzType jzType);

    /**
     * 新增风险分类
     * 
     * @param jzType 风险分类
     * @return 结果
     */
    public int insertJzType(JzType jzType);

    /**
     * 修改风险分类
     * 
     * @param jzType 风险分类
     * @return 结果
     */
    public int updateJzType(JzType jzType);

    /**
     * 批量删除风险分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzTypeByIds(String ids);

    /**
     * 删除风险分类信息
     * 
     * @param id 风险分类ID
     * @return 结果
     */
    public int deleteJzTypeById(Long id);

    /**
     * 获取9系统系统名称
     * @return
     */
    public List<JzType> jzTypeSubList();

    /**
     * 要删
     * @param dictType
     * @return
     */
    public List<JzType> selectJzTypeByType(String dictType);

    /**
     * 根据ID查询所有数据
     * @param ID
     * @return
     */
    public JzType selectJzTypeByParentId(Long ID);

    /**
     *
     * @param stateid
     * @return
     */
    public List<JzType> listType(int stateid);
    /**
     * 获取应急物资分类列表
     * @param
     * @return
     */
    public List<JzType> wzList();

    /**
     * 获取应急物资大分类表表
     * @return
     */
    public List<JzType> bswzList(int type);

    /**
     * 获取应急物资小分类表表
     * @return
     */
    public List<JzType> smallTypeList(int type);
}
