package pe.gob.fovipol.sisfov.sisfov.logistica.response;

import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Sede;

import java.util.List;

public class SedeResponse {

    private List<Sede> sede;

    public List<Sede> getSede() {
        return sede;
    }

    public void setSede(List<Sede> sede) {
        this.sede = sede;
    }
}
