package pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="T_MAE_ENTIDAD_DETALLE")
@ToString
public class EntidadDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDEN_ENTD_NU")
    private @Getter @Setter Long id;
    @Column(name="CODI_ENTI_VC")
    private @Getter  @Setter String codigoEntidad;

    @Column(name="SEC_ENTD_NU")
    private @Getter  @Setter  Integer secuenciaEntidad;
    @Column(name="VALO_CAD1_VC")
    private @Getter  @Setter  String primerValorCadenaCorta;
    @Column(name="VALO_CAD2_VC")
    private @Getter  @Setter  String segundoValorCadenaCorta;
    @Column(name="VALO_CAD3_VC")
    private @Getter  @Setter  String tercerValorCadenaCorta;
    @Column(name="VALO_NUM1_NU")
    private @Getter  @Setter  Integer primerValorNumerico;

    @Column(name="VALO_NUM2_NU")
    private @Getter  @Setter  Integer segundoValorNumerico;

    @Column(name="VALO_NUM3_NU")
    private @Getter  @Setter  Integer tercerValorNumerico;


    @Column(name="VALO_DEC1_NU")
    private @Getter  @Setter BigDecimal primerValorDecimal;

    @Column(name="VALO_DEC2_NU")
    private @Getter  @Setter  BigDecimal segundoValorDecimal;

    @Column(name="VALO_DEC3_NU")
    private @Getter  @Setter  BigDecimal tercerValorDecimal;

    @Column(name="VALO_FEC1_DT")
    private @Getter  @Setter Date primerValorFecha;

    @Column(name="VALO_FEC2_DT")
    private @Getter  @Setter  Date segundoValorFecha;

    @Column(name="VALO_FEC3_DT")
    private @Getter  @Setter  Date tercerValorFecha;


    @Column(name="DESC_ENTD_VC")
    private @Getter  @Setter String descripcionEntidadDetalle;

    @Column(name="FLAG_ESTA_NU")
    private @Getter  @Setter  Integer estadoEntidadDetalle;

    @JsonIgnore
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
