package pe.gob.fovipol.sisfov.sisfov.logistica.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AreaDto {
    private Long id;
    @NotNull(message = "es obligatorio")
    private  String descripcionArea;
    @NotNull(message = "es obligatorio")
    private  String descCortaArea;
    @NotNull(message = "es obligatorio")
    private   Integer tipoArea;
    @NotNull(message = "es obligatorio")
    private   String direccionArea;
    @NotNull(message = "es obligatorio")
    private   String telefono;
    @NotNull(message = "es obligatorio")
    private   String anexoArea;
    @NotNull(message = "es obligatorio")
    private   String personaContacto;
    @NotNull(message = "es obligatorio")
    private   Integer estadoArea;
    @JsonIgnore
    private   String usuarioQueCreo;
    @JsonIgnore
    private   String usuarioQueModifico;
    @JsonIgnore
    private   String hostNameAuditoria;
    private  LocalDateTime fechaCreacion;
    @JsonIgnore
    private  LocalDateTime fechaActualizacion;
}
