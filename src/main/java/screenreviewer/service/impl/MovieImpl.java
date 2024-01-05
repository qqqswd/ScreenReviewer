package screenreviewer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import screenreviewer.mapper.MovieMapper;
import screenreviewer.pojo.Movie;
import screenreviewer.service.MovieService;

import java.util.List;

@Service
public class MovieImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public void addMovie(Movie movie) {
        movieMapper.addMovie(movie);
    }

    @Override
    public void delete(String movieId) {
        movieMapper.delete(movieId);
    }

    @Override
    public List<Movie> list() {
        return movieMapper.list();
    }

    @Override
    public void update(Movie movie) {
        movieMapper.update(movie);
    }

    @Override
    public List<Movie> sortList() {
        return movieMapper.sortList();
    }

    @Override
    public void addScore(String movieId) {
        movieMapper.addScore(movieId);
    }

    @Override
    public List<Movie> search(String searchWord) {
        return movieMapper.search(searchWord);
    }

    @Override
    public Movie getMovieById(String movieId) {
        return movieMapper.getMovieById(movieId);
    }
}
