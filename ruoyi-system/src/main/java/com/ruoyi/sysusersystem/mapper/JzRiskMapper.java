package com.ruoyi.sysusersystem.mapper;

import com.ruoyi.sysusersystem.domain.JzRisk;
import java.util.List;

/**
 * 风险Mapper接口
 * 
 * @author sunli
 * @date 2019-12-27
 */
public interface JzRiskMapper 
{
    /**
     * 查询风险
     * 
     * @param riskId 风险ID
     * @return 风险
     */
    public JzRisk selectJzRiskById(Long riskId);

    /**
     * 查询风险列表
     * 
     * @param jzRisk 风险
     * @return 风险集合
     */
    public List<JzRisk> selectJzRiskList(JzRisk jzRisk);

    /**
     * 新增风险
     * 
     * @param jzRisk 风险
     * @return 结果
     */
    public int insertJzRisk(JzRisk jzRisk);

    /**
     * 修改风险
     * 
     * @param jzRisk 风险
     * @return 结果
     */
    public int updateJzRisk(JzRisk jzRisk);

    /**
     * 删除风险
     * 
     * @param riskId 风险ID
     * @return 结果
     */
    public int deleteJzRiskById(Long riskId);

    /**
     * 批量删除风险
     * 
     * @param riskIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzRiskByIds(String[] riskIds);

    /**
     * 根据Id获取文件地址
     * @param riskId
     * @return
     */
    public String selectFileUrlByRiskId(Long riskId);
}
