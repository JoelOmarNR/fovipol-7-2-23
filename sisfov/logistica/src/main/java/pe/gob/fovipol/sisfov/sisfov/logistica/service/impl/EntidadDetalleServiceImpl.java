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
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.EntidadDetalle;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.repository.EntidadDetalleRepository;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EntidadDetalleDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.EntidadDetalleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntidadDetalleServiceImpl implements EntidadDetalleService {

    @Autowired
    private EntidadDetalleRepository entidadDetalleRepository;


    @Override
    public Page<EntidadDetalleDto> findAll(EntidadDetalleDto spec, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EntidadDetalle> searchEntidadDetalle(SearchRequest request) {
        SearchSpecification<EntidadDetalle> specification = new SearchSpecification<>(request);
        int page = request.getPage()==null?1:request.getPage();
        //int size = request.getSize()==null?1:request.getSize();
        long total = this.count();
        long defauld = this.count()==0?3:total;
        long size = request.getSize()==null?defauld:request.getSize();

        Pageable pageable = SearchSpecification.getPageable(page, request.getSize());
        return entidadDetalleRepository.findAll(specification, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EntidadDetalle> findAll(Pageable pageable) {
        return entidadDetalleRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntidadDetalleDto> findAll() {
        try{
            List<EntidadDetalle> entidadDetalles = entidadDetalleRepository.findAll();
            List<EntidadDetalleDto> entidadDetalleDtos = new ArrayList<>();
            if(entidadDetalles.size()>0){
                ModelMapper model = new ModelMapper();
                for (EntidadDetalle entidadDetalle: entidadDetalles) {
                    entidadDetalleDtos.add(model.map(entidadDetalle,EntidadDetalleDto.class));
                }
                return entidadDetalleDtos;
            }else{
                throw new NotFoundException("Aún no cuenta con registros en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public EntidadDetalleDto findOrById(Long id) {
        try{
            Optional<EntidadDetalle> entidadDetalle = entidadDetalleRepository.findById(id);
            if(entidadDetalle.isPresent()){
                ModelMapper model = new ModelMapper();
                EntidadDetalleDto dto = model.map(entidadDetalle.get(),EntidadDetalleDto.class);
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
    public EntidadDetalleDto crear(EntidadDetalleDto entidadDetalleDto) {
        try {
            ModelMapper mp1= new ModelMapper();
            EntidadDetalle entidadDetalle = mp1.map(entidadDetalleDto,EntidadDetalle.class);
            ModelMapper mp= new ModelMapper();
            EntidadDetalleDto dto = mp.map(entidadDetalleRepository.save(entidadDetalle), EntidadDetalleDto.class);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public EntidadDetalleDto actualizar(EntidadDetalleDto entidadDetalle, Long id) {
        try {
            Optional<EntidadDetalle>entidadDetalleBuscada = entidadDetalleRepository.findById(id);

            if(entidadDetalleBuscada.isPresent()){
                EntidadDetalle entidadDetalleDB = entidadDetalleBuscada.get();

                entidadDetalleDB.setCodigoEntidad(entidadDetalle.getCodigoEntidad());
                entidadDetalleDB.setDescripcionEntidadDetalle(entidadDetalle.getDescripcionEntidadDetalle());
                entidadDetalleDB.setSecuenciaEntidad(entidadDetalle.getSecuenciaEntidad());


                ModelMapper mp = new ModelMapper();
                EntidadDetalleDto dto = mp.map(entidadDetalleRepository.save(entidadDetalleDB), EntidadDetalleDto.class);
                return dto;

            }else{
                throw new NotFoundException("El recurso no se actualizó.");
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(Long id) {

        try{
            Optional<EntidadDetalle> entidadDetalle = entidadDetalleRepository.findById(id);
            if(entidadDetalle.isPresent()){
                entidadDetalleRepository.delete(entidadDetalle.get());
            }else{
                throw new NotFoundException("El recurso no se encuentra en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public long count() {
        return entidadDetalleRepository.count();
    }
}
