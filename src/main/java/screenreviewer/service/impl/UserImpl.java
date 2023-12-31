package screenreviewer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import screenreviewer.mapper.UserMapper;
import screenreviewer.pojo.User;
import screenreviewer.service.UserService;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public void status(String userId, int status) {
        userMapper.status(userId, status);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User login(User user) {
        return userMapper.getByUserIdAndPassword(user);
    }
}
