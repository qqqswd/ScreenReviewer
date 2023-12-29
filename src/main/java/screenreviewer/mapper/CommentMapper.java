package screenreviewer.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import screenreviewer.pojo.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
    /** 根据id查询当前电影所有评论 */
    @Select("select * from comment where movie_id = #{movieId}")
    List<Comment> getById(String movieId);

    /** 更具当前评论id删除评论 */
    @Delete("delete from comment where comment_id = #{commentID}")
    void delete(String commentId);
}
