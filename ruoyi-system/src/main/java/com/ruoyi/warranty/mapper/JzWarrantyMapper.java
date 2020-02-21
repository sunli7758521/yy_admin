package com.ruoyi.warranty.mapper;

import com.ruoyi.warranty.domain.JzWarranty;
import java.util.List;

/**
 * 报修Mapper接口
 * 
 * @author ruoyi
 * @date 2019-12-23
 */
public interface JzWarrantyMapper 
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
     * 删除报修
     * 
     * @param warrantyId 报修ID
     * @return 结果
     */
    public int deleteJzWarrantyById(Long warrantyId);

    /**
     * 批量删除报修
     * 
     * @param warrantyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJzWarrantyByIds(String[] warrantyIds);


}
