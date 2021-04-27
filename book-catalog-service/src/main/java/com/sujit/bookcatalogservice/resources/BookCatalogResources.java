package com.sujit.bookcatalogservice.resources;

import com.sujit.bookcatalogservice.models.Book;
import com.sujit.bookcatalogservice.models.CatalogItem;
import com.sujit.bookcatalogservice.models.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResources {

    @GetMapping("/test2")
    public List<CatalogItem> getCatalog( ) {
        RestTemplate restTemplate = new RestTemplate();
        List<Rating> ratings = Arrays.asList(
                new Rating("1111", 3),
                new Rating("2222", 4),
                new Rating("3333", 5)

        );

       return ratings.stream().map(rating -> {
           Book book = restTemplate.getForObject("http://localhost:8082/books/" + rating.getBookId(), Book.class );

           return  new CatalogItem(book.getName(), "Beginners to expert in programming", rating.getRating());
       })
       .collect(Collectors.toList());

    }
    @GetMapping("/test")
    public String testing() {
        return "Working nice";
    }

}
