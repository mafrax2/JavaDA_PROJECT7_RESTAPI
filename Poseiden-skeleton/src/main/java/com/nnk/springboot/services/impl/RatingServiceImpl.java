package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository repository;

    public RatingServiceImpl(RatingRepository repository) {
        this.repository = repository;
    }


    public List<Rating> getAllRatings(){
        return repository.findAll();
    }

    public Rating getRatingById(int id) {
        return repository.getById(id);
    }

    public Rating saveRating(Rating rating) {
        return repository.save(rating);
    }

    public void deleteRating(int id){
        repository.deleteById(id);
    }

}
