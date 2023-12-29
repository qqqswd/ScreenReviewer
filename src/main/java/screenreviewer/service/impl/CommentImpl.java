package screenreviewer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import screenreviewer.mapper.CommentMapper;
import screenreviewer.pojo.Comment;
import screenreviewer.service.CommentService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getById(String movieId) {
        return commentMapper.getById(movieId);
    }

    @Override
    public void delete(int commentId) {
        commentMapper.delete(commentId);
    }

    @Override
    public void add(Comment comment) {
        comment.setCreateTime(LocalDateTime.now());
        commentMapper.add(comment);
    }
}
