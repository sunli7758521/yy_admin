package com.ruoyi.web.controller.sysusersystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.sysusersystem.domain.JzRisk;
import com.ruoyi.sysusersystem.domain.Pingjiabiao;
import com.ruoyi.sysusersystem.service.IJzRiskService;
import com.ruoyi.sysusersystem.service.IPingjiabiaoService;
import com.ruoyi.web.controller.common.CommonController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import sun.util.calendar.BaseCalendar;

/**
 * 风险Controller
 * 
 * @author sunli
 * @date 2019-12-27
 */
@Controller
@RequestMapping("/sysusersystem/risk")
public class JzRiskController extends BaseController
{
    private String prefix = "sysusersystem/risk";

    @Autowired
    private IPingjiabiaoService pingjiabiaoService;

    @Autowired
    private IJzRiskService jzRiskService;
    @GetMapping("/test/{parentId}")
    public void test(@PathVariable Long parentId){
        Long s = parentId;
        Map<Long,String> map  = new HashMap<>();
        map.put(203L,"elevator_system_risk");
        map.put(301L,"risk_of_electric");
    }
    /**
     *  添加页面在线预览word文件
     * @param fileUrl word文件名称
     * @param mmap
     * @return 跳转yulan文件
     */
    @RequestMapping(value="/addWordToPdf/{fileUrl}",method= RequestMethod.GET)
    public String addWordToPdf(@PathVariable String fileUrl,ModelMap mmap)
    {
        /**
         * 1，word转pdf
         * 2. 读取数据库word路径，
         * 3. 读取pdf路径
         * 4. 显示到页面
         */
        Date date = new Date();
        String strDateFormat = "/yyyy/MM/dd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String path1 = Global.getUploadPath()+ fileUrl;
        String isDocOrDocx = path1.substring(path1.indexOf("."));
        String path = Global.getUploadPath()+sdf.format(date)+"/"+fileUrl;
        String str=null;
        if(isDocOrDocx.equals(".docx")) {
            str = path1.substring(0, path1.indexOf(".docx"));
        }else if(isDocOrDocx.equals(".doc"))
        {
            str = path1.substring(0, path1.indexOf(".doc"));
        }else if(isDocOrDocx.equals(".pdf"))
        {
            //PDF文件直接显示
            String pdfUrl = str.substring(str.lastIndexOf("/")+1);
            mmap.put("pdfUrl",Constants.RESOURCE_PREFIX+"/"+pdfUrl);
            return prefix+"/yu";
        }else if(isDocOrDocx.equals(".zip")){
            //压缩文件不能在线预览
        }
        String pdfUrl = str.concat(".pdf");
        int flag = CommonController.wToPdfChange(path,pdfUrl);//word转PDF
        if(flag==0){
            pdfUrl = pdfUrl.substring(pdfUrl.lastIndexOf("/")+1);
            //把pdf文件路径传递到yulan.html页面
        }else{
        }
        mmap.put("pdfUrl", Constants.RESOURCE_PREFIX+"/"+pdfUrl);
        return prefix+"/yu";
    }
    /**
     * docx,doc 可以转换
     * pdf 直接显示  方法现未做处理
     * 更新页面预览文件
     * @param riskId 接收主键查询fileurl
     * @param mmap
     * @return
     */
    @RequestMapping(value="/editWordToPdf/{riskId}",method= RequestMethod.GET)
    @RequiresPermissions("sysusersystem:risk:search")
    public String editWordToPdf(@PathVariable Long riskId,ModelMap mmap)
    {
        //String wordfile = jzSystemManagementService.selectFileUrlByManagementByID(managementId);//根据Id获取到文件路径
        String wordfile = "";
        wordfile = jzRiskService.selectFileUrlByRiskId(riskId);//根据Id获取文件路径
        wordfile= Global.getUploadPath()+wordfile.substring(15);// /profile/upload 所以从第16位开始
        String fileName = wordfile.substring(wordfile.lastIndexOf("/")+1);//截取到文件名称
        String path1 =Global.getUploadPath()+fileName;//获取全路径
        String isDocOrDocx = path1.substring(path1.indexOf("."));
        String str = null;
        if(isDocOrDocx.equals(".docx")) {
            str = path1.substring(0, path1.indexOf(".docx"));
        }else if(isDocOrDocx.equals(".doc"))
        {
            str = path1.substring(0, path1.indexOf(".doc"));
        }
        String pdffile = str.concat(".pdf");;
        int flag = CommonController.wToPdfChange(wordfile,pdffile);
        String pdfName = fileName.substring(0,fileName.indexOf(".")).concat(".pdf");
        if(flag==0){
            mmap.put("pdfUrl", Constants.RESOURCE_PREFIX+"/upload"+pdfName);
        }else{
            //文件读取错误
        }
        return prefix+"/yu";
    }
    @RequiresPermissions("sysusersystem:risk:view")
    @GetMapping()
    public String risk()
    {
        return prefix + "/risk";
    }

    /**
     * 查询风险列表
     * @param jzrisk
     */
    @RequiresPermissions("sysusersystem:risk:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JzRisk jzrisk)
    {
        startPage();
//        jzrisk.setTypeId(117L); //117L 对应 sys_dict_date 的ID　为风险
        List<JzRisk> list = jzRiskService.selectJzRiskList(jzrisk);
        return getDataTable(list);
    }

    /**
     * 导出风险列表
     */
    @RequiresPermissions("sysusersystem:risk:export")
    @Log(title = "风险", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JzRisk jzRisk)
    {
        List<JzRisk> list = jzRiskService.selectJzRiskList(jzRisk);
        ExcelUtil<JzRisk> util = new ExcelUtil<JzRisk>(JzRisk.class);
        return util.exportExcel(list, "risk");
    }

    /**
     * 新增风险
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存风险
     * 更新时间 更新人 创建作者数据需要在更新和添加的时候自动写入，未完成
     */
    @RequiresPermissions("sysusersystem:risk:add")
    @Log(title = "风险", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JzRisk jzRisk)
    {
        jzRisk.setCreateId(ShiroUtils.getUserId());
        return toAjax(jzRiskService.insertJzRisk(jzRisk));
    }

    /**
     * 修改风险
     */
    @GetMapping("/edit/{riskId}")
    public String edit(@PathVariable("riskId") Long riskId, ModelMap mmap)
    {
        JzRisk jzRisk = jzRiskService.selectJzRiskById(riskId);
        mmap.put("jzRisk", jzRisk);
        return prefix + "/edit";
    }

    /**
     * 修改保存风险
     */
    @RequiresPermissions("sysusersystem:risk:edit")
    @Log(title = "风险", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JzRisk jzRisk)
    {
        jzRisk.setUpdateId(ShiroUtils.getUserId());
        return toAjax(jzRiskService.updateJzRisk(jzRisk));
    }

    /**
     * 删除风险
     */
    @RequiresPermissions("sysusersystem:risk:remove")
    @Log(title = "风险", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jzRiskService.deleteJzRiskByIds(ids));
    }

    /**
     * 风险评估详情
     */
    @GetMapping("/detail/{riskId}")
    public String detail(@PathVariable("riskId") Long riskId, ModelMap mmap)
    {

        mmap.put("riskId", riskId);

        return "sysusersystem/pingjiabiao/pingjiabiao";
    }

    /**
     * 新增风险评价
     */
    @GetMapping("/fXPG/{riskId}")
    public String add(@PathVariable("riskId") Long riskId, ModelMap mmap)
    {
        mmap.put("riskId", riskId);
        return prefix + "/fxpg";
    }

    /**
     * 新增保存风险评价
     */
    @RequiresPermissions("sysusersystem:pingjiabiao:add")
    @Log(title = "风险评价", businessType = BusinessType.INSERT)
    @PostMapping("/fXPG")
    @ResponseBody
    public AjaxResult fXPG(Pingjiabiao pingjiabiao)
    {
        pingjiabiao.setPjTime(DateUtils.getNowDate());
        return toAjax(pingjiabiaoService.insertPingjiabiao(pingjiabiao));
    }

    /**
     * docx,doc 可以转换
     * pdf 直接显示  方法现未做处理
     * 更新页面预览文件
     * @param riskId 接收主键查询fileurl
     * @param mmap
     * @return
     */
    @RequestMapping(value="/pgWordToPdf/{riskId}",method= RequestMethod.GET)
    @RequiresPermissions("sysusersystem:risk:search")
    public String pgWordToPdf(@PathVariable Long riskId,ModelMap mmap)
    {
        //String wordfile = jzSystemManagementService.selectFileUrlByManagementByID(managementId);//根据Id获取到文件路径
        String wordfile = "";
        wordfile = jzRiskService.selectByRiskId(riskId);//根据Id获取文件路径
        wordfile= Global.getUploadPath()+wordfile.substring(15);// /profile/upload 所以从第16位开始
        String fileName = wordfile.substring(wordfile.lastIndexOf("/")+1);//截取到文件名称
        String path1 =Global.getUploadPath()+fileName;//获取全路径
        String isDocOrDocx = path1.substring(path1.indexOf("."));
        String str = null;
        if(isDocOrDocx.equals(".docx")) {
            str = path1.substring(0, path1.indexOf(".docx"));
        }else if(isDocOrDocx.equals(".doc"))
        {
            str = path1.substring(0, path1.indexOf(".doc"));
        }
        String pdffile = str.concat(".pdf");;
        int flag = CommonController.wToPdfChange(wordfile,pdffile);
        String pdfName = fileName.substring(0,fileName.indexOf(".")).concat(".pdf");
        if(flag==0){
            mmap.put("pdfUrl", Constants.RESOURCE_PREFIX+"/upload"+pdfName);
        }else{
            //文件读取错误
        }
        return prefix+"/yu";
    }

}
