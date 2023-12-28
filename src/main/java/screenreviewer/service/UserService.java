package screenreviewer.service;

import screenreviewer.pojo.User;

import java.util.List;

public interface UserService {
    /** 查询全部用户数据 */
    List<User> list();
}
