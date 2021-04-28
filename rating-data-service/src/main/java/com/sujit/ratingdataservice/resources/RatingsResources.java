package com.sujit.ratingdataservice.resources;

import com.sujit.ratingdataservice.models.Rating;
import com.sujit.ratingdataservice.models.UserRating;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ratingsdata")
public class RatingsResources {
 private final UserRating userRating = new UserRating();

    @RequestMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId ) {
        return new Rating(bookId, 5);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUser(@PathVariable("userId") String userId ) {
             List<Rating> ratings = Arrays.asList (
                new Rating("1111", 3),
                new Rating("2222", 4),
                new Rating("3333", 5)

             );
             userRating.setUserRating(ratings);
             return userRating;
    }
}
