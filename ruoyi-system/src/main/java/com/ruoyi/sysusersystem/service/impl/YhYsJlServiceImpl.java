package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.sysusersystem.domain.JzHiddenTrouble;
import com.ruoyi.sysusersystem.mapper.JzHiddenTroubleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.YhYsJlMapper;
import com.ruoyi.sysusersystem.domain.YhYsJl;
import com.ruoyi.sysusersystem.service.IYhYsJlService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 隐患验收记录Service业务层处理
 * 
 * @author sunli
 * @date 2020-02-24
 */
@Service
public class YhYsJlServiceImpl implements IYhYsJlService 
{
    @Autowired
    private YhYsJlMapper yhYsJlMapper;

    @Autowired
    private JzHiddenTroubleMapper jzHiddenTroubleMapper;

    /**
     * 查询隐患验收记录
     * 
     * @param yId 隐患验收记录ID
     * @return 隐患验收记录
     */
    @Override
    public YhYsJl selectYhYsJlById(Long yId)
    {
        return yhYsJlMapper.selectYhYsJlById(yId);
    }

    /**
     * 查询隐患验收记录列表
     * 
     * @param yhYsJl 隐患验收记录
     * @return 隐患验收记录
     */
    @Override
    public List<YhYsJl> selectYhYsJlList(YhYsJl yhYsJl)
    {
        return yhYsJlMapper.selectYhYsJlList(yhYsJl);
    }

    /**
     * 新增隐患验收记录
     * 
     * @param yhYsJl 隐患验收记录
     * @return 结果
     */
    @Override
    @Transactional
    public int insertYhYsJl(YhYsJl yhYsJl)
    {
        yhYsJl.setCreateTime(DateUtils.getNowDate());
        // 修改隐患表隐患项状态
        changYhState(yhYsJl);
        return yhYsJlMapper.insertYhYsJl(yhYsJl);
    }
    // 修改隐患表隐患项状态
    private void changYhState(YhYsJl yhYsJl) {
        JzHiddenTrouble  jzHiddenTrouble= new JzHiddenTrouble();
        jzHiddenTrouble.setHiddenTroubleId(yhYsJl.getYhId());
        // 审核通过
        if(yhYsJl.getState().equals("0")){
            // 验收通过
            jzHiddenTrouble.setState("3");
        }else{
            // 验收不通过
            jzHiddenTrouble.setState("2");
        }
         jzHiddenTroubleMapper.updateJzHiddenTrouble(jzHiddenTrouble);
    }

    /**
     * 修改隐患验收记录
     * 
     * @param yhYsJl 隐患验收记录
     * @return 结果
     */
    @Override
    public int updateYhYsJl(YhYsJl yhYsJl)
    {
        yhYsJl.setUpdateTime(DateUtils.getNowDate());
        return yhYsJlMapper.updateYhYsJl(yhYsJl);
    }

    /**
     * 删除隐患验收记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYhYsJlByIds(String ids)
    {
        return yhYsJlMapper.deleteYhYsJlByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除隐患验收记录信息
     * 
     * @param yId 隐患验收记录ID
     * @return 结果
     */
    @Override
    public int deleteYhYsJlById(Long yId)
    {
        return yhYsJlMapper.deleteYhYsJlById(yId);
    }
}
