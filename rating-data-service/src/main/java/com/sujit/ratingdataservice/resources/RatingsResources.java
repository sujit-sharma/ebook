package com.sujit.ratingdataservice.resources;

import com.sujit.ratingdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResources {
    @RequestMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId ) {
        return new Rating(bookId, 5);
    }
}
