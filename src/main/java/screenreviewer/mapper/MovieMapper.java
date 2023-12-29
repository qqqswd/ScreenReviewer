package screenreviewer.mapper;

import org.apache.ibatis.annotations.*;
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

    /** 根据影片评分排序查询 */
    @Select("select * from movie order by score desc ")
    List<Movie> sortList();

    /** 根据影片id查询并计算所有评分均值并插入影片信息 */
    @Update("UPDATE movie m \n" +
            "SET m.score = COALESCE((\n" +
            "    SELECT AVG(c.score)\n" +
            "    FROM comment c\n" +
            "    WHERE c.movie_id = m.movie_id \n" +
            "), 0)\n" +
            "WHERE m.movie_id = #{movieId};\n")
    void addScore(String movieId);

    @Select("SELECT * FROM movie WHERE title LIKE CONCAT('%', #{searchWord}, '%')")
    List<Movie> search(String searchWord);
}
