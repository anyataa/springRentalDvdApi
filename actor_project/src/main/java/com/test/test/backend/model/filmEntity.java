package com.test.test.backend.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "film")
public class filmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer film_id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "release_year")
    private Integer release_year;
    @Column(name = "language_id")
    private Integer language_id;
    @Column(name = "rental_duration")
    private Float rental_duration;
    @Column(name = "rental_rate")
    private Integer rental_rate;
    @Column(name = "length")
    private Integer length;
    @Column(name = "replacement_cost")
    private Float replacement;
    @Column(name = "rating")
    private String rating;
    @Column(name = "last_update")
    private Date last_name;
    @Column(name = "special_features")
    private String special_features;
    @Column(name = "fulltext")
    private String fulltext;
}
