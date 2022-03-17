package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

     List<Rating> getAllRatings();

     Rating getRatingById(int id);

     Rating saveRating(Rating rating);

     void deleteRating(int id);

}
