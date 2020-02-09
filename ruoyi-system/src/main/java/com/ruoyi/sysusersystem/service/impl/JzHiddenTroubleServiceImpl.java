package com.ruoyi.sysusersystem.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.sysusersystem.domain.JzHiddenTroubleLog;
import com.ruoyi.sysusersystem.domain.JzHiddenTroubleVO;
import com.ruoyi.sysusersystem.mapper.JzHiddenTroubleLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sysusersystem.mapper.JzHiddenTroubleMapper;
import com.ruoyi.sysusersystem.domain.JzHiddenTrouble;
import com.ruoyi.sysusersystem.service.IJzHiddenTroubleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 隐患Service业务层处理
 * 
 * @author sunli
 * @date 2020-01-06
 */
@Service
public class JzHiddenTroubleServiceImpl implements IJzHiddenTroubleService 
{
    @Autowired
    private JzHiddenTroubleMapper jzHiddenTroubleMapper;

    @Autowired
    private JzHiddenTroubleLogMapper jzHiddenTroubleLogMapper;

    /**
     * 查询隐患
     * 
     * @param hiddenTroubleId 隐患ID
     * @return 隐患
     */
    @Override
    public JzHiddenTrouble selectJzHiddenTroubleById(Long hiddenTroubleId)
    {
        return jzHiddenTroubleMapper.selectJzHiddenTroubleById(hiddenTroubleId);
    }

    /**
     * 查询隐患列表
     * 
     * @param jzHiddenTrouble 隐患
     * @return 隐患
     */
    @Override
    public List<JzHiddenTrouble> selectJzHiddenTroubleList(JzHiddenTrouble jzHiddenTrouble)
    {
        return jzHiddenTroubleMapper.selectJzHiddenTroubleList(jzHiddenTrouble);
    }

    /**
     * 新增隐患
     * 
     * @param jzHiddenTrouble 隐患
     * @return 结果
     */
    @Override
    public int insertJzHiddenTrouble(JzHiddenTrouble jzHiddenTrouble)
    {
        jzHiddenTrouble.setCreateTime(DateUtils.getNowDate());
        int jht=jzHiddenTroubleMapper.insertJzHiddenTrouble(jzHiddenTrouble);
        insertJzHiddenTroubleLog(jzHiddenTrouble);
        return jht;
    }

    /**
     * 修改隐患
     * 
     * @param jzHiddenTrouble 隐患
     * @return 结果
     */
    @Override
    public int updateJzHiddenTrouble(JzHiddenTrouble jzHiddenTrouble)
    {
        jzHiddenTrouble.setUpdateTime(DateUtils.getNowDate());
        int jht=jzHiddenTroubleMapper.updateJzHiddenTrouble(jzHiddenTrouble);
        updateJzHiddenTroubleLog(jzHiddenTrouble);
        return jht;
    }

    /**
     * 删除隐患对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzHiddenTroubleByIds(String ids)
    {
        jzHiddenTroubleLogMapper.deleteJzHiddenTroubleLogByIds(Convert.toStrArray(ids));
        int jht=jzHiddenTroubleMapper.deleteJzHiddenTroubleByIds(Convert.toStrArray(ids));
        return jht;
    }


    /**
     * 删除隐患信息
     * 
     * @param hiddenTroubleId 隐患ID
     * @return 结果
     */
    @Override
    public int deleteJzHiddenTroubleById(Long hiddenTroubleId)
    {

        return jzHiddenTroubleMapper.deleteJzHiddenTroubleById(hiddenTroubleId);
    }
    /**
     * 预览隐患项
     *
     * @param
     * @return 结果
     */
    @Override
    public List<JzHiddenTroubleVO> selectHiddenTroubleList(JzHiddenTrouble log) {
        return jzHiddenTroubleMapper.selectHiddenTroubleList(log);
    }


    /**
     * 新增隐患
     *
     * @param jzHiddenTrouble 模板
     */
    public void insertJzHiddenTroubleLog(JzHiddenTrouble jzHiddenTrouble)
    {
        JzHiddenTroubleLog ht = new  JzHiddenTroubleLog();
        ht.setHiddenTroubleId(jzHiddenTrouble.getHiddenTroubleId());
        ht.setTypeId(jzHiddenTrouble.getTypeId());
        ht.setPlanId(jzHiddenTrouble.getPlanId());
        ht.setIdentifyPeople(jzHiddenTrouble.getIdentifyPeople());
        ht.setRectificationPeople(jzHiddenTrouble.getRectificationPeople());
        ht.setRectificationTime(jzHiddenTrouble.getRectificationTime());
        ht.setState(jzHiddenTrouble.getState());
        ht.setRemark(jzHiddenTrouble.getRemark());
        ht.setCreateTime(jzHiddenTrouble.getCreateTime());
        ht.setHiddenContent(jzHiddenTrouble.getHiddenContent());
        ht.setHiddenWz(jzHiddenTrouble.getHiddenWz());
        ht.setHiddenJb(jzHiddenTrouble.getHiddenJb());
        ht.setUpdateTime(jzHiddenTrouble.getUpdateTime());
        jzHiddenTroubleLogMapper.insertJzHiddenTroubleLog(ht);


    }
    /**
     * 修改隐患
     *
     * @param jzHiddenTrouble 模板
     */
    public void updateJzHiddenTroubleLog(JzHiddenTrouble jzHiddenTrouble)
    {
        JzHiddenTroubleLog ht = new  JzHiddenTroubleLog();
        ht.setHiddenTroubleId(jzHiddenTrouble.getHiddenTroubleId());
        ht.setTypeId(jzHiddenTrouble.getTypeId());
        ht.setPlanId(jzHiddenTrouble.getPlanId());
        ht.setIdentifyPeople(jzHiddenTrouble.getIdentifyPeople());
        ht.setRectificationPeople(jzHiddenTrouble.getRectificationPeople());
        ht.setRectificationTime(jzHiddenTrouble.getRectificationTime());
        ht.setState(jzHiddenTrouble.getState());
        ht.setRemark(jzHiddenTrouble.getRemark());
        ht.setCreateTime(jzHiddenTrouble.getCreateTime());
        ht.setHiddenContent(jzHiddenTrouble.getHiddenContent());
        ht.setHiddenWz(jzHiddenTrouble.getHiddenWz());
        ht.setHiddenJb(jzHiddenTrouble.getHiddenJb());
        ht.setUpdateTime(jzHiddenTrouble.getUpdateTime());
        jzHiddenTroubleLogMapper.updateJzHiddenTroubleLog(ht);


    }
}
