package pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="T_MAE_SEDE")
@ToString
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDEN_SEDE_NU")
    private  @Getter  @Setter Long id;
    @Column(name="DESC_SEDE_VC")
    private  @Getter  @Setter String descripcionSede;

    @Column(name="DESC_CORT_VC")
    private  @Getter  @Setter String descCortaSede;

    @Column(name="DIRE_SEDE_VC")
    private  @Getter  @Setter String direccionSede;

    @Column(name="NUME_TELE_NU")
    private  @Getter  @Setter String telefono;

    @Column(name="PERS_CONT_VC")
    private  @Getter  @Setter String personaContacto;

    @Column(name="FLAG_ESTA_NU")
    private  @Getter  @Setter Integer estadoSede;

    @JsonIgnore
    @Column(name="USUA_CREA_VC")
    private  @Getter  @Setter String usuarioQueCreo;

    @JsonIgnore
    @Column(name="USUA_MODI_VC")
    private  @Getter  @Setter String usuarioQueModifico;

    @Column(name="FECH_CREA_DT")
    private @Getter @Setter LocalDateTime fechaCreacion;

    @JsonIgnore
    @Column(name="FECH_MODI_DT")
    private   @Getter  @Setter LocalDateTime fechaActualizacion;

    @PrePersist
    private void asignarFechaCreacion() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    private void asignarFechaActualizacion() {
        fechaActualizacion = LocalDateTime.now();
    }

    @JsonIgnore
    @Column(name="HOST_AUDI_VC")
    private @Getter @Setter String hostNameAuditoria;

    /*
    @JsonIgnore
   @ManyToOne
    @JoinColumn(name = "IDEN_EMPR_NU", referencedColumnName = "IDEN_EMPR_NU")
    private @Getter @Setter Empresa empresa;
    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL)
    private @Getter @Setter List<Area> areas;*/

}
