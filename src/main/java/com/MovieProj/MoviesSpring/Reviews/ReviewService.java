package com.MovieProj.MoviesSpring.Reviews;

import com.MovieProj.MoviesSpring.Movies.MovieRepo;
import com.MovieProj.MoviesSpring.Movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MovieRepo movieRepo;


    public Reviews createReviews(String reviewBody,String imdbId){
        Reviews reviews=reviewRepo.insert(new Reviews(reviewBody));


        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(reviews))
                .first();
        return reviews;


//        Optional<Movies> movies=movieRepo.findMovieByImdbId(imdbId);
//
//        if(movies.isPresent()){
//            Movies movie=movies.get();
//
//            if (movie.getReviewIds() != null){
//                movie.getReviewIds().add(reviews.getId());
//            }else{
//                movie.setReviewIds(List.of(reviews.getId()));
//            }
//            movieRepo.save(movie);
//        }
//
//        return reviews;




    }
}
