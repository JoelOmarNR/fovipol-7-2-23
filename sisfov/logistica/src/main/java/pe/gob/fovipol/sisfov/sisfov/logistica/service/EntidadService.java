package pe.gob.fovipol.sisfov.sisfov.logistica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.SearchRequest;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Empresa;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Entidad;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EntidadDto;

import java.util.List;

public interface EntidadService {
    Page<EntidadDto> findAll(EntidadDto spec, Pageable pageable);

    public Page<Entidad> searchEntidades(SearchRequest request);

    Page<Entidad> findAll(Pageable pageable);
    public List<EntidadDto> findAll();
    public EntidadDto findOrById(String id);
    public EntidadDto crear(EntidadDto entidadDto);
    public EntidadDto actualizar(EntidadDto entidadDto,String id);
    public void eliminar(String id);

    long count();
}
