package screenreviewer.service;

import screenreviewer.pojo.Movie;

import java.util.List;

public interface MovieService {
    void addMovie(Movie movie);

    void delete(String movieId);

    List<Movie> list();

    void update(Movie movie);

    List<Movie> sortList();

    void addScore(String movieId);

    List<Movie> search(String searchWord);
}
