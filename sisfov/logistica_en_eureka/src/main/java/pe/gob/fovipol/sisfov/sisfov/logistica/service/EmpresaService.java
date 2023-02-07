package pe.gob.fovipol.sisfov.sisfov.logistica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.SearchRequest;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.EntidadDetalle;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Empresa;
import java.util.List;


public interface EmpresaService {

  Page<EmpresaDto> findAll(EmpresaDto spec, Pageable pageable);

  public Page<Empresa> searchEmpresas(SearchRequest request);

  Page<Empresa> findAll(Pageable pageable);
  public List<EmpresaDto> findAll();
  public EmpresaDto findOrById(Long id);
  public EmpresaDto crear(EmpresaDto empresaDto);
  public EmpresaDto actualizar(EmpresaDto empresaDto,Long id);
  public void eliminar(Long id);


  long count();

}
