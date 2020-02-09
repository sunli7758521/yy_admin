package com.ruoyi.systemmanagement.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.systemmanagement.IJzSystemManagementService;
import com.ruoyi.systemmanagement.domain.JzSystemManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.systemmanagement.mapper.JzSystemManagementMapper;
import com.ruoyi.common.core.text.Convert;

/**
 * 制度管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-14
 */
@Service
public class JzSystemManagementServiceImpl implements IJzSystemManagementService
{
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private JzSystemManagementMapper jzSystemManagementMapper;

    /**
     * 根据managementId返回fileurl
     *
     * @param managementId 主键
     * @return fileurl
     */
    @Override
    public String selectFileUrlByManagementByID(Long managementId) {
        return jzSystemManagementMapper.selectFileUrlManagementById(managementId);
    }

    /**
     * 查询制度管理
     * 
     * @param managementId 制度管理ID
     * @return 制度管理
     */
    @Override
    public JzSystemManagement selectJzSystemManagementById(Long managementId)
    {
        return jzSystemManagementMapper.selectJzSystemManagementById(managementId);
    }
    /**
     * 查询制度管理列表
     * 
     * @param jzSystemManagement 制度管理
     * @return 制度管理
     */
    @Override
    public List<JzSystemManagement> selectJzSystemManagementList(JzSystemManagement jzSystemManagement)
    {
        return jzSystemManagementMapper.selectJzSystemManagementList(jzSystemManagement);
    }

    /**
     * 新增制度管理
     * 
     * @param jzSystemManagement 制度管理
     * @return 结果
     */
    @Override
    public int insertJzSystemManagement(JzSystemManagement jzSystemManagement)
    {

        jzSystemManagement.setCreateTime(DateUtils.getNowDate());
        return jzSystemManagementMapper.insertJzSystemManagement(jzSystemManagement);
    }

    /**
     * 修改制度管理
     * 
     * @param jzSystemManagement 制度管理
     * @return 结果
     */
    @Override
    public int updateJzSystemManagement(JzSystemManagement jzSystemManagement)
    {
        jzSystemManagement.setUpdateTime(DateUtils.getNowDate());
        return jzSystemManagementMapper.updateJzSystemManagement(jzSystemManagement);
    }

    /**
     * 删除制度管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzSystemManagementByIds(String ids)
    {
        return jzSystemManagementMapper.deleteJzSystemManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除制度管理信息
     * 
     * @param managementId 制度管理ID
     * @return 结果
     */
    @Override
    public int deleteJzSystemManagementById(Long managementId)
    {
        return jzSystemManagementMapper.deleteJzSystemManagementById(managementId);
    }

    /**
     * 大班长查询
     *
     * @param id
     * @param teamId
     * @param state
     * @param managementId
     * @return
     */
    @Override
    public List<JzSystemManagement> selectDbzList(String id, Long teamId, String state, Long managementId) {
        return jzSystemManagementMapper.selectDbzList(Convert.toStrArray(id),teamId,state,managementId);
    }
}
