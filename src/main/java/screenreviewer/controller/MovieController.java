package screenreviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import screenreviewer.pojo.Movie;
import screenreviewer.pojo.Result;
import screenreviewer.service.MovieService;

import java.util.List;

@Slf4j
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public Result add(@RequestBody Movie movie) {
        log.info("新增影片:{}", movie.getTitle());
        movieService.addMovie(movie);
        return Result.success();
    }

    @DeleteMapping("delete/{movieId}")
    public Result delete(@PathVariable String movieId) {
        log.info("根据id删除影片:{}", movieId);
        movieService.delete(movieId);
        return Result.success();
    }

    @GetMapping("/getMovie")
    public Result list() {
        log.info("查询全部影片数据");
        List<Movie> movieList = movieService.list();
        return Result.success(movieList);
    }

    @PutMapping("/updateMovie")
    public Result update(@RequestBody Movie movie) {
        log.info("更新影片信息:{}", movie.getMovieId());
        movieService.update(movie);
        return Result.success();
    }
}
