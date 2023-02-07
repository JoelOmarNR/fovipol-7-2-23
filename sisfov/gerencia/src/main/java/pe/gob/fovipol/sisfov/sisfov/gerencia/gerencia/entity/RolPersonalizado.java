package pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity(name="rolPersonalizado")
public class RolPersonalizado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter Integer id;
    private @Getter @Setter String nomRolPersonalizado;
    private @Getter @Setter Integer nroEstado;

    private @Getter @Setter LocalDateTime fechaCreacion;

    private @Getter @Setter LocalDateTime fechaActualizacion;

    @PrePersist
    private void asignarFechaCreacion() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    private void asignarFechaActualizacion() {
        fechaActualizacion = LocalDateTime.now();
    }
}
