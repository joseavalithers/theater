package com.avalith.theater.api;


import com.avalith.theater.models.entity.Show;
import com.avalith.theater.models.service.IShowService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class ShowResource {
    private final IShowService showService;

    @Operation(operationId = "getShows", summary = "get all Shows")
    @GetMapping("/shows")
    public ResponseEntity<List<Show>> getShows(){
        return ResponseEntity.ok().body(showService.findAll());
    }

    @Operation(operationId = "getShowByName", summary = "get a Show from db with required name")
    @GetMapping("/show/{name}")
    public ResponseEntity<List<Show>> getShowByName(@PathVariable("name") String name){
        Optional<List<Show>> db = Optional.ofNullable(showService.findByName(name));
        return db.map(value-> new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Operation(operationId = "save", summary = "same a Show in the db")
    @PostMapping("/show/save")
    public ResponseEntity<Show> saveShow(@RequestBody Show show){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/show/save").toUriString());
        return ResponseEntity.created(uri).body(showService.saveShow(show));
    }

    @Operation(operationId = "getShowById", summary = "get a Show from Db with id required")
    @GetMapping("/shows/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable("id") Long id){
        Optional<Show> show = Optional.ofNullable(showService.findById(id));
        return show.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Operation(operationId = "patchShow", summary = "update data from a Show on Db")
    @PatchMapping("/show/{id}")
    public ResponseEntity<Show> patchShow(
            @PathVariable("id") Long id,
            @RequestBody Show patch){
        Show show = showService.findById(id);
        if (patch.getName() != null){
            show.setName(patch.getName());
        }
        if (patch.getPrice() != null){
            show.setPrice(patch.getPrice());
        }
        if (patch.getSchedule() != null){
            show.setSchedule(patch.getSchedule());
        }
        if (patch.getType() != null){
            show.setType(patch.getType());
        }
        showService.saveShow(show);
        return new ResponseEntity<>(show,HttpStatus.OK);
    }

    @Operation(operationId = "deleteShow",summary = "delete a Show from db")
    @DeleteMapping("/show/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteShow(@PathVariable("id") Long id){
        try{
            showService.deleteById(id);
        }catch(EmptyResultDataAccessException e) {}
    }
}
