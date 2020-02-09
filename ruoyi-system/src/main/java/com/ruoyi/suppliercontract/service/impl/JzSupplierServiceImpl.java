package com.ruoyi.suppliercontract.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.suppliercontract.mapper.JzSupplierMapper;
import com.ruoyi.suppliercontract.domain.JzSupplier;
import com.ruoyi.suppliercontract.service.IJzSupplierService;
import com.ruoyi.common.core.text.Convert;

/**
 * 供应商Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
@Service("sup")
public class JzSupplierServiceImpl implements IJzSupplierService 
{
    @Autowired
    private JzSupplierMapper jzSupplierMapper;

    /**
     * 查询供应商
     * 
     * @param supplierId 供应商ID
     * @return 供应商
     */
    @Override
    public JzSupplier selectJzSupplierById(Long supplierId)
    {
        return jzSupplierMapper.selectJzSupplierById(supplierId);
    }

    /**
     * 查询供应商列表
     * 
     * @param jzSupplier 供应商
     * @return 供应商
     */
    @Override
    public List<JzSupplier> selectJzSupplierList(JzSupplier jzSupplier)
    {
        return jzSupplierMapper.selectJzSupplierList(jzSupplier);
    }


    /**
     * 新增供应商
     *
     * @param jzSupplier 供应商
     * @return 结果
     */
    @Override
    public int insertJzSupplier(JzSupplier jzSupplier)
    {
        jzSupplier.setCreateTime(DateUtils.getNowDate());
        return jzSupplierMapper.insertJzSupplier(jzSupplier);
    }

    /**
     * 修改供应商
     * 
     * @param jzSupplier 供应商
     * @return 结果
     */
    @Override
    public int updateJzSupplier(JzSupplier jzSupplier)
    {
        jzSupplier.setUpdateTime(DateUtils.getNowDate());
        return jzSupplierMapper.updateJzSupplier(jzSupplier);
    }

    /**
     * 删除供应商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzSupplierByIds(String ids)
    {
        return jzSupplierMapper.deleteJzSupplierByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商信息
     * 
     * @param supplierId 供应商ID
     * @return 结果
     */
    @Override
    public int deleteJzSupplierById(Long supplierId)
    {
        return jzSupplierMapper.deleteJzSupplierById(supplierId);
    }

    @Override
    public List<JzSupplier> supList() {
        return jzSupplierMapper.supList();
    }
}
