package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repository.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pirates")
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;

    @RequestMapping( method = RequestMethod.GET)
    public void editPirate(){
        // Get the id of the pirate from url
        // Get the pirate from the database with that id
        // use the setters to change the properties
    }


}
