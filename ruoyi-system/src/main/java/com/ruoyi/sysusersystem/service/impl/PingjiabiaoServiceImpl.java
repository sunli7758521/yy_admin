package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.PingjiabiaoMapper;
import com.ruoyi.sysusersystem.domain.Pingjiabiao;
import com.ruoyi.sysusersystem.service.IPingjiabiaoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 风险评价Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-18
 */
@Service
public class PingjiabiaoServiceImpl implements IPingjiabiaoService 
{
    @Autowired
    private PingjiabiaoMapper pingjiabiaoMapper;

    /**
     * 查询风险评价
     * 
     * @param pingjiaId 风险评价ID
     * @return 风险评价
     */
    @Override
    public Pingjiabiao selectPingjiabiaoById(Long pingjiaId)
    {
        return pingjiabiaoMapper.selectPingjiabiaoById(pingjiaId);
    }

    /**
     * 查询风险评价列表
     * 
     * @param pingjiabiao 风险评价
     * @return 风险评价
     */
    @Override
    public List<Pingjiabiao> selectPingjiabiaoList(Pingjiabiao pingjiabiao)
    {
        return pingjiabiaoMapper.selectPingjiabiaoList(pingjiabiao);
    }

    /**
     * 新增风险评价
     * 
     * @param pingjiabiao 风险评价
     * @return 结果
     */
    @Override
    public int insertPingjiabiao(Pingjiabiao pingjiabiao)
    {
        return pingjiabiaoMapper.insertPingjiabiao(pingjiabiao);
    }

    /**
     * 修改风险评价
     * 
     * @param pingjiabiao 风险评价
     * @return 结果
     */
    @Override
    public int updatePingjiabiao(Pingjiabiao pingjiabiao)
    {
        return pingjiabiaoMapper.updatePingjiabiao(pingjiabiao);
    }

    /**
     * 删除风险评价对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePingjiabiaoByIds(String ids)
    {
        return pingjiabiaoMapper.deletePingjiabiaoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除风险评价信息
     * 
     * @param pingjiaId 风险评价ID
     * @return 结果
     */
    @Override
    public int deletePingjiabiaoById(Long pingjiaId)
    {
        return pingjiabiaoMapper.deletePingjiabiaoById(pingjiaId);
    }
}
