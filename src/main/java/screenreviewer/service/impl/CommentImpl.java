package screenreviewer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import screenreviewer.mapper.CommentMapper;
import screenreviewer.pojo.Comment;
import screenreviewer.service.CommentService;

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
    public void delete(String commentId) {
        commentMapper.delete(commentId);
    }
}
