/*
 * This file is generated by jOOQ.
 */
package db.tables.records;


import db.tables.Nomenclatures;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class NomenclaturesRecord extends UpdatableRecordImpl<NomenclaturesRecord> implements Record2<String, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.nomenclatures.name</code>.
     */
    public NomenclaturesRecord setName(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.nomenclatures.name</code>.
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.nomenclatures.cod_id</code>.
     */
    public NomenclaturesRecord setCodId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.nomenclatures.cod_id</code>.
     */
    public Long getCodId() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Nomenclatures.NOMENCLATURES.NAME;
    }

    @Override
    public Field<Long> field2() {
        return Nomenclatures.NOMENCLATURES.COD_ID;
    }

    @Override
    public String component1() {
        return getName();
    }

    @Override
    public Long component2() {
        return getCodId();
    }

    @Override
    public String value1() {
        return getName();
    }

    @Override
    public Long value2() {
        return getCodId();
    }

    @Override
    public NomenclaturesRecord value1(String value) {
        setName(value);
        return this;
    }

    @Override
    public NomenclaturesRecord value2(Long value) {
        setCodId(value);
        return this;
    }

    @Override
    public NomenclaturesRecord values(String value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached NomenclaturesRecord
     */
    public NomenclaturesRecord() {
        super(Nomenclatures.NOMENCLATURES);
    }

    /**
     * Create a detached, initialised NomenclaturesRecord
     */
    public NomenclaturesRecord(String name, Long codId) {
        super(Nomenclatures.NOMENCLATURES);

        setName(name);
        setCodId(codId);
    }
}