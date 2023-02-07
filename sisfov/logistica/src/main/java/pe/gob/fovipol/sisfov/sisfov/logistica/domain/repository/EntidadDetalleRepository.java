package pe.gob.fovipol.sisfov.sisfov.logistica.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.EntidadDetalle;

@Repository
public interface EntidadDetalleRepository extends JpaRepository<EntidadDetalle, Long>, JpaSpecificationExecutor<EntidadDetalle> {
}
