package com.test.test.backend.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "film_actor")
public class filmActorEntity {
    // @Column(name = "actor_id")
    // private Integer actor_id;
    // @Column(name = "film_id")
    // private Integer film_id;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private filmEntity filmEntity;
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private actorEntity actorEntity;
    @Column(name = "last_update")
    private Date last_update;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_actor_id")
    private Integer film_actor_id;

}