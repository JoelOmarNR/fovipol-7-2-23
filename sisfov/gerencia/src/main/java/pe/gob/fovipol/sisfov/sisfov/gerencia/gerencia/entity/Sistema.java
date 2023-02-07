package pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.entity;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name="sistema")
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sistemaId")
    private @Getter @Setter Integer id;
    private @Getter @Setter String nombre;
    private @Getter @Setter Integer estado;

    private @Getter @Setter String usuarioCreacion;
    private @Getter @Setter String usuarioModificacion;

    private @Getter @Setter LocalDateTime fechaCreacion;

    private @Getter @Setter LocalDateTime fechaActualizacion;

    @PrePersist
    private  void asignarFechaCreacion() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    private  void asignarFechaActualizacion() {
        fechaActualizacion = LocalDateTime.now();
    }


}
