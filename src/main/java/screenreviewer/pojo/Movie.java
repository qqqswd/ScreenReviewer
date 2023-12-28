package screenreviewer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String title;
    private String movieId;
    private String content;
    private double score;
    private String img;
}
