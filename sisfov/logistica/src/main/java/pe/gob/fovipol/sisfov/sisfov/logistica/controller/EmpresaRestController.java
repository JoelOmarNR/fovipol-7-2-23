package pe.gob.fovipol.sisfov.sisfov.logistica.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.SearchRequest;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EntidadDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.response.ApiResponse;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.EmpresaService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = {"http://localhost:8090"})
public class EmpresaRestController {

    @Autowired
    private ApiResponse apiResponse;

    @Autowired
    private EmpresaService empresaService;


    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<EmpresaDto> empresaDtos = empresaService.findAll();
            return apiResponse.successResponse(empresaDtos, HttpStatus.OK);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }


    @GetMapping("/paginable")
    public ResponseEntity<?> index(@PageableDefault(sort = "razonSocial", size = 10) Pageable pageable) {
        return apiResponse.successResponse(empresaService.findAll(pageable),HttpStatus.OK);
    }

    @PostMapping("/paginableFilters")
    public ResponseEntity<?> search(@RequestBody SearchRequest request) {
        return apiResponse.successResponse(empresaService.searchEmpresas(request),HttpStatus.OK);
    }




    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Long id){
      try {
          EmpresaDto response=empresaService.findOrById(id);
          return apiResponse.successResponse(response,HttpStatus.OK);
      }catch (Exception e){
          return apiResponse.errorResponse(e.getMessage());
      }
    }


    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody EmpresaDto empresaDto, BindingResult result){
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }
        try {
            return apiResponse.successResponse(empresaService.crear(empresaDto),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>actualizar(@Validated @RequestBody EmpresaDto empresaDto,@PathVariable Long id, BindingResult result){
        if (result.hasErrors()) {
            return apiResponse.validar(result);
        }
        try {
            return apiResponse.successResponse(empresaService.actualizar(empresaDto,id),HttpStatus.CREATED);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            empresaService.eliminar(id);
            return apiResponse.successResponseStatus("Recurso eliminado con éxito.",HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return apiResponse.errorResponse(e.getMessage());
        }
    }
}
