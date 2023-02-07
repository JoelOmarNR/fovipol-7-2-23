package pe.gob.fovipol.sisfov.sisfov.logistica.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.SearchRequest;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EntidadDetalleDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.response.ApiResponse;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.EntidadDetalleService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/entidaddetalles")
@CrossOrigin(origins = {"http://localhost:8090"})
public class EntidadDetalleRestController {

    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private EntidadDetalleService entidadDetalleService;

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<EntidadDetalleDto> entidadDetallesDtos = entidadDetalleService.findAll();
            return apiResponse.successResponse(entidadDetallesDtos, HttpStatus.OK);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }

    @PostMapping("/paginableFilters")
    public ResponseEntity<?> search(@RequestBody SearchRequest request) {
        return apiResponse.successResponse(entidadDetalleService.searchEntidadDetalle(request),HttpStatus.OK);
    }

    @GetMapping("/paginable")
    public ResponseEntity<?> index(@PageableDefault(sort = "codigoEntidad", size = 10) Pageable pageable) {
        return apiResponse.successResponse(entidadDetalleService.findAll(pageable),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Long id){
        try {
            EntidadDetalleDto response=entidadDetalleService.findOrById(id);
            return apiResponse.successResponse(response,HttpStatus.OK);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }



    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody EntidadDetalleDto entidadDetalleDto, BindingResult result){
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }
        try {
            return apiResponse.successResponse(entidadDetalleService.crear(entidadDetalleDto),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>actualizar(@Validated @RequestBody EntidadDetalleDto entidadDetalleDto, @PathVariable Long id, BindingResult result){
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }
        try {
            return apiResponse.successResponse(entidadDetalleService.actualizar(entidadDetalleDto,id),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            entidadDetalleService.eliminar(id);
            return apiResponse.successResponseStatus("Recurso eliminado con éxito.",HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }


}
