package pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.entity.RolPersonalizado;


@Repository
public interface RolPersRepository extends JpaRepository<RolPersonalizado, Integer> {
}
