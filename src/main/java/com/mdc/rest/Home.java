package com.mdc.rest;

import com.mdc.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Home {

    private static final Logger LOGGER = LoggerFactory.getLogger(Home.class);

    @GetMapping("/")
    public ResponseEntity<Status> indexPage() {
        return new ResponseEntity<>(Status.builder().name("Demo").releaseDate("Today").version("1.0.0").build(), HttpStatus.OK);
    }
}
