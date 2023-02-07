package pe.gob.fovipol.sisfov.sisfov.logistica.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.SearchRequest;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.SearchSpecification;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Entidad;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.EntidadDetalle;
import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EmpresaDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Empresa;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.repository.EmpresaRepository;

import pe.gob.fovipol.sisfov.sisfov.logistica.dto.EntidadDto;
import pe.gob.fovipol.sisfov.sisfov.logistica.service.EmpresaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmpresaServiceImpl implements EmpresaService {
   // private static final Logger Log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Page<EmpresaDto> findAll(EmpresaDto spec, Pageable pageable) {
      /*  ModelMapper model = new ModelMapper();
        Specification<Empresa> emp = (Specification<Empresa>) model.map(spec, Empresa.class);
        Page<Empresa> empresas = empresaRepository.findAll(emp,pageable);
        ModelMapper modelMapper = new ModelMapper();
        List<EmpresaDto> empresaDtos = new ArrayList<>();
        for (Empresa empresa: empresas) {
            empresaDtos.add(modelMapper.map(empresa,EmpresaDto.class));
        }
        Page<EmpresaDto> listaPaginable = new PageImpl<>(empresaDtos);
        return listaPaginable;*/
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Empresa> searchEmpresas(SearchRequest request) {
        SearchSpecification<Empresa> specification = new SearchSpecification<>(request);
        int page = request.getPage()==null?1:request.getPage();
        long total = this.count();
        long defauld = this.count()==0?3:total;
        long size = request.getSize()==null?defauld:request.getSize();

        Pageable pageable = SearchSpecification.getPageable(page, request.getSize());
        return empresaRepository.findAll(specification, pageable);
    }

    @Override
    public Page<Empresa> findAll(Pageable pageable) {
        return empresaRepository.findAll(pageable);
    }

    @Override
    public List<EmpresaDto> findAll() {
        try{
            List<Empresa> empresas = empresaRepository.findAll();
            List<EmpresaDto> empresaDtos = new ArrayList<>();
            if(empresas.size()>0){
                ModelMapper model = new ModelMapper();
                for (Empresa empresa: empresas) {
                    empresaDtos.add(model.map(empresa,EmpresaDto.class));
                }
                return empresaDtos;
            }else{
                throw new NotFoundException("Aún no cuenta con registros en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public EmpresaDto findOrById(Long id) {
        try{
            Optional<Empresa> empresa = empresaRepository.findById(id);
            if(empresa.isPresent()){
                ModelMapper model = new ModelMapper();
                EmpresaDto dto = model.map(empresa.get(),EmpresaDto.class);
                return dto;
            }else{
                throw new NotFoundException("El recurso no se encuentra en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /*@Override
    @Transactional(readOnly = true)
    public EmpresaDto findByRazonSocial(String razonSocial) {
        try{
            Optional<Empresa> empresa = empresaRepository.findByRazonSocial(razonSocial);
            if(empresa.isPresent()){
                ModelMapper model = new ModelMapper();
                EmpresaDto dto = model.map(empresa.get(),EmpresaDto.class);
                return dto;
            }else{
                throw new NotFoundException("El recurso no se encuentra en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }*/


    @Override
    public long count() {
        return empresaRepository.count();
    }


    @Override
    @Transactional
    public EmpresaDto crear(EmpresaDto empresaDto) {
        try {
            ModelMapper mp1= new ModelMapper();
            Empresa empresa = mp1.map(empresaDto,Empresa.class);
            ModelMapper mp= new ModelMapper();
            EmpresaDto dto = mp.map(empresaRepository.save(empresa), EmpresaDto.class);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    @Transactional
    public EmpresaDto actualizar(EmpresaDto empresa, Long id) {
        try {
            Optional<Empresa>empresaBuscada = empresaRepository.findById(id);
            
            if(empresaBuscada.isPresent()){
                Empresa empresaDB = empresaBuscada.get();

                empresaDB.setRazonSocial(empresa.getRazonSocial());
                empresaDB.setCodigoEmpresa(empresa.getCodigoEmpresa());
                empresaDB.setCorreo(empresa.getCorreo());
                empresaDB.setDireccion(empresa.getDireccion());
                empresaDB.setCanalCobranza(empresa.getCanalCobranza());
                empresaDB.setCuentaDetraccion(empresa.getCuentaDetraccion());
                empresaDB.setGiroNegocio(empresa.getGiroNegocio());
                empresaDB.setCuentaDetraccion(empresa.getCuentaDetraccion());
                empresaDB.setPaginaWeb(empresa.getPaginaWeb());
                empresaDB.setNombreComercial(empresa.getNombreComercial());
                empresaDB.setEstadoEmpresa(empresa.getEstadoEmpresa());
                empresaDB.setRetencion(empresa.getRetencion());
                empresaDB.setCiudadEmpresa(empresa.getCiudadEmpresa());
                empresaDB.setCuentaDetraccion(empresa.getCuentaDetraccion());
                empresaDB.setCanalCobranza(empresa.getCanalCobranza());
                ModelMapper mp = new ModelMapper();
                EmpresaDto dto = mp.map(empresaRepository.save(empresaDB), EmpresaDto.class);
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
            Optional<Empresa> empresa = empresaRepository.findById(id);
            if(empresa.isPresent()){
                empresaRepository.delete(empresa.get());
            }else{
                throw new NotFoundException("El recurso no se encuentra en la base de datos.");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


}
