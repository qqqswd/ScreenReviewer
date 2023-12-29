package screenreviewer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import screenreviewer.pojo.Admin;

@Mapper
public interface AdminMapper {
    /** 根据管理员id和密码查询管理员账户 */
    @Select("select * from admin where admin_id = #{adminId} and password = #{password}")
    Admin getByAdminIdAndPassword(Admin admin);
}
