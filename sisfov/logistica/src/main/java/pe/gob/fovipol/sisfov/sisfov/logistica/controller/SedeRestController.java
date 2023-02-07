package pe.gob.fovipol.sisfov.sisfov.logistica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.SedeDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.response.ApiResponse;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.SedeService;
import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/sedes")
@CrossOrigin(origins = {"http://localhost:8090"})
public class SedeRestController {


    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private SedeService sedeService;

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<SedeDto> sedesDtos = sedeService.findAll();
            return apiResponse.successResponse(sedesDtos, HttpStatus.OK);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }

    @GetMapping("/paginable")
    public ResponseEntity<?> index(@PageableDefault(sort = "descripcionSede", size = 10) Pageable pageable) {
        return apiResponse.successResponse(sedeService.findAll(pageable),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Long id){
        try {
            SedeDto response=sedeService.findOrById(id);
            return apiResponse.successResponse(response,HttpStatus.OK);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody SedeDto sedeDto, BindingResult result) {
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }

        try {
            return apiResponse.successResponse(sedeService.crear(sedeDto),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?>actualizar(@Validated @RequestBody SedeDto sedeDto, @PathVariable Long id, BindingResult result){
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }
        try {
            return apiResponse.successResponse(sedeService.actualizar(sedeDto,id),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            sedeService.eliminar(id);
            return apiResponse.successResponseStatus("Recurso eliminado con éxito.",HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }


}


