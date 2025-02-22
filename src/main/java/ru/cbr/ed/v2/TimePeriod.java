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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Request Time Period
 * 
 * <p>Java class for TimePeriod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimePeriod"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="TimeFromTo" type="{urn:cbr-ru:ed:v2.0}TimeFromTo"/&gt;
 *         &lt;element name="InquiryDate" type="{urn:cbr-ru:ed:leaftypes:v2.0}DateType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimePeriod", propOrder = {
    "inquiryDate",
    "timeFromTo"
})
public class TimePeriod
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "InquiryDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar inquiryDate;
    @XmlElement(name = "TimeFromTo")
    protected TimeFromTo timeFromTo;

    /**
     * Gets the value of the inquiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInquiryDate() {
        return inquiryDate;
    }

    /**
     * Sets the value of the inquiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInquiryDate(XMLGregorianCalendar value) {
        this.inquiryDate = value;
    }

    /**
     * Gets the value of the timeFromTo property.
     * 
     * @return
     *     possible object is
     *     {@link TimeFromTo }
     *     
     */
    public TimeFromTo getTimeFromTo() {
        return timeFromTo;
    }

    /**
     * Sets the value of the timeFromTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeFromTo }
     *     
     */
    public void setTimeFromTo(TimeFromTo value) {
        this.timeFromTo = value;
    }

}
