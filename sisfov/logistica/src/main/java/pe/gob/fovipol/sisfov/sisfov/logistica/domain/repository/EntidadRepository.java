package pe.gob.fovipol.sisfov.sisfov.logistica.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad,String>, JpaSpecificationExecutor<Entidad> {
}
