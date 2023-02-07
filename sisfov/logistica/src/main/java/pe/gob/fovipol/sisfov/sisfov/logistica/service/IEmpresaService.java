package pe.gob.fovipol.sisfov.sisfov.logistica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.entity.Empresa;
import java.util.List;


public interface IEmpresaService {

  Page<Empresa> findAll(Pageable pageable);
  public List<EmpresaDto> findAll();
  public EmpresaDto findOrById(Long id);
  public EmpresaDto crear(EmpresaDto empresaDto);
  public EmpresaDto actualizar(EmpresaDto empresaDto,Long id);
  public void eliminar(Long id);

}
