package screenreviewer.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import screenreviewer.pojo.OperateLog;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    /** 插入日志记录 */
    @Insert("insert into operate_log(operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateUser}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    void insert(OperateLog log);

    /** 查询所有日志记录 */
    @Select("select operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time from operate_log")
    List<OperateLog> getLog();
}