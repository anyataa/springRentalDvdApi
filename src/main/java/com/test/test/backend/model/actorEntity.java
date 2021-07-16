package com.test.test.backend.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.test.test.backend.service.actorService;

@Entity
@Table(name = "actor")
public class actorEntity implements actorService {
    private Integer actor_id;
    private String first_name;
    private String last_name;
    private Date last_update;

    public actorEntity() {
    }

    public actorEntity(Integer actor_id, String first_name, String last_name, Date last_update) {
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.last_update = last_update;
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getActor_Id() {
        return actor_id;
    }

    public void setActor_Id(Integer id) {
        this.actor_id = id;
    };

    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(name = "last_name", nullable = false, length = 45)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Column(name = "last_update", nullable = false)
    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    };

    @Override
    public String toString() {
        return "actorEntity [actor_id=" + actor_id + ", first_name=" + first_name + ", last_name=" + last_name
                + ", last_update=" + last_update + "]";
    }

    @Override
    public void setNameAndDate(String last_name, String first_name, Date date_actor) {
        // TODO Auto-generated method stub
        setFirst_name(first_name);
        setLast_name(last_name);
        setLast_update(date_actor);

    }

}
