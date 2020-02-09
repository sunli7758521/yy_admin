package com.ruoyi.guanlisystem.service.impl;


import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.equipment.domain.JzEquipment;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guanlisystem.mapper.JzSysUserSystemMapper;
import com.ruoyi.guanlisystem.domain.JzSysUserSystem;
import com.ruoyi.guanlisystem.service.IJzSysUserSystemService;
import com.ruoyi.common.core.text.Convert;

/**
 * 系统用户管理的系统Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-02
 */
@Service
public class JzSysUserSystemServiceImpl implements IJzSysUserSystemService 
{
    @Autowired
    private JzSysUserSystemMapper jzSysUserSystemMapper;

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询系统用户管理的系统
     * 
     * @param id 系统用户管理的系统ID
     * @return 系统用户管理的系统
     */
    @Override
    public JzSysUserSystem selectJzSysUserSystemById(Long id)
    {
        return jzSysUserSystemMapper.selectJzSysUserSystemById(id);
    }

    /**
     * 查询系统用户管理的系统列表
     * 
     * @param jzSysUserSystem 系统用户管理的系统
     * @return 系统用户管理的系统
     */
    @Override
    public List<JzSysUserSystem> selectJzSysUserSystemList(JzSysUserSystem jzSysUserSystem)
    {
        return jzSysUserSystemMapper.selectJzSysUserSystemList(jzSysUserSystem);
    }

    /**
     * 新增系统用户管理的系统
     * 
     * @param jzSysUserSystem 系统用户管理的系统
     * @return 结果
     */
    @Override
    public int insertJzSysUserSystem(JzSysUserSystem jzSysUserSystem)
    {
        jzSysUserSystem.setCreateTime(DateUtils.getNowDate());
        return jzSysUserSystemMapper.insertJzSysUserSystem(jzSysUserSystem);
    }

    /**
     * 修改系统用户管理的系统
     * 
     * @param jzSysUserSystem 系统用户管理的系统
     * @return 结果
     */
    @Override
    public int updateJzSysUserSystem(JzSysUserSystem jzSysUserSystem)
    {
        jzSysUserSystem.setUpdateTime(DateUtils.getNowDate());
        return jzSysUserSystemMapper.updateJzSysUserSystem(jzSysUserSystem);
    }

    /**
     * 删除系统用户管理的系统对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzSysUserSystemByIds(String ids)
    {
        return jzSysUserSystemMapper.deleteJzSysUserSystemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除系统用户管理的系统信息
     * 
     * @param id 系统用户管理的系统ID
     * @return 结果
     */
    @Override
    public int deleteJzSysUserSystemById(Long id)
    {
        return jzSysUserSystemMapper.deleteJzSysUserSystemById(id);
    }
    /**
     *
     *  查询所管理的系统
     *
     * */
    @Override
    public List<SysDept> selectGuanliSystem(Long userId) {

        SysDept d = new SysDept();
        d.setParentId(300L);
        List<SysDept> list = sysDeptMapper.systemList(userId);
        List<SysDept> deptList = sysDeptService.selectDeptList(d);
        for (SysDept userSystem : deptList) {
            for (SysDept dept : list) {
                Long deptId = userSystem.getDeptId().longValue();
                Long deId =  dept.getDeptId().longValue();
                if (deptId.equals(deId))
                {
                    userSystem.setFlag(true);
                    break;
                }
            }
       }
        return deptList;
    }
    //  通过用户id 查询管理系统id
    @Override
    public List<JzSysUserSystem> selectByUserId(Long userId) {
        return jzSysUserSystemMapper.selectByUserId(userId);
    }


}
