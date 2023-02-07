package pe.gob.fovipol.sisfov.sisfov.logistica.controller.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pe.gob.fovipol.sisfov.sisfov.logistica.entity.Empresa;
import pe.gob.fovipol.sisfov.sisfov.logistica.entity.Sede;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SedeDTO {
    @Column(name="DESC_SEDE_VC")
    private  @Getter  @Setter String descripcionSede;

    @Column(name="DIRE_SEDE_VC")
    private  @Getter  @Setter String direccionSede;

    @Column(name="NUME_TELE_NU")
    private  @Getter  @Setter String telefono;

    @Column(name="PERS_CONT_VC")
    private  @Getter  @Setter String personaContacto;



}
