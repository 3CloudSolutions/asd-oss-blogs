package com.threecloud.kitchenbff.controller;

import com.threecloud.kitchenbff.model.dto.HouseDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class HomeInventoryController {
    @GetMapping("/houses/1")
    public Mono<HouseDTO> getHouses() {
        return Mono.just(new HouseDTO("111 Main St.", "Cincinnati", "Ohio"));
    }

}
