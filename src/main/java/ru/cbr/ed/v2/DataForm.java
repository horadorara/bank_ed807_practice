//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.02 at 05:36:11 PM SAMT 
//


package ru.cbr.ed.v2;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Реквизиты заполнения формы
 * 
 * <p>Java class for DataForm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataForm"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ReportID" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}ReportIDType" /&gt;
 *       &lt;attribute name="DataCode" use="required" type="{urn:cbr-ru:ed:leaftypes:v2.0}TwoDigitCodeType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataForm")
public class DataForm
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlAttribute(name = "ReportID", required = true)
    protected String reportID;
    @XmlAttribute(name = "DataCode", required = true)
    protected String dataCode;

    /**
     * Gets the value of the reportID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportID() {
        return reportID;
    }

    /**
     * Sets the value of the reportID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportID(String value) {
        this.reportID = value;
    }

    /**
     * Gets the value of the dataCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCode() {
        return dataCode;
    }

    /**
     * Sets the value of the dataCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCode(String value) {
        this.dataCode = value;
    }

}
