/**
 * This class is generated by jOOQ
 */
package org.sao.aoa.migrator.model.tables;

import org.sao.aoa.migrator.model.AnuarioSchema;
import org.sao.aoa.migrator.model.tables.records.CitaHistoricoRecord;

/**
 * This class is generated by jOOQ.
 *
 * Históricos de cita recopiladas
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CitaHistorico extends org.jooq.impl.TableImpl<CitaHistoricoRecord> {

	private static final long serialVersionUID = 305350526;

	/**
	 * The singleton instance of <code>cita_historico</code>
	 */
	public static final CitaHistorico CITA_HISTORICO = new CitaHistorico();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<CitaHistoricoRecord> getRecordType() {
		return CitaHistoricoRecord.class;
	}

	/**
	 * The column <code>cita_historico.id</code>. Identificador de la cita
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Identificador de la cita");

	/**
	 * The column <code>cita_historico.fechaHistorico</code>. Fecha de alta del registro histórico
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.sql.Timestamp> FECHAHISTORICO = createField("fechaHistorico", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "Fecha de alta del registro histórico");

	/**
	 * The column <code>cita_historico.usuarioHistorico</code>. Usuario que realizó el cambio
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.String> USUARIOHISTORICO = createField("usuarioHistorico", org.jooq.impl.SQLDataType.VARCHAR.length(250).nullable(false), this, "Usuario que realizó el cambio");

	/**
	 * The column <code>cita_historico.cita_id</code>. Id de cita
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> CITA_ID = createField("cita_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Id de cita");

	/**
	 * The column <code>cita_historico.fechaAlta</code>. Fecha de alta de la cita
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.sql.Timestamp> FECHAALTA = createField("fechaAlta", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "Fecha de alta de la cita");

	/**
	 * The column <code>cita_historico.cantidad</code>. Número de individuos de la especie citada
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> CANTIDAD = createField("cantidad", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Número de individuos de la especie citada");

	/**
	 * The column <code>cita_historico.observaciones</code>. Observaciones sobre la cita
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.String> OBSERVACIONES = createField("observaciones", org.jooq.impl.SQLDataType.CLOB.length(65535), this, "Observaciones sobre la cita");

	/**
	 * The column <code>cita_historico.indSeleccionada</code>. Indica si la cita es seleccionada para el anuario (1) o no (0)
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Byte> INDSELECCIONADA = createField("indSeleccionada", org.jooq.impl.SQLDataType.TINYINT, this, "Indica si la cita es seleccionada para el anuario (1) o no (0)");

	/**
	 * The column <code>cita_historico.lugar_id</code>. Identificador del lugar donde se produjo la cita
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> LUGAR_ID = createField("lugar_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Identificador del lugar donde se produjo la cita");

	/**
	 * The column <code>cita_historico.indRarezaHomologada</code>. Indica si la cita es de una rareza homologada (1) o no (0)
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> INDRAREZAHOMOLOGADA = createField("indRarezaHomologada", org.jooq.impl.SQLDataType.INTEGER, this, "Indica si la cita es de una rareza homologada (1) o no (0)");

	/**
	 * The column <code>cita_historico.observador_principal_id</code>.
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> OBSERVADOR_PRINCIPAL_ID = createField("observador_principal_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cita_historico.clase_reproduccion_id</code>.
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> CLASE_REPRODUCCION_ID = createField("clase_reproduccion_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>cita_historico.fuente_id</code>.
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> FUENTE_ID = createField("fuente_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cita_historico.indHabitatRaro</code>. Indica si la cita fue en un habitat raro para la especie vista (1) o no (0)
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Byte> INDHABITATRARO = createField("indHabitatRaro", org.jooq.impl.SQLDataType.TINYINT, this, "Indica si la cita fue en un habitat raro para la especie vista (1) o no (0)");

	/**
	 * The column <code>cita_historico.indCriaHabitatRaro</code>. Indica si la cita es de una especie criando en un habitat raro (1) o no (0)
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Byte> INDCRIAHABITATRARO = createField("indCriaHabitatRaro", org.jooq.impl.SQLDataType.TINYINT, this, "Indica si la cita es de una especie criando en un habitat raro (1) o no (0)");

	/**
	 * The column <code>cita_historico.indHerido</code>. Indica si el individuo/s citado/s estaba/n herido/s (1) o no (0)
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Byte> INDHERIDO = createField("indHerido", org.jooq.impl.SQLDataType.TINYINT, this, "Indica si el individuo/s citado/s estaba/n herido/s (1) o no (0)");

	/**
	 * The column <code>cita_historico.indComportamiento</code>. Descripción del comportamiento de la especie
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Byte> INDCOMPORTAMIENTO = createField("indComportamiento", org.jooq.impl.SQLDataType.TINYINT, this, "Descripción del comportamiento de la especie");

	/**
	 * The column <code>cita_historico.especie_id</code>. Identificador de la especie
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> ESPECIE_ID = createField("especie_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Identificador de la especie");

	/**
	 * The column <code>cita_historico.criterio_seleccion_cita_id</code>. Criterio utilizado en la selección de la cita
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> CRITERIO_SELECCION_CITA_ID = createField("criterio_seleccion_cita_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "Criterio utilizado en la selección de la cita");

	/**
	 * The column <code>cita_historico.importancia_cita_id</code>.
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> IMPORTANCIA_CITA_ID = createField("importancia_cita_id", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this, "");

	/**
	 * The column <code>cita_historico.estudio_id</code>.
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Integer> ESTUDIO_ID = createField("estudio_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>cita_historico.indPrivacidad</code>. Indica si los datos sensibles de la cita de la especie deben ser privados (0) o públicos (1)
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Byte> INDPRIVACIDAD = createField("indPrivacidad", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this, "Indica si los datos sensibles de la cita de la especie deben ser privados (0) o públicos (1)");

	/**
	 * The column <code>cita_historico.indFoto</code>.
	 */
	public final org.jooq.TableField<CitaHistoricoRecord, java.lang.Byte> INDFOTO = createField("indFoto", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>cita_historico</code> table reference
	 */
	public CitaHistorico() {
		this(AnuarioSchema.getTablePrefix() + "cita_historico", null);
	}

	/**
	 * Create an aliased <code>cita_historico</code> table reference
	 */
	public CitaHistorico(java.lang.String alias) {
		this(alias, CitaHistorico.CITA_HISTORICO);
	}

	private CitaHistorico(java.lang.String alias, org.jooq.Table<CitaHistoricoRecord> aliased) {
		this(alias, aliased, null);
	}

	private CitaHistorico(java.lang.String alias, org.jooq.Table<CitaHistoricoRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, AnuarioSchema.ANUARIO_SCHEMA, aliased, parameters, "Históricos de cita recopiladas");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CitaHistorico as(java.lang.String alias) {
		return new CitaHistorico(alias, this);
	}

	/**
	 * Rename this table
	 */
	public CitaHistorico rename(java.lang.String name) {
		return new CitaHistorico(name, null);
	}
}