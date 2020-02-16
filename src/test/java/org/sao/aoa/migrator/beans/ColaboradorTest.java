package org.sao.aoa.migrator.beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Class ColaboradorTest
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class ColaboradorTest {

    private Map<String, Object> data;

    @Before
    public void setUp() {

        this.data = new HashMap<>();
        data.put("id_98", "1.0");
        data.put("id_observ", "92.0");
    }

    @Test
    public void testColaboradorConstructsOk() throws Exception {

        Colaborador colaborador = new Colaborador(this.data);

        Assert.assertEquals(colaborador.getId98(), Integer.valueOf(1));
        Assert.assertEquals(colaborador.getColaboradorId(), Integer.valueOf(92));
    }
}
