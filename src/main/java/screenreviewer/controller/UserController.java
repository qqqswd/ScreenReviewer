package screenreviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import screenreviewer.annotation.Log;
import screenreviewer.pojo.Result;
import screenreviewer.pojo.User;
import screenreviewer.service.UserService;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public Result list() {
        log.info("查询全部用户数据");
        List<User> userList = userService.list();
        return Result.success(userList);
    }

    @Log
    @PutMapping("/status")
    public Result status(@RequestBody User user) {
        log.info("修改当前用户状态");
        userService.status(user.getUserId(), user.getStatus());
        return Result.success();
    }

    @PostMapping("/addUser")
    public Result add(@RequestBody User user) {
        log.info("用户注册:{}",user.getUserName());
        userService.addUser(user);
        return Result.success();
    }
}
