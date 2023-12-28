package screenreviewer.mapper;

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
}
