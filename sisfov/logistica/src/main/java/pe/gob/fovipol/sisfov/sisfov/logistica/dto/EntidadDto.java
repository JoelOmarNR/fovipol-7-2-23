package pe.gob.fovipol.sisfov.sisfov.logistica.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadDto {
    private String id;
    private String codigoEntidad;
    private String nombreEntidad;
    private String descripcionEntidad;
    private Integer estadoEntidad;

    private  String usuarioCreador;
    @JsonIgnore

    private String usuarioModificador;
    @JsonIgnore

    private LocalDateTime fechaCreacion;
    @JsonIgnore

    private LocalDateTime fechaActualizacion;

    @JsonIgnore

    private  String hostNameAuditoria;
}
