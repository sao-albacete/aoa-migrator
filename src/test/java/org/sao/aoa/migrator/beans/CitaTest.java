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
        data.put("id_98", "1");
        data.put("FECHA", Timestamp.valueOf("1998-02-01 00:00:00").toString());
        data.put("num", "30");
        data.put("OBSERVACIO", "Volando río arriba");
        data.put("selecc", "0");
        data.put("id_lugarAOA", "1141");
        data.put("rareza", "");
        data.put("obs_princ_id", "80");
        data.put("repro", "12");
        data.put("fuente", "6");
        data.put("hab_raro", "0");
        data.put("cria_hab", "0");
        data.put("herido", "0");
        data.put("comport", "0");
        data.put("id_sps", "26");
        data.put("criterio_sel", "21");
        data.put("activo", "1");
        data.put("importancia", "13");
        data.put("estudio", "1");
        data.put("privaci", "1");
        data.put("foto", "0");
    }

    @Test
    public void testCitaConstructsOk() throws Exception {

        Cita cita = new Cita(this.data);

        Assert.assertEquals(cita.getId98(), Integer.valueOf((String)this.data.get("id_98")));
        Assert.assertEquals(cita.getFecha(), Timestamp.valueOf((String)this.data.get("FECHA")));
        Assert.assertEquals(cita.getCantidad(), Integer.valueOf((String)this.data.get("num")));
        Assert.assertEquals(cita.getObservaciones(), this.data.get("OBSERVACIO"));
        Assert.assertEquals(cita.isSeleccionada(), Boolean.valueOf((String)this.data.get("selecc")));
        Assert.assertEquals(cita.getLugarId(), Integer.valueOf((String)this.data.get("id_lugarAOA")));
        Assert.assertEquals(cita.isRareza(), Boolean.valueOf((String)this.data.get("rareza")));
        Assert.assertEquals(cita.getObservadorId(), Integer.valueOf((String)this.data.get("obs_princ_id")));
        Assert.assertEquals(cita.getClaseReproduccionId(), Integer.valueOf((String)this.data.get("repro")));
        Assert.assertEquals(cita.getFuente(), Integer.valueOf((String)this.data.get("fuente")));
        Assert.assertEquals(cita.isHabitatRaro(), Boolean.valueOf((String)this.data.get("hab_raro")));
        Assert.assertEquals(cita.isCriaEnHabitatRaro(), Boolean.valueOf((String)this.data.get("cria_hab")));
        Assert.assertEquals(cita.isHerido(), Boolean.valueOf((String)this.data.get("herido")));
        Assert.assertEquals(cita.isComportamientoRaro(), Boolean.valueOf((String)this.data.get("comport")));
        Assert.assertEquals(cita.getEspecieId(), Integer.valueOf((String)this.data.get("id_sps")));
        Assert.assertEquals(cita.getCriterioSeleccionId(), Integer.valueOf((String)this.data.get("criterio_sel")));
        Assert.assertEquals(cita.isActivo(), Boolean.valueOf((String)this.data.get("activo")));
        Assert.assertEquals(cita.getImportanciaCitaId(), Integer.valueOf((String)this.data.get("importancia")));
        Assert.assertEquals(cita.getEstudioId(), Integer.valueOf((String)this.data.get("estudio")));
        Assert.assertEquals(cita.getPrivacidadId(), Integer.valueOf((String)this.data.get("privaci")));
        Assert.assertEquals(cita.isFoto(), Boolean.valueOf((String)this.data.get("foto")));
    }
}
