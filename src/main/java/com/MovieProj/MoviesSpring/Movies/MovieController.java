package com.MovieProj.MoviesSpring.Movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    public ResponseEntity<String> AllMovie(){
        return new ResponseEntity<>("movies", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Movies>>  getAllMovie(){
        return new ResponseEntity<List<Movies>>(movieService.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable ObjectId id){
        Movies movies=movieService.getMovieById(id);
            if(movies!=null){

        return new ResponseEntity<>(movies,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Movies> getMovieByImdbId(@PathVariable String imdbId){
       Optional<Movies> movies=movieService.getMovieByImdbId(imdbId);
            if(movies.isPresent()){

        return new ResponseEntity<Movies>(movies.get(),HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
