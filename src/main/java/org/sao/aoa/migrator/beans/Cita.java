package org.sao.aoa.migrator.beans;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Properties;

/**
 * Class Cita
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class Cita {

    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer id98;
    private LocalDate fecha;
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
        Properties fieldsMapping = new Properties();
        fieldsMapping.load(this.getClass().getResourceAsStream("/mapping/cita-fields-mapping.properties"));

        Class cita = this.getClass();

        for (Object key : fieldsMapping.keySet()) {
            String fieldName = (String)key;
            String mapKey = fieldsMapping.getProperty(fieldName);

            if (values.containsKey(mapKey)) {
                Field field = cita.getDeclaredField(fieldName);
                String fieldValue = (String)values.get(mapKey);

                if (field.getType() == Integer.class) {
                    field.set(this, Integer.valueOf(fieldValue));
                } else if (field.getType() == String.class) {
                    field.set(this, fieldValue);
                } else if (field.getType() == LocalDate.class) {
                    field.set(this, LocalDate.parse(fieldValue, this.dateFormat));
                } else if (field.getType() == Boolean.class) {
                    field.set(this, Boolean.valueOf(fieldValue));
                }
            }
        }
    }

    public Integer getId98() {
        return id98;
    }

    public LocalDate getFecha() {
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
