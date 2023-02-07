package pe.gob.fovipol.sisfov.sisfov.logistica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.SearchRequest;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Empresa;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.EntidadDetalle;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EntidadDetalleDto;

import java.util.List;

public interface EntidadDetalleService {

    Page<EntidadDetalleDto> findAll(EntidadDetalleDto spec, Pageable pageable);

    public Page<EntidadDetalle> searchEntidadDetalle(SearchRequest request);

    Page<EntidadDetalle> findAll(Pageable pageable);
    public List<EntidadDetalleDto> findAll();
    public EntidadDetalleDto findOrById(Long id);
    public EntidadDetalleDto crear(EntidadDetalleDto entidadDetalleDto);
    public EntidadDetalleDto actualizar(EntidadDetalleDto entidadDetalleDto,Long id);
    public void eliminar(Long id);


    long count();
}
