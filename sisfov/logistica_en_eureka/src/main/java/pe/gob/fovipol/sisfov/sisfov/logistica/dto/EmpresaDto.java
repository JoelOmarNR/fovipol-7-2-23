package pe.gob.fovipol.sisfov.sisfov.logistica.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {
    private Long id;

    @NotNull(message = "es obligatorio")
    private String codigoEmpresa;
    @NotBlank
    @NotEmpty(message = "es obligatorio")
    private String razonSocial;
    @NotNull(message = "es obligatorio")
    private String nombreComercial;
    @NotNull(message = "es obligatorio")
    private String direccion;
    @NotNull(message = "es obligatorio")
    private String ruc;
    @NotNull(message = "es obligatorio")
    private Integer giroNegocio;
    @NotNull(message = "es obligatorio")
    private String representanteLegal;
    @NotNull(message = "es obligatorio")
    private String cuentaDetraccion;
    @NotNull(message = "es obligatorio")
    private String telefono;
    @NotNull(message = "es obligatorio")
    private  String telefonoDos;
    @NotNull(message = "es obligatorio")
    private  Integer ciudadEmpresa;
    private String ciudadEmpresaDos;
    @NotNull(message = "es obligatorio")
    private String paginaWeb;
    @NotNull(message = "es obligatorio")
    private String correo;
    @NotNull(message = "es obligatorio")
    private  Integer retencion;

    private String  canalCobranza;
    @NotNull(message = "es obligatorio")
    private Integer estadoEmpresa;

    @JsonIgnore
    private String usuarioCreador;
    @JsonIgnore
    private  String usuarioModificador;
    @JsonIgnore
    private LocalDateTime fechaCreacion;
    @JsonIgnore
    private LocalDateTime fechaActualizacion;
    @JsonIgnore
    private String hostNameAuditoria;
    @JsonIgnore
    private  Integer condicionContribuyente;
    @JsonIgnore
    private Integer estadoContribuyente;

}
