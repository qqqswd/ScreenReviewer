package screenreviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import screenreviewer.pojo.Admin;
import screenreviewer.pojo.Result;
import screenreviewer.pojo.User;
import screenreviewer.service.AdminService;
import screenreviewer.service.UserService;
import screenreviewer.utils.JwtUtils;


import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("用户登录：{}", user.getUserId());
        User u = userService.login(user);

        // 登录成功，生成令牌，下发令牌
        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getUserId());

            String jwt = JwtUtils.generateJwt(claims); // 包含当前登录的员工信息
            return  Result.success(jwt);
        }

        // 登录失败，返回错误信息
        return u != null?Result.success():Result.error("用户名或密码错误") ;
    }

    @PostMapping("/admin")
    public Result admin(@RequestBody Admin admin) {
        log.info("管理员登录：{}", admin.getAdminId());
        Admin a = adminService.adminLogin(admin);

        // 登录成功，生成令牌，下发令牌
        if (a != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", a.getAdminId());

            String jwt = JwtUtils.generateJwt(claims); // 包含当前登录的员工信息
            return  Result.success(jwt);
        }

        // 登录失败，返回错误信息
        return a != null?Result.success():Result.error("用户名或密码错误") ;
    }
}
