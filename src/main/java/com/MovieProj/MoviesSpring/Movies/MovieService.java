package com.MovieProj.MoviesSpring.Movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;


    public List<Movies> getAllMovies(){
            return movieRepo.findAll();
    }

    public Movies getMovieById(ObjectId id) {
        return movieRepo.findById(id).orElse(null);

    }
    public Optional<Movies> getMovieByImdbId(String imdbId) {
        return movieRepo.findMovieByImdbId(imdbId);
    }
}
