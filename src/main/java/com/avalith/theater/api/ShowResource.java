package com.avalith.theater.api;


import com.avalith.theater.models.entity.Show;
import com.avalith.theater.models.service.IShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
