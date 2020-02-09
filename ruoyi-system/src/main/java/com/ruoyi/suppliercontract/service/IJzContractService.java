package com.ruoyi.suppliercontract.service;

import com.ruoyi.suppliercontract.domain.JzContract;
import com.ruoyi.suppliercontract.domain.JzSupplier;

import java.util.List;

/**
 * 合同Service接口
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
public interface IJzContractService 
{
    /**
     * 查询合同
     * 
     * @param id 合同ID
     * @return 合同
     */
    public JzContract selectJzContractById(Long id);

    /**
     * 查询合同列表
     * 
     * @param jzContract 合同
     * @return 合同集合
     */
    public List<JzContract> selectJzContractList(JzContract jzContract);

    /**
     * 新增合同
     * 
     * @param jzContract 合同
     * @return 结果
     */
    public int insertJzContract(JzContract jzContract);

    /**
     * 修改合同
     * 
     * @param jzContract 合同
     * @return 结果
     */
    public int updateJzContract(JzContract jzContract);

    /**
     * 批量删除合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzContractByIds(String ids);

    /**
     * 删除合同信息
     * 
     * @param id 合同ID
     * @return 结果
     */
    public int deleteJzContractById(Long id);
    /**
     * 查询供应商列表
     *
     * @param supplierName 供应商Name
     * @param   titile     合同标题
     * @return 供应商集合
     */
 //   public  List<JzContract> selectConSupList(String supplierName,String titile);
}
