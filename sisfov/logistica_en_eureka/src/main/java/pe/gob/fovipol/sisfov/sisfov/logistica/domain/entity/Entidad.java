package pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="T_MAE_ENTIDAD")
@ToString
public class Entidad {

    @Id
    @Column(name="CODI_ENTI_VC")
    private  @Getter  @Setter String id;

    @Column(name="NOMB_ENTI_VC")
    private @Getter  @Setter String nombreEntidad;

    @Column(name="DESC_ENTI_VC")
    private  @Getter  @Setter String descripcionEntidad;

    @Column(name="FLAG_ESTA_NU")
    private @Getter  @Setter Integer estadoEntidad;


    @Column(name="USUA_CREA_VC")
    private @Getter  @Setter  String usuarioCreador;
    @JsonIgnore
    @Column(name="USUA_MODI_VC")
    private @Getter  @Setter  String usuarioModificador;
    @JsonIgnore
    @Column(name="FECH_CREA_DT")
    private @Getter  @Setter LocalDateTime fechaCreacion;
    @JsonIgnore
    @Column(name="FECH_MODI_DT")
    private @Getter  @Setter LocalDateTime fechaActualizacion;

    @PrePersist
    private  void asignarFechaCreacion() {
        fechaCreacion = LocalDateTime.now();
    }


    @PreUpdate
    private  void asignarFechaActualizacion() {
        fechaActualizacion = LocalDateTime.now();
    }

    @JsonIgnore
    @Column(name="HOST_AUDI_VC")
    private @Getter  @Setter  String hostNameAuditoria;


}
