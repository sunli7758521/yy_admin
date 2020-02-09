package com.ruoyi.business.mapper;

import com.ruoyi.business.domain.JzType;
import java.util.List;

/**
 * 风险分类Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-25
 */
public interface JzTypeMapper 
{
    public JzType selectJzTypeByParentId(Long id);

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
     * 删除风险分类
     * 
     * @param id 风险分类ID
     * @return 结果
     */
    public int deleteJzTypeById(Long id);

    /**
     * 批量删除风险分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzTypeByIds(String[] ids);

    /**
     * 查询9系统名称
     * @return
     */
    public List<JzType> selectSystemName();

    /**
     * 要删
     * @param dictType
     * @return
     */
    public List<JzType> selectJzTypeByType(String dictType);

    /**
     * 根据stateid 查询风险 应急物资 隐患分类
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
     * 获取应急物资大分类列表
     * @return
     */
    public List<JzType> bswzList(int type);

    /**
     * 获取应急物资大分类列表
     * @param type
     * @return
     */
    List<JzType> smallTypeList(int type);
}
