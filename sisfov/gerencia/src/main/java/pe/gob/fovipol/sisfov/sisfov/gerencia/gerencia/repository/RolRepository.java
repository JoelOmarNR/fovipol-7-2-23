package pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.entity.Rol;


@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
}
