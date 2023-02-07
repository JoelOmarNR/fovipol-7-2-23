package pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.entity.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value="select * from usuario where nombre=?1",nativeQuery=true)
    public abstract Usuario findByNombre(String nombre);

}
