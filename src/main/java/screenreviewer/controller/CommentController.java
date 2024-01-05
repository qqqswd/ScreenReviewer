package screenreviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import screenreviewer.annotation.Log;
import screenreviewer.pojo.Comment;
import screenreviewer.pojo.Result;
import screenreviewer.service.CommentService;
import screenreviewer.service.MovieService;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private MovieService movieService;

    @Log
    @GetMapping("comment/{movieId}")
    public Result getById(@PathVariable String movieId) {
        log.info("查询当前影片所有评论和评分:{}", movieId);
        List<Comment> commentList = commentService.getById(movieId);
        return Result.success(commentList);
    }

    @Log
    @DeleteMapping("/delete")
    public Result delete(@RequestBody Comment comment) {
        log.info("根据评论id删除评论:{}", comment.getCommentId());
        commentService.delete(comment.getCommentId());
        movieService.addScore(comment.getMovieId());
        return Result.success();
    }

    @Log
    @PostMapping("/addComment")
    public Result add(@RequestBody Comment comment) {
        commentService.add(comment);
        movieService.addScore(comment.getMovieId());
        return Result.success();
    }
}
