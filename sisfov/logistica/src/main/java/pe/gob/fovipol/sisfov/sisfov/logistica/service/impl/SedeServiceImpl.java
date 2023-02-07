package pe.gob.fovipol.sisfov.sisfov.logistica.service.impl;


import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.SedeDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Sede;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.repository.SedeRepository;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.SedeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SedeServiceImpl implements SedeService {

    //private static final Logger Log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    @Autowired
    private SedeRepository sedeRepository;


    @Override
    public Page<Sede> findAll(Pageable pageable) {
        return sedeRepository.findAll(pageable);
    }

    @Override
    public List<SedeDto> findAll() {
        try{
            List<Sede> sedes = sedeRepository.findAll();
            List<SedeDto> sedeDtos = new ArrayList<>();
            if(sedes.size()>0){
                ModelMapper model = new ModelMapper();
                for (Sede sede: sedes) {
                    sedeDtos.add(model.map(sede,SedeDto.class));
                }
                return sedeDtos;
            }else{
                throw new NotFoundException("Aún no cuenta con registros en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public SedeDto findOrById(Long id) {
        try{
            Optional<Sede> sede = sedeRepository.findById(id);
            if(sede.isPresent()){
                ModelMapper model = new ModelMapper();
                SedeDto dto = model.map(sede.get(),SedeDto.class);
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
    public SedeDto crear(SedeDto sedeDto) {
        try {
            ModelMapper mp1= new ModelMapper();
            Sede sede = mp1.map(sedeDto,Sede.class);
            ModelMapper mp= new ModelMapper();
            SedeDto dto = mp.map(sedeRepository.save(sede), SedeDto.class);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public SedeDto actualizar(SedeDto sede, Long id) {
        try {
            Optional<Sede>sedeBuscada = sedeRepository.findById(id);

            if(sedeBuscada.isPresent()){
                Sede sedeDB = sedeBuscada.get();

                sedeDB.setDescripcionSede(sede.getDescripcionSede());
                sedeDB.setDescCortaSede(sede.getDescCortaSede());
                sedeDB.setDireccionSede(sede.getDireccionSede());
                sedeDB.setEstadoSede(sede.getEstadoSede());
                sedeDB.setPersonaContacto(sede.getPersonaContacto());
                sedeDB.setTelefono(sede.getTelefono());



                ModelMapper mp = new ModelMapper();
                SedeDto dto = mp.map(sedeRepository.save(sedeDB), SedeDto.class);
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
            Optional<Sede> sede = sedeRepository.findById(id);
            if(sede.isPresent()){
                sedeRepository.delete(sede.get());
            }else{
                throw new NotFoundException("El recurso no se encuentra en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
