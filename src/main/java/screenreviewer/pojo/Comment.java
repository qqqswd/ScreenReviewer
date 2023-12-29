package screenreviewer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int commentId;
    private String userId;
    private String movieId;
    private String comment;
    private double score;
    private LocalDateTime createTime;
}
