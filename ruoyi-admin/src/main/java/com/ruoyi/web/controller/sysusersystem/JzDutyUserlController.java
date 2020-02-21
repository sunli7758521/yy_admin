package com.ruoyi.web.controller.sysusersystem;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.sysusersystem.domain.JzDutyUser;
import com.ruoyi.sysusersystem.service.IJzDutyUserService;
import com.ruoyi.sysusersystem.service.IJzPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 值班关联用户Controller
 * 
 * @author sunli
 * @date 2020-01-13
 */
@Controller
@RequestMapping("/sysusersystem/userl")
public class JzDutyUserlController extends BaseController
{
    private String prefix = "sysusersystem/user";

    @Autowired
    private IJzDutyUserService jzDutyUserService;

    @Autowired
    private IJzPlanService jzPlanService;


    @RequiresPermissions("sysusersystem:userl:view")
    @GetMapping()
    public String show()
    {
        return prefix + "/show";
    }


    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo shuLiang(){
        startPage();
        List<JzDutyUser> jlist = jzDutyUserService.selectShuLiang();
        return getDataTable(jlist);
    }
    /**
     * 查看详细信息
     */
    @GetMapping("/listById/{zbTime}")
    public String listId(@PathVariable("zbTime") String zbTime, ModelMap mmap)
    {
//        List<JzDutyUser> jlist =jzDutyUserService.selectList(zbTime);
//        mmap.put("jlist", jlist);
        mmap.put("zbTime",zbTime);
        return prefix + "/listById";
    }
    @PostMapping("/list/{zbTime}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("zbTime") String zbTime)
    {
        startPage();
        List<JzDutyUser> list  = jzDutyUserService.selectList(zbTime);
        return getDataTable(list);
    }
}
