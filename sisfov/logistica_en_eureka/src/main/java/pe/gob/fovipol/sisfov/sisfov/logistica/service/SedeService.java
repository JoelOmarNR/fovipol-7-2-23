package pe.gob.fovipol.sisfov.sisfov.logistica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.SedeDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Sede;
import java.util.List;


public interface SedeService {


    Page<Sede> findAll(Pageable pageable);
    public List<SedeDto> findAll();
    public SedeDto findOrById(Long id);
    public SedeDto crear(SedeDto sedeDto);
    public SedeDto actualizar(SedeDto sedeDto,Long id);
    public void eliminar(Long id);


}
