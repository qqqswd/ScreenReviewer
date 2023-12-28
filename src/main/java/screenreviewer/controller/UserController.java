package screenreviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import screenreviewer.pojo.Result;
import screenreviewer.pojo.User;
import screenreviewer.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public Result list() {
        log.info("查询全部用户数据");

        List<User> userList = userService.list();
        return Result.success(userList);
    }
}
