package com.nnk.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "moodysRating is mandatory")
    private String moodysRating;
    @NotBlank(message = "sandPRating is mandatory")
    private String sandPRating;
    @NotBlank(message = "fitchRating is mandatory")
    private String fitchRating;
    @NotNull(message = "orderNumber is mandatory")
    private Integer orderNumber;


    public Rating(String moodysRating, String sandPRating, String fitchRating, int orderNumber) {
        this.moodysRating =moodysRating;
        this.sandPRating = sandPRating;
        this.fitchRating = fitchRating;
        this.orderNumber =orderNumber;
    }
    // TODO: Map columns in data table RATING with corresponding java fields
}
