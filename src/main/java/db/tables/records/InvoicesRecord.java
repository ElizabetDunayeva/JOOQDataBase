/*
 * This file is generated by jOOQ.
 */
package db.tables.records;


import db.tables.Invoices;

import java.sql.Date;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class InvoicesRecord extends UpdatableRecordImpl<InvoicesRecord> implements Record3<Long, Date, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.invoices.number</code>.
     */
    public InvoicesRecord setNumber(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.invoices.number</code>.
     */
    public Long getNumber() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.invoices.date_of</code>.
     */
    public InvoicesRecord setDateOf(Date value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.invoices.date_of</code>.
     */
    public Date getDateOf() {
        return (Date) get(1);
    }

    /**
     * Setter for <code>public.invoices.organization_id</code>.
     */
    public InvoicesRecord setOrganizationId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.invoices.organization_id</code>.
     */
    public Long getOrganizationId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Date, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Date, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Invoices.INVOICES.NUMBER;
    }

    @Override
    public Field<Date> field2() {
        return Invoices.INVOICES.DATE_OF;
    }

    @Override
    public Field<Long> field3() {
        return Invoices.INVOICES.ORGANIZATION_ID;
    }

    @Override
    public Long component1() {
        return getNumber();
    }

    @Override
    public Date component2() {
        return getDateOf();
    }

    @Override
    public Long component3() {
        return getOrganizationId();
    }

    @Override
    public Long value1() {
        return getNumber();
    }

    @Override
    public Date value2() {
        return getDateOf();
    }

    @Override
    public Long value3() {
        return getOrganizationId();
    }

    @Override
    public InvoicesRecord value1(Long value) {
        setNumber(value);
        return this;
    }

    @Override
    public InvoicesRecord value2(Date value) {
        setDateOf(value);
        return this;
    }

    @Override
    public InvoicesRecord value3(Long value) {
        setOrganizationId(value);
        return this;
    }

    @Override
    public InvoicesRecord values(Long value1, Date value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InvoicesRecord
     */
    public InvoicesRecord() {
        super(Invoices.INVOICES);
    }

    /**
     * Create a detached, initialised InvoicesRecord
     */
    public InvoicesRecord(Long number, Date dateOf, Long organizationId) {
        super(Invoices.INVOICES);

        setNumber(number);
        setDateOf(dateOf);
        setOrganizationId(organizationId);
    }
}
