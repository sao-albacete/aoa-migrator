package org.sao.aoa.migrator.beans;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;

/**
 * Class EdadSexo
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class EdadSexo {

    private Integer id98;
    private Integer claseId;
    private Integer cantidad;

    public EdadSexo(Map<String, Object> values) throws IOException, IllegalAccessException, NoSuchFieldException {

        if (values == null || values.isEmpty()) {
            return;
        }

        // Load edad-sexo fields mapping properties
        Properties fieldsMapping = new Properties();
        fieldsMapping.load(this.getClass().getResourceAsStream("/mapping/edad-sexo-fields-mapping.properties"));

        Class edadSexo = this.getClass();

        for (Object key : fieldsMapping.keySet()) {
            String fieldName = (String)key;
            String mapKey = fieldsMapping.getProperty(fieldName);

            if (values.containsKey(mapKey)) {
                Field field = edadSexo.getDeclaredField(fieldName);
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

    public Integer getClaseId() {
        return claseId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void replaceCitaId(Integer newId) {
        this.id98 = newId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EdadSexo{");
        sb.append("id98=").append(id98);
        sb.append(", claseId=").append(claseId);
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }
}
