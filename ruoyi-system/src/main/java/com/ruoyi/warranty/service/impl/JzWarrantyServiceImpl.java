package com.ruoyi.warranty.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.warranty.mapper.JzWarrantyMapper;
import com.ruoyi.warranty.domain.JzWarranty;
import com.ruoyi.warranty.service.IJzWarrantyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报修Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
@Service
public class JzWarrantyServiceImpl implements IJzWarrantyService 
{
    @Autowired
    private JzWarrantyMapper jzWarrantyMapper;

    /**
     * 查询手机号
     *
     * @param Id
     * @return
     */
    @Override
    public String selectPhone(long Id) {
        return jzWarrantyMapper.selectPhone(Id);
    }

    /**
     * 查询报修
     * 
     * @param warrantyId 报修ID
     * @return 报修
     */
    @Override
    public JzWarranty selectJzWarrantyById(Long warrantyId)
    {
        return jzWarrantyMapper.selectJzWarrantyById(warrantyId);
    }

    /**
     * 查询报修列表
     * 
     * @param jzWarranty 报修
     * @return 报修
     */
    @Override
    public List<JzWarranty> selectJzWarrantyList(JzWarranty jzWarranty)
    {
        return jzWarrantyMapper.selectJzWarrantyList(jzWarranty);
    }

    /**
     * 新增报修
     * 
     * @param jzWarranty 报修
     * @return 结果
     */
    @Override
    public int insertJzWarranty(JzWarranty jzWarranty)
    {
        jzWarranty.setCreateTime(DateUtils.getNowDate());
        return jzWarrantyMapper.insertJzWarranty(jzWarranty);
    }

    /**
     * 修改报修
     * 
     * @param jzWarranty 报修
     * @return 结果
     */
    @Override
    public int updateJzWarranty(JzWarranty jzWarranty)
    {
        jzWarranty.setUpdateTime(DateUtils.getNowDate());
        return jzWarrantyMapper.updateJzWarranty(jzWarranty);
    }

    /**
     * 删除报修对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzWarrantyByIds(String ids)
    {
        return jzWarrantyMapper.deleteJzWarrantyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报修信息
     * 
     * @param warrantyId 报修ID
     * @return 结果
     */
    @Override
    public int deleteJzWarrantyById(Long warrantyId)
    {
        return jzWarrantyMapper.deleteJzWarrantyById(warrantyId);
    }


}
