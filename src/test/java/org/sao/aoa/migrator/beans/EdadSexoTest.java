package org.sao.aoa.migrator.beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Class EdadSexoTest
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class EdadSexoTest {

    private Map<String, Object> data;

    @Before
    public void setUp() {

        this.data = new HashMap<>();
        data.put("id_98", "1.0");
        data.put("clase_id", "3.0");
        data.put("numero", "12.0");
    }

    @Test
    public void testColaboradorConstructsOk() throws Exception {

        EdadSexo edadSexo = new EdadSexo(this.data);

        Assert.assertEquals(edadSexo.getId98(), Integer.valueOf(1));
        Assert.assertEquals(edadSexo.getClaseId(), Integer.valueOf(3));
        Assert.assertEquals(edadSexo.getCantidad(), Integer.valueOf(12));
    }
}
