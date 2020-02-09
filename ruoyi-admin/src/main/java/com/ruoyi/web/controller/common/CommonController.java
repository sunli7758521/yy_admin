package com.ruoyi.web.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用请求处理
 * 
 * @author ruoyi
 */
@Controller
public class CommonController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;

    public static int wToPdfChange(String wordFile, String pdfFile) {
        int flag = 0;
            ActiveXComponent app = null;
                    System.out.println("开始转换...");
                    // 开始时间
                   // long start = System.currentTimeMillis();
                    try {
                         // 打开word
                         app = new ActiveXComponent("Word.Application");
                         // 获得word中所有打开的文档
                         Dispatch documents = app.getProperty("Documents").toDispatch();
                         //System.out.println("打开文件: " + wordFile);
                         // 打开文档
                         Dispatch document = Dispatch.call(documents, "Open", wordFile, false, true).toDispatch();
                         // 如果文件存在的话，不会覆盖，会直接报错，所以我们需要判断文件是否存在
                         File target = new File(pdfFile);
                          if (target.exists()) {
                                 target.delete();
                              }
                         //System.out.println("另存为: " + pdfFile);
                         Dispatch.call(document, "SaveAs", pdfFile, 17);
                         // 关闭文档
                         Dispatch.call(document, "Close", false);
                        }catch(Exception e) {
                        flag = 1;
                         System.out.println("转换失败"+e.getMessage());
                        }finally {
                          // 关闭office
                        // app.invoke("Quit", 0);
                        }
                 return  flag;
    }

    /**
     * 通用下载请求
     * 
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            if (!FileUtils.isValidFilename(fileName))
            {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = Global.getDownloadPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }


    /**
     * 通用上传方法
     */
    @PostMapping("common1/upload/")
    @ResponseBody
    public  Map<String,String> upload1(@RequestParam("file") MultipartFile file) {
        Map<String,String> map = new HashMap<>();
        try
        {
            if (!file.isEmpty())
            {
                String img = FileUploadUtils.upload(Global.getUploadPath(), file);
                map.put("code","0");
                map.put("msg",img);
                return map;
            }
            map.put("code","1");
            map.put("msg","更新失败");
            return map;
        }
        catch (Exception e)
        {
            log.error("修改头像失败！", e);
            map.put("code","1");
            map.put("msg",e.getMessage());
            return map;
        }
    }
    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = Global.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        // 本地资源路径
        String localPath = Global.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }
}
