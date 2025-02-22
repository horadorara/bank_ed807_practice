//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 05:36:11 PM SAMT 
//


package ru.cbr.ed.v2;

import java.io.Serializable;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Информация, связанная с процессом миграции Участника
 * 
 * <p>Java class for Migrated complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Migrated"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="MigratedInd" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}IndicatorType" /&gt;
 *       &lt;attribute name="LastRABISDate" type="{urn:cbr-ru:ed:leaftypes:v2.0}DateType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Migrated")
public class Migrated
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlAttribute(name = "MigratedInd", required = true)
    protected boolean migratedInd;
    @XmlAttribute(name = "LastRABISDate")
    protected XMLGregorianCalendar lastRABISDate;

    /**
     * Gets the value of the migratedInd property.
     * 
     */
    public boolean isMigratedInd() {
        return migratedInd;
    }

    /**
     * Sets the value of the migratedInd property.
     * 
     */
    public void setMigratedInd(boolean value) {
        this.migratedInd = value;
    }

    /**
     * Gets the value of the lastRABISDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastRABISDate() {
        return lastRABISDate;
    }

    /**
     * Sets the value of the lastRABISDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastRABISDate(XMLGregorianCalendar value) {
        this.lastRABISDate = value;
    }

}
