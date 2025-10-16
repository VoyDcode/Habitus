package Fiap.Habitus.controller;

import Fiap.Habitus.model.House;
import Fiap.Habitus.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private HouseRepository repository;

    @GetMapping
    public Page<House> listar(
            @RequestParam(required = false) String description,
            @RequestParam(required = false) BigDecimal rent,
            Pageable pageable
    ) {
        if (description != null && !description.isEmpty()) {
            return repository.findByDescriptionContainingIgnoreCase(description, pageable);
        } else if (rent != null) {
            return repository.findByRentLessThanEqual(rent, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }
}
