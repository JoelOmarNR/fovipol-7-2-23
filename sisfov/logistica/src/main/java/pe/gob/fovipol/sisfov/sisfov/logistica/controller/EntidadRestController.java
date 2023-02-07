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
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EntidadDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.response.ApiResponse;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.EntidadService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/entidades")
@CrossOrigin(origins = {"http://localhost:8090"})
public class EntidadRestController {

    @Autowired
    private ApiResponse apiResponse;
    @Autowired
    private EntidadService entidadService;

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<EntidadDto> entidadDtos = entidadService.findAll();
            return apiResponse.successResponse(entidadDtos, HttpStatus.OK);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }

    @PostMapping("/paginableFilters")
    public ResponseEntity<?> search(@RequestBody SearchRequest request) {
        return apiResponse.successResponse(entidadService.searchEntidades(request),HttpStatus.OK);
    }

    @GetMapping("/paginable")
    public ResponseEntity<?> index(@PageableDefault(sort = "nombreEntidad", size = 10) Pageable pageable) {
        return apiResponse.successResponse(entidadService.findAll(pageable),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable String id){
        try {
            EntidadDto response=entidadService.findOrById(id);
            return apiResponse.successResponse(response,HttpStatus.OK);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody EntidadDto entidadDto, BindingResult result){
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }
        try {
            return apiResponse.successResponse(entidadService.crear(entidadDto),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>actualizar(@Validated @RequestBody EntidadDto entidadDto, @PathVariable String id, BindingResult result){
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }
        try {
            return apiResponse.successResponse(entidadService.actualizar(entidadDto,id),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id){
        try {
            entidadService.eliminar(id);
            return apiResponse.successResponseStatus("Recurso eliminado con éxito.",HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }



}
