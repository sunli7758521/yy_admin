package com.ruoyi.systemmanagement.mapper;

import com.ruoyi.systemmanagement.domain.JzSystemManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 制度管理Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-14
 */
public interface JzSystemManagementMapper 
{
    /**
     * 查询文件路径是否存在
     * @param msg 文件路径
     * @return
     */
    public Long selectJzSystemManagementFileUrl(@Param(value = "msg") String msg);
    /**
     * 查询制度管理
     * 
     * @param managementId 制度管理ID
     * @return 制度管理
     */
    public JzSystemManagement selectJzSystemManagementById(Long managementId);

    /**
     * 查询制度管理列表
     * 
     * @param jzSystemManagement 制度管理
     * @return 制度管理集合
     */
    public List<JzSystemManagement> selectJzSystemManagementList(JzSystemManagement jzSystemManagement);

    /**
     * 新增制度管理
     * 
     * @param jzSystemManagement 制度管理
     * @return 结果
     */
    public int insertJzSystemManagement(JzSystemManagement jzSystemManagement);

    /**
     * 修改制度管理
     * 
     * @param jzSystemManagement 制度管理
     * @return 结果
     */
    public int updateJzSystemManagement(JzSystemManagement jzSystemManagement);

    /**
     * 删除制度管理
     * 
     * @param managementId 制度管理ID
     * @return 结果
     */
    public int deleteJzSystemManagementById(Long managementId);

    /**
     * 批量删除制度管理
     * 
     * @param managementIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzSystemManagementByIds(String[] managementIds);

    /**
     * 根据managementId查询fileurl
     * @param managementId 主键
     * @return fileurl
     */
    public String selectFileUrlManagementById(Long managementId);

    /**
     * 大班长查询
     * @param toStrArray
     * @param teamId
     * @param state
     * @param managementId
     * @return
     */
    public List<JzSystemManagement> selectDbzList(@Param("array") String[] systemIds,
                                                  @Param("typeId") Long teamId,
                                                  @Param("state") String state,
                                                  @Param("managementId") Long managementId);

}
