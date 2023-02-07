package pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.entity.Sistema;


@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Integer> {
}
