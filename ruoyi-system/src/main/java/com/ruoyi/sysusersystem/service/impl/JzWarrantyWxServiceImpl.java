package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzWarrantyWxMapper;
import com.ruoyi.sysusersystem.domain.JzWarrantyWx;
import com.ruoyi.sysusersystem.service.IJzWarrantyWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 维修记录Service业务层处理
 * 
 * @author sunli
 * @date 2020-02-19
 */
@Service
public class JzWarrantyWxServiceImpl implements IJzWarrantyWxService 
{
    @Autowired
    private JzWarrantyWxMapper jzWarrantyWxMapper;

    /**
     * 查询维修记录
     * 
     * @param wxId 维修记录ID
     * @return 维修记录
     */
    @Override
    public JzWarrantyWx selectJzWarrantyWxById(Long wxId)
    {
        return jzWarrantyWxMapper.selectJzWarrantyWxById(wxId);
    }

    /**
     * 查询维修记录列表
     * 
     * @param jzWarrantyWx 维修记录
     * @return 维修记录
     */
    @Override
    public List<JzWarrantyWx> selectJzWarrantyWxList(JzWarrantyWx jzWarrantyWx)
    {
        return jzWarrantyWxMapper.selectJzWarrantyWxList(jzWarrantyWx);
    }

    /**
     * 新增维修记录
     * 
     * @param jzWarrantyWx 维修记录
     * @return 结果
     */
    @Override
    public int insertJzWarrantyWx(JzWarrantyWx jzWarrantyWx)
    {
        return jzWarrantyWxMapper.insertJzWarrantyWx(jzWarrantyWx);
    }

    /**
     * 修改维修记录
     * 
     * @param jzWarrantyWx 维修记录
     * @return 结果
     */
    @Override
    public int updateJzWarrantyWx(JzWarrantyWx jzWarrantyWx)
    {
        jzWarrantyWx.setUpdateTime(DateUtils.getNowDate());
        return jzWarrantyWxMapper.updateJzWarrantyWx(jzWarrantyWx);
    }

    /**
     * 删除维修记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzWarrantyWxByIds(String ids)
    {
        return jzWarrantyWxMapper.deleteJzWarrantyWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除维修记录信息
     * 
     * @param wxId 维修记录ID
     * @return 结果
     */
    @Override
    public int deleteJzWarrantyWxById(Long wxId)
    {
        return jzWarrantyWxMapper.deleteJzWarrantyWxById(wxId);
    }
}
