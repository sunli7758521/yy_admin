package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.sysusersystem.domain.JzHiddenTrouble;
import com.ruoyi.sysusersystem.domain.YhZgYsVo;
import com.ruoyi.sysusersystem.mapper.JzHiddenTroubleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.YhZgMapper;
import com.ruoyi.sysusersystem.domain.YhZg;
import com.ruoyi.sysusersystem.service.IYhZgService;
import com.ruoyi.common.core.text.Convert;

/**
 * 隐患整改Service业务层处理
 * 
 * @author sunli
 * @date 2020-02-22
 */
@Service
public class YhZgServiceImpl implements IYhZgService 
{
    @Autowired
    private YhZgMapper yhZgMapper;

    @Autowired
    private JzHiddenTroubleMapper jzHiddenTroubleMapper;

    /**
     * 查询隐患整改
     * 
     * @param id 隐患整改ID
     * @return 隐患整改
     */
    @Override
    public YhZg selectYhZgById(Long id)
    {
        return yhZgMapper.selectYhZgById(id);
    }

    /**
     * 查询隐患整改列表
     * 
     * @param yhZg 隐患整改
     * @return 隐患整改
     */
    @Override
    public List<YhZg> selectYhZgList(YhZg yhZg)
    {
        return yhZgMapper.selectYhZgList(yhZg);
    }

    /**
     * 新增隐患整改
     * 
     * @param yhZg 隐患整改
     * @return 结果
     */
    @Override
    public int insertYhZg(YhZg yhZg)
    {
        yhZg.setCreateTime(DateUtils.getNowDate());
        String state= "1";

        updateYHXState(yhZg.getYhId(),state);
        return yhZgMapper.insertYhZg(yhZg);
    }
    // 修改整改项状态 把已排查未整改  改为已整改未审核
    private void updateYHXState(Long yhId,String state) {
        JzHiddenTrouble hiddenTrouble = new JzHiddenTrouble();
        hiddenTrouble.setHiddenTroubleId(yhId);
        if(state.equals("1")){
            // 修改整改项状态 把已排查未整改  改为已整改未审核
            hiddenTrouble.setState("1");
        }else if(state.equals("1")){
            //  未删除 修改状态 改成已排查未整改
            hiddenTrouble.setState("1");
        }

        jzHiddenTroubleMapper.updateJzHiddenTrouble(hiddenTrouble);
    }

    /**
     * 修改隐患整改
     * 
     * @param yhZg 隐患整改
     * @return 结果
     */
    @Override
    public int updateYhZg(YhZg yhZg)
    {
        yhZg.setUpdateTime(DateUtils.getNowDate());
        return yhZgMapper.updateYhZg(yhZg);
    }

    /**
     * 删除隐患整改对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYhZgByIds(String ids)
    {
        String[] id  = ids.split(",");
        if(id.length>1){

            for (String s : id) {
                YhZg yhZg = yhZgMapper.selectYhZgById(Long.parseLong(s));
                String state= "1";
                updateYHXState(yhZg.getYhId(),state);
            }
        }


        return yhZgMapper.deleteYhZgByIds(Convert.toStrArray(ids));
    }


    /**
     * 删除隐患整改信息
     * 
     * @param id 隐患整改ID
     * @return 结果
     */
    @Override
    public int deleteYhZgById(Long id)
    {
        YhZg yhZg = yhZgMapper.selectYhZgById(id);
        String state= "1";
        updateYHXState(yhZg.getYhId(),state);
        return yhZgMapper.deleteYhZgById(id);
    }
    /**
     * 查询隐患整改验收
     *
     * @param yhZg 隐患整改验收
     * @return 结果
     */
    @Override
    public List<YhZgYsVo> selectYhZgYsList(YhZgYsVo yhZg) {
        return yhZgMapper.selectYhZgYsList(yhZg);
    }
}
