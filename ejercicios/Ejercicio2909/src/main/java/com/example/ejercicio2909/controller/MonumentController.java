package com.example.ejercicio2909.controller;

import com.example.ejercicio2909.model.Monument;
import com.example.ejercicio2909.model.MonumentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MonumentController {


    private final MonumentRepository monumentRepository;

    //GetAll
    @GetMapping("/monument")
    public ResponseEntity<List<Monument>> getAllMonuments(){

        List<Monument> result = monumentRepository.findAll();

        if (result.isEmpty()){

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(result);

    }

    @GetMapping("/monument/{id}")
    public ResponseEntity<Monument> getMonumentById(@PathVariable Long id){

        return ResponseEntity.of(monumentRepository.findById(id));

    }


    @PostMapping("monument")
    public ResponseEntity<Monument> addMonument (@RequestBody @Valid Monument monument){

        if (StringUtils.hasText(monument.getCodigoPais())){

            return ResponseEntity.ok()
                    .body(monumentRepository.save(monument));

        }

        return ResponseEntity.badRequest().build();

    }

    @PutMapping("/monument/{id}")
    public ResponseEntity<Monument> updateMonument(

            @PathVariable Long id,
            @RequestBody Monument monument

    ){

        return monumentRepository.findById(id)
                .map(m-> {

                    m.setCodigoPais(monument.getCodigoPais());
                    m.setDescripcion(monument.getDescripcion());
                    m.setLocalizacion(monument.getLocalizacion());
                    m.setNombreCiudad(monument.getNombreCiudad());
                    m.setNombreMonumento(monument.getNombreMonumento());
                    m.setNombrePais(monument.getNombrePais());
                    m.setUrlFoto(monument.getUrlFoto());

                    return ResponseEntity.ok(monumentRepository.save(m));

                }).orElse(ResponseEntity.notFound().build());


    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        monumentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
