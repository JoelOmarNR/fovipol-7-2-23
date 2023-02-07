package pe.gob.fovipol.sisfov.sisfov.logistica.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.*;


@Data
public class EmpresaDTO {


    @NotNull(message = "El código es obligatorio")
   // @Size(min = 3, max = 10, message = "El codigo debe tener {min} caracteres como mínimo y {max} caracteres como máximo")
    private @Getter  @Setter String codigoEmpresa;
    @NotEmpty(message = "es obligatorio")
    //@Pattern(regexp = "[a-z0-9-]+", message = "El slug debe tener un formato válido")
    private @Getter  @Setter  String razonSocial;
    @NotBlank(message = "es obligatoria")
    private @Getter  @Setter  String nombreComercial;
    @NotBlank(message = "es obligatoria")
    private @Getter  @Setter  String direccion;
    @NotBlank(message = "es obligatorio")
    private @Getter  @Setter  String ruc;

    private @Getter  @Setter  String giroNegocio;
    @Column(name="REPR_LEGA_VC")
    private @Getter  @Setter  String representanteLegal;


    @NotEmpty(message = "La cuenta detracción de la empresa es obligatorio")
    @Column(name="CUEN_DETR_VC")
    private @Getter  @Setter  String cuentaDetraccion;

    @Column(name="PAGI_WEBT_VC")
    private @Getter  @Setter  String paginaWeb;

    @Email(message= "Ingrese el formato correcto")
    @NotEmpty(message = "El correo es obligatorio")
    @Column(name="CORR_ELEC_VC")
    private @Getter  @Setter  String correo;


    @Column(name="FLAG_RETE_NU")
    private @Getter  @Setter  Integer retencion;
    @Column(name="FLAG_COBR_CH")
    private @Getter  @Setter  String  canalCobranza;
    @Column(name="FLAG_ESTA_NU")
    private @Getter  @Setter  Integer estadoEmpresa;

}
