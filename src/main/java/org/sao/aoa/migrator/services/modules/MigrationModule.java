package org.sao.aoa.migrator.services.modules;

import com.google.inject.AbstractModule;
import org.sao.aoa.migrator.readers.ExcelReader;
import org.sao.aoa.migrator.readers.ExcelReaderInterface;

/**
 * Class MigrationModule
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class MigrationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ExcelReaderInterface.class).to(ExcelReader.class);
    }
}
