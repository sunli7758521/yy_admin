package com.ruoyi.warranty.service;

import com.ruoyi.warranty.domain.JzWarranty;
import java.util.List;

/**
 * 报修Service接口
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
public interface IJzWarrantyService 
{
    /**
     * 查询报修
     * 
     * @param warrantyId 报修ID
     * @return 报修
     */
    public JzWarranty selectJzWarrantyById(Long warrantyId);

    /**
     * 查询报修列表
     * 
     * @param jzWarranty 报修
     * @return 报修集合
     */
    public List<JzWarranty> selectJzWarrantyList(JzWarranty jzWarranty);

    /**
     * 新增报修
     * 
     * @param jzWarranty 报修
     * @return 结果
     */
    public int insertJzWarranty(JzWarranty jzWarranty);

    /**
     * 修改报修
     * 
     * @param jzWarranty 报修
     * @return 结果
     */
    public int updateJzWarranty(JzWarranty jzWarranty);

    /**
     * 批量删除报修
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzWarrantyByIds(String ids);

    /**
     * 删除报修信息
     * 
     * @param warrantyId 报修ID
     * @return 结果
     */
    public int deleteJzWarrantyById(Long warrantyId);


}
