package screenreviewer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import screenreviewer.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    /** 查询全部用户数据 */
    @Select("select user_id, user_name, status from user")
    List<User> list();
}
