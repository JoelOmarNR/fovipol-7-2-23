package pe.gob.fovipol.sisfov.sisfov.logistica.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntidadDetalleDto {
    private  Long id;
    private String codigoEntidad;
    private  Integer secuenciaEntidad;
    private  String primerValorCadenaCorta;
    private  String segundoValorCadenaCorta;
    private  String tercerValorCadenaCorta;
    private  Integer primerValorNumerico;
    private  Integer segundoValorNumerico;

    private  Integer tercerValorNumerico;

    private BigDecimal primerValorDecimal;

    private  BigDecimal segundoValorDecimal;

    private  BigDecimal tercerValorDecimal;

    private Date primerValorFecha;

    private  Date segundoValorFecha;

    private  Date tercerValorFecha;

    private String descripcionEntidadDetalle;

    private  Integer estadoEntidadDetalle;
    @JsonIgnore
    private  String usuarioCreador;
    @JsonIgnore
    private  String usuarioModificador;
    @JsonIgnore
    private LocalDateTime fechaCreacion;
    @JsonIgnore
    private LocalDateTime fechaActualizacion;
    @JsonIgnore
    private  String hostNameAuditoria;

}
