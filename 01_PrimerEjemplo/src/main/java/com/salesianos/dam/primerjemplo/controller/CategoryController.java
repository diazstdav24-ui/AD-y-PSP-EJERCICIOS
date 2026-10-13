package com.salesianos.dam.primerjemplo.controller;

import com.salesianos.dam.primerjemplo.dto.EditCategoryDto;
import com.salesianos.dam.primerjemplo.dto.GetCategoryDto;
import com.salesianos.dam.primerjemplo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;

    @Operation(
            summary = "Obtener todas las categorías",
            description = "Permite obtener todas las categorías del catálogo"
    )
    @ApiResponses({
            @ApiResponse(description = "Categorías encontradas",
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetCategoryDto.class))
                    )),
            @ApiResponse(description = "No hay categorías",
                    responseCode = "404",
                    content = @Content)
    })
    @GetMapping
    public List<GetCategoryDto> getAll() {
        return categoryService.getAll().stream()
                .map(GetCategoryDto::of)
                .toList();
    }

    @Operation(
            summary = "Obtener una categoría por ID",
            description = "Devuelve la categoría que tiene el id indicado"
    )
    @ApiResponses({
            @ApiResponse(description = "Categoría encontrada",
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GetCategoryDto.class)
                    )),
            @ApiResponse(description = "La categoría no se encuentra",
                    responseCode = "404",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public GetCategoryDto getById(@PathVariable Long id) {
        return GetCategoryDto.of(categoryService.getById(id));
    }

    @Operation(
            summary = "Crear una nueva categoría",
            description = "Crea una nueva categoría en la base de datos"
    )
    @ApiResponses({
            @ApiResponse(description = "Categoría creada",
                    responseCode = "201",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GetCategoryDto.class)
                    )),
            @ApiResponse(description = "Datos incorrectos, no se pudo crear",
                    responseCode = "400",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<GetCategoryDto> createCategory(@RequestBody EditCategoryDto editCategoryDto) {
        return ResponseEntity.status(201)
                .body(GetCategoryDto.of(categoryService.addCategory(editCategoryDto)));
    }

    @Operation(
            summary = "Editar una categoría",
            description = "Modifica la categoría que tiene el id indicado"
    )
    @ApiResponses({
            @ApiResponse(description = "Categoría actualizada",
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GetCategoryDto.class)
                    )),
            @ApiResponse(description = "Datos incorrectos, no se pudo actualizar",
                    responseCode = "400",
                    content = @Content),
            @ApiResponse(description = "La categoría no se encuentra",
                    responseCode = "404",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public GetCategoryDto editCategory(@PathVariable Long id,
                                       @RequestBody EditCategoryDto editCategoryDto) {
        return GetCategoryDto.of(categoryService.updateCategory(id, editCategoryDto));
    }

    @Operation(
            summary = "Borrar una categoría",
            description = "Elimina la categoría que tiene el id indicado"
    )
    @ApiResponses({
            @ApiResponse(description = "Categoría borrada",
                    responseCode = "204",
                    content = @Content),
            @ApiResponse(description = "La categoría no se encuentra",
                    responseCode = "404",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}


