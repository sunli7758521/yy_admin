package com.ruoyi.systemmanagement;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.systemmanagement.domain.JzSystemManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 制度管理Service接口
 * 
 * @author ruoyi
 * @date 2019-12-14
 */
public interface IJzSystemManagementService {
    /**
     * 根据managementId返回fileurl
     *
     * @param managementId 主键
     * @return fileurl
     */
    public String selectFileUrlByManagementByID(Long managementId);

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
     * 批量删除制度管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzSystemManagementByIds(String ids);

    /**
     * 删除制度管理信息
     *
     * @param managementId 制度管理ID
     * @return 结果
     */
    public int deleteJzSystemManagementById(Long managementId);

    /**
     * 大班长查询
     * @param id
     * @param teamId
     * @param state
     * @param managementId
     * @return
     */
    public List<JzSystemManagement> selectDbzList(String id, Long teamId, String state, Long managementId);
}
