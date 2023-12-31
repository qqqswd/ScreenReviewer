package screenreviewer.service;

import screenreviewer.pojo.Admin;
import screenreviewer.pojo.User;

import java.util.List;

public interface UserService {
    /** 查询全部用户数据 */
    List<User> list();

    /** 修改当前用户账户状态 */
    void status(String userId, int status);

    void addUser(User user);

    User login(User user);
}
