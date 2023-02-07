package pe.gob.fovipol.sisfov.sisfov.logistica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.AreaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Area;

import java.util.List;

public interface AreaService {
    Page<Area> findAll(Pageable pageable);
    public List<AreaDto> findAll();

    public AreaDto findOrById(Long id);

    public AreaDto crear (AreaDto areaDto);
    public AreaDto actualizar(AreaDto areaDto, Long id);

    public void eliminar(Long id);

}
