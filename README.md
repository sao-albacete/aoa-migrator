# Migrador de citas antiguas para el Anuario Ornigológico de Albacete Online
Esta es una herramienta Java para migrar citas antiguas desde un fichero Excel a la base de datos del Anuario Ornitológico de Albacete Online.

## Requisitos
* Java (version >=1.7)

## Preparación del fichero JAR ejecutable
Crear el fichero _build.properties_ en el directorio _src/main/resources_ del proyecto con los datos de conexión de base de datos. El contenido del fichero deberá ser el siguiente:
<pre>
jdbc.driver=com.mysql.jdbc.Driver
jdbc.user=user
jdbc.password=password
jdbc.url=jdbc:mysql://localhost:3306/database-name
jdbc.database.name=database-name
jdbc.database.tables.prefix=prefix
</pre>

Ejecutar los siguientes comandos para generar el fichero JAR ejecutable:
<pre>
$ mvn clean && mvn compile && mvn package
</pre>
Tras la ejecución del comando anterior se generará un fichero .jar ejecutable en el directorio _/target_

Es necesario que el fichero JAR ejecutable tenga permisos de ejecución, para ello, puedes lanzar este comando:
<pre>
$ chmod +x migrator.jar
</pre>

## Ficheros origen de datos
El proceso de migración requiere de tres ficheros en formato Excel de donde la herramienta de migración cogerá los datos, los procesará y por último insertará en la base de datos del anuario.

### Fichero de citas
Este fichero contiene la información general de las citas a insertar.

Las columnas de cabecera son las siguientes:
<pre>
id_98|FECHA|num|OBSERVACIO|selecc|id_lugarAOA|rareza|obs_princ_id|repro|fuente|hab_raro	cria_hab|herido|comport|id_sps|criterio_sel|activo|importancia|estudio|privaci|foto
</pre>

Este sería un ejemplo de contenido de una fila:
<pre>
2|1/2/1998|30|Varios bandos|0|846|80|11|6|0|0|0|0|525|21|1|13|11|1|0
</pre>

### Fichero de observadores
Este fichero contiene la información de los observadores asociados a cada cita.

Las columnas de cabecera son las siguientes:
<pre>
id_98|id_observ
</pre>

Este sería un ejemplo de contenido de una fila:
<pre>
1|92
</pre>

### Ficha de edades y sexos
Este fichero contiene la información de las edades y los sexos de los individuos observados en cada cita.

Las columnas de cabecera son las siguientes:
<pre>
aso_edad_sexo_id|id_98|clase|numero|clase_id
</pre>

Este sería un ejemplo de contenido de una fila:
<pre>
669|760|10|2|3
</pre>

## Instrucciones de uso
Una vez tienes preparados los tres ficheros Excel y el .JAR ejecutable ya sólo queda ejecutar la migración con el siguiente comando:
```
java -jar aoa-migrator.jar -citas citas.xls -colaboradores colaboradores.xls -edadsexocantidad aso_edad_sexo.xls
```


