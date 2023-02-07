package pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="T_MAE_EMPRESA")
@ToString
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDEN_EMPR_NU")
    private @Getter  @Setter Long id;
    @Column(name="CODI_EMPR_VC")
    private @Getter  @Setter String codigoEmpresa;
    //@NotBlank
    //@NotEmpty(message = "La razón social es obligatorio")
    @Column(name="RAZO_SOCI_VC")
    private @Getter  @Setter  String razonSocial;
    @Column(name="NOMB_COME_VC")
    private @Getter  @Setter  String nombreComercial;
    @Column(name="DIRE_EMPR_VC")
    private @Getter  @Setter  String direccion;
    @Column(name="NUME_RUCT_VC")
    private @Getter  @Setter  String  ruc;
    @Column(name="GIRO_NEGO_NU")
    private @Getter  @Setter  Integer giroNegocio;
    @Column(name="REPR_LEGA_VC")
    private @Getter  @Setter  String representanteLegal;
    @Column(name="CUEN_DETR_VC")
    private @Getter  @Setter  String cuentaDetraccion;
    @Column(name="NUME_TELE_VC")
    private @Getter  @Setter  String telefono;
    @Column(name="NUME_TEL2_VC")
    private @Getter  @Setter  String telefonoDos;
   @Column(name="CIUD_EMPR_VC")
   private @Getter  @Setter  Integer ciudadEmpresa;
   @Column(name="CIU2_EMPR_VC")
   private @Getter  @Setter  String ciudadEmpresaDos;
    @Column(name="PAGI_WEBT_VC")
    private @Getter  @Setter  String paginaWeb;
    @Column(name="CORR_ELEC_VC")
    private @Getter  @Setter  String correo;
    @Column(name="FLAG_RETE_NU")
    private @Getter  @Setter  Integer retencion;
    @Column(name="FLAG_COBR_CH")
    private @Getter  @Setter  String  canalCobranza;
    @Column(name="FLAG_ESTA_NU")
    private @Getter  @Setter  Integer estadoEmpresa;
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
    @JsonIgnore
   @Column(name="HOST_AUDI_VC")
   private @Getter  @Setter  String hostNameAuditoria;
    @JsonIgnore
   @Column(name="COND_CONT_NU")
   private @Getter  @Setter  Integer condicionContribuyente;
    @JsonIgnore
   @Column(name="ESTA_CONT_NU")
   private @Getter  @Setter  Integer estadoContribuyente;

    @PrePersist
    private  void asignarFechaCreacion() {
        fechaCreacion = LocalDateTime.now();
    }


    @PreUpdate
    private  void asignarFechaActualizacion() {
        fechaActualizacion = LocalDateTime.now();
    }

    /*
  @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
  @JsonIgnore
  private @Getter @Setter List<Sede> sedes;*/


}
