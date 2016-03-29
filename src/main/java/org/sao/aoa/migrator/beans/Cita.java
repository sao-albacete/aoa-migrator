package org.sao.aoa.migrator.beans;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Class Cita
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class Cita {

    private Integer id98;
    private Date fecha;
    private Integer cantidad;
    private String observaciones;
    private Boolean seleccionada;
    private Integer lugarId;
    private Boolean rareza;
    private Integer observadorId;
    private Integer claseReproduccionId;
    private Integer fuente;
    private Boolean habitatRaro;
    private Boolean criaEnHabitatRaro;
    private Boolean herido;
    private Boolean comportamientoRaro;
    private Integer especieId;
    private Integer criterioSeleccionId;
    private Boolean activo;
    private Integer importanciaCitaId;
    private Integer estudioId;
    private Integer privacidadId;
    private Boolean foto;

    public Cita(Map<String, Object> values) throws Exception {

        if (values == null || values.isEmpty()) {
            return;
        }

        // Load cita fields mapping properties
//        Properties fieldsMapping = new Properties();
//        FileInputStream fis = new FileInputStream("/mapping/cita-fields-mapping.properties");
//        fieldsMapping.load(fis);

        Set<String> keys = values.keySet();
        for (String key : keys) {
            switch (key) {
                case "id_98":
                    id98 = (Integer)values.get(key);
                    break;
                case "FECHA":
                    // TODO parse date
                    fecha = (Date)values.get(key);
                    break;
                case "num":
                    cantidad = (Integer) values.get(key);
                    break;
                case "OBSERVACIO":
                    observaciones = (String) values.get(key);
                    break;
                case "selecc":
                    seleccionada = (Boolean) values.get(key);
                    break;
                case "id_lugarAOA":
                    lugarId = (Integer) values.get(key);
                    break;
                case "rareza":
                    rareza = (Boolean) values.get(key);
                    break;
                case "obs_princ_id":
                    observadorId = (Integer) values.get(key);
                    break;
                case "repro":
                    claseReproduccionId = (Integer) values.get(key);
                    break;
                case "fuente":
                    fuente = (Integer) values.get(key);
                    break;
                case "hab_raro":
                    habitatRaro = (Boolean) values.get(key);
                    break;
                case "cria_hab":
                    criaEnHabitatRaro = (Boolean) values.get(key);
                    break;
                case "herido":
                    herido = (Boolean) values.get(key);
                    break;
                case "comport":
                    comportamientoRaro = (Boolean) values.get(key);
                    break;
                case "id_sps":
                    especieId = (Integer) values.get(key);
                    break;
                case "criterio_sel":
                    criterioSeleccionId = (Integer) values.get(key);
                    break;
                case "activo":
                    activo = (Boolean) values.get(key);
                    break;
                case "importancia":
                    importanciaCitaId = (Integer) values.get(key);
                    break;
                case "estudio":
                    estudioId = (Integer) values.get(key);
                    break;
                case "privaci":
                    privacidadId = (Integer) values.get(key);
                    break;
                case "foto":
                    foto = (Boolean) values.get(key);
                    break;
                default:
                    throw new Exception("Fiels mapping not found");
            }
        }
    }

    public Integer getId98() {
        return id98;
    }

    public Date getFecha() {
        return fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Boolean isSeleccionada() {
        return seleccionada;
    }

    public Integer getLugarId() {
        return lugarId;
    }

    public Boolean isRareza() {
        return rareza;
    }

    public Integer getObservadorId() {
        return observadorId;
    }

    public Integer getClaseReproduccionId() {
        return claseReproduccionId;
    }

    public Integer getFuente() {
        return fuente;
    }

    public Boolean isHabitatRaro() {
        return habitatRaro;
    }

    public Boolean isCriaEnHabitatRaro() {
        return criaEnHabitatRaro;
    }

    public Boolean isHerido() {
        return herido;
    }

    public Boolean isComportamientoRaro() {
        return comportamientoRaro;
    }

    public Integer getEspecieId() {
        return especieId;
    }

    public Integer getCriterioSeleccionId() {
        return criterioSeleccionId;
    }

    public Boolean isActivo() {
        return activo;
    }

    public Integer getImportanciaCitaId() {
        return importanciaCitaId;
    }

    public Integer getEstudioId() {
        return estudioId;
    }

    public Integer getPrivacidadId() {
        return privacidadId;
    }

    public Boolean isFoto() {
        return foto;
    }
}
