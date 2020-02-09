package com.ruoyi.suppliercontract.mapper;

import com.ruoyi.suppliercontract.domain.JzContract;
import java.util.List;

/**
 * 合同Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-17
 */
public interface JzContractMapper 
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
     * 删除合同
     * 
     * @param id 合同ID
     * @return 结果
     */
    public int deleteJzContractById(Long id);

    /**
     * 批量删除合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzContractByIds(String[] ids);

   // public List<JzContract> selectConSupList(String supplierName,String titile);
}
