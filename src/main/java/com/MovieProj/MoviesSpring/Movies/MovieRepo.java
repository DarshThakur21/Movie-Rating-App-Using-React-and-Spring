package com.MovieProj.MoviesSpring.Movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MovieRepo extends MongoRepository<Movies, ObjectId> {
    Optional <Movies> findMovieByImdbId(String imdbId);

}
