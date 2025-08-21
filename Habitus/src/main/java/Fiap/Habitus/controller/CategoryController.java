package Fiap.Habitus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import Fiap.Habitus.model.Category;


@RestController
public class CategoryController {

    @GetMapping("/categories")
    public List<Category> index(){

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Apartamento", "apartamento"));
        categories.add(new Category(2L, "Casa", "Casa"));
        categories.add(new Category(3L, "Moveis", "mobilia"));

        return categories;
        
    }
    
}
