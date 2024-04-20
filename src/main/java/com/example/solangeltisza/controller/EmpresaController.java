package com.example.solangeltisza.controller;

import com.example.solangeltisza.entity.EmpresaEntity;
import com.example.solangeltisza.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solangel/empresa")
@AllArgsConstructor

public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(
            summary = "Guardar una empresa",
            description = "Para utilizar el endPoint, es necesario enviar un objeto EmpresaEntity que será guardado en la base de datos después de pasar por un proceso de validación."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El código de estado HTTP 200 indica que la empresa se ha creado con éxito.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "El código de estado HTTP 400 indica que la solicitud es inválida.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error del servidor",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaEntity> crear(@RequestBody @Parameter EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.crear(empresaEntity));
    }
    @Operation(
            summary = "Buscar por Id",
            description = "Buscar una empresa por su identificador único (ID)."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El código de estado HTTP 200 indica que la consulta con el ID se ejecutó con éxito.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "El código de estado HTTP 400 indica que la solicitud con el ID proporcionado es inválida.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error del servidor",
                    content = @Content(mediaType = "application/json")
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmpresaEntity>> buscarPorId(@PathVariable @Parameter Long id){
        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    @Operation(
            summary = "Buscar por todas las empresas",
            description = "Se realizará la búsqueda en todas las empresas correspondientes."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El codigo HTTTP STATUS 200 significa que la consulta se ejecuto con exito",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "El código de estado HTTP 400 indica que la solicitud es inválida.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error del servidor",
                    content = @Content(mediaType = "application/json")
            )
    })
    @GetMapping("/todos")
    public ResponseEntity<List<EmpresaEntity>> buscarTodos(){
        return ResponseEntity.ok(empresaService.buscarTodos());
    }


    @Operation(
            summary = "actualizar por id",
            description = "Se actualizará utilizando el ID correspondiente."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El codigo HTTTP STATUS 200 significa que la consulta se ejecuto con exito (ACTUALIZADO)",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "El codigo HTTTP STATUS 400 significa que tu REQUEST es invalido (ERROR)",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error del servidor",
                    content = @Content(mediaType = "application/json")
            )
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable @Parameter Long id, @RequestBody @Parameter EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.actualizar(id, empresaEntity));
    }


    @Operation(
            summary = "Eliminar por id",
            description = "Por favor, ingrese el ID correspondiente que desea eliminar."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "El codigo HTTTP STATUS 200 significa que la eliminación se ejecuto con exito",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "El codigo HTTTP STATUS 400 significa que tu REQUEST es invalido (ERROR)",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error del servidor",
                    content = @Content(mediaType = "application/json")
            )
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmpresaEntity> eliminar(@PathVariable @Parameter Long id){
        return ResponseEntity.ok(empresaService.borrar(id));
    }
}
