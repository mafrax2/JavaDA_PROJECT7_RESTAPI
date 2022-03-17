package com.nnk.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "rulename")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RuleName {
    // TODO: Map columns in data table RULENAME with corresponding java fields
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Username is mandatory")
    private String name;
    @NotBlank(message = "Username is mandatory")
    private String description;
    @NotBlank(message = "Username is mandatory")
    private String json;
    @NotBlank(message = "Username is mandatory")
    private String template;
    @NotBlank(message = "Username is mandatory")
    private String sqlStr;
    @NotBlank(message = "Username is mandatory")
    private String sqlPart;

    public RuleName(String ruleName, String description, String json, String template, String sql, String sqlPart) {
            this.name = ruleName;
            this.description = description;
            this.json=json;
            this.template =template;
            this.sqlStr = sql;
            this.sqlPart = sqlPart;

    }
}
