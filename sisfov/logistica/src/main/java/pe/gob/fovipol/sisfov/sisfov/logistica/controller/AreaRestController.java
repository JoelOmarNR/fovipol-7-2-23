package pe.gob.fovipol.sisfov.sisfov.logistica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.AreaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.response.ApiResponse;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.AreaService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/areas")
@CrossOrigin(origins = {"http://localhost:8090"})
public class AreaRestController {


    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private AreaService areaService;


    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<AreaDto> areaDtos = areaService.findAll();
            return apiResponse.successResponse(areaDtos, HttpStatus.OK);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }
    @GetMapping("/paginable")
    public ResponseEntity<?> index(@PageableDefault(sort = "descripcionArea", size = 10) Pageable pageable) {
        return apiResponse.successResponse(areaService.findAll(pageable),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Long id){
        try {
            AreaDto response=areaService.findOrById(id);
            return apiResponse.successResponse(response,HttpStatus.OK);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> crear(@Validated @RequestBody AreaDto areaDto, BindingResult result){
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }
        try {
            return apiResponse.successResponse(areaService.crear(areaDto),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<?>actualizar(@Validated @RequestBody AreaDto areaDto, @PathVariable Long id, BindingResult result){
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }
        try {
            return apiResponse.successResponse(areaService.actualizar(areaDto,id),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            areaService.eliminar(id);
            return apiResponse.successResponseStatus("Recurso eliminado con éxito.",HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }
}
