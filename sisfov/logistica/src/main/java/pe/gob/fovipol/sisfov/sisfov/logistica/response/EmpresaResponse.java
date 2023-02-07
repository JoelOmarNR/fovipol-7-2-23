package pe.gob.fovipol.sisfov.sisfov.logistica.response;

import pe.gob.fovipol.sisfov.sisfov.logistica.domain.entity.Empresa;


import java.util.List;

public class EmpresaResponse {

    private List<Empresa> empresa;

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
    }
}
