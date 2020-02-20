package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzRiskMapper;
import com.ruoyi.sysusersystem.domain.JzRisk;
import com.ruoyi.sysusersystem.service.IJzRiskService;
import com.ruoyi.common.core.text.Convert;

/**
 * 风险Service业务层处理
 * 
 * @author sunli
 * @date 2019-12-27
 */
@Service
public class JzRiskServiceImpl implements IJzRiskService 
{
    @Autowired
    private JzRiskMapper jzRiskMapper;

    /**
     * 查询风险
     * 
     * @param riskId 风险ID
     * @return 风险
     */
    @Override
    public JzRisk selectJzRiskById(Long riskId)
    {
        return jzRiskMapper.selectJzRiskById(riskId);
    }

    /**
     * 查询风险列表
     * 
     * @param jzRisk 风险
     * @return 风险
     */
    @Override
    public List<JzRisk> selectJzRiskList(JzRisk jzRisk)
    {
        return jzRiskMapper.selectJzRiskList(jzRisk);
    }

    /**
     * 新增风险
     * 
     * @param jzRisk 风险
     * @return 结果
     */
    @Override
    public int insertJzRisk(JzRisk jzRisk)
    {
        jzRisk.setCreateTime(DateUtils.getNowDate());
        return jzRiskMapper.insertJzRisk(jzRisk);
    }

    /**
     * 修改风险
     * 
     * @param jzRisk 风险
     * @return 结果
     */
    @Override
    public int updateJzRisk(JzRisk jzRisk)
    {
        jzRisk.setUpdateTime(DateUtils.getNowDate());
        return jzRiskMapper.updateJzRisk(jzRisk);
    }

    /**
     * 删除风险对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzRiskByIds(String ids)
    {
        return jzRiskMapper.deleteJzRiskByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除风险信息
     * 
     * @param riskId 风险ID
     * @return 结果
     */
    @Override
    public int deleteJzRiskById(Long riskId)
    {
        return jzRiskMapper.deleteJzRiskById(riskId);
    }

    /**
     * 根据Id获取文件地址
     *
     * @param riskId
     * @return
     */
    @Override
    public String selectFileUrlByRiskId(Long riskId) {
        return jzRiskMapper.selectFileUrlByRiskId(riskId);
    }

    /**
     * 根据Id获取评估报告地址
     * @param riskId
     * @return
     */
    @Override
    public String selectByRiskId(Long riskId) {
        return jzRiskMapper.selectByRiskId(riskId);
    }
}
