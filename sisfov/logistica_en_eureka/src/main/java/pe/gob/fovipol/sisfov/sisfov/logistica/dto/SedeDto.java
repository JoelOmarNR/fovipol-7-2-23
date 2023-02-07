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
public class SedeDto {

    private  @Getter  @Setter Long id;
    @NotBlank
    @NotEmpty(message = "es obligatorio")
    private  String descripcionSede;

    @NotNull(message = "es obligatorio")
    private   String descCortaSede;

    @NotNull(message = "es obligatorio")
    private  String direccionSede;

    @NotNull(message = "es obligatorio")
    private  String telefono;

    @NotNull(message = "es obligatorio")
    private  String personaContacto;

    @NotNull(message = "es obligatorio")
    private  Integer estadoSede;
    @JsonIgnore
    private  String usuarioQueCreo;
    @JsonIgnore
    private  String usuarioQueModifico;

    //private  EmpresaDto empresa;
    private LocalDateTime fechaCreacion;

    @JsonIgnore
    private  LocalDateTime fechaActualizacion;
}
