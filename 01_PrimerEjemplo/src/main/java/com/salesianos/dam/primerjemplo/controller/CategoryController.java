package com.salesianos.dam.primerjemplo.controller;

import com.salesianos.dam.primerjemplo.dto.EditCategoryDto;
import com.salesianos.dam.primerjemplo.dto.GetCategoryDto;
import com.salesianos.dam.primerjemplo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;

    @GetMapping
    public List<GetCategoryDto> getAll() {
        return categoryService.getAll().stream()
                .map(GetCategoryDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public GetCategoryDto getById(@PathVariable Long id) {
        return GetCategoryDto.of(categoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<GetCategoryDto> createCategory(@RequestBody EditCategoryDto editCategoryDto) {
        return ResponseEntity.status(201)
                .body(GetCategoryDto.of(categoryService.addCategory(editCategoryDto)));
    }

    @PutMapping("/{id}")
    public GetCategoryDto editCategory(@PathVariable Long id,
                                       @RequestBody EditCategoryDto editCategoryDto) {
        return GetCategoryDto.of(categoryService.updateCategory(id, editCategoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}


