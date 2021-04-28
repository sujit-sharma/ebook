package com.sujit.bookcatalogservice.resources;

import com.sujit.bookcatalogservice.models.Book;
import com.sujit.bookcatalogservice.models.CatalogItem;
import com.sujit.bookcatalogservice.models.Rating;
import com.sujit.bookcatalogservice.models.UserRating;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog")
public class BookCatalogResources {
    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId ) {
        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId,
                UserRating.class);


        WebClient.Builder builder = WebClient.builder();
       return ratings.getUserRating().stream().map(rating -> {
            Book book = restTemplate.getForObject("http://localhost:8082/books/" + rating.getBookId(), Book.class );



           return  new CatalogItem(book.getName(), "Beginners to expert in programming", rating.getRating());
       })
       .collect(Collectors.toList());

    }
//    Book book = webClientBuilder.build()
//            .get()
//            .uri("http://localhost:8082/books/" + rating.getBookId())
//            .retrieve()
//            .bodyToMono(Book.class)
//            .block();


}
