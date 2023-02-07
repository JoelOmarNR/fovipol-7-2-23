package pe.gob.fovipol.sisfov.sisfov.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.fovipol.sisfov.sisfov.logistica.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
}
