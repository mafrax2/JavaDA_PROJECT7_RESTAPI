package com.nnk.springboot.domain;

//import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


@Entity
@Table(name = "curvepoint")
@Data
@AllArgsConstructor
public class CurvePoint {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "curveId is mandatory")
    private Integer curveId;
    private Timestamp asOfDate;
    @NotNull(message = "term is mandatory")
    private Double term;
    @NotNull(message = "value is mandatory")
    private Double value;
    private Timestamp creationDate;


    public CurvePoint(int i, double v, double v1) {
        this.curveId = i;
        this.term = v;
        this.value = v1;
    }

    public CurvePoint() {

    }
    // TODO: Map columns in data table CURVEPOINT with corresponding java fields
}
