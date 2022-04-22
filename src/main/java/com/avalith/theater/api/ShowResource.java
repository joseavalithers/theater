package com.avalith.theater.api;


import com.avalith.theater.models.entity.Show;
import com.avalith.theater.models.service.IShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
@RequiredArgsConstructor
@Slf4j
public class ShowResource {
    private final IShowService showService;

    @GetMapping("/shows")
    public ResponseEntity<List<Show>> getShows(){
        return ResponseEntity.ok().body(showService.findAll());
    }

    @PostMapping("/show/save")
    public ResponseEntity<Show> saveShow(@RequestBody Show show){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/show/save").toUriString());
        return ResponseEntity.created(uri).body(showService.saveShow(show));
    }
    @GetMapping("/shows/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable("id") Long id){
        Optional<Show> show = Optional.ofNullable(showService.findById(id));
        return show.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

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
    @DeleteMapping("/show/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteShow(@PathVariable("id") Long id){
        try{
            showService.deleteById(id);
        }catch(EmptyResultDataAccessException e) {}
    }
}
