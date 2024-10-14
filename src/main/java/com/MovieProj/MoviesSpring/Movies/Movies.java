package com.MovieProj.MoviesSpring.Movies;


import com.MovieProj.MoviesSpring.Reviews.Reviews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;


//using lombok
@Document(collection="movies")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Movies {


    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    private List<Reviews> reviewIds;
//    private List<ObjectId> reviewIds;


}
