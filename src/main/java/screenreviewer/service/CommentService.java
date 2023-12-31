package screenreviewer.service;

import screenreviewer.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getById(String movieId);

    void delete(int commentId);

    void add(Comment comment);
}
