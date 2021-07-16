package com.test.test.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.test.test.backend.model.ResourceNotFound;
import com.test.test.backend.model.actorEntity;
import com.test.test.backend.repository.actorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actorApi")
public class actorController {
    @Autowired(required = true)
    private actorRepository actorRepositoryList;

    // get all actor
    @GetMapping("/getActors")
    public List<actorEntity> getAllActor() {
        // return List<actorEntity> ;
        return actorRepositoryList.findAll();
    };

    // get actor by id
    @GetMapping("getActor/{actor_id}")
    public ResponseEntity<actorEntity> getActorbyId(@PathVariable(value = "actor_id") Integer actor_id)
            throws ResourceNotFound {
        actorEntity actor = actorRepositoryList.findById(actor_id)
                .orElseThrow(() -> new ResourceNotFound("actor with id = " + actor_id + " is not exist"));
        return ResponseEntity.ok().body(actor);

    }

    // put actor by id
    @PutMapping("/editActor/{actor_id}")
    public ResponseEntity<actorEntity> editActor(@PathVariable(value = "actor_id") Integer actor_id,
            @Valid @RequestBody actorEntity actor) throws ResourceNotFound {
        actorEntity actor_item = actorRepositoryList.findById(actor_id)
                .orElseThrow(() -> new ResourceNotFound("actor with id = " + actor_id));

        // --------------- With Service, easier and cleaner -------------
        actor_item.setNameAndDate(actor.getLast_name(), actor.getFirst_name(), actor.getLast_update());

        // ------------- Without Service ------------
        // actor_item.setFirst_name(actor.getFirst_name());
        // actor_item.setLast_name(actor.getLast_name());
        // actor_item.setLast_update(actor.getLast_update());
        // ------------------------------------------------------------

        actorRepositoryList.save(actor_item);
        return ResponseEntity.ok().body(actor_item);

    }

    // add actor
    @PostMapping("/createActor")
    public actorEntity createActor(@Valid @RequestBody actorEntity actor) {
        return actorRepositoryList.save(actor);
    }

    // delete actor
    @DeleteMapping("/deleteActor/{actor_id}")
    public Map<String, Boolean> deleteActor(@PathVariable(value = "actor_id") Integer actor_id)
            throws ResourceNotFound {

        actorEntity actor = actorRepositoryList.findById(actor_id)
                .orElseThrow(() -> new ResourceNotFound("ID cannot be found for =" + actor_id));
        actorRepositoryList.delete(actor);
        Map<String, Boolean> response = new HashMap<>();
        return response;

    }

    // get last name with @Query
    @GetMapping("/getActorsLastName")
    public List<String> getActorByLastName() {
        return actorRepositoryList.getActorLastName();
    };

    // get old actor
    @GetMapping("/getOldActor/{date}")
    public List<actorEntity> getOldActor(@PathVariable(value = "date") String date) {
        return actorRepositoryList.getOldActor(date);
    };

    // get based on param
    @GetMapping("/getActorLastNameBasedOnParam")
    public List<actorEntity> getActorByLastNameParam(@RequestParam("wanted_name") String wanted_name) {
        return actorRepositoryList.getActorLastNameBasedOnParam(wanted_name);

    }

}
