package com.cq.wen.oneself.module.system.controller;




import com.cq.wen.oneself.common.core.domain.Result;
import com.cq.wen.oneself.module.system.entity.SysUser;
import com.cq.wen.oneself.module.system.service.SysUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * 用户信息表(SysUser)表控制层
 *
 * @author makejava
 * @since 2022-07-20 18:07:58
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController{
    /**
     * 服务对象
     */
    @Autowired
    private SysUserService sysUserService;

   @GetMapping("/info/{username}")
   public Result<SysUser> getUserInfo(@PathVariable("username") String username){
        SysUser sysUser =  sysUserService.queryUserName(username);
        return Result.ok(sysUser);
   }


   @PostMapping("/register")
   public Result<Boolean> registerUserInfo(@RequestBody SysUser sysUser){
       sysUserService.save(sysUser);
       return Result.ok(true);
    }

}

