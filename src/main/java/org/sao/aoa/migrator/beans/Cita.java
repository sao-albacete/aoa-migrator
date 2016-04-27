package org.sao.aoa.migrator.beans;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;
import java.util.Properties;

import static org.sao.aoa.migrator.utils.DateUtils.DATE_FORMAT;

/**
 * Class Cita
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class Cita {

    private Integer id98;
    private Timestamp fecha;
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

    public Cita(Map<String, Object> values) throws IOException, IllegalAccessException, NoSuchFieldException {

        if (values == null || values.isEmpty()) {
            return;
        }

        // Load cita fields mapping properties
        Properties fieldsMapping = new Properties();

        fieldsMapping.load(this.getClass().getResourceAsStream("/mapping/cita-fields-mapping.properties"));

        Class cita = this.getClass();

        for (Object key : fieldsMapping.keySet()) {
            String fieldName = (String) key;
            String mapKey = fieldsMapping.getProperty(fieldName);

            if (values.containsKey(mapKey)) {
                Field field = cita.getDeclaredField(fieldName);
                String fieldValue = (String) values.get(mapKey);

                if (field.getType() == Integer.class) {
                    field.set(this, Double.valueOf(fieldValue).intValue());
                } else if (field.getType() == String.class) {
                    field.set(this, fieldValue);
                } else if (field.getType() == Timestamp.class) {
                    field.set(this, Timestamp.valueOf(fieldValue));
                } else if (field.getType() == Boolean.class) {
                    field.set(this, Boolean.valueOf(fieldValue));
                }
            }
        }
    }

    public Integer getId98() {
        return id98;
    }

    public Timestamp getFecha() {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cita{");
        sb.append("id98=").append(id98);
        sb.append(", fecha=").append(fecha);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", observaciones='").append(observaciones).append('\'');
        sb.append(", seleccionada=").append(seleccionada);
        sb.append(", lugarId=").append(lugarId);
        sb.append(", rareza=").append(rareza);
        sb.append(", observadorId=").append(observadorId);
        sb.append(", claseReproduccionId=").append(claseReproduccionId);
        sb.append(", fuente=").append(fuente);
        sb.append(", habitatRaro=").append(habitatRaro);
        sb.append(", criaEnHabitatRaro=").append(criaEnHabitatRaro);
        sb.append(", herido=").append(herido);
        sb.append(", comportamientoRaro=").append(comportamientoRaro);
        sb.append(", especieId=").append(especieId);
        sb.append(", criterioSeleccionId=").append(criterioSeleccionId);
        sb.append(", activo=").append(activo);
        sb.append(", importanciaCitaId=").append(importanciaCitaId);
        sb.append(", estudioId=").append(estudioId);
        sb.append(", privacidadId=").append(privacidadId);
        sb.append(", foto=").append(foto);
        sb.append('}');
        return sb.toString();
    }
}
