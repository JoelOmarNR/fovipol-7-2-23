package pe.gob.fovipol.sisfov.sisfov.logistica.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Area;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Empresa;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.repository.AreaRepository;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.AreaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.AreaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {

     @Autowired
     private AreaRepository areaRepository;

    @Override
    public Page<Area> findAll(Pageable pageable) {
        return areaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AreaDto> findAll() {
        try{
            List<Area> areas = areaRepository.findAll();
            List<AreaDto> areaDtos = new ArrayList<>();
            if(areas.size()>0){
                ModelMapper model = new ModelMapper();
                for (Area area: areas) {
                    areaDtos.add(model.map(area,AreaDto.class));
                }
                return areaDtos;
            }else{
                throw new NotFoundException("Aún no cuenta con registros en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public AreaDto findOrById(Long id) {
        try{
            Optional<Area> area = areaRepository.findById(id);
            if(area.isPresent()){
                ModelMapper model = new ModelMapper();
                AreaDto dto = model.map(area.get(),AreaDto.class);
                return dto;
            }else{
                throw new NotFoundException("El recurso no se encuentra en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public AreaDto crear(AreaDto areaDto) {
        try {
            ModelMapper mp1= new ModelMapper();
            Area area = mp1.map(areaDto,Area.class);
            ModelMapper mp= new ModelMapper();
            AreaDto dto = mp.map(areaRepository.save(area), AreaDto.class);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public AreaDto actualizar(AreaDto area, Long id) {
        try {
            Optional<Area>areaBuscada = areaRepository.findById(id);

            if(areaBuscada.isPresent()){
                Area areaDB = areaBuscada.get();

                areaDB.setDescripcionArea(area.getDescripcionArea());
                areaDB.setAnexoArea(area.getAnexoArea());
                areaDB.setDireccionArea(area.getDireccionArea());
                areaDB.setDescCortaArea(area.getDescCortaArea());
                areaDB.setTipoArea(area.getTipoArea());
                areaDB.setTelefono(area.getTelefono());
                areaDB.setPersonaContacto(area.getPersonaContacto());
                areaDB.setEstadoArea(area.getEstadoArea());

                ModelMapper mp = new ModelMapper();
                AreaDto dto = mp.map(areaRepository.save(areaDB), AreaDto.class);
                return dto;

            }else{
                throw new NotFoundException("El recurso no se actualizó.");
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        try{
            Optional<Area> area = areaRepository.findById(id);
            if(area.isPresent()){
                areaRepository.delete(area.get());
            }else{
                throw new NotFoundException("El recurso no se encuentra en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
