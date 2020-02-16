package org.sao.aoa.migrator.beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Class CitaTest
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class CitaTest {

    private Map<String, Object> data;

    @Before
    public void setUp() {

        this.data = new HashMap<>();
        data.put("id_98", "1.0");
        data.put("FECHA", "1998-01-02 00:00:00.0");
        data.put("num", "30.0");
        data.put("OBSERVACIO", "Volando río arriba\r\n");
        data.put("selecc", "0.0");
        data.put("id_lugarAOA", "1141.0");
        data.put("rareza", "null");
        data.put("obs_princ_id", "80.0");
        data.put("repro", "12.0");
        data.put("fuente", "6.0");
        data.put("hab_raro", "0.0");
        data.put("cria_hab", "0.0");
        data.put("herido", "0.0");
        data.put("comport", "0.0");
        data.put("id_sps", "26.0");
        data.put("criterio_sel", "21.0");
        data.put("activo", "1.0");
        data.put("importancia", "13.0");
        data.put("estudio", "1.0");
        data.put("privaci", "1.0");
        data.put("foto", "0.0");
    }

    @Test
    public void testCitaConstructsOk() throws Exception {

        Cita cita = new Cita(this.data);

        Assert.assertEquals(cita.getId98(), Integer.valueOf(1));
        Assert.assertEquals(cita.getFecha(), Timestamp.valueOf("1998-01-02 00:00:00.0"));
        Assert.assertEquals(cita.getCantidad(), Integer.valueOf(30));
        Assert.assertEquals(cita.getObservaciones(), "Volando río arriba");
        Assert.assertEquals(cita.isSeleccionada(), false);
        Assert.assertEquals(cita.getLugarId(), Integer.valueOf(1141));
        Assert.assertEquals(cita.isRareza(), false);
        Assert.assertEquals(cita.getObservadorId(), Integer.valueOf(80));
        Assert.assertEquals(cita.getClaseReproduccionId(), Integer.valueOf(12));
        Assert.assertEquals(cita.getFuente(), Integer.valueOf(6));
        Assert.assertEquals(cita.isHabitatRaro(), false);
        Assert.assertEquals(cita.isCriaEnHabitatRaro(), false);
        Assert.assertEquals(cita.isHerido(), false);
        Assert.assertEquals(cita.isComportamientoRaro(), false);
        Assert.assertEquals(cita.getEspecieId(), Integer.valueOf(26));
        Assert.assertEquals(cita.getCriterioSeleccionId(), Integer.valueOf(21));
        Assert.assertEquals(cita.isActivo(), true);
        Assert.assertEquals(cita.getImportanciaCitaId(), Integer.valueOf(13));
        Assert.assertEquals(cita.getEstudioId(), Integer.valueOf(1));
        Assert.assertEquals(cita.getPrivacidadId(), Integer.valueOf(1));
        Assert.assertEquals(cita.isFoto(), false);
    }
}
