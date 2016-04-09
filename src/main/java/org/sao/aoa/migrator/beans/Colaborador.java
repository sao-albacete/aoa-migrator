package org.sao.aoa.migrator.beans;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Map;
import java.util.Properties;

/**
 * Class Colaborador
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class Colaborador {

    private Integer id98;
    private Integer colaboradorId;

    public Colaborador(Map<String, Object> values) throws Exception {

        if (values == null || values.isEmpty()) {
            return;
        }

        // Load colaborador fields mapping properties
        Properties fieldsMapping = new Properties();
        fieldsMapping.load(this.getClass().getResourceAsStream("/mapping/colaborador-fields-mapping.properties"));

        Class colaborador = this.getClass();

        for (Object key : fieldsMapping.keySet()) {
            String fieldName = (String)key;
            String mapKey = fieldsMapping.getProperty(fieldName);

            if (values.containsKey(mapKey)) {
                Field field = colaborador.getDeclaredField(fieldName);
                String fieldValue = (String)values.get(mapKey);

                if (field.getType() == Integer.class) {
                    field.set(this, Integer.valueOf(fieldValue));
                }
            }
        }
    }

    public Integer getId98() {
        return id98;
    }

    public Integer getColaboradorId() {
        return colaboradorId;
    }
}
