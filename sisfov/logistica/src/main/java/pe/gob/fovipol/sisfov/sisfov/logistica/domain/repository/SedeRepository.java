package pe.gob.fovipol.sisfov.sisfov.logistica.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede,Long> {
}
