package screenreviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import screenreviewer.pojo.Comment;
import screenreviewer.pojo.Result;
import screenreviewer.service.CommentService;

import java.util.List;

@Slf4j
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("comment/{movieId}")
    public Result getById(@PathVariable String movieId) {
        log.info("查询当前影片所有评论和评分:{}", movieId);
        List<Comment> commentList = commentService.getById(movieId);
        return Result.success(commentList);
    }

    @DeleteMapping("comment/{commentId}")
    public Result delete(@PathVariable String commentId) {
        log.info("根据学号删除学生:{}", commentId);
        commentService.delete(commentId);
        return Result.success();
    }
}
