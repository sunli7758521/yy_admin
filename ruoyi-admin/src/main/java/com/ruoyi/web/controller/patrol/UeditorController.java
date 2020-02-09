package com.ruoyi.web.controller.patrol;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.patrol.ueditor.PublicMsg;
import com.ruoyi.patrol.ueditor.Ueditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 富文本
 *
 * @author zhaoyan
 * @date 2019-10-30
 */
@Controller
@RequestMapping("/patrol/ueditor")
public class UeditorController extends BaseController {

    @Autowired
    private ServerConfig serverConfig;

    @RequestMapping(value="/ueditor")
    @ResponseBody
    public String ueditor(@RequestParam("action") String param, MultipartFile upfile, HttpServletRequest request) {
        Ueditor ueditor = new Ueditor();
        if(param!=null && param.equals("config")){
            return PublicMsg.UEDITOR_CONFIG;
        }else if(param!=null && param.equals("uploadimage")||param.equals("uploadscrawl")||param.equals("uploadfile")){
            if(upfile!=null){
                //{state：”数据状态信息”，url：”图片回显路径”，title：”文件title”，original：”文件名称”，···}
                try {
                    return uploadImg(upfile,request);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    ueditor.setState("出现异常");
                    return JSON.toJSONString(ueditor);
                }
            }else{
                ueditor.setState("文件为空");
                return JSON.toJSONString(ueditor);
            }
        }else{
            ueditor.setState("不支持该操作");
            return JSON.toJSONString(ueditor);
        }
    }

    @RequestMapping(value="/imgUpload")
    @ResponseBody
    public Ueditor imgUpload(@RequestParam("action") String param,MultipartFile upfile,HttpServletRequest request) {
        Ueditor ueditor = new Ueditor();
        return ueditor;
    }

    public String uploadImg(MultipartFile file, HttpServletRequest request) throws IOException {
        Ueditor ueditor = new Ueditor();
        String filePath = Global.getUploadPath();
        String fileName = FileUploadUtils.upload(filePath, file);
//        String url = serverConfig.getUrl() + fileName;//冯智朝原有
        String url = fileName;//郎金超改
        ueditor.setState("SUCCESS");
        ueditor.setTitle(fileName);
        ueditor.setOriginal(fileName);
        ueditor.setUrl(url);
        System.out.println( JSON.toJSONString(ueditor));
        return JSON.toJSONString(ueditor);
    }
}
