package pe.gob.fovipol.sisfov.sisfov.logistica.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.SearchRequest;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.SearchSpecification;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Empresa;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Entidad;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.repository.EntidadRepository;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EntidadDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.EntidadService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntidadServiceImpl implements EntidadService {

    @Autowired
    EntidadRepository entidadRepository;
    @Override
    public Page<EntidadDto> findAll(EntidadDto spec, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Entidad> searchEntidades(SearchRequest request) {
        SearchSpecification<Entidad> specification = new SearchSpecification<>(request);
        int page = request.getPage()==null?1:request.getPage();
        long total = this.count();
        long defauld = this.count()==0?3:total;
        long size = request.getSize()==null?defauld:request.getSize();

        Pageable pageable = SearchSpecification.getPageable(page, request.getSize());
        return entidadRepository.findAll(specification, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Entidad> findAll(Pageable pageable) {
        return entidadRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntidadDto> findAll() {
        try{
            List<Entidad> entidades = entidadRepository.findAll();
            List<EntidadDto> entidadDtos = new ArrayList<>();
            if(entidades.size()>0){
                ModelMapper model = new ModelMapper();
                for (Entidad entidad: entidades) {
                    entidadDtos.add(model.map(entidad,EntidadDto.class));
                }
                return entidadDtos;
            }else{
                throw new NotFoundException("Aún no cuenta con registros en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public EntidadDto findOrById(String id) {
        try{
            Optional<Entidad> entidad = entidadRepository.findById(id);
            if(entidad.isPresent()){
                ModelMapper model = new ModelMapper();
                EntidadDto dto = model.map(entidad.get(),EntidadDto.class);
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
    public EntidadDto crear(EntidadDto entidadDto) {
        try {
            ModelMapper mp1= new ModelMapper();
            Entidad entidad = mp1.map(entidadDto,Entidad.class);
            ModelMapper mp= new ModelMapper();
            EntidadDto dto = mp.map(entidadRepository.save(entidad), EntidadDto.class);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public EntidadDto actualizar(EntidadDto entidad, String id) {
        try {
            Optional<Entidad>entidadBuscada = entidadRepository.findById(id);

            if(entidadBuscada.isPresent()){
                Entidad entidadDB   = entidadBuscada.get();

                entidadDB.setNombreEntidad(entidad.getNombreEntidad());
                entidadDB.setDescripcionEntidad(entidad.getDescripcionEntidad());
                entidadDB.setEstadoEntidad(entidad.getEstadoEntidad());
                entidadDB.setUsuarioCreador(entidad.getUsuarioCreador());

                ModelMapper mp = new ModelMapper();
                EntidadDto dto = mp.map(entidadRepository.save(entidadDB), EntidadDto.class);
                return dto;

            }else{
                throw new NotFoundException("El recurso no se actualizó.");
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(String id) {

        try{
            Optional<Entidad> entidad = entidadRepository.findById(id);
            if(entidad.isPresent()){
                entidadRepository.delete(entidad.get());
            }else{
                throw new NotFoundException("El recurso no se encuentra en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



    @Override
    public long count() {
        return entidadRepository.count();
    }
}
