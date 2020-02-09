package com.ruoyi.business.service.impl;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.DateUtils;
import org.apache.poi.poifs.crypt.dsig.ExpiredCertificateSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.JzTypeMapper;
import com.ruoyi.business.domain.JzType;
import com.ruoyi.business.service.IJzTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 风险分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-12-25
 */
@Service
public class JzTypeServiceImpl implements IJzTypeService 
{
    @Autowired
    private JzTypeMapper jzTypeMapper;

    /**
     * 查询风险分类
     * 
     * @param id 风险分类ID
     * @return 风险分类
     */
    @Override
    public JzType selectJzTypeById(Long id)
    {
        return jzTypeMapper.selectJzTypeById(id);
    }

    /**
     * 查询风险分类列表
     * 
     * @param jzType 风险分类
     * @return 风险分类
     */
    @Override
    public List<JzType> selectJzTypeList(JzType jzType)
    {
        return jzTypeMapper.selectJzTypeList(jzType);
    }

    /**
     * 新增风险分类
     * 
     * @param jzType 风险分类
     * @return 结果
     */
    @Override
    public int insertJzType(JzType jzType)
    {
//        JzType info = jzTypeMapper.selectJzTypeByParentId(jzType.getParentId());
                JzType info = jzTypeMapper.selectJzTypeById(jzType.getParentId());
        if(info !=null){
            jzType.setAncestors(info.getAncestors().concat(",").concat(jzType.getParentId().toString()));
            jzType.setCreateTime(DateUtils.getNowDate());
        }else{

        }

        return jzTypeMapper.insertJzType(jzType);
    }

    /**
     * 修改风险分类
     * 
     * @param jzType 风险分类
     * @return 结果
     */
    @Override
    public int updateJzType(JzType jzType)
    {
        jzType.setUpdateTime(DateUtils.getNowDate());
        return jzTypeMapper.updateJzType(jzType);
    }

    /**
     * 删除风险分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJzTypeByIds(String ids)
    {
        return jzTypeMapper.deleteJzTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除风险分类信息
     * 
     * @param id 风险分类ID
     * @return 结果
     */
    @Override
    public int deleteJzTypeById(Long id)
    {
        return jzTypeMapper.deleteJzTypeById(id);
    }

    /**
     * 获取9系统系统名称
     *
     * @return
     */
    @Override
    public List<JzType> jzTypeSubList() {
        return jzTypeMapper.selectSystemName();
    }

    /**
     * 之后删除
     *
     * @param dictType
     * @return
     */
    @Override
    public List<JzType> selectJzTypeByType(String dictType) {
        return jzTypeMapper.selectJzTypeByType(dictType);
    }

    /**
     * 根据ID查询所用数据
     *
     * @param ID
     * @return
     */
    @Override
    public JzType selectJzTypeByParentId(Long ID) {
        return jzTypeMapper.selectJzTypeByParentId(ID);
    }

    /**
     * @param stateid
     * @return
     */
    @Override
    public List<JzType> listType(int stateid) {
        return jzTypeMapper.listType(stateid);
    }
    /**
     * 获取应急物资分类列表
     * @param
     * @return
     */
    @Override
    public List<JzType> wzList(){
        return jzTypeMapper.wzList();
    }

    /**
     * 获取应急物资大分类表表
     * @return
     */
    @Override
    public List<JzType> bswzList(int type) {
        return  jzTypeMapper.bswzList(type);
    }

    /**
     * 获取应急物资小分类表表
     * @param type
     * @return
     */
    @Override
    public List<JzType> smallTypeList(int type) {
        return  jzTypeMapper.smallTypeList(type);
    }
}
