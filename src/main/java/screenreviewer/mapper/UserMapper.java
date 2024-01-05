package screenreviewer.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import screenreviewer.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    /** 查询全部用户数据 */
    @Select("select user_id, user_name, status from user")
    List<User> list();

    /** 修改当前用户账户状态 */
    @Update("update user set status = #{status} where user_id = #{userId}")
    void status(String userId, int status);

    /** 添加用户，status默认为0 */
    @Insert("insert into user(user_id, user_name, password, status) " +
            "value(#{userId}, #{userName}, #{password}, 0) ")
    void addUser(User user);

    /** 根据用户id和密码来查询用户 */
    @Select("select * from user where user_id = #{userId} and password = #{password} and status = 1")
    User getByUserIdAndPassword(User user);
}
