/*
 * This file is generated by jOOQ.
 */
package db.tables;


import db.Keys;
import db.Public;
import db.tables.records.PositionsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.14.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Positions extends TableImpl<PositionsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.positions</code>
     */
    public static final Positions POSITIONS = new Positions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PositionsRecord> getRecordType() {
        return PositionsRecord.class;
    }

    /**
     * The column <code>public.positions.price</code>.
     */
    public final TableField<PositionsRecord, Long> PRICE = createField(DSL.name("price"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.positions.nomenclature_id</code>.
     */
    public final TableField<PositionsRecord, Long> NOMENCLATURE_ID = createField(DSL.name("nomenclature_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.positions.amount</code>.
     */
    public final TableField<PositionsRecord, Long> AMOUNT = createField(DSL.name("amount"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.positions.number_invoice</code>.
     */
    public final TableField<PositionsRecord, Long> NUMBER_INVOICE = createField(DSL.name("number_invoice"), SQLDataType.BIGINT.nullable(false), this, "");

    private Positions(Name alias, Table<PositionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Positions(Name alias, Table<PositionsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.positions</code> table reference
     */
    public Positions(String alias) {
        this(DSL.name(alias), POSITIONS);
    }

    /**
     * Create an aliased <code>public.positions</code> table reference
     */
    public Positions(Name alias) {
        this(alias, POSITIONS);
    }

    /**
     * Create a <code>public.positions</code> table reference
     */
    public Positions() {
        this(DSL.name("positions"), null);
    }

    public <O extends Record> Positions(Table<O> child, ForeignKey<O, PositionsRecord> key) {
        super(child, key, POSITIONS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<PositionsRecord> getPrimaryKey() {
        return Keys.POSITIONS_PK;
    }

    @Override
    public List<UniqueKey<PositionsRecord>> getKeys() {
        return Arrays.<UniqueKey<PositionsRecord>>asList(Keys.POSITIONS_PK);
    }

    @Override
    public List<ForeignKey<PositionsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PositionsRecord, ?>>asList(Keys.POSITIONS__NOMENCLATURE_FK, Keys.POSITIONS__INVOICE_FK);
    }

    public Nomenclatures nomenclatures() {
        return new Nomenclatures(this, Keys.POSITIONS__NOMENCLATURE_FK);
    }

    public Invoices invoices() {
        return new Invoices(this, Keys.POSITIONS__INVOICE_FK);
    }

    @Override
    public Positions as(String alias) {
        return new Positions(DSL.name(alias), this);
    }

    @Override
    public Positions as(Name alias) {
        return new Positions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Positions rename(String name) {
        return new Positions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Positions rename(Name name) {
        return new Positions(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, Long, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
