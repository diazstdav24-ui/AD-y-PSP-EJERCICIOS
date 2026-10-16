package com.salesianos.dam.primerjemplo.controller;

import com.salesianos.dam.primerjemplo.dto.EditProductDto;
import com.salesianos.dam.primerjemplo.dto.GetProductDetail;
import com.salesianos.dam.primerjemplo.dto.GetProductList;
import com.salesianos.dam.primerjemplo.model.Product;
import com.salesianos.dam.primerjemplo.repo.ProductRepository;
import com.salesianos.dam.primerjemplo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Tag(name="Product Controller", description = "Un controlador de productos")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;


    @Operation(
            summary = "Crear un nuevo producto producto",
            description = "Crea un nuevo producto en la bdd"
    )
    @ApiResponses(
            {
                    @ApiResponse(description = "Nuevo producto creado",
                            responseCode = "201",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = GetProductDetail.class)
                            )),
                    @ApiResponse(description = "Error el producto no pudo ser creado",
                            responseCode = "400",
                            content = @Content)
            }
    )
    @PostMapping
    public ResponseEntity<GetProductDetail> addProduct(@RequestBody EditProductDto product) {

        return ResponseEntity.status(201)
                .body(GetProductDetail.of(productService.addProduct(product)));

    }



    /**
     * GET /: devuelve todos los productos.
     * No entra ningún dato del cliente. El servicio devuelve una lista de entidades
     * Product, y con stream().map(GetProductList::of) cada una se convierte en un DTO
     * de salida resumido. Se responde 200 con la lista en el cuerpo.
     * Flujo: BD -> entidades -> DTOs de lista -> JSON
     */

    @Operation(
            summary = "Obtener todos los productos",
            description = "Permite obtener todos los productos del catálogo"
    )
    @ApiResponses(
            {
                    @ApiResponse(description = "Productos encontrados",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = GetProductList.class)
                            )),
                    @ApiResponse(description = "Los productos no se encuentran",
                            responseCode = "404",
                            content = @Content)
            }
    )
    @GetMapping
    public ResponseEntity<List<GetProductList>> getAllProducts() {

        List<Product> result = productService.getAllProducts();
        return ResponseEntity.ok(
                result
                        .stream()
                        .map(GetProductList::of)
                        .toList());
    }


    /**
     * GET /{id}: devuelve el detalle de un producto.
     * El id viaja en la URL y @PathVariable lo recoge. El servicio busca la entidad
     * (si no existe, lanza una excepción que debe acabar en 404). GetProductDetail.of(...)
     * la convierte en DTO de detalle y se responde 200.
     * Flujo: id de la URL -> entidad -> DTO de detalle -> JSON
     */

    @ApiResponses(
            {
                    @ApiResponse(description = "Obtener producto por ID",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = GetProductDetail.class)
                            )),
                    @ApiResponse(description = "Error el producto no pudo ser encontrado",
                            responseCode = "404",
                            content = @Content)
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<GetProductDetail> getProductById(@PathVariable Long id) {

        return ResponseEntity.ok(GetProductDetail.of(productService.getProductById(id)));

    }

    /**
     * PUT /{id}: modifica un producto existente.
     * Entran dos datos: el id por la URL (@PathVariable) y el JSON del cuerpo, que
     * @RequestBody convierte en EditProductDto. El servicio carga la entidad existente,
     * le copia los valores del DTO, la guarda y la devuelve. Esa entidad actualizada se
     * convierte en GetProductDetail y se responde 200.
     * Flujo: id + DTO de entrada -> entidad existente modificada -> entidad guardada
     *        -> DTO de salida -> JSON
     */

    @Operation(
            summary = "Actualizar el producto buscado",
            description = "Permite actualizar un producto"
    )
    @ApiResponses(
            {
                    @ApiResponse(description = "Producto actualizado",
                            responseCode = "201",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = GetProductDetail.class)
                            )),
                    @ApiResponse(description = "No se pudo crear",
                            responseCode = "400",
                            content = @Content),

                    @ApiResponse(description = "El producto no se encuentra",
                            responseCode = "404",
                            content = @Content)
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<GetProductDetail> updateProduct(
            @PathVariable Long id,
            @RequestBody EditProductDto product) {

        return ResponseEntity.ok(
                GetProductDetail.of(productService.updateProduct(id, product)));

    }

    @Operation(
            summary = "Obtener todos los productos",
            description = "Permite obtener todos los productos del catálogo"
    )
    @ApiResponses(
            {
                    @ApiResponse(description = "Producto borrado",
                            responseCode = "204"),

                    @ApiResponse(description = "El producto no se encuentra",
                            responseCode = "404")
            }
    )
    /**
     * DELETE /{id}: elimina un producto.
     * Solo entra el id por la URL. El servicio borra y no devuelve nada, así que no hay
     * entidad ni DTO de salida: por eso el tipo es Void y se responde 204 con
     * noContent().build(). Si el servicio no comprueba antes que el producto existe,
     * el 404 nunca llegará a producirse.
     * Flujo: id -> borrado -> respuesta vacía
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
