package com.ruoyi.equipment.service.impl;

import java.beans.Transient;
import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.equipment.domain.JzEquipmentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.equipment.mapper.JzEquipmentSpecificationsMapper;
import com.ruoyi.equipment.mapper.JzEquipmentRepMapper;
import com.ruoyi.equipment.domain.JzEquipmentSpecifications;
import com.ruoyi.equipment.service.IJzEquipmentSpecificationsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备规格Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-01-02
 */
@Service
public class JzEquipmentSpecificationsServiceImpl implements IJzEquipmentSpecificationsService 
{
    @Autowired
    private JzEquipmentSpecificationsMapper jzEquipmentSpecificationsMapper;

    @Autowired
    private JzEquipmentRepMapper jzEquipmentRepMapper;

    /**
     * 查询设备规格
     * 
     * @param spId 设备规格ID
     * @return 设备规格
     */
    @Override
    public JzEquipmentSpecifications selectJzEquipmentSpecificationsById(Long spId)
    {
        return jzEquipmentSpecificationsMapper.selectJzEquipmentSpecificationsById(spId);
    }

    /**
     * 查询设备规格列表
     * 
     * @param jzEquipmentSpecifications 设备规格
     * @return 设备规格
     */
    @Override
    public List<JzEquipmentSpecifications> selectJzEquipmentSpecificationsList(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        return jzEquipmentSpecificationsMapper.selectJzEquipmentSpecificationsList(jzEquipmentSpecifications);
    }
    /**
     * 设备规格下拉框
     * */
    @Override
    public List<JzEquipmentSpecifications> esList() {
        return jzEquipmentSpecificationsMapper.esList();
    }

    /**
     * 新增设备规格
     * 
     * @param jzEquipmentSpecifications 设备规格
     * @return 结果
     */
    @Override
    @Transient
    public int insertJzEquipmentSpecifications(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        //添加规格库
        int jes=jzEquipmentSpecificationsMapper.insertJzEquipmentSpecifications(jzEquipmentSpecifications);
        //添加备件库
        insertRep(jzEquipmentSpecifications);
       // int jesr=jzEquipmentRepMapper.insertJzEquipmentRep(jzEquipmentSpecifications);

        return jes;
    }

    /**
     * 修改设备规格
     * 
     * @param jzEquipmentSpecifications 设备规格
     * @return 结果
     */
    @Override
    public int updateJzEquipmentSpecifications(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        return jzEquipmentSpecificationsMapper.updateJzEquipmentSpecifications(jzEquipmentSpecifications);
    }

    /**
     * 修改设备规格,设备库
     *
     * @param jzEquipmentSpecifications 设备规格
     * @return 结果
     */
    @Override
    public int updateJzEquipmentSpecificationsRep(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        return jzEquipmentSpecificationsMapper.updateJzEquipmentSpecificationsRep(jzEquipmentSpecifications);
    }

    /**
     * 删除设备规格对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transient
    public int deleteJzEquipmentSpecificationsByIds(String ids)
    {
        jzEquipmentRepMapper.deleteJzEquipmentRepByIds(Convert.toStrArray(ids));
       int ist = jzEquipmentSpecificationsMapper.deleteJzEquipmentSpecificationsByIds(Convert.toStrArray(ids));
        return ist;
    }

    /**
     * 删除设备规格信息
     * 
     * @param spId 设备规格ID
     * @return 结果
     */
    @Override
    public int deleteJzEquipmentSpecificationsById(Long spId)
    {
        return jzEquipmentSpecificationsMapper.deleteJzEquipmentSpecificationsById(spId);
    }

    /**
     * 查询设备规格，备品库
     * @param sbId 设备规格ID
     * @return
     */
    @Override
    public List<JzEquipmentSpecifications> esrList(Long sbId) {
        return jzEquipmentSpecificationsMapper.esrList(sbId);
    }
    /**
     * 查询设备规格,备品库列表
     *
     * @param jzEquipmentSpecifications 设备规格
     * @return 设备规格
     */
    @Override
    public List<JzEquipmentSpecifications> selectJzEquipmentSpecificationsRepList(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        return jzEquipmentSpecificationsMapper.selectJzEquipmentSpecificationsRepList(jzEquipmentSpecifications);
    }
    /**
     * 新增用户角色信息
     *
     * @param jzEquipmentSpecifications 用户对象
     */
    public void insertRep(JzEquipmentSpecifications jzEquipmentSpecifications)
    {
        Long rep = jzEquipmentSpecifications.getSpId();
        JzEquipmentRep reps = new JzEquipmentRep();
        if(rep != 0 && rep != null){
            reps.setSpId(jzEquipmentSpecifications.getSpId());
            reps.setName(jzEquipmentSpecifications.getErName());
            reps.setGgXh(jzEquipmentSpecifications.getGgXh());
            reps.setNum(jzEquipmentSpecifications.getNum());
            reps.setType(jzEquipmentSpecifications.getType());
            reps.setState(jzEquipmentSpecifications.getState());
            jzEquipmentRepMapper.insertJzEquipmentRep(reps);
        }

    }
}
