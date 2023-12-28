package screenreviewer.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import screenreviewer.pojo.Movie;

import java.util.List;

@Mapper
public interface MovieMapper {
    /** 添加影片 */
    @Insert("insert into movie(movie_id, title, content, score, img) value(#{movieId}, #{title}, #{content}, #{score}, #{img}) ")
    void addMovie(Movie movie);

    /** 删除影片 */
    @Delete("delete from movie where movie_id = #{movieId}")
    void delete(String movieId);

    /** 查询所有影片信息 */
    @Select("select * from movie")
    List<Movie> list();

    /** 更新影片信息 */
    void update(Movie movie);
}
