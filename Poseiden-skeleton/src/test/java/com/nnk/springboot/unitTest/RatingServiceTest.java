package com.nnk.springboot.unitTest;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.RatingService;
import com.nnk.springboot.services.impl.RatingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {

    private List<Rating> ratings;
    @Mock
    private RatingRepository repository;


    private RatingService service;


    private static List<Rating> createRatings(){

        Rating rating1 = new Rating( "moodysRating1",  "sandPRating1",  "fitchRating1",  1);
        rating1.setId(1);
        Rating rating2 = new Rating("moodysRating2",  "sandPRating2",  "fitchRating2",  2);
        rating2.setId(2);
        Rating rating3 = new Rating("moodysRating3",  "sandPRating3",  "fitchRating3",  3);
        rating3.setId(3);
        Rating rating4 = new Rating("moodysRating4",  "sandPRating4",  "fitchRating4",  4);
        rating4.setId(4);

        List<Rating> ratings = Arrays.asList(rating1, rating2, rating3, rating4);
        return  ratings;

    }

    @BeforeEach
    private void setUpTests(){
        ratings = createRatings();
        service = new RatingServiceImpl(repository);
    }

    @Test
    public void getAllratingsTest(){
        when(repository.findAll()).thenReturn(ratings);

        List<Rating> list = createRatings();

        List<Rating> allRatings = service.getAllRatings();

        assertIterableEquals(list, allRatings);

    }

    @Test
    public void getRatingByidTest() throws Exception {

        when(repository.getById(any(Integer.class))).thenReturn(ratings.get(0));

        List<Rating> list = createRatings();

        Rating ratingById = service.getRatingById(1);

        assertEquals(list.get(0), ratingById);

    }


    @Test
    public void saveRatingTest(){

        Rating rating = new Rating("moodysRating5",  "sandPRating5",  "fitchRating5",  5);
        rating.setId(5);
        when(repository.save(any(Rating.class))).thenReturn(rating);

        Rating rating1 = service.saveRating(rating);

        assertEquals(rating, rating1);

    }

}
