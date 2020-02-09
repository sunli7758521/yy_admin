package com.ruoyi.suppliercontract.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.suppliercontract.domain.JzSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.suppliercontract.mapper.JzContractMapper;
import com.ruoyi.suppliercontract.domain.JzContract;
import com.ruoyi.suppliercontract.service.IJzContractService;
import com.ruoyi.common.core.text.Convert;

/**
 * 合同Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
@Service
public class JzContractServiceImpl implements IJzContractService 
{
    @Autowired
    private JzContractMapper jzContractMapper;

    /**
     * 查询合同
     * 
     * @param id 合同ID
     * @return 合同
     */
    @Override
    public JzContract selectJzContractById(Long id)
    {
        return jzContractMapper.selectJzContractById(id);
    }

    /**
     * 查询合同列表
     * 
     * @param jzContract 合同
     * @return 合同
     */
    @Override
    public List<JzContract> selectJzContractList(JzContract jzContract)
    {
        return jzContractMapper.selectJzContractList(jzContract);
    }

    /**
     * 新增合同
     * 
     * @param jzContract 合同
     * @return 结果
     */
    @Override
    public int insertJzContract(JzContract jzContract)
    {
        jzContract.setCreateTime(DateUtils.getNowDate());
        return jzContractMapper.insertJzContract(jzContract);
    }

    /**
     * 修改合同
     * 
     * @param jzContract 合同
     * @return 结果
     */
    @Override
    public int updateJzContract(JzContract jzContract)
    {
        jzContract.setUpdateTime(DateUtils.getNowDate());
        return jzContractMapper.updateJzContract(jzContract);
    }

    /**
     * 删除合同对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzContractByIds(String ids)
    {
        return jzContractMapper.deleteJzContractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同信息
     * 
     * @param id 合同ID
     * @return 结果
     */
    @Override
    public int deleteJzContractById(Long id)
    {
        return jzContractMapper.deleteJzContractById(id);
    }
    /**
     * 查询供应商Name列表
     *
     * @param jzContract 供应商Name
     * @return 供应商
     */
//    @Override
//    public List<JzContract> selectConSupList(String supplierName,String titile)
//    {
//        List<JzSupplier> list = jzSupplierMapper.selectJzSupplierNameList(supplierName);
//        return jzContractMapper.selectConSupList(supplierName,titile);
//    }

}
