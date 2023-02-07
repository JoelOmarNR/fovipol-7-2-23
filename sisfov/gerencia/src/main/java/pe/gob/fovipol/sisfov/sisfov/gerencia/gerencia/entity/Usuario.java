package pe.gob.fovipol.sisfov.sisfov.gerencia.gerencia.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idUsuario")
    private @Getter @Setter Integer id;
    private @Getter @Setter String nombre;
    private @Getter @Setter String correo;


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
