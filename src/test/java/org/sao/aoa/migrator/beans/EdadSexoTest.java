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
        data.put("id_98", "1");
        data.put("clase_id", "3");
        data.put("numero", "1");
    }

    @Test
    public void testColaboradorConstructsOk() throws Exception {

        EdadSexo edadSexo = new EdadSexo(this.data);

        Assert.assertEquals(edadSexo.getId98(), Integer.valueOf((String)this.data.get("id_98")));
        Assert.assertEquals(edadSexo.getClaseId(), Integer.valueOf((String)this.data.get("clase_id")));
        Assert.assertEquals(edadSexo.getCantidad(), Integer.valueOf((String)this.data.get("numero")));
    }
}
