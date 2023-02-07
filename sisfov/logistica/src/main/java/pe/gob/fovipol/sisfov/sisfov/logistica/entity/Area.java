package pe.gob.fovipol.sisfov.sisfov.logistica.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="T_MAE_AREA")
@ToString
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDEN_AREA_NU")
    private  @Getter
    @Setter Integer id;

    @Column(name="DESC_AREA_VC")
    private  @Getter  @Setter String descripcionArea;

    @Column(name="AREA_CORT_VC")
    private  @Getter  @Setter String descCortaArea;

    @Column(name="SEDE_FILIAL_VC")
    private  @Getter  @Setter String sedeFilial;

    @Column(name="TIPO_AREA_VC")
    private  @Getter  @Setter Integer tipoArea;
    @Column(name="DIRE_AREA_VC")
    private  @Getter  @Setter String direccionArea;
    @Column(name="NUME_TELE_VC")
    private  @Getter  @Setter String telefono;
    @Column(name="ANEX_AREA_NU")
    private  @Getter  @Setter String anexoArea;
    @Column(name="PERS_CONT_VC")
    private  @Getter  @Setter String personaContacto;
    @Column(name="FLAG_ESTA_NU")
    private  @Getter  @Setter Integer estadoEmpresa;

    @Column(name="USUA_CREA_VC")
    private  @Getter  @Setter String usuarioQueCreo;

    @Column(name="USUA_MODI_VC")
    private  @Getter  @Setter String usuarioQueModifico;

    @Column(name="HOST_AUDI_VC")
    private  @Getter  @Setter String hostNameAuditoria;

    @Column(name="FECH_CREA_DT")
    private @Getter  @Setter LocalDateTime fechaCreacion;

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


    @ManyToOne
    @JoinColumn(name = "IDEN_SEDE_NU", referencedColumnName = "IDEN_SEDE_NU")
    private  @Getter  @Setter Sede sede;


}
