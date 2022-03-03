package com.nnk.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "rating")
@Data
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String moodysRating;
    private String sandPRating;
    private String fitchRating;
    private Integer orderNumber;


    public Rating(String moodys_rating, String sand_pRating, String fitch_rating, int i) {

    }
    // TODO: Map columns in data table RATING with corresponding java fields
}
