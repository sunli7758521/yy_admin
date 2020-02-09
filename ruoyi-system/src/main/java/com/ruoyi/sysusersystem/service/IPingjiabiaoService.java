package com.ruoyi.sysusersystem.service;

import com.ruoyi.sysusersystem.domain.Pingjiabiao;
import java.util.List;

/**
 * 风险评价Service接口
 * 
 * @author sunli
 * @date 2020-01-18
 */
public interface IPingjiabiaoService 
{
    /**
     * 查询风险评价
     * 
     * @param pingjiaId 风险评价ID
     * @return 风险评价
     */
    public Pingjiabiao selectPingjiabiaoById(Long pingjiaId);

    /**
     * 查询风险评价列表
     * 
     * @param pingjiabiao 风险评价
     * @return 风险评价集合
     */
    public List<Pingjiabiao> selectPingjiabiaoList(Pingjiabiao pingjiabiao);

    /**
     * 新增风险评价
     * 
     * @param pingjiabiao 风险评价
     * @return 结果
     */
    public int insertPingjiabiao(Pingjiabiao pingjiabiao);

    /**
     * 修改风险评价
     * 
     * @param pingjiabiao 风险评价
     * @return 结果
     */
    public int updatePingjiabiao(Pingjiabiao pingjiabiao);

    /**
     * 批量删除风险评价
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePingjiabiaoByIds(String ids);

    /**
     * 删除风险评价信息
     * 
     * @param pingjiaId 风险评价ID
     * @return 结果
     */
    public int deletePingjiabiaoById(Long pingjiaId);
}
