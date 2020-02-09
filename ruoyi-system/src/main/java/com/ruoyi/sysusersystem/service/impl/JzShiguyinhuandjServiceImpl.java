package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzShiguyinhuandjMapper;
import com.ruoyi.sysusersystem.domain.JzShiguyinhuandj;
import com.ruoyi.sysusersystem.service.IJzShiguyinhuandjService;
import com.ruoyi.common.core.text.Convert;

/**
 * 事故隐患排查整改记录Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-19
 */
@Service
public class JzShiguyinhuandjServiceImpl implements IJzShiguyinhuandjService 
{
    @Autowired
    private JzShiguyinhuandjMapper jzShiguyinhuandjMapper;

    /**
     * 查询事故隐患排查整改记录
     * 
     * @param id 事故隐患排查整改记录ID
     * @return 事故隐患排查整改记录
     */
    @Override
    public JzShiguyinhuandj selectJzShiguyinhuandjById(Long id)
    {
        return jzShiguyinhuandjMapper.selectJzShiguyinhuandjById(id);
    }

    /**
     * 查询事故隐患排查整改记录列表
     * 
     * @param jzShiguyinhuandj 事故隐患排查整改记录
     * @return 事故隐患排查整改记录
     */
    @Override
    public List<JzShiguyinhuandj> selectJzShiguyinhuandjList(JzShiguyinhuandj jzShiguyinhuandj)
    {
        return jzShiguyinhuandjMapper.selectJzShiguyinhuandjList(jzShiguyinhuandj);
    }

    /**
     * 新增事故隐患排查整改记录
     * 
     * @param jzShiguyinhuandj 事故隐患排查整改记录
     * @return 结果
     */
    @Override
    public int insertJzShiguyinhuandj(JzShiguyinhuandj jzShiguyinhuandj)
    {
        jzShiguyinhuandj.setCreateTime(DateUtils.getNowDate());
        return jzShiguyinhuandjMapper.insertJzShiguyinhuandj(jzShiguyinhuandj);
    }

    /**
     * 修改事故隐患排查整改记录
     * 
     * @param jzShiguyinhuandj 事故隐患排查整改记录
     * @return 结果
     */
    @Override
    public int updateJzShiguyinhuandj(JzShiguyinhuandj jzShiguyinhuandj)
    {
        jzShiguyinhuandj.setUpdateTime(DateUtils.getNowDate());
        return jzShiguyinhuandjMapper.updateJzShiguyinhuandj(jzShiguyinhuandj);
    }

    /**
     * 删除事故隐患排查整改记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzShiguyinhuandjByIds(String ids)
    {
        return jzShiguyinhuandjMapper.deleteJzShiguyinhuandjByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除事故隐患排查整改记录信息
     * 
     * @param id 事故隐患排查整改记录ID
     * @return 结果
     */
    @Override
    public int deleteJzShiguyinhuandjById(Long id)
    {
        return jzShiguyinhuandjMapper.deleteJzShiguyinhuandjById(id);
    }
}
