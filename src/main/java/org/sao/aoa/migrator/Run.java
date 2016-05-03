package org.sao.aoa.migrator;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.commons.cli.*;
import org.sao.aoa.migrator.services.MigrationService;
import org.sao.aoa.migrator.services.MigrationServiceInterface;
import org.sao.aoa.migrator.services.modules.MigrationModule;

import java.util.logging.LogManager;

/**
 * Class Run
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class Run {

    static { LogManager.getLogManager().reset(); }

    public static void main(String[] args) {

        Options options = new Options();

        try {

            // Define CLI options
            options.addOption("citas", true, "Fichero que contiene las citas");
            options.addOption("edadsexocantidad", true, "Fichero que contiene la edad, el sexo y la cantidad de individuos por cita");
            options.addOption("colaboradores", true, "Fichero que contiene los colaboradores de las citas");
            options.addOption("h", "help", false, "Imprime el mensaje de ayuda");

            CommandLineParser cliParser = new BasicParser();
            CommandLine cli = cliParser.parse(options, args);

            // If user has typed "h" or "help" show options
            if (cli.hasOption("h")){
                new HelpFormatter().printHelp(Run.class.getCanonicalName(), options );
                return;
            }

            // Get filenames
            String citasFilename =  cli.getOptionValue("citas");
            if (citasFilename == null){
                throw new ParseException("El nombre del fichero de citas es obligatorio");
            }
            String edadSexoCantidadFilename =  cli.getOptionValue("edadsexocantidad");
            if (edadSexoCantidadFilename == null){
                throw new ParseException("El nombre del fichero de edad, sexo y cantidad de cada cita es obligatorio");
            }
            String colaboradoresFilename =  cli.getOptionValue("colaboradores");
            if (colaboradoresFilename == null){
                throw new ParseException("El nombre del fichero de colaboradores de cada cita es obligatorio");
            }

            // Run migration
            Injector injector = Guice.createInjector(new MigrationModule());
            MigrationServiceInterface migrator = injector.getInstance(MigrationService.class);

            System.out.println("STARTING process....");
            migrator.run(citasFilename, edadSexoCantidadFilename, colaboradoresFilename);
            System.out.println("Process FINISHED successfully.");

        } catch (ParseException e) {
            System.err.println(e.getMessage());
            new HelpFormatter().printHelp(Run.class.getCanonicalName(), options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
